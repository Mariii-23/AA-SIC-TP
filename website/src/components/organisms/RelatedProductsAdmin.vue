<template>
  <v-sheet class="mx-auto" color="background">
    <v-slide-group
      v-model="model"
      class="slider pa-4"
      selected-class="bg-success"
      show-arrows
    >
      <v-slide-group-item v-for="product in products" :key="product.id">
        <ProductPreviewAdminCard
          class="product"
          :product="product"
          :editProductHandler="
            () => editProductHandler && editProductHandler(product.id)
          "
          :deleteProductHandler="
            () => deleteProductHandler && deleteProductHandler(product.id)
          "
        />
      </v-slide-group-item>
    </v-slide-group>
  </v-sheet>
</template>

<script lang="ts">
import { ProductSimple } from "@/appTypes/Product";
import ProductPreviewAdminCard from "./Card/ProductPreviewAdminCard.vue";

export default {
  data: () => ({
    model: null,
  }),
  components: {
    ProductPreviewAdminCard,
  },
  props: {
    products: Array as () => ProductSimple[],
    editProductHandler: {
      type: Function,
      required: true,
    },
    deleteProductHandler: {
      type: Function,
      required: true,
    },
  },
};
</script>

<style scoped>
.product {
  margin: 25px;
}
</style>
