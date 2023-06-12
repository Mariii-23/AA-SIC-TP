<template>
  <v-btn type="submit" color="secondary bg-secondary" @click="handleClick" value="{{value}}">
    <ButtonText class="text-surface">
      <slot />
    </ButtonText>
  </v-btn>
</template>

<script lang="ts">
import ButtonText from "../Typography/ButtonText.vue";

export default {
  props: {
    handleClick: {
      type: Function,
      required: true,
    },
    value: {
      type: String,
    },
  },
  components: { ButtonText },
};
</script>
