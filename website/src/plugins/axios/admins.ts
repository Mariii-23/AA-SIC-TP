import {
  AddAdminResponse,
  GetAllAdminsResponse,
  GetAllCustomersResponse,
  Response,
} from "@/appTypes/AxiosTypes";
import { app } from "@/main";
import { handleResponse } from "./axios";

const url = "/admin";

const getAllAdmins = async (offset: number, numItems: number) => {
  try {
    const req = await app.config.globalProperties.$axios.get(`${url}/all`, {
      params: {
        offset,
        numItems,
      },
    });

    return handleResponse(req, (data: GetAllAdminsResponse) => {
      data.data.forEach((element) => {
        element.id = element.iD;
      });
      return data.data;
    }) 
  } catch (error) {
    return {
      success: error.request.status,
      data: error.request.statusText,
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

    return handleResponse(req, (data) => {
      data.data.forEach((element) => {
        element.id = element.iD;
      });
      return data.data;
    }) 
  } catch (error) {
    return {
      success: error.request.status,
      data: error.request.statusText,
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
    return handleResponse(req, (data) => {
      data.id = data.iD;
      return data;
    }) 
  } catch (error) {
    return {
      success: error.request.status,
      data: error.request.statusText,
    };
  }
};

const removeAdmin = async (id: string) => {
  try {
    const req = await app.config.globalProperties.$axios.delete(
      `${url}/remove/${id}`
    );
    return handleResponse(req, (_) => {
      return "";
    }) 
  } catch (error) {
    return {
      success: error.request.status,
      data: error.request.statusText,
    };
  }
};

const editAdmin = async (id: string, email: string, name: string) => {
  try {
    const req = await app.config.globalProperties.$axios.post(
      `${url}/edit/${id}`,
      {
        email,
        name,
        password: null,
      }
    );

    return handleResponse(req, (_) => {
      return "";
    }) 
  } catch (error) {
    return {
      success: error.request.status,
      data: error.request.statusText,
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
