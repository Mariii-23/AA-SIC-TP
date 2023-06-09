<template>
  <Typography.Body>Body</Typography.Body>
  <Typography.Body :size="2">Body 2</Typography.Body>
  <Typography.Heading>Heading </Typography.Heading>
  <Typography.Heading :size="6">Heading 6</Typography.Heading>
  <Typography.Heading :size="2">Heading 2</Typography.Heading>

  <heading-text>Heading</heading-text>

  <v-container class="fill-height">
    <v-responsive class="d-flex align-center text-center fill-height">
      <v-img contain height="300" src="@/assets/logo.svg" />


      <v-container class="fill-height">
        <v-responsive class="d-flex align-center text-center fill-height">
          <div class="text-body-2 font-weight-light mb-n1">Welcome to</div>

          <h1 class="text-h2 font-weight-bold">Vuetify</h1>

          <div class="py-5" />

          <v-row class="d-flex align-center justify-center">
            <v-col cols="auto"> <v-btn color="primary"> Primary </v-btn> </v-col>
            <v-col cols="auto">
              <v-btn color="secondary"> Secondary </v-btn>
            </v-col>
            <v-col cols="auto"> <v-btn color="error"> Error </v-btn> </v-col>
          </v-row>

          <v-row class="d-flex align-center justify-center">
            <v-col cols="auto">
              <v-btn color="info"> Info </v-btn>
            </v-col>
            <v-col cols="auto">
              <v-btn color="success"> Success </v-btn>
            </v-col>
            <v-col cols="auto">
              <v-btn color="warning"> Warning </v-btn>
            </v-col>
          </v-row>
        </v-responsive>
      </v-container>


      <v-row class="d-flex align-center justify-center">
        <v-col cols="auto">
          <v-switch inset color="info" v-model="darkMode" @change="toggleTheme()"
            :label="`It's ${darkMode ? 'Dark' : 'Light'}!`"/>
        </v-col>
      </v-row>


      <div class="py-14" />

      <v-row class="d-flex align-center justify-center">
        <v-col cols="auto">
          <v-btn href="https://next.vuetifyjs.com/components/all/" min-width="164" rel="noopener noreferrer"
            target="_blank" variant="text">
            <v-icon icon="mdi-view-dashboard" size="large" start />

            Components
          </v-btn>
        </v-col>

        <v-col cols="auto">
          <v-btn color="primary" href="https://next.vuetifyjs.com/introduction/why-vuetify/#feature-guides"
            min-width="228" rel="noopener noreferrer" size="x-large" target="_blank" variant="flat">
            <v-icon icon="mdi-speedometer" size="large" start />

            Get Started
          </v-btn>
        </v-col>

        <v-col cols="auto">
          <v-btn href="https://community.vuetifyjs.com/" min-width="164" rel="noopener noreferrer" target="_blank"
            variant="text">
            <v-icon icon="mdi-account-group" size="large" start />

            Community
          </v-btn>
        </v-col>
      </v-row>
    </v-responsive>
  </v-container>
</template>

<script lang="ts" setup>
import { ref } from "vue";
import { useTheme } from "vuetify";
import { Typography } from "./atoms/Typography/Typography";
import HeadingText from "./atoms/Typography/HeadingText.vue";

const theme = useTheme();
const darkMode = ref(false);

const toggleTheme = () => {
  theme.global.name.value = darkMode.value ? "customDarkTheme" : "customLightTheme";
  // Optional: Get value of current theme
  console.log(`Current theme is dark? ${theme.global.current.value.dark}`);
};
</script>
