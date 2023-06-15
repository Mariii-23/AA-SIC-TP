<template>
  <v-file-input
    multiple
    chips
    accept="image/*"
    :label="label"
    @change="handleFileSelection"
    class="bg-primary"
  />
</template>

<script lang="ts">
export default {
  name: "FilesInput",
  data: () => ({
    files: [],
  }),
  props: {
    label: {
      type: String,
      default: "File input",
    },
  },
  methods: {
    handleFileSelection(event) {
      this.files = event.target.files;
      const file = event.target.files[0];
      const formData = new FormData();
      formData.append("file", file);
      console.log(formData);
    },
  },
};
</script>
