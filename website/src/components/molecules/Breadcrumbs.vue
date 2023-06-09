<template>
  <div class="bg-secondary">
    <v-breadcrumbs :items="links">
      <template v-slot:divider>
        <v-icon icon="mdi-chevron-right" />
      </template>
    </v-breadcrumbs>
  </div>
</template>

<script lang="ts">
export default {
  name: "Breadcrumbs",
  props: {
    links: {
      type: Array as () => String[],
      require: true,
    },
  },
};
</script>
