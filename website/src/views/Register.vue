<template>
  <div class="body">
    <v-container fluid fill-height class="custom-full-width">
      <v-card class="elevation-12 rounded-lg">
        <v-toolbar dark color="primary">
          <v-toolbar-title>{{ $t("register") }}</v-toolbar-title>
        </v-toolbar>
        <v-card-text class="fill-height">
          <form
            fastfail
            class="custom-flex"
            ref="form"
            @submit.prevent="registerHandler()"
          >
            <v-text-field
              v-model="name"
              name="name"
              :label="$t('name')"
              type="input"
              :placeholder="$t('name')"
              required
              bg-color="primary"
              single-line
              :rules="nameRules"
              class="input-form"
            />
            <v-text-field
              v-model="email"
              name="email"
              label="Email"
              type="text"
              placeholder="Email"
              single-line
              class="input-form rounded-lg"
              required
              bg-color="primary"
              :rules="emailRules"
            />
            <v-text-field
              v-model="password"
              name="password"
              :label="$t('password')"
              type="password"
              :placeholder="$t('password')"
              required
              bg-color="primary"
              single-line
              :rules="passwordRules"
              class="input-form"
            />
            <v-text-field
              v-model="conf_password"
              name="password"
              :label="$t('confirm-pw')"
              type="password"
              :placeholder="$t('confirm-pw')"
              required
              bg-color="primary"
              single-line
              :rules="confirmPasswordRules"
              class="input-form"
            />

            <v-text-field
              v-model="address"
              name="address"
              :label="$t('address')"
              type="input"
              :placeholder="$t('address')"
              required
              bg-color="primary"
              single-line
              :rules="addressRules"
              class="input-form"
            />
            <v-text-field
              v-model="nif"
              name="nif"
              :label="$t('nif')"
              type="input"
              :placeholder="$t('nif')"
              required
              bg-color="primary"
              single-line
              :rules="nifRules"
              class="input-form"
            />
            <v-text-field
              bg-color="primary"
              type="date"
              :label="$t('dob')"
              :rules="dobRules"
            />

            <FullWidthButton> {{ $t("register") }}</FullWidthButton>

            <div class="login-phrase">
              <p>{{ $t("have-account") }}</p>
              <p class="link" @click="goToLogIn()">{{ $t("login") }}</p>
            </div>
          </form>
        </v-card-text>
      </v-card>
    </v-container>
  </div>
</template>

<style>
.custom-full-width {
  width: 100%;
}

.custom-flex {
  display: flex;
  flex-direction: column;
  gap: 10px;
}

.body {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 500px;
  margin: 3% auto auto auto;
}

@media (max-width: 600px) {
  .body {
    width: 90%;
  }
}

.login-phrase {
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 4px;
}

.login-phrase > .link {
  color: blue;
}
</style>

<script lang="ts">
import FullWidthButton from "@/components/atoms/Button/FullWidthButton.vue";
import { useUserStore } from "@/store/userStore";

const userStore = useUserStore();

export default {
  name: "Register",
  data() {
    return {
      email: "",
      emailRules: [
        (value) => {
          if (/^[a-z.-]+[a-z0-9.-]+@[a-z.-]+\.[a-z]+$/i.test(value))
            return true;

          return this.$t("invalid-email");
        },
      ],
      password: "",
      passwordRules: [
        (value) => {
          if (value?.length >= 8) return true;

          return this.$t("password-length");
        },
      ],
      conf_password: "",
      confirmPasswordRules: [
        (value) => {
          if (value === this.password) return true;

          return this.$t("password-match");
        },
        (value) => {
          if (value?.length > 0) return true;

          return this.$t("password-length");
        },
      ],
      address: "",
      addressRules: [
        (value) => {
          if (value?.length >= 8) return true;

          return this.$t("invalid-address");
        },
      ],
      nif: "",
      nifRules: [
        (value) => {
          if (value?.length === 9 && /[0-9-]+/.test(value)) return true;

          return this.$t("invalid-nif");
        },
      ],
      name: "",
      nameRules: [
        (value) => {
          if (value?.length >= 3 && /[^0-9]/.test(value)) return true;

          return this.$t("invalid-name");
        },
      ],
      date: null,
      dobRules: [
        (value) => {
          if (value) return true;

          return this.$t("invalid-date");
        },
      ],
    };
  },
  methods: {
    async registerHandler() {
      await userStore.register(
        this.email,
        this.password,
        this.name,
        this.date,
        this.nif,
        this.address
      );
      if (userStore.isLoggedIn) {
        this.$router.push("/");
      }
    },
    // handleSignupWithGoogle() {
    //    console.log("register with google");
    //    this.$router.push("/register-personal-data");
    // },
    // handleSignupWithEmail() {
    //    console.log("register with email");
    //    this.$router.push("/register-personal-data");
    // },
    goToLogIn() {
      this.$router.push("/login");
    },
  },
  components: { FullWidthButton },
};
</script>
