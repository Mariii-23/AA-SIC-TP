<template>
  <div class="product-card-wrapper">
    <div class="first">
      <slot name="first" />
    </div>
    <div class="second">
      <slot name="second" />
    </div>
  </div>
</template>

<style scoped>
.product-card-wrapper {
  display: grid;
  grid-template-columns: 50% 1fr;
  gap: 3%;
}

.first {
  position: sticky;
  top: 0;
}

.second {
  overflow-y: auto;
  display: flex;
  flex-direction: column;
  padding: 2px;
  gap: 10px;
}

@media (max-width: 800px) {
  .product-card-wrapper {
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
