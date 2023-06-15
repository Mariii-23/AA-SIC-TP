export interface CompanyInfo {
    name: string,
    address: string,
    postCode: string,
    schedule: string,
    contact: string,
    email: string,
}
export interface Company extends CompanyInfo{
    socialMedia: SocialMedia[]
}

export interface SocialMedia {
    name: string,
    link: string
}
