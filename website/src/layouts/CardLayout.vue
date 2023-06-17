<template>
    <v-card class="cardLayout">
        <slot />
    </v-card>
</template>

<style>
.cardLayout {
    width: 100%;
    height: 100%;
}

.expanded {
    width: 400px;
}
</style>
