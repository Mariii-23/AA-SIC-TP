<template>
  <div class="ola">
    <TwoColumnsPanel>
      <template v-slot:first>
        <TitleCardLinksButton title="All Users" :items="items" button-text="Add User" :button-handler="addUserHandler" />
      </template>
      <template v-slot:second>
        <ContainerPanel>
          <v-container> ola </v-container>
          <v-container> ola </v-container>
          <v-container> ola </v-container>
          <v-container> ola </v-container>
          <v-container> ola </v-container>
          <v-container> ola </v-container>
          <v-container> ola </v-container>
          <v-container> ola </v-container>
          <v-container> ola </v-container>
          <v-container> ola </v-container>
          <v-container> ola </v-container>
          <v-container> ola </v-container>
          <v-container> ola </v-container>
          <v-container> ola </v-container>
          <v-container> ola </v-container>
          <v-container> ola </v-container>
          <v-container> ola </v-container>
          <v-container> ola </v-container>
          <v-container> ola </v-container>
          <v-container> ola </v-container>
          <v-container> ola </v-container>
          <v-container> ola </v-container>
          <v-container> ola </v-container>
          <v-container> adeus </v-container>
          <v-container> adeus </v-container>
          <v-container> adeus </v-container>
          <v-container> adeus </v-container>
          <v-container> adeus </v-container>
          <v-container> adeus </v-container>
        </ContainerPanel>
      </template>
    </TwoColumnsPanel>
  </div>
</template>

<script lang="ts">
import TitleCardLinksButton from "@/components/organisms/TitleCardLinksButton.vue";
import TwoColumnsPanel from "@/layouts/Body/TwoColumnsPanel.vue";
import ContainerPanel from "@/layouts/ContainerPanel.vue";

export default {
  data: () => ({
    items: [],
  }),
  mounted: function () {
    this.items = [
      { href: "/try", icon: "brightness-1", text: "ola heheh" },
      { href: "/login", icon: "brightness-1", text: "ola heheh" },
      { href: "/try", icon: "bullseye", text: "ola heheh" },
      { href: "/login", icon: "bullseye", text: "ola heheh" },
      { href: "/login", icon: "bullseye", text: "ola heheh" },
      { href: "/login", icon: "brightness-1", text: "ola heheh" },
    ];
  },
  components: {
    TwoColumnsPanel,
    ContainerPanel,
    TitleCardLinksButton,
  },
  methods: {
    addUserHandler() {
      console.log("cliquei");
    },
  },
};
</script>

<style>
.ola {
  position: sticky;
  top: 0;
  padding: 3%;
}
</style>
