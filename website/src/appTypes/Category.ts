export interface SubCategoryProps {
    name: string,
    id: string,
}

export type CategoryAvatarProps = SubCategoryProps ;

export interface CategoryProps {
    name: string,
    id: string,
    imgHref: string,
    subcategories: SubCategoryProps[]
}