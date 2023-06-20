export interface Order {
    id: string,
    date: Date,
    total: number,
    state: OrderState,
    orderItems: OrderItem[]
}

export interface OrderItem {
    itemId: string,
    name: string,
    price: number,
    quantity: number,
    img: string,
    materialHref: string
    materialId: string
}

export interface OrderAdmin extends Order {
    user: string,
    email: string
}

export interface Cart {
    total: number,
    items: OrderItem[]
}

export enum OrderState {
    PENDING,
    READY,
    DONE
}