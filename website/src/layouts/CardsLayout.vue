<template>
    <div class="cardsLayout">
        <slot />
    </div>
</template>

<style>
.cardsLayout {
    display: grid;
    grid-template-columns: repeat(auto-fill, 250px);
    justify-content: space-between;
    gap: 50px;
    list-style-type: none;
}
</style>
