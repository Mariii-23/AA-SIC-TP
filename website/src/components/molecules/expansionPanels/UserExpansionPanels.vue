<template>
  <v-expansion-panels variant="popout">
    <ExpansionPanelLayout v-for="user in users" :key="user.id">
      <template v-slot:title>
        <TitleWithButton
          :size="5"
          :title="`${$t('client')} #${user.id}`"
          :button-text="$t('viewDetails')"
          :button-handler="
            () => viewDetailsHandler && viewDetailsHandler(user.id)
          "
        />
        <div class="user-title-info-wrapper">
          <div>{{ $t("name") }}: {{ user.name }}</div>
          <div>{{ $t("email") }}: {{ user.email }}</div>
        </div>
      </template>
      <template v-slot:text>
        <UserTableInfo :user="user" />
      </template>
    </ExpansionPanelLayout>
  </v-expansion-panels>
</template>

<style>
.user-title-info-wrapper {
  display: flex;
  flex-direction: column;
  gap: 10px;
}
</style>

<script lang="ts">
import { UserInfoProps } from "@/appTypes/User";
import ExpansionPanelLayout from "./ExpansionPanelLayout.vue";
import UserTableInfo from "./BodyExpansionPanel/UserTableInfo.vue";
import TitleWithButton from "../TitleWithButton.vue";

export default {
  name: "UserExpansionPanels",
  props: {
    users: {
      type: Array as () => UserInfoProps[],
      require: true,
    },
    viewDetailsHandler: {
      type: Function,
    },
  },
  components: {
    ExpansionPanelLayout,
    UserTableInfo,
    TitleWithButton,
  },
};
</script>
