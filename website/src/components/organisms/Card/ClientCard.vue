<template>
  <CardLayout class="bg-secondary">
    <v-card-item>
        <ClientTable :client="client"/>
    </v-card-item>
  </CardLayout>
</template>

<script lang="ts">
import { UserInfoProps } from "@/appTypes/User";
import CardLayout from "@/layouts/CardLayout.vue";
import ClientTable from "../Table/ClientTable.vue";

export default {
  name: "ClientCard",
  props: {
    client: {
      type: Object as () => UserInfoProps,
    },
  },
  components: { CardLayout, ClientTable },
};
</script>

