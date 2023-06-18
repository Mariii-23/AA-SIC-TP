import { defineStore } from "pinia";
import axios from "@/plugins/axios/axios";
import { Category, ImageProp, SubCategory } from "@/appTypes/Product";

export const useCategoriesStore = defineStore("categories", {
  state: () => ({
    categories: [] as Category[],
  }),
  actions: {
    async getAllCategories() {
      const r = await axios.categories.getAllCategories(0, 100000);
      if (r.success == 200) {
        if (typeof r.data === "string") {
          this.categories = [];
        } else {
          this.categories = r.data;
        }
      }
    },
    async removeCategory(id: string) {
      const r = await axios.categories.deleteCategory(id);
      if (r.success == 200) {
        if (typeof r.data !== "string") {
          this.categories = this.categories.filter((e) => e.id !== id);
        }
      }
      return r.success;
    },
    async addCategory(name: string, photo: string, subCategories: ImageProp[]) {
      const r = await axios.categories.addCategory(name, photo);
      if (r.success == 200) {
        if (typeof r.data !== "string") {
          const categoryId = r.data.id;
          const subCategoriesProps = [] as SubCategory[];
          for (const item of subCategories) {
            const r2 = await axios.categories.addSubCategories(
              categoryId,
              item
            );
            if (typeof r2.data !== "string") {
              subCategoriesProps.push(r2.data);
            }
          }
          r.data.subCategories = subCategoriesProps;
          this.categories.push(r.data);
        }
      }
      return r.success;
    },
  },
});
