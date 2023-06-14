<template>
    <v-table density="compact"  class="bg-secondary elevation-3">
      <tbody>
        <tr v-for="material in materials" :key="material.id">
          <td>
              <Avatar class="avatar" :href="material.href" :size="20" />
          </td>
          <td>{{ material.name}}</td>
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
    }, 
    components: {
        Avatar
    }
  };
  </script>
  