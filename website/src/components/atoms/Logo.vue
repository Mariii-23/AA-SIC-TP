<template>
  <div id="app">
    <v-img :src="logo" />
  </div>
</template>

<script lang="ts">
import logo from "@/images/logo.png"

export default {
  data: function () {
    return {
      //FIXME: Get logo
      logo: logo
    }
  }
}
</script>