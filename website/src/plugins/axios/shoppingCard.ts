import { app } from "@/main";
import { handleResponse } from "./axios";
import { Response, ShoppingCart } from "@/appTypes/AxiosTypes";
import { Cart, OrderItem } from "@/appTypes/Order";

const productImage = "http://localhost:8080/product/all/productImage";

const url = "/order";

const getShoppingCart = async (customerId: string) => {
    try {
        const req = await app.config.globalProperties.$axios.get(
            `${url}/customer/shoppingCart?id=${customerId}`);

        return handleResponse(req, (data: ShoppingCart) => {
            const orderItems = [] as OrderItem[];
            for (const item of data.items) {
                orderItems.push({
                    id: item.itemId,
                    name: item.name,
                    price: item.price,
                    quantity: item.quantity,
                    img: `${productImage}?imageId=${item.productImageId}`,
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
        console.log(error)
        return {
            success: error.request.status,
            data: error.request.statusText,
        };
    }
};

export interface ShoppingCardAxios {
    getShoppingCart: (
        customerId: string
    ) => Promise<Response<ShoppingCart>>;
}

const shoppingCard: ShoppingCardAxios = {
    getShoppingCart: async (customerId: string) => {
        return await getShoppingCart(customerId);
    }
};

export default shoppingCard;