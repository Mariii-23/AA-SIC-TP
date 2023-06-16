import axios, { AxiosInstance, AxiosResponse } from "axios";
import { App } from "vue";
import authentication from "./authentication";
import admins from "./admins";
import categories from "./categories";
import company from "./company";
import materials from "./materials";

interface AxiosOptions {
  baseUrl?: string;
  token?: string;
}

import { Response } from "@/appTypes/AxiosTypes";

let axiosInstance: AxiosInstance;

export const handleResponse = <T>(
  response: AxiosResponse<T>,
  successHandler: (data: T) => any
): Response<T> => {
  if (response.status === 200) {
    const data = successHandler ? successHandler(response.data) : response.data;
    return {
      success: 200,
      data,
    };
  } else {
    return {
      success: response.status,
      data: response.statusText,
    };
  }
};

export default {
  install: (app: App, options: AxiosOptions) => {
    axiosInstance = axios.create({
      baseURL: options.baseUrl,
      headers: {
        Authorization: options.token ? `Bearer ${options.token}` : "",
      },
    });

    axiosInstance.interceptors.response.use(
      (response) => {
        return response;
      },
      (error) => {
        axiosInstance.defaults.headers.Authorization = "";
        return Promise.reject(error);
      }
    );

    app.config.globalProperties.$axios = axiosInstance;
  },
  categories,
  authentication,
  admins,
  company,
  materials,
};
