<template>
  <v-expansion-panels variant="popout">
    <ExpansionPainelLayout v-for="user in admins" :key="user.id">
      <template v-slot:title>
        <TitleWithButton
          :size="5"
          :title="`${$t('admin')} #${user.id}`"
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
    </ExpansionPainelLayout>
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
import ExpansionPainelLayout from "./ExpansionPainelLayout.vue";
import UserTableInfo from "./BodyExpansionPainel/UserTableInfo.vue";
import TitleWithButton from "../TitleWithButton.vue";

export default {
  name: "AdminExpansionPainels",
  props: {
    admins: {
      type: Array as () => UserInfoProps[],
      require: true,
    },
    viewDetailsHandler: {
      type: Function,
    },
  },
  components: {
    ExpansionPainelLayout,
    UserTableInfo,
    TitleWithButton,
  },
};
</script>
