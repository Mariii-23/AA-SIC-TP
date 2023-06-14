<template>
  <v-carousel show-arrows="hover">
    <v-carousel-item
      v-for="(image,i) in images"
      :key="i"
      :src="image"
      cover
    />
  </v-carousel>
</template>
<script lang="ts">
import { ProductImages} from "@/appTypes/Product";

export default {
    props: {
        images: Object as () => ProductImages,
    },
  }
</script>
