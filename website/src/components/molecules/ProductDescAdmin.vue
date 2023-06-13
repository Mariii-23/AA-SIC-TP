<template>
    <v-card color="secondary" class="card">
        <div class="header">
            <v-card-title>{{ product.name }}</v-card-title>
            <v-btn icon class="elevation-0" color="secondary">
                <v-icon size="30">mdi-pencil-outline</v-icon>
            </v-btn>
        </div>
        <div class="body">
            <HeadingText :size="6">{{ product.price }}€</HeadingText>

        materiais
        <FullWidthButton class="btn"> {{ $t("remove-product") }} </FullWidthButton>

        </div>
        
    </v-card>
</template>

<script lang="ts">
import HeadingText from "../atoms/Typography/HeadingText.vue";
import FullWidthButton from "../atoms/Button/FullWidthButton.vue";
import { ProductDescriptionUser } from "@/appTypes/Product";

export default {
    name: "ProductDesc",
    props: {
        product: {
            type: Object as () => ProductDescriptionUser,
            default: () => ({
                name: "Product name",
                price: 12.99,
                favorite: false,
                id: "-1"
            }),
        },
    },
    components: { 
        HeadingText, 
        FullWidthButton }
};
</script>

<style scoped>
.card {
    padding: 10px;
}
.header {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
}

.body {
    padding-bottom: 20px;
    padding-left: 20px;
    padding-right: 20px;
}

.actions {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    align-items: center
}

.btn{
    margin-top: 10px;
    width: 100%;
}
</style>