<template>
  <v-btn icon @click="onClick" class="bg-background elevation-0" :size="size">
    <AvatarVue :image="imageHref" :size="size" />
  </v-btn>
</template>

<script lang="ts">
import AvatarVue from "../atoms/AvatarVue.vue";

export default {
  name: "AvatarLink",
  props: {
    imageHref: {
      type: String,
      require: true,
    },
    size: {
      type: Number,
      default: 80,
    },
    onClick: {
      type: Function,
    },
  },
  components: { AvatarVue },
};
</script>
