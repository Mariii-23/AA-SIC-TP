<template>
    <CardLayout class="bg-secondary">
      <v-tabs v-model="tab" bg-color="primary">
        <v-tab
          v-for="(tabItem, index) in tabs"
          :key="index"
          :disabled="tab !== index"
          :value="index"
        >
          <v-icon v-if="tab === index">mdi-numeric-{{ index + 1 }}-circle</v-icon>
          <v-icon v-else> mdi-numeric-{{ index + 1 }}-circle-outline </v-icon>
          {{ tabItem.label }}
        </v-tab>
      </v-tabs>
  
      <v-card-text>
        <v-window v-model="tab">
          <v-window-item
            v-for="(tabItem, index) in tabs"
            :key="index"
            :value="index"
          >
            <slot :name="'tab' + (index + 1)" />
          </v-window-item>
        </v-window>
      </v-card-text>
    </CardLayout>
  </template>
  
  <script lang="ts">
  import CardLayout from "@/layouts/CardLayout.vue";
  export default {
    name: "TabbedComponent",
    props: {
      tabs: {
        type: Array as () => {
          label: string;
        }[],
        required: true,
      },
      selectedTab: {
        type: Number,
        required: true,
      },
    },
    data: () => ({
      tab: 0,
    }),
    mounted: function () {
      this.tab = this.selectedTab;
      this.$watch(
        () => this.selectedTab,
        (newValue) => {
          this.tab = newValue;
        }
      );
    },
    components: { CardLayout },
  };
  </script>
  
  <style scoped>
  .body {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 800px;
    margin: 3% auto auto auto;
  }
  .text-fields-row {
    display: flex;
  }
  </style>