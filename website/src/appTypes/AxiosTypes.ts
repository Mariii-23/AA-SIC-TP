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

export interface GetAllCustomersResponse {
  last: boolean;
  data: {
    email: string;
    name: string;
    birthday: Date;
    nif: string;
    address: string;
  }[];
}
