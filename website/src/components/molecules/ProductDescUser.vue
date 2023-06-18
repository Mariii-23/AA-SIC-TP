<template>
    <v-card color="secondary" class="card">
        <div class="header">
            <v-card-title>{{ product.name }}</v-card-title>
            <v-btn icon class="elevation-0" color="secondary" v-on:click="favouriteIconHandler">
                <v-icon size="30" v-if="product.favourite">mdi-heart</v-icon>
                <v-icon size="30" v-else>mdi-heart-outline</v-icon>
            </v-btn>
        </div>
        <div class="body">
            <HeadingText :size="6">{{ product.price }}€</HeadingText>

            <Material class="materials" 
                :materials="materials" 
                :selectMaterialHandler="selectMaterialHandler"
            />

            <div class="actions">
                <QuantityButton
                    :quantity="quantity"
                    :incrementHandler="() => incrementQuantityHandler && incrementQuantityHandler(product.id, quantity)"
                    :decrementHandler="() => decrementQuantityHandler && decrementQuantityHandler(product.id, quantity)"
                 />
                <PrimaryButton :handleClick="buyNowHandler">{{ $t("buy-now") }} </PrimaryButton>
            </div>
            <FullWidthButton class="btn" :handleClick="addToCartHandler"> {{ $t("add-cart") }} </FullWidthButton>

        </div>

    </v-card>
</template>

<script lang="ts">
import QuantityButton from "../atoms/Button/QuantityButton.vue";
import HeadingText from "../atoms/Typography/HeadingText.vue";
import PrimaryButton from "../atoms/Button/PrimaryButton.vue";
import FullWidthButton from "../atoms/Button/FullWidthButton.vue";
import { ProductDescriptionUser } from "@/appTypes/Product";
import Material from "../molecules/Materials.vue";
import { Materials } from "@/appTypes/Product";

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
        materials: {
            type: Array as () => Materials[],
            require: true,
        },
        addToCartHandler: {
            type: Function,
            require: true,
        },
        buyNowHandler: {
            type: Function,
            require: true,
        },
        favouriteIconHandler: {
            type: Function,
            require: true,
        },
        selectMaterialHandler: {
            type: Function,
            require: true,
        },
        quantity: {
            type: Number,
        },
        incrementQuantityHandler: {
            type: Function,
            require: true,
        },
        decrementQuantityHandler: {
            type: Function,
            require: true,
        },
    },
    components: {
        HeadingText,
        QuantityButton,
        PrimaryButton,
        FullWidthButton,
        Material
    }
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

.btn {
    margin-top: 10px;
    width: 100%;
}

.materials {
    padding: 0;
    margin-top: 10px;
    margin-bottom: 15px;
}
</style>