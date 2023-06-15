<template>
    <v-table density="compact"  class="bg-secondary elevation-2">
      <tbody>
        <tr v-for="social_media in company?.socialMedia" :key="social_media.name">
          <td>{{ social_media.name }}:</td>
          <td>{{ social_media.link }}</td>
        </tr>
      </tbody>
    </v-table>
  </template>
  
  <script lang="ts">
  import { Company } from "@/appTypes/Company";
  
  export default {
    props: {
      company: {
        type: Object as () => Company,
        require: true,
      },
    },
  };
  </script>
  