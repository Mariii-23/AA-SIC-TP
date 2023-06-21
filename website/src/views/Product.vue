<template>
  <ConfirmationModal
    :title="$t('rmv-product')"
    :text="$t('rmv-product-text') + ' ' + product.id + '?'"
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
    images: [] as string[],
    info: {} as ProductInformation,
    materials: [] as Material[],
    isRemoveModalOpen: false,
    productsFavorite: [] as ProductSimple[],
    productsRelatedUser: [] as ProductUserProps[],
    productsRelatedAdmin: [] as ProductSimple[],
  }),
  mounted: async function () {
    this.isAdmin = userStore.isAdmin();
    this.product.id = this.$route.params.id.toString();

    this.productsFavorite = [];
    this.productsRelatedUser = [];
    this.productsRelatedAdmin = [];

    const product = await productStore.getProduct(this.product.id);
    if (!product) {
      //TODO: mudar de pagina
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
    if (userStore.isLoggedIn) {
      this.productsFavorite = await productStore.getAllFavoriteProducts(
        userStore.id
      );
    }

    this.$watch(
      () => userStore,
      async (newValue) => {
        if (!newValue.isAdmin()) {
          const r = await productStore.getAllFavoriteProducts(newValue.id);
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
      }
    );

    this.$watch(
      () => userStore.$id,
      () => (this.isAdmin = userStore.isAdmin())
    );
  },
  methods: {
    async updateRelatedProduct() {
      const r = await productStore.getProductByCategoryId(this.categoryId);
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
    async deleteProductHandler(productId: string) {
      console.log("delete product " + productId);

      const r = await productStore.removeProduct(this.product.id);
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
    openRemoveModal(productId: string) {
      this.product.id = productId;
      this.isRemoveModalOpen = true;
    },

    //ESTES TRÊS FAZEM O MESMO?
    //TODO:
    editProductDescHandler(productId: string) {
      console.log("edit product desc " + productId);
    },

    //TODO:
    editProductInfoHandler(productId: string) {
      console.log("edit product info " + productId);
    },

    //TODO:
    editProductHandler(productId: string) {
      console.log("edit product " + productId);
    },

    //TODO:
    addMaterialHandler() {
      console.log("add material");
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
        href: this.images[0],
        price: this.product.price,
      };

      const r = await shoppingCartStore.addProduct(
        product,
        this.quantity,
        userId
      );

      if (r) {
        this.$router.push("/user/cart");
      } else {
        notificationStore.openErrorAlert("add-product-cart-error");
      }
    },
    async buyNowHandler() {
      await this.addToCartHandler();
    },

    async favouriteIconHandler() {
      const userId = userStore.id;
      if (!userStore.isLoggedIn) {
        this.$router.push("/login");
        return;
      }
      const product = this.productsFavorite.find(
        (e) => e.id == this.product.id
      );
      const req = await productStore.addRmvFavoriteProducts(
        userId,
        this.product.id
      );
      if (req) {
        if (product) {
          notificationStore.openSuccessAlert("rm-favorite-success");
          this.productsFavorite = this.productsFavorite.filter(
            (e) => e.id !== product.id
          );
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
