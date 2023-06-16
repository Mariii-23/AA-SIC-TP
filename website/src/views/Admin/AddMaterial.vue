<template>
  <SimpleBodyLayout>
    <TwoColumnsPanel>
      <template v-slot:first>
        <TitleCardLinksButton :title="$t('store')" :items="items" />
      </template>
      <template v-slot:second>
        <TitleGoBack :title="$t('addMaterial')" :items="items" />
        <AddMaterialForm :register-material="addMaterialHandler" />
      </template> </TwoColumnsPanel
  ></SimpleBodyLayout>
</template>

<script lang="ts">
import { LinkProps } from "@/appTypes/Link";
import TwoColumnsPanel from "@/layouts/Body/TwoColumnsPanel.vue";
import TitleCardLinksButton from "@/components/organisms/TitleCardLinksButton.vue";
import SimpleBodyLayout from "@/layouts/Body/SimpleBodyLayout.vue";
import TitleGoBack from "@/components/molecules/TitleGoBack.vue";
import { useNotificationStore } from "@/store/notificationStore";
import AddMaterialForm from "@/components/organisms/Forms/AddMaterialForm.vue";
import { useMaterialStore } from "@/store/materialsStore";

const materialsStore = useMaterialStore();
const notificationStore = useNotificationStore();

export default {
  name: "AddMaterialPage",
  data: () => ({
    items: [] as LinkProps[],
    isModalOpen: false,
  }),
  mounted: function () {
    this.items = [
      { href: "/admin/company", icon: "brightness-1", text: "company" },
      { href: "/admin/categories", icon: "brightness-1", text: "categories" },
      { href: "/admin/materials", icon: "bullseye", text: "materials" },
    ];
  },
  methods: {
    async addMaterialHandler(name: string, photo: string) {
      const req = await materialsStore.addMaterial(name, photo);
      if (req) {
        notificationStore.openSuccessAlert("add-material-success");
        this.$router.back();
      } else {
        notificationStore.openErrorAlert("add-material-error");
      }
    },
  },
  components: {
    TwoColumnsPanel,
    TitleCardLinksButton,
    SimpleBodyLayout,
    TitleGoBack,
    AddMaterialForm,
  },
};
</script>
