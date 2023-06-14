<template>
  <CardLayout class="bg-secondary">
    <v-card-item>
        <AdminTable :admin="admin"/>
    </v-card-item>
  </CardLayout>
</template>

<script lang="ts">
import { UserInfoProps } from "@/appTypes/User";
import CardLayout from "@/layouts/CardLayout.vue";
import AdminTable from "../Table/AdminTable.vue";

export default {
  name: "AdminCard",
  props: {
    admin: {
      type: Object as () => UserInfoProps,
    },
  },
  components: { CardLayout, AdminTable },
};
</script>

