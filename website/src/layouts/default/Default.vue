<template>
  <v-app>
    <app-drawer :list="list" :on-click-handler="goToCategory" />

    <default-bar :key="$route.fullPath" />

    <default-view />

    <div v-if="!notShowFooter.includes($route.fullPath)">
      <default-footer />
    </div>
  </v-app>
</template>

<script lang="ts">
import DefaultBar from "@/components/organisms/AppBar.vue";
import DefaultView from "./View.vue";
import DefaultFooter from "@/components/organisms/AppFooter.vue";
import AppDrawer from "@/components/organisms/AppDrawer.vue";
import { Ref, ref } from "vue";
import { DrawerItem } from "@/appTypes/DrawerItem";
import { useCategoriesStore } from "@/store/categoriesStore";
import { Category } from "@/appTypes/Product";
import { usedrawerStore } from "@/store/drawerStore";

// const notShowFooter = ref([
//   "/login",
//   "/register",
//   "/recover-password",
//   "/add-product",
// ]);
export default {
  name: "Default",
  data: () => ({
    notShowFooter: [] as Ref<string[]>,
    list: [] as DrawerItem[],
    categories: [] as Category[],
  }),
  mounted: async function () {
    this.notShowFooter = ref([
      "/login",
      "/register",
      "/recover-password",
      "/add-product",
    ]);

    const categoriesStore = useCategoriesStore();

    if (categoriesStore.categories.length == 0) {
      await categoriesStore.getAllCategories(0, 10000);
      categoriesStore.categories.forEach((categorie) => {
        this.list.push({
          title: categorie.name,
          value: categorie.name,
          prependIcon: "",
          id: categorie.id,
          href: categorie.href,
        });
      });
    }

    this.$watch(
      () => ({ categories: categoriesStore.categories }),
      (newValues) => {
        //TODO: falta por a imagem
        this.categories = newValues.categories;
        let categoriesItens: DrawerItem[] = [];
        newValues.categories.forEach((categorie) => {
          categoriesItens.push({
            title: categorie.name,
            value: categorie.name,
            prependIcon: "",
            id: categorie.id,
            href: categorie.href,
          });
        });
        this.list = categoriesItens;
      }
    );
  },
  methods: {
    goToCategory(id: string) {
      const drawerStore = usedrawerStore();
      drawerStore.changeDrawer();

      const route = `/category/${id}`;
      this.$router.push(route);
    },
  },
  components: {
    DefaultBar,
    DefaultFooter,
    DefaultView,
    AppDrawer,
  },
};
</script>
