<template>
  <CategoryAdmin
    v-if="isAdmin"
    v-bind:products="products"
    v-bind:category="category"
    :handle-on-click-avatar="handleOnClickAvatar"
    :handle-page-change="onChangePagePagination"
    :addProductHandler="addProductHandler"
  />

  <CategoryUser
    v-else
    v-bind:products="products"
    v-bind:category="category"
    :handle-on-click-avatar="handleOnClickAvatar"
    :handle-page-change="onChangePagePagination"
    :shopping-cart-handler="shoppingCartHandler"
    :favorite-icon-handler="favoriteIconHandler"
  />
</template>

<script lang="ts">
import CategoryUser from "./User/CategoryUser.vue";
import CategoryAdmin from "./Admin/CategoryAdmin.vue";
import { Category, ProductSimple } from "@/appTypes/Product";
import { useCategoriesStore } from "@/store/categoriesStore";
import { useProductStore } from "@/store/productStore";
import { useUserStore } from "@/store/userStore";

const categoriesStore = useCategoriesStore();
const productStore = useProductStore();
const userStore = useUserStore();

export default {
  name: "Category Page",
  data: function () {
    return {
      isAdmin: false,
      products: [] as ProductSimple[],
      category: {} as Category,
    };
  },
  mounted: async function () {
    await categoriesStore.getCategoryById(this.$route.params.id);
    this.category = categoriesStore.category;

    this.isAdmin = userStore.isAdmin();

    const r = await productStore.getProductByCategoryId(this.category.id);
    if (r) {
      this.products = r;
    }

    this.$watch(
      () => userStore.role,
      () => {
        this.isAdmin = userStore.isAdmin();
      }
    );

    this.$watch(
      () => this.$route.params.id,
      async (newValue) => {
        await categoriesStore.getCategoryById(newValue);
        this.category = categoriesStore.category;

        const r = await productStore.getProductByCategoryId(this.category.id);
        if (r) {
          this.products = r;
        }
      }
    );

    this.$watch(
      () => categoriesStore.category,
      async (newValue) => {
        this.category = newValue;
        const r = await productStore.getProductByCategoryId(this.category.id);
        if (r) {
          this.products = r;
        }
      }
    );
  },
  methods: {
    //TODO:
    onChangePagePagination(number: string) {
      console.log("page " + number);
    },

    //TODO:
    handleOnClickAvatar(number: string) {
      console.log(number);
    },

    //TODO:
    addProductHandler() {
      console.log("adicionar produto");
    },

    //TODO:
    deleteProductHandler(number: string) {
      console.log("delete " + number);
    },
    editProductHandler(productId: string) {
      console.log("edit " + productId);
    },
    shoppingCartHandler(productId: string) {
      console.log("add to shopping cart" + productId);
    },
    favoriteIconHandler(productId: string) {
      console.log("favourite " + productId);
    },
  },
  components: {
    CategoryAdmin,
    CategoryUser,
  },
};
</script>
