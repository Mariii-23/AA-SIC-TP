<template>
  <div class="two-columns">
    <div class="first">
      <slot name="first" />
    </div>
    <div class="second">
      <slot name="second" />
    </div>
  </div>
</template>

<style scoped>
.two-columns {
  display: grid;
  grid-template-columns: 25% 1fr;
  gap: 3%;
}

.first {
  position: sticky;
  top: 0;
  height: 50vh;
}

.second {
  overflow-y: auto;
  display: flex;
  flex-direction: column;
  gap: 10px;
}

@media (max-width: 800px) {
  .two-columns {
    grid-template-columns: 1fr;
    gap: 1%;
  }

  .first {
    top: auto;
    position: relative;
    height: auto;
  }
}
</style>
