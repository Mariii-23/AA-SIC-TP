<template>
    <div class="titleWithEditButton">
        <HeadingText>{{ title }}</HeadingText>
        <v-btn icon @click="editHandler" class="bg-background elevation-0">
            <v-icon>mdi-square-edit-outline</v-icon>
        </v-btn>
    </div>
</template>

<script lang="ts">
import HeadingText from "../atoms/Typography/HeadingText.vue";

export default {
    name: "TitleWithEditButton",
    props: {
        editHandler: {
            type: Function,
        },
        title: {
            type: String,
            require: true,
        }
    },
    components: { HeadingText },

};
</script>

<style>
.titleWithEditButton {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
}
</style>
