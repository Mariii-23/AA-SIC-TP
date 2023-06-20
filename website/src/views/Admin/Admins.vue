<template>
  <SimpleBodyLayout>
    <ConfirmationModal
    :title="$t('removeAdmin')"
    :text="$t('rm-admin-text')"
    :confirmHandler="removeAdminHandler"
    :closeModal="closeModal"
    v-bind:is-modal-open="isModalOpen"
  />

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
        <HeadingText>{{ $t("admins") }}</HeadingText>
        <SearchBar bg-color="primary" />
        <AdminExpansionPanels
          :admins="admins"
          :remove-admin-handler="openModal"
        />
      </template> </TwoColumnsPanel
  ></SimpleBodyLayout>
</template>

<script lang="ts">
import { LinkProps } from "@/appTypes/Link";
import TwoColumnsPanel from "@/layouts/Body/TwoColumnsPanel.vue";
import TitleCardLinksButton from "@/components/organisms/TitleCardLinksButton.vue";
import SimpleBodyLayout from "@/layouts/Body/SimpleBodyLayout.vue";
import HeadingText from "@/components/atoms/Typography/HeadingText.vue";
import SearchBar from "@/components/molecules/SearchBar.vue";
import { AdminInfoProps } from "@/appTypes/User";
import AdminExpansionPanels from "@/components/molecules/expansionPanels/AdminExpansionPanels.vue";
import { useAdminsStore } from "@/store/adminsStore";
import ConfirmationModal from "@/components/organisms/Modal/ConfirmationModal.vue";
import { useNotificationStore } from "@/store/notificationStore";
const adminStore = useAdminsStore();
const notificationStore = useNotificationStore();

export default {
  name: "AdminsAdminPage",
  data: () => ({
    idAdmin: "",
    items: [] as LinkProps[],
    admins: [] as AdminInfoProps[],
    isModalOpen: false,
  }),
  mounted: async function () {
    await adminStore.getAllAdmins();

    this.admins = adminStore.admins;

    this.items = [
      { href: "/admin/profile", icon: "brightness-1", text: "profile" },
      { href: "/admin", icon: "bullseye", text: "admins" },
      { href: "/admin/client", icon: "brightness-1", text: "clients" },
    ];

    this.$watch(
      () => ({ admins: adminStore.admins }),
      (newValues) => {
        this.admins = newValues.admins;
      }
    );
  },
  methods: {
    async removeAdminHandler() {
      if (await adminStore.removeAdmin(this.idAdmin)) {
        this.closeModal();
        notificationStore.openSuccessAlert("removeAdminSuccess");
      } else {
        this.closeModal();
        notificationStore.openErrorAlert("removeAdminError");
      }
    },
    addAdminHandler() {
      this.$router.push("/admin/add-admin/");
    },
    openModal(id: string) {
      this.idAdmin = id;
      this.isModalOpen = true;
    },
    closeModal() {
      this.idAdmin = "";
      this.isModalOpen = false;
    },
  },
  components: {
    TwoColumnsPanel,
    TitleCardLinksButton,
    SimpleBodyLayout,
    HeadingText,
    SearchBar,
    AdminExpansionPanels,
    ConfirmationModal,
  },
};
</script>
