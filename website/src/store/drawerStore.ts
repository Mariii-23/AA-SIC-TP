import { defineStore } from "pinia";

export const usedrawerStore = defineStore("drawer", {
  state: () => ({
    drawer: false,
  }),
  actions: {
    async changeDrawer() {
      this.drawer = !this.drawer;
    },
  },
});
