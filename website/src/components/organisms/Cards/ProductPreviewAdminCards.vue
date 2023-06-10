<template>
    <CardsLayout>
        <ProductPreviewAdmin v-for="product in products" :key="product.id" :product="product" />
    </CardsLayout>
</template>

<script lang="ts">
import { ProductAdminProps } from "@/appTypes/ProductAdminProps";
import ProductPreviewAdmin from "@/components/organisms/Card/ProductPreviewAdminCard.vue";
import CardsLayout from "@/layouts/CardsLayout.vue";

export default {
    components: {
        ProductPreviewAdmin,
        CardsLayout,
    },
    props: {
        products: {
            type: Array as () => ProductAdminProps[],
            require: true,
        },
    },
};
</script>
