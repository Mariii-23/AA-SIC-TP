<template>
  <div class="body">
    <v-container fluid fill-height class="custom-full-width">
      <v-card class="elevation-12 rounded-lg">
        <v-toolbar dark color="primary">
          <v-toolbar-title>{{ $t("login") }}</v-toolbar-title>
        </v-toolbar>
        <v-card-text class="fill-height">
          <form ref="form" @submit.prevent="login()">
            <div class="custom-flex">
              <div>
                <v-text-field v-model="username" name="email" label="Email" type="text" placeholder="Email" single-line
                  class="input-form rounded-lg" required bg-color="primary" />
                <v-text-field v-model="password" name="password" :label="$t('password')" type="password"
                  :placeholder="$t('password')" required bg-color="primary" single-line />
              </div>

              <FullWidthButton :handleClick="handleLoginWithEmail"> {{ $t("login") }}</FullWidthButton>

              <div class="signup-phrase">
                <p>{{ $t("forgot-pw") }} </p>
                <p class="link" @click="goToRecoverPw()">{{ $t("recover-pw") }}</p>
              </div>

              <div class="custom-divider">
                <div class="line" />
                <div class="text">
                  <p>
                    {{ $t("or") }}
                  </p>
                </div>
                <div class="line" />
              </div>

              <div class="custom-flex">
                <PrimaryButton :handleClick="handleLoginWithGoogle">
                  {{ $t("continue-google") }}
                </PrimaryButton>
              </div>

              <div class="signup-phrase">
                <p>{{ $t("dont-have-account") }}</p>
                <p class="link" @click="goToRegister()">{{ $t("register") }}</p>
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

.button-grid>v-btn {
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


.signup-phrase {
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 4px;
}

.signup-phrase>.link {
  color: blue;
}
</style>


 
<script lang="ts">
import PrimaryButton from "@/components/atoms/Button/PrimaryButton.vue";
import FullWidthButton from "@/components/atoms/Button/FullWidthButton.vue";

export default {
  name: "Login",
  data() {
    return {
      username: "",
      password: "",
    };
  },
  methods: {
    login() {
      const { username } = this;
      console.log(username + "logged in");
    },
    handleLoginWithGoogle() {
      console.log("login with google");
    },
    handleLoginWithEmail(){
      console.log("login with email");
    },
    goToRegister() {
      this.$router.push("/register")
    },
    goToRecoverPw() {
      this.$router.push("/recover-password")
    }
  },
  components: { PrimaryButton, FullWidthButton }
};
</script>