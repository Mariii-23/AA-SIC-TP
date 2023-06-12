<template>
  <v-app-bar>
    <v-app-bar-nav-icon icon @click="changeDrawer">
      <v-icon>mdi-menu</v-icon>
    </v-app-bar-nav-icon>

    <v-app-bar-nav-icon>
      <Logo class="logo" />
    </v-app-bar-nav-icon>

    <v-spacer />

    <div class="search-bar">
      <SearchBar />
    </div>

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

    <div v-if="loggedIn && user_type === 'customer'" class="icon-w-text">
      <v-btn icon>
        <v-icon>mdi-account-circle</v-icon>
      </v-btn>
      <BodyText class="navbar_text"> {{ $t("welcome") }} {{ truncatedUsername }} </BodyText>
    </div>

    <v-btn icon v-if="loggedIn && user_type == 'customer'">
      <v-icon>mdi-shopping-outline</v-icon>
    </v-btn>

    <v-btn icon v-if="loggedIn && user_type == 'customer'">
      <v-icon>mdi-heart-outline</v-icon>
    </v-btn>


    <!--FOR ADMINS-->
    <v-btn v-if="loggedIn && user_type == 'admin'">
      <BodyText id="orders-text">{{ $t("orders") }}</BodyText>
    </v-btn>
    <v-btn icon v-if="loggedIn && user_type == 'admin'">
      <v-icon>mdi-account-group-outline</v-icon>
    </v-btn>
    <v-btn icon v-if="loggedIn && user_type == 'admin'">
      <v-icon>mdi-store-edit-outline</v-icon>
    </v-btn>



    <LanguageSwitcher class="lang-switcher" />
  </v-app-bar>
</template>

<script lang="ts">
import Logo from "@/components/atoms/Logo.vue";
import BodyText from "../atoms/Typography/BodyText.vue";
import { usedrawerStore } from "@/store/drawerStore";
import LanguageSwitcher from "@/components/molecules/LanguageSwitcher.vue";
import SearchBar from "@/components/molecules/SearchBar.vue";

export default {
  name: "AppBar",
  data: () => ({
    loggedIn: false,
    user_type: "",
    username: "",
    user: -1,
  }),
  setup() {
    const drawerStore = usedrawerStore();

    return {
      drawer: drawerStore.drawer,
      changeDrawer: drawerStore.changeDrawer,
    };
  },
  mounted: function () {
    // TODO: Get user
    const user = {
      role: "customer",
      //role: "admin",
      username: "Jacinto Alberto",
      id: 12,
    };

    if (user !== false) {
      this.user_type = user.role;
      this.username = user.username;
      this.user = user.id;
      this.loggedIn = true;
    }
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
    logout() {
      this.loggedIn = false;
      this.user_type = "";
      this.username = "";
      this.user = -1;
      this.$router.push("/");
    },
  },
  components: { Logo, BodyText, LanguageSwitcher, SearchBar },
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
