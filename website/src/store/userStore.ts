import { defineStore } from "pinia";
import axios, { updateToken } from "@/plugins/axios/axios";

export const useUserStore = defineStore("user", {
  state: () => ({
    isLoggedIn: false,
    token: "",
    email: "",
    name: "",
    id: "",
    role: "",
  }),
  actions: {
    async login(username: string, password: string) {
      const r = await axios.authentication.login(username, password);
      if (r.success) {
        console.log(r.data.token);
        updateToken(r.data.token);
        this.isLoggedIn = true;
        this.token = r.data.token;
        this.email = r.data.email;
        this.name = r.data.name;
        this.id = r.data.iD;
        this.role = r.data.role;
      }
    },
  },
});
