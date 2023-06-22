<template>
  <v-carousel show-arrows="hover" :cycle="true">
    <v-carousel-item v-for="(image, i) in images" :key="i" :src="image.href" cover />
  </v-carousel>
</template>
<script lang="ts">
import { Image } from "@/appTypes/Product";

export default {
  props: {
    images: Array as () => Image[],
  },
};
</script>
