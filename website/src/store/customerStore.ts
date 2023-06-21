import { defineStore } from "pinia";
import axios from "@/plugins/axios/axios";

export const useCustomerStore = defineStore("customer", {
  state: () => ({
    address: "",
    nif: "",
  }),
  actions: {
    async getUserById(id: string) {
      const r = await axios.customer.getCustomerById(id);
      if (r.success) {
        this.address = r.data.address;
        this.nif = r.data.nif;
        return r.data;
      }
      return null;
    },
    async editCustomer(
      id: string,
      name: string,
      email: string,
      address: string,
      nif: string,
      password: string
    ) {
      const r = await axios.customer.editCustomer(
        id,
        name,
        email,
        address,
        nif,
        password
      );

      return r.success == 200;
    },
    async update(address: string, nif: string) {
      if (address != "") this.address = address;
      if (nif != "") this.nif = nif;
    },
  },
});
