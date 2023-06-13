<template>
    <div class="product">
        <div class="left-side">
                <Carousel class="carousel" />
                <ProductInfo/>
        </div>
        <div class="product-desc">
            <ProductDesc />
        </div>
    </div>

    <div class="related-products">
        <HeadingText :size="6">{{ $t("related-products") }}</HeadingText>
        <RelatedProducts/>
    </div>
</template>

<script>
import Carousel from "@/components/molecules/Carousel.vue";
import ProductInfo from "@/components/molecules/ProductInfo.vue";
import ProductDesc from "@/components/molecules/ProductDesc.vue";
import HeadingText from "@/components/atoms/Typography/HeadingText.vue";
import RelatedProducts from '@/components/organisms/RelatedProducts.vue';

export default {
    components: {
        Carousel,
        ProductInfo,
        ProductDesc,
        HeadingText,
        RelatedProducts
    },
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
    }

    .left-side {
        width: 100%;
    }
}

</style>