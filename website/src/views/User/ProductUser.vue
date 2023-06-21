<template>
  <div class="product">
    <ProductLayout>
      <template v-slot:first>
        <Carousel :images="productImages" class="carousel" />
        <ProductInfo :info="productInfo" />
      </template>
      <template v-slot:second>
        <ProductDesc
          :product="product"
          v-bind:is-favourite="isFavourite"
          :materials="materials"
          :addToCartHandler="addToCartHandler"
          :buyNowHandler="buyNowHandler"
          :favouriteIconHandler="favouriteIconHandler"
          :selectMaterialHandler="selectMaterialHandler"
          v-bind:quantity="quantity"
          :incrementQuantityHandler="incrementQuantityHandler"
          :decrementQuantityHandler="decrementQuantityHandler"
        />
      </template>
    </ProductLayout>

    <div class="related-products" v-if="relatedProducts.length > 0">
      <HeadingText :size="6">{{ $t("related-products") }}</HeadingText>
      <RelatedProducts
        :products="relatedProducts"
        :favouriteIconHandler="favouriteIconHandler"
        :viewMoreHandler="viewMoreHandler"
      />
    </div>
  </div>
</template>

<script lang="ts">
import Carousel from "@/components/molecules/Carousel.vue";
import ProductInfo from "@/components/molecules/ProductInfoUser.vue";
import ProductDesc from "@/components/molecules/ProductDescUser.vue";
import HeadingText from "@/components/atoms/Typography/HeadingText.vue";
import RelatedProducts from "@/components/organisms/RelatedProductsUser.vue";
import { ProductInformation, ProductSimple } from "@/appTypes/Product";
import { Material } from "@/appTypes/Product";
import { ProductUserProps } from "@/appTypes/ProductUserProps";
import ProductLayout from "@/layouts/Body/ProductLayout.vue";

export default {
  name: "Product User",
  data() {
    return {
      isFavourite: false,
    };
  },
  mounted() {
    this.isFavourite =
      this.productsFavorite.find((e) => e.id == this.product.id) !== undefined;
    this.productsFavorite.find((e) => e.id == this.product.id);
    this.$watch(
      () => this.productsFavorite,
      (newValues) => {
        this.isFavourite =
          newValues.find((e) => e.id == this.product.id) !== undefined;
      }
    );
  },
  props: {
    relatedProducts: {
      type: Array as () => ProductUserProps[],
      required: true,
    },
    product: {
      type: Object as () => ProductSimple,
      required: true,
    },
    productsFavorite: {
      type: Array as () => ProductSimple[],
      required: true,
    },
    productInfo: {
      type: Object as () => ProductInformation,
      required: true,
    },
    productImages: {
      type: Array as () => string[],
      required: true,
    },
    materials: {
      type: Array as () => Material[],
      required: true,
    },

    //HANDLERS
    addToCartHandler: {
      type: Function,
      required: true,
    },
    buyNowHandler: {
      type: Function,
      required: true,
    },
    favouriteIconHandler: {
      type: Function,
      required: true,
    },
    selectMaterialHandler: {
      type: Function,
      required: true,
    },
    quantity: {
      type: Number,
      required: true,
    },
    incrementQuantityHandler: {
      type: Function,
      required: true,
    },
    decrementQuantityHandler: {
      type: Function,
      required: true,
    },
    viewMoreHandler: {
      type: Function,
      required: true,
    }
  },
  components: {
    Carousel,
    ProductInfo,
    ProductDesc,
    HeadingText,
    RelatedProducts,
    ProductLayout,
  },
};
</script>

<style scoped>
.product {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}

.related-products {
  margin: 30px 5% 30px 5%;
}
</style>
