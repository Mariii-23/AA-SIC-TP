<template>
  <div :class="[`text-overline`]">
    <slot/>
  </div>
</template>

<script lang="ts">
export default {
  name: "Overline"
};
</script>