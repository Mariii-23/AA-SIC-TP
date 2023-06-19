import { app } from "@/main";
import { handleResponse } from "./axios";
import { ProductSimple } from "@/appTypes/Product";
import { GetProductsByCategoryResponse, Response } from "@/appTypes/AxiosTypes";

const url = "product";

const productImage = `http://localhost:8080/${url}/all/productImage`;

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

const deleteProduct = async (productId: string) => {
  console.log()
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

export interface ProductAxios {
  getProductByCategoryId: (
    categoryId: string,
    offset: number,
    numItems: number
  ) => Promise<Response<ProductSimple[]>>;
  deleteProduct: (productId: string) => Promise<Response<void>>;
}

const productStore: ProductAxios = {
  getProductByCategoryId: async (
    categoryId: string,
    offset: number,
    numItems: number
  ) => {
    return await getProductByCategoryId(categoryId, offset, numItems);
  },
  deleteProduct: async (productId) => {
    return deleteProduct(productId);
  },
};

export default productStore;
