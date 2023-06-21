<template>
    <v-sheet class="materials" elevation="3" color="primary">
        <v-slide-group v-model="model" selected-class="selected" mandatory show-arrows>
            <v-slide-group-item class="item" v-for="(material,index) in materials" :key="material.id"
                v-slot="{ selectedClass }">
                <v-btn class="elevation-0 rounded-0" 
                    color="primary"
                >
                  <v-tooltip
                    activator="parent"
                    location="top"
                  >{{ material.name }}</v-tooltip>
                  <Avatar :class="[, selectedClass]" class="avatar" 
                    :href="material.href" :size="20" 
                    @click="toggle(index, material.id)" 
                />
                </v-btn>
            </v-slide-group-item>
        </v-slide-group>
    </v-sheet>
</template>


<script lang="ts">
import { Material } from "@/appTypes/Product";
import Avatar from "@/components/atoms/AvatarVue.vue";

export default {
    name: "Materials",
    data: () => ({
        model: 0,
    }),
    props: {
        materials: {
            type: Array as () => Material[],
            require: true,
        },
        selectMaterialHandler: {
            type: Function,
            require: true,
        },
    },
    components: { Avatar },
    methods: {
        toggle(index: number, material: string) {
            this.model = index;
            this.selectMaterialHandler && this.selectMaterialHandler(material);
        }
    }
};
</script>

<style scoped>
.selected {
    border: 1px solid #fff;
    box-shadow: 0 0 3px 3px black;
}

.materials {
    width: fit-content;
    border-radius: 5px;
}
</style>