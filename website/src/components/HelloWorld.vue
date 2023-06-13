<template>
  <Typography.Body>{{ $t("hello") }}</Typography.Body>
  <Typography.Body>Body</Typography.Body>
  <Typography.Body :size="2">Body 2</Typography.Body>
  <Typography.Heading>Heading </Typography.Heading>
  <Typography.Heading :size="6">Heading 6</Typography.Heading>
  <Typography.Heading :size="2">Heading 2</Typography.Heading>

  <heading-text>Heading</heading-text>
  <FilesInput />

  <v-container class="fill-height">
    <v-responsive class="d-flex align-center text-center fill-height">
      <v-container class="fill-height">
        <v-responsive class="d-flex align-center text-center fill-height">
          <div class="text-body-2 font-weight-light mb-n1">Welcome to</div>

          <h1 class="text-h2 font-weight-bold">Vuetify</h1>

          <div class="py-5" />

          <v-row class="d-flex align-center justify-center">
            <v-col cols="auto">
              <v-btn color="primary"> Primary </v-btn>
            </v-col>
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
          <v-switch
            inset
            color="info"
            v-model="darkMode"
            @change="toggleTheme()"
            :label="`It's ${darkMode ? 'Dark' : 'Light'}!`"
          />
        </v-col>
      </v-row>

      <div class="py-14" />
    </v-responsive>
  </v-container>
</template>

<script lang="ts" setup>
import { ref } from "vue";
import { useTheme } from "vuetify";
import { Typography } from "./atoms/Typography/Typography";
import HeadingText from "./atoms/Typography/HeadingText.vue";
import FilesInput from "./molecules/FilesInput.vue";

const theme = useTheme();
const darkMode = ref(false);

const toggleTheme = () => {
  theme.global.name.value = darkMode.value
    ? "customDarkTheme"
    : "customLightTheme";
  // Optional: Get value of current theme
  console.log(`Current theme is dark? ${theme.global.current.value.dark}`);
};
</script>

<style scoped>
.products {
  margin: 10%;
  gap: 50px;
}

.custom-title {
  display: flex;
  align-items: center;
  justify-content: space-between;
  cursor: pointer;
}

.rotate-arrow {
  transition: transform 0.3s;
  transform: rotate(180deg);
}

.custom-text {
  margin-top: 10px;
}
</style>
