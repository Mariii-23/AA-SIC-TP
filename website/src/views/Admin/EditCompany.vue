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
        <TitleWithButtonAndGoBack
          :title="$t('company')"
          :buttonText="$t('save-changes')"
          :buttonHandler="saveChanges"
        />
        <form ref="form">
          <div class="custom-flex">
            <v-row>
              <v-col cols="4">
                <v-list-subheader>
                  <BodyText>{{ $t("name") }}</BodyText>
                </v-list-subheader>
              </v-col>

              <v-col cols="8">
                <v-text-field
                  v-model="company.name"
                  name="name"
                  :label="$t('name')"
                  type="name"
                  :placeholder="$t('name')"
                  single-line
                  class="input-form rounded-lg"
                  required
                  bg-color="primary"
                />
              </v-col>
            </v-row>
            <v-row>
              <v-col cols="4">
                <v-list-subheader>
                  <BodyText>{{ $t("address") }}</BodyText>
                </v-list-subheader>
              </v-col>

              <v-col cols="8">
                <v-text-field
                  v-model="company.address"
                  name="address"
                  :label="$t('address')"
                  type="address"
                  :placeholder="$t('address')"
                  single-line
                  class="input-form rounded-lg"
                  required
                  bg-color="primary"
                />
              </v-col>
            </v-row>

            <v-row>
              <v-col cols="4">
                <v-list-subheader>
                  <BodyText>{{ $t("postal-code") }}</BodyText>
                </v-list-subheader>
              </v-col>

              <v-col cols="8">
                <v-text-field
                  v-model="company.postCode"
                  name="postalcode"
                  :label="$t('postal-code')"
                  type="address"
                  :placeholder="$t('postal-code')"
                  single-line
                  class="input-form rounded-lg"
                  required
                  bg-color="primary"
                />
              </v-col>
            </v-row>

            <v-row>
              <v-col cols="4">
                <v-list-subheader>
                  <BodyText>{{ $t("schedule") }}</BodyText>
                </v-list-subheader>
              </v-col>

              <v-col cols="8">
                <v-text-field
                  v-model="company.schedule"
                  name="schedule"
                  :label="$t('schedule')"
                  type="schedule"
                  :placeholder="$t('schedule')"
                  single-line
                  class="input-form rounded-lg"
                  required
                  bg-color="primary"
                />
              </v-col>
            </v-row>

            <v-row>
              <v-col cols="4">
                <v-list-subheader>
                  <BodyText>{{ $t("phoneNo") }}</BodyText>
                </v-list-subheader>
              </v-col>

              <v-col cols="8">
                <v-text-field
                  v-model="company.contact"
                  name="phoneNo"
                  :label="$t('phoneNo')"
                  type="phoneNo"
                  :placeholder="$t('phoneNo')"
                  single-line
                  class="input-form rounded-lg"
                  required
                  bg-color="primary"
                />
              </v-col>
            </v-row>

            <v-row>
              <v-col cols="4">
                <v-list-subheader>
                  <BodyText>{{ $t("email") }}</BodyText>
                </v-list-subheader>
              </v-col>

              <v-col cols="8">
                <v-text-field
                  v-model="company.email"
                  name="email"
                  :label="$t('email')"
                  type="email"
                  :placeholder="$t('email')"
                  single-line
                  class="input-form rounded-lg"
                  required
                  bg-color="primary"
                />
              </v-col>
            </v-row>
          </div>
        </form>
      </template>
    </TwoColumnsPanel>
  </SimpleBodyLayout>
</template>

<script lang="ts">
import { LinkProps } from "@/appTypes/Link";
import TwoColumnsPanel from "@/layouts/Body/TwoColumnsPanel.vue";
import TitleCardLinksButton from "@/components/organisms/TitleCardLinksButton.vue";
import SimpleBodyLayout from "@/layouts/Body/SimpleBodyLayout.vue";
import ConfirmationModal from "@/components/organisms/Modal/ConfirmationModal.vue";
import TitleWithButtonAndGoBack from "@/components/molecules/TitleWithButtonAndGoBack.vue";
import { useCompanyStore } from "@/store/companyStore";

const companyStore = useCompanyStore();

export default {
  name: "EditCompany",
  data: () => ({
    items: Array as () => LinkProps[],
    isModalOpen: false,
    company: {
      name: "",
      address: "",
      postCode: "",
      schedule: "",
      contact: "",
      email: "",
    },
  }),
  mounted: async function () {
    if (companyStore.companyInfo.name == "") {
      await companyStore.getInfo();
    }

    this.company = {
      name: companyStore.companyInfo.name,
      address: companyStore.companyInfo.address,
      postCode: companyStore.companyInfo.postCode,
      schedule: companyStore.companyInfo.schedule,
      contact: companyStore.companyInfo.contact,
      email: companyStore.companyInfo.email,
    };

    this.items = [
      { href: "/admin/company", icon: "bullseye", text: "company" },
      { href: "/admin/categories", icon: "brightness-1", text: "categories" },
      { href: "/admin/materials", icon: "brightness-1", text: "materials" },
    ];

    this.$watch(
      () => companyStore.companyInfo,
      (newValues) => {
        this.company = newValues;
      }
    );
  },
  //TODO: ir buscar os direitos
  methods: {
    async saveChanges(
    ) {
        await companyStore.updateInfo(this.company);
    },
    addSocialNetwork() {
      console.log("add social network");
    },
    logoutHandler() {
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
    ConfirmationModal,
    TitleWithButtonAndGoBack,
  },
};
</script>

<style scoped>
.btn {
  margin-bottom: 20px;
}
</style>
