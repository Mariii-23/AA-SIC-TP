<template>
  <ConfirmationModal
    :title="$t('rmv-category')"
    :text="$t('rmv-category-text') + ' ' + category + '?'"
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
  <SimpleBodyLayout>
    <TwoColumnsPanel>
      <template v-slot:first>
        <TitleCardLinksButton
          :title="$t('store')"
          :items="items"
          :button-text="$t('logout')"
          :button-handler="openLogoutModal"
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
          :remove-category-handler="removeCategoryHandler"
        />
        <!-- <ItemsTable :items="categories" :deleteItem="openRemoveModal" /> -->
      </template> </TwoColumnsPanel
  ></SimpleBodyLayout>
</template>

<script lang="ts">
import { LinkProps } from "@/appTypes/Link";
import TwoColumnsPanel from "@/layouts/Body/TwoColumnsPanel.vue";
import TitleCardLinksButton from "@/components/organisms/TitleCardLinksButton.vue";
import SimpleBodyLayout from "@/layouts/Body/SimpleBodyLayout.vue";
import { Category } from "@/appTypes/Product";
import ItemsTable from "@/components/organisms/Table/ItemsTable.vue";
import TitleWithButton from "@/components/molecules/TitleWithButton.vue";
import ConfirmationModal from "@/components/organisms/Modal/ConfirmationModal.vue";
import { useCategoriesStore } from "@/store/categoriesStore";
import CategoryCards from "@/components/organisms/Cards/CategoryCards.vue";

const categoryStore = useCategoriesStore();

export default {
  name: "StoreCategories",
  data: () => ({
    items: [] as LinkProps[],
    isRemoveModalOpen: false,
    isLogoutModalOpen: false,
    categories: [] as Category[],
    category: "",
  }),
  mounted: async function () {
    this.items = [
      { href: "/admin/company", icon: "brightness-1", text: "company" },
      { href: "/admin/categories", icon: "bullseye", text: "categories" },
      { href: "/admin/materials", icon: "brightness-1", text: "materials" },
    ];

    if (categoryStore.categories.length <= 0) {
      await categoryStore.getAllCategories();
    }

    this.categories = categoryStore.categories;

    this.$watch(
      () => categoryStore.categories,
      (newValues) => {
        this.categories = newValues;
      }
    );
  },
  //TODO: ir buscar os direitos
  methods: {
    removeCategoryHandler(categoryId: string) {
      console.log(categoryId);
    },
    addCategoryHandler() {
      console.log("add category");
    },
    editCategoryHandler(categoryId: string) {
      console.log(categoryId);
    },
    closeRemoveModal() {
      this.isRemoveModalOpen = false;
    },
    openRemoveModal(categoryname: string) {
      this.category = categoryname;
      this.isRemoveModalOpen = true;
    },
    openLogoutModal() {
      this.isLogoutModalOpen = true;
    },
    closeLogoutModal() {
      this.isLogoutModalOpen = false;
    },
    logoutHandler() {
      console.log("logout");
    },
  },
  components: {
    TwoColumnsPanel,
    TitleCardLinksButton,
    SimpleBodyLayout,
    ItemsTable,
    TitleWithButton,
    ConfirmationModal,
    CategoryCards,
  },
};
</script>
