<template>
  <div class="body">
    <v-container fluid fill-height class="custom-full-width">
      <v-card class="elevation-12 rounded-lg">
        <v-toolbar dark color="primary">
          <v-toolbar-title>{{ $t("finish-register") }}</v-toolbar-title>
        </v-toolbar>
        <v-card-text class="fill-height">
          <form ref="form">
            <div class="custom-flex">
              <p>{{ $t("personal-data") }}</p>
              <div>
                <v-text-field
                  v-model="address"
                  name="password"
                  :label="$t('address')"
                  type="input"
                  :placeholder="$t('address')"
                  required
                  bg-color="primary"
                  single-line
                />
                <v-text-field
                  v-model="nif"
                  name="password"
                  :label="$t('nif')"
                  type="input"
                  :placeholder="$t('nif')"
                  required
                  bg-color="primary"
                  single-line
                />
                <v-text-field type="date" :label="$t('dob')" />
              </div>

              <FullWidthButton :handleClick="handleSignup">
                {{ $t("finish-register") }}</FullWidthButton
              >
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

export default {
  name: "RegisterPersonalData",
  data() {
    return {
      address: "",
      nif: "",
      dob: null,
    };
  },
  methods: {
    handleSignup() {
      console.log(+"signup");
    },
  },
  components: { FullWidthButton },
};
</script>
