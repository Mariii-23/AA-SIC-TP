<template>
  <div class="modal-wrapper" v-if="isOpen">
    <v-card class="elevation-15">
      <v-card-title class="title-modal-wrapper">
        <HeadingText size="6">
          {{ title }}
        </HeadingText>
        <v-btn icon @click="closeModal" class="bg-background elevation-1" size="30">
          <v-icon size="18">mdi-close</v-icon>
        </v-btn>
      </v-card-title>

      <v-card-text class="bg-background">
        <div class="body-modal-wrapper">
          <slot name="body-modal" />
        </div>
      </v-card-text>

      <v-card-actions class="bg-background">
        <slot name="actions-modal" />
      </v-card-actions>
    </v-card>
  </div>
</template>

<script lang="ts">
import HeadingText from "@/components/atoms/Typography/HeadingText.vue";

export default {
  name: "Modal",
  props: {
    isOpen: {
      type: Boolean,
      default: false,
    },
    closeModal: {
      type: Function,
      require: true,
    },
    title: {
      type: String,
      require: true,
    },
  },
  components: { HeadingText },
};
</script>

<style scoped>
.modal-wrapper {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  position: fixed;
  z-index: 9999;
}

.modal-overlay {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
}

.modal-content {
  background-color: white;
  padding: 20px;
  border-radius: 5px;
  max-width: 500px;
}

.body-modal-wrapper {
  padding: 0px;
  padding-top: 15px;
}

.title-modal-wrapper {
  display: flex;
  justify-content: space-between;
  gap: 30px;
}
</style>
