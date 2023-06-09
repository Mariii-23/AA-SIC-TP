<template>
  <v-btn type="submit" class="custom-full-width" color="primary" @click="handleClick" value={{value}}>
    <ButtonText>
        <slot/>
    </ButtonText>
  </v-btn>

</template>

<script lang="ts">

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
};
</script>