<template>
  <CardLayout class="bg-secondary">
    <v-card-text class="fill-height">
      <form ref="form" @submit.prevent="addHandler">
        <div class="custom-flex">
          <v-text-field
            v-model="name"
            name="name"
            :label="$t('name')"
            type="text"
            :placeholder="$t('name')"
            single-line
            class="input-form rounded-lg"
            required
            bg-color="primary"
            :rules="nameRules"
          />
          <v-text-field
            v-model="price"
            name="price"
            :label="$t('price')"
            type="text"
            :placeholder="$t('price')"
            required
            bg-color="primary"
            single-line
            :rules="priceRules"
          />

          <FullWidthButton :handle-click="() => {}">
            {{ buttonText }}</FullWidthButton
          >
        </div>
      </form>
    </v-card-text>
  </CardLayout>
</template>

<script lang="ts">
import FullWidthButton from "@/components/atoms/Button/FullWidthButton.vue";
import CardLayout from "@/layouts/CardLayout.vue";

export default {
  name: "Add Name and Price form",
  data() {
    return {
      name: "",
      nameRules: [
        (value: string) => {
          if (value?.length >= 3 && /[^0-9]/.test(value)) return true;

          return this.$t("invalid-name");
        },
      ],
      price: null,
      priceRules: [
        (value: string) => {
          if (/[0-9]+\.[0-9][0-9]/.test(value)) return true;

          return this.$t("invalid-price");
        },
      ],
    };
  },
  props: {
    buttonText: {
      type: String,
      required: true,
    },
    register: {
      type: Function,
    },
  },
  methods: {
    addHandler() {
      this.register && this.register(this.name, this.price);
    },
  },
  components: { FullWidthButton, CardLayout },
};
</script>

<style>
.custom-flex {
  display: flex;
  flex-direction: column;
  gap: 20px;
}
</style>
