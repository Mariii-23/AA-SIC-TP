import {
  LoginResponse,
  RegisterResponse,
  Response,
} from "@/appTypes/AxiosTypes";
import { app } from "@/main";

import { handleResponse } from "./axios";

const url = "/api/v1/auth";

const login = async (email: string, password: string) => {
  try {
    const axios = app.config.globalProperties.$axios;
    const req = await axios.post(`${url}/login`, {
      email,
      password,
    });

    return handleResponse(req, (data) => {
      const token = data.token;
      axios.defaults.headers.Authorization = token ? `Bearer ${token}` : "";
      return data;
    });
  } catch (error) {
    return {
      success: error.request.status,
      data: error.request.statusText,
    };
  }
};

const register = async (
  email: string,
  password: string,
  name: string,
  birthday: Date,
  nif: string,
  address: string
) => {
  try {
    const axios = app.config.globalProperties.$axios;
    const req = await axios.post(`${url}/register`, {
      email,
      password,
      name,
      birthday,
      nif,
      address,
    });

    return handleResponse(req, (data) => {
      const token = req.data.token;
      axios.defaults.headers.Authorization = token ? `Bearer ${token}` : "";
      return data;
    });
  } catch (error) {
    return {
      success: error.request.status,
      data: error.request.statusText,
    };
  }
};

export interface Authentication {
  login: (
    username: string,
    password: string
  ) => Promise<Response<LoginResponse>>;
  logout: () => void;
  register: (
    email: string,
    password: string,
    name: string,
    birthday: Date,
    nif: string,
    address: string
  ) => Promise<Response<RegisterResponse>>;
}

const authentication: Authentication = {
  login: async (username: string, password: string) => {
    return await login(username, password);
  },
  logout: () => {
    const axios = app.config.globalProperties.$axios;
    axios.defaults.headers.Authorization = "";
  },
  register: async (
    email: string,
    password: string,
    name: string,
    birthday: Date,
    nif: string,
    address: string
  ) => {
    return await register(email, password, name, birthday, nif, address);
  },
};

export default authentication;
