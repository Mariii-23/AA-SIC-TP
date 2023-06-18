export interface Order {
    id: number,
    date: string,
    total: number,
    state: string,
    orderItems: OrderItem[]
}

export interface OrderItem {
    id: number,
    name: string,
    price: number,
    quantity: number,
    img: string,
    material: string
}

export interface OrderAdmin extends Order {
    user: number,
    email: string
}

export interface Cart {
    total: number,
    items: OrderItem[]
}