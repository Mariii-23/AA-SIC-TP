<template>
  <CardsEditableLayout>
    <MaterialCard
      v-for="material in items"
      :key="material.id"
      :material="material"
      :remove-material-handler="() => removeMaterialHandler && removeMaterialHandler(material.id)"
      :update-material-handler="updateMaterialHandler"
    />
  </CardsEditableLayout>
</template>

<script lang="ts">
import MaterialCard from "../Card/MaterialCard.vue";
import { Material } from "@/appTypes/Product";
import CardsEditableLayout from "@/layouts/CardsEditableLayout.vue";

export default {
  components: {
    MaterialCard,
    CardsEditableLayout,
  },
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
};
</script>
