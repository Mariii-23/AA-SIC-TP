<template>
  <v-footer class="footer" color="secondary" elevation="5">
    <v-spacer />
    <v-col v-if="hasLocalization" class="column">
      <v-row>
        <HeadingText :size="6"> {{ $t("where") }} </HeadingText>
      </v-row>
      <v-row>{{ address }}</v-row>
      <v-row>{{ post_code }}</v-row>
    </v-col>
    <v-spacer />
    <v-col v-if="hasSchedule" class="column">
      <v-row>
        <HeadingText :size="6"> {{ $t("schedule") }}</HeadingText>
      </v-row>
      <v-row v-for="schedule in schedule_list" :key="schedule">{{
        schedule
      }}</v-row>
    </v-col>
    <v-spacer />
    <v-col class="column">
      <v-row>
        <HeadingText :size="6"> {{ $t("contact") }}</HeadingText>
      </v-row>
      <v-row>{{ phone_number }}</v-row>
      <v-row>{{ email }}</v-row>
    </v-col>
    <v-spacer />
  </v-footer>
</template>

<script lang="ts">
import { useCompanyStore } from "@/store/companyStore";
import HeadingText from "../atoms/Typography/HeadingText.vue";
const companyStore = useCompanyStore();

export default {
  name: "AppFooter",
  data: () => ({
    hasLocalization: false,
    address: null,
    post_code: null,
    hasSchedule: false,
    schedule_list: [],
    phone_number: null,
    email: null,
    social_media_list: [],
  }),
  mounted: async function () {
    if (companyStore.companyInfo.name == "") {
      await companyStore.getInfo();
    }

    const localization = {
      address: companyStore.companyInfo.address,
      post_code: companyStore.companyInfo.postCode,
    };

    const schedule = {
      schedule_list: [companyStore.companyInfo.schedule],
    };

    const contact = {
      phone_number: companyStore.companyInfo.contact,
      email: companyStore.companyInfo.email,
    };

    if (localization !== false) {
      this.address = localization.address;
      this.post_code = localization.post_code;
      this.hasLocalization = true;
    }

    if (schedule !== false) {
      this.schedule_list = schedule.schedule_list;
      this.hasSchedule = true;
    }

    if (contact !== false) {
      this.phone_number = contact.phone_number;
      this.email = contact.email;
    }

    this.$watch(
      () => companyStore.companyInfo,
      (newValues) => {
        this.address = newValues.address;
        this.post_code = newValues.postCode;
        this.email = newValues.email;
        this.hasSchedule = newValues.schedule != "";
        this.schedule_list = [newValues.schedule];
        this.phone_number = newValues.contact;
      }
    );
  },
  components: { HeadingText },
};
</script>

<style scoped>
.footer {
  display: flex;
  align-content: center;
  padding: 20px;
}

@media screen and (max-width: 800px) {
  .footer {
    display: flex;
    flex-direction: column;
  }

  .column {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
  }
}
</style>
