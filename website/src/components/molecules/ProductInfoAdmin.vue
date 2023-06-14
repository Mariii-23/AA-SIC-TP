<template>
  <v-card color="secondary">
    <v-tabs v-model="tab" bg-color="transparent" color="black" grow>
      <v-tab>
        {{ $t('product-details') }}
      </v-tab>
      <v-tab class="right-tab">
        {{ $t('tech-info') }}
      </v-tab>
        <v-btn size="large" color="secondary" class="elevation-0"
          v-on:click="editProductInfoHandler">
          <v-icon>mdi-pencil-outline</v-icon>
        </v-btn>
    </v-tabs>

    <v-window v-model="tab">
      <v-window-item>
        <v-card color="secondary" flat :text="info.details"/>

      </v-window-item>

      <v-window-item>
        <v-card color="secondary" flat>
          <v-table>
            <tbody>
              <tr v-for="item in info.technical" :key="item.name">
                <td>{{ item.name }}</td>
                <td>{{ item.info }}</td>
              </tr>
            </tbody>
          </v-table>
        </v-card>
      </v-window-item>

    </v-window>
  </v-card>
</template>

<script lang="ts">
import { ProductInformation } from "@/appTypes/Product";
export default {
  data() {
    return {
      tab: "Product Details" || "Detalhes do Produto",
   }
  },
  props: {
    info: {
      type: Object as () => ProductInformation,
    },
    editProductInfoHandler: {
      type: Function,
      require: true,
    },
  },
}
</script>

<style scoped>
.right-tab {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}
</style>