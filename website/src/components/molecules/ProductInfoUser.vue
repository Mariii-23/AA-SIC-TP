<template>
  <v-card color="secondary">
    <v-tabs v-model="tab"  color="black" grow>
      <v-tab>
        {{ $t('product-details') }}
      </v-tab>
      <v-tab>
        {{ $t('tech-info') }}
      </v-tab>
    </v-tabs>

    <v-window v-model="tab">
      <v-window-item>
        <v-card color="secondary" flat :text="info.details"/>
      </v-window-item>

      <v-window-item>
        <v-card flat>
          <v-table class="bg-secondary">
            <tbody>
              <tr v-for="item in info.technical" :key="item.name">
                <td>{{ item.name }}</td>
                <td>{{ item.description }}</td>
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
      required: true
    }
  },
}
</script>

