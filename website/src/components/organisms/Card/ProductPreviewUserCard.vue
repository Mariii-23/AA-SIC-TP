<template>
    <v-card width="175" :id="product.id">
        <v-card-item>
            <div class="imgContainer">
                <v-img cover :src="product.href" :lazy-src="product.href" class="image" />
            </div>
            <v-card-title>{{ product.name }}</v-card-title>
            <v-card-subtitle>{{ product.price }}€</v-card-subtitle>
        </v-card-item>

        <div class="actions">
            <v-btn icon class="action elevation-0">
                <v-icon>mdi-shopping-outline</v-icon>
            </v-btn>
            <v-btn icon class="action elevation-0">
                <v-icon v-if="product.favorite">mdi-heart</v-icon>
                <v-icon v-else>mdi-heart-outline</v-icon>
            </v-btn>
        </div>
    </v-card>
</template>

<script lang="ts">
import { ProductUserProps } from "@/appTypes/ProductUserProps";

export default {
    name: "ProductPreviewAdminCard",
    props: {
        product: {
            type: Object as () => ProductUserProps,
            default: () => ({
                name: "Product name",
                price: 12.99,
                favorite: false,
                href: "",
                id: "-1"
            }),
        },
    },
};
</script>

<style scoped>
.imgContainer {
    width: 150px;
    height: 150px;
}

.image {
    border-radius: 5%;
    width: 100%;
    height: 100%;
}

.actions {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
}
</style>
