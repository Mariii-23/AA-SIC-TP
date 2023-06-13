<template>
  <SimpleBodyLayout>
    <TwoColumnsPanel>
      <template v-slot:first>
        <TitleCardLinksButton
          :title="$t('allClients')"
          :items="items"
        />
      </template>
      <template v-slot:second>
        <HeadingText>{{ $t("clients") }}</HeadingText>
        <SearchBar bg-color="primary"/>
        <UserExpansionPainels
          :users="users"
          :view-details-handler="viewDetailsHandler"
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
import UserExpansionPainels from "@/components/molecules/expansionPainels/UserExpansionPainels.vue";
import { UserInfoProps } from "@/appTypes/User";

export default {
  name: "ClientsAdminPage",
  data: () => ({
  //TODO: ir buscar os direitos
    items: Array as () => LinkProps[],
    users: Array as () => UserInfoProps[],
  }),
  mounted: function () {
    const user = {
      name: "Maria",
      email: "maria@hotmail.com",
      address: "Rua da Marina, Edificiona Nao sei , ablalkb",
      nif: "999888999",
      id: "1234",
    } as UserInfoProps;
    let users1: UserInfoProps[] = [];
    for (let i = 0; i < 8; i++) {
      users1.push(user);
    }
    this.users = users1

    this.items = [
      { href: "/admin/profile", icon: "brightness-1", text: "profile" },
      { href: "/admin/company", icon: "brightness-1", text: "company" },
      { href: "/admin", icon: "brightness-1", text: "admins" },
      { href: "/admin/client", icon: "bullseye", text: "clients" },
    ];
  },
  //TODO: handlers
  methods: {
    viewDetailsHandler: (id: number) => {
      console.log(id);
    },
    addAdminHandler: () => {
      console.log("add admin");
    },
  },
  components: {
    TwoColumnsPanel,
    TitleCardLinksButton,
    SimpleBodyLayout,
    HeadingText,
    SearchBar,
    UserExpansionPainels
  },
};
</script>
