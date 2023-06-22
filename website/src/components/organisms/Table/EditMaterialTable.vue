<template>
        <CompanyNetworkLinks v-if="!isEdit" :company="company" />

        <div v-if="isEdit">
          <div
            v-for="(textField, i) in textFields"
            :key="i"
            class="text-fields-row"
          >
            <v-text-field
              :label="textField.label1"
              v-model="textField.value1"
            />

            <v-text-field
              :label="textField.label2"
              v-model="textField.value2"
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
import { Company } from "@/appTypes/Company";
import { useCompanyStore } from "@/store/companyStore";
import CompanyNetworkLinks from "@/components/organisms/Table/CompanyNetworkLinksTable.vue";
import FullWidthButton from "@/components/atoms/Button/FullWidthButton.vue";
import { SocialNetWorkResponse } from "@/appTypes/AxiosTypes";
const companyStore = useCompanyStore();

export default {
  name: "Company",
  data: () => ({
    items:  [] as LinkProps[],
    company: {} as Company,
    textFields: [] as{
      label1: String,
      value1: String,
      label2: String,
      value2: String,
    }[],
    isEdit: false,
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
    }
  },
  components: {
    CompanyNetworkLinks,
    FullWidthButton,
  },
};
</script>
