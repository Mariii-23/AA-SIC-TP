<template>
  <CardLayout v-if="category" class="bg-secondary">
    <v-card-item class="bg-secondary">
      <div class="imgContainer">
        <v-img
          cover
          :src="category.href"
          :lazy-src="category.href"
          class="image"
        />
      </div>
      <div class="category-car-body-wrapper">
        <v-card-title>{{ category.name }}</v-card-title>

        <v-card-subtitle>
          <v-chip-group v-if="category.subCategories.length > 0">
            <v-chip>
              {{ category.subCategories[0].name }}
            </v-chip>
            <v-chip v-if="category.subCategories.length == 2">
              {{ category.subCategories[1].name }}
            </v-chip>
            <v-tooltip
              v-if="category.subCategories.length > 2"
              location="top center"
              origin="auto"
            >
              <template v-slot:activator="{ props }">
                <v-chip v-bind="props">
                  + {{ category.subCategories.length - 1 }}...
                </v-chip>
              </template>
              <ChipGroup :tags="category.subCategories.map((e) => e.name)" />
            </v-tooltip>
          </v-chip-group>
        </v-card-subtitle>

        <div class="actions">
          <v-btn
            icon
            class="action elevation-0 bg-secondary"
            @click="editCategoryHandler"
          >
            <v-icon>mdi-square-edit-outline</v-icon>
          </v-btn>

          <v-btn
            icon
            @click="removeCategoryHandler"
            class="action bg-secondary elevation-0"
          >
            <v-icon icon="mdi-trash-can-outline" />
          </v-btn>
        </div>
      </div>
    </v-card-item>
  </CardLayout>
</template>

<script lang="ts">
import { Category } from "@/appTypes/Product";
import CardLayout from "@/layouts/CardLayout.vue";
import ChipGroup from "@/components/molecules/ChipGroup.vue";

export default {
  name: "CategoryCard",
  data: () => ({
    overlay: false,
  }),
  props: {
    category: {
      type: Object as () => Category,
    },
    removeCategoryHandler: {
      type: Function,
    },
    editCategoryHandler: {
      type: Function,
    },
  },
  components: { CardLayout, ChipGroup },
};
</script>

<style scoped>
.imgContainer {
  width: 150px;
  height: 150px;
}

.image {
  border-radius: 5%;
  width: 100%;
  height: 100%;
}

.category-car-body-wrapper {
  display: flex;
  flex-direction: column;
  height: max-content;
  justify-content: space-between;
}

.actions {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  width: 100%;
}
</style>
