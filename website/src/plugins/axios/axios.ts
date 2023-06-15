import axios, { AxiosInstance } from "axios";
import { App } from "vue";
import authentication from "./authentication";
import admins from "./admins";

interface AxiosOptions {
  baseUrl?: string;
  token?: string;
}

let axiosInstance: AxiosInstance;

export default {
  install: (app: App, options: AxiosOptions) => {
    axiosInstance = axios.create({
      baseURL: options.baseUrl,
      headers: {
        Authorization: options.token ? `Bearer ${options.token}` : "",
      },
    });

    app.config.globalProperties.$axios = axiosInstance;
  },
  authentication,
  admins,
};
