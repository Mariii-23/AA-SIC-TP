<template>
    <Modal
      :is-open="isModalOpen"
      :close-modal="closeModal"
      :title="$t('remove-product')"
    >
      <template v-slot:body-modal>
        <BodyText>
          {{ $t("modal-remove-product") }} {{ productName }}?
        </BodyText>
      </template>
      <template v-slot:actions-modal>
        <CancelConfirmButton
          :cancel-handler="closeModal"
          :confirm-handler="removeProductHandler"
        />
      </template>
    </Modal>
  </template>
  
  <script lang="ts">
  import BodyText from "@/components/atoms/Typography/BodyText.vue";
  import CancelConfirmButton from "@/components/molecules/CancelConfirmButtons.vue";
  import Modal from "@/components/organisms/Modal.vue";
  
  export default {
    name: "RemoveProductModal",
    props: {
        productName: {
            type: String,
            required: true,
        },
      removeProductHandler: {
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
  