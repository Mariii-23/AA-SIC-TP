<template>
  <div class="titleWithButton">
    <TitleGoBack :title="title" :goBackHandler="goBack" />
    <PrimaryButton :handleClick="buttonHandler">
      <ButtonText>
        {{ buttonText }}
      </ButtonText>
    </PrimaryButton>
  </div>
</template>

<script lang="ts">
import ButtonText from "../atoms/Typography/ButtonText.vue";
import PrimaryButton from "../atoms/Button/PrimaryButton.vue";
import TitleGoBack from "./TitleGoBack.vue";

export default {
  name: "TitleWithButtonAndGoBack",
  methods: {
    goBack() {
      if (this.goBackHandler) {
        this.goBackHandler();
      } else {
        this.$router.back();
      }
    },
  },
  props: {
    goBackHandler: {
      type: Function,
    },
    size: {
      type: Number,
      default: 4,
      validator: (value: number) => [1, 2, 3, 4, 5, 6].includes(value),
    },
    title: {
      type: String,
      require: true,
    },
    buttonText: {
      type: String,
      require: true,
    },
    buttonHandler: {
      type: Function,
      require: true,
    },
  },
  components: { ButtonText, PrimaryButton, TitleGoBack },
};
</script>

<style>
.titleWithButton {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}
</style>
