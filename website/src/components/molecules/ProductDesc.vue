<template>
    <v-card color="secondary" class="card">
        <div class="header">
            <v-card-title>{{ product.name }}</v-card-title>
            <v-btn icon class="elevation-0" color="secondary">
                <v-icon size="30" v-if="product.favorite">mdi-heart</v-icon>
                <v-icon size="30" v-else>mdi-heart-outline</v-icon>
            </v-btn>
        </div>
        <div class="body">
            <HeadingText :size="6">{{ product.price }}€</HeadingText>

        materiais
        <div class="actions">
            <QuantityButton />
            <PrimaryButton>{{ $t("buy-now") }} </PrimaryButton>
        </div>
        <FullWidthButton class="btn"> {{ $t("add-cart") }} </FullWidthButton>

        </div>
        
    </v-card>
</template>

<script lang="ts">
import QuantityButton from "../atoms/Button/QuantityButton.vue";
import HeadingText from "../atoms/Typography/HeadingText.vue";
import PrimaryButton from "../atoms/Button/PrimaryButton.vue";
import FullWidthButton from "../atoms/Button/FullWidthButton.vue";
import { ProductUserProps } from "@/appTypes/ProductUserProps";

export default {
    name: "ProductDesc",
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
    components: { 
        HeadingText, 
        QuantityButton, 
        PrimaryButton, 
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