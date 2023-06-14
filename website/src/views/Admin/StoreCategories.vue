<template>
    <SimpleBodyLayout>
      <TwoColumnsPanel>
        <template v-slot:first>
          <TitleCardLinksButton :title="$t('store')" :items="items" />
        </template>
        <template v-slot:second>
          <TitleWithButton
              :title="$t('materials')"
              :buttonText="$t('edit-materials')"
              :buttonHandler="editMaterialsHandler"
            />
          <MaterialsTable :materials="categories"/>
        </template> </TwoColumnsPanel
    ></SimpleBodyLayout>
  </template>
  
  <script lang="ts">
  import { LinkProps } from "@/appTypes/Link";
  import TwoColumnsPanel from "@/layouts/Body/TwoColumnsPanel.vue";
  import TitleCardLinksButton from "@/components/organisms/TitleCardLinksButton.vue";
  import SimpleBodyLayout from "@/layouts/Body/SimpleBodyLayout.vue";
  import { Materials } from "@/appTypes/Product";
  import MaterialsTable from "@/components/organisms/Table/MaterialsTable.vue";
  import TitleWithButton from "@/components/molecules/TitleWithButton.vue";

  export default {
    name: "Materials",
    data: () => ({
      items: Array as () => LinkProps[],
      isModalOpen: false,
      categories: Array as () => Materials[],
    }),
    mounted: function () {
      this.items = [
        { href: "/company", icon: "brightness-1", text: "company" },
        { href: "/categories", icon: "brightness-1", text: "categories" },
        { href: "/materials", icon: "bullseye", text: "materials" },
      ];
      this.categories = [
    {
      id: "1",
      name: "Red",
      href: "https://images.unsplash.com/flagged/photo-1593005510509-d05b264f1c9c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8cmVkJTIwY29sb3VyfGVufDB8fDB8fHww&w=1000&q=80"
    },
    {
      id: "2",
      name: "Blue",
      href: "https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Solid_blue.svg/2500px-Solid_blue.svg.png"

    },
    {
      id: "3",
      name: "Green",
      href: "https://upload.wikimedia.org/wikipedia/commons/thumb/2/29/Solid_green.svg/1200px-Solid_green.svg.png"
    }
  ];
    },
    //TODO: ir buscar os direitos
    methods: {
      editMaterialsHandler() {
        console.log("edit materials")
      }
    },
    components: {
      TwoColumnsPanel,
      TitleCardLinksButton,
      SimpleBodyLayout,
      MaterialsTable,
      TitleWithButton
    },
  };
  </script>
  