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
        <v-autocomplete class="search-bar mt-5" 
      append-inner-icon="mdi-magnify"
      :items="itemsSearch"
       v-model="searching" 
       menu-icon=""
       width="100%" 
       bg-color="primary"
        :label="$t('search')"
        @change="search()"/>
        

        <UserExpansionPanels
          :users="users"
          :view-details-handler="viewDetailsHandler"
        />
        <Pagination :length="length" :total-visible="5" :handle-page-change="handlePageChange" />
      </template> </TwoColumnsPanel
  ></SimpleBodyLayout>
</template>

<style scoped>
.search-bar {
  width: 100%;
  margin-top: 13px;
  align-content: center;
}
</style>

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

const adminStore = useAdminsStore();

export default {
  name: "ClientsAdminPage",
  data: () => ({
    items: [] as LinkProps[],
    users: [] as UserInfoProps[],
    page: 1,
    length: 0,
    clientsOnPage: 20,
    searching: "",
    itemsSearch: []
  }),
  mounted: async function () {
    await adminStore.getAllCustomers(0, 100000);

    for (let i = 0; i < adminStore.customers.length; i++) {
      this.itemsSearch.push(adminStore.customers[i].name);
    }

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

    this.$watch(
        () => this.searching,
        (newValues) => {
          this.search();
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
    },
    async search(){
      const adminStore = useAdminsStore();
      const r = await adminStore.searchCustomers(this.searching);
      if (r)
        this.$router.push("/admin/client/" + r);
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
