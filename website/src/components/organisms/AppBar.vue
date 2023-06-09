<template>
  <v-app-bar>
    <v-app-bar-nav-icon>
      <v-icon icon="mdi-circle-slice-6" />
    </v-app-bar-nav-icon>

    <v-app-bar-title>
      Essentials Preset
    </v-app-bar-title>

    <div v-if="loggedIn && user_type === 'registed_user'" class="btn-group">
      ola sou um user que esta registado
    </div>

    <v-spacer />
    <v-btn icon>
      <v-icon>mdi-magnify</v-icon>
    </v-btn>

    <v-btn icon>
      <v-icon>mdi-heart</v-icon>
    </v-btn>

    <v-btn icon>
      <v-icon>mdi-dots-vertical</v-icon>
    </v-btn>
  </v-app-bar>
</template>

<script lang="ts">
export default {
  name: "AppBar",
  data: () => ({
    loggedIn: false,
    user_type: null,
    username: null,
    user: null,
  }),
  watch: {
    "$route"() {
      //   this.updateList()
    }
  },
  mounted: function () {
    // this.updateList()

    // TODO: Get user
    const user = {
      role: "registed_user",
      username: "Jacinto",
      id: 12,
    }

    if (user !== false) {
      this.user_type = user.role
      this.username = user.username
      this.user = user.id
      this.loggedIn = true
    }
  },
  methods: {
    logout() {
      this.loggedIn = false
      this.user_type = null
      this.$router.push("/")
    },
  }
}  
</script>
