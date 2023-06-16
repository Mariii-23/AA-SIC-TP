
export interface UserInfoProps {
    id: string,
    name: string,
    email: string,
    nif: string,
    address: string,
}

export interface AdminInfoProps {
    id: string;
    email: string;
    name: string;
}

export interface CustomerInfoProps {
    id: string;
    email: string;
    name: string;
    birthday: Date;
    nif: string;
    address: string;
}