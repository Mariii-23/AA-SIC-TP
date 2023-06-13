<template>
  <v-text-field
    class="search-bar"
    :bg-color="bgColor"
    :label="$t('search')"
    density="compact"
    single-line
    append-inner-icon="mdi-magnify"
  />
</template>

<script lang="ts">
export default {
  name: "Search Bar",
  props: {
    bgColor: {
      type: String,
      default: "secondary",
    },
  },
};
</script>

<style scoped>
.search-bar {
  width: 100%;
}
</style>
