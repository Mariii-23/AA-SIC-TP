import { defineStore } from "pinia";
import axios from "@/plugins/axios/axios";
import { Product, ProductSimple } from "@/appTypes/Product";

export const useProductStore = defineStore("products", {
  state: () => ({
    products: [] as ProductSimple[],
    product: {} as Product,
  }),
  actions: {
    async getAllProducts() {
      //const r = await axios.product.getAllProduct(0, 100000);
      //if (r.success == 200) {
      //  if (typeof r.data === "string") {
      //    this.products = [];
      //  } else {
      //    this.products = r.data;
      //  }
      //}
    },
    async removeProduct(id: string) {
      //const r = await axios.product.deleteProduct(id);
      //if (r.success == 200) {
      //  if (typeof r.data !== "string") {
      //    this.products = this.products.filter((e) => e.id !== id);
      //  }
      //}
      //return r.success == 200;
    },
    async getProductByCategoryId(categoryId: string) {
      let products = [] as ProductSimple[];
      const r = await axios.product.getProductByCategoryId(
        categoryId,
        0,
        100000
      );
      if (r && typeof r.data != "string") {
        products = r.data;
      }
      return products;
    },
  },
});
