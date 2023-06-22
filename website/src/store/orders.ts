import { defineStore } from "pinia";
import axios from "@/plugins/axios/axios";
import { Order, OrderAdmin } from "@/appTypes/Order";
import { GetAllOrders, Response } from "@/appTypes/AxiosTypes";
import { useCustomerStore } from "@/store/customerStore";
const customerStore = useCustomerStore();

const num = 20;

export const useOrderStore = defineStore("orders", {
  state: () => ({
    myOrders: [] as Order[],
    ordersPending: [] as OrderAdmin[],
    ordersDone: [] as OrderAdmin[],
    ordersReady: [] as OrderAdmin[],
  }),
  actions: {
    async getNumberOfCustomerOrders(customerId: string) {
      const r = await axios.orders.getNumberOfCustomerOrders(customerId);
      if (r.success == 200 && typeof r.data != "string") {
        return r.data;
      }
      return r.success;
    },
    async getAllOrders(customerId: string, offset: number, numItems: number) {
      const r: Response<GetAllOrders> = await axios.orders.getAllOrders(
        customerId,
        offset,
        numItems
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
    async setOrderReady(orderId: string) {
      const r = await axios.orders.setOrderReady(orderId);

      if (r.success == 200) {
        const order = this.ordersPending.find((e) => e.id == orderId);
        if (order) {
          this.ordersReady.push(order);
          this.ordersPending = this.ordersPending.filter(
            (e) => e.id != orderId
          );
        }
      }
    },
    async setOrderDone(orderId: string) {
      const r = await axios.orders.setOrderDone(orderId);

      if (r.success == 200) {
        const order = this.ordersReady.find((e) => e.id == orderId);
        if (order) {
          this.ordersDone.push(order);
          this.ordersReady = this.ordersReady.filter(
            (e) => e.id != orderId
          );
        }
      }
    },
    async getAllOrdersPending() {
      const r: Response<GetAllOrders> = await axios.orders.getAllOrdersPending(
        0,
        num
      );

      const orders = [] as OrderAdmin[];

      if (r.success == 200 && typeof r.data != "string") {
        for (const item of r.data.data) {
          const r2 = await axios.orders.getOrderId(item.id);
          if (r2.success == 200 && typeof r2.data != "string") {
            const user = await customerStore.getUserById(item.customer_id);
            if (user) {
              orders.push({
                email: user.email,
                user: user.name,
                ...r2.data,
              });
            } else {
              orders.push({
                email: "",
                user: "",
                ...r2.data,
              });
            }
          }
        }
      }
      this.ordersPending = orders;
    },
    async getAllOrdersDone() {
      const r: Response<GetAllOrders> = await axios.orders.getAllOrdersDone(
        0,
        num
      );

      const orders = [] as OrderAdmin[];
      if (r.success == 200 && typeof r.data != "string") {
        for (const item of r.data.data) {
          const r2 = await axios.orders.getOrderId(item.id);
          if (r2.success == 200 && typeof r2.data != "string") {
            const user = await customerStore.getUserById(item.customer_id);
            if (user) {
              orders.push({
                email: user.email,
                user: user.name,
                ...r2.data,
              });
            }
          }
        }
      }
      this.ordersDone = orders;
    },
    async getAllOrdersReady() {
      const r: Response<GetAllOrders> = await axios.orders.getAllOrdersReady(
        0,
        num
      );

      const orders = [] as OrderAdmin[];
      if (r.success == 200 && typeof r.data != "string") {
        for (const item of r.data.data) {
          const r2 = await axios.orders.getOrderId(item.id);
          if (r2.success == 200 && typeof r2.data != "string") {
            const user = await customerStore.getUserById(item.customer_id);
            if (user) {
              orders.push({
                email: user.email,
                user: user.name,
                ...r2.data,
              });
            }
          }
        }
        this.ordersReady = orders;
      }
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
