<template>
    <v-table density="compact"  class="bg-secondary elevation-2">
      <tbody>
        <tr>
          <td>{{ $t("address") }}:</td>
          <td>{{ company?.address }}</td>
        </tr>
        <tr>
          <td>{{ $t("postal-code") }}:</td>
          <td>{{ company?.postCode }}</td>
        </tr>
        <tr>
          <td>{{ $t("schedule") }}:</td>
          <td>{{ company?.schedule }}</td>
        </tr>
        <tr>
          <td>{{ $t("phoneNo") }}:</td>
          <td>{{ company?.contact }}</td>
        </tr>
        <tr>
          <td>{{ $t("email") }}:</td>
          <td>{{ company?.email }}</td>
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
  