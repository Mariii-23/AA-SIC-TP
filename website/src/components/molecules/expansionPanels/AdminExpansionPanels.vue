//TODO: corrigir esta pagina
<template>
  <v-list :lines="false" density="compact" nav bg-color="secondary">
    <v-list-item
      v-for="(user, i) in admins"
      :key="i"
      :value="user"
      bg-color="secondary"
      class="elevation-1 flex-grow-2 adminInfoWrapper"
    >
      <TitleWithButton
        :size="5"
        :title="`${$t('admin')} #${user.id}`"
        :button-text="$t('removeAdmin')"
        :button-handler="
          () => removeAdminHandler && removeAdminHandler(user.id)
        "
      />
      <div class="user-title-info-wrapper">
        <div>{{ $t("name") }}: {{ user.name }}</div>
        <div>{{ $t("email") }}: {{ user.email }}</div>
      </div>
    </v-list-item>
  </v-list>
</template>

<style>
.user-title-info-wrapper {
  display: flex;
  flex-direction: column;
  gap: 10px;
}

.adminInfoWrapper {
  gap: 20px;
  margin-top: 10px;
  margin-bottom: 20px;
}
</style>

<script lang="ts">
import { UserInfoProps } from "@/appTypes/User";
import TitleWithButton from "../TitleWithButton.vue";
import CardLayout from "@/layouts/CardLayout.vue";

export default {
  name: "AdminExpansionPanels",
  props: {
    admins: {
      type: Array as () => UserInfoProps[],
      require: true,
    },
    removeAdminHandler: {
      type: Function,
    },
  },
  components: {
    TitleWithButton,
  },
};
</script>
