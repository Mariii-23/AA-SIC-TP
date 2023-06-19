<template>
    <div class="cardsLayout">
        <slot />
    </div>
</template>

<style>
.cardsLayout {
    display: grid;
    grid-template-columns: repeat(auto-fill, 280px);
    justify-content: space-between;
    gap: 30px;
    list-style-type: none;
}
</style>
