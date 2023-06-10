<template>
    <div class="titleCardsLinksButton">
        <HeadingText>{{ title }}</HeadingText>
        <LinksCard :items="items" />
        <FullWidthButton v-if="buttonText" :handle-click="buttonHandler">
            <ButtonText>
                {{ buttonText }}
            </ButtonText>
        </FullWidthButton>
    </div>
</template>

<script lang="ts">
import { LinkCardProps } from "@/appTypes/LinksCardProps";
import LinksCard from "@/components/organisms/Card/LinksCard.vue";
import HeadingText from "../atoms/Typography/HeadingText.vue";
import FullWidthButton from "../atoms/Button/FullWidthButton.vue";

export default {
    props: {
        title: {
            type: String,
            required: true,
        },
        items: {
            type: Array as () => LinkCardProps[],
            required: true,
        },
        buttonText: {
            type: String,
        },
        buttonHandler: {
            type: Function,
        },
    },
    components: {
        LinksCard,
        HeadingText,
        FullWidthButton,
    },
};
</script>

<style>
.titleCardsLinksButton {
    display: grid;
    gap: 20px;
}
</style>
