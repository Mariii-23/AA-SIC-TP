<template>
    <div :class="[`text-${breakpoint}-button`]">
        <slot/>
    </div>
</template>

<script lang="ts">
export default {
  name: "ButtonText",
  props: {
    breakpoint: {
      type: String,
      default: "sm",
      validator: (value: string) => ["sm", "md", "lg", "xl"].includes(value),
    },
  },
};
</script>