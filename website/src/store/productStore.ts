import { defineStore } from "pinia";
import axios from "@/plugins/axios/axios";
import { Product, ProductSimple, TechnicalInfo } from "@/appTypes/Product";

export const useProductStore = defineStore("products", {
  state: () => ({
    products: [] as ProductSimple[],
    productsFavorites: [] as ProductSimple[],
    product: {} as Product,
  }),
  actions: {
    async getAllFavoriteProducts(customerId: string) {
      let products = [] as ProductSimple[];
      const r = await axios.customer.getProductFavorites(customerId, 0, 100000);
      if (r && typeof r.data != "string") {
        products = r.data;
      }
      this.productsFavorites = products;
      return products;
    },

    async addRmvFavoriteProducts(customerId: string, productId: string) {
      const product = this.productsFavorites.find((e) => e.id === productId);
      if (product) {
        return await this.removeFavoriteProducts(customerId, productId);
      }
      return await this.addFavoriteProducts(customerId, productId);
    },
    async addFavoriteProducts(customerId: string, productId: string) {
      const r = await axios.customer.addProductFavorites(customerId, productId);
      if (r && typeof r.data != "string") {
        const product = this.products.find((e) => e.id == productId);
        if (product) {
          this.productsFavorites.push(product);
        }
      }
      return r.success === 200;
    },
    async removeFavoriteProducts(customerId: string, productId: string) {
      const r = await axios.customer.removeProductFavorites(
        customerId,
        productId
      );
      if (r && typeof r.data != "string") {
        this.productsFavorites = this.productsFavorites.filter(
          (e) => e.id != productId
        );
      }
      return r.success === 200;
    },
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
      const r = await axios.product.deleteProduct(id);
      if (r.success == 200) {
        if (typeof r.data != "string") {
          this.products = this.products.filter((e) => e.id !== id);
        }
      }


      return r.success == 200;
    },

    async addProduct(
      name: string,
      description: string,
      price: number,
      categoryId: string | null,
      subCategoryId: string | null,
      materialsId: string[],
      infos: TechnicalInfo[],
      images: string[]
    ) {
      const r = await axios.product.addProduct(
        name,
        description,
        price,
        categoryId,
        subCategoryId,
        materialsId,
        infos,
        images
      );

      if (r.success == 200 && typeof r.data != "string")
        this.products.push(r.data);

      return r.data;
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
      this.products = products;
      return products;
    },

    async getProductBySubCategoryId(subcategoryId: string) {
      let products = [] as ProductSimple[];
      const r = await axios.product.getProductBySubCategoryId(
        subcategoryId,
        0,
        100000
      );
      if (r && typeof r.data != "string") {
        products = r.data;
      }
      this.products = products;
      return products;
    },
  },
});
