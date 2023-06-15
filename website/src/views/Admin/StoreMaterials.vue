<template>
  <ConfirmationModal 
      :title="$t('rmv-material')" 
      :text="$t('rmv-material-text') + ' ' + material + '?'" 
      :confirmHandler="removeMaterialHandler" 
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
        <TitleCardLinksButton :title="$t('store')" :items="items" :button-text="$t('logout')"
            :button-handler="openLogoutModal"/>
      </template>
      <template v-slot:second>
        <TitleWithButton :title="$t('materials')" :buttonText="$t('add-material')"
          :buttonHandler="addMaterialHandler" />
        <ItemsTable :items="materials" :editItem="editMaterialHandler" :deleteItem="openRemoveModal" />
      </template>
    </TwoColumnsPanel>
  </SimpleBodyLayout>
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
  name: "Materials",
  data: () => ({
    items: Array as () => LinkProps[],
    isRemoveModalOpen: false,
    isLogoutModalOpen: false,
    materials: Array as () => Materials[],
    material: ""
  }),
  mounted: function () {
    this.items = [
      { href: "/admin/company", icon: "brightness-1", text: "company" },
      { href: "/admin/categories", icon: "brightness-1", text: "categories" },
      { href: "/admin/materials", icon: "bullseye", text: "materials" },
    ];
    this.materials = [
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
    addMaterialHandler() {
      console.log("add material")
    },
    closeRemoveModal() {
        this.isRemoveModalOpen = false;
      },
      openRemoveModal(materialname: string){
        this.material = materialname;
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
      },
    removeMaterialHandler() {
      console.log("remove material " + this.material)
    },
    saveChangesHandler(productname: String) {
      console.log("save changes " + productname)
    },
    editMaterialHandler (productname: String) {
      console.log("edit material " + productname)
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
  