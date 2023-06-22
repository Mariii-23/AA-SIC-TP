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

export interface CategoryInfo {
  id: string;
  name: string;
  href: string;
}

export interface Category extends CategoryInfo {
  subCategories: SubCategory[];
}

export interface ProductDescriptionUser extends ProductDescriptionAdmin {
  favourite: boolean;
}

export interface TechnicalInfo {
  name: string;
  description: string;
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

export interface Image {
  id: string,
  href: string,
}

export interface Product {
  id: string;
  name: string;
  price: number;

  categoryId: string,

  images: Image[];

  information: ProductInformation;

  materials: Material[];

  reviews: Review[];
}

export interface Review {
  classification: number;
  comment: string;
  username: string;
}

export interface ProductAddCard extends ProductSimple {
  materialId: string;
}

export interface ProductSimple {
  id: string;
  name: string;
  price: number;
  href: string;
}
