<template>
  <CardLayout>
    <v-container fluid class="layout-images">
      <div v-for="image in images" :key="image.id" class="body-images-wrapper">
        <div class="item-image">
          <AvatarLink :image-href="image.href" :size="size" />
          <v-btn
            icon
            @click="removeFile(image.id)"
            class="elevation-0 bg-secondary"
          >
            <v-icon icon="mdi-trash-can-outline" />
          </v-btn>
        </div>
      </div>
    </v-container>
  </CardLayout>
</template>

<script lang="ts">
import { Image } from "@/appTypes/Product";
import AvatarLink from "@/components/molecules/AvatarLink.vue";
import CardLayout from "@/layouts/CardLayout.vue";

export default {
  name: "Delete Images",
  props: {
    images: {
      type: Array as () => Image[],
      required: true,
    },
    removeFile: {
      type: Function,
      required: true,
    },
    size: {
      type: Number,
      default: 50,
    },
  },
  components: {
    CardLayout,
    AvatarLink,
  },
};
</script>

<style scoped>
.body-images {
  display: flex;
  gap: 30px;
}

.item-image {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-bottom: 10px;
}

.layout-images {
  display: grid;
  gap: 20px;
  grid-template-columns: repeat(4, 1fr);
}

@media (max-width: 768px) {
  .layout-images {
    grid-template-columns: repeat(1, 1fr);
  }
}
</style>
