<template>
  <div class="cancel-confirm-buttons-wrapper">
    <PrimaryButton class="primary" @click="cancelHandler">
      {{ $t("cancel") }}
    </PrimaryButton>
    <SecondaryButton @click="confirmHandler">
      {{ $t("confirm") }}
    </SecondaryButton>
  </div>
</template>

<script lang="ts">
import PrimaryButton from "@/components/atoms/Button/PrimaryButton.vue";
import SecondaryButton from "@/components/atoms/Button/SecondaryButton.vue";

export default {
  name: "RemoveAdminModal",
  props: {
    cancelHandler: {
      type: Function,
    },
    confirmHandler: {
      type: Function,
    },
  },
  components: { PrimaryButton, SecondaryButton },
};
</script>

<style>
.cancel-confirm-buttons-wrapper {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  width: 100%;
}
</style>
