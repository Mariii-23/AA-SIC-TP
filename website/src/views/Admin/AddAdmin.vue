<template>
  <SimpleBodyLayout>
    <TwoColumnsPanel>
      <template v-slot:first>
        <TitleCardLinksButton :title="$t('addAdmin')" :items="items" />
      </template>
      <template v-slot:second>
        <TitleGoBack :title="$t('admins')" :items="items" />
        <AddAdminForm :register-admin="addAdminHandler" />
      </template> </TwoColumnsPanel
  ></SimpleBodyLayout>
</template>

<script lang="ts">
import { LinkProps } from "@/appTypes/Link";
import TwoColumnsPanel from "@/layouts/Body/TwoColumnsPanel.vue";
import TitleCardLinksButton from "@/components/organisms/TitleCardLinksButton.vue";
import SimpleBodyLayout from "@/layouts/Body/SimpleBodyLayout.vue";
import TitleGoBack from "@/components/molecules/TitleGoBack.vue";
import AddAdminForm from "@/components/organisms/Forms/AddAdminForm.vue"

export default {
  name: "AddAdminPage",
  data: () => ({
    items: Array as () => LinkProps[],
    isModalOpen: false,
  }),
  mounted: function () {
    this.items = [
      { href: "/admin/profile", icon: "brightness-1", text: "profile" },
      { href: "/admin/company", icon: "brightness-1", text: "company" },
      { href: "/admin", icon: "bullseye", text: "admins" },
      { href: "/admin/client", icon: "brightness-1", text: "clients" },
    ];
  },
  //TODO: ir buscar os direitos
  methods: {
    addAdminHandler(email: string, password: string) {
      console.log("add admin");
      //TODO: add handler
    },
  },
  components: {
    TwoColumnsPanel,
    TitleCardLinksButton,
    SimpleBodyLayout,
    TitleGoBack,
    AddAdminForm,
  },
};
</script>
