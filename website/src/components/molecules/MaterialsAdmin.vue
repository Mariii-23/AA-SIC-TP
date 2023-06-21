<template>
    <div class="materials">
        <MaterialsSelect :materials="materials" :selectMaterialHandler="selectMaterialHandler"/>
        <PrimaryButton :handleClick="addMaterialHandler" class="add_btn">+</PrimaryButton>
    </div>
</template>

<script lang="ts">
import { Material } from "@/appTypes/Product";
import PrimaryButton from "@/components/atoms/Button/PrimaryButton.vue";
import MaterialsSelect from "@/components/molecules/MaterialsSelect.vue";

export default {
    name: "Materials",
    props: {
        materials: {
            type: Array as () => Material[],
            required: true,
        },
        addMaterialHandler: {
            type: Function,
            required: true,
        },
        selectMaterialHandler: {
            type: Function,
            required: true,
        },
    },
    components: { PrimaryButton, MaterialsSelect },
};
</script>

<style scoped>
.materials {
    display: flex;
    flex-direction: row;
    align-items: center;
}

.add_btn {
    margin-left: 10px;
}

</style>