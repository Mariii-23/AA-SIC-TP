<template>
  <div class="body">
    <v-container fluid fill-height class="custom-full-width">
      <v-card class="elevation-12 rounded-lg">
        <v-toolbar dark color="primary">
          <v-toolbar-title>{{ $t("recover-pw") }}</v-toolbar-title>
        </v-toolbar>
        <v-card-text class="fill-height">
          <v-form fastfail class="custom-flex" ref="form" @submit.prevent="sendCode()">
            <p>{{ $t("enter-email") }}</p>
            <div>
              <v-text-field v-model="email" name="email" label="Email" type="text" placeholder="Email" single-line
                class="input-form rounded-lg" required bg-color="primary" :rules="emailRules" />
              <FullWidthButton> {{ $t("send-code") }}</FullWidthButton>
            </div>
          </v-form>
          <div class="custom-divider">
            <div class="line" />
          </div>
          <v-form fastfail class="custom-flex" ref="form" @submit.prevent="recoverPassword()">
            - <p>{{ $t("enter-code") }}</p>

            <div>
              <v-text-field v-model="code" name="code" :label="$t('code')" type="text" :placeholder="$t('code')"
                single-line class="input-form rounded-lg" required bg-color="primary" :rules="codeRules" />
              <FullWidthButton :handleClick="recoverPassword">
                {{ $t("recover-pw") }}
              </FullWidthButton>
            </div>

            <div class="signup-phrase">
              <p>{{ $t("didnt-receive") }}</p>
              <p class="link" @click="sendCode()">{{ $t("resend") }}</p>
            </div>

          </v-form>
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

.body {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 500px;
  margin: 3% auto auto auto;
}

.input-form {
  margin-bottom: 10px;
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
import FullWidthButton from "@/components/atoms/Button/FullWidthButton.vue";

export default {
  name: "RecoverPassword",
  data() {
    return {
      email: "",
      emailRules: [
        value => {
          if (/^[a-z.-]+[a-z0-9.-]+@[a-z.-]+\.[a-z]+$/i.test(value)) return true

          return this.$t('invalid-email')
        },
      ],
      code: "",
      codeRules: [
        //  value => {
        //    if (verificar) return true
        //
        //    return this.$t('invalid-code')
        //  },
      ]
    }
  },
  components: { FullWidthButton },
  methods: {
    sendCode() {
      console.log("sendCode");
    },
    recoverPassword() {
      console.log("recoverPassword");
    },
  },
};
</script>