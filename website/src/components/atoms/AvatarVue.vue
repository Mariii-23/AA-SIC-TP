<template>
  <v-avatar :image="href" :size="size" />
</template>

<script lang="ts">
export default {
  name: "AvatarVue",
  props: {
    href: {
      type: String,
      require: true,
    },
    size: {
      type: Number,
      default: 80,
    },
  },
};
</script>
