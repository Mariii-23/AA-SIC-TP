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
        <Pagination :length="length" :total-visible="5" :handle-page-change="handlePageChange" />
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
import Pagination from "@/components/molecules/Pagination.vue";

export default {
  name: "ClientsAdminPage",
  data: () => ({
    items: [] as LinkProps[],
    users: [] as UserInfoProps[],
    page: 1,
    length: 0,
    clientsOnPage: 20,
  }),
  mounted: async function () {
    const adminStore = useAdminsStore();
    await adminStore.getAllCustomers(0, 20);
    this.length = Math.ceil((await adminStore.getNumberOfCustomers())/this.clientsOnPage);

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
    async handlePageChange(page: number){
      this.page = page;
      const adminStore = useAdminsStore();
      await adminStore.getAllCustomers((this.page-1)*this.clientsOnPage, this.clientsOnPage);
    }
  },
  components: {
    TwoColumnsPanel,
    TitleCardLinksButton,
    SimpleBodyLayout,
    HeadingText,
    SearchBar,
    UserExpansionPanels,
    Pagination
  },
};
</script>
