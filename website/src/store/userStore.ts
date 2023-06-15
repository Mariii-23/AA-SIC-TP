import { defineStore } from "pinia";
import axios from "@/plugins/axios/axios";

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
        this.isLoggedIn = true;
        this.token = r.data.token;
        this.email = r.data.email;
        this.name = r.data.name;
        this.id = r.data.iD;
        this.role = r.data.role;
      }
    },
    async register(
      email: string,
      password: string,
      name: string,
      birthday: Date,
      nif: string,
      address: string
    ) {
      const r = await axios.authentication.register(
        email,
        password,
        name,
        birthday,
        nif,
        address
      );
      if (r.success) {
        this.isLoggedIn = true;
        this.token = r.data.token;
        this.email = r.data.email;
        this.name = r.data.name;
        this.id = r.data.iD;
        this.role = r.data.role;
      }
    },
    async update(name: string, email: string) {
      this.email = email;
      this.name = name;
    },
  },
});
