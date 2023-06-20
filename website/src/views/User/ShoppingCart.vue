<template>
    <SimpleBodyLayout>
        <ShoppingCartLayout>
            <template v-slot:first>
              <CartItemCards 
                :order-items="cart.items" 
                :incrementHandler="incrementHandler" 
                :decrementHandler="decrementHandler"
                :removeProductHandler="removeProductHandler"    
            />
            </template>
            <template v-slot:second>
                <CartTotalCard 
                    :cart="cart"
                    :makeOrder="makeOrder"
                    :cancelOrder="cancelOrder"
                />
            </template>
        </ShoppingCartLayout>
    </SimpleBodyLayout>
</template>

<script lang="ts">
import ShoppingCartLayout from "@/layouts/Body/ShoppingCartLayout.vue";
import SimpleBodyLayout from "@/layouts/Body/SimpleBodyLayout.vue";
import { Cart } from "@/appTypes/Order";
import CartItemCards from "@/components/organisms/Cards/CartItemCards.vue";
import CartTotalCard from "@/components/organisms/Card/CartTotalCard.vue";
import { useShoppingCartStore } from "@/store/shoppingCartStore";
import { useUserStore } from "@/store/userStore";

const shoppingCartStore = useShoppingCartStore();
const userStore = useUserStore();

export default {
    name: "ShoppingCart",
    data: () => ({
        cart: {} as Cart,
    }),
    mounted: async function () {
        if (userStore.isLoggedIn === false) {
            //TODO
        }
        await shoppingCartStore.getShoppingCart(userStore.id);
        this.cart = shoppingCartStore.cart;
    },
    methods: {
        incrementHandler (index: number) {
            this.cart &&
            this.cart.items &&
            this.cart.items[index] &&
            this.cart.items[index].quantity++;
        },
        decrementHandler (index: number) {
            this.cart &&
            this.cart.items &&
            this.cart.items[index];
            if (this.cart.items[index].quantity > 1) {
                this.cart.items[index].quantity--;
            }
        },
        removeProductHandler (index: number) {
            this.cart &&
            this.cart.items &&
            this.cart.items[index];
        },
        makeOrder () {
            console.log("make order");
        },
        cancelOrder () {
            this.$router.back()
        }
    },
    components: {
        ShoppingCartLayout,
        SimpleBodyLayout,
        CartItemCards,
        CartTotalCard
    },
}
</script>
