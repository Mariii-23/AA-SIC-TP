<template>
  <SimpleBodyLayout>
    <TwoColumnsPanel>
      <template v-slot:first>
        <TitleCardLinksButton :title="$t('allUsers')" :items="items" :button-text="$t('addAdmin')"
          :button-handler="addAdminHandler" />
      </template>
      <template v-slot:second>
        <TitleWithButton :title="$t('profile')" :button-text="$t('save-changes')" :button-handler="saveChanges" />
        <form ref="form" @submit.prevent="saveChanges()">
          <v-row>
            <v-col cols="4">
              <v-list-subheader>
                <BodyText>{{ $t("name") }}</BodyText>
              </v-list-subheader>
            </v-col>

            <v-col cols="8">
              <v-text-field v-model="name" name="name" :label="$t('name')" type="name" :placeholder="$t('name')"
                single-line class="rounded-lg" required bg-color="primary" :rules="nameRules" />
            </v-col>
          </v-row>
          <v-row>
            <v-col cols="4">
              <v-list-subheader>
                <BodyText>{{ $t("email") }}</BodyText>
              </v-list-subheader>
            </v-col>

            <v-col cols="8">
              <v-text-field v-model="email" name="email" :label="$t('email')" type="email" :placeholder="$t('email')"
                single-line class="rounded-lg" required bg-color="primary" :rules="emailRules" />
            </v-col>
          </v-row>
          <v-row>
            <v-col cols="4">
              <v-list-subheader>
                <BodyText>{{ $t("password") }}</BodyText>
              </v-list-subheader>
            </v-col>

            <v-col cols="8">
              <v-text-field v-model="password" name="password" :label="$t('password')" type="password"
                :placeholder="$t('password')" single-line class="input-form rounded-lg" bg-color="primary"
                :rules="passwordRules" />

            </v-col>
          </v-row>
          <v-row>
            <v-col cols="4">
              <v-list-subheader>
                <BodyText>{{ $t("confirm-pw") }}</BodyText>
              </v-list-subheader>
            </v-col>

            <v-col cols="8">
              <v-text-field v-model="conf_password" name="password" :label="$t('confirm-pw')" type="password"
                :placeholder="$t('confirm-pw')" single-line class="input-form rounded-lg" bg-color="primary"
                :rules="confirmPasswordRules" />

            </v-col>
          </v-row>
          <FullWidthButton class="mt-2">
            {{ $t("save-changes") }}</FullWidthButton>
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
import TitleWithButton from "@/components/molecules/TitleWithButton.vue";
import { useUserStore } from "@/store/userStore";
import { useAdminsStore } from "@/store/adminsStore";
import BodyText from "@/components/atoms/Typography/BodyText.vue";
import FullWidthButton from "@/components/atoms/Button/FullWidthButton.vue";

const userStore = useUserStore();
const adminStore = useAdminsStore();

export default {
  name: "AdminAdminPage",
  data() {
    return {
      items: [] as LinkProps[],
      name: "",
      id: "",
      nameRules: [
        value => {
          if (value?.length >= 3 && /[^0-9]/.test(value)) return true
          return this.$t("invalid-name")
        },
      ],
      email: "",
      emailRules: [
        value => {
          if (/^[a-z.-]+[a-z0-9.-]+@[a-z.-]+\.[a-z]+$/i.test(value)) return true
          return this.$t("invalid-email")
        },
      ],
      password: "",
      passwordRules: [
      ],
      conf_password: "",
      confirmPasswordRules: [
        value => {
          if (value === this.password) return true
          return this.$t("password-match")
        },
      ],
    }
  },
  mounted: function () {
    (this.name = userStore.name),
      (this.email = userStore.email),
      (this.id = userStore.id),
      (this.items = [
        { href: "/admin/profile", icon: "bullseye", text: "profile" },
        { href: "/admin", icon: "brightness-1", text: "admins" },
        { href: "/admin/client", icon: "brightness-1", text: "clients" },
      ]);
  },

  methods: {
    addAdminHandler() {
      this.$router.push("/admin/add-admin/");
    },
    async saveChanges() {
      let argname, argemail;
      if (this.name == userStore.name) {
        argname = "";
      } else {
        argname = this.name;
      }

      if (this.email == userStore.email) {
        argemail = "";
      } else {
        argemail = this.email;
      }

      const r = await adminStore.editAdmin(this.id, argemail, argname, this.password);
      if (r) {
        userStore.update(argname, argemail);
        this.$router.push("/admin/profile");
      }
    },
  },
  components: {
    TwoColumnsPanel,
    TitleCardLinksButton,
    SimpleBodyLayout,
    TitleWithButton,
    BodyText,
    FullWidthButton,
  },
};
</script>
