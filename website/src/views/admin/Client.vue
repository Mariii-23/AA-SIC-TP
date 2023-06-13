<template>
  <SimpleBodyLayout>
    <TwoColumnsPanel>
      <template v-slot:first>
        <TitleCardLinksButton :title="$t('client')" :items="items" />
      </template>
      <template v-slot:second>
        <TitleGoBack :title="$t('allClients')"/>
        <ClientCard :client="client" />
      </template> </TwoColumnsPanel
  ></SimpleBodyLayout>
</template>

<script lang="ts">
import { LinkProps } from "@/appTypes/Link";
import TwoColumnsPanel from "@/layouts/Body/TwoColumnsPanel.vue";
import TitleCardLinksButton from "@/components/organisms/TitleCardLinksButton.vue";
import SimpleBodyLayout from "@/layouts/Body/SimpleBodyLayout.vue";
import { UserInfoProps } from "@/appTypes/User";
import { useRoute } from "vue-router";
import ClientCard from "@/components/organisms/Card/ClientCard.vue";
import TitleGoBack from "@/components/molecules/TitleGoBack.vue";

export default {
  name: "ClientInfoAdminPage",
  data: () => ({
    items: Array as () => LinkProps[],
    client: Object as () => UserInfoProps,
    isModalOpen: false,
  }),
  mounted: function () {
    const route = useRoute();
    //TODO: ir buscar os direitos
    this.client = {
      name: "Maria",
      email: "maria@hotmail.com",
      address: "Rua da Marina, Edificiona Nao sei , ablalkb",
      nif: "999888999",
      id: route.params.id,
    } as UserInfoProps;

    this.items = [
      { href: "/admin/profile", icon: "brightness-1", text: "profile" },
      { href: "/admin/company", icon: "brightness-1", text: "company" },
      { href: "/admin", icon: "brightness-1", text: "admins" },
      { href: "/admin/client", icon: "bullseye", text: "clients" },
    ];
  },
  components: {
    TwoColumnsPanel,
    TitleCardLinksButton,
    SimpleBodyLayout,
    ClientCard,
    TitleGoBack
},
};
</script>
