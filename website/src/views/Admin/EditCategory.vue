<template>
  <SimpleBodyLayout>
    <TwoColumnsPanel>
      <template v-slot:first>
        <TitleCardLinksButton :title="$t('store')" :items="items" />
      </template>
      <template v-slot:second>
        <TitleGoBack :title="$t('update-category')" :items="items" />

        <NextTabs :tabs="tabs" v-bind:selected-tab="tab">
          <template v-slot:tab1>
            <AddImageNameForm
              class="bg-primary"
              :text-button="$t('next-step')"
              :register="registerNameAndPhoto"
              :name-input="category.name"
              :required-file="false"
            />
          </template>

          <template v-slot:tab2>
            <div class="titleWithGoBack">
              <v-btn icon @click="goBack" class="bg-secondary elevation-0">
                <v-icon>mdi-keyboard-backspace</v-icon>
              </v-btn>
              <HeadingText>{{ $t("previos-step") }}</HeadingText>
            </div>
            <UpdateSubcategoriesForm
              :remove-subcategory="removeSubcategory"
              :add-subcategories="registerSubcategories"
              :text-button="$t('edit-category')"
              v-bind:sub-categories="subCategories"
            />
          </template>
        </NextTabs>
      </template> </TwoColumnsPanel
  ></SimpleBodyLayout>
</template>

<script lang="ts">
import UpdateSubcategoriesForm from "@/components/organisms/Forms/UpdateSubcategoriesForm.vue";
import NextTabs from "@/components/organisms/NextTabs.vue";
import AddImageNameForm from "@/components/organisms/Forms/AddImageNameForm.vue";
import { LinkProps } from "@/appTypes/Link";
import TwoColumnsPanel from "@/layouts/Body/TwoColumnsPanel.vue";
import TitleCardLinksButton from "@/components/organisms/TitleCardLinksButton.vue";
import SimpleBodyLayout from "@/layouts/Body/SimpleBodyLayout.vue";
import TitleGoBack from "@/components/molecules/TitleGoBack.vue";
import { useNotificationStore } from "@/store/notificationStore";
import HeadingText from "@/components/atoms/Typography/HeadingText.vue";
import { useCategoriesStore } from "@/store/categoriesStore";
import { Category, ImageProp, SubCategory } from "@/appTypes/Product";

const categoryStore = useCategoriesStore();
const notificationStore = useNotificationStore();

export default {
  name: "AddCategoryPage",
  data: () => ({
    category: {} as Category,

    subCategories: [] as SubCategory[],

    name: "",
    photo: "",
    items: [] as LinkProps[],
    isModalOpen: false,
    tabs: [] as {
      label: string;
    }[],
    tab: 0,
  }),
  mounted: async function () {
    await categoryStore.getCategoryById(this.$route.params.id.toString());
    this.category = categoryStore.category;
    this.subCategories = categoryStore.category.subCategories;

    this.tabs = [
      {
        label: this.$t("name-photo"),
      },
      {
        label: this.$t("add-subcategories"),
      },
    ];
    this.items = [
      { href: "/admin/company", icon: "brightness-1", text: "company" },
      { href: "/admin/categories", icon: "bullseye", text: "categories" },
      { href: "/admin/materials", icon: "brightness-1", text: "materials" },
    ];
  },
  methods: {
    async removeSubcategory(subcategoryId: string) {
      const r = await categoryStore.removeSubCategory(
        subcategoryId,
        this.category.id
      );
      if (r) {
        notificationStore.openSuccessAlert(this.$t("rmv-subcategory-success"));
      } else {
        notificationStore.openErrorAlert(this.$t("rmv-subcategory-error"));
      }
    },
    registerNameAndPhoto(name: string, photo: string) {
      this.name = name;
      this.photo = photo;
      this.tab = this.tab + 1;
    },
    async registerSubcategories(subCategories: ImageProp[]) {
      let req = await categoryStore.updateCategory(
        this.category.id,
        this.name,
        this.photo
      );

      for (const item of subCategories) {
        if (item.photo != "") {
          const r = await categoryStore.addSubCategories(
            item,
            this.category.id
          );
          req = req && r;
        }
      }
      if (req) {
        notificationStore.openSuccessAlert("update-category-success");
      } else {
        notificationStore.openErrorAlert("update-category-error");
      }
      await categoryStore.getAllCategories();
      this.$router.back();
    },
    goBack() {
      this.tab = this.tab - 1;
    },
  },
  components: {
    TwoColumnsPanel,
    TitleCardLinksButton,
    SimpleBodyLayout,
    TitleGoBack,
    NextTabs,
    AddImageNameForm,
    UpdateSubcategoriesForm,
    HeadingText,
  },
};
</script>
