<template>
  <div>
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

        <TitleWithButton
          size="6"
          v-if="isEdit"
          :title="$t('networkLinks')"
          :button-handler="saveNetworkHandler"
          :button-text="$t('save')"
        />
        <TitleWithEditButton
          :size="6"
          v-if="!isEdit"
          :title="$t('networkLinks')"
          :edit-handler="editHandler"
        />

        <CompanyNetworkLinks v-if="!isEdit" :company="company" />

        <v-form v-if="isEdit" fast-fail>
          <div
            v-for="(textField, i) in textFields"
            :key="i"
            class="text-fields-row"
          >
            <v-text-field 
              :label="textField.label1"
              v-model="textField.value1"
              :rules="socialNetworkNameRules"
            />

            <v-text-field
              :label="textField.label2"
              v-model="textField.value2"
              :rules="linkRules"
            />

            <v-btn @click="remove(i)" class="error">
              <v-icon icon="mdi-trash-can-outline" />
            </v-btn>
          </div>

          <FullWidthButton :handle-click="add">
            {{ $t("add") }}
          </FullWidthButton>
          <FullWidthButton :handle-click="cancelHandler">
            {{ $t("cancel") }}
          </FullWidthButton>
        </v-form>
      </template>
    </TwoColumnsPanel></SimpleBodyLayout
  >
  </div>
</template>

<style>
.text-fields-row {
  display: flex;
  gap: 10px;
}
</style>

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
import CompanyNetworkLinks from "@/components/organisms/Table/CompanyNetworkLinksTable.vue";
import TitleWithEditButton from "@/components/molecules/TitleWithEditButton.vue";
import FullWidthButton from "@/components/atoms/Button/FullWidthButton.vue";
import { SocialNetWorkResponse } from "@/appTypes/AxiosTypes";
const companyStore = useCompanyStore();

export default {
  name: "Company",
  data: () => ({
    items:  [] as LinkProps[],
    isModalOpen: false,
    company: {} as Company,
    textFields: [] as{
      label1: String,
      value1: String,
      label2: String,
      value2: String,
    }[],
    isEdit: false,
    socialNetworkNameRules: [
      (value: string) => {
        if (value?.length >= 3 && /[^0-9]/.test(value)) return true;

        return this.$t("invalid-name");
      },
    ],
    linkRules: [
      (value: string) => {
        if (/^(ftp|http|https):\/\/[^ "]+$/.test(value)) return true;

        return this.$t("invalid-link");
      },
    ],
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
      postCode: companyStore.companyInfo.postCode,
      schedule: companyStore.companyInfo.schedule,
      contact: companyStore.companyInfo.contact,
      email: companyStore.companyInfo.email,
      socialMedia: companyStore.socialNetworks,
    };

    companyStore.socialNetworks.forEach((socialNetwork) => {
      this.textFields.push({
        label1: this.$t("name"),
        value1: socialNetwork.name,
        label2: this.$t("link"),
        value2: socialNetwork.link,
      });
    });

    this.$watch(
      () => companyStore.companyInfo,
      (newValues) => {
        this.company.name = newValues.name;
        this.company.address = newValues.address;
        this.company.postCode = newValues.postCode;
        this.company.schedule = newValues.schedule;
        this.company.contact = newValues.contact;
        this.company.email = newValues.email;
      }
    );
    this.$watch(
      () => companyStore.socialNetworks,
      (newValues) => {
        //this.company.socialNetworks = newValues;
        console.log(newValues)
        newValues.forEach((socialNetwork) => {
          this.textFields.push({
            label1: this.$t("name"),
            value1: socialNetwork.name,
            label2: this.$t("link"),
            value2: socialNetwork.link,
          });
        });
      }
    );
  },
  methods: {
    add() {
      this.textFields.push({
        label1: this.$t("name"),
        value1: "",
        label2: this.$t("link"),
        value2: "",
      });
    },
    remove(index: number) {
      this.textFields.splice(index, 1);
    },
    cancelHandler() {
      this.textFields = [];
      companyStore.socialNetworks.forEach((socialNetwork) => {
        this.textFields.push({
          label1: this.$t("name"),
          value1: socialNetwork.name,
          label2: this.$t("link"),
          value2: socialNetwork.link,
        });
      });
      this.editHandler();
    },
    editHandler() {
      this.isEdit = !this.isEdit;
    },
    async saveNetworkHandler() {
      let newNetworksLinks: SocialNetWorkResponse[] = [];
      this.textFields.forEach((field) => {
        newNetworksLinks.push({
          name: field.value1,
          link: field.value2,
        } as SocialNetWorkResponse);
      });

      if (await companyStore.updateNetworkLinks(newNetworksLinks)) {
        this.editHandler();
        this.textFields = [];
        companyStore.socialNetworks.forEach((socialNetwork) => {
          this.textFields.push({
            label1: this.$t("name"),
            value1: socialNetwork.name,
            label2: this.$t("link"),
            value2: socialNetwork.link,
          });
        });
      }
    },
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
    CompanyNetworkLinks,
    TitleWithEditButton,
    FullWidthButton,
  },
};
</script>
