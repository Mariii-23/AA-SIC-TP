<template>
  <CardLayout>
    <v-card-item @click="onClick && onClick(product.id)">
      <ImageCard :href="product.href" />
      <v-card-title>{{ product.name }}</v-card-title>
      <v-card-subtitle>{{ product.price }}€</v-card-subtitle>
    </v-card-item>

    <div class="actions">
      <v-btn
        icon
        class="action elevation-0 bg-secondary"
        @click="viewMoreHandler"
      >
        <v-icon>mdi-dots-horizontal-circle-outline</v-icon>
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
import ImageCard from "@/components/atoms/ImageCard.vue";

export default {
  name: "ProductPreviewUserCard",
  props: {
    product: {
      type: Object as () => ProductUserProps,
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
    onClick: {
      type: Function,
    },
  },
  components: { CardLayout, ImageCard },
};
</script>

<style scoped>
.actions {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}
</style>
