<template>
  <SimpleBodyLayout>
    <TwoColumnsPanel>
      <template v-slot:first>
        <TitleCardLinksButton :title="$t('store')" :items="items" />
      </template>
      <template v-slot:second>
        <TitleGoBack :title="$t('add-category')" :items="items" />

        <NextTabs :tabs="tabs" v-bind:selected-tab="tab">
          <template v-slot:tab1>
            <AddImageNameForm
              class="bg-primary"
              :text-button="$t('next-step')"
              :register="registerNameAndPhoto"
            />
          </template>

          <template v-slot:tab2>
            <div class="titleWithGoBack">
              <v-btn icon @click="goBack" class="bg-secondary elevation-0">
                <v-icon>mdi-keyboard-backspace</v-icon>
              </v-btn>
              <HeadingText>{{ $t("previos-step") }}</HeadingText>
            </div>
            <AddSubcategoriesForm
              :add-subcategories="registerSubcategories"
              :text-button="$t('add-category')"
            />
          </template>
        </NextTabs>
      </template> </TwoColumnsPanel
  ></SimpleBodyLayout>
</template>

<script lang="ts">
import AddSubcategoriesForm from "@/components/organisms/Forms/AddSubcategoriesForm.vue";
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
import { ImageProp } from "@/appTypes/Product";

const categoryStore = useCategoriesStore();
const notificationStore = useNotificationStore();
export default {
  name: "AddCategoryPage",
  data: () => ({
    name: "",
    photo: "",
    items: [] as LinkProps[],
    isModalOpen: false,
    tabs: [] as {
      label: string;
    }[],
    tab: 0,
  }),
  mounted: function () {
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
    registerNameAndPhoto(name: string, photo: string) {
      this.name = name;
      this.photo = photo;
      this.tab = this.tab + 1;
    },
    async registerSubcategories(subCategories: ImageProp[]) {
      await this.addCategoryHandler(this.name, this.photo, subCategories);
    },
    goBack() {
      this.tab = this.tab - 1;
    },
    async addCategoryHandler(
      name: string,
      photo: string,
      subCategories: ImageProp[]
    ) {
      const req = await categoryStore.addCategory(name, photo, subCategories);
      if (req) {
        notificationStore.openSuccessAlert("add-category-success");
        this.$router.back();
      } else {
        notificationStore.openErrorAlert("add-category-error");
      }
    },
  },
  components: {
    TwoColumnsPanel,
    TitleCardLinksButton,
    SimpleBodyLayout,
    TitleGoBack,
    NextTabs,
    AddImageNameForm,
    AddSubcategoriesForm,
    HeadingText,
  },
};
</script>
