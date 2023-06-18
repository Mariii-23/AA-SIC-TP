<template>
  <SimpleBodyLayout>
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
        <TitleWithButton
          :title="$t('profile')"
          :button-text="$t('save-changes')"
          :button-handler="saveChanges"
        />
        <form ref="form">
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
                  class="rounded-lg"
                  required
                  bg-color="primary"
                  :rules="nameRules"
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
                  class="rounded-lg"
                  required
                  bg-color="primary"
                  :rules="emailRules"
                />
              </v-col>
            </v-row>
            <FullWidthButton class="mt-2" :handle-click="saveChanges">
              {{ $t("save-changes") }}</FullWidthButton
            >
        </form>
      </template>
    </TwoColumnsPanel></SimpleBodyLayout
  >
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
  //TODO: ir buscar os direitos
  data() {
    return {
    items: [] as LinkProps[],
    name: "",
    password: "",
    id: "",
    nameRules: [
        value => {
          if (value?.length >= 3 && /[^0-9]/.test(value)) return true
          return this.$t("invalid-name")
        },
      ],
    email: "",
    emailRules : [
        value => {
          if (/^[a-z.-]+[a-z0-9.-]+@[a-z.-]+\.[a-z]+$/i.test(value)) return true
          return this.$t("invalid-email")
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
      const r = await adminStore.editAdmin(this.id, this.email, this.name);
      if ( r == 200) {
        console.log("save changes");
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
