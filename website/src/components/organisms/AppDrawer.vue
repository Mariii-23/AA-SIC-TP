<template>
  <v-navigation-drawer v-model="drawer" temporary>
    <v-list-item @click="changeDrawer" class="close">
      <v-list-item-avatar>
        <v-icon>mdi-chevron-left</v-icon>
      </v-list-item-avatar>
      {{ $t("close") }}
    </v-list-item>

    <v-divider />

    <!-- TODO:  Add link to category page -->
    <v-list density="compact" nav>
      <v-list-item
        v-for="item in list"
        :key="item.value"
        :prepend-icon="item.prependIcon"
        :title="item.title"
        :value="item.value"
      />
    </v-list>
  </v-navigation-drawer>
</template>

<script lang="ts">
import { usedrawerStore } from "@/store/drawerStore";
import { useCategoriesStore } from "@/store/categoriesStore";
import { computed, watch } from "vue";
import { DrawerItem } from "@/appTypes/DrawerItem";

export default {
  name: "AppDrawer",
  data: () => ({
    list: [] as DrawerItem[],
    categories: [],
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
  mounted: async function () {
    const categoriesStore = useCategoriesStore();

    if (categoriesStore.categories.length == 0) {
      await categoriesStore.getAllCategories();
      categoriesStore.categories.forEach((categorie) => {
        this.list.push({
          title: categorie.name,
          value: categorie.name,
          prependIcon: "",
        });
      });
      console.log(categoriesStore.categories);
    }

    //FIXME: add prependIcon
    // this.list = [
    //   { prependIcon: "mdi-view-dashboard", title: "Home", value: "home" },
    //   { prependIcon: "mdi-forum", title: "About", value: "about" },
    // ];

    this.$watch(
      () => ({ categories: categoriesStore.categories }),
      (newValues) => {
        this.categories = newValues.categories;
        let categoriesItens: DrawerItem[] = [];
        newValues.categories.forEach((categorie) => {
          categoriesItens.push({
            title: categorie.name,
            value: categorie.name,
            prependIcon: "",
          });
        });
        this.list = categoriesItens;
      }
    );
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
