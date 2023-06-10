<template>
    <div :class="[`text-button`]">
        <slot/>
    </div>
</template>

<script lang="ts">
export default {
  name: "ButtonText"
};
</script>