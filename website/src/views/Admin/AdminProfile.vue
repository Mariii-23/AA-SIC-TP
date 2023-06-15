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
          <TitleWithButton
            :title="$t('profile')"
            :button-text="$t('edit-profile')"
            :button-handler="editProfile"
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
  import TitleWithButton from "@/components/molecules/TitleWithButton.vue";
  import { useRoute } from "vue-router";
  import AdminCard from "@/components/organisms/Card/AdminCard.vue";
  
  export default {
    name: "AdminProfile",
    //TODO: ir buscar os direitos
    data: () => ({
      items: Array as () => LinkProps[],
      admin: Object as () => UserInfoProps,
    }),
    mounted: function () {
      const route = useRoute();
      //TODO: ir buscar o admin consoante o id dado
      this.admin = {
        name: "Maria",
        email: "maria@hotmail.com",
        id: route.params.id,
      } as UserInfoProps;
  
      this.items = [
        { href: "/admin/profile", icon: "bullseye", text: "profile" },
        { href: "/admin", icon: "brightness-1", text: "admins" },
        { href: "/admin/client", icon: "brightness-1", text: "clients" },
      ];
    },
    //TODO: ir buscar os direitos
    methods: {
      addAdminHandler() {
        this.$router.push("/admin/add-admin/");
      },
      editProfile() {
        this.$router.push("/admin/profile/edit");
      }

    },
    components: {
      TwoColumnsPanel,
      TitleCardLinksButton,
      SimpleBodyLayout,
      TitleWithButton,
      AdminCard,
    },
  };
  </script>
  