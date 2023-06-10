<template>
  <div :class="[`text-h${size}`]">
    <slot/>
  </div>
</template>

<script lang="ts">
export default {
  name: "HeadingText",

  props: {
    size: {
      type: Number,
      default: 4,
      validator: (value: number) => [1, 2, 3, 4, 5, 6].includes(value),
    }
  },
};
</script>