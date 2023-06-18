<template>
    <CardLayout width="45%" class="card bg-secondary">
        <v-card-title>
            {{ $t("total") }}
        </v-card-title>
      <v-card-item>
        <OrderTableInfo :orderItems="cart?.items" :total="cart?.total"/>
      </v-card-item>
      <div class="actions">
      <PrimaryButton width="20%" :handleClick="cancelOrder">{{ $t("cancel") }}</PrimaryButton>
      <PrimaryButton width="75%" :handleClick="makeOrder">{{ $t("buy") }}</PrimaryButton>
    </div>
    </CardLayout>
  </template>
  
  <script lang="ts">
  import CardLayout from "@/layouts/CardLayout.vue";
  import OrderTableInfo from "@/components/molecules/expansionPanels/BodyExpansionPanel/OrderTableInfo.vue";
  import { Cart } from "@/appTypes/Order";
  import PrimaryButton from "@/components/atoms/Button/PrimaryButton.vue";
  
  export default {
    name: "CartTotalCard",
    props: {
        cart: {
            type: Object as () => Cart,
            require: true,
        },
        cancelOrder: {
            type: Function,
            require: true,
        },
        makeOrder: {
            type: Function,
            require: true,
        },
    },
    components: { CardLayout, OrderTableInfo, PrimaryButton  },
  };
  </script>
 <style scoped>
 .card {
    position: fixed;
    padding: 10px;
    display: flex;
    flex-direction: column;
    margin-top: 60px;
 }
 .actions {
        display: flex;
        flex-direction: row;
        justify-content: space-between;
 }
 </style>
  