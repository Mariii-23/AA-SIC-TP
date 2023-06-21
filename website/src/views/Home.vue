<template>
  <SimpleBodyLayout>
    <HeadingText>{{ name }}</HeadingText>

    <CategoriesAvatar
      :categories="categories"
      :click-handler="handleOnClickAvatar"
      :size="100"
    />

    <ProductPreviewUserCards
      :products="productsUser"
      :view-more-handler="viewMoreHandler"
      :favorite-icon-handler="favoriteIconHandler"
      :on-click-handler="handleOnClickAvatar"
    />

    <Pagination
      length="10"
      total-visible="6"
      v-if="showPagination"
      :handle-page-change="onChangePagePagination"
    />
  </SimpleBodyLayout>
</template>

<script lang="ts">
import SimpleBodyLayout from "@/layouts/Body/SimpleBodyLayout.vue";
import HeadingText from "@/components/atoms/Typography/HeadingText.vue";
import CategoriesAvatar from "@/components/organisms/AvatarList/CategoriesAvatar.vue";
import ProductPreviewUserCards from "@/components/organisms/Cards/ProductPreviewUserCards.vue";
import Pagination from "@/components/molecules/Pagination.vue";
import { Category, ProductSimple } from "@/appTypes/Product";
import { useCategoriesStore } from "@/store/categoriesStore";
import { useProductStore } from "@/store/productStore";
import { useUserStore } from "@/store/userStore";
import { useNotificationStore } from "@/store/notificationStore";
import { ProductUserProps } from "@/appTypes/ProductUserProps";
import { useCompanyStore } from "@/store/companyStore";

const categoriesStore = useCategoriesStore();
const productStore = useProductStore();
const userStore = useUserStore();
const notificationStore = useNotificationStore();
const companyStore = useCompanyStore();

export default {
  name: "Home Page",
  data: function () {
    return {
      name: "",
      productsUser: [] as ProductUserProps[],
      isAdmin: false,
      showPagination: false,
      products: [] as ProductSimple[],
      productsFavorite: [] as ProductSimple[],
      categories: [] as Category[],
      categoryId: "",
      isRemoveModalOpen: false,
      productId: "",
    };
  },
  mounted: async function () {
    await companyStore.getInfo();
    this.name = companyStore.companyInfo.name;
    this.showPagination = true;

    this.categoryId = "1";
    await productStore.getAllProducts();
    this.products = productStore.products;

    this.categories = categoriesStore.categories;
    this.productsFavorite = [];

    this.isAdmin = userStore.isAdmin();

    if (userStore.isLoggedIn && !userStore.isAdmin) {
      this.productsFavorite = await productStore.getAllFavoriteProducts(
        userStore.id
      );
    }

    this.productsUser = [];
    for (let i = 0; i < this.products.length; i++) {
      const item = this.products[i];
      const isFavorite = this.productsFavorite.find((e) => e.id === item.id);
      this.productsUser.push({
        favourite: isFavorite !== undefined,
        ...item,
      });
    }

    this.$watch(
      () => companyStore.companyInfo.name,
      (newValue) => (this.name = newValue)
    );

    this.$watch(
      () => this.categoryId,
      async (newValue) => {
        if (newValue == "") {
          this.showPagination = true;
          await productStore.getAllProducts();
          this.products = productStore.products;
        } else {
          this.showPagination = false;
          await productStore.getProductByCategoryId(newValue);
          this.products = productStore.products;
        }

        this.productsUser = [];
        for (let i = 0; i < this.products.length; i++) {
          const item = this.products[i];
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
      () => userStore.role,
      () => {
        this.isAdmin = userStore.isAdmin();
      }
    );

    this.$watch(
      () => categoriesStore.categories,
      (newValue) => {
        this.categories = newValue;
      }
    );

    this.$watch(
      () => userStore,
      async (newValue) => {
        if (!newValue.isAdmin())
          this.productsFavorite = await productStore.getAllFavoriteProducts(
            newValue.id
          );

        this.productsUser = [];
        for (let i = 0; i < this.products.length; i++) {
          const item = this.products[i];
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
  },
  methods: {
    closeRemoveModal() {
      this.isRemoveModalOpen = false;
      this.productId = "";
    },
    openRemoveModal(productId: string) {
      this.productId = productId;
      this.isRemoveModalOpen = true;
    },
    onChangePagePagination(number: string) {
      //TODO:
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
          notificationStore.openSuccessAlert("rm-favorite-success");
        } else {
          await productStore.getAllFavoriteProducts(userId);
          notificationStore.openSuccessAlert("add-favorite-success");
        }
      } else {
        if (product) {
          notificationStore.openErrorAlert("rm-favorite-error");
        } else notificationStore.openErrorAlert("add-favorite-error");
      }
    },
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
