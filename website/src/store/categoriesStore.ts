import { defineStore } from "pinia";
import axios from "@/plugins/axios/axios";
import { Category } from "@/appTypes/Product";

export const useCategoriesStore = defineStore("categories", {
  state: () => ({
    categories: [] as Category[],
  }),
  actions: {
    async getAllCategories() {
      const r = await axios.categories.getAllCategories(0, 100000);
      console.log(r);
      if (r.success == 200) {
        if (typeof r.data === "string") {
          this.categories = [];
        } else {
          this.categories = r.data;
        }
      }
    },
  },
});
