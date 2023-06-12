// Composables
import { createRouter, createWebHistory } from "vue-router";

const routes = [
  {
    path: "/",
    component: () => import("@/layouts/default/Default.vue"),
    children: [
      {
        path: "",
        name: "Home",
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () =>
          import(/* webpackChunkName: "home" */ "@/views/Home.vue"),
      },
      {
        path: "login",
        name: "Login",
        component: () => import("@/views/Login.vue"),
      },
      {
        path: "register",
        name: "Register",
        component: () => import("@/views/Register.vue"),
      },
      {
        path: "register-personal-data",
        name: "RegisterPersonalData",
        component: () => import("@/views/RegisterPersonalData.vue"),
      },
      {
        path: "try",
        name: "Layout",
        component: () => import("@/views/LayoutTry.vue"),
      },
      {
        path: "recover-password",
        name: "RecoverPassword",
        component: () => import("@/views/RecoverPassword.vue"),
      },
      {
        path: "date-picker",
        name: "DatePicker",
        component: () => import("@/views/DatePicker.vue"),
      },
    ],
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
