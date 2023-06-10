<template>
    <v-text-field class="search-bar"
     bg-color="secondary"
     :label= "$t('search')" 
     density="compact"
     single-line
     append-inner-icon="mdi-magnify"/>

</template>

<script setup lang="ts">

</script>

<style scoped>
.search-bar {
    width: 100%;
}
</style>