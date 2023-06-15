import {
  LoginResponse,
  RegisterResponse,
  Response,
} from "@/appTypes/AxiosTypes";
import { app } from "@/main";

const url = "/api/v1/auth";

const login = async (email: string, password: string) => {
  try {
    const axios = app.config.globalProperties.$axios;
    const req = await axios.post(`${url}/login`, {
      email,
      password,
    });

    const token = req.data.token;
    console.log(token)

    axios.defaults.headers.Authorization = token ? `Bearer ${token}` : "";

    return {
      success: true,
      data: req.data,
    };
  } catch (error) {
    return {
      success: false,
      data: "forbidden",
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

    const token = req.data.token;

    axios.defaults.headers.Authorization = token ? `Bearer ${token}` : "";

    return {
      success: true,
      data: req.data,
    };
  } catch (error) {
    return {
      success: false,
      data: "forbidden",
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
  //   register: (username: string, password: string) => Promise<void>;
}

const authentication: Authentication = {
  login: async (username: string, password: string) => {
    return await login(username, password);
  },
  logout: () => {
    //TODO: Remover token
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
  //   register: async (username: string, password: string) => {
  //     await register(username, password);
  //   },
};

export default authentication;
