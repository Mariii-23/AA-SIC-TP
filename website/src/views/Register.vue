<template>
   <div class="body">
      <v-container fluid fill-height class="custom-full-width">
         <v-card class="elevation-12 rounded-lg">
            <v-toolbar dark color="primary">
               <v-toolbar-title>{{ $t("register") }}</v-toolbar-title>
            </v-toolbar>
            <v-card-text class="fill-height">
               <form ref="form" @submit.prevent="login()">
                  <div class="custom-flex">
                     <div>
                        <v-text-field v-model="email" name="email" label="Email" type="text" placeholder="Email"
                           single-line class="input-form rounded-lg" required bg-color="primary" />
                        <v-text-field v-model="password" name="password" :label="$t('password')" type="password"
                           :placeholder="$t('password')" required bg-color="primary" single-line />
                        <v-text-field v-model="conf_password" name="password" :label="$t('confirm-pw')" type="password"
                           :placeholder="$t('confirm-pw')" required bg-color="primary" single-line />
                        <v-text-field v-model="address" name="password" :label="$t('address')" type="input"
                           :placeholder="$t('address')" required bg-color="primary" single-line />
                        <v-text-field v-model="nif" name="password" :label="$t('nif')" type="input"
                           :placeholder="$t('nif')" required bg-color="primary" single-line />

                     </div>

                     <FullWidthButton :handleClick="handleSignupWithEmail"> {{ $t("register") }}</FullWidthButton>

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
                        <PrimaryButton :handleClick="handleSignupWithGoogle">
                           {{ $t("continue-google") }}
                        </PrimaryButton>
                     </div>

                     <div class="login-phrase">
                        <p>{{ $t("have-account") }}</p>
                        <p class="link">{{ $t("login") }}</p>
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


.login-phrase {
   display: flex;
   justify-content: center;
   align-items: center;
   gap: 4px;
}

.login-phrase>.link {
   color: blue;
}
</style>
 
 
  
<script lang="ts">
import PrimaryButton from "@/components/atoms/Button/PrimaryButton.vue";
import FullWidthButton from "@/components/atoms/Button/FullWidthButton.vue";

export default {
   name: "Register",
   data() {
      return {
         email: "",
         password: "",
         conf_password: "",
         address: "",
         nif: "",
         items: [
            {
               label: 'Personal',
               to: "/"
            },
            {
               label: 'Seat',
               to: "/seat",
            },
            {
               label: 'Payment',
               to: "/payment",
            },
            {
               label: 'Confirmation',
               to: "/confirmation",
            }
         ]
      }
   },
   methods: {
      login() {
         const { email } = this;
         console.log(email + "logged in");
      },
      handleSignupWithGoogle() {
         console.log(+"hiihih");
      },
      handleSignupWithEmail() {
         console.log("hiihih");
      },
   },
   components: { PrimaryButton, FullWidthButton }
};
</script>