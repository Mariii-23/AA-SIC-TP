import { GetAllOrders, GetOrder, Response } from "@/appTypes/AxiosTypes";
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

const getOrderById = async (orderId: string) => {
  try {
    const req = await app.config.globalProperties.$axios.get(
      `${url}/customer/order`,{
        params: {
          orderId
        }
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
    console.log(error)
    return {
      success: error.request.status,
      data: error.request.statusText,
    };
  }
};

export interface OrdersAxios {
  getAllOrders: (
    customerId: string,
    offset: number,
    numItems: number
  ) => Promise<Response<GetAllOrders>>;
  getOrderId: (customerId: string) => Promise<Response<Order>>;
}

const orders: OrdersAxios = {
  getAllOrders: async (
    customerId: string,
    offset: number,
    numberItems: number
  ) => {
    return await getAllOrders(customerId, offset, numberItems);
  },
  getOrderId: async (customerId: string) => {
    return await getOrderById(customerId);
  },
};

export default orders;
