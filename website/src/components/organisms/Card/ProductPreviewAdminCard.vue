<template>
  <CardLayout>
    <v-card-item>
      <ImageCard :href="product.href" />
      <v-card-title>{{ product.name }}</v-card-title>
      <v-card-subtitle>{{ product.price }}€</v-card-subtitle>
    </v-card-item>

    <div class="actions">
      <v-btn icon class="action elevation-0" @click="deleteProductHandler">
        <v-icon>mdi-trash-can-outline</v-icon>
      </v-btn>
      <v-btn icon class="action elevation-0" @click="editProductHandler">
        <v-icon>mdi-pencil-outline</v-icon>
      </v-btn>
    </div>
  </CardLayout>
</template>

<script lang="ts">
import { ProductSimple } from "@/appTypes/Product";
import CardLayout from "@/layouts/CardLayout.vue";
import ImageCard from "@/components/atoms/ImageCard.vue";

export default {
  name: "ProductPreviewAdmin",
  props: {
    product: {
      type: Object as () => ProductSimple,
      required: true,
    },
    deleteProductHandler: {
      type: Function,
      required: true,
    },
    editProductHandler: {
      type: Function,
      required: true,
    },
  },
  components: { CardLayout, ImageCard },
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
