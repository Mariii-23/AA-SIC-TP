import { defineStore } from "pinia";
import axios from "@/plugins/axios/axios";
import { Product, ProductSimple, TechnicalInfo } from "@/appTypes/Product";
import { useNotificationStore } from "./notificationStore";

export const useProductStore = defineStore("products", {
  state: () => ({
    products: [] as ProductSimple[],
    productsFavorites: [] as ProductSimple[],
    product: {} as Product,
  }),
  actions: {
    async getNumberOfFavorites(customerId: string) {
      const r = await axios.customer.getNumberOfFavorites(customerId);
      if (r.success && typeof r.data !== "string") {
        return r.data;
      }
      return r.success;
    },
    async getAllFavoriteProducts(customerId: string, offset: number, numItems: number) {
      let products = [] as ProductSimple[];
      const r = await axios.customer.getProductFavorites(customerId, offset, numItems);
      if (r.success == 200 && typeof r.data != "string") {
        products = r.data;
      }
      this.productsFavorites = products;
      return products;
    },

    async addRmvFavoriteProducts(customerId: string, productId: string) {
      const product = this.productsFavorites.find((e) => e.id == productId);
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
      if (r.success == 200 && typeof r.data != "string") {
        this.productsFavorites = this.productsFavorites.filter(
          (e) => e.id !== productId
        );
      }
      return r.success === 200;
    },
    async getNumberOfProducts() {
      const r= await axios.product.getNumberOfProducts();
      if (r.success && typeof r.data !== "string") {
        return r.data;
      }
      return r.success;
    },
    async getAllProducts(offset: number, numItems: number) {
      const r = await axios.product.getProducts(offset, numItems);
      if (r.success == 200) {
        if (typeof r.data === "string") {
          this.products = [];
        } else {
          this.products = r.data;
        }
      }
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
    async getProduct(id: string) {
      const r = await axios.product.getProductById(id);
      if (r.success == 200) {
        if (typeof r.data != "string") {
          return r.data;
        }
      }

      return null;
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

    async getNumberOfProductsByCategoryId(categoryId: string) {
      const r = await axios.product.getNumberOfProductsByCategoryId(
        categoryId
      );
      if (r.success && typeof r.data !== "string") {
        return r.data;
      }
      return r.success;
    },
    async editProduct(
      productId: string,
      name: string,
      description: string,
      price: number,
      categoryId: string | null,
      subCategoryId: string | null,
      materialsId: string[],
      infos: TechnicalInfo[]
    ) {
      const r = await axios.product.editProduct(
        productId,
        name,
        description,
        price,
        categoryId,
        subCategoryId,
        materialsId,
        infos
      );

      if (r.success == 200 && typeof r.data != "string") {
        this.products = this.products.filter((e) => e.id != productId);
        this.products.push(r.data);
      }

      return r.data;
    },

    async getProductByCategoryId(categoryId: string, offset: number, numItems: number) {

      let products = [] as ProductSimple[];
      const r = await axios.product.getProductByCategoryId(
        categoryId,
        offset,
        numItems
      );
      if (r && typeof r.data != "string") {
        products = r.data;
      }
      this.products = products;
      return products;
    },

    async getNumberOfProductsBySubCategoryId(subcategoryId: string) {
      const r = await axios.product.getNumberOfProductsBySubCategoryId(
        subcategoryId
      );
      if (r.success && typeof r.data !== "string") {
        return r.data;
      }
      return r.success;
    },

    async getProductBySubCategoryId(subcategoryId: string, offset: number, numItems: number) {
      let products = [] as ProductSimple[];
      const r = await axios.product.getProductBySubCategoryId(
        subcategoryId,
        offset,
        numItems
      );
      if (r.success && typeof r.data != "string") {
        products = r.data;
      }
      this.products = products;
      return products;
    },

    async addImageProduct(productId: string, image: string) {
      const r = await axios.product.addImageProduct(productId, image);
      return r.success == 200;
    },

    async deteleImageProduct(productId: string, imageId: string) {
      const r = await axios.product.removeImageProduct(productId, imageId);
      return r && typeof r.data != "string";
    },
    async search (name: string) {
      const r = await axios.product.search(name);
      if (r.success && typeof r.data !== "string") {
        return r.data.id;
      }
      else if (r.success == 400){
        const notificationStore = useNotificationStore();
        notificationStore.openErrorAlert("no-results")
      }
      return r.success == 200;
    },
  },
});
