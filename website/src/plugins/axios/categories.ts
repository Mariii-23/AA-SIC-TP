import { GetAllCategoriesResponse, Response } from "@/appTypes/AxiosTypes";
import { app } from "@/main";
import { handleResponse } from "./axios";
import { Category, Material, SubCategory } from "@/appTypes/Product";

const url = "/product";

const categoryImage = `http://localhost:8080${url}/all/categoryImage`;
const subCategoryImage = `http://localhost:8080${url}/all/subcategoryImage`;

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
      const materiais = [] as Material[];

      data.data.forEach((material) => {
        const subCategories: SubCategory[] = [];

        material.subCategories.forEach((subCategory) => {
          subCategories.push({
            name: subCategory.name,
            id: subCategory.id,
            href: `${subCategoryImage}?categoryId=${material.id}`,
          } as SubCategory);
        });

        materiais.push({
          id: material.id,
          name: material.name,
          href: `${categoryImage}?categoryId=${material.id}`,
          subCategories: subCategories,
        } as Material);
      });

      return materiais;
    });
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
  ) => Promise<Response<Category[]>>;
}

const categories: CategoriesAxios = {
  getAllCategories: async (offset: number, numberItems: number) => {
    return await getAllCategories(offset, numberItems);
  },
};

export default categories;
