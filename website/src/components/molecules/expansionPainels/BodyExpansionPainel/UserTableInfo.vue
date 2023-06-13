<template>
  <v-table density="compact"  class="bg-secondary">
    <tbody>
      <tr :key="user?.id">
        <td>{{ $t("nif") }}:</td>
        <td>{{ user?.nif }}</td>
      </tr>
      <tr :key="user?.id">
        <td>{{ $t("address") }}:</td>
        <td>{{ user?.address }}</td>
      </tr>
    </tbody>
  </v-table>
</template>

<script lang="ts">
import { UserInfoProps } from "@/appTypes/User";

export default {
  props: {
    user: {
      type: Object as () => UserInfoProps,
      require: true,
    },
  },
};
</script>
