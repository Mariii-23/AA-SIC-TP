<template>
  <Breadcrumbs :links="links" />
  <SimpleBodyLayout>
    <HeadingText>{{ category && category.name }}</HeadingText>

    <CategoriesAvatar
      :categories="category && category.subCategories"
      :click-handler="handleOnClickAvatar"
      :size="100"
    />

    <ProductPreviewUserCards
      :products="products"
      :shopping-cart-handler="shoppingCartHandler"
      :favorite-icon-handler="favoriteIconHandler"
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
import HeadingText from "@/components/atoms/Typography/HeadingText.vue";
import CategoriesAvatar from "@/components/organisms/AvatarList/CategoriesAvatar.vue";
import ProductPreviewUserCards from "@/components/organisms/Cards/ProductPreviewUserCards.vue";
import Pagination from "@/components/molecules/Pagination.vue";
import { CategoryProps } from "@/appTypes/Category";
import { ProductUserProps } from "@/appTypes/ProductUserProps";
import { LinkProps } from "@/appTypes/Link";

export default {
  name: "CategoryUserPage",
  props: {
    products: {
      type: Array as () => ProductUserProps[],
      require: true,
    },
    links: {
      type: Array as () => LinkProps[],
      require: true,
    },
    category: {
      type: Object as () => CategoryProps,
      require: true,
    },
    handlePageChange: {
      type: Function,
      require: true,
    },
    handleOnClickAvatar: {
      type: Function,
      require: true,
    },
    shoppingCartHandler: {
      type: Function,
    },
    favoriteIconHandler: {
      type: Function,
    },
  },
  components: {
    Breadcrumbs,
    SimpleBodyLayout,
    HeadingText,
    CategoriesAvatar,
    ProductPreviewUserCards,
    Pagination,
  },
};
</script>
