<template>
  <CardLayout class="bg-secondary">
    <v-card-item class="card-item-material custom-full-width bg-secondary">
      <ImageCard  v-if="!isEdit" :href="material.href"/>
      <v-card-title v-if="!isEdit" class="card-item-material bg-secondary">
        {{ material.name }}
      </v-card-title>

      <div class="inputImageContainer">
        <v-file-input
          v-if="isEdit"
          accept="image/*"
          :label="$t('image')"
          class="bg-primary custom-full-width"
          @change="handleFileUpload"
        />
      </div>
      <v-card-title class="card-item-material bg-secondary">
        <v-text-field
          class="bg-primary custom-full-width"
          v-if="isEdit"
          :label="textField.label2"
          v-model="textField.value2"
        />
      </v-card-title>
    </v-card-item>
    <div class="actions">
      <PrimaryButton
        class="action elevation-0 bg-secondary"
        v-if="isEdit"
        :handle-click="updateMaterial"
      >
        {{ $t("save") }}
      </PrimaryButton>
      <PrimaryButton
        class="action elevation-0 bg-secondary"
        v-if="isEdit"
        :handle-click="cancelHandler"
      >
        {{ $t("cancel") }}
      </PrimaryButton>

      <v-btn
        v-else
        icon
        class="action elevation-0 bg-secondary"
        @click="editHandler"
      >
        <v-icon>mdi-square-edit-outline</v-icon>
      </v-btn>

      <v-btn
        icon
        @click="removeMaterialHandler"
        class="action bg-secondary elevation-0"
      >
        <v-icon icon="mdi-trash-can-outline" />
      </v-btn>
    </div>
  </CardLayout>
</template>

<script lang="ts">
import { Material } from "@/appTypes/Product";
import PrimaryButton from "@/components/atoms/Button/PrimaryButton.vue";
import CardLayout from "@/layouts/CardLayout.vue";
import ImageCard from "@/components/atoms/ImageCard.vue";

export default {
  name: "MaterialCard",
  data: () => ({
    photo: "",
    isEdit: false,
    textField: {} as {
      label1: String;
      value1: String;
      label2: String;
      value2: String;
    },
  }),
  props: {
    material: {
      type: Object as () => Material,
      required: true
    },
    removeMaterialHandler: {
      type: Function,
    },
    updateMaterialHandler: {
      type: Function,
    },
  },
  mounted: function () {
    this.textField = {
      label1: this.$t("photoLink"),
      value1: "",
      label2: this.$t("title"),
      value2: this.material.name,
    };
  },
  methods: {
    editHandler() {
      this.isEdit = !this.isEdit;
    },
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
    cancelHandler() {
      this.textField = {
        label1: this.$t("photoLink"),
        value1: "",
        label2: this.$t("title"),
        value2: this.material.name,
      };
      this.editHandler();
    },
    async updateMaterial() {
      this.updateMaterialHandler &&
        this.updateMaterialHandler(
          this.material.id,
          this.textField.value2,
          this.photo
        );
      this.editHandler();
    },
  },
  components: { CardLayout, PrimaryButton, ImageCard },
};
</script>

<style scoped>
.custom-full-width {
  width: 100%;
}

.imgContainer {
  width: 150px;
  height: 150px;
}
.inputImageContainer {
  width: 350px;
}

.image {
  border-radius: 5%;
  width: 100%;
  height: 100%;
}

.actions {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}

.card-item-material {
  display: flex;
  justify-content: center;
  width: 100%;
}

.center {
  display: flex;
  justify-content: center;
}
</style>
