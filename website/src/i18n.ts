import { createI18n } from "vue-i18n";

import en from "./locales/en/common.json";
import pt from "./locales/pt/common.json";

const i18n = createI18n({
  locale: "en", // set locale
  // set locale messages
  messages: {
    en,
    pt,
  },
});

export default i18n;
