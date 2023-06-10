<template>
  <v-app>
    <app-drawer />

    <default-bar :key="$route.fullPath" />

    <default-view />

    <default-footer />
  </v-app>
</template>

<script lang="ts" setup>
import DefaultBar from "@/components/organisms/AppBar.vue";
import DefaultView from "./View.vue";
import DefaultFooter from "@/components/organisms/AppFooter.vue";
import AppDrawer from "@/components/organisms/AppDrawer.vue";
</script>
