<template>
    <div class="materials">
        <Material :materials="materials"/>
        <PrimaryButton :handleClick="addMaterialHandler" size="large" class="add_btn">+</PrimaryButton>
    </div>
</template>

<script lang="ts">
import { Materials } from "@/appTypes/Product";
import PrimaryButton from "@/components/atoms/Button/PrimaryButton.vue";
import Material from "@/components/molecules/Materials.vue";

export default {
    name: "Materials",
    props: {
        materials: {
            type: Array as () => Materials[],
            require: true,
        },
        addMaterialHandler: {
            type: Function,
            require: true,
        },
    },
    components: { PrimaryButton, Material },
};
</script>

<style scoped>
.materials {
    display: flex;
    flex-direction: row;
}

.add_btn {
    margin-left: 10px;
}

</style>