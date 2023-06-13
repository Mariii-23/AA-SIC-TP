<template>
  <v-table density="compact"  class="bg-secondary">
    <tbody>
      <tr key="name">
        <td>{{ $t("name") }}:</td>
        <td>{{ admin?.name }}</td>
      </tr>
      <tr key="email">
        <td>{{ $t("email") }}:</td>
        <td>{{ admin?.email }}</td>
      </tr>
      <tr key="nif">
        <td>{{ $t("nif") }}:</td>
        <td>{{ admin?.nif }}</td>
      </tr>
      <tr key="address">
        <td>{{ $t("address") }}:</td>
        <td>{{ admin?.address }}</td>
      </tr>
    </tbody>
  </v-table>
</template>

<script lang="ts">
import { UserInfoProps } from "@/appTypes/User";

export default {
  props: {
    admin: {
      type: Object as () => UserInfoProps,
      require: true,
    },
  },
};
</script>
