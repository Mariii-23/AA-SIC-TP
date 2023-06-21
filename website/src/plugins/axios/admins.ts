import {
  AddAdminResponse,
  GetAllAdminsResponse,
  GetAllCustomersResponse,
  Response,
} from "@/appTypes/AxiosTypes";
import { app } from "@/main";
import { handleResponse } from "./axios";

const url = "/admin";

const getNumberOfAdmins = async () => {
  try {
    const req = await app.config.globalProperties.$axios.get(`${url}/numberOfAdmins`);
    return handleResponse(req, (data) => {
      return data;
    });
  } catch (error) {
    return {
      success: error.request.status,
      data: error.request.statusText,
    };  
  }
};

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
    });
  } catch (error) {
    return {
      success: error.request.status,
      data: error.request.statusText,
    };
  }
};

const getNumberOfCustomers = async () => {
  try {
    const req = await app.config.globalProperties.$axios.get(
      `${url}/numberOfCustomers`);
    return handleResponse(req, (data) => {
      return data;
    });
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
    });
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
    });
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
    return handleResponse(req, () => {
      return "";
    });
  } catch (error) {
    return {
      success: error.request.status,
      data: error.request.statusText,
    };
  }
};

const editAdmin = async (
  id: string,
  email: string,
  name: string,
  password: string
) => {
  try {
    let paramEmail, paramName, paramPassword;
    if (email == "") {
      paramEmail = null;
    } else {
      paramEmail = email;
    }
    if (name == "") {
      paramName = null;
    } else {
      paramName = name;
    }
    if (password == "") {
      paramPassword = null;
    } else {
      paramPassword = password;
    }

    const req = await app.config.globalProperties.$axios.post(
      `${url}/edit/${id}`,
      {
        email: paramEmail,
        name: paramName,
        password: paramPassword,
      }
    );

    return handleResponse(req, () => {
      return "";
    });
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
  getNumberOfCustomers: () => Promise<Response<number>>;
  getAllAdmins: (
    offset: number,
    numItems: number
  ) => Promise<Response<GetAllAdminsResponse>>;
  getNumberOfAdmins: () => Promise<Response<number>>;
  addAdmin: (
    email: string,
    password: string,
    name: string
  ) => Promise<Response<AddAdminResponse>>;
  removeAdmin: (id: string) => Promise<Response<string>>;
  updateAdmin: (
    id: string,
    email: string,
    name: string,
    password: string
  ) => Promise<Response<string>>;
}

const admin: AdminAxios = {
  getAllCustomers: async (offset: number, numberItems: number) => {
    return await getAllCustomers(offset, numberItems);
  },
  getNumberOfCustomers: async () => {
    return await getNumberOfCustomers();
  },
  getAllAdmins: async (offset: number, numberItems: number) => {
    return await getAllAdmins(offset, numberItems);
  },
  getNumberOfAdmins: async () => {
    return await getNumberOfAdmins();
  },
  addAdmin: async (email: string, password: string, name: string) => {
    return await addAdmin(email, password, name);
  },
  removeAdmin: async (id: string) => {
    return await removeAdmin(id);
  },
  updateAdmin: async (
    id: string,
    email: string,
    name: string,
    password: string
  ) => {
    return await editAdmin(id, email, name, password);
  },
};

export default admin;
