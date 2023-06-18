<template>
    <div class="cartItemLayout">
        <slot />
    </div>
</template>

<style>
.cartItemLayout {
    display: flex;
    flex-direction: column;
    gap: 30px;
    list-style-type: none;
}
</style>
