<template>
    <v-card class="card">
        <v-list class="list" v-for="material in materials" bg-color="primary">
            <v-list-item class="item">
                <v-btn class="btn elevation-0" size="x-small" color="primary">
                    <Avatar class="avatar" :image="material.href" :size="20" />
                    <v-tooltip class="tooltip" activator="parent" location="top" :text="material.name" />
                </v-btn>
            </v-list-item>
        </v-list>
    </v-card>
</template>

<script lang="ts">
import { Materials } from "@/appTypes/Product";
import Avatar from "@/components/atoms/AvatarVue.vue";
import PrimaryButton from "@/components/atoms/Button/PrimaryButton.vue";

export default {
    name: "Materials",
    props: {
        materials: {
            type: Array as () => Materials[],
            require: true,
        },
    },
    components: { Avatar, PrimaryButton },
};
</script>

<style scoped>
.card {
    display: flex;
    flex-direction: row;
    width: fit-content;
    border-radius: 5%;
}

.list {
    padding: 0;
}
</style>