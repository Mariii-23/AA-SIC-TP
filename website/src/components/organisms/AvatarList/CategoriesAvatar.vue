<template>
  <div class="categories-avatar-wrapper">
    <v-slide-group v-model="model" selected-class="bg-primary" show-arrows>
      <v-slide-group-item
        v-for="category in categories"
        :key="category.id"
        selected-class="radius-wrapper"
        v-slot="{ toggle, selectedClass }"
      >
        <div
          color="grey-lighten-1"
          :class="['ma-3', selectedClass]"
          @click="toggle"
        >
          <CategoryAvatar
            :size="size"
            :class="['ma-4', selectedClass]"
            :key="category.id"
            :avatar-href="category.href"
            :name="$t(category.name)"
            :on-click="() => clickHandler && clickHandler(category.id)"
          />
          <v-scale-transition />
        </div>
      </v-slide-group-item>
    </v-slide-group>
  </div>
</template>

<script lang="ts">
import { CategoryInfo } from "@/appTypes/Product";
import CategoryAvatar from "../Avatar/CategoryAvatar.vue";
export default {
  name: "Avatar",
  data: () => ({
    model: [],
  }),
  mounted() {
    this.$watch(
      () => this.$route.fullPath,
      () => (this.model = [])
    );
  },
  props: {
    categories: {
      type: Array as () => CategoryInfo[],
      require: true,
    },
    clickHandler: {
      type: Function,
      require: true,
    },
    size: {
      type: Number,
      require: true,
    },
  },
  components: { CategoryAvatar },
};
</script>

<style>
.categories-avatar-wrapper {
  display: flex;
  flex-direction: row;
  gap: 30px;
  max-height: full;
  overflow-y: auto;
}

.radius-wrapper {
  border-radius: 40px;
}
</style>
