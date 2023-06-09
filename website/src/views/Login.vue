<template>
  <div class="body">
    <v-container fluid fill-height class="custom-full-width">
      <v-card class="elevation-12 rounded-lg">
        <v-toolbar dark color="primary">
          <v-toolbar-title>Login form</v-toolbar-title>
        </v-toolbar>
        <v-card-text class="fill-height">
          <form ref="form" @submit.prevent="login()">
            <div class="custom-flex">
              <div>
                <v-text-field v-model="username" name="username" label="Username" type="text" placeholder="username"
                  class="input-form rounded-lg" required/>
                <v-text-field v-model="password" name="password" label="Password" type="password" placeholder="password"
                  required/>
              </div>

              <div class="button-grid">
                <v-btn type="submit" color="primary" value="log in">Recover password</v-btn>
                <div/>
                <v-btn type="submit" color="primary" value="log in">Login</v-btn>
              </div>

              <div class="signup-phrase">
                <p>Don't you have an account?</p>
                <p class="signup">Sign up</p>
              </div>

              <div class="custom-divider">
                <div class="line"/>
                <div class="text">
                  <p>
                    OR
                  </p>
                </div>
                <div class="line"/>
              </div>

              <div class="custom-flex">
                <PrimaryButton :handleClick="handleLoginWithGoogle">
                  Continue whit google
                </PrimaryButton>
                <FullWidthButton :handleClick="handleLoginWithGoogle">
                  Continue whit google
                </FullWidthButton>
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

.button-login-recover {
  display: flex;
  justify-content: space-between;
}

.button-login-recover>v-btn {
  flex-basis: 45%;
}

.button-login-recover>v-btn:last-child {
  margin-right: 0;
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
  margin: 3% 30%;
}

@media (max-width: 768px) {
  .body {
    margin: 10%;
  }
}


.signup-phrase {
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 4px;

}

.signup-phrase>.signup {
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
      console.log(+"hiihih");
    }
  },
  components: { PrimaryButton, FullWidthButton }
};
</script>