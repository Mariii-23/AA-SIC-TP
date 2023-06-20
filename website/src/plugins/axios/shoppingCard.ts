import { app } from "@/main";
import { handleResponse } from "./axios";
import { Response, ShoppingCartResponse } from "@/appTypes/AxiosTypes";
import { Cart, OrderItem } from "@/appTypes/Order";

const productImage = "http://localhost:8080/product/all/productImage";

const url = "/order";

const getShoppingCart = async (customerId: string) => {
  try {
    const req = await app.config.globalProperties.$axios.get(
      `${url}/customer/shoppingCart?id=${customerId}`
    );

    return handleResponse(req, (data: ShoppingCartResponse) => {
      const orderItems = [] as OrderItem[];
      for (const item of data.items) {
        orderItems.push({
          id: item.itemId,
          name: item.name,
          price: item.price,
          quantity: item.quantity,
          href: `${productImage}?imageId=${item.productImageId}`,
          materialHref: `http://localhost:8080/product/all/materialImage?materialId=${item.materialId}`,
          materialId: item.materialId,
        });
      }

      const cart: Cart = {
        total: data.total,
        items: orderItems,
      };
      return cart;
    });
  } catch (error) {
    console.log(error);
    return {
      success: error.request.status,
      data: error.request.statusText,
    };
  }
};

const deleteItemFromShoppingCart = async (itemId: string) => {
  try {
    const req = await app.config.globalProperties.$axios.delete(
      `${url}/customer/shoppingCart/product/${itemId}`
    );

    return handleResponse(req, () => {
      return null;
    });
  } catch (error) {
    console.log(error);
    return {
      success: error.request.status,
      data: error.request.statusText,
    };
  }
};

const addItemFromShoppingCart = async (
  customerId: string,
  productId: string,
  materialId: string,
  quantity: number
) => {
  try {
    const req = await app.config.globalProperties.$axios.post(
      `${url}/customer/shoppingCart/product/`,
      {
        customerId,
        productId,
        materialId,
        quantity,
      }
    );

    return handleResponse(req, (data) => {
      return data;
    });
  } catch (error) {
    console.log(error);
    return {
      success: error.request.status,
      data: error.request.statusText,
    };
  }
};

const updateItemFromShoppingCart = async (itemId: string, quantity: number) => {
  try {
    const req = await app.config.globalProperties.$axios.post(
      `${url}/customer/shoppingCart/quantity`,
      {
        itemId,
        quantity,
      }
    );

    return handleResponse(req, () => {
      return null;
    });
  } catch (error) {
    console.log(error);
    return {
      success: error.request.status,
      data: error.request.statusText,
    };
  }
};

export interface ShoppingCardAxios {
  getShoppingCart: (customerId: string) => Promise<Response<Cart>>;
  deleteItem: (itemId: string) => Promise<Response<void>>;
  addItem: (
    customerId: string,
    productId: string,
    materialId: string,
    quantity: number
  ) => Promise<Response<string>>;
  updateItem: (itemId: string, quantity: number) => Promise<Response<void>>;
}

const shoppingCard: ShoppingCardAxios = {
  getShoppingCart: async (customerId: string) => {
    return await getShoppingCart(customerId);
  },
  deleteItem: async (itemId: string) => {
    return await deleteItemFromShoppingCart(itemId);
  },
  addItem: async (
    customerId: string,
    productId: string,
    materialId: string,
    quantity: number
  ) => {
    return await addItemFromShoppingCart(
      customerId,
      productId,
      materialId,
      quantity
    );
  },
  updateItem: async (itemId: string, quantity: number) => {
    return await updateItemFromShoppingCart(itemId, quantity);
  },
};

export default shoppingCard;
