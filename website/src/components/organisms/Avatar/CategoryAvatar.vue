<template>
  <div class="category-avatar-wrapper">
    <AvatarLink :image-href="avatarHref" :on-click="onClick" :size="size" />
    <OverlineText class="category-avatar-title-wrapper">{{
      name
    }}</OverlineText>
  </div>
</template>

<script lang="ts">
import AvatarLink from "@/components/molecules/AvatarLink.vue";
import OverlineText from "@/components/atoms/Typography/OverlineText.vue";
export default {
  name: "Avatar",
  props: {
    name: {
      type: String,
      require: true,
    },
    avatarHref: {
      type: String,
      require: true,
    },
    size: {
      type: Number,
      default: 80,
    },
    onClick: {
      type: Function,
    },
  },
  components: { AvatarLink, OverlineText },
};
</script>

<style>
.category-avatar-wrapper {
  display: flex;
  flex-direction: column;
  gap: 15;
}

.category-avatar-title-wrapper {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
</style>
