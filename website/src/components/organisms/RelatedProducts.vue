<template>
    <v-sheet  class="mx-auto" color="background">
        <v-slide-group v-model="model" class="slider pa-4" selected-class="bg-success" show-arrows>
            <v-slide-group-item 
            v-for="n in 15" :key="n" 
            v-slot="{ isSelected, toggle, selectedClass }">
                <ProductPreviewUserCard class="product"/>
            </v-slide-group-item>
        </v-slide-group>
    </v-sheet>
</template>

<script>
import ProductPreviewUserCard from './Card/ProductPreviewUserCard.vue'

export default {
    data: () => ({
        model: null,
    }),
    components: {
        ProductPreviewUserCard
    }
}
</script>

<style scoped>
.product {
    margin: 25px;
}
</style>