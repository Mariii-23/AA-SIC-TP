<template>
  <SimpleBodyLayout>
    <TwoColumnsPanel>
      <ConfirmationModal :title="$t('logout')" :text="$t('logout-text')" :confirmHandler="logoutHandler"
        :closeModal="closeModal" :isModalOpen="isModalOpen" />
      <template v-slot:first>
        <TitleCardLinksButton :title="$t('store')" :items="items" :button-text="$t('logout')"
          :button-handler="openModal" />
      </template>
      <template v-slot:second>
        <TitleWithButtonAndGoBack :title="$t('company')" :buttonText="$t('save-changes')" :buttonHandler="saveChanges" />
        <form ref="form">
            <v-row>
              <v-col cols="4">
                <v-list-subheader>
                  <BodyText>{{ $t("name") }}</BodyText>
                </v-list-subheader>
              </v-col>

              <v-col cols="8">
                <v-text-field v-model="company.name" name="name" :label="$t('name')" type="name" :placeholder="$t('name')"
                  single-line class="rounded-lg" required bg-color="primary" :rules="nameRules" />
              </v-col>
            </v-row>
            <v-row>
              <v-col cols="4">
                <v-list-subheader>
                  <BodyText>{{ $t("address") }}</BodyText>
                </v-list-subheader>
              </v-col>

              <v-col cols="8">
                <v-text-field v-model="company.address" name="address" :label="$t('address')" type="address"
                  :placeholder="$t('address')" single-line class="rounded-lg" required bg-color="primary" 
                  :rules="addressRules"/>
              </v-col>
            </v-row>

            <v-row>
              <v-col cols="4">
                <v-list-subheader>
                  <BodyText>{{ $t("postal-code") }}</BodyText>
                </v-list-subheader>
              </v-col>

              <v-col cols="8">
                <v-text-field v-model="company.postCode" name="postalcode" :label="$t('postal-code')" type="address"
                  :placeholder="$t('postal-code')" single-line class="rounded-lg" required
                  bg-color="primary" :rules="postCodeRules"/>
              </v-col>
            </v-row>

            <v-row>
              <v-col cols="4">
                <v-list-subheader>
                  <BodyText>{{ $t("schedule") }}</BodyText>
                </v-list-subheader>
              </v-col>

              <v-col cols="8">
                <v-text-field v-model="company.schedule" name="schedule" :label="$t('schedule')" type="schedule"
                  :placeholder="$t('schedule')" single-line class="rounded-lg" required bg-color="primary" />
              </v-col>
            </v-row>

            <v-row>
              <v-col cols="4">
                <v-list-subheader>
                  <BodyText>{{ $t("phoneNo") }}</BodyText>
                </v-list-subheader>
              </v-col>

              <v-col cols="8">
                <v-text-field v-model="company.contact" name="phoneNo" :label="$t('phoneNo')" type="phoneNo"
                  :placeholder="$t('phoneNo')" single-line class="rounded-lg" required bg-color="primary"
                  :rules="phoneNoRules"/>
              </v-col>
            </v-row>

            <v-row>
              <v-col cols="4">
                <v-list-subheader>
                  <BodyText>{{ $t("email") }}</BodyText>
                </v-list-subheader>
              </v-col>

              <v-col cols="8">
                <v-text-field v-model="company.email" name="email" :label="$t('email')" type="email"
                  :placeholder="$t('email')" single-line class="rounded-lg" required bg-color="primary" 
                  :rules="emailRules"/>
              </v-col>
            </v-row>
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
  data() {
    return {
      items: [] as LinkProps[],
      isModalOpen: false,
      company: {
        name: "",
        address: "",
        postCode: "",
        schedule: "",
        contact: "",
        email: "",
      },
      nameRules: [
        value => {
          if (value) return true

          return this.$t('invalid-name')
        },
      ],
      addressRules: [
        value => {
          if (value?.length >= 8) return true

          return this.$t('invalid-address')
        },
      ],
      postCodeRules: [
        value => {
          if (/[0-9][0-9][0-9][0-9]-[0-9][0-9][0-9]/.test(value)) return true
          return this.$t('invalid-postal-code')
        }
      ],
      phoneNoRules: [
        value => {
          if (value?.length === 9 && /[0-9]+/.test(value)) return true

          return this.$t('invalid-phone-no')
        },
      ],
      emailRules : [
        value => {
          if (/^[a-z.-]+[a-z0-9.-]+@[a-z.-]+\.[a-z]+$/i.test(value)) return true

          return this.$t('invalid-email')
        },
      ],
    }
  },
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
  methods: {
    async saveChanges() {
      await companyStore.updateInfo(this.company);
    },
    //TODO: ir buscar os direitos
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
