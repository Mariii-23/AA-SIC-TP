<template>
  <v-table density="compact" class="bg-secondary elevation-3">
    <tbody>
      <tr v-for="material in materials" :key="material.id">
        <td>
          <Avatar class="avatar" :href="material.href" :size="20" />
        </td>
        <td>{{ material.name }}</td>
        <td class="actions">
          <v-btn :onClick="editItem" class="elevation-0 bg-secondary">
            <v-icon>mdi-pencil-outline</v-icon>
          </v-btn>

          <v-btn :onClick="deleteItem" class="elevation-0 bg-secondary">
            <v-icon>mdi-trash-can-outline</v-icon>
          </v-btn>
        </td>
      </tr>
    </tbody>
  </v-table>
</template>
  
<script lang="ts">
import { Materials } from "@/appTypes/Product";
import Avatar from "@/components/atoms/AvatarVue.vue";

export default {
  props: {
    materials: {
      type: Array as () => Materials[],
      require: true,
    },
    editItem: {
      type: Function,
      require: true
    },
    deleteItem: {
      type: Function,
      require: true
    },
  },
  components: {
    Avatar
  }
};
</script>
  