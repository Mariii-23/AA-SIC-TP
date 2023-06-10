<template>
  <div :class="[`text-Caption`]">
    <slot/>
  </div>
</template>

<script lang="ts">
export default {
  name: "CaptionText"
};
</script>