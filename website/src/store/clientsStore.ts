import { defineStore } from "pinia";
import axios from "@/plugins/axios/axios";

export const useCustomersStore = defineStore("customers", {
  state: () => ({
    customers: []
  }),
  actions: {
    async getAllCustomers() {
      const r = await axios.admins.getAllCustomers(0,100000);
      if (r.success) {
        this.customers = r.data;
      }
    },
  },
});
