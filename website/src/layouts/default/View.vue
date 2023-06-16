<template>
  <v-main>
    <notifications />
    <router-view />
  </v-main>
</template>

<script lang="ts" setup>
import Notifications from "./Notifications.vue";
</script>
