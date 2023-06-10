<template>
    <div class="cardsLayout">
        <slot />
    </div>
</template>

<style>
.cardsLayout {
    display: grid;
    grid-template-columns: repeat(auto-fill, 175px);
    justify-content: space-between;
    gap: 30px;
    list-style-type: none;
}
</style>
