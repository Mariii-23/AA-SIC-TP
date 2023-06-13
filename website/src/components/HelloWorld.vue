<template>
  <Typography.Body>{{ $t("hello") }}</Typography.Body>
  <Typography.Body>Body</Typography.Body>
  <Typography.Body :size="2">Body 2</Typography.Body>
  <Typography.Heading>Heading </Typography.Heading>
  <Typography.Heading :size="6">Heading 6</Typography.Heading>
  <Typography.Heading :size="2">Heading 2</Typography.Heading>

  <heading-text>Heading</heading-text>

  <div class="products">
    <!-- <ProductPreviewAdminCards :products="products" /> -->
    <ProductPreviewUserCards :products="products" />
  </div>

  <v-container class="fill-height">
    <v-responsive class="d-flex align-center text-center fill-height">
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
            :label="`It's ${darkMode ? 'Dark' : 'Light'}!`" />
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
import ProductPreviewAdminCards from "./organisms/Cards/ProductPreviewAdminCards.vue";
import ProductPreviewUserCards from "./organisms/Cards/ProductPreviewUserCards.vue";

const theme = useTheme();
const darkMode = ref(false);


const products = [
  {
    name: "Product name 1",
    price: 1,
    id: 1,
    href: "http://diamond.mariii.xyz:8080/api/wall/pleasant-lake.jpg",
  },
  {
    id: 1,
    name: "Product name 2",
    price: 2,
    href: "http://diamond.mariii.xyz:8080/api/wall/workshop.jpg",
  },
  {
    name: "Product name 3",
    href: "http://diamond.mariii.xyz:8080/api/wall/workshop.jpg",
    id: 1,
    price: 3,
  },
  {
    name: "Product name 4",
    href: "http://diamond.mariii.xyz:8080/api/wall/workshop.jpg",
    id: 1,
    price: 4,
  },
  {
    name: "Product name 4",
    href: "http://diamond.mariii.xyz:8080/api/wall/workshop.jpg",
    id: 1,
    price: 4,
  },
  {
    id: 1,
    name: "Product name 2",
    href: "http://diamond.mariii.xyz:8080/api/wall/workshop.jpg",
    price: 2,
  },
  {
    name: "Product name 3",
    href: "http://diamond.mariii.xyz:8080/api/wall/workshop.jpg",
    id: 1,
    price: 3,
  },
];

const toggleTheme = () => {
  theme.global.name.value = darkMode.value ? "customDarkTheme" : "customLightTheme";
  // Optional: Get value of current theme
  console.log(`Current theme is dark? ${theme.global.current.value.dark}`);
};

</script>

<style scoped>
.products {
  margin: 10%;
  gap: 50px;
}


</style>