import { app } from "@/main";
import { handleResponse } from "./axios";
import { Material, Product, ProductSimple, TechnicalInfo } from "@/appTypes/Product";
import {
  AddProductResponse,
  GetProductById,
  GetProductsByCategoryResponse,
  Response,
} from "@/appTypes/AxiosTypes";

const url = "product";

const productImage = `http://localhost:8080/${url}/all/productImage`;
const materialImage = `http://localhost:8080/${url}/all/materialImage`;

//const getAllProducts = async (
//  categoryId: string,
//  offset: number,
//  numItems: number
//) => {
//  try {
//    const req = await app.config.globalProperties.$axios.get(
//      `${url}/all`,
//      {
//        params: {
//          offset,
//          numItems,
//          categoryId,
//        },
//      }
//    );
//
//    return handleResponse(req, (data: GetProductsByCategoryResponse) => {
//      return data.data;
//    });
//  } catch (error) {
//    return {
//      success: error.request.status,
//      data: error.request.statusText,
//    };
//  }
//};

const addProduct = async (
  name: string,
  description: string,
  price: number,
  categoryId: string | null,
  subCategoryId: string | null,
  materialIds: string[],
  infos: TechnicalInfo[],
  images: string[]
) => {
  try {
    const req = await app.config.globalProperties.$axios.post(`${url}/add`, {
      name,
      description,
      price,
      categoryId,
      subCategoryId,
      materialIds,
      infos,
      images,
    });

    return handleResponse(req, (data: AddProductResponse) => {
      return {
        name: data.name,
        id: data.id,
        href: `${productImage}?imageId=${data.image}`,
        price: data.price,
      };
    });
  } catch (error) {
    console.log(error);
    return {
      success: error.request.status,
      data: error.request.statusText,
    };
  }
};

const deleteProduct = async (productId: string) => {
  try {
    const req = await app.config.globalProperties.$axios.delete(
      `${url}/remove/${productId}`
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

const getProductById = async (productId: string) => {
  try {
    const req = await app.config.globalProperties.$axios.get(`${url}/all`, {
      params: {
        productId,
      },
    });

    return handleResponse(req, (data: GetProductById) => {
      const images = [] as string[];

      for (const item of data.images) {
        images.push(`${productImage}?imageId=${item}`);
      }

      const materials = [] as Material[];

      for (const material of data.materials) {
        materials.push({
          id: material.id,
          name: material.name,
          href: `${materialImage}?materialId=${material.id}`
        })
      }

      return {
        id: data.id,
        name: data.name,
        price: data.price,
        images,
        categoryId: data.categoryID,
        materials,
        information: {
          details: data.description,
          technical: data.technicalInfo,
        },
        reviews: data.reviews,
      } as Product;
    });
  } catch (error) {
    console.log(error)
    return {
      success: error.request.status,
      data: error.request.statusText,
    };
  }
};

const getProductByCategoryId = async (
  categoryId: string,
  offset: number,
  numItems: number
) => {
  try {
    const req = await app.config.globalProperties.$axios.get(
      `${url}/all/category`,
      {
        params: {
          offset,
          numItems,
          categoryId,
        },
      }
    );

    return handleResponse(req, (data: GetProductsByCategoryResponse) => {
      const products: ProductSimple[] = [];

      for (let i = 0; i < data.data.length; i++) {
        const item = data.data[i];
        products.push({
          name: item.name,
          id: item.id,
          href: `${productImage}?imageId=${item.image}`,
          price: item.price,
        });
      }
      return products;
    });
  } catch (error) {
    return {
      success: error.request.status,
      data: error.request.statusText,
    };
  }
};

const getProductBySubCategoryId = async (
  subCategoryId: string,
  offset: number,
  numItems: number
) => {
  try {
    const req = await app.config.globalProperties.$axios.get(
      `${url}/all/subcategory`,
      {
        params: {
          offset,
          numItems,
          subCategoryId,
        },
      }
    );

    return handleResponse(req, (data: GetProductsByCategoryResponse) => {
      const products: ProductSimple[] = [];

      for (let i = 0; i < data.data.length; i++) {
        const item = data.data[i];
        products.push({
          name: item.name,
          id: item.id,
          href: `${productImage}?imageId=${item.image}`,
          price: item.price,
        });
      }
      return products;
    });
  } catch (error) {
    return {
      success: error.request.status,
      data: error.request.statusText,
    };
  }
};

export interface ProductAxios {
  getProductByCategoryId: (
    categoryId: string,
    offset: number,
    numItems: number
  ) => Promise<Response<ProductSimple[]>>;
  getProductBySubCategoryId: (
    subCategoryId: string,
    offset: number,
    numItems: number
  ) => Promise<Response<ProductSimple[]>>;
  deleteProduct: (productId: string) => Promise<Response<void>>;
  getProductById: (productId: string) => Promise<Response<Product>>;
  addProduct: (
    name: string,
    description: string,
    price: number,
    categoryId: string | null,
    subCategoryId: string | null,
    materialsId: string[],
    infos: TechnicalInfo[],
    images: string[]
  ) => Promise<Response<ProductSimple>>;
}

const productStore: ProductAxios = {
  getProductByCategoryId: async (
    categoryId: string,
    offset: number,
    numItems: number
  ) => {
    return await getProductByCategoryId(categoryId, offset, numItems);
  },
  getProductBySubCategoryId: async (
    subCategoryId: string,
    offset: number,
    numItems: number
  ) => {
    return await getProductBySubCategoryId(subCategoryId, offset, numItems);
  },
  deleteProduct: async (productId) => {
    return deleteProduct(productId);
  },
  getProductById: async (productId) => {
    return getProductById(productId);
  },
  addProduct: async (
    name: string,
    description: string,
    price: number,
    categoryId: string | null,
    subCategoryId: string | null,
    materialsId: string[],
    infos: TechnicalInfo[],
    images: string[]
  ) => {
    return await addProduct(
      name,
      description,
      price,
      categoryId,
      subCategoryId,
      materialsId,
      infos,
      images
    );
  },
};

export default productStore;
