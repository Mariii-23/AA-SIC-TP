export interface ProductDescriptionAdmin {
    name: string,
    id: string,
    price: number,
    materiais: Materials[],
}

export interface ProductDescriptionUser extends ProductDescriptionAdmin {
    favourite: boolean,
}

export interface TechnicalInfo {
    name: string,
    info: string
}

export interface ProductInformation {
    details: string,
    technical: TechnicalInfo[]
}

export interface ProductImages {
    images: string[]
}

export interface Materials {
    id: string,
    name: string,
    href: string,
}