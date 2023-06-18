<template>
  <v-expansion-panels variant="popout">
      <ExpansionPanelLayout v-for="order in orders" :key="order.id">
        <template v-slot:title>
          <TitleWithTwoButtons v-if="changingTo"
            :size="5"
            :title="`${$t('order')} #${order.id}`"
            :left-button-text="`${$t('change-to')} ${changingTo}`"
            :left-button-handler="() => changeState && changeState(order.id)"
            :right-button-text="$t('viewDetails')"
            :right-button-handler="
              () => viewDetailsHandler && viewDetailsHandler(order.id)
            "
          />
          <TitleWithButton v-else
            :size="5"
            :title="`${$t('order')} #${order.id}`"
            :button-text="$t('viewDetails')"
            :button-handler="
              () => viewDetailsHandler && viewDetailsHandler(order.id)
            "
          />
          
          <div class="user-title-info-wrapper">
            <div>{{ $t("client") }} #{{ order.user }}</div>
            <div>{{ $t("date-text") }} {{ order.date }}</div>
            <div>{{ $t("total") }}: {{ order.total }}€</div>
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
    gap: 20px;
  }
  .total-button {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
  }
  </style>
  
  <script lang="ts">
  import { OrderAdmin } from "@/appTypes/Order";
  import ExpansionPanelLayout from "./ExpansionPanelLayout.vue";
  import OrderTableInfo from "./BodyExpansionPanel/OrderTableInfo.vue";
  import TitleWithButton from "../TitleWithButton.vue";
  import TitleWithTwoButtons from "../TitleWithTwoButtons.vue";
  export default {
    name: "OrderAdminExpansionPanels",
    props: {
      orders: {
        type: Array as () => OrderAdmin[],
        require: true,
      },
      viewDetailsHandler: {
        type: Function,
      },
      changeState: {
        type: Function,
      }
      , 
      changingTo: {
        type: String
      }
    },
    components: {
    ExpansionPanelLayout,
    OrderTableInfo,
    TitleWithButton,
    TitleWithTwoButtons
},
  };
  </script>
  