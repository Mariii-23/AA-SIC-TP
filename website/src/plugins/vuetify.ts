/**
 * plugins/vuetify.ts
 *
 * Framework documentation: https://vuetifyjs.com`
 */

// Styles
import "@mdi/font/css/materialdesignicons.css";
import "vuetify/styles";

// Composables
import { createVuetify } from "vuetify";

const customLightTheme = {
  dark: false,
  colors: {
    background: "#EDEDE9",
    surface: "#D5BDAF",
    primary: "#E3D5CA",
    secondary: "#F5EBE0",
    error: "#E5989B", // FIXME: change me
    info: "#FFCDB2", // FIXME: change me
    success: "#4caf50", // FIXME: change me
    warning: "#fb8c00", // FIXME: change me
  },
};

const customDarkTheme = {
  dark: true,
  colors: {
    background: "#E3D5CA",
    surface: "#F5EBE0",
    primary: "#EDEDE9",
    secondary: "#F5EBE0",
    error: "#E5989B", // FIXME: change me
    info: "#FFCDB2", // FIXME: change me
    success: "#4caf50", // FIXME: change me
    warning: "#fb8c00", // FIXME: change me
  },
};

// https://vuetifyjs.com/en/introduction/why-vuetify/#feature-guides
export default createVuetify({
  theme: {
    defaultTheme: "customLightTheme",
    themes: {
      customLightTheme,
      customDarkTheme,
    },
  },
});
