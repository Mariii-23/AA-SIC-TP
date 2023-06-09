<template>
  <div :class="[`text-${breakpoint}-Caption`]">
    <slot/>
  </div>
</template>

<script lang="ts">
export default {
  name: "CaptionText",
  props: {
    breakpoint: {
      type: String,
      default: "sm",
      validator: (value: string) => ["sm", "md", "lg", "xl"].includes(value),
    },
  },
};
</script>