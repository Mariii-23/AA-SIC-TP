import { GetAllCategoriesResponse, Response } from "@/appTypes/AxiosTypes";
import { app } from "@/main";
import { handleResponse } from "./axios";
import { Category, SubCategory } from "@/appTypes/Product";

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
      const category = [] as Category[];

      data.data.forEach((categories) => {
        const subCategories: SubCategory[] = [];

        categories.subCategories.forEach((subCategory) => {
          subCategories.push({
            name: subCategory.name,
            id: subCategory.id,
            href: `${subCategoryImage}?categoryId=${categories.id}`,
          } as SubCategory);
        });

        category.push({
          id: categories.id,
          name: categories.name,
          href: `${categoryImage}?categoryId=${categories.id}`,
          subCategories: subCategories,
        } as Category);
      });

      return category;
    });
  } catch (error) {
    return {
      success: error.request.status,
      data: error.request.statusText,
    };
  }
};

const removeCategory = async (id: string) => {
  try {
    const req = await app.config.globalProperties.$axios.delete(
      `${url}/category/remove/${id}`
    );

    return handleResponse(req, (_) => {
      return null;
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
  deleteCategory: (id: string) => Promise<Response<void>>;
}

const categories: CategoriesAxios = {
  getAllCategories: async (offset: number, numberItems: number) => {
    return await getAllCategories(offset, numberItems);
  },
  deleteCategory: async (id: string) => {
    return await removeCategory(id);
  },
};

export default categories;