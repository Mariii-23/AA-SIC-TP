<template>
  <SimpleBodyLayout>
    <TwoColumnsPanel>
      <template v-slot:first>
        <TitleCardLinksButton
          :title="$t('allUsers')"
          :items="items"
          :button-text="$t('addAdmin')"
          :button-handler="addAdminHandler"
        />
      </template>
      <template v-slot:second>
        <TitleGoBack :title="$t('addAdmin')" :items="items" />
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
import AddAdminForm from "@/components/organisms/Forms/AddAdminForm.vue";
import { useAdminsStore } from "@/store/adminsStore";
import { useNotificationStore } from "@/store/notificationStore";

const adminsStore = useAdminsStore();
const notificationStore = useNotificationStore();

export default {
  name: "AddAdminPage",
  data: () => ({
    items: [] as LinkProps[],
    isModalOpen: false,
  }),
  mounted: function () {
    this.items = [
      { href: "/admin/profile", icon: "brightness-1", text: "profile" },
      { href: "/admin", icon: "bullseye", text: "admins" },
      { href: "/admin/client", icon: "brightness-1", text: "clients" },
    ];
  },
  methods: {
    async addAdminHandler(email: string, password: string, name: string) {
      const result = await adminsStore.addAdmin(email, password, name);
      if (result) {
        this.$router.push("/admin");
        notificationStore.openSuccessAlert("addAdminSuccess");
      } else {
        notificationStore.openErrorAlert("addAdminError");
      }
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
