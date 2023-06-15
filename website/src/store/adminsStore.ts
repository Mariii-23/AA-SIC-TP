import { defineStore } from "pinia";
import axios from "@/plugins/axios/axios";

export const useAdminsStore = defineStore("admins", {
  state: () => ({
    customers: [],
    admins: []
  }),
  actions: {
    async getAllCustomers() {
      const r = await axios.admins.getAllCustomers(0,100000);
      if (r.success) {
        this.customers = r.data;
      }
    },
    async getAllAdmins() {
      const r = await axios.admins.getAllAdmins(0,100000);
      if (r.success) {
        this.admins = r.data;
      }
    },
  },
});
