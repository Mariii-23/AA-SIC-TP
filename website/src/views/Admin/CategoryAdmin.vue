<template>
  <SimpleBodyLayout>
    <TitleWithButton
      :button-text="$t('addProduct')"
      :button-handler="addProductHandler"
      :title="category.name"
    />

    <CategoriesAvatar
      :categories="category.subCategories"
      :click-handler="handleOnClickAvatar"
      :size="100"
    />

    <ProductPreviewAdminCards
      :products="products"
      :delete-product-handler="deleteProductHandler"
      :edit-product-handler="editProductHandler"
      :on-click-handler="onClickProduct"
    />

    <Pagination
      :length="length"
      total-visible="5"
      :handle-page-change="handlePageChange"
    />
  </SimpleBodyLayout>
</template>

<script lang="ts">
import SimpleBodyLayout from "@/layouts/Body/SimpleBodyLayout.vue";
import CategoriesAvatar from "@/components/organisms/AvatarList/CategoriesAvatar.vue";
import Pagination from "@/components/molecules/Pagination.vue";
import { LinkProps } from "@/appTypes/Link";
import ProductPreviewAdminCards from "@/components/organisms/Cards/ProductPreviewAdminCards.vue";
import TitleWithButton from "@/components/molecules/TitleWithButton.vue";
import { ProductSimple } from "@/appTypes/Product";
import { Category } from "@/appTypes/Product";

export default {
  name: "CategoryAdminPage",
  props: {
    products: {
      type: Array as () => ProductSimple[],
      required: true,
    },
    links: {
      type: Array as () => LinkProps[],
    },
    category: {
      type: Object as () => Category,
      required: true,
    },
    handlePageChange: {
      type: Function,
    },
    handleOnClickAvatar: {
      type: Function,
    },
    addProductHandler: {
      type: Function,
    },
    deleteProductHandler: {
      type: Function,
    },
    editProductHandler: {
      type: Function,
    }, 
     onClickProduct: {
      type: Function,
      required: true,
    },
    length: {
      type: Number,
      required: true,
    },
  },
  components: {
    SimpleBodyLayout,
    CategoriesAvatar,
    Pagination,
    ProductPreviewAdminCards,
    TitleWithButton,
  },
};
</script>
