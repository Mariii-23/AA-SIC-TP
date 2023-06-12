<template>
    <v-btn type="submit" color="primary bg-primary" @click="handleClick" value={{value}}>
        <ButtonText class="text-black">
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
    components: { ButtonText }
};
</script>