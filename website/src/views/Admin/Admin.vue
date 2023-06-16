<template>
  <ConfirmationModal 
    :title="$t('removeAdmin')"
    :text="$t('rm-admin-text')"
    :confirmHandler="removeAdminHandler"
    :closeModal="closeModal"
    :isModalOpen="isModalOpen"
  />
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
        <TitleWithButtonAndGoBack
          :title="$t('admin') + ' ' + admin.id"
          :button-text="$t('removeAdmin')"
          :button-handler="openModal"
        />
        <AdminCard :admin="admin" />
      </template> </TwoColumnsPanel
  ></SimpleBodyLayout>
</template>

<script lang="ts">
import { LinkProps } from "@/appTypes/Link";
import TwoColumnsPanel from "@/layouts/Body/TwoColumnsPanel.vue";
import TitleCardLinksButton from "@/components/organisms/TitleCardLinksButton.vue";
import SimpleBodyLayout from "@/layouts/Body/SimpleBodyLayout.vue";
import { UserInfoProps } from "@/appTypes/User";
import TitleWithButtonAndGoBack from "@/components/molecules/TitleWithButtonAndGoBack.vue";
import { useRoute } from "vue-router";
import AdminCard from "@/components/organisms/Card/AdminCard.vue";
import ConfirmationModal from "@/components/organisms/Modal/ConfirmationModal.vue";

export default {
  name: "AdminAdminPage",
  //TODO: ir buscar os direitos
  data: () => ({
    items: [] as LinkProps[],
    admin: {} as UserInfoProps,
    isModalOpen: false,
  }),
  mounted: function () {
    const route = useRoute();
    //TODO: ir buscar o admin consoante o id dado
    this.admin = {
      name: "Maria",
      email: "maria@hotmail.com",
      address: "Rua da Marina, Edificiona Nao sei , ablalkb",
      nif: "999888999",
      id: route.params.id,
    } as UserInfoProps;

    this.items = [
      { href: "/admin/profile", icon: "brightness-1", text: "profile" },
      { href: "/admin", icon: "bullseye", text: "admins" },
      { href: "/admin/client", icon: "brightness-1", text: "clients" },
    ];
  },
  //TODO: ir buscar os direitos
  methods: {
    removeAdminHandler: () => {
      console.log("remove admin");
    },
    addAdminHandler() {
      this.$router.push("/admin/add-admin/");
    },
    openModal() {
      this.isModalOpen = true;
    },
    closeModal() {
      this.isModalOpen = false;
    },
  },
  components: {
    TwoColumnsPanel,
    TitleCardLinksButton,
    SimpleBodyLayout,
    TitleWithButtonAndGoBack,
    AdminCard,
    ConfirmationModal
  },
};
</script>
