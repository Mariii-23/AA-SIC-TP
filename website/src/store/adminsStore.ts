import { defineStore } from "pinia";
import axios from "@/plugins/axios/axios";
import { AdminInfoProps, CustomerInfoProps } from "@/appTypes/User";
import { useNotificationStore } from "./notificationStore";

export const useAdminsStore = defineStore("admins", {
  state: () => ({
    customers: [] as CustomerInfoProps[],
    admins: [] as AdminInfoProps[],
  }),
  actions: {
    clearStore() {
      this.customers = []
      this.admins = []
    },
    getCustomerById(id: string) {
      return this.customers.find((c) => c.id == id);
    },
    async getNumberOfCustomers() {
      const r = await axios.admins.getNumberOfCustomers();
      if (r.success && typeof r.data !== "string") {
        return r.data;
      }
      return 0;
    },
    async getAllCustomers(offset: number, numItems: number) {
      const r = await axios.admins.getAllCustomers(offset, numItems);
      if (r.success && typeof r.data !== "string") {
        this.customers = r.data;
      }
    },
    async getNumberOfAdmins() {
      const r = await axios.admins.getNumberOfAdmins();
      if (r.success && typeof r.data !== "string") {
        return r.data;
      }
      return 0;
    },
    async getAllAdmins(offset: number, numItems: number) {
      const r = await axios.admins.getAllAdmins(offset, numItems);
      if (r.success && typeof r.data !== "string") {
        this.admins = r.data;
      }
    },

    async removeAdmin(id: string) {
      const r = await axios.admins.removeAdmin(id);
      if (r.success == 200 && typeof r.data !== "string") {
        this.admins = this.admins.filter((e) => e.id != id);
      }
      return r.success == 200;
    },

    async addAdmin(email: string, password: string, name: string) {
      const r = await axios.admins.addAdmin(email, password, name);
      if (r.success && typeof r.data !== "string") {
        this.admins.push(r.data);
      }
      return r.success == 200;
    },
    async editAdmin(id: string, email: string, name: string, password: string) {
      const r = await axios.admins.updateAdmin(id, email, name, password);
      if (r.success == 200) {
        this.getAllAdmins(0, 100000);
      }
      return r.success == 200;
    },
    async searchCustomers (name: string) {
      const r = await axios.admins.searchCustomers(name);
      if (r.success && typeof r.data !== "string") {
        return r.data;
      }
      else if (r.success == 400) {
        const notificationStore = useNotificationStore();
        notificationStore.openErrorAlert("no-results");
      }
      return r.success == 200;
    },
    async searchAdmins (name: string) {
      const r = await axios.admins.searchAdmins(name);
      if (r.success && typeof r.data !== "string") {
        return r.data;
      }
      else if (r.success == 400) {
        const notificationStore = useNotificationStore();
        notificationStore.openErrorAlert("no-results");
      }
      return r.success == 200;
    }
  },
});
