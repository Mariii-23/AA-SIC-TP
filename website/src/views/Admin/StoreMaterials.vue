<template>
  <div v-if="materials.length == 0">
      <v-progress-linear
      indeterminate
    />
    </div>
  <SimpleBodyLayout>
    <ConfirmationModal
      :title="$t('rmv-material')"
      :text="$t('rmv-material-text') + ' ' + materialName + '?'"
      :confirmHandler="removeMaterialHandler"
      :closeModal="closeRemoveModal"
      v-bind:is-modal-open="isRemoveModalOpen"
    />
    <TwoColumnsPanel>
      <template v-slot:first>
        <TitleCardLinksButton
          :title="$t('store')"
          :items="items"
        />
      </template>
      <template v-slot:second>
        <TitleWithButton
          :title="$t('materials')"
          :buttonText="$t('add-material')"
          :buttonHandler="addMaterialHandler"
        />
        <MaterialsEditableCards
          v-bind:items="materials"
          :remove-material-handler="openRemoveModal"
          :update-material-handler="updateMaterialHandler"
        />
        <Pagination :length="length" :total-visible="5" :handle-page-change="handlePageChange" />
      </template>
    </TwoColumnsPanel>
  </SimpleBodyLayout>
</template>

<script lang="ts">
import { LinkProps } from "@/appTypes/Link";
import TwoColumnsPanel from "@/layouts/Body/TwoColumnsPanel.vue";
import TitleCardLinksButton from "@/components/organisms/TitleCardLinksButton.vue";
import SimpleBodyLayout from "@/layouts/Body/SimpleBodyLayout.vue";
import { Material } from "@/appTypes/Product";
import TitleWithButton from "@/components/molecules/TitleWithButton.vue";
import ConfirmationModal from "@/components/organisms/Modal/ConfirmationModal.vue";

import { useMaterialStore } from "@/store/materialsStore";
import MaterialsEditableCards from "@/components/organisms/Cards/MaterialsEditableCards.vue";
import { useNotificationStore } from "@/store/notificationStore";
import Pagination from "@/components/molecules/Pagination.vue";

const materialsStore = useMaterialStore();
const notifications = useNotificationStore();

export default {
  name: "Materials",
  data: () => ({
    items: [] as LinkProps[],
    isRemoveModalOpen: false,
    materials: [] as Material[],
    materialId: "",
    materialName: "",
    page: 1,
    length: 0,
    materialsOnPage: 16,
  }),
  mounted: async function () {
    this.items = [
      { href: "/admin/company", icon: "brightness-1", text: "company" },
      { href: "/admin/categories", icon: "brightness-1", text: "categories" },
      { href: "/admin/materials", icon: "bullseye", text: "materials" },
    ];

    this.length = Math.ceil((await materialsStore.getNumberOfMaterials())/this.materialsOnPage);

    if (materialsStore.materials.length <= 0) {
      await materialsStore.getAllMaterials(0, this.materialsOnPage);
    }
    this.materials = materialsStore.materials;

    this.$watch(
      () => materialsStore.materials,
      (newValues) => {
        this.materials = newValues;
      }
    );
  },
  methods: {
    addMaterialHandler() {
      this.$router.push("materials/add");
    },
    closeRemoveModal() {
      this.isRemoveModalOpen = false;
      this.materialId = "";
      this.materialName = "";
    },
    openRemoveModal(materialId: string, materialName: string) {
      this.materialId = materialId;
      this.materialName = materialName;
      this.isRemoveModalOpen = true;
    },
    async removeMaterialHandler() {
      const r = await materialsStore.removeMaterial(this.materialId);
      if (r) {
        notifications.openSuccessAlert(this.$t("rmv-material-success"));
      } else {
        notifications.openErrorAlert(this.$t("rmv-material-error"));
      }
      this.closeRemoveModal();
    },
    async updateMaterialHandler(
      materialId: string,
      name: string,
      photo: string
    ) {
      const r = await materialsStore.updateMaterial(materialId, name, photo);
      await materialsStore.getAllMaterials((this.page-1)*this.materialsOnPage, this.materialsOnPage);
      if (r) {
        notifications.openSuccessAlert(this.$t("update-material-success"));
      } else {
        notifications.openErrorAlert(this.$t("update-material-error"));
      }
    },
    async handlePageChange(page: number){
      this.page = page;
      await materialsStore.getAllMaterials((this.page-1)*this.materialsOnPage, this.materialsOnPage);
    }
  },
  components: {
    TwoColumnsPanel,
    TitleCardLinksButton,
    SimpleBodyLayout,
    TitleWithButton,
    ConfirmationModal,
    MaterialsEditableCards,
    Pagination
  },
};
</script>
