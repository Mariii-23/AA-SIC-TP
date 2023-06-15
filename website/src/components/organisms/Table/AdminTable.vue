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
