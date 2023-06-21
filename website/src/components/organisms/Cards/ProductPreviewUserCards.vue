<template>
  <CardsLayout>
    <ProductPreviewUser
      v-for="product in products"
      :key="product.id"
      :product="product"
      :shopping-cart-handler="
        () => shoppingCartHandler && shoppingCartHandler(product.id)
      "
      :favorite-icon-handler="
        () => favoriteIconHandler && favoriteIconHandler(product.id)
      "
      :onClick="onClickHandler"
    />
  </CardsLayout>
</template>

<script lang="ts">
import { ProductUserProps } from "@/appTypes/ProductUserProps";
import ProductPreviewUser from "@/components/organisms/Card/ProductPreviewUserCard.vue";
import CardsLayout from "@/layouts/CardsLayout.vue";

export default {
  components: {
    ProductPreviewUser,
    CardsLayout,
  },
  props: {
    products: {
      type: Array as () => ProductUserProps[],
      required: true,
    },
    shoppingCartHandler: {
      type: Function,
    },
    favoriteIconHandler: {
      type: Function,
    },
    onClickHandler: {
      type: Function,
    },
  },
};
</script>
