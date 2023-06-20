import { defineStore } from "pinia";
import axios from "@/plugins/axios/axios";
import { Order } from "@/appTypes/Order";
import { GetAllOrders, Response } from "@/appTypes/AxiosTypes";

export const useOrderStore = defineStore("orders", {
  state: () => ({
    myOrders: [] as Order[],
  }),
  actions: {
    async getAllOrders(customerId: string) {
      const r: Response<GetAllOrders> = await axios.orders.getAllOrders(
        customerId,
        0,
        1000000
      );

      const orders = [] as Order[];
      if (r.success == 200) {
        for (const item of r.data.data) {
          const r2 = await axios.orders.getOrderId(item.id);
          if (r2.success == 200 && typeof r2.data != "string") {
            orders.push(r2.data);
          }
        }
      }

      this.myOrders = orders;
    },

    async getOrder(orderId: string) {
      const r = await axios.orders.getOrderId(orderId);
      if (r.success == 200 && typeof r.data != "string") {
        return r.data;
      }
      return null;
    },
  },
});
