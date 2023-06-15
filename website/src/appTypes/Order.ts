export interface Order {
    id: number,
    date: string,
    total: number,
    state: string,
    orderItems: OrderItem[]
}

export interface OrderItem {
    name: string,
    price: number,
    quantity: number,
    img: string,
    material: string
}