<template>
    <Modal
      :is-open="isModalOpen"
      :close-modal="closeModal"
      :title="$t('edit-material')"
    >
      <template v-slot:body-modal>
        <BodyText>
          {{ $t("modal-remove-material") }} {{ materialName }}?
        </BodyText>
      </template>
      <template v-slot:actions-modal>
        <CancelConfirmButton
          :cancel-handler="closeModal"
          :confirm-handler="removeMaterialHandler"
        />
      </template>
    </Modal>
  </template>
  
  <script lang="ts">
  import BodyText from "@/components/atoms/Typography/BodyText.vue";
  import CancelConfirmButton from "@/components/molecules/CancelConfirmButtons.vue";
  import Modal from "./Modal.vue";
  
  export default {
    name: "EditMaterialModal",
    props: {
        materialName: {
            type: String,
            required: true,
        },
      removeMaterialHandler: {
        type: Function,
      },
      closeModal: {
        type: Function,
      },
      isModalOpen: {
        type: Boolean,
        required: true,
      },
    },
    components: {
      Modal,
      BodyText,
      CancelConfirmButton,
    },
  };
  </script>
  