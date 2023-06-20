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
            <div v-if="cart.items && cart.items.length === 0">
                <BodyText>{{ $t("empty-cart") }}</BodyText>
            </div>
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
import BodyText from "@/components/atoms/Typography/BodyText.vue";

const shoppingCartStore = useShoppingCartStore();
const userStore = useUserStore();

export default {
  name: "ShoppingCart",
  data: () => ({
    cart: {} as Cart,
  }),
  mounted: async function () {
    if (userStore.isLoggedIn) {
      await shoppingCartStore.getShoppingCart(userStore.id);
      this.cart = shoppingCartStore.cart;
    }
    this.cart = shoppingCartStore.cart;

    this.$watch(
      () => shoppingCartStore.cart,
      (newValues) => {
        this.cart = newValues;
      }
    );
  },
  methods: {
    updateTotal() {
      this.cart.total = 0;

      if (this.cart.items) {
        for (const item of this.cart.items) {
          this.cart.total += item.quantity * item.price;
        }
      }
    },
    incrementHandler(index: number) {
      const quantity = this.cart.items[index].quantity;
      shoppingCartStore.updateProduct(index, quantity + 1);
      this.updateTotal();
    },
    decrementHandler(index: number) {
      const quantity = this.cart.items[index].quantity;
      if (quantity > 1) {
        shoppingCartStore.updateProduct(index, quantity - 1);
      } else if (quantity == 1) this.removeProductHandler(index);
      this.updateTotal();
    },
    removeProductHandler(index: number) {
      shoppingCartStore.removeProduct(index);
      this.updateTotal();
    },
    makeOrder() {
      this.updateTotal();
      console.log("make order");
    },
    cancelOrder() {
      this.$router.back();
      }
      },
    components: {
        ShoppingCartLayout,
        SimpleBodyLayout,
        CartItemCards,
        CartTotalCard,
        BodyText

    
};
</script>
