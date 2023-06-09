<template>
  <div class="[`text-${breakpoint}-body-${size}`]">
    <slot />
  </div>
</template>

<script lang="ts">
export default {
  name: "BodyText",
  props: {
    size: {
      type: Number,
      default: 1,
      validator: (value: number) => [1, 2].includes(value),
    },
    breakpoint: {
      type: String,
      default: "sm",
      validator: (value: string) => ["sm", "md", "lg", "xl"].includes(value),
    },
  },
};
</script>