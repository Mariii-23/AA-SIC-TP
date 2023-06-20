import { defineStore } from "pinia";
import axios from "@/plugins/axios/axios";
import Cart from "@/appTypes/Cart";

export const useShoppingCartStore = defineStore("shoppingCart", {
    state: () => ({
        cart : {} as Cart,
    }),
    actions: {
        async getShoppingCart(customerId : string) {
            const r = await axios.order.getShoppingCart(customerId);
            if (r.success == 200 && typeof r.data !== "string") {
                this.cart = r.data;
            }
            return r.data;
        }
    }
});
