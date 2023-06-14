<template>
  <Modal
    :is-open="isModalOpen"
    :close-modal="closeModal"
    :title="$t('removeAdmin')"
  >
    <template v-slot:body-modal>
      <BodyText>
        {{ $t("rm-admin-text") }}
      </BodyText>
    </template>
    <template v-slot:actions-modal>
      <CancelConfirmButton
        :cancel-handler="closeModal"
        :confirm-handler="removeAdminHandler"
      />
    </template>
  </Modal>
</template>

<script lang="ts">
import BodyText from "@/components/atoms/Typography/BodyText.vue";
import CancelConfirmButton from "@/components/molecules/CancelConfirmButtons.vue";
import Modal from "./Modal.vue";

export default {
  name: "RemoveAdminModal",
  props: {
    removeAdminHandler: {
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
