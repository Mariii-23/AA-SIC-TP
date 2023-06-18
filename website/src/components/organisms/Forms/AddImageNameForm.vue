<template>
  <CardLayout class="bg-secondary">
    <v-card-text class="fill-height">
      <form ref="form" @submit.prevent="addHandler()">
        <div class="custom-flex">
          <v-file-input
            accept="image/*"
            :label="photo"
            @change="handleFileUpload"
            :rules="imageRules"
          />
          <v-text-field
            v-model="name"
            name="name"
            :label="$t('name')"
            type="text"
            :placeholder="$t('name')"
            required
            :rules="nameRules"
          />

        <FullWidthButton :handle-click="() => {}">
          {{ $t("next") }}</FullWidthButton
        >
        </div>
      </form>
    </v-card-text>
  </CardLayout>
</template>

<script lang="ts">
import FullWidthButton from "@/components/atoms/Button/FullWidthButton.vue";
import CardLayout from "@/layouts/CardLayout.vue";

export default {
  name: "Add Image and Name form",
  data() {
    return {
      name: "",
      nameRules: [
        value => {
          if (value?.length >= 3 && /[^0-9]/.test(value)) return true

          return this.$t("invalid-name")
        },
      ],
      photo: "",
      imageRules:  [
        value => {
          if (!value) return true

          return this.$t("img-required")
        },
      ],
    };
  },
  props: {
    register: {
      type: Function,
    },
  },
  methods: {
    handleFileUpload(event) {
      const file = event.target.files[0];

      const reader = new FileReader();
      reader.onload = () => {
        const arrayBuffer = reader.result;
        const bytes = new Uint8Array(arrayBuffer);
        let binaryString = "";
        for (let i = 0; i < bytes.length; i++) {
          binaryString += String.fromCharCode(bytes[i]);
        }
        this.photo = btoa(binaryString);
      };

      reader.readAsArrayBuffer(file);
    },
    addHandler() {
      this.register && this.register(this.name, this.photo);
    },
  },
  components: { FullWidthButton, CardLayout },
};
</script>

<style>
.custom-flex {
  display: flex;
  flex-direction: column;
  gap: 20px;
}
</style>