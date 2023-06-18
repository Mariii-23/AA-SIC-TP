export interface ImageProp {
  name: string;
  photo: string;
}

export interface ProductDescriptionAdmin {
  name: string;
  id: string;
  price: number;
  materiais: Material[];
}

export interface SubCategory {
  id: string;
  name: string;
  href: string;
}

export interface Category {
  id: string;
  name: string;
  href: string;
  subCategories: SubCategory[];
}

export interface ProductDescriptionUser extends ProductDescriptionAdmin {
  favourite: boolean;
}

export interface TechnicalInfo {
  name: string;
  info: string;
}

export interface ProductInformation {
  details: string;
  technical: TechnicalInfo[];
}

export interface ProductImages {
  images: string[];
}

export interface Material {
  id: string;
  name: string;
  href: string;
}

export interface Item {
  id: string;
  name: string;
  href: string;
}

export interface Product {
  name: String;
  price: number;
  images: ProductImages;
  info: ProductInformation;
  materials: number[];
}
