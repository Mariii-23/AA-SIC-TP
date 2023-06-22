<template>
  <ConfirmationModal
    :title="$t('rmv-product')"
    :text="$t('rmv-product-text') + ' ' + nameProductToRemove + '?'"
    :confirmHandler="deleteProductHandler"
    :closeModal="closeRemoveModal"
    v-bind:is-modal-open="isRemoveModalOpen"
  />

  <SimpleBodyLayout>
    <ProductUser
      v-if="!isAdmin"
      :product="product"
      :productImages="images"
      :productInfo="info"
      :materials="materials"
      v-bind:productsFavorite="productsFavorite"
      v-bind:quantity="quantity"
      :incrementQuantityHandler="incrementQuantityHandler"
      :decrementQuantityHandler="decrementQuantityHandler"
      :addToCartHandler="addToCartHandler"
      :buyNowHandler="buyNowHandler"
      :favouriteIconHandler="favouriteIconHandler"
      :selectMaterialHandler="selectMaterialHandler"
      v-bind:related-products="productsRelatedUser"
      :viewMoreHandler="viewMoreHandler"
    />

    <ProductAdmin
      v-if="isAdmin"
      :productImages="images"
      :product="product"
      :productInfo="info"
      :materials="materials"
      :deleteProductHandler="deleteProductHandler"
      :editProductDescHandler="editProductDescHandler"
      :editProductInfoHandler="editProductInfoHandler"
      :editProductHandler="editProductHandler"
      :addMaterialHandler="addMaterialHandler"
      :selectMaterialHandler="selectMaterialHandler"
      :openRemoveModal="openRemoveModal"
      v-bind:related-products="productsRelatedAdmin"
    />
  </SimpleBodyLayout>
</template>

<script lang="ts">
import ProductUser from "./User/ProductUser.vue";
import ProductAdmin from "./Admin/ProductAdmin.vue";
import {
  ProductInformation,
  Material,
  ProductSimple,
  Image,
} from "@/appTypes/Product";
import { useUserStore } from "@/store/userStore";
import { useProductStore } from "@/store/productStore";
import { useNotificationStore } from "@/store/notificationStore";
import { useShoppingCartStore } from "@/store/shoppingCartStore";
import ConfirmationModal from "@/components/organisms/Modal/ConfirmationModal.vue";
import { ProductUserProps } from "@/appTypes/ProductUserProps";
import SimpleBodyLayout from "@/layouts/Body/SimpleBodyLayout.vue";

const userStore = useUserStore();
const productStore = useProductStore();
const notificationStore = useNotificationStore();
const shoppingCartStore = useShoppingCartStore();

export default {
  name: "Product",
  data: () => ({
    isAdmin: true,
    product: {} as ProductSimple,
    categoryId: "",
    materialId: "",
    quantity: 1,
    images: [] as Image[],
    info: {} as ProductInformation,
    materials: [] as Material[],
    isRemoveModalOpen: false,
    productsFavorite: [] as ProductSimple[],
    productsRelatedUser: [] as ProductUserProps[],
    productsRelatedAdmin: [] as ProductSimple[],
    nameProductToRemove: "",
    idProductToRemove: "",
  }),
  mounted: async function () {
    this.isAdmin = userStore.isAdmin();
    this.product.id = this.$route.params.id.toString();

    this.productsFavorite = [];
    this.productsRelatedUser = [];
    this.productsRelatedAdmin = [];

    const product = await productStore.getProduct(this.product.id);
    if (!product) {
      //mandar notificacao
    } else {
      this.images = product.images;
      this.info = product.information;
      this.materials = product.materials;
      if (product.materials.length > 0) {
        this.materialId = product.materials[0].id;
      }
      this.product.name = product.name;
      this.product.price = product.price;
      this.categoryId = product.categoryId;

      await this.updateRelatedProduct();
    }
    if (userStore.isLoggedIn && !userStore.isAdmin()) {
      this.productsFavorite = await productStore.getAllFavoriteProducts(
        userStore.id,
        0,
        1000
      );

      await this.updateRelatedProduct();
    }

    this.$watch(
      () => this.$route.params.id,
      async (newValue) => {
        this.isAdmin = userStore.isAdmin();

        if (newValue === undefined) {
          return;
        }
        this.product.id = newValue.toString();

        this.productsFavorite = [];
        this.productsRelatedUser = [];
        this.productsRelatedAdmin = [];

        const product = await productStore.getProduct(this.product.id);
        if (!product) {
          //mandar notificacao
        } else {
          this.images = product.images;
          this.info = product.information;
          this.materials = product.materials;
          if (product.materials.length > 0) {
            this.materialId = product.materials[0].id;
          }
          this.product.name = product.name;
          this.product.price = product.price;
          this.categoryId = product.categoryId;

          await this.updateRelatedProduct();
        }
        if (userStore.isLoggedIn && !userStore.isAdmin()) {
          this.productsFavorite = await productStore.getAllFavoriteProducts(
            userStore.id,
            0,
            1000
          );

          await this.updateRelatedProduct();
        }
      }
    );

    this.$watch(
      () => userStore,
      async (newValue) => {
        if (!newValue.isAdmin()) {
          const r = await productStore.getAllFavoriteProducts(
            newValue.id,
            0,
            1000
          );
          if (r !== undefined) {
            this.productsFavorite = r;
          }

          await this.updateRelatedProduct();
        }
      }
    );

    this.$watch(
      () => productStore.productsFavorites,
      async (newValue) => {
        this.productsFavorite = newValue;
        await this.updateRelatedProduct();
        console.log(this.productsFavorite)
        console.log(productStore.productsFavorites)
      }
    );

    this.$watch(
      () => userStore.$id,
      () => (this.isAdmin = userStore.isAdmin())
    );
  },
  methods: {
    async updateRelatedProduct() {
      const r = await productStore.getProductByCategoryId(this.categoryId, 0, 10);
      this.productsRelatedUser = [];
      this.productsRelatedAdmin = [];
      const isAdmin = userStore.isAdmin();
      for (let i = 0; i < r.length; i++) {
        const item = r[i];
        if (isAdmin) {
          this.productsRelatedAdmin.push(item);
        } else {
          const isFavorite = this.productsFavorite.find(
            (e) => e.id === item.id
          );
          this.productsRelatedUser.push({
            favourite: isFavorite !== undefined,
            ...item,
          });
        }
      }
    },
    async deleteProductHandler() {
      const r = await productStore.removeProduct(this.idProductToRemove);
      if (r) {
        notificationStore.openSuccessAlert("rmv-product-success");
      } else {
        notificationStore.openErrorAlert("rmv-product-error");
      }

      this.closeRemoveModal();
    },
    closeRemoveModal() {
      this.isRemoveModalOpen = false;
      this.product.id = "";
    },
    openRemoveModal(productId: string, productName: string) {
      this.idProductToRemove = productId;
      this.nameProductToRemove = productName;
      this.isRemoveModalOpen = true;
    },

    editProductDescHandler(productId: string) {
      this.$router.push(`/admin/product/edit/${productId}`);
    },
    editProductInfoHandler(productId: string) {
      this.editProductDescHandler(productId);
    },
    editProductHandler(productId: string) {
      this.editProductDescHandler(productId);
    },
    addMaterialHandler() {
      this.editProductDescHandler(this.product.id);
    },

    viewMoreHandler(productId: string) {
      this.$router.push("/product/" + productId);
    },

    async addToCartHandler() {
      if (!userStore.isLoggedIn) {
        this.$router.push("/login");
      }
      const userId = userStore.id;
      const product = {
        materialId: this.materialId,
        id: this.product.id,
        name: this.product.id,
        href: this.images[0].href,
        price: this.product.price,
      };

      const r = await shoppingCartStore.addProduct(
        product,
        this.quantity,
        userId
      );

      if (r) {
        notificationStore.openSuccessAlert("add-product-cart-success");
      } else {
        notificationStore.openErrorAlert("add-product-cart-error");
      }
    },
    async buyNowHandler() {
      await this.addToCartHandler();
      if (!userStore.isLoggedIn) {
        this.$router.push("/login");
      } else {
        this.$router.push("/user/cart");
      }
    },
    async favouriteIconHandler(productId: string) {
      const userId = userStore.id;
      if (!userStore.isLoggedIn) {
        this.$router.push("/login");
        return;
      }
      
      const product = this.productsFavorite.find((e) => e.id == productId);
      const req = await productStore.addRmvFavoriteProducts(userId, productId);
      if (req) {
        await productStore.getAllFavoriteProducts(userId, 0, 100000);
      } else {
        if (product) {
          notificationStore.openErrorAlert("rm-favorite-error");
        } else notificationStore.openErrorAlert("add-favorite-error");
      }
    },
    selectMaterialHandler(materialId: string) {
      this.materialId = materialId;
    },
    incrementQuantityHandler() {
      this.quantity = this.quantity + 1;
    },
    decrementQuantityHandler() {
      if (this.quantity > 1) {
        this.quantity = this.quantity - 1;
      }
    },
  },
  components: {
    ConfirmationModal,
    ProductUser,
    ProductAdmin,
    SimpleBodyLayout,
  },
};
</script>
