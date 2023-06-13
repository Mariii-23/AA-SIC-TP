<template>
  <div v-if="isAlert">
    <SuccessAlert title="A operacao foi realizada com sucesso" />
    <ErrorAlert title="A operacao foi realizada com sucesso" />
    <WarningAlert title="A operacao foi realizada com sucesso" />
  </div>

  <div class="ola">
    <TwoColumnsPanel>
      <template v-slot:first>
        <TitleCardLinksButton
          title="All Users"
          :items="items"
          button-text="Add User"
          :button-handler="addUserHandler"
        />
      </template>
      <template v-slot:second>
        <TitleWithButton
          title="All Users"
          button-text="New user"
          :button-handler="addUserHandler"
        />
        <v-container />
        <TitleWithGoBack title="All Users" />
        <v-container />
        <TitleWithEditButton title="All Users" :edit-handler="addUserHandler" />

        <SecondaryButton :handle-click="openModal" @close="closeModal">
          Abrir Modal
        </SecondaryButton>

        <modal
          :is-open="isModalOpen"
          :close-modal="closeModal"
          title="Ola mundo"
        >
          <template v-slot:body-modal>
            laksdjfal laksjflka sd adslfkjalk
          </template>
          <template v-slot:actions-modal>
            <PrimaryButton @click="closeModal"> Fechar </PrimaryButton>
            <SecondaryButton @click="closeModal"> Yes </SecondaryButton>
          </template>
        </modal>

        <v-container />
      </template>
    </TwoColumnsPanel>
  </div>
</template>

<script lang="ts">
import TitleWithButton from "@/components/molecules/TitleWithButton.vue";
import TitleCardLinksButton from "@/components/organisms/TitleCardLinksButton.vue";
import TitleWithGoBack from "@/components/molecules/TitleGoBack.vue";
import TwoColumnsPanel from "@/layouts/Body/TwoColumnsPanel.vue";
import TitleWithEditButton from "@/components/molecules/TitleWithEditButton.vue";
import Modal from "@/components/organisms/Modal.vue";
import SecondaryButton from "@/components/atoms/Button/SecondaryButton.vue";
import SuccessAlert from "@/components/atoms/Alert/SuccessAlert.vue";
import ErrorAlert from "@/components/atoms/Alert/ErrorAlert.vue";
import WarningAlert from "@/components/atoms/Alert/WarningAlert.vue";

export default {
  name: "try",
  data: () => ({
    items: [],
    isModalOpen: false,
    isAlert: false,
  }),
  mounted: function () {
    this.isModalOpen = false;
    this.isAlert = false;
    this.items = [
      { href: "/try", icon: "brightness-1", text: "ola heheh" },
      { href: "/login", icon: "brightness-1", text: "ola heheh" },
      { href: "/try", icon: "bullseye", text: "ola heheh" },
      { href: "/login", icon: "bullseye", text: "ola heheh" },
      { href: "/login", icon: "bullseye", text: "ola heheh" },
      { href: "/login", icon: "brightness-1", text: "ola heheh" },
    ];
  },
  components: {
    TwoColumnsPanel,
    TitleCardLinksButton,
    TitleWithButton,
    TitleWithGoBack,
    TitleWithEditButton,
    Modal,
    SecondaryButton,
    SuccessAlert,
    ErrorAlert,
    WarningAlert,
  },
  methods: {
    addUserHandler() {
      console.log("cliquei");
      this.isAlert = true;
    },
    openModal() {
      this.isModalOpen = true;
    },
    closeModal() {
      this.isModalOpen = false;
    },
  },
};
</script>

<style>
.ola {
  position: sticky;
  top: 0;
  padding: 3%;
}
</style>
