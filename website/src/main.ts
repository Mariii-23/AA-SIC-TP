/**
 * main.ts
 *
 * Bootstraps Vuetify and other plugins then mounts the App`
 */

// Components
import App from "./App.vue";
// Composables
import { createApp } from "vue";

// Plugins
import { registerPlugins } from "@/plugins";

import i18n from "./i18n";

import pinia from "./store";
import DatePicker from "./DatePicker";

const app = createApp(App);

registerPlugins(app);

app.use(i18n);
app.use(pinia);
app.component("DatePicker", DatePicker);

app.mount("#app");
