import { defineStore } from "pinia";
import axios from "@/plugins/axios/axios";
import { CompanyInfo, SocialMedia } from "@/appTypes/Company";

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
    logo: "",
  }),
  actions: {
    getLogoPath() {
      return axios.company.getLogoLink();
    },
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
    async updateNetworkLinks(networkLinks: SocialMedia[]) {
      const r = await axios.company.updateNetworkLinks(networkLinks);
      if (r.success) {
        this.socialNetworks = r.data;
      }
      return r.success;
    },
    async updateInfo(company: CompanyInfo) {
      const r = await axios.company.updateInfo(company);

      if (r.success) {
        this.companyInfo = r.data;
      }
    },
  },
});
