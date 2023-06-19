<template>
  <v-navigation-drawer v-model="drawer" temporary>
    <v-list-item @click="changeDrawer" class="close">
      <v-icon>mdi-chevron-left</v-icon>
      {{ $t("close") }}
    </v-list-item>
    <v-divider />
    <v-list density="compact" nav>
      <v-list-item
        v-for="item in list"
        :key="item.id"
        :prepend-icon="item.prependIcon"
        :title="item.title"
        :value="item.value"
        :prepend-avatar="item.href"
        @click="onClickHandler(item.id)"
      />
    </v-list>
  </v-navigation-drawer>
</template>

<script lang="ts">
import { usedrawerStore } from "@/store/drawerStore";
import { computed } from "vue";
import { DrawerItem } from "@/appTypes/DrawerItem";

export default {
  name: "AppDrawer",
  props: {
    list: {
      type: Array as () => DrawerItem[],
      required: true,
    },
    onClickHandler: {
      type: Function,
      required: true,
    },
  },
  setup() {
    const drawerStore = usedrawerStore();
    const drawer = computed(() => drawerStore.drawer);
    return {
      drawer,
      changeDrawer: drawerStore.changeDrawer,
    };
  },
};
</script>

<style scoped>
.close {
  display: flex;
  flex-direction: row;
  padding: 10px;
}
</style>
