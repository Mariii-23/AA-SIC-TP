<template>
  <v-carousel show-arrows="hover" :cycle="true">
    <v-carousel-item v-for="(image, i) in images" :key="i" :src="image" cover />
  </v-carousel>
</template>
<script lang="ts">
export default {
  props: {
    images: Object as () => string[],
  },
};
</script>
