<template>
    <div class="cardsEditableLayout">
        <slot />
    </div>
</template>

<style>
.cardsEditableLayout {
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    justify-content: space-between;
    gap: 30px;
    list-style-type: none;
}
</style>
