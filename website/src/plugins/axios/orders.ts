import {
  GetAllOrders,
  GetOrder,
  Response,
  GetAllAdminOrders,
} from "@/appTypes/AxiosTypes";
import { app } from "@/main";
import { handleResponse } from "./axios";
import { Order, OrderItem } from "@/appTypes/Order";

const productImage = "http://localhost:8080/product/all/productImage";

const url = "/order";

const getAllOrders = async (
  customerId: string,
  offset: number,
  numItems: number
) => {
  try {
    const req = await app.config.globalProperties.$axios.get(
      `${url}/customer/orders`,
      {
        params: {
          customerId,
          offset,
          numItems,
        },
      }
    );

    return handleResponse(req, (data: GetAllOrders) => {
      return data;
    });
  } catch (error) {
    return {
      success: error.request.status,
      data: error.request.statusText,
    };
  }
};

const setOrderReady = async (orderId: string) => {
  try {
    const req = await app.config.globalProperties.$axios.post(
      `${url}/admin/ready/${orderId}`
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

const setOrderDone = async (orderId: string) => {
  try {
    const req = await app.config.globalProperties.$axios.post(
      `${url}/admin/ready/${orderId}`
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

const getAllOrdersPending = async (offset: number, numItems: number) => {
  try {
    const req = await app.config.globalProperties.$axios.get(
      `${url}/admin/orders/pending`,
      {
        params: {
          offset,
          numItems,
        },
      }
    );

    return handleResponse(req, (data: GetAllAdminOrders) => {
      return data;
    });
  } catch (error) {
    return {
      success: error.request.status,
      data: error.request.statusText,
    };
  }
};

const getAllOrdersDone = async (offset: number, numItems: number) => {
  try {
    const req = await app.config.globalProperties.$axios.get(
      `${url}/admin/orders/done`,
      {
        params: {
          offset,
          numItems,
        },
      }
    );

    return handleResponse(req, (data: GetAllAdminOrders) => {
      return data;
    });
  } catch (error) {
    return {
      success: error.request.status,
      data: error.request.statusText,
    };
  }
};

const getAllOrdersReady = async (offset: number, numItems: number) => {
  try {
    const req = await app.config.globalProperties.$axios.get(
      `${url}/admin/orders/ready`,
      {
        params: {
          offset,
          numItems,
        },
      }
    );

    return handleResponse(req, (data: GetAllAdminOrders) => {
      return data;
    });
  } catch (error) {
    return {
      success: error.request.status,
      data: error.request.statusText,
    };
  }
};

const getOrderById = async (orderId: string) => {
  try {
    const req = await app.config.globalProperties.$axios.get(
      `${url}/customer/order`,
      {
        params: {
          orderId,
        },
      }
    );

    return handleResponse(req, (data: GetOrder) => {
      const orderItems = [] as OrderItem[];

      for (const item of data.items) {
        orderItems.push({
          id: item.id,
          name: item.name,
          price: item.price,
          quantity: item.quantity,
          href: `${productImage}?imageId=${item.productImageId}`,
          materialHref: `http://localhost:8080/product/all/materialImage?materialId=${item.materialId}`,
          materialId: item.materialId,
        });
      }

      const order: Order = {
        id: data.id,
        date: data.date,
        total: data.total,
        state: data.state,
        orderItems,
      };
      return order;
    });
  } catch (error) {
    console.log(error);
    return {
      success: error.request.status,
      data: error.request.statusText,
    };
  }
};

export interface OrdersAxios {
  setOrderDone: (
    orderId: string,
  ) => Promise<Response<null>>;
  setOrderReady: (
    orderId: string,
  ) => Promise<Response<null>>;
  getAllOrders: (
    customerId: string,
    offset: number,
    numItems: number
  ) => Promise<Response<GetAllOrders>>;
  getAllOrdersPending: (
    offset: number,
    numItems: number
  ) => Promise<Response<GetAllAdminOrders>>;
  getAllOrdersReady: (
    offset: number,
    numItems: number
  ) => Promise<Response<GetAllAdminOrders>>;
  getAllOrdersDone: (
    offset: number,
    numItems: number
  ) => Promise<Response<GetAllAdminOrders>>;
  getOrderId: (customerId: string) => Promise<Response<Order>>;
}

const orders: OrdersAxios = {
  setOrderDone: async (
    orderId: string,
  ) => {
    return await setOrderDone(orderId);
  },
  setOrderReady: async (
    orderId: string,
  ) => {
    return await setOrderReady(orderId);
  },
  getAllOrders: async (
    customerId: string,
    offset: number,
    numberItems: number
  ) => {
    return await getAllOrders(customerId, offset, numberItems);
  },
  getAllOrdersPending: async (offset: number, numberItems: number) => {
    return await getAllOrdersPending(offset, numberItems);
  },
  getAllOrdersDone: async (offset: number, numberItems: number) => {
    return await getAllOrdersDone(offset, numberItems);
  },
  getAllOrdersReady: async (offset: number, numberItems: number) => {
    return await getAllOrdersReady(offset, numberItems);
  },
  getOrderId: async (customerId: string) => {
    return await getOrderById(customerId);
  },
};

export default orders;
