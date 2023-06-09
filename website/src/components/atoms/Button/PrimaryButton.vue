<template>
  <v-btn type="submit" color="primary" @click="handleClick" value={{value}}>
    <ButtonText>
        <slot/>
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
    components: { ButtonText }
};
</script>