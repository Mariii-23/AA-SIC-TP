<template>
  <div class="product">
    <ProductLayout>
      <template v-slot:first>
        <Carousel :images="productImages" class="carousel" />
        <ProductInfo
          :info="productInfo"
          :editProductInfoHandler="
            () => editProductInfoHandler && editProductInfoHandler(product.id)
          "
        />
      </template>
      <template v-slot:second>
        <ProductDescAdmin
          :product="product"
          :materials="materials"
          :addMaterialHandler="addMaterialHandler"
          :selectMaterialHandler="selectMaterialHandler"
          :deleteProductHandler="openRemoveModal"
          :editProductDescHandler="
            () => editProductDescHandler && editProductDescHandler(product.id)
          "
        />
      </template>
    </ProductLayout>

    <div class="related-products">
      <HeadingText :size="6">{{ $t("related-products") }}</HeadingText>
      <RelatedProducts
        :products="relatedProducts"
        :editProductHandler="editProductHandler"
        :deleteProductHandler="openRemoveModal"
      />
    </div>
  </div>
</template>

<script lang="ts">
import Carousel from "@/components/molecules/Carousel.vue";
import ProductInfo from "@/components/molecules/ProductInfoAdmin.vue";
import ProductDescAdmin from "@/components/molecules/ProductDescAdmin.vue";
import HeadingText from "@/components/atoms/Typography/HeadingText.vue";
import RelatedProducts from "@/components/organisms/RelatedProductsAdmin.vue";
import {
  ProductInformation,
  Material,
  ProductSimple,
  Image,
} from "@/appTypes/Product";
import ProductLayout from "@/layouts/Body/ProductLayout.vue";

export default {
  name: "ProductAdmin",
  props: {
    relatedProducts: Array as () => ProductSimple[],
    product: {
      type: Object as () => ProductSimple,
      required: true,
    },
    productInfo: Object as () => ProductInformation,
    productImages: Array as () => Image[],
    materials: {
      type: Array as () => Material[],
      required: true,
    },

    //HANDLERS
    deleteProductHandler: {
      type: Function,
      required: true,
    },
    editProductDescHandler: {
      type: Function,
      required: true,
    },
    editProductInfoHandler: {
      type: Function,
      required: true,
    },
    editProductHandler: {
      type: Function,
      required: true,
    },
    addMaterialHandler: {
      type: Function,
      required: true,
    },
    selectMaterialHandler: {
      type: Function,
      required: true,
    },
    openRemoveModal: {
      type: Function,
      required: true,
    },
  },
  components: {
    Carousel,
    ProductInfo,
    ProductDescAdmin,
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

.carousel {
  margin-bottom: 50px;
}

.related-products {
  margin: 30px 5% 30px 5%;
}
</style>
