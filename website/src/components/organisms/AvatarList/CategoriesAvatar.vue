<template>
  <div class="categories-avatar-wrapper">
    <CategoryAvatar
      v-for="category in categories"
      :size="size"
      :key="category.id"
      :avatar-href="category.imgHref"
      :name="$t(category.name)"
      :on-click="() => clickHandler && clickHandler(category.id)"
    />
  </div>
</template>

<script lang="ts">
import CategoryAvatar from "../Avatar/CategoryAvatar.vue";
import { CategoryAvatarProps } from "@/appTypes/Category";
export default {
  name: "Avatar",
  props: {
    categories: {
      type: Array as () => CategoryAvatarProps[],
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
</style>
