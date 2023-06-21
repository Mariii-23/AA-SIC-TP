<template>
  <v-card color="secondary" class="card">
    <v-card-title>
      <div class="header">
        {{ product.name }}
        <v-btn
          icon
          class="elevation-0"
          color="secondary"
          v-on:click="editProductDescHandler"
        >
          <v-icon size="30">mdi-pencil-outline</v-icon>
        </v-btn>
      </div>
    </v-card-title>

    <v-card-item dense>
      <HeadingText :size="6">{{ product.price }}€</HeadingText>

      <MaterialsAdmin
        class="materials"
        :materials="materials"
        :addMaterialHandler="addMaterialHandler"
        :selectMaterialHandler="selectMaterialHandler"
      />
    </v-card-item>
    <v-card-text>
      <FullWidthButton class="btn" :handleClick="() => deleteProductHandler && deleteProductHandler(product.id, product.name)">
        {{ $t("remove-product") }}
      </FullWidthButton>
    </v-card-text>
  </v-card>
</template>

<script lang="ts">
import HeadingText from "../atoms/Typography/HeadingText.vue";
import FullWidthButton from "../atoms/Button/FullWidthButton.vue";
import {  Material, ProductSimple } from "@/appTypes/Product";
import MaterialsAdmin from "../molecules/MaterialsAdmin.vue";

export default {
  name: "ProductDesc",
  props: {
    product: {
      type: Object as () => ProductSimple,
      required: true,
    },
    materials: {
      type: Array as () => Material[],
      required: true,
    },
    //HANDLERS
    deleteProductHandler: {
      type: Function,
      required: true,
    },
    editProductDescHandler: {
      type: Function,
      required: true,
    },
    addMaterialHandler: {
      type: Function,
      required: true,
    },
    selectMaterialHandler: {
      type: Function,
      required: true,
    },
  },
  components: {
    HeadingText,
    FullWidthButton,
    MaterialsAdmin,
  },
};
</script>

<style scoped>
.card {
  padding: 10px;
}
.header {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}

.actions {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
}

.materials {
  padding: 0;
  margin-top: 10px;
  margin-bottom: 15px;
}
</style>
