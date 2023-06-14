/**
 * main.ts
 *
 * Bootstraps Vuetify and other plugins then mounts the App`
 */

// Components
import App from "./App.vue";
import axios from "./plugins/axios/axios";
// Composables
import { createApp } from "vue";

// Plugins
import { registerPlugins } from "@/plugins";

import i18n from "./i18n";

import pinia from "./store";

const app = createApp(App);

registerPlugins(app);

app.use(i18n);
app.use(pinia);
app.use(axios, {
  baseUrl: "http://localhost:8080",
});

app.mount("#app");

export { app };
