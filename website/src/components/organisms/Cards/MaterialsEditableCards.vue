<template>
  <CardsLayout>
    <MaterialCard
      v-for="material in items"
      :key="material.id"
      :material="material"
      :remove-material-handler="
        () => removeMaterialHandler && removeMaterialHandler(material.id, material.name)
      "
      :update-material-handler="updateMaterialHandler"
    />
  </CardsLayout>
</template>

<script lang="ts">
import MaterialCard from "../Card/MaterialCard.vue";
import { Material } from "@/appTypes/Product";
import CardsLayout from "@/layouts/CardsLayout.vue";

export default {
  name: "Materials Editable Cards",
  props: {
    items: {
      type: Array as () => Material[],
    },
    removeMaterialHandler: {
      type: Function,
    },
    updateMaterialHandler: {
      type: Function,
    },
  },
  components: {
    MaterialCard,
    CardsLayout,
  },
};
</script>
