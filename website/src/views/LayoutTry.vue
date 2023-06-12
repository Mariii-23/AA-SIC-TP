<template>
  <div class="ola">
    <TwoColumnsPanel>
      <template v-slot:first>
        <TitleCardLinksButton title="All Users" :items="items" button-text="Add User" :button-handler="addUserHandler" />
      </template>
      <template v-slot:second>
        <TitleWithButton title="All Users" button-text="New user" :button-handler="addUserHandler" />
        <v-container />
        <TitleWithGoBack title="All Users" />
        <v-container />
        <TitleWithEditButton title="All Users" :edit-handler="addUserHandler" />
        <v-container />
      </template>
    </TwoColumnsPanel>
  </div>
</template>

<script lang="ts">
import TitleWithButton from "@/components/molecules/TitleWithButton.vue";
import TitleCardLinksButton from "@/components/organisms/TitleCardLinksButton.vue";
import TitleWithGoBack from "@/components/molecules/TitleGoBack.vue";
import TwoColumnsPanel from "@/layouts/Body/TwoColumnsPanel.vue";
import TitleWithEditButton from "@/components/molecules/TitleWithEditButton.vue";

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
    TitleCardLinksButton,
    TitleWithButton,
    TitleWithGoBack,
    TitleWithEditButton
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
