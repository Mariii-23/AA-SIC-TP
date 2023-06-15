<template>
  <v-table density="compact" class="bg-secondary elevation-3">
    <tbody>
      <tr v-for="item in items" :key="item.id">
        <td>
          <Avatar class="avatar" :href="item.href" :size="20" />
        </td>
        <td>{{ item.name }}</td>
        <td class="actions">
          <v-btn @click="editItem && editItem(item.name)" class="elevation-0 bg-secondary">
            <v-icon>mdi-pencil-outline</v-icon>
          </v-btn>

          <v-btn @click="deleteItem && deleteItem(item.name)" class="elevation-0 bg-secondary">
            <v-icon>mdi-trash-can-outline</v-icon>
          </v-btn>
        </td>
      </tr>
    </tbody>
  </v-table>
</template>
  
<script lang="ts">
import { Item } from "@/appTypes/Product";
import Avatar from "@/components/atoms/AvatarVue.vue";

export default {
  props: {
    items: {
      type: Array as () => Item[],
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
  