import { defineStore } from "pinia";
import axios from "@/plugins/axios/axios";
import { useNotificationStore } from "./notificationStore";

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
    isAdmin() {
      if (this.isLoggedIn) {
        return this.role === "ADMIN";
      }
      return false;
    },
    async logout() {
      this.isLoggedIn = false;
      this.token = "";
      this.email = "";
      this.name = "";
      this.id = "";
      this.role = "";
      await axios.authentication.logout();
    },
    async login(username: string, password: string) {
      const r = await axios.authentication.login(username, password);
      if (r.success == 200 && typeof r.data !== "string") {
        this.isLoggedIn = true;
        this.token = r.data.token;
        this.email = r.data.email;
        this.name = r.data.name;
        this.id = r.data.iD;
        this.role = r.data.role;
      } else if (r.success == 401) {
        await axios.authentication.logout();
        const notificationStore = useNotificationStore();
        notificationStore.openErrorAlert("tokenInvalid");
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
      if (r.success == 200 && typeof r.data !== "string") {
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
