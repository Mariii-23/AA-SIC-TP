module.exports = {
  env: {
    node: true,
  },
  extends: [
    "plugin:vue/vue3-essential",
    "eslint:recommended",
    "@vue/eslint-config-typescript",
  ],
  // parser: "@typescript-eslint/parser",
  // parserOptions: {
  //   ecmaFeatures: {
  //     jsx: true,
  //   },
  //   ecmaVersion: 13,
  //   sourceType: "module",
  // },
  plugins: ["@typescript-eslint"],
  rules: {
    "vue/multi-word-component-names": "off",
    quotes: [2, "double"],
    "vue/html-self-closing": [
      "error",
      {
        html: {
          void: "always", // exige a sintaxe de fechamento automático para tags vazias
        },
      },
    ],
  },
};
