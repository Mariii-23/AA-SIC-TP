<template>
  <v-btn type="submit" class="custom-full-width" color="primary bg-primary" @click="handleClick" value={{value}}>
    <ButtonText class="text-black">
      <slot />
    </ButtonText>
  </v-btn>
</template>

<style>
.custom-full-width {
  width: 100%;
}
</style>

<script lang="ts">
export default {
  props: {
    handleClick: {
      type: Function,
      required: true,
    },
    value: {
      type: String,
    },
  },
};
</script>