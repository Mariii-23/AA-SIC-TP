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
        path: "recover-password",
        name: "RecoverPassword",
        component: () => import("@/views/RecoverPassword.vue"),
      },
      {
        path: "product/:id",
        name: "ProductPage",
        component: () => import("@/views/Product.vue"),
      },
      {
        path: "category/:id",
        name: "Category",
        component: () => import("@/views/Category.vue"),
      },

      //ADMIN
      {
        path: "admin/add-admin/",
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
        path: "admin/profile",
        name: "Admin profile",
        component: () => import("@/views/Admin/AdminProfile.vue"),
      },
      {
        path: "admin/materials",
        name: "Materials",
        component: () => import("@/views/Admin/StoreMaterials.vue"),
      },
      {
        path: "admin/materials/add",
        name: "Add Materials",
        component: () => import("@/views/Admin/AddMaterial.vue"),
      },
      {
        path: "admin/company",
        name: "Company",
        component: () => import("@/views/Admin/Company.vue"),
      },
      {
        path: "admin/company/edit",
        name: "CompanyEdit",
        component: () => import("@/views/Admin/EditCompany.vue"),
      },
      {
        path: "admin/categories",
        name: "Categories",
        component: () => import("@/views/Admin/StoreCategories.vue"),
      },
      {
        path: "/admin/categories/add",
        name: "Add Category",
        component: () => import("@/views/Admin/AddCategory.vue"),
      },
      {
        path: "/admin/categories/edit/:id",
        name: "Edit Category",
        component: () => import("@/views/Admin/EditCategory.vue"),
      },
      {
        path: "admin/profile/edit",
        name: "ProfileEdit",
        component: () => import("@/views/Admin/EditProfile.vue"),
      },
      {
        path: "admin/product/add",
        name: "AddProduct",
        component: () => import("@/views/Admin/AddProduct.vue"),
      },
      {
        path: "admin/product/edit/:id",
        name: "EditProduct",
        component: () => import("@/views/Admin/EditProduct.vue"),
      },
      {
        path: "admin/orders/pending",
        name: "OrdersPending",
        component: () => import("@/views/Admin/Orders/PendingOrders.vue"),
      },
      {
        path: "admin/orders/pending/:id",
        name: "OrderPendingDetails",
        component: () => import("@/views/Admin/Orders/PendingOrderDetails.vue"),
      },
      {
        path: "admin/orders/ready",
        name: "OrdersReady",
        component: () => import("@/views/Admin/Orders/ReadyOrders.vue"),
      },
      {
        path: "admin/orders/ready/:id",
        name: "OrderReadyDetails",
        component: () => import("@/views/Admin/Orders/ReadyOrderDetails.vue"),
      },
      {
        path: "admin/orders/done",
        name: "OrdersDone",
        component: () => import("@/views/Admin/Orders/DoneOrders.vue"),
      },
      {
        path: "admin/orders/done/:id",
        name: "OrderDoneDetails",
        component: () => import("@/views/Admin/Orders/DoneOrderDetails.vue"),
      },

      //USER
      {
        path: "user/profile",
        name: "User profile",
        component: () => import("@/views/User/Profile.vue"),
      },
      {
        path: "user/profile/edit",
        name: "User profile edit",
        component: () => import("@/views/User/EditProfile.vue"),
      },
      {
        path: "user/orders",
        name: "User Orders",
        component: () => import("@/views/User/Orders.vue"),
      },
      {
        path: "user/orders/:id",
        name: "Order info",
        component: () => import("@/views/User/OrderDetails.vue"),
      },
      {
        path: "user/cart",
        name: "User Cart",
        component: () => import("@/views/User/ShoppingCart.vue"),
      },
      {
        path: "user/favourites",
        name: "User Favourites",
        component: () => import("@/views/User/Favourites.vue"),
      },
    ],
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
