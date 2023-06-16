<template>
    <ConfirmationModal
    :title="$t('logout')"
    :text="$t('logout-text')"
    :confirmHandler="logoutHandler"
    :closeModal="closeModal"
    :isModalOpen="isModalOpen"
  />
    <SimpleBodyLayout>
      <TwoColumnsPanel>
        <template v-slot:first>
          <TitleCardLinksButton
            :title="$t('hello') + ', ' + user.name + '!'"
            :items="items"
            :button-text="$t('logout')"
            :button-handler="openModal"
          />
        </template>
        <template v-slot:second>
          <TitleWithButton
            :title="$t('profile')"
            :button-text="$t('edit-profile')"
            :button-handler="editProfile"
          />
          <ClientCard :client="user" />
        </template> </TwoColumnsPanel
    ></SimpleBodyLayout>
  </template>
  
  <script lang="ts">
  import { LinkProps } from "@/appTypes/Link";
  import TwoColumnsPanel from "@/layouts/Body/TwoColumnsPanel.vue";
  import TitleCardLinksButton from "@/components/organisms/TitleCardLinksButton.vue";
  import SimpleBodyLayout from "@/layouts/Body/SimpleBodyLayout.vue";
  import { UserInfoProps } from "@/appTypes/User";
  import TitleWithButton from "@/components/molecules/TitleWithButton.vue";
  import { useRoute } from "vue-router";
  import ClientCard from "@/components/organisms/Card/ClientCard.vue";
import ConfirmationModal from "@/components/organisms/Modal/ConfirmationModal.vue";
  
  export default {
    name: "UserProfile",
    //TODO: ir buscar os direitos
    data: () => ({
      items: [] as LinkProps[],
      user: Object as () => UserInfoProps,
      isModalOpen: false
    }),
    mounted: function () {
      const route = useRoute();
      //TODO: ir buscar o admin consoante o id dado
      this.user = {
        name: "Maria",
        email: "maria@hotmail.com",
        address: "Rua da Marina, Edificiona Nao sei , ablalkb",
        nif: "999888999",
        id: route.params.id,
      } as UserInfoProps;
  
      this.items = [
        { href: "/user/profile", icon: "bullseye", text: "profile" },
        { href: "/user/orders", icon: "brightness-1", text: "my-orders" },
      ];
    },
    //TODO: ir buscar os direitos
    methods: {
      logoutHandler() {
        console.log("logout");
      },
      editProfile() {
        this.$router.push("/user/profile/edit");
      },
      closeModal() {
        this.isModalOpen = false;
      },
      openModal() {
        this.isModalOpen = true;
      },

    },
    components: {
      TwoColumnsPanel,
      TitleCardLinksButton,
      SimpleBodyLayout,
      TitleWithButton,
      ClientCard,
      ConfirmationModal
    },
  };
  </script>
  