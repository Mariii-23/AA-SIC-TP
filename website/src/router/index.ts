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
        path: "product",
        name: "ProductPage",
        component: () => import("@/views/Product.vue"),
      },
      {
      path: "category/:id",
        name: "Category",
        component: () => import("@/views/Category.vue"),
      },
      // FIXME: alterar pagina 
      {
        path: "/category/:id/subcategory/:subCategoryId",
        name: "SubCategory",
        component: () => import("@/views/LayoutTry.vue"),
      },

      //ADMINN
      {
        path: "addAdmin/",
        name: "Add Admin",
        component: () => import("@/views/Admin/AddAdmin.vue"),
      },
      {
        path: "admin/client/",
        name: "Users",
        component: () => import("@/views/Admin/Clients.vue"),
      },
      {
        path: "admin/client/:id",
        name: "Client info",
        component: () => import("@/views/Admin/Client.vue"),
      },
      {
        path: "admin/",
        name: "Admins",
        component: () => import("@/views/Admin/Admins.vue"),
      },
      {
        path: "admin/:id",
        name: "Admin info",
        component: () => import("@/views/Admin/Admin.vue"),
      }, 
      {
        path: "admin/profile",
        name: "Admin profile",
        component: () => import("@/views/Admin/AdminProfile.vue"),
      },
      {
        path: "materials",
        name: "Materials",
        component: () => import("@/views/Admin/StoreMaterials.vue"),
      },
      {
        path: "company",
        name: "Company",
        component: () => import("@/views/Admin/Company.vue"),
      },
      {
        path: "company/edit",
        name: "CompanyEdit",
        component: () => import("@/views/Admin/EditCompany.vue"),
      }
    ],
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
