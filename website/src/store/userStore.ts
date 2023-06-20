import { defineStore } from "pinia";
import axios from "@/plugins/axios/axios";
import { useNotificationStore } from "./notificationStore";
import { useCustomerStore } from "./customerStore";

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
        if (this.role == "CUSTOMER") {
          const customerStore = useCustomerStore();
          customerStore.getUserById(this.id);
        }
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
      if (email != "") {
      this.email = email;
      }
      if (name != "") {
      this.name = name;
      }
    },
    async recoverPassword(email: string) {
      const r = await axios.customer.recoverPassword(email);
      if (r.success == 200) {
        this.id = r.data;
      }
      return r.success;
    },
    async confirmRecoverPassword(code: string, new_password: string) {
      const r = await axios.customer.confirmRecoverPassword(code, new_password, this.id);
      return r;
    },
  },
});
