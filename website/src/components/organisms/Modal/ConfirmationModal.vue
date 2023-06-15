<template>
    <Modal
      :is-open="isModalOpen"
      :close-modal="closeModal"
      :title="title"
    >
      <template v-slot:body-modal>
        <BodyText>
          {{ text }}
        </BodyText>
      </template>
      <template v-slot:actions-modal>
        <CancelConfirmButton
          :cancel-handler="closeModal"
          :confirm-handler="confirmHandler"
        />
      </template>
    </Modal>
  </template>
  
  <script lang="ts">
  import BodyText from "@/components/atoms/Typography/BodyText.vue";
  import CancelConfirmButton from "@/components/molecules/CancelConfirmButtons.vue";
  import Modal from "./Modal.vue";
  
  export default {
    name: "ConfirmationModal",
    props: {
        title: {
            type: String,
            required: true,
        },
        text: {
            type: String,
            required: true,
        },
      confirmHandler: {
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
  