<template>
  <div>
      <HeadingText class="mb-6">{{ $t("cart") }}</HeadingText>
  
    <CartItemCard class="card"
      v-for="(orderItem, index) in orderItems" 
      :key="orderItem.name" 
      :orderItem="orderItem" 
      :quantity="orderItem.quantity"
      :incrementHandler="() => incrementHandler && incrementHandler(index)"
      :decrementHandler="() => decrementHandler && decrementHandler(index)"
      />
  </div>
</template>
  
<script lang="ts">
import CartItemCard from "../Card/CartItemCard.vue";
import { OrderItem } from "@/appTypes/Order";
import HeadingText from "@/components/atoms/Typography/HeadingText.vue";

export default {
  components: {
    CartItemCard,
    HeadingText
  },
  props: {
    orderItems: {
      type: Array as () => OrderItem[],
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
  },
};
</script>

<style>
.card {
  margin-bottom: 20px;
}
</style>  