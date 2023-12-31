<template>
  <ConfirmationModal :title="$t('rmv-product')" :text="$t('rmv-product-text') + ' ' + productName + '?'"
    :confirmHandler="deleteProductHandler" :closeModal="closeRemoveModal" v-bind:is-modal-open="isRemoveModalOpen" />

  <div v-if="products.length == 0">
    <v-progress-linear indeterminate />
  </div>

  <CategoryAdmin v-if="isAdmin" v-bind:products="products" v-bind:category="category"
    :handle-on-click-avatar="handleOnClickAvatar" :handle-page-change="onChangePagePagination"
    :addProductHandler="addProductHandler" :edit-product-handler="editProductHandler"
    :delete-product-handler="openRemoveModal" :on-click-product="onClickProductUser" :length="length" />

  <CategoryUser v-else v-bind:products="products" v-bind:products-favorite="productsFavorite" v-bind:category="category"
    :handle-on-click-avatar="handleOnClickAvatar" :handle-page-change="onChangePagePagination"
    :view-more-handler="viewMoreHandler" :favorite-icon-handler="favoriteIconHandler"  :length="length"
    :on-click-product="onClickProductUser" />
</template>

<script lang="ts">
import CategoryUser from "./User/CategoryUser.vue";
import CategoryAdmin from "./Admin/CategoryAdmin.vue";
import { Category, ProductSimple } from "@/appTypes/Product";
import { useCategoriesStore } from "@/store/categoriesStore";
import { useProductStore } from "@/store/productStore";
import { useUserStore } from "@/store/userStore";
import { useNotificationStore } from "@/store/notificationStore";
import ConfirmationModal from "@/components/organisms/Modal/ConfirmationModal.vue";

const categoriesStore = useCategoriesStore();
const productStore = useProductStore();
const userStore = useUserStore();
const notificationStore = useNotificationStore();

export default {
  name: "Category Page",
  data: function () {
    return {
      isAdmin: false,
      products: [] as ProductSimple[],
      productsFavorite: [] as ProductSimple[],
      category: {} as Category,
      categoryId: "",
      isRemoveModalOpen: false,
      productId: "",
      productName: "",
      page: 1,
      length: 0,
      productsOnPage: 20,
    };
  },
  mounted: async function () {
    await categoriesStore.getCategoryById(this.$route.params.id.toString());
    this.category = categoriesStore.category;
    this.productsFavorite = [];

    this.isAdmin = userStore.isAdmin();

    this.length = Math.ceil(
      (await productStore.getNumberOfProductsByCategoryId(
        this.category.id
      )) / this.productsOnPage
    );

    const r = await productStore.getProductByCategoryId(this.category.id, 0, this.productsOnPage);
    if (r) {
      this.products = r;
    }

    if (userStore.isLoggedIn && !userStore.isAdmin()) {
      this.productsFavorite = await productStore.getAllFavoriteProducts(
        userStore.id,
        0, 
        100000
      );
    }

    this.$watch(
      () => this.categoryId,
      async (newValue) => {
        if (newValue == "") {
          this.page = 1;
          this.length = Math.ceil(
            (await productStore.getNumberOfProductsByCategoryId(
              this.category.id
            )) / this.productsOnPage
          );
          await productStore.getProductByCategoryId(this.category.id, 0, this.productsOnPage);
        } else {
          this.page = 1;
          this.length = Math.ceil(
            (await productStore.getNumberOfProductsBySubCategoryId(
              newValue
            )) / this.productsOnPage
          );
          await productStore.getProductBySubCategoryId(newValue, 0, this.productsOnPage);
        }
      }
    );

    this.$watch(
      () => userStore.role,
      () => {
        this.isAdmin = userStore.isAdmin();
      }
    );

    this.$watch(
      () => userStore,
      async (newValue) => {
        if (!newValue.isAdmin())
          this.productsFavorite = await productStore.getAllFavoriteProducts(
            newValue.id,
            0, 
            100000
          );
      }
    );

    this.$watch(
      () => productStore.productsFavorites,
      async (newValue) => {
        this.productsFavorite = newValue;
      }
    );

    this.$watch(
      () => productStore.products,
      async (newValue) => {
        this.products = newValue;
      }
    );

    this.$watch(
      () => this.$route.params.id,
      async (newValue) => {
        await categoriesStore.getCategoryById(newValue);
        this.category = categoriesStore.category;

        const r = await productStore.getProductByCategoryId(this.category.id, 0, this.productsOnPage);
        if (r) {
          this.products = r;
        }
      }
    );

    this.$watch(
      () => categoriesStore.category,
      async (newValue) => {
        this.category = newValue;
        const r = await productStore.getProductByCategoryId(this.category.id, 0, this.productsOnPage);
        if (r) {
          this.products = r;
        }
      }
    );
  },
  methods: {
    closeRemoveModal() {
      this.isRemoveModalOpen = false;
      this.productId = "";
      this.productName = "";
    },
    openRemoveModal(productId: string, productName: string) {
      this.productId = productId;
      this.productName = productName;
      this.isRemoveModalOpen = true;
    },
    async onChangePagePagination(page: number) {
      this.page = page;
      if (this.categoryId == ""){
        await productStore.getProductByCategoryId(this.category.id, (this.page-1)*this.productsOnPage, this.productsOnPage);
      }
      else {
        await productStore.getProductBySubCategoryId(this.categoryId, (this.page-1)*this.productsOnPage, this.productsOnPage);
      }
    },

    handleOnClickAvatar(number: string) {
      if (this.categoryId == number) {
        this.categoryId = "";
      } else {
        this.categoryId = number;
      }
    },
    onClickProductUser(productId: string) {
      this.$router.push(`/product/${productId}`);
    },
    addProductHandler() {
      this.$router.push("/admin/product/add");
    },
    editProductHandler(productId: string) {
      this.$router.push(`/admin/product/edit/${productId}`);
    },
    async deleteProductHandler() {
      const r = await productStore.removeProduct(this.productId);
      if (r) {
        notificationStore.openSuccessAlert("rmv-product-success");
      } else {
        notificationStore.openErrorAlert("rmv-product-error");
      }

      this.closeRemoveModal();
    },
    viewMoreHandler(productId: string) {
      this.onClickProductUser(productId);
    },
    async favoriteIconHandler(productId: string) {
      const userId = userStore.id;
      if (!userStore.isLoggedIn) {
        this.$router.push("/login");
        return;
      }
      const product = this.productsFavorite.find((e) => e.id == productId);
      const req = await productStore.addRmvFavoriteProducts(userId, productId);
      if (req) {
        if (product) {
          this.productsFavorite = this.productsFavorite.filter(
            (e) => e.id !== product.id
          );
        } else {
          await productStore.getAllFavoriteProducts(userId, 0, 100000);
        }
      } else {
        if (product) {
          notificationStore.openErrorAlert("rm-favorite-error");
        } else notificationStore.openErrorAlert("add-favorite-error");
      }
    },
  },
  components: {
    CategoryAdmin,
    CategoryUser,
    ConfirmationModal,
  },
};
</script>
