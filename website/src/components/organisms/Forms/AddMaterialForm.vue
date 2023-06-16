<template>
  <CardLayout class="bg-secondary">
    <v-card-text class="fill-height">
      <form ref="form" @submit.prevent="addMaterialHandler()">
        <div class="custom-flex">
          <v-file-input
            accept="image/*"
            :label="photo"
            class="bg-primary"
            @change="handleFileUpload"
          />
          <v-text-field
            v-model="name"
            name="name"
            :label="$t('name')"
            type="text"
            :placeholder="$t('name')"
            required
          />
        </div>

        <FullWidthButton> {{ $t("addMaterial") }}</FullWidthButton>
      </form>
    </v-card-text>
  </CardLayout>
</template>

<script lang="ts">
import FullWidthButton from "@/components/atoms/Button/FullWidthButton.vue";
import CardLayout from "@/layouts/CardLayout.vue";

export default {
  name: "Login",
  data() {
    return {
      name: "",
      photo: "",
    };
  },
  props: {
    registerMaterial: {
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
      //console.log("Nome do arquivo:", file.name);
      //console.log("Tipo do arquivo:", file.type);
    },
    addMaterialHandler() {
      this.registerMaterial && this.registerMaterial(this.name, this.photo);
    },
  },
  components: { FullWidthButton, CardLayout },
};
</script>
