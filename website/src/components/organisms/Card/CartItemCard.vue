<template>
  <CardLayout class="card bg-secondary">
    <div class="img">
      <v-img max-height="150px" max-width="150px" :src="orderItem?.img" />
    </div>
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
        <!--FIXME. alterar para começar na quantidade-->
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
export default {
  name: "CartItemCard",
  props: {
    orderItem: {
      type: Object as () => OrderItem,
      require: true,
    },
    incrementHandler: {
      type: Function,
      require: true,
    },
    decrementHandler: {
      type: Function,
      require: true,
    },
    quantity: {
      type: Number,
      require: true,
    },
    removeProductHandler: {
      type: Function,
      require: true,
    },
  },
  components: { CardLayout, Avatar, QuantityButton },
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
