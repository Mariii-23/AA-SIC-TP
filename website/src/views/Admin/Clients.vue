<template>
  <SimpleBodyLayout>
    <TwoColumnsPanel>
      <template v-slot:first>
        <TitleCardLinksButton :title="$t('allClients')" :items="items" />
      </template>
      <template v-slot:second>
        <HeadingText>{{ $t("clients") }}</HeadingText>
        <SearchBar bg-color="primary" />
        <UserExpansionPanels
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
import UserExpansionPanels from "@/components/molecules/expansionPanels/UserExpansionPanels.vue";
import { UserInfoProps } from "@/appTypes/User";
import { useCustomersStore } from "@/store/clientsStore";

export default {
  name: "ClientsAdminPage",
  data: () => ({
    //TODO: ir buscar os direitos
    items: Array as () => LinkProps[],
    users: Array as () => UserInfoProps[],
  }),
  mounted: async function () {
    const customerStore = useCustomersStore();

    await customerStore.getAllCustomers();

    this.users = customerStore.customers;

    this.items = [
      { href: "/admin/profile", icon: "brightness-1", text: "profile" },
      { href: "/admin/company", icon: "brightness-1", text: "company" },
      { href: "/admin", icon: "brightness-1", text: "admins" },
      { href: "/admin/client", icon: "bullseye", text: "clients" },
    ];

    this.$watch(
      () => ({ users: customerStore.customers }),
      (newValues) => {
        this.users = newValues.users;
      }
    );
  },
  //TODO: handlers
  methods: {
    viewDetailsHandler(id: number) {
      this.$router.push("/admin/client/" + id);
      console.log(id);
    },
  },
  components: {
    TwoColumnsPanel,
    TitleCardLinksButton,
    SimpleBodyLayout,
    HeadingText,
    SearchBar,
    UserExpansionPanels,
  },
};
</script>
