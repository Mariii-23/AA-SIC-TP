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
            }
        },
    }
});