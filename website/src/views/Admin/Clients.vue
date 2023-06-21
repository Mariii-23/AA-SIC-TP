<template>
  <div v-if="users.length == 0">
      <v-progress-linear
      indeterminate
    />
    </div>
  <SimpleBodyLayout>
    <TwoColumnsPanel>
      <template v-slot:first>
        <TitleCardLinksButton :title="$t('allUsers')" :items="items"
        :button-text="$t('addAdmin')"
          :button-handler="addAdminHandler" />
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
import { useAdminsStore } from "@/store/adminsStore";

export default {
  name: "ClientsAdminPage",
  data: () => ({
    items: [] as LinkProps[],
    users: [] as UserInfoProps[],
  }),
  mounted: async function () {
    const adminStore = useAdminsStore();
    await adminStore.getAllCustomers();

    this.users = adminStore.customers;

    this.items = [
      { href: "/admin/profile", icon: "brightness-1", text: "profile" },
      { href: "/admin", icon: "brightness-1", text: "admins" },
      { href: "/admin/client", icon: "bullseye", text: "clients" },
    ];

    this.$watch(
      () => ({ users: adminStore.customers }),
      (newValues) => {
        this.users = newValues.users;
      }
    );
  },
  methods: {
    viewDetailsHandler(id: number) {
      this.$router.push("/admin/client/" + id);
    },
    addAdminHandler() {
      this.$router.push("/admin/add-admin/");
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
