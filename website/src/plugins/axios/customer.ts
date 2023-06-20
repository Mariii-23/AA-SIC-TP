import { app } from "@/main";
import { handleResponse } from "./axios";
import { ProductSimple } from "@/appTypes/Product";
import { GetProductsByCategoryResponse, Response, GetCustomerResponse } from "@/appTypes/AxiosTypes";

const url = "/customer";

const productImage = "http://localhost:8080/product/all/productImage";

const addProductFavorites = async (customerId: string, productId: string) => {
  try {
    const req = await app.config.globalProperties.$axios.post(
      `${url}/favourite/add`,
      {
        customerId,
        productId,
      }
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

const removeProductFavorites = async (
  customerId: string,
  productId: string
) => {
  try {
    const req = await app.config.globalProperties.$axios.delete(
      `${url}/favourite/delete`,
      {
        data: {
          customerId,
          productId,
        },
      }
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

const getProductFavorites = async (
  id: string,
  offset: number,
  numItems: number
) => {
  try {
    const req = await app.config.globalProperties.$axios.get(
      `${url}/favourites`,
      {
        params: {
          offset,
          numItems,
          id,
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

const getCustomerById = async (id: string) => {
  try {
    const req = await app.config.globalProperties.$axios.get(
      `${url}`, {
      params: {
        id
      }
    }
    );
    return handleResponse(req, (data) => {
      return data;
    })
  }
  catch (error) {
    return {
      success: error.request.status,
      data: error.request.statusText,
    };
  }
};

const recoverPassword = async (email: string) => {
  try {
    const req = await app.config.globalProperties.$axios.post(
      `${url}/password/recover?email=${email}`);
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

const confirmRecoverPassword = async (code: string, password: string, id: string) => {
  try {
    const req = await app.config.globalProperties.$axios.post(
      `${url}/password/recover/confirm/${id}`, {
      token: code,
      newPassword: password,
    });
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

const editCustomer = async (id: string, name: string, email: string,
  address: string, nif: string, password: string) => {
  try {
    let paramName, paramEmail, paramAddress, paramNif, paramPassword;
    if (name == "") { paramName = null; } else { paramName = name; }
    if (email == "") { paramEmail = null; } else { paramEmail = email; }
    if (address == "") { paramAddress = null; } else { paramAddress = address; }
    if (nif == "") { paramNif = null; } else { paramNif = nif; }
    if (password == "") { paramPassword = null; } else { paramPassword = password; }

    const req = await app.config.globalProperties.$axios.post(
      `${url}/edit?customer_id=${id}`,
      {
        name: paramName,
        email: paramEmail,
        password: paramPassword,
        address: paramAddress,
        nif: paramNif,
      }
    );
    return handleResponse(req, (_) => {
      return "";
    })
  } catch (error) {
    return {
      success: error.request.status,
      data: error.request.statusText,
    };
  }
};

export interface CustomerAxios {
  getProductFavorites: (
    categoryId: string,
    offset: number,
    numItems: number
  ) => Promise<Response<ProductSimple[]>>;
  removeProductFavorites: (
    customerId: string,
    productId: string
  ) => Promise<Response<void>>;
  addProductFavorites: (
    customerId: string,
    productId: string
  ) => Promise<Response<void>>;
  getCustomerById: (
    id: string
  ) => Promise<Response<GetCustomerResponse>>;
  recoverPassword: (
    email: string
  ) => Promise<Response<String>>;
  confirmRecoverPassword: (
    code: string,
    password: string,
    id: string
  ) => Promise<Response<Boolean>>;
  editCustomer: (
    id: string,
    name: string,
    email: string,
    address: string,
    nif: string,
    password: string
  ) => Promise<Response<String>>;
}

const customer: CustomerAxios = {
  getProductFavorites: async (
    categoryId: string,
    offset: number,
    numItems: number
  ) => {
    return await getProductFavorites(categoryId, offset, numItems);
  },
  addProductFavorites: async (customerId: string, productId: string) => {
    return addProductFavorites(customerId, productId);
  },
  removeProductFavorites: async (customerId: string, productId: string) => {
    return removeProductFavorites(customerId, productId);
  },
  getCustomerById: async (id: string) => {
    return await getCustomerById(id);
  },
  recoverPassword: async (email: string) => {
    return await recoverPassword(email);
  },
  confirmRecoverPassword: async (code: string, password: string, id: string) => {
    return await confirmRecoverPassword(code, password, id);
  },
  editCustomer: async (id: string, name: string, email: string, address: string, nif: string, password: string) => {
    return await editCustomer(id, name, email, address, nif, password);
  },
};

export default customer;