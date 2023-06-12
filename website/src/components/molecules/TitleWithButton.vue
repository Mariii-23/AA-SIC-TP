<template>
  <div class="titleWithButton">
    <HeadingText>{{ title }}</HeadingText>
    <PrimaryButton :handleClick="buttonHandler">
      <ButtonText>
        {{ buttonText }}
      </ButtonText>
    </PrimaryButton>
  </div>
</template>

<script lang="ts">
import HeadingText from "../atoms/Typography/HeadingText.vue";
import ButtonText from "../atoms/Typography/ButtonText.vue";
import PrimaryButton from "../atoms/Button/PrimaryButton.vue";

export default {
  name: "TitleWithButton",
  props: {
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
  components: { HeadingText, ButtonText, PrimaryButton },
};
</script>

<style>
.titleWithButton {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}
</style>
