<template>
  <div v-for="(textField, i) in textFields" :key="i" class="text-fields-row">
    <v-file-input
      class="mr-2"
      bg-color="primary"
      :label="textField.value1"
      accept="image/*"
      @change="handleFileUpload"
    />

    <v-text-field
      bg-color="primary"
      :label="$t('value')"
      v-model="textField.value2"
    />

    <v-icon size="30" @click="remove(i)" class="error">
      mdi-trash-can-outline</v-icon
    >
  </div>
  <v-icon size="30" @click="add" class="mb-5"> mdi-plus</v-icon>
</template>

<script lang="ts">
export default {
  name: "Add Subcategories Form",
  data: () => ({
    photo : "",
    textFields: [] as {
      value1: string;
      value2: string;
    }[],
  }),
  mounted: function () {
    this.textFields.push({
      value1: "",
      value2: "",
    });
  },
  methods: {
    add() {
      this.textFields.push({
        value1: "",
        value2: "",
      });
    },
    remove(index: number) {
      this.textFields.splice(index, 1);
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
  },
  components: {},
};
</script>

<style scoped>
.body {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 800px;
  margin: 3% auto auto auto;
}
.text-fields-row {
  display: flex;
}
</style>
