<template>
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
            v-model="name"
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
            v-model="address"
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
            v-model="postalCode"
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
            v-model="schedule"
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
            v-model="phoneNo"
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
            v-model="email"
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

      <FullWidthButton> {{ $t("save-changes") }}</FullWidthButton>
    </div>
  </form>
</template>

<script lang="ts">
import BodyText from "@/components/atoms/Typography/BodyText.vue";
import FullWidthButton from "@/components/atoms/Button/FullWidthButton.vue";

export default {
  name: "EditCompanyInfoForm",
  data: () => ({
    name: "",
    address: "",
    postalCode: "",
    schedule: "",
    phoneNo: "",
    email: "",
  }),
  mounted: function () {
    this.name = this.nameCompany;
    this.address = this.addressCompany;
    this.postalCode = this.postalCodeCompany;
    this.schedule = this.postalCodeCompany;
    this.phoneNo = this.phoneNoCompany;
    this.email = this.emailCompany;
  },
  methods: {
    companyEdit() {
      this.saveChanges &&
        this.saveChanges(
          this.name,
          this.address,
          this.postalCode,
          this.schedule,
          this.phoneNo,
          this.email
        );
    },
  },
  props: {
    nameCompany: {
      type: String,
    },
    addressCompany: {
      type: String,
    },
    postalCodeCompany: {
      type: String,
    },
    scheduleCompany: {
      type: String,
    },
    phoneNoCompany: {
      type: String,
    },
    emailCompany: {
      type: String,
    },
    saveChanges: {
      type: Function,
    },
  },
  components: {
    BodyText,
    FullWidthButton,
  },
};
</script>

<style scoped>
.btn {
  margin-bottom: 20px;
}
</style>
