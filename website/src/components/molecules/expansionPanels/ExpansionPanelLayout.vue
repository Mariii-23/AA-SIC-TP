<template>
  <v-expansion-panel class="bg-secondary">
    <v-expansion-panel-title>  
      <div class="user-expansion-title-wrapper w-100">
        <slot name="title" />
      </div>
    </v-expansion-panel-title>
    <v-expansion-panel-text>
      <div class="user-expansion-text-wrapper">
        <slot name="text"/>
      </div>
    </v-expansion-panel-text>
  
  </v-expansion-panel>
</template>

<style>
.user-expansion-title-wrapper {
  display: flex;
  flex-direction: column;
  gap: 20px;
  margin-top: 10px;
  margin-bottom: 20px;
}

.user-expansion-text-wrapper {
  margin-top: 20px;
  display: flex;
  flex-direction: column;
}
</style>
