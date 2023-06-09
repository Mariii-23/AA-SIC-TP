<template>
  <div :class="[`text-${breakpoint}-overline`]">
    <slot/>
  </div>
</template>

<script lang="ts">
export default {
  name: "Overline",
  props: {
    breakpoint: {
      type: String,
      default: "sm",
      validator: (value: string) => ["sm", "md", "lg", "xl"].includes(value),
    },
  },
};
</script>