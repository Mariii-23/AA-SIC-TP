<template>
  <ProductUser v-if="!isAdmin" :productImages="images" :productInfo="info" :materials="materials"
    :addToCartHandler="addToCartHandler" :buyNowHandler="buyNowHandler" :favouriteIconHandler="favouriteIconHandler"
    :selectMaterialHandler="selectMaterialHandler" :quantity="quantity"
    :incrementQuantityHandler="incrementQuantityHandler" :decrementQuantityHandler="decrementQuantityHandler" />

  <ProductAdmin v-if="isAdmin" :productImages="images" :productInfo="info" :materials="materials"
    :deleteProductHandler="deleteProductHandler" :editProductDescHandler="editProductDescHandler"
    :editProductInfoHandler="editProductInfoHandler" :editProductHandler="editProductHandler"
    :addMaterialHandler="addMaterialHandler" :selectMaterialHandler="selectMaterialHandler" />
</template>

<script lang="ts">
import ProductUser from "./User/ProductUser.vue";
import ProductAdmin from "./Admin/ProductAdmin.vue";
import { ProductImages, ProductInformation, Material } from "@/appTypes/Product";

export default {
  name: "Product",
  components: {
    ProductUser,
    ProductAdmin,
  },
  data: () => ({
    isAdmin: false,
    quantity: 1,
    images: Object as () => ProductImages,
    info: Object as () => ProductInformation,
    materials: Array as () => Material[],
  }),
  mounted: function () {
    this.images = [
      "https://cdn.vuetifyjs.com/images/cards/hotel.jpg",
      "http://diamond.mariii.xyz:8080/api/wall/pleasant-lake.jpg",
      "https://cdn.vuetifyjs.com/images/cards/docks.jpg",
      "https://cdn.vuetifyjs.com/images/cards/sunshine.jpg",
  ];

    this.info = {
      details: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
      technical: [
        {
          name: "Altura",
          info: "100cm",
        },
        {
          name: "Largura",
          info: "80cm",
        },
        {
          name: "Profundidade",
          info: "70cm",
        },
      ]
    };

    this.materials = [
      {
        id: "1",
        name: "Red",
        href: "https://images.unsplash.com/flagged/photo-1593005510509-d05b264f1c9c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8cmVkJTIwY29sb3VyfGVufDB8fDB8fHww&w=1000&q=80",
      },
      {
        id: "2",
        name: "Blue",
        href: "https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Solid_blue.svg/2500px-Solid_blue.svg.png",
      },
      {
        id: "3",
        name: "Green",
        href: "https://upload.wikimedia.org/wikipedia/commons/thumb/2/29/Solid_green.svg/1200px-Solid_green.svg.png",
      },
    ];
  },
  methods: {
    //TODO:
    deleteProductHandler(productId: string) {
      console.log("delete product " + productId);
    },

    //ESTES TRÊS FAZEM O MESMO?
    editProductDescHandler(productId: string) {
      console.log("edit product desc " + productId);
    },

    editProductInfoHandler(productId: string) {
      console.log("edit product info " + productId);
    },

    editProductHandler(productId: string) {
      console.log("edit product " + productId);
    },

    addMaterialHandler() {
      console.log("add material");
    },

    addToCartHandler(productId: string) {
      console.log("add to cart " + productId);
    },

    buyNowHandler(productId: string) {
      console.log("buy now " + productId);
    },

    favouriteIconHandler(productId: string) {
      console.log("favourite " + productId);
    },

    selectMaterialHandler(materialId: string) {
      console.log("select material " + materialId);
    },

    incrementQuantityHandler(productId: string, quantity: number) {
      this.quantity = this.quantity++;
      console.log("increment quantity " + productId + " " + quantity);
    },

    decrementQuantityHandler(productId: string, quantity: number) {
      this.quantity = this.quantity--;
      console.log("decrement quantity " + productId + " " + quantity);
    }
  }
}
</script>
