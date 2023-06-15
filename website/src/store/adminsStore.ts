import { defineStore } from "pinia";
import axios from "@/plugins/axios/axios";

export const useAdminsStore = defineStore("admins", {
  state: () => ({
    customers: [],
    admins: [],
  }),
  actions: {
    getCustomerById(id: string) {
      return this.customers.find((c) => c.id == id) ;
    },
    async getAllCustomers() {
      const r = await axios.admins.getAllCustomers(0, 100000);
      if (r.success) {
        this.customers = r.data;
      }
    },
    async getAllAdmins() {
      const r = await axios.admins.getAllAdmins(0, 100000);
      if (r.success) {
        this.admins = r.data;
      }
    },

    async removeAdmin(id: string) {
      const r = await axios.admins.removeAdmin(id);
      if (r.success) {
        this.admins = this.admins.filter((e) => e.id != id);
      }
      return r.success;
    },

    async addAdmin(email: string, password: string, name: string) {
      const r = await axios.admins.addAdmin(email, password, name);
      if (r.success) {
        this.admins.push(r.data);
      }
      return r.success;
    },
    async editAdmin(id: string, email: string, name: string) {
      const r = await axios.admins.updateAdmin(id, email, name);
      if (r.success) {
        this.getAllAdmins();
      }
      return r.success;
    },
  },
});
