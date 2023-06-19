import { ProductSimple } from "./Product";

export interface ProductUserProps extends ProductSimple {
  favourite: boolean;
}
