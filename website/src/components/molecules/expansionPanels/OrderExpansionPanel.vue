<template>
    <v-expansion-panels variant="popout">
      <ExpansionPanelLayout v-for="order in orders" :key="order.id">
        <template v-slot:title>
          <TitleWithButtonAndChip
            :size="5"
            :title="`${$t('order')} #${order.id}`"
            :button-text="$t('viewDetails')"
            :button-handler="
              () => viewDetailsHandler && viewDetailsHandler(order.id)
            "
            :chip="$t(order.state.toString())"
          />
          <div class="user-title-info-wrapper">
            <div>{{ $t("date-text") }} {{ order.date }}</div>
            <div>{{ $t("total") }}: {{ order.total.toFixed(2) }}€</div>
          </div>
        </template>
        <template v-slot:text>
          <OrderTableInfo :orderItems="order.orderItems" />
        </template>
      </ExpansionPanelLayout>
    </v-expansion-panels>
  </template>
  
  <style>
  .user-title-info-wrapper {
    display: flex;
    flex-direction: column;
    gap: 10px;
  }
  </style>
  
  <script lang="ts">
  import { Order } from "@/appTypes/Order";
  import ExpansionPanelLayout from "./ExpansionPanelLayout.vue";
  import OrderTableInfo from "./BodyExpansionPanel/OrderTableInfo.vue";
  import TitleWithButtonAndChip from "../TitleWithButtonAndChip.vue";
  
  export default {
    name: "OrderExpansionPanels",
    props: {
      orders: {
        type: Array as () => Order[],
        required: true,
      },
      viewDetailsHandler: {
        type: Function,
      },
    },
    components: {
      ExpansionPanelLayout,
      OrderTableInfo,
      TitleWithButtonAndChip,
    },
  };
  </script>
  