import { GetAllCategoriesResponse, Response } from "@/appTypes/AxiosTypes";
import { app } from "@/main";

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

    return {
      success: true,
      data: req.data.data,
    };
  } catch (error) {
    return {
      success: false,
      data: "forbidden",
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
