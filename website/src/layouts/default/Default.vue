<template>
  <v-app>
    <app-drawer />

    <default-bar :key="$route.fullPath" />

    <default-view />

    <div v-if="!notShowFooter.includes($route.fullPath)">
      <default-footer />
    </div>
  </v-app>
</template>

<script lang="ts" setup>
import DefaultBar from "@/components/organisms/AppBar.vue";
import DefaultView from "./View.vue";
import DefaultFooter from "@/components/organisms/AppFooter.vue";
import AppDrawer from "@/components/organisms/AppDrawer.vue";
import { ref } from "vue";

const notShowFooter = ref(["/login", "/register"]);
</script>
