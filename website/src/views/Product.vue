<template>
  <ProductUser v-if="!isAdmin" :productImages="images"  :productInfo="info" />

  <ProductAdmin v-if="isAdmin" :productImages="images"  :productInfo="info" />
</template>

<script lang="ts" setup>
  import ProductUser from "./user/ProductUser.vue";
  import ProductAdmin from "./admin/ProductAdmin.vue";

  //TODO: change this
  const isAdmin = true;

  const images = [
  "https://cdn.vuetifyjs.com/images/cards/hotel.jpg",
  "http://diamond.mariii.xyz:8080/api/wall/pleasant-lake.jpg",
  "https://cdn.vuetifyjs.com/images/cards/docks.jpg",
  "https://cdn.vuetifyjs.com/images/cards/sunshine.jpg"
  ]

  const techInfo = [
    {
      name: "Altura",
      info: "100cm"
    },
    {
      name: "Largura",
      info: "80cm"
    },
    {
      name: "Profundidade",
      info: "70cm"
    }
  ]

  const details = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."

  const info = {
    details: details,
    technical: techInfo
  }

</script>