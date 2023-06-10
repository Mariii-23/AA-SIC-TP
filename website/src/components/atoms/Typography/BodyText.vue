<template>
  <div :class="[`text-body-${size}`]">
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
   /* breakpoint: {
      type: String,
      default: "sm",
      validator: (value: string) => ["xs","sm", "md", "lg", "xl"].includes(value),
    },*/
  },
};
</script>