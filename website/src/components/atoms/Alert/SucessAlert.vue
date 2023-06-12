<template>
  <v-alert
    type="success"
    :title="title"
    :text="text"
    variant="tonal"
    closable
    close-label="Close Alert"
    class="small-alert"
  >
    <template v-slot:title>
      <div class="small-title">{{ title }}</div>
    </template>
  </v-alert>
</template>

<script lang="ts">
export default {
  props: {
    title: {
      type: String,
      require: true,
    },
    text: {
      type: String,
      require: true,
    },
  },
};
</script>

<style scoped>
.small-title {
  font-size: 14px;
}

.small-alert {
  padding: 8px 16px;
  font-size: 12px;
}
</style>
