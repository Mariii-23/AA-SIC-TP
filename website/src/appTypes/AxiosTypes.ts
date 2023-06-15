export interface Response<T> {
  success: boolean;
  data: T | string;
}

export interface LoginResponse {
  token: string;
  email: string;
  name: string;
  iD: string;
  role: string;
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
  };
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
