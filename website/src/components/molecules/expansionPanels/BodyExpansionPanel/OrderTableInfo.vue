<template>
    <v-table density="compact"  class="bg-secondary">
      <tbody>
        <tr v-for="item in orderItems" :key="item.name">
          <td>{{ item.name }}</td>
          <td>{{ item.quantity }} x {{ item.price }}€</td>
        </tr>
        <tr v-if="total">
          <td class="font-weight-bold">{{ $t("total") }}:</td>
          <td>{{ total.toFixed(2) }}€</td>
        </tr>
      </tbody>
    </v-table>
  </template>
  
  <script lang="ts">
  import { OrderItem } from "@/appTypes/Order";
  
  export default {
    props: {
      orderItems: {
        type: Array as () => OrderItem[],
        required: true,
      },
      total: {
        type: Number,
        required: true,
      },
    },
  };
  </script>
  