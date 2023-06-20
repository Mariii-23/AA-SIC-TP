<template>
  <CardLayout>
    <v-card-item>
      <ImageCard :href="product.href" />
      <v-card-title>{{ product.name }}</v-card-title>
      <v-card-subtitle>{{ product.price }}€</v-card-subtitle>
    </v-card-item>

    <div class="actions">
      <v-btn
        icon
        class="action elevation-0 bg-secondary"
        @click="shoppingCartHandler"
      >
        <v-icon>mdi-shopping-outline</v-icon>
      </v-btn>
      <v-btn
        icon
        class="action elevation-0 bg-secondary"
        @click="favoriteIconHandler"
      >
        <v-icon v-if="product.favourite">mdi-heart</v-icon>
        <v-icon v-else>mdi-heart-outline</v-icon>
      </v-btn>
    </div>
  </CardLayout>
</template>

<script lang="ts">
import { ProductUserProps } from "@/appTypes/ProductUserProps";
import CardLayout from "@/layouts/CardLayout.vue";

export default {
  name: "ProductPreviewUserCard",
  props: {
    product: {
      type: Object as () => ProductUserProps,
      required: true,
    },
    shoppingCartHandler: {
      type: Function,
      required: true,
    },
    favoriteIconHandler: {
      type: Function,
      required: true,
    },
  },
  components: { CardLayout },
};
</script>

<style scoped>
.imgContainer {
  width: 150px;
  height: 150px;
}

.image {
  border-radius: 5%;
  width: 100%;
  height: 100%;
}

.actions {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}
</style>
