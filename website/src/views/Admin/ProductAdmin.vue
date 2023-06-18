<template>
    <div>
        <ConfirmationModal :title="$t('remove-product')" :text="$t('modal-remove-product') + ' ' + productDesc.name + '? '"
            :confirmHandler="deleteProductHandler" :closeModal="closeModal" :isModalOpen="isModalOpen" />

        <div class="product">
            <div class="left-side">
                <Carousel :images="productImages" class="carousel" />
                <ProductInfo :info="productInfo"
                    :editProductInfoHandler="() => editProductInfoHandler && editProductInfoHandler(productDesc.id)" />
            </div>
            <div class="product-desc">
                <ProductDesc :product="productDesc" :materials="materials" :addMaterialHandler="addMaterialHandler"
                    :selectMaterialHandler="selectMaterialHandler" :deleteProductHandler="openModal"
                    :editProductDescHandler="() => editProductDescHandler && editProductDescHandler(productDesc.id)" />
            </div>
        </div>

        <div class="related-products">
            <HeadingText :size="6">{{ $t("related-products") }}</HeadingText>
            <RelatedProducts :products="relatedProducts" :editProductHandler="editProductHandler"
                :deleteProductHandler="deleteProductHandler" />
        </div>
    </div>
</template>

<script lang="ts">
import Carousel from "@/components/molecules/Carousel.vue";
import ProductInfo from "@/components/molecules/ProductInfoAdmin.vue";
import ProductDesc from "@/components/molecules/ProductDescAdmin.vue";
import HeadingText from "@/components/atoms/Typography/HeadingText.vue";
import RelatedProducts from "@/components/organisms/RelatedProductsAdmin.vue";
import { ProductInformation, ProductImages, Materials } from "@/appTypes/Product";
import ConfirmationModal from "@/components/organisms/Modal/ConfirmationModal.vue";

export default {
    name: "ProductAdmin",
    data() {
        return {
            isModalOpen: false,
            productDesc: {
                name: "Product name",
                id: "8",
                price: 8,
            },
            relatedProducts: [
                {
                    id: "1",
                    name: "Product name 1",
                    price: 1,
                    href: "https://cdn.vuetifyjs.com/images/cards/hotel.jpg",
                },
                {
                    id: "2",
                    name: "Product name 2",
                    price: 2,
                    href: "http://diamond.mariii.xyz:8080/api/wall/pleasant-lake.jpg",
                },
                {
                    id: "3",
                    name: "Product name 3",
                    price: 3,
                    href: "https://cdn.vuetifyjs.com/images/cards/docks.jpg",
                },
                {
                    id: "4",
                    name: "Product name 4",
                    price: 4,
                    href: "https://cdn.vuetifyjs.com/images/cards/sunshine.jpg",
                },
                {
                    id: "5",
                    name: "Product name 5",
                    price: 5,
                    href: "https://cdn.vuetifyjs.com/images/cards/hotel.jpg",
                },
                {
                    id: "6",
                    name: "Product name 6",
                    price: 6,
                    href: "http://diamond.mariii.xyz:8080/api/wall/pleasant-lake.jpg",
                },
                {
                    id: "7",
                    name: "Product name 7",
                    price: 7,
                    href: "https://cdn.vuetifyjs.com/images/cards/docks.jpg",
                }
            ]
        }
    },
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
        deleteProductHandler: {
            type: Function,
            require: true,
        },
        editProductDescHandler: {
            type: Function,
            require: true,
        },
        editProductInfoHandler: {
            type: Function,
            require: true,
        },
        editProductHandler: {
            type: Function,
            require: true,
        },
        addMaterialHandler: {
            type: Function,
            require: true,
        },
        selectMaterialHandler: {
            type: Function,
            require: true
        }

    },
    methods: {
        openModal() {
            this.isModalOpen = true;
        },
        closeModal() {
            this.isModalOpen = false;
        },
    },
    components: {
        Carousel,
        ProductInfo,
        ProductDesc,
        HeadingText,
        RelatedProducts,
        ConfirmationModal
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