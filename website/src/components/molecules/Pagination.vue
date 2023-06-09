<template>
  <div class="text-center">
    <v-pagination
      v-model="page"
      :length="length"
      :total-visible="totalVisible"
      @update:model-value="handlePageChange"
    />
  </div>
</template>

<script lang="ts">
export default {
  name: "Pagination",
  data() {
    return {
      page: 1,
    };
  },
  props: {
    length: {
      type: String,
      require: true,
    },
    totalVisible: {
      type: String,
      require: true,
    },
    handlePageChange: {
      type: Function,
      require: true,
    },
  },
};
</script>
