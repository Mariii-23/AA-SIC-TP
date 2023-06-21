<template>
  <v-img
    :aspect-ratio="1"
    cover
    :src="href"
    :lazy-src="href"
    class="image"
  />
</template>

<script lang="ts">
export default {
  name: "Image Card",
  props: {
    href: {
      type: String,
      required: true,
    },
  },
};
</script>

<style scoped>
.image {
  border-radius: 5%;
}
</style>
