<template>
  <SimpleBodyLayout>
    <HeadingText>{{ category.name }}</HeadingText>

    <CategoriesAvatar
      :categories="category.subCategories"
      :click-handler="handleOnClickAvatar"
      :size="100"
    />

    <ProductPreviewUserCards
      :products="productsUser"
      :view-more-handler="viewMoreHandler"
      :favorite-icon-handler="favoriteIconHandler"
      :on-click-handler="onClickProduct"
    />

    <Pagination
      length="10"
      total-visible="6"
      :handle-page-change="handlePageChange"
    />
  </SimpleBodyLayout>
</template>

<script lang="ts">
import SimpleBodyLayout from "@/layouts/Body/SimpleBodyLayout.vue";
import HeadingText from "@/components/atoms/Typography/HeadingText.vue";
import CategoriesAvatar from "@/components/organisms/AvatarList/CategoriesAvatar.vue";
import ProductPreviewUserCards from "@/components/organisms/Cards/ProductPreviewUserCards.vue";
import Pagination from "@/components/molecules/Pagination.vue";
import { LinkProps } from "@/appTypes/Link";
import { Category } from "@/appTypes/Product";
import { ProductSimple } from "@/appTypes/Product";
import { ProductUserProps } from "@/appTypes/ProductUserProps";

export default {
  name: "CategoryUserPage",
  data: () => ({
    productsUser: [] as ProductUserProps[],
  }),
  mounted() {
    this.productsUser = [];
    for (let i = 0; i < this.products.length; i++) {
      const item = this.products[i];
      const isFavorite = this.productsFavorite.find((e) => e.id == item.id);
      this.productsUser.push({
        favourite: isFavorite !== undefined,
        ...item,
      });
    }

    this.$watch(
      () => this.products,
      (newValues) => {
        this.productsUser = [];
        for (let i = 0; i < newValues.length; i++) {
          const item = newValues[i];
          const isFavorite = this.productsFavorite.find(
            (e) => e.id === item.id
          );
          this.productsUser.push({
            favourite: isFavorite !== undefined,
            ...item,
          });
        }
      }
    );

    this.$watch(
      () => this.productsFavorite,
      (newValues) => {

        this.productsUser = [];
        for (let i = 0; i < this.products.length; i++) {
          const item = this.products[i];
          const isFavorite = newValues.find((e) => e.id === item.id);
          this.productsUser.push({
            favourite: isFavorite !== undefined,
            ...item,
          });
        }
      }
    );
  },
  props: {
    products: {
      type: Array as () => ProductSimple[],
      required: true,
    },
    productsFavorite: {
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
      required: true,
    },
    handleOnClickAvatar: {
      type: Function,
      required: true,
    },
    viewMoreHandler: {
      type: Function,
      required: true,
    },
    favoriteIconHandler: {
      type: Function,
      required: true,
    },
    onClickProduct: {
      type: Function,
      required: true,
    }
  },
  components: {
    SimpleBodyLayout,
    HeadingText,
    CategoriesAvatar,
    ProductPreviewUserCards,
    Pagination,
  },
};
</script>
