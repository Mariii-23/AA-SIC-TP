<template>
  <v-navigation-drawer v-model="drawer" temporary>
    <v-list-item @click="changeDrawer" class="top">
      <v-list-item-avatar>
        <v-icon>mdi-chevron-left</v-icon>
      </v-list-item-avatar>
      {{ $t("close") }}
    </v-list-item>

    <v-divider />

    <v-list density="compact" nav>
      <v-list-item v-for="item in list" :key="item.value" :prepend-icon="item.prependIcon" :title="item.title"
        :value="item.value" />
    </v-list>
  </v-navigation-drawer>
</template>

<script lang="ts">
import { usedrawerStore } from "@/store/drawerStore";
import { computed, watch } from "vue";
import { DrawerItem } from "@/appTypes/DrawerItem";

export default {
  name: "AppDrawer",
  data: () => ({
    list: [] as DrawerItem[],
  }),
  setup() {
    const drawerStore = usedrawerStore();
    const drawer = computed(() => drawerStore.drawer);
    //FIXME: Remover - Assistir o valor do drawer e ver as suas mudanças
    watch(drawer, (newDrawer) => {
      console.log("Drawer mudou:", newDrawer);
    });
    return {
      drawer,
      changeDrawer: drawerStore.changeDrawer,
    };
  },
  mounted: function () {
    //FIXME: get list
    this.list = [
      { prependIcon: "mdi-view-dashboard", title: "Home", value: "home" },
      { prependIcon: "mdi-forum", title: "About", value: "about" },
    ];
  }
};
</script>

<style scoped>
.top {
  display: flex;
  flex-direction: row;
  padding: 10px;
}
</style>