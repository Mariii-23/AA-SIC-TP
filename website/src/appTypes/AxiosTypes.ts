import { OrderState } from "./Order";

export interface Response<T> {
  success: number;
  data: T | string;
}

export interface MaterialResponse {
  name: string;
  id: string;
}

export interface CategoryResponse {
  name: string;
  id: string;
}

export interface GetOrder {
  id: string;
  date: Date;
  total: number;
  state: OrderState;
  items: {
    id: string,
    name: string;
    price: string;
    quantity: number;
    materialId: string;
    productImageId: string;
  }[];
}

export interface GetAllOrders {
  last: boolean;
  data: {
    id: string;
    date: Date;
    total: number;
    state: OrderState;
  }[];
}

export interface GetProductsByCategoryResponse {
  last: boolean;
  data: {
    id: string;
    name: string;
    image: string;
    price: number;
  }[];
}

export interface AddProductResponse {
  id: string;
  name: string;
  image: string;
  price: number;
}

export interface SubCategoryResponse {
  name: string;
  id: string;
  categoryId: string;
}

export interface LoginResponse {
  token: string;
  email: string;
  name: string;
  iD: string;
  role: string;
}

export interface CompanyInfoResponse {
  name: string;
  email: string;
  contact: string;
  address: string;
  postCode: string;
  schedule: string;
}
export interface SocialNetWorkResponse {
  name: string;
  link: string;
}

export interface AddAdminResponse {
  iD: string;
  email: string;
  name: string;
}

export interface AddAdminResponse {
  iD: string;
  email: string;
  name: string;
}

export interface RegisterResponse {
  token: string;
  email: string;
  name: string;
  iD: string;
  role: string;
}

export interface CategoryResponse {
  id: string;
  name: string;
  subCategories: {
    id: string;
    name: string;
  }[];
}

export interface GetAllCategoriesResponse {
  last: boolean;
  data: CategoryResponse[];
}

export interface RegisterResponse {
  token: string;
  email: string;
  name: string;
  iD: string;
  role: string;
}

export interface GetAllCustomersResponse {
  last: boolean;
  data: {
    iD: string;
    email: string;
    name: string;
    birthday: Date;
    nif: string;
    address: string;
  }[];
}

export interface GetCustomerResponse {
    iD: string;
    email: string;
    name: string;
    birthday: Date;
    nif: string;
    address: string;
}


export interface GetAllAdminsResponse {
  last: boolean;
  data: {
    iD: string;
    email: string;
    name: string;
  }[];
}

export interface GetAllAdminsResponse {
  last: boolean;
  data: {
    iD: string;
    email: string;
    name: string;
  }[];
}

export interface ShoppingCart {
  total: number;
  items: {
    itemId: string;
    name: string;
    price: number;
    quantity: number;
    materialId: string;
    productImageId: string;
  }[];
}