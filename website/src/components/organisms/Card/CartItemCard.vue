<template>
  <CardLayout class="card bg-secondary">
    <ImageCard max-height="125px" max-width="125px" class="mt-2 ml-2" :href="orderItem?.href"/>

    <div class="info">
      <div class="name-remove">
        <v-card-title class="mt-2">{{ orderItem?.name }}</v-card-title>

        <v-btn
          icon
          class="elevation-0 bg-secondary"
          v-on:click="removeProductHandler"
        >
          <v-icon>mdi-trash-can-outline</v-icon>
        </v-btn>
      </div>
      <v-card-item>{{ orderItem?.price }}€</v-card-item>
      <div class="material-quantity">
        <v-card-item>
          <Avatar :href="orderItem?.materialHref" :size="20" />
        </v-card-item>
        <QuantityButton
          class="mr-5"
          :quantity="quantity"
          :incrementHandler="incrementHandler"
          :decrementHandler="decrementHandler"
        />
      </div>
    </div>
  </CardLayout>
</template>

<script lang="ts">
import { OrderItem } from "@/appTypes/Order";
import CardLayout from "@/layouts/CardLayout.vue";
import Avatar from "@/components/atoms/AvatarVue.vue";
import QuantityButton from "@/components/atoms/Button/QuantityButton.vue";
import ImageCard from "@/components/atoms/ImageCard.vue";
export default {
  name: "CartItemCard",
  props: {
    orderItem: {
      type: Object as () => OrderItem,
      required: true,
    },
    incrementHandler: {
      type: Function,
      required: true,
    },
    decrementHandler: {
      type: Function,
      required: true,
    },
    quantity: {
      type: Number,
      required: true,
    },
    removeProductHandler: {
      type: Function,
      required: true,
    },
  },
  components: { CardLayout, Avatar, QuantityButton, ImageCard },
};
</script>

<style>
.card {
  display: flex;
  flex-direction: row;
}
.name-remove {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}
.img {
  margin: auto auto auto 10px;
}

.material-quantity {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}

.info {
  width: 100%;
}
</style>
