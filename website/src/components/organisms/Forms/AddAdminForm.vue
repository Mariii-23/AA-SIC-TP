<template>
  <CardLayout class="bg-secondary">
    <v-card-text class="fill-height">
      <form ref="form" class="custom-flex" @submit.prevent="addUserHandler()">
          <v-text-field
            v-model="email"
            name="email"
            label="Email"
            type="text"
            placeholder="Email"
            class="rounded-lg"
            required
            :rules="emailRules"
          />
          <v-text-field
            v-model="password"
            name="password"
            :label="$t('password')"
            type="password"
            :placeholder="$t('password')"
            required
            :rules="passwordRules"
          />
          <v-text-field
            v-model="name"
            name="name"
            :label="$t('name')"
            type="text"
            :placeholder="$t('name')"
            required
            :rules="nameRules"
          />

        <FullWidthButton :handle-click="()=>{}"> {{ $t("addAdmin") }}</FullWidthButton>
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
      emailRules: [
        value => {
          if (/^[a-z.-]+[a-z0-9.-]+@[a-z.-]+\.[a-z]+$/i.test(value)) return true

          return this.$t("invalid-email")
        },
      ],
      password: "",
      passwordRules: [
        value => {
          if (value?.length >= 8) return true

          return this.$t("password-length")
        },
      ],
      name: "",
      nameRules: [
        value => {
          if (value?.length >= 3 && /[^0-9]/.test(value)) return true

          return this.$t("invalid-name")
        },
      ],
    };
  },
  props: {
    registerAdmin: {
      type: Function,
    },
  },
  methods: {
    addUserHandler() {
      this.registerAdmin && this.registerAdmin(this.email, this.password, this.name);
    },
  },
  components: { FullWidthButton, CardLayout },
};
</script>

<style>
.custom-flex {
  display: flex;
  flex-direction: column;
  gap: 10px;
}
</style>