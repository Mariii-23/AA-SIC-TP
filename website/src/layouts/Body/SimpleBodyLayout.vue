<template>
  <div class="simple-body-layout-wrapper">
    <slot />
  </div>
</template>

<style>
.simple-body-layout-wrapper {
 display: flex; 
 flex-direction: column;
  padding-left: 5%;
  padding-right: 5%;
  padding-top: 2%;
  padding-bottom: 2%;
  gap: 40px;
}
</style>
