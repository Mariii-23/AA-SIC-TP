<template>
  <v-table density="compact"  class="bg-secondary">
    <tbody>
      <tr key="name">
        <td>{{ $t("name") }}:</td>
        <td>{{ client?.name }}</td>
      </tr>
      <tr key="email">
        <td>{{ $t("email") }}:</td>
        <td>{{ client?.email }}</td>
      </tr>
      <tr key="nif">
        <td>{{ $t("nif") }}:</td>
        <td>{{ client?.nif }}</td>
      </tr>
      <tr key="address">
        <td>{{ $t("address") }}:</td>
        <td>{{ client?.address }}</td>
      </tr>
    </tbody>
  </v-table>
</template>

<script lang="ts">
import { UserInfoProps } from "@/appTypes/User";

export default {
  props: {
    client: {
      type: Object as () => UserInfoProps,
      require: true,
    },
  },
};
</script>
