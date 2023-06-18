<template>
    <SimpleBodyLayout>
        <ShoppingCartLayout>
            <template v-slot:first>
              <CartItemCards 
                :order-items="cart.items" 
                :incrementHandler="incrementHandler" 
                :decrementHandler="decrementHandler"/>
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

export default {
    name: "ShoppingCart",
    data: () => ({
        cart: Object as () => Cart,
    }),
    mounted: async function () {
        this.cart = {
            total: 500,
            items: [
            {
                id: 1,
                name: "Cadeira",
                quantity: 2,
                price: 100,
                img: "https://www.ikea.com/pt/pt/images/products/bergmund-cadeira-efeito-carvalho-hallarp-bege__0926594_pe789377_s5.jpg",
                material: "https://upload.wikimedia.org/wikipedia/commons/thumb/4/43/Red_flag.svg/1280px-Red_flag.svg.png"
            },
            {
                id: 2,
                name: "Cadeira2",
                quantity: 2,
                price: 100,
                img: "https://www.ikea.com/pt/pt/images/products/bergmund-cadeira-efeito-carvalho-hallarp-bege__0926594_pe789377_s5.jpg",
                material: "https://upload.wikimedia.org/wikipedia/commons/thumb/4/43/Red_flag.svg/1280px-Red_flag.svg.png"
            },
            {
                id: 3,
                name: "Cadeira3",
                quantity: 2,
                price: 100,
                img: "https://www.ikea.com/pt/pt/images/products/bergmund-cadeira-efeito-carvalho-hallarp-bege__0926594_pe789377_s5.jpg",
                material: "https://upload.wikimedia.org/wikipedia/commons/thumb/4/43/Red_flag.svg/1280px-Red_flag.svg.png"
            },
            {
                id: 4,
                name: "Cadeira4",
                quantity: 2,
                price: 100,
                img: "https://www.ikea.com/pt/pt/images/products/bergmund-cadeira-efeito-carvalho-hallarp-bege__0926594_pe789377_s5.jpg",
                material: "https://upload.wikimedia.org/wikipedia/commons/thumb/4/43/Red_flag.svg/1280px-Red_flag.svg.png"
            },
            {
                id: 5,
                name: "Cadeira5",
                quantity: 2,
                price: 100,
                img: "https://www.ikea.com/pt/pt/images/products/bergmund-cadeira-efeito-carvalho-hallarp-bege__0926594_pe789377_s5.jpg",
                material: "https://upload.wikimedia.org/wikipedia/commons/thumb/4/43/Red_flag.svg/1280px-Red_flag.svg.png"
            },
        ]};

    },
    methods: {
        incrementHandler (productid: number) {
            this.cart &&
            this.cart.items &&
            this.cart.items.forEach((item) => {
                if (item.id === productid) {
                    item.quantity++;
                }
            });
            console.log("increment " + productid);
        },
        decrementHandler (productid: number) {
            this.cart &&
            this.cart.items &&
            this.cart.items.forEach((item) => {
                if (item.id === productid) {
                    item.quantity--;
                }
            });
            console.log("decrement " + productid);
        },
        makeOrder () {
            console.log("make order");
        },
        cancelOrder () {
            console.log("cancel order");
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
