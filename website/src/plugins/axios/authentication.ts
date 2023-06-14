import { LoginResponse, Response } from "@/appTypes/AxiosTypes";
import { app } from "@/main";

const url = "/api/v1/auth";

const login = async (email: string, password: string) => {
  try {
    const req = await app.config.globalProperties.$axios.post(`${url}/login`, {
      email,
      password,
    });

    return {
      success: true,
      data: req.data ,
    };
  } catch (error) {
    console.log(error)
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
  //   register: (username: string, password: string) => Promise<void>;
}

const authentication: Authentication = {
  login: async (username: string, password: string) => {
    return await login(username, password);
  },
  logout: () => {
    // app.config.globalProperties.$axios.updateToken("");
  },
  //   register: async (username: string, password: string) => {
  //     await register(username, password);
  //   },
};

export default authentication;
