<template>
  <div class="body">
    <v-container fluid fill-height class="custom-full-width">
      <v-card class="elevation-12 rounded-lg">
        <v-toolbar dark color="primary">
          <v-toolbar-title>{{ $t("register") }}</v-toolbar-title>
        </v-toolbar>
        <v-card-text class="fill-height">
          <form ref="form" @submit.prevent="registerHandler()">
            <div class="custom-flex">
              <div>
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
                />
                <v-text-field
                  v-model="name"
                  name="name"
                  :label="$t('name')"
                  type="input"
                  :placeholder="$t('name')"
                  required
                  bg-color="primary"
                  single-line
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
                />
                <v-text-field type="date" :label="$t('dob')" />
              </div>

              <FullWidthButton> {{ $t("register") }}</FullWidthButton>

              <!-- <div class="custom-divider">
                        <div class="line" />
                        <div class="text">
                           <p>
                              {{ $t("or") }}
                           </p>
                        </div>
                        <div class="line" />
                     </div>

                     <div class="custom-flex">
                        <PrimaryButton :handleClick="handleSignupWithGoogle">
                           {{ $t("continue-google") }}
                        </PrimaryButton>
                     </div> -->

              <div class="login-phrase">
                <p>{{ $t("have-account") }}</p>
                <p class="link" @click="goToLogIn()">{{ $t("login") }}</p>
              </div>
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

.custom-divider {
  display: flex;
  align-items: center;
  margin: 0px 0;
}

.custom-divider .line {
  flex-grow: 1;
  height: 1px;
  background-color: black;
}

.custom-divider .text {
  margin: 0 10px;
}

.button-grid {
  display: grid;
  grid-template-columns: 48% auto 48%;
  grid-gap: 10px;
}

.button-grid > v-btn {
  width: 100%;
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
      password: "",
      conf_password: "",
      address: "",
      nif: "",
      name: "",
      date: null,
    };
  },
  methods: {
    async registerHandler() {
      await userStore.register(this.email, this.password, this.name, this.date, this.nif, this.address);
      if (userStore.isLoggedIn) {
        this.$router.push("/")
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
