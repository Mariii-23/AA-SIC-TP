<template>
  <div v-if="categories.length == 0">
      <v-progress-linear
      indeterminate
    />
    </div>
  <SimpleBodyLayout>
    <ConfirmationModal
    :title="$t('rmv-category')"
    :text="$t('rmv-category-text') + ' ' + categoryName + '?'"
    :confirmHandler="removeCategoryHandler"
    :closeModal="closeRemoveModal"
    :isModalOpen="isRemoveModalOpen"
  />

  <ConfirmationModal
    :title="$t('logout')"
    :text="$t('logout-text')"
    :confirmHandler="logoutHandler"
    :closeModal="closeLogoutModal"
    :isModalOpen="isLogoutModalOpen"
  />
    <TwoColumnsPanel>
      <template v-slot:first>
        <TitleCardLinksButton
          :title="$t('store')"
          :items="items"
        />
      </template>
      <template v-slot:second>
        <TitleWithButton
          :title="$t('categories')"
          :buttonText="$t('add-category')"
          :buttonHandler="addCategoryHandler"
        />
        <CategoryCards
          :categories="categories"
          :edit-category-handler="editCategoryHandler"
          :remove-category-handler="openRemoveModal"
        />
        <Pagination :length="length" :total-visible="5" :handle-page-change="handlePageChange" />
      </template> </TwoColumnsPanel
  ></SimpleBodyLayout>
</template>

<script lang="ts">
import { LinkProps } from "@/appTypes/Link";
import TwoColumnsPanel from "@/layouts/Body/TwoColumnsPanel.vue";
import TitleCardLinksButton from "@/components/organisms/TitleCardLinksButton.vue";
import SimpleBodyLayout from "@/layouts/Body/SimpleBodyLayout.vue";
import { Category } from "@/appTypes/Product";
import TitleWithButton from "@/components/molecules/TitleWithButton.vue";
import ConfirmationModal from "@/components/organisms/Modal/ConfirmationModal.vue";
import { useCategoriesStore } from "@/store/categoriesStore";
import CategoryCards from "@/components/organisms/Cards/CategoryCards.vue";
import { useNotificationStore } from "@/store/notificationStore";
import { useUserStore } from "@/store/userStore";
import Pagination from "@/components/molecules/Pagination.vue";

const categoryStore = useCategoriesStore();
const notifications = useNotificationStore();
const userStore = useUserStore();

export default {
  name: "StoreCategories",
  data: () => ({
    items: [] as LinkProps[],
    isRemoveModalOpen: false,
    isLogoutModalOpen: false,
    categories: [] as Category[],
    categoryId: "",
    categoryName: "",
    page: 1,
    length: 0,
    categoriesOnPage: 16,
  }),
  mounted: async function () {
    this.items = [
      { href: "/admin/company", icon: "brightness-1", text: "company" },
      { href: "/admin/categories", icon: "bullseye", text: "categories" },
      { href: "/admin/materials", icon: "brightness-1", text: "materials" },
    ];

    this.length = Math.ceil((await categoryStore.getNumberOfCategories())/this.categoriesOnPage);

    if (categoryStore.categories.length <= 0) {
      await categoryStore.getAllCategories(0, this.categoriesOnPage);
    }

    this.categories = categoryStore.categories;

    this.$watch(
      () => categoryStore.categories,
      (newValues) => {
        this.categories = newValues;
      }
    );
  },
  methods: {
    async removeCategoryHandler() {
      const r = await categoryStore.removeCategory(this.categoryId);
      if (r) {
        notifications.openSuccessAlert(this.$t("rmv-category-success"));
      } else {
        notifications.openErrorAlert(this.$t("rmv-category-error"));
      }
      this.closeRemoveModal();
    },
    addCategoryHandler() {
      const route = `${this.$router.currentRoute.value.fullPath}/add`;
      this.$router.push(route);
    },
    editCategoryHandler(categoryId: string) {
      const route = `${this.$router.currentRoute.value.fullPath}/edit/${categoryId}`;
      this.$router.push(route);
    },
    closeRemoveModal() {
      this.isRemoveModalOpen = false;
    },
    openRemoveModal(categoryid: string, categoryname: string) {
      this.categoryId = categoryid;
      this.categoryName = categoryname;
      this.isRemoveModalOpen = true;
    },
    openLogoutModal() {
      this.isLogoutModalOpen = true;
    },
    closeLogoutModal() {
      this.isLogoutModalOpen = false;
    },
    logoutHandler() {
      userStore.logout();
      this.$router.push("/");
    },
    async handlePageChange(page: number){
      this.page = page;
      await categoryStore.getAllCategories((this.page-1)*this.categoriesOnPage, this.categoriesOnPage);
    }
  },
  components: {
    TwoColumnsPanel,
    TitleCardLinksButton,
    SimpleBodyLayout,
    TitleWithButton,
    ConfirmationModal,
    CategoryCards,
    Pagination
  },
};
</script>