<template>
  <CardsLayout>
    <ProductPreviewUser
      v-for="product in products"
      :key="product.id"
      :product="product"
      :shopping-card-handler="() => shoppingCardHandler && shoppingCardHandler(product.id)"
      :favorite-icon-handler="() => favoriteIconHandler && favoriteIconHandler(product.id)"
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
      require: true,
    },
    shoppingCardHandler: {
      type: Function,
    },
    favoriteIconHandler: {
      type: Function,
    },
  },
};
</script>
