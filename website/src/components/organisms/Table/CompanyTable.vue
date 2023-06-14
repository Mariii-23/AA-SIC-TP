<template>
    <v-table density="compact"  class="bg-secondary elevation-2">
      <tbody>
        <tr>
          <td>{{ $t("address") }}:</td>
          <td>{{ company?.address }}</td>
        </tr>
        <tr>
          <td>{{ $t("postal-code") }}:</td>
          <td>{{ company?.postalCode }}</td>
        </tr>
        <tr>
          <td>{{ $t("schedule") }}:</td>
          <td>{{ company?.schedule }}</td>
        </tr>
        <tr>
          <td>{{ $t("phoneNo") }}:</td>
          <td>{{ company?.phoneNo }}</td>
        </tr>
        <tr>
          <td>{{ $t("email") }}:</td>
          <td>{{ company?.email }}</td>
        </tr>
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
  