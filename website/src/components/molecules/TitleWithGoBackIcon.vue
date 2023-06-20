<template>
  <div class="titleWithGoBack">
    <v-btn icon @click="goBack" class="bg-secondary elevation-0">
      <v-icon>mdi-keyboard-backspace</v-icon>
    </v-btn>
    <HeadingText> {{ title }}</HeadingText>
  </div>
</template>

<script lang="ts">
import HeadingText from "../atoms/Typography/HeadingText.vue";

export default {
  name: "Title with go back Icon",
  props: {
    title: {
      type: String,
      required: true,
    },
    goBack: {
      type: Function,
      required: true,
    },
  },
  components: {
    HeadingText,
  },
};
</script>

<style>
.titleWithGoBack {
  display: flex;
  flex-direction: row;
  gap: 15px;
}
</style>
