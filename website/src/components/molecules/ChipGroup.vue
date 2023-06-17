<template>
  <v-chip-group color="primary">
    <v-chip v-for="prop in tags" v-bind:key="prop" variant="elevated" color="primary">
      {{ prop }}
    </v-chip>
  </v-chip-group>
</template>

<script lang="ts">
export default {
  name: "ChipGroups",
  props: {
    tags: {
      type: Array as () => string[],
    },
  },
};
</script>
