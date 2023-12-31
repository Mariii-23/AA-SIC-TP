import { defineStore } from "pinia";
import axios from "@/plugins/axios/axios";
import { Cart } from "@/appTypes/Order";
import { ProductAddCard } from "@/appTypes/Product";
import { useUserStore } from "./userStore";
import { useCustomerStore } from "./customerStore";

const userStore = useUserStore();
const customerStore = useCustomerStore();

export const useShoppingCartStore = defineStore("shoppingCart", {
  state: () => ({
    cart: {
      total: 0,
      items: [],
    } as Cart,
  }),
  actions: {
    async getShoppingCart(customerId: string) {
      const r = await axios.shoppingCard.getShoppingCart(customerId);
      if (r.success == 200 && typeof r.data !== "string") {
        this.cart = r.data;
      }
      return r.data;
    },

    async addProduct(
      product: ProductAddCard,
      quantity: number,
      customerId: string
    ) {
      this.cart.total += product.price;
      let id = "";

      if (userStore.isLoggedIn) {
        const r = await axios.shoppingCard.addItem(
          customerId,
          product.id,
          product.materialId,
          quantity
        );
        if (r.success === 200 && typeof r.data != "string") {
          id = r.data;
        }
      }

      if (id === "") {
        return false;
      }

      this.cart.items.push({
        id,
        name: product.name,
        price: product.price,
        href: product.href,
        quantity,
        materialId: product.id,
        materialHref: `http://localhost:8080/product/all/materialImage?materialId=${product.materialId}`,
      });
      return true;
    },

    async removeProduct(index: number) {
      const product = this.cart.items[index];

      if (userStore.isLoggedIn) {
        const r = await axios.shoppingCard.deleteItem(product.id);
        if (r.success != 200) return;
      }

      this.cart.items.splice(index, 1);
      this.cart.total -= product.price;
    },

    async updateProduct(index: number, quantity: number) {
      const product = this.cart.items[index];
      if (userStore.isLoggedIn) {
        const r = await axios.shoppingCard.updateItem(product.id, quantity);
        if (r.success != 200) return;
      }
      this.cart.items[index].quantity = quantity;
    },

    async buyShoppingCart() {
      const address = customerStore.address;
      if (userStore.isLoggedIn && address) {
        const customerId = userStore.id;
        const r = await axios.shoppingCard.buyShoppingCart(
          customerId,
          address,
          false
        );

        if(r.success == 200 && typeof r.data != "string") {
          return r.data.id;
        }
      }

      return null;
    },
  },
});
