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
          :title="$t('store')"
          :items="items"
          :button-text="$t('logout')"
          :button-handler="openModal"
        />
      </template>
      <template v-slot:second>
        <TitleWithButton
          :title="$t('company')"
          :buttonText="$t('edit-company-info')"
          :buttonHandler="editCompanyHandler"
        />
        <CompanyTable :company="company" />
      </template> </TwoColumnsPanel
  ></SimpleBodyLayout>
</template>

<script lang="ts">
import { LinkProps } from "@/appTypes/Link";
import TwoColumnsPanel from "@/layouts/Body/TwoColumnsPanel.vue";
import TitleCardLinksButton from "@/components/organisms/TitleCardLinksButton.vue";
import SimpleBodyLayout from "@/layouts/Body/SimpleBodyLayout.vue";
import { Company } from "@/appTypes/Company";
import TitleWithButton from "@/components/molecules/TitleWithButton.vue";
import CompanyTable from "@/components/organisms/Table/CompanyTable.vue";
import ConfirmationModal from "@/components/organisms/Modal/ConfirmationModal.vue";
import { useCompanyStore } from "@/store/companyStore";
const companyStore = useCompanyStore();

export default {
  name: "Company",
  data: () => ({
    items: Array as () => LinkProps[],
    isModalOpen: false,
    company: Object as () => Company,
  }),
  mounted: async function () {
    this.items = [
      { href: "/admin/company", icon: "bullseye", text: "company" },
      { href: "/admin/categories", icon: "brightness-1", text: "categories" },
      { href: "/admin/materials", icon: "brightness-1", text: "materials" },
    ];

    await companyStore.getInfo();

    this.company = {
      name: companyStore.companyInfo.name,
      address: companyStore.companyInfo.address,
      postalCode: companyStore.companyInfo.postCode,
      schedule: companyStore.companyInfo.schedule,
      phoneNo: companyStore.companyInfo.contact,
      email: companyStore.companyInfo.email,
      socialMedia: companyStore.socialNetworks,
    };
  },
  methods: {
    editCompanyHandler() {
      this.$router.push("/admin/company/edit");
    },
    logoutHandler() {
  //TODO: ir buscar os direitos
      console.log("logout");
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
    CompanyTable,
    ConfirmationModal,
  },
};
</script>
