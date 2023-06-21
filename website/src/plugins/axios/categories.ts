import {
  CategoryResponse,
  GetAllCategoriesResponse,
  Response,
  SubCategoryResponse,
} from "@/appTypes/AxiosTypes";
import { app } from "@/main";
import { handleResponse } from "./axios";
import { Category, ImageProp, SubCategory } from "@/appTypes/Product";

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
            href: `${subCategoryImage}?subCategoryId=${subCategory.id}`,
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

    return handleResponse(req, () => {
      return null;
    });
  } catch (error) {
    return {
      success: error.request.status,
      data: error.request.statusText,
    };
  }
};

const deleteSubCategory = async (id: string) => {
  try {
    const req = await app.config.globalProperties.$axios.delete(
      `${url}/subcategory/remove/${id}`
    );

    return handleResponse(req, () => {
      return null;
    });
  } catch (error) {
    return {
      success: error.request.status,
      data: error.request.statusText,
    };
  }
};

const addCategoryInfo = async (name: string, image: string) => {
  try {
    const req = await app.config.globalProperties.$axios.post(
      `${url}/category`,
      {
        name,
        image,
      }
    );

    return handleResponse(req, (data: CategoryResponse) => {
      return {
        id: data.id,
        name: data.name,
        href: `${categoryImage}?categoryId=${data.id}`,
        subCategories: [],
      };
    });
  } catch (error) {
    return {
      success: error.request.status,
      data: error.request.statusText,
    };
  }
};

const updateCategoryInfo = async (id: string, name: string, image: string) => {
  try {
    const req = await app.config.globalProperties.$axios.post(
      `${url}/category/edit/${id}`,
      {
        name,
        image: image !== "" ? image : null,
      }
    );

    return handleResponse(req, (data: CategoryResponse) => {
      return {
        id: data.id,
        name: data.name,
        href: `${categoryImage}?categoryId=${data.id}`,
        subCategories: [],
      };
    });
  } catch (error) {
    return {
      success: error.request.status,
      data: error.request.statusText,
    };
  }
};

const addSubcategory = async (categoryId: string, subCategory: ImageProp) => {
  try {
    const req = await app.config.globalProperties.$axios.post(
      `${url}/subcategory`,
      {
        name: subCategory.name,
        image: subCategory.photo,
        categoryId,
      }
    );

    return handleResponse(req, (data: SubCategoryResponse) => {
      console.log(data);
      return {
        name: data.name,
        id: data.id,
        href: `${subCategoryImage}?subCategoryId=${data.id}`,
      };
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
  addCategory: (name: string, photo: string) => Promise<Response<Category>>;
  updateCategory: (
    id: string,
    name: string,
    photo: string
  ) => Promise<Response<void>>;
  deleteSubcategory: (id: string) => Promise<Response<void>>;
  addSubCategory: (
    categoryId: string,
    subCategory: ImageProp
  ) => Promise<Response<SubCategory>>;
}

const categories: CategoriesAxios = {
  getAllCategories: async (offset: number, numberItems: number) => {
    return await getAllCategories(offset, numberItems);
  },
  deleteCategory: async (id: string) => {
    return await removeCategory(id);
  },
  addCategory: async (name: string, photo: string) => {
    return await addCategoryInfo(name, photo);
  },
  updateCategory: async (id: string, name: string, photo: string) => {
    return await updateCategoryInfo(id, name, photo);
  },
  addSubCategory: async (categoryId: string, subCategory: ImageProp) => {
    return await addSubcategory(categoryId, subCategory);
  },
  deleteSubcategory: async (id: string) => {
    return await deleteSubCategory(id);
  },
};

export default categories;
