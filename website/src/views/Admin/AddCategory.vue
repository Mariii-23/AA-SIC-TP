<template>
  <SimpleBodyLayout>
    <TwoColumnsPanel>
      <template v-slot:first>
        <TitleCardLinksButton :title="$t('store')" :items="items" />
      </template>
      <template v-slot:second>
        <TitleGoBack :title="$t('addCategory')" :items="items" />

        <NextTabs :tabs="tabs" v-bind:selected-tab="tab">
          <template v-slot:tab1>
            <AddImageNameForm
              class="bg-primary"
              :text-button="$t('next')"
              :register="registerNameAndPhoto"
            />
          </template>

          <template v-slot:tab2>
            <AddSubcategoriesForm />
            <SecondaryButton :handleClick="goBack">{{
              $t("goBack")
            }}</SecondaryButton>
          </template>
        </NextTabs>
      </template>
    </TwoColumnsPanel></SimpleBodyLayout
  >
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
import { useMaterialStore } from "@/store/materialsStore";
import SecondaryButton from "@/components/atoms/Button/SecondaryButton.vue";

const materialsStore = useMaterialStore();
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
    goBack() {
      this.tab = this.tab - 1;
    },
    async addCategoryHandler(name: string, photo: string) {
      //const req = await materialsStore.addMaterial(name, photo);
      //if (req) {
      //  notificationStore.openSuccessAlert("add-material-success");
      //  this.$router.back();
      //} else {
      //  notificationStore.openErrorAlert("add-material-error");
      //}
    },
  },
  components: {
    TwoColumnsPanel,
    TitleCardLinksButton,
    SimpleBodyLayout,
    TitleGoBack,
    NextTabs,
    AddImageNameForm,
    SecondaryButton,
    AddSubcategoriesForm,
  },
};
</script>
