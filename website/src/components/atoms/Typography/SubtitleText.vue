<template>
  <div :class="[`text-subtitle-${size}`]">
    <slot />
  </div>
</template>

<script lang="ts">
export default {
  name: "SubtitleText",
  props: {
    size: {
      type: Number,
      default: 1,
      validator: (value: number) => [1, 2].includes(value),
    }
  },
};
</script>