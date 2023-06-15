import { defineStore } from "pinia";
import axios from "@/plugins/axios/axios";

export const useCategoriesStore = defineStore("categories", {
  state: () => ({
    categories: [],
  }),
  actions: {
    async getAllCategories() {
      const r = await axios.categories.getAllCategories(0, 100000);
      console.log(r)
      if (r.success) {
        this.categories = r.data;
      }
    },
  },
});
