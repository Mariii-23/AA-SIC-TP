import { GetAllAdminsResponse, GetAllCustomersResponse, Response } from "@/appTypes/AxiosTypes";
import { app } from "@/main";

const url = "/admin";

const getAllAdmins = async (offset: number, numItems: number) => {
  try {
    const req = await app.config.globalProperties.$axios.get(
      `${url}/all`,
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

export interface AdminAxios {
  getAllCustomers: (
    offset: number,
    numItems: number
  ) => Promise<Response<GetAllCustomersResponse>>;
  getAllAdmins: (
    offset: number,
    numItems: number
  ) => Promise<Response<GetAllAdminsResponse>>;
}

const admin: AdminAxios = {
  getAllCustomers: async (offset: number, numberItems: number) => {
    return await getAllCustomers(offset, numberItems);
  },
  getAllAdmins: async (offset: number, numberItems: number) => {
    return await getAllAdmins(offset, numberItems);
  },
};

export default admin;
