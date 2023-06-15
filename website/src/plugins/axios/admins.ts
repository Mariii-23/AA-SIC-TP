import {
  AddAdminResponse,
  GetAllAdminsResponse,
  GetAllCustomersResponse,
  Response,
} from "@/appTypes/AxiosTypes";
import { app } from "@/main";

const url = "/admin";

const getAllAdmins = async (offset: number, numItems: number) => {
  try {
    const req = await app.config.globalProperties.$axios.get(`${url}/all`, {
      params: {
        offset,
        numItems,
      },
    });

    req.data.data.forEach((element) => {
      element.id = element.iD;
    });

    return {
      success: true,
      data: req.data.data,
    };
  } catch (error) {
    console.log("erro :", error);
    console.log(app.config.globalProperties.$axios.defaults.headers);
    return {
      success: false,
      data: "forbidden",
    };
  }
};

const getAllCustomers = async (offset: number, numItems: number) => {
  try {
    const req = await app.config.globalProperties.$axios.get(
      `${url}/customer/all`,
      {
        params: {
          offset,
          numItems,
        },
      }
    );

    req.data.data.forEach((element) => {
      element.id = element.iD;
    });

    return {
      success: true,
      data: req.data.data,
    };
  } catch (error) {
    console.log("erro :", error);
    console.log(app.config.globalProperties.$axios.defaults.headers);
    return {
      success: false,
      data: "forbidden",
    };
  }
};

const addAdmin = async (email: string, password: string, name: string) => {
  try {
    const req = await app.config.globalProperties.$axios.post(`${url}/add`, {
      email,
      name,
      password,
    });

    req.data.id = req.data.iD;

    return {
      success: true,
      data: req.data,
    };
  } catch (error) {
    console.log("erro :", error);
    console.log(app.config.globalProperties.$axios.defaults.headers);
    return {
      success: false,
      data: "forbidden",
    };
  }
};

const removeAdmin = async (id: string) => {
  try {
    await app.config.globalProperties.$axios.delete(`${url}/remove/${id}`);

    return {
      success: true,
      data: "",
    };
  } catch (error) {
    return {
      success: false,
      data: "forbidden",
    };
  }
};

const editAdmin = async (id: string, email: string, name: string) => {
  try {
    await app.config.globalProperties.$axios.post(`${url}/edit/${id}`, {
      email,
      name,
      password: null,
    });

    return {
      success: true,
      data: "",
    };
  } catch (error) {
    console.log("erro :", error);
    console.log(app.config.globalProperties.$axios.defaults.headers);
    return {
      success: false,
      data: "forbidden",
    };
  }
};

export interface AdminAxios {
  getAllCustomers: (
    offset: number,
    numItems: number
  ) => Promise<Response<GetAllCustomersResponse>>;
  getAllAdmins: (
    offset: number,
    numItems: number
  ) => Promise<Response<GetAllAdminsResponse>>;
  addAdmin: (
    email: string,
    password: string,
    name: string
  ) => Promise<Response<AddAdminResponse>>;
  removeAdmin: (id: string) => Promise<Response<string>>;
  updateAdmin: (
    id: string,
    email: string,
    name: string
  ) => Promise<Response<string>>;
}

const admin: AdminAxios = {
  getAllCustomers: async (offset: number, numberItems: number) => {
    return await getAllCustomers(offset, numberItems);
  },
  getAllAdmins: async (offset: number, numberItems: number) => {
    return await getAllAdmins(offset, numberItems);
  },
  addAdmin: async (email: string, password: string, name: string) => {
    return await addAdmin(email, password, name);
  },
  removeAdmin: async (id: string) => {
    return await removeAdmin(id);
  },
  updateAdmin: async (id: string, email: string, name: string) => {
    return await editAdmin(id, email, name);
  },
};

export default admin;
