<template>
  <ConfirmationModal :title="$t('logout')" :text="$t('logout-text')" :confirmHandler="logout" :closeModal="closeModal"
    :isModalOpen="isModalOpen" />
  <v-app-bar>
    <v-app-bar-nav-icon @click="changeDrawer">
      <v-icon>mdi-menu</v-icon>
    </v-app-bar-nav-icon>

    <v-app-bar-nav-icon>
      <Logo class="logo" />
    </v-app-bar-nav-icon>

    <v-spacer />

      <v-autocomplete class="search-bar mt-5" 
      append-inner-icon="mdi-magnify"
      :items="products"
       v-model="name" 
       menu-icon=""
       width="100%" 
       bg-color="secondary"
        @change="search()"/>

    <v-spacer />

    <!--FOR USERS-->
    <div v-if="!loggedIn" class="icon-w-text">
      <v-btn to="/login" icon>
        <v-icon>mdi-account-circle-outline</v-icon>
      </v-btn>
      <BodyText class="navbar_text">
        {{ $t("navbar-login") }}
      </BodyText>
    </div>

    <div v-if="loggedIn && user_type === 'CUSTOMER'" class="icon-w-text" @click="userAccountHandler">
      <v-btn icon>
        <v-icon>mdi-account-circle</v-icon>
      </v-btn>
      <BodyText class="navbar_text">
        {{ $t("welcome") }} {{ truncatedUsername }}
      </BodyText>
    </div>


    <v-btn icon v-if="loggedIn && user_type == 'CUSTOMER'" @click="goTo('/user/cart')">
      <v-icon>mdi-shopping-outline</v-icon>
    </v-btn>


    <v-btn icon v-if="loggedIn && user_type == 'CUSTOMER'" @click="goTo('/user/favourites')">
      <v-icon>mdi-heart-outline</v-icon>
    </v-btn>

    <!--FOR ADMINS-->
    <div @click="goTo('/admin/orders/pending')">
      <v-btn v-if="loggedIn && user_type == 'ADMIN'">
        <BodyText id="orders-text">{{ $t("orders") }}</BodyText>
      </v-btn>
    </div>
    <div @click="goTo('/admin/profile')">
      <v-btn icon v-if="loggedIn && user_type == 'ADMIN'">
        <v-icon>mdi-account-group-outline</v-icon>
      </v-btn>
    </div>
    <div @click="goTo('/admin/company')">
      <v-btn icon v-if="loggedIn && user_type == 'ADMIN'">
        <v-icon>mdi-store-edit-outline</v-icon>
      </v-btn>
    </div>

    <LanguageSwitcher class="lang-switcher" />

    <div @click="openModal">
      <v-btn icon v-if="loggedIn">
        <v-icon>mdi-logout</v-icon>
      </v-btn>
    </div>

  </v-app-bar>
</template >

<script lang="ts">
import Logo from "@/components/atoms/Logo.vue";
import BodyText from "../atoms/Typography/BodyText.vue";
import { usedrawerStore } from "@/store/drawerStore";
import LanguageSwitcher from "@/components/molecules/LanguageSwitcher.vue";
import SearchBar from "@/components/molecules/SearchBar.vue";
import { useUserStore } from "@/store/userStore";
import ConfirmationModal from "./Modal/ConfirmationModal.vue";
import { useAdminsStore } from "@/store/adminsStore";
import { useProductStore } from "@/store/productStore";
const userStore = useUserStore();
const productsStore = useProductStore();

export default {
  name: "AppBar",
  data: () => ({
    loggedIn: false,
    user_type: "",
    username: "",
    id: "",
    isModalOpen: false,
    name: "",
    products: []
  }),
  setup() {
    const drawerStore = usedrawerStore();

    return {
      drawer: drawerStore.drawer,
      changeDrawer: drawerStore.changeDrawer,
    };
  },
  mounted: async function () {
    this.loggedIn = userStore.isLoggedIn;
    this.user_type = userStore.role;
    this.username = userStore.name;
    this.id = userStore.id;

    await productsStore.getAllProducts(0, 10000);
    for (let i = 0; i < productsStore.products.length; i++) {
                    this.products.push(
                        productsStore.products[i].name
                    );
    }
    // Use o watch para observar as mudanças no userStore
    this.$watch(
      () => ({
        isLoggedIn: userStore.isLoggedIn,
        role: userStore.role,
        name: userStore.name,
        id: userStore.id,
      }),
      (newValues) => {
        this.loggedIn = newValues.isLoggedIn;
        this.user_type = newValues.role;
        this.username = newValues.name;
        this.id = newValues.id;
      }
    );

      this.$watch(
        () => this.name,
        (newValues) => {
          this.name = newValues;
          this.search();
        }
      );
  
  },
  computed: {
    truncatedUsername() {
      if (this.username.length > 8) {
        return this.username.split(" ")[0];
      }
      return this.username;
    },
  },
  methods: {
    goTo(path: string) {
      this.$router.push(path);
    },
    logout() {
      const adminsStore = useAdminsStore();
      adminsStore.clearStore();
      userStore.logout();
      this.$router.push("/");
      this.isModalOpen = false;
    },
    openModal() {
      this.isModalOpen = true;
    },
    closeModal() {
      this.isModalOpen = false;
    },
    userAccountHandler() {
      this.$router.push("/user/profile");
    },
    async search(){;
      const id = await productsStore.search(this.name);
      if (id != false)
        this.$router.push(`/product/${id}`);
    }
  },
  components: { Logo, BodyText, LanguageSwitcher, SearchBar, ConfirmationModal },
};
</script>

<style>
.icon-w-text {
  display: flex;
  flex-direction: row;
  align-items: center;
  padding: 10px;
}

.search-bar {
  width: 30%;
  margin-top: 13px;
  align-content: center;
}


@media screen and (max-width: 800px) {
  .search-bar {
    visibility: hidden;
  }

  .navbar_text {
    visibility: hidden;
    display: none;
  }
}
</style>
