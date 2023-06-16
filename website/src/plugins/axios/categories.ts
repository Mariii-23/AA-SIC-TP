import { GetAllCategoriesResponse, Response } from "@/appTypes/AxiosTypes";
import { app } from "@/main";
import { handleResponse } from "./axios";

const url = "/product";

const getAllCategories = async (offset: number, numItems: number) => {
  try {
    const req = await app.config.globalProperties.$axios.get(
      `${url}/all/categories`,
      {
        params: {
          offset,
          numItems,
        },
      }
    );

    return handleResponse(req, (data: GetAllCategoriesResponse) => {
      return data.data;
    }) 
  } catch (error) {
    return {
      success: error.request.status,
      data: error.request.statusText,
    };
  }
};

export interface CategoriesAxios {
  getAllCategories: (
    offset: number,
    numItems: number
  ) => Promise<Response<GetAllCategoriesResponse>>;
}

const categories: CategoriesAxios = {
  getAllCategories: async (offset: number, numberItems: number) => {
    return await getAllCategories(offset, numberItems);
  },
};

export default categories;
