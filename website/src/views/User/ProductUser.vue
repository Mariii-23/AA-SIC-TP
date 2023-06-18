<template>
    <div>
        <div class="product">
            <div class="left-side">
                <Carousel :images="productImages" class="carousel" />
                <ProductInfo :info="productInfo" />
            </div>
            <div class="product-desc">
                <ProductDesc :product="productDesc" :materials="materials"
                    :addToCartHandler="() => addToCartHandler && addToCartHandler(productDesc.id)"
                    :buyNowHandler="() => buyNowHandler && buyNowHandler(productDesc.id)"
                    :favouriteIconHandler="() => favouriteIconHandler && favouriteIconHandler(productDesc.id)"
                    :selectMaterialHandler="selectMaterialHandler" :quantity="quantity"
                    :incrementQuantityHandler="incrementQuantityHandler"
                    :decrementQuantityHandler="decrementQuantityHandler" />
            </div>
        </div>

        <div class="related-products">
            <HeadingText :size="6">{{ $t("related-products") }}</HeadingText>
            <RelatedProducts :products="relatedProducts" :favouriteIconHandler="favouriteIconHandler"
                :addToCartHandler="addToCartHandler" />
        </div>
    </div>
</template>

<script lang="ts">
import Carousel from "@/components/molecules/Carousel.vue";
import ProductInfo from "@/components/molecules/ProductInfoUser.vue";
import ProductDesc from "@/components/molecules/ProductDescUser.vue";
import HeadingText from "@/components/atoms/Typography/HeadingText.vue";
import RelatedProducts from "@/components/organisms/RelatedProductsUser.vue";
import { ProductInformation, ProductImages } from "@/appTypes/Product";
import { Materials } from "@/appTypes/Product";

export default {
    props: {
        //relatedProducts: Array as () => ProductUserProps[],
        //productDesc: Object as () => ProductDescriptionUser,
        productInfo: Object as () => ProductInformation,
        productImages: Object as () => ProductImages,
        materials: {
            type: Array as () => Materials[],
            require: true,
        },

        //HANDLERS
        addToCartHandler: {
            type: Function,
            require: true,
        },
        buyNowHandler: {
            type: Function,
            require: true,
        },
        favouriteIconHandler: {
            type: Function,
            require: true,
        },
        selectMaterialHandler: {
            type: Function,
            require: true,
        },
        quantity: {
            type: Number,
            require: true,
        },
        incrementQuantityHandler: {
            type: Function,
            require: true,
        },
        decrementQuantityHandler: {
            type: Function,
            require: true,
        },

    },
    components: {
        Carousel,
        ProductInfo,
        ProductDesc,
        HeadingText,
        RelatedProducts
    },
    data() {
        return {
            productDesc: {
                name: "Product name",
                id: "8",
                price: 8,
                favourite: true,
            },
            relatedProducts: [
                {
                    id: "1",
                    name: "Product name 1",
                    price: 1,
                    href: "https://cdn.vuetifyjs.com/images/cards/hotel.jpg",
                    favourite: false,
                },
                {
                    id: "2",
                    name: "Product name 2",
                    price: 2,
                    href: "http://diamond.mariii.xyz:8080/api/wall/pleasant-lake.jpg",
                    favourite: false,
                },
                {
                    id: "3",
                    name: "Product name 3",
                    price: 3,
                    href: "https://cdn.vuetifyjs.com/images/cards/docks.jpg",
                    favourite: true,
                },
                {
                    id: "4",
                    name: "Product name 4",
                    price: 4,
                    href: "https://cdn.vuetifyjs.com/images/cards/sunshine.jpg",
                    favourite: false,
                },
                {
                    id: "5",
                    name: "Product name 5",
                    price: 5,
                    href: "https://cdn.vuetifyjs.com/images/cards/hotel.jpg",
                    favourite: true,
                },
                {
                    id: "6",
                    name: "Product name 6",
                    price: 6,
                    href: "http://diamond.mariii.xyz:8080/api/wall/pleasant-lake.jpg",
                    favourite: false,
                },
                {
                    id: "7",
                    name: "Product name 7",
                    price: 7,
                    href: "https://cdn.vuetifyjs.com/images/cards/docks.jpg",
                    favourite: false,
                }
            ]
        }
    }
};
</script>

<style scoped>
.product {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    margin-left: 10%;
    margin-right: 10%;
    margin-top: 50px;
}

.left-side {
    width: 50%;
}

.carousel {
    margin-bottom: 50px;
}

.product-desc {
    width: 40%;
}

.related-products {
    margin: 50px 10% 50px 10%;
    width: 80%;
}


@media screen and (max-width: 950px) {
    .product {
        flex-direction: column;
    }

    .product-desc {
        width: 100%;
        margin-top: 50px;
    }

    .left-side {
        width: 100%;
    }
}
</style>