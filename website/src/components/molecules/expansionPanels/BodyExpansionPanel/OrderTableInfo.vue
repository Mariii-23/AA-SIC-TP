<template>
    <v-table density="compact"  class="bg-secondary">
      <tbody>
        <tr v-for="item in orderItems" :key="item.name">
          <td>{{ item.name }}</td>
          <td>{{ item.quantity }} x {{ item.price }}€</td>
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
        require: true,
      },
    },
  };
  </script>
  