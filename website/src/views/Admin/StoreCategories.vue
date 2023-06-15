<template>
    <ConfirmationModal 
      :title="$t('rmv-category')" 
      :text="$t('rmv-category-text') + ' ' + category + '?'" 
      :confirmHandler="removeCategoryHandler" 
      :closeModal="closeRemoveModal" 
      :isModalOpen="isRemoveModalOpen"/>

      <ConfirmationModal
    :title="$t('logout')"
    :text="$t('logout-text')"
    :confirmHandler="logoutHandler"
    :closeModal="closeLogoutModal"
    :isModalOpen="isLogoutModalOpen"
  />
    <SimpleBodyLayout>
      <TwoColumnsPanel>
        <template v-slot:first>
          <TitleCardLinksButton :title="$t('store')" :items="items" 
          :button-text="$t('logout')"
            :button-handler="openLogoutModal"/>
        </template>
        <template v-slot:second>
          <TitleWithButton
              :title="$t('categories')"
              :buttonText="$t('add-category')"
              :buttonHandler="addCategoryHandler"
            />
          <ItemsTable :items="categories" :deleteItem="openRemoveModal"/>
        </template> </TwoColumnsPanel
    ></SimpleBodyLayout>
  </template>
  
  <script lang="ts">
  import { LinkProps } from "@/appTypes/Link";
  import TwoColumnsPanel from "@/layouts/Body/TwoColumnsPanel.vue";
  import TitleCardLinksButton from "@/components/organisms/TitleCardLinksButton.vue";
  import SimpleBodyLayout from "@/layouts/Body/SimpleBodyLayout.vue";
  import { Materials } from "@/appTypes/Product";
  import ItemsTable from "@/components/organisms/Table/ItemsTable.vue";
  import TitleWithButton from "@/components/molecules/TitleWithButton.vue";
  import ConfirmationModal from "@/components/organisms/Modal/ConfirmationModal.vue";

  export default {
    name: "StoreCategories",
    data: () => ({
      items: Array as () => LinkProps[],
      isRemoveModalOpen: false,
      isLogoutModalOpen: false,
      categories: Array as () => Materials[],
      category: ""
    }),
    mounted: function () {
      this.items = [
        { href: "/admin/company", icon: "brightness-1", text: "company" },
        { href: "/admin/categories", icon: "bullseye", text: "categories" },
        { href: "/admin/materials", icon: "brightness-1", text: "materials" },
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
      removeCategoryHandler() {
        console.log("remove category")
      },
      addCategoryHandler() {
        console.log("add category")
      },
      closeRemoveModal() {
        this.isRemoveModalOpen = false;
      },
      openRemoveModal(categoryname: string){
        this.category = categoryname;
        this.isRemoveModalOpen = true;
      },
      openLogoutModal() {
        this.isLogoutModalOpen = true;
      },
      closeLogoutModal() {
        this.isLogoutModalOpen = false;
      },
      logoutHandler() {
        console.log("logout")
      }
    },
    components: {
      TwoColumnsPanel,
      TitleCardLinksButton,
      SimpleBodyLayout,
     ItemsTable,
      TitleWithButton,
      ConfirmationModal
    },
  };
  </script>
  