import { defineStore } from "pinia";
import axios from "@/plugins/axios/axios";

export const useCompanyStore = defineStore("company", {
  state: () => ({
    companyInfo: {
      name: "",
      email: "",
      contact: "",
      address: "",
      postCode: "",
      schedule: "",
    },
    socialNetworks: [],
  }),
  actions: {
    async getInfo() {
      const r = await axios.company.getInfo();
      if (r.success) {
        this.companyInfo = {
          name: r.data.name,
          email: r.data.email,
          contact: r.data.contact,
          address: r.data.address,
          postCode: r.data.postCode,
          schedule: r.data.schedule,
        };
      }

      const r2 = await axios.company.getSocialNetwork();

      if (r2.success) {
        this.socialNetworks = r2.data;
      }
    },
  },
});
