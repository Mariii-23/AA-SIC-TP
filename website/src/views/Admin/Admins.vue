<template>
  <div v-if="admins.length == 0">
      <v-progress-linear
      indeterminate
    />
    </div>
  <SimpleBodyLayout>
    <ConfirmationModal
    :title="$t('removeAdmin')"
    :text="$t('rm-admin-text') + ' '  + nameAdmin + '?'"
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
        <v-autocomplete class="search-bar mt-5" 
      append-inner-icon="mdi-magnify"
      :items="itemsSearch"
       v-model="searching" 
       menu-icon=""
       width="100%" 
       bg-color="primary"
        :label="$t('search')"
        @change="search()"/>
        <AdminExpansionPanels
          :admins="admins"
          :remove-admin-handler="openModal"
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
import { AdminInfoProps } from "@/appTypes/User";
import AdminExpansionPanels from "@/components/molecules/expansionPanels/AdminExpansionPanels.vue";
import { useAdminsStore } from "@/store/adminsStore";
import ConfirmationModal from "@/components/organisms/Modal/ConfirmationModal.vue";
import { useNotificationStore } from "@/store/notificationStore";
import Pagination from "@/components/molecules/Pagination.vue";
const adminStore = useAdminsStore();
const notificationStore = useNotificationStore();

export default {
  name: "AdminsAdminPage",
  data: () => ({
    idAdmin: "",
    nameAdmin: "",
    items: [] as LinkProps[],
    admins: [] as AdminInfoProps[],
    isModalOpen: false,
    page: 1,
    length: 0,
    adminsOnPage: 20,
    searching: "",
    itemsSearch: [] as string[]
  }),
  mounted: async function () {
    await adminStore.getAllAdmins(0, 100000);

    for (let i = 0; i < adminStore.admins.length; i++) {
      this.itemsSearch.push(adminStore.admins[i].name);
    }
    await adminStore.getAllAdmins(0, this.adminsOnPage);
    this.length = Math.ceil((await adminStore.getNumberOfAdmins())/this.adminsOnPage);

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
    this.$watch(
      () => this.searching,
      (newValues) => {
          this.search();
      }
    );
  },
  methods: {
    async removeAdminHandler() {
      if (await adminStore.removeAdmin(this.idAdmin)) {
        this.closeModal();
        notificationStore.openSuccessAlert("removeAdminSuccess");
        await adminStore.getAllAdmins((this.page-1)*this.adminsOnPage, this.adminsOnPage);
      } else {
        this.closeModal();
        notificationStore.openErrorAlert("removeAdminError");
      }
    },
    addAdminHandler() {
      this.$router.push("/admin/add-admin/");
    },
    openModal(id: string, name: string) {
      this.idAdmin = id;
      this.nameAdmin = name;
      this.isModalOpen = true;
    },
    closeModal() {
      this.idAdmin = "";
      this.nameAdmin = "";
      this.isModalOpen = false;
    },
    async handlePageChange(page: number){
      this.page = page;
      const adminStore = useAdminsStore();
      await adminStore.getAllAdmins((this.page-1)*this.adminsOnPage, this.adminsOnPage);
    },
    async search () {
      const adminStore = useAdminsStore();
      const admin = await adminStore.searchAdmins(this.searching);
      if (admin){
      this.admins = [];
      this.admins.push(admin);
      }
      else {
        this.admins = adminStore.admins;
      }
    }
  },
  components: {
    TwoColumnsPanel,
    TitleCardLinksButton,
    SimpleBodyLayout,
    HeadingText,
    SearchBar,
    AdminExpansionPanels,
    ConfirmationModal,
    Pagination
  },
};
</script>
