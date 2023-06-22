<template>
  <CardLayout class="bg-secondary">
    <v-card-text class="fill-height">
      <form ref="form" @submit.prevent="addHandler">
        <div class="custom-flex">
          <HeadingText :size="6"> {{ $t("product-details") }}:</HeadingText>
          <v-textarea
            bg-color="primary"
            v-model="description"
            required
            counter
            :label="$t('description')"
            maxlength="400"
            single-line
            :rules="textRules"
          />
          <HeadingText :size="6"> {{ $t("tech-info") }}:</HeadingText>
          <div
            v-for="(textField, i) in textFields"
            :key="i"
            class="text-fields-row"
          >
            <v-text-field
              class="mr-2"
              required
              bg-color="primary"
              :label="$t('field')"
              v-model="textField.name"
              :rules="textRules"
            />

            <v-text-field
              required
              bg-color="primary"
              :label="$t('value')"
              v-model="textField.description"
              :rules="textRules"
            />

            <v-btn
              icon
              @click="remove(i)"
              class="action bg-secondary elevation-0"
            >
              <v-icon> mdi-trash-can-outline</v-icon>
            </v-btn>
          </div>
          <v-icon size="30" @click="add" class="mb-5"> mdi-plus</v-icon>

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
import { TechnicalInfo } from "@/appTypes/Product";

export default {
  name: "Product Description and Tech Info form",
  data() {
    return {
      description: "",
      textFields: [] as TechnicalInfo[],
      textRules: [
        (value: string) => {
          if (value !== "") return true;

          return this.$t("invalid-content");
        },
      ],
    };
  },
  mounted() {
    if (this.descriptionInit !== undefined) {
      this.description = this.descriptionInit;
    }
    if (this.technicalInfoInit !== undefined) {
      for (const technical of this.technicalInfoInit) {
        this.textFields.push(technical);
      }
    }
  },
  props: {
    descriptionInit: {
      type: String,
    },
    technicalInfoInit: {
      type: Array as () => TechnicalInfo[],
    },
    buttonText: {
      type: String,
      required: true,
    },
    register: {
      type: Function,
    },
  },
  methods: {
    add() {
      this.textFields.push({
        name: "",
        description: "",
      });
    },
    remove(index: number) {
      this.textFields.splice(index, 1);
    },
    addHandler() {
      this.register && this.register(this.description, this.textFields);
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

.text-fields-row {
  display: flex;
}
</style>
