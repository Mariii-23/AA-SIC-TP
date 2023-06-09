<template>
  <CategoryUser
    v-if="!isAdmin"
    :products="products"
    :category="category"
    :links="links"
    :handle-on-click-avatar="handleOnClickAvatar"
    :handle-page-change="onChangePagePagination"
    :shopping-card-handler="shoppingCardHandler"
    :favorite-icon-handler="favoriteIconHandler"
  />

  <CategoryAdmin
    v-if="isAdmin"
    :products="products"
    :category="category"
    :links="links"
    :handle-on-click-avatar="handleOnClickAvatar"
    :handle-page-change="onChangePagePagination"
    :add-product-handler="addProductHandler"
    :delete-product-handler="deleteProductHandler"
    :edit-product-handler="editProductHandler"
  />
</template>

<script lang="ts" setup>
import CategoryUser from "./user/CategoryUser.vue";
import { ref, onMounted } from "vue";
import { useRoute } from "vue-router";
import CategoryAdmin from "./admin/CategoryAdmin.vue";

const route = useRoute();
//TODO: change this
const isAdmin = false;
const links = ref([]);

//TODO: ir buscar ao backend
const category = ref({
  id: null,
  name: "Mesa",
  subCategories: [],
  href: "https://cdn.vuetifyjs.com/images/cards/hotel.jpg",
});

let product = {
  name: "Product name 1",
  price: 1,
  id: 1,
  href: "http://diamond.mariii.xyz:8080/api/wall/pleasant-lake.jpg",
};
//TODO: ir buscar ao backend
let products = [];

for (let i = 0; i < 20; i++) {
  products.push(product);
}

//TODO:
const onChangePagePagination = (number: string) => {
  console.log(number);
};

//TODO:
const handleOnClickAvatar = (number: string) => {
  console.log(number);
};

//TODO:
const addProductHandler = () => {
  console.log("adicionar produto");
};

//TODO:
const deleteProductHandler = (number: string) => {
  console.log(number);
};

//TODO:
const editProductHandler = (productId: string) => {
  console.log(productId);
};

const shoppingCardHandler = (productId: string) => {
  console.log(productId);
};

const favoriteIconHandler = (productId: string) => {
  console.log(productId);
};

onMounted(() => {
  category.value.id = route.params.id;
  category.value.name = "Mesa";
  category.value.subCategories = [
    {
      id: 1,
      name: "Mesa",
      imgHref: "https://cdn.vuetifyjs.com/images/cards/hotel.jpg",
    },
    {
      id: 2,
      name: "Mesa2",
      imgHref: "https://cdn.vuetifyjs.com/images/cards/hotel.jpg",
    },
    {
      id: 3,
      name: "Mesa3",
      imgHref: "https://cdn.vuetifyjs.com/images/cards/hotel.jpg",
    },
    {
      id: 4,
      name: "Mesa4",
      imgHref: "https://cdn.vuetifyjs.com/images/cards/hotel.jpg",
    },
    {
      id: 3,
      name: "Mesa3",
      imgHref: "https://cdn.vuetifyjs.com/images/cards/hotel.jpg",
    },
    {
      id: 4,
      name: "Mesa4",
      imgHref: "https://cdn.vuetifyjs.com/images/cards/hotel.jpg",
    },
    {
      id: 4,
      name: "Mesa4",
      imgHref: "https://cdn.vuetifyjs.com/images/cards/hotel.jpg",
    },
    {
      id: 3,
      name: "Mesa3",
      imgHref: "https://cdn.vuetifyjs.com/images/cards/hotel.jpg",
    },
    {
      id: 4,
      name: "Mesa4",
      imgHref: "https://cdn.vuetifyjs.com/images/cards/hotel.jpg",
    },
    {
      id: 4,
      name: "Mesa4",
      imgHref: "https://cdn.vuetifyjs.com/images/cards/hotel.jpg",
    },
    {
      id: 3,
      name: "Mesa3",
      imgHref: "https://cdn.vuetifyjs.com/images/cards/hotel.jpg",
    },
    {
      id: 4,
      name: "Mesa4",
      imgHref: "https://cdn.vuetifyjs.com/images/cards/hotel.jpg",
    },
    {
      id: 4,
      name: "Mesa4",
      imgHref: "https://cdn.vuetifyjs.com/images/cards/hotel.jpg",
    },
    {
      id: 4,
      name: "Mesa4",
      imgHref: "https://cdn.vuetifyjs.com/images/cards/hotel.jpg",
    },
    {
      id: 3,
      name: "Mesa3",
      imgHref: "https://cdn.vuetifyjs.com/images/cards/hotel.jpg",
    },
    {
      id: 4,
      name: "Mesa4",
      imgHref: "https://cdn.vuetifyjs.com/images/cards/hotel.jpg",
    },
    {
      id: 4,
      name: "Mesa4",
      imgHref: "https://cdn.vuetifyjs.com/images/cards/hotel.jpg",
    },
    {
      id: 3,
      name: "Mesa3",
      imgHref: "https://cdn.vuetifyjs.com/images/cards/hotel.jpg",
    },
    {
      id: 4,
      name: "Mesa4",
      imgHref: "https://cdn.vuetifyjs.com/images/cards/hotel.jpg",
    },
  ];
  category.value.href = "https://cdn.vuetifyjs.com/images/cards/hotel.jpg";

  links.value = [
    {
      disabled: false,
      href: category.value.id,
      title: category.value.name,
    },
  ];
});
</script>
