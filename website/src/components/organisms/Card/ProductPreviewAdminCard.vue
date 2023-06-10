<template>
    <CardLayout>
        <v-card-item>
            <div class="imgContainer">
                <v-img :src="product.href" :lazy-src="product.href" class="image" />
            </div>
            <v-card-title>{{ product.name }}</v-card-title>
            <v-card-subtitle>{{ product.price }}€</v-card-subtitle>
        </v-card-item>

        <div class="actions">
            <v-btn icon class="action elevation-0">
                <v-icon>mdi-trash-can-outline</v-icon>
            </v-btn>
            <v-btn icon class="action elevation-0">
                <v-icon>mdi-pencil-outline</v-icon>
            </v-btn>
        </div>
    </CardLayout>
</template>

<script lang="ts">
import { ProductAdminProps } from "@/appTypes/ProductAdminProps";
import CardLayout from "@/layouts/CardLayout.vue";

export default {
    name: "ProductPreviewAdmin",
    props: {
        product: {
            type: Object as () => ProductAdminProps,
            default: () => ({
                name: "Product name",
                price: 12.99,
                href: ""
            }),
        },
    },
    components: { CardLayout },
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
    background-color: aqua;
    object-fit: cover;
}

.actions {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
}
</style>
