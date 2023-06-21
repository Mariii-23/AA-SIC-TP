<template>
  <div class="body">
    <v-container fluid fill-height class="custom-full-width">
      <v-card class="elevation-12 rounded-lg">
        <v-toolbar dark color="primary">
          <v-toolbar-title>{{ $t("login") }}</v-toolbar-title>
        </v-toolbar>
        <v-card-text class="fill-height">
          <form
            class="custom-flex"
            ref="form"
            fast-fail
            @submit.prevent="login()"
          >
            <v-text-field
              v-model="email"
              name="email"
              label="Email"
              type="text"
              placeholder="Email"
              single-line
              class="rounded-lg"
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
            />

            <div class="signup-phrase">
              <p>{{ $t("forgot-pw") }}</p>
              <p class="link" @click="goToRecoverPw()">
                {{ $t("recover-pw") }}
              </p>
            </div>

            <FullWidthButton> {{ $t("login") }}</FullWidthButton>

            <div class="signup-phrase">
              <p>{{ $t("dont-have-account") }}</p>
              <p class="link" @click="goToRegister()">{{ $t("register") }}</p>
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
  gap: 20px;
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

.signup-phrase {
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 4px;
}

.signup-phrase > .link {
  color: blue;
}
</style>

<script lang="ts">
import FullWidthButton from "@/components/atoms/Button/FullWidthButton.vue";
import { useUserStore } from "@/store/userStore";

const userStore = useUserStore();

export default {
  name: "Login",
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
        /*value => {
          if verificar password return true

          return this.$t('incorrect-login')
        }*/
      ],
    };
  },
  methods: {
    async login() {
      await userStore.login(this.email, this.password);
      if (userStore.isLoggedIn) {
        this.$router.back();
        /*if (userStore.role == "ADMIN")
          this.$router.push("/admin")
        else {
          this.$router.push("/category/12")
        }*/
      }
    },
    goToRegister() {
      this.$router.push("/register");
    },
    goToRecoverPw() {
      this.$router.push("/recover-password");
    },
  },
  components: { FullWidthButton },
};
</script>
