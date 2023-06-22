<template>
  <CardsLayout>
    <ProductPreviewAdmin
      v-for="product in products"
      :key="product.id"
      :product="product"
      :delete-product-handler="
        () => deleteProductHandler && deleteProductHandler(product.id, product.name)
      "
      :edit-product-handler="
        () => editProductHandler && editProductHandler(product.id)
      "
      :onClick="onClickHandler"
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
      required: true,
    },
    deleteProductHandler: {
      type: Function,
    },
    editProductHandler: {
      type: Function,
    },    onClickHandler: {
      type: Function,
    },
  },
};
</script>
