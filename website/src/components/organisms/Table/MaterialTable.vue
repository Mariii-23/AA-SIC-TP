<template>
  <v-table density="compact" class="bg-secondary elevation-3">
    <tbody>
      <tr v-for="item in items" :key="item.id">
        <td>
          <Avatar class="avatar" :href="item.href" :size="20" />
        </td>
        <td>{{ item.name }}</td>
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
  