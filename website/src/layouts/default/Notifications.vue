<template>
  <div v-for="error in errorAlerts" v-bind:key="error.id">
    <ErrorAlert :title="$t(error.text)" :on-close="() => onCloseError(error.id)" />
  </div>
  <div v-for="success in successsAlerts" v-bind:key="success.id">
    <SuccessAlert
      :title="$t(success.text)"
      :on-close="() => onCloseSuccess(success.id)"
    />
  </div>
</template>

<script lang="ts">
import ErrorAlert from "@/components/atoms/Alert/ErrorAlert.vue";
import SuccessAlert from "@/components/atoms/Alert/SuccessAlert.vue";
import { useNotificationStore } from "@/store/notificationStore";
import { AlertProps } from "@/appTypes/Alert";
const notificationStore = useNotificationStore();

export default {
  name: "notifications",
  components: {
    ErrorAlert,
    SuccessAlert,
  },
  data: () => ({
    successsAlerts: [] as AlertProps[],
    errorAlerts: [] as AlertProps[],
  }),
  mounted: async function () {
    this.successsAlerts = notificationStore.successAlert;
    this.errorAlerts = notificationStore.errorAlert;

    this.$watch(
      () => ({ successsAlerts: notificationStore.successAlert }),
      (newValues) => {
        this.successsAlerts = newValues.successsAlerts;
      }
    );
    this.$watch(
      () => ({ errorAlerts: notificationStore.errorAlert }),
      (newValues) => {
        this.errorAlerts = newValues.errorAlerts;
      }
    );
  },
  methods: {
    onCloseSuccess: (id: number) => {
      notificationStore.closeSuccessAlert(id);
    },
    onCloseError: (id: number) => {
      notificationStore.closeErrorAlert(id);
    },
  },
};
</script>
