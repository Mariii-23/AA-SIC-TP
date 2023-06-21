<template>
  <CardsLayout>
    <CategoryCard
      v-for="category in categories"
      :key="category.id"
      :category="category"
      :edit-category-handler="
        () => editCategoryHandler && editCategoryHandler(category.id)
      "
      :remove-category-handler="
        () => removeCategoryHandler && removeCategoryHandler(category.id, category.name)
      "
    />
  </CardsLayout>
</template>

<script lang="ts">
import CardsLayout from "@/layouts/CardsLayout.vue";
import CategoryCard from "../Card/CategoryCard.vue";
import { Category } from "@/appTypes/Product";

export default {
  components: {
    CardsLayout,
    CategoryCard,
  },
  props: {
    categories: {
      type: Array as () => Category[],
      require: true,
    },
    editCategoryHandler: {
      type: Function,
    },
    removeCategoryHandler: {
      type: Function,
    },
  },
};
</script>
