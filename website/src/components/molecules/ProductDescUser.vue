<template>
  <v-card color="secondary" class="card">
    <v-card-title>
      <div class="header">
        {{ product.name }}
        <v-btn
          icon
          class="elevation-0"
          color="secondary"
          v-on:click="() => favouriteIconHandler(product.id)"
        >
          <v-icon size="30" v-if="favourite">mdi-heart</v-icon>
          <v-icon size="30" v-else>mdi-heart-outline</v-icon>
        </v-btn>
      </div>
    </v-card-title>

    <v-card-item >
      <HeadingText :size="6">{{ product.price }}€</HeadingText>
      <MaterialsSelect
        class="materials"
        :materials="materials"
        :selectMaterialHandler="selectMaterialHandler"
      />
    </v-card-item>
    <v-card-text>
      <div class="actions">
        <QuantityButton
          v-bind:quantity="quantity"
          :incrementHandler="incrementQuantityHandler"
          :decrementHandler="decrementQuantityHandler"
        />
        <PrimaryButton :handleClick="buyNowHandler"
          >{{ $t("buy-now") }}
        </PrimaryButton>
      </div>
    </v-card-text>
    <v-card-actions>
      <FullWidthButton class="btn" :handleClick="addToCartHandler">
        {{ $t("add-cart") }}
      </FullWidthButton>
    </v-card-actions>
  </v-card>
</template>

<script lang="ts">
import QuantityButton from "../atoms/Button/QuantityButton.vue";
import HeadingText from "../atoms/Typography/HeadingText.vue";
import PrimaryButton from "../atoms/Button/PrimaryButton.vue";
import FullWidthButton from "../atoms/Button/FullWidthButton.vue";
import { ProductSimple } from "@/appTypes/Product";
import MaterialsSelect from "../molecules/MaterialsSelect.vue";
import { Material } from "@/appTypes/Product";

export default {
  name: "ProductDesc",
  data() {
    return {
    favourite: false,
    }
  },
  props: {
    isFavourite : {
      type: Boolean,
      required: true,
    },
    product: {
      type: Object as () => ProductSimple,
      required: true,
    },
    materials: {
      type: Array as () => Material[],
      required: true,
    },
    addToCartHandler: {
      type: Function,
      required: true,
    },
    buyNowHandler: {
      type: Function,
      required: true,
    },
    favouriteIconHandler: {
      type: Function,
      required: true,
    },
    selectMaterialHandler: {
      type: Function,
      required: true,
    },
    quantity: {
      type: Number,
    },
    incrementQuantityHandler: {
      type: Function,
      required: true,
    },
    decrementQuantityHandler: {
      type: Function,
      required: true,
    },
  },
  mounted() {
    this.favourite = this.isFavourite;

    this.$watch(
      () => this.isFavourite,
      (newValues) => {
        this.favourite = newValues;
            }
      )
  },  components: {
    HeadingText,
    QuantityButton,
    PrimaryButton,
    FullWidthButton,
    MaterialsSelect,
  },
};
</script>

<style scoped>
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
</style>
