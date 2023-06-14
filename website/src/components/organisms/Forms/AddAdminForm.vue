<template>
  <CardLayout class="bg-secondary">
    <v-card-text class="fill-height">
      <form ref="form" @submit.prevent="addUserHandler()">
        <div class="custom-flex">
          <v-text-field
            v-model="email"
            name="email"
            label="Email"
            type="text"
            placeholder="Email"
            class="input-form rounded-lg"
            required
          />
          <v-text-field
            v-model="password"
            name="password"
            :label="$t('password')"
            type="password"
            :placeholder="$t('password')"
            required
          />
        </div>

        <FullWidthButton> {{ $t("addAdmin") }}</FullWidthButton>
      </form>
    </v-card-text>
  </CardLayout>
</template>

<script lang="ts">
import FullWidthButton from "@/components/atoms/Button/FullWidthButton.vue";
import CardLayout from "@/layouts/CardLayout.vue";

export default {
  name: "Login",
  data() {
    return {
      email: "",
      password: "",
    };
  },
  props: {
    registerAdmin: {
      type: Function,
    },
  },
  methods: {
    addUserHandler() {
      this.registerAdmin && this.registerAdmin(this.email, this.password);
    },
  },
  components: { FullWidthButton, CardLayout },
};
</script>
