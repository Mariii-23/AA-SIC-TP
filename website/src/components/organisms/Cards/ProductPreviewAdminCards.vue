<template>
  <CardsLayout>
    <ProductPreviewAdmin
      v-for="product in products"
      :key="product.id"
      :product="product"
      :delete-product-handler="
        () => deleteProductHandler && deleteProductHandler(product.id)
      "
      :edit-product-handler="
        () => editProductHandler && editProductHandler(product.id)
      "
    />
  </CardsLayout>
</template>

<script lang="ts">
import { ProductSimple } from "@/appTypes/Product";
import ProductPreviewAdmin from "@/components/organisms/Card/ProductPreviewAdminCard.vue";
import CardsLayout from "@/layouts/CardsLayout.vue";

export default {
  components: {
    ProductPreviewAdmin,
    CardsLayout,
  },
  props: {
    products: {
      type: Array as () => ProductSimple[],
      require: true,
    },
    deleteProductHandler: {
      type: Function,
    },
    editProductHandler: {
      type: Function,
    },
  },
};
</script>
