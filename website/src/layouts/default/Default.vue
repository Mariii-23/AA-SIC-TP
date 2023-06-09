<template>
  <v-app>
    <default-bar />

    <default-view />

    <default-footer />
  </v-app>
</template>

<script lang="ts" setup>
import DefaultBar from "@/components/organisms/AppBar.vue"
import DefaultView from "./View.vue"
import DefaultFooter from "@/components/organisms/AppFooter.vue"
</script>
