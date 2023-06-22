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
      <div class="social-networks">
      <v-row v-for="social in social_media" :key="social" class="mt-5">
        <v-btn v-if="social.name == 'Facebook'" :href="social.link" class="elevation-0" color="secondary">
          <v-icon size="x-large">mdi-facebook</v-icon>
          </v-btn>
          <v-btn v-else-if="social.name == 'Instagram'" class="elevation-0" color="secondary" :href="social.link">
          <v-icon size="x-large">mdi-instagram</v-icon>
          </v-btn>
          <v-btn v-else :href="social.link" class="elevation-0" color="secondary">
          <v-icon size="x-large">mdi-link-variant</v-icon>
          </v-btn>
      </v-row>
    </div>
    </v-col>
    <v-spacer />
  </v-footer>
</template>

<script lang="ts">
import { useCompanyStore } from "@/store/companyStore";
import HeadingText from "../atoms/Typography/HeadingText.vue";
import { SocialMedia } from "@/appTypes/Company";
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
    social_media: [] as SocialMedia[],
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

    this.social_media = companyStore.socialNetworks;

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
.social-networks {
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: center;
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
