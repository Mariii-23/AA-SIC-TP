export interface Company {
    name: string,
    address: string,
    postalCode: string,
    schedule: string,
    phoneNo: string,
    email: string,
    socialMedia: SocialMedia[]
}

export interface SocialMedia {
    name: string,
    link: string
}
