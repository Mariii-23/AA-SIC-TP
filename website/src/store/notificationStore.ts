import { defineStore } from "pinia";
import { AlertProps } from "@/appTypes/Alert";

export const useNotificationStore = defineStore("notification", {
  state: () => ({
    id: 1,
    successAlert: [] as AlertProps[],
    errorAlert: [] as AlertProps[],
  }),
  actions: {
    closeSuccessAlert(id: number) {
      this.successAlert = this.successAlert.filter(
        (e: AlertProps) => e.id != id
      );
    },
    closeErrorAlert(id: number) {
      this.errorAlert = this.errorAlert.filter((e: AlertProps) => e.id != id);
    },
    openSuccessAlert(text: string) {
      this.successAlert.push({
        id: this.id,
        text: text,
      } as AlertProps);
      this.id = this.id + 1;
    },
    openErrorAlert(text: string) {
      this.errorAlert.push({
        id: this.id,
        text: text,
      } as AlertProps);
      this.id = this.id + 1;
    },
  },
});
