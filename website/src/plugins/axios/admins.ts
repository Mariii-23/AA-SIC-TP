import { GetAllCustomersResponse, Response } from "@/appTypes/AxiosTypes";
import { app } from "@/main";

const url = "/admin";

const getAllCustomers = async (offset: number, numItems: number) => {
  try {
    console.log(app.config.globalProperties.$axios.defaults.headers)
    const req = await app.config.globalProperties.$axios.get(
      `${url}/customer/all`,
      {
        params: {
            offset,
            numItems,
        },
      }
    );

    return {
      success: true,
      data: req.data.data,
    };
  } catch (error) {
    console.log("erro :",error);
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
}

const admin: AdminAxios = {
  getAllCustomers: async (offset: number, numberItems: number) => {
    return await getAllCustomers(offset, numberItems);
  },
};

export default admin;
