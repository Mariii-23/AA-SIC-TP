<template>
    <v-sheet  class="mx-auto" color="background">
        <v-slide-group v-model="model" class="slider pa-4" selected-class="bg-success" show-arrows>
            <v-slide-group-item 
            v-for="product in products"
            :key="product.id">
                <ProductPreviewUserCard class="product"
                :product="product"
                :favoriteIconHandler="() => favouriteIconHandler && favouriteIconHandler(product.id)" 
                :shoppingCartHandler="() => addToCartHandler && addToCartHandler(product.id)"
                />
            </v-slide-group-item>
        </v-slide-group>
    </v-sheet>
</template>

<script lang="ts">
import ProductPreviewUserCard from "./Card/ProductPreviewUserCard.vue"
import { ProductUserProps } from "@/appTypes/ProductUserProps";

export default {
    data: () => ({
        model: null,
    }),
    components: {
        ProductPreviewUserCard
    }, 
    props: {
        products: Array as () => ProductUserProps[],
        favouriteIconHandler: {
            type: Function,
            required: true,
        },
        addToCartHandler: {
            type: Function,
            required: true,
        },
    }
}
</script>

<style scoped>
.product {
    margin: 25px;
}
</style>