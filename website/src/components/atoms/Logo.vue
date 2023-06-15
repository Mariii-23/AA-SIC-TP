<template>
  <div id="app">
    <img :src="logo" alt="Logo" class="max-width" />
  </div>
</template>

<style>
.max-width {
  max-width: 100%;
}
</style>

<script lang="ts">
import { useCompanyStore } from "@/store/companyStore";

const companyStore = useCompanyStore();

export default {
  data: function () {
    let path = "";

    if (companyStore.logo == "") {
      path = companyStore.getLogoPath();
    }

    return {
      logo: path,
    };
  },
};
</script>
