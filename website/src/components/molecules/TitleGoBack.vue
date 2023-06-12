<template>
    <div class="titleWithGoBack">
        <v-btn icon @click="goBack" class="bg-background elevation-0">
            <v-icon>mdi-keyboard-backspace</v-icon>
        </v-btn>
        <HeadingText>{{ title }}</HeadingText>
    </div>
</template>

<script lang="ts">
import HeadingText from "../atoms/Typography/HeadingText.vue";

export default {
    name: "TitleWithGoBack",
    props: {
        goBackHandler: {
            type: Function,
        },
        title: {
            type: String,
            require: true,
        }
    },
    methods: {
        goBack() {
            this.$router.back();
        },
    },
    components: { HeadingText },

};
</script>

<style>
.titleWithGoBack {
    display: flex;
    flex-direction: row;
    gap: 15px
}
</style>
