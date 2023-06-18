<template>
  <div class="titleWithButton">
    <HeadingText :size="size">{{ title }}</HeadingText>
    <div class="buttons">
      <ExpansionPanelsButton :handleClick="leftButtonHandler">
        <ButtonText>
          {{ leftButtonText }}
        </ButtonText>
      </ExpansionPanelsButton>
      <ExpansionPanelsButton class="ml-4" :handleClick="rightButtonHandler">
        <ButtonText>
          {{ rightButtonText }}
        </ButtonText>
      </ExpansionPanelsButton>
    </div>
  </div>
</template>

<script lang="ts">
import HeadingText from "../atoms/Typography/HeadingText.vue";
import ButtonText from "../atoms/Typography/ButtonText.vue";
import ExpansionPanelsButton from "../atoms/Button/ExpansionPanelsButton.vue";

export default {
  name: "TitleWithTwoButtons",
  props: {
    size: {
      type: Number,
      default: 4,
      validator: (value: number) => [1, 2, 3, 4, 5, 6].includes(value),
    },
    title: {
      type: String,
      require: true,
    },
    leftButtonText: {
      type: String,
      require: true,
    },
    rightButtonText: {
      type: String,
      require: true,
    },
    leftButtonHandler: {
      type: Function,
      require: true,
    },
    rightButtonHandler: {
      type: Function,
      require: true,
    },
  },
  components: { HeadingText, ButtonText, ExpansionPanelsButton },
};
</script>

<style>
.titleWithButton {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}
.buttons  {
  display: flex;
  flex-direction: row;
}
</style>
