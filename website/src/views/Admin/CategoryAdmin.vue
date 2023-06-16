<template>
  <Breadcrumbs :links="links" />
  <SimpleBodyLayout>
    <TitleWithButton
      :button-text="$t('addProduct')"
      :button-handler="addProductHandler"
      :title="category?.name"
    />

    <CategoriesAvatar
      :categories="category && category.subcategories"
      :click-handler="handleOnClickAvatar"
      :size="100"
    />

    <ProductPreviewAdminCards
      :products="products"
      :delete-product-handler="deleteProductHandler"
      :edit-product-handler="editProductHandler"
    />

    <Pagination
      length="10"
      total-visible="6"
      :handle-page-change="handlePageChange"
    />
  </SimpleBodyLayout>
</template>

<script lang="ts">
import Breadcrumbs from "@/components/molecules/Breadcrumbs.vue";
import SimpleBodyLayout from "@/layouts/Body/SimpleBodyLayout.vue";
import CategoriesAvatar from "@/components/organisms/AvatarList/CategoriesAvatar.vue";
import Pagination from "@/components/molecules/Pagination.vue";
import { CategoryProps } from "@/appTypes/Category";
import { LinkProps } from "@/appTypes/Link";
import ProductPreviewAdminCards from "@/components/organisms/Cards/ProductPreviewAdminCards.vue";
import { ProductAdminProps } from "@/appTypes/ProductAdminProps";
import TitleWithButton from "@/components/molecules/TitleWithButton.vue";

export default {
  name: "CategoryAdminPage",
  props: {
    products: {
      type: Array as () => ProductAdminProps[],
    },
    links: {
      type: Array as () => LinkProps[],
    },
    category: {
      type: Object as () => CategoryProps,
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
  },
  components: {
    Breadcrumbs,
    SimpleBodyLayout,
    CategoriesAvatar,
    Pagination,
    ProductPreviewAdminCards,
    TitleWithButton,
  },
};
</script>
