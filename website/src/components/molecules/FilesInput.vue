<template>
  <CardLayout class="bg-secondary">
    <v-card-text class="fill-height">
      <form ref="form" @submit.prevent="addHandler">
        <div class="custom-flex">
          <v-file-input
            multiple
            chips
            :required="filesRequired"
            accept="image/*"
            :label="label"
            @change="handleFileSelection"
            @click:clear="clearInputImages"
            bg-color="primary"
            :rules="imageRules"
          />

          <FullWidthButton :handle-click="() => {}">
            {{ buttonText }}</FullWidthButton
          >
        </div>
      </form>
    </v-card-text>
  </CardLayout>
</template>

<script lang="ts">
import FullWidthButton from "../atoms/Button/FullWidthButton.vue";
import CardLayout from "@/layouts/CardLayout.vue";

export default {
  name: "FilesInput",
  data() {
    return {
      files: [] as string[],
      imageRules: [
        (value: string) => {
          if (value !== "") return true;

          return this.$t("img-required");
        },
      ],
    };
  },
  props: {
    buttonText: {
      type: String,
      required: true,
    },
    label: {
      type: String,
      default: "File input",
    },
    register: {
      type: Function,
    },
    filesRequired: {
      type: Boolean,
      default: true,
    },
  },
  methods: {
    clearInputImages() {
      this.files = [];
    },
    handleFileSelection(event) {
      const filesInput = event.target;
      this.files = [];

      const files = filesInput.files; // Acessar a propriedade 'files'

      for (const file of files) {
        const reader = new FileReader();
        reader.onload = () => {
          const arrayBuffer = reader.result;
          const bytes = new Uint8Array(arrayBuffer);
          let binaryString = "";
          for (let i = 0; i < bytes.length; i++) {
            binaryString += String.fromCharCode(bytes[i]);
          }
          this.files.push(btoa(binaryString));
        };

        reader.readAsArrayBuffer(file);
      }
    },
    addHandler() {
      this.register && this.register(this.files);
    },
  },
  components: {
    FullWidthButton,
    CardLayout,
  },
};
</script>
