import { defineStore } from "pinia";
import axios from "@/plugins/axios/axios";
import { Category, ImageProp, SubCategory } from "@/appTypes/Product";

export const useCategoriesStore = defineStore("categories", {
  state: () => ({
    categories: [] as Category[],
    category: {} as Category,
  }),
  actions: {
    async getAllCategories(offset: number, numItems: number) {
      const r = await axios.categories.getAllCategories(offset, numItems);
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
      return r.success == 200;
    },
    async removeSubCategory(subcategoryId: string, categoryId: string) {
      const r = await axios.categories.deleteSubcategory(subcategoryId);
      if (r.success == 200) {
        if (typeof r.data !== "string") {
          const category = this.categories.findIndex(
            (e) => e.id === categoryId
          );
          if (category >= 0) {
            this.categories[category].subCategories = this.categories[
              category
            ].subCategories.filter((e) => e.id !== subcategoryId);
          }
        }
      }
      return r.success == 200;
    },
    async addSubCategories(subcategory: ImageProp, categoryId: string) {
      const r = await axios.categories.addSubCategory(categoryId, subcategory);
      if (r.success == 200) {
        if (typeof r.data !== "string") {
          const category = this.categories.findIndex(
            (e) => e.id === categoryId
          );
          this.categories[category].subCategories.push(r.data);
        }
      }
      return r.success == 200;
    },
    async updateCategory(categoryId: string, name: string, photo: string ) {
      const r = await axios.categories.updateCategory(categoryId, name, photo);
      return r.success == 200;
    },
    async addCategory(name: string, photo: string, subCategories: ImageProp[]) {
      const r = await axios.categories.addCategory(name, photo);
      if (r.success == 200) {
        if (typeof r.data !== "string") {
          const categoryId = r.data.id;
          const subCategoriesProps = [] as SubCategory[];
          for (const item of subCategories) {
            const r2 = await axios.categories.addSubCategory(categoryId, item);
            if (typeof r2.data !== "string") {
              subCategoriesProps.push(r2.data);
            }
          }
          r.data.subCategories = subCategoriesProps;
          this.categories.push(r.data);
        }
      }
      return r.success == 200;
    },
    async getCategoryById(categoryId: string) {
      if (this.categories.length <= 0) {
        await this.getAllCategories(0, 10000);
      }

      const category = this.categories.find((e) => e.id == categoryId);
      if (category) this.category = category;

      // FIXME: no caso de nao ter tem q pedir ao backend
      return true;
    },
    async getNumberOfCategories() {
      const r = await axios.categories.getNumberOfCategories();
      if (r.success && typeof r.data !== "string") {
        return r.data;
      }
      return r.success;
    }

  },
});
