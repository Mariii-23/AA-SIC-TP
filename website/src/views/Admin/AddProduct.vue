<template>
  <div class="body">
    <v-card width="100%">
      <v-tabs v-model="tab" bg-color="primary">
        <v-tab value="one" :disabled="isOneDisabled">
          <v-icon v-if="tab === 'one'">mdi-numeric-1-circle</v-icon>
          <v-icon v-else>mdi-numeric-1-circle-outline</v-icon>
          {{ $t("name-price") }}
        </v-tab>
        <v-tab value="two" :disabled="isTwoDisabled">
          <v-icon v-if="tab === 'two'">mdi-numeric-2-circle</v-icon>
          <v-icon v-else>mdi-numeric-2-circle-outline</v-icon>
          {{ $t("add-images") }}
        </v-tab>
        <v-tab value="three" :disabled="isThreeDisabled">
          <v-icon v-if="tab === 'three'">mdi-numeric-3-circle</v-icon>
          <v-icon v-else>mdi-numeric-3-circle-outline</v-icon>
          {{ $t("add-description") }}
        </v-tab>
      </v-tabs>

      <v-card-text>
        <v-window v-model="tab">
          <v-window-item value="one">
            <form ref="form">
              <div class="custom-flex">
                <div>
                  <v-text-field v-model="name" name="name" :label="$t('name')" type="text" :placeholder="$t('name')"
                    single-line class="input-form rounded-lg" required bg-color="primary" />
                  <v-text-field v-model="price" name="price" :label="$t('price')" type="text" :placeholder="$t('price')"
                    required bg-color="primary" single-line />
                </div>
              </div>
              <FullWidthButton :handle-click="nextStep"> {{ $t("next-step") }}</FullWidthButton>
            </form>
          </v-window-item>

          <v-window-item value="two">
            <FilesInput :label="$t('images')" />
            <FullWidthButton :handle-click="nextStep"> {{ $t("next-step") }}</FullWidthButton>
          </v-window-item>

          <v-window-item value="three">
            <HeadingText :size="6"> {{ $t("product-details") }}:</HeadingText>
            <v-textarea bg-color="primary" v-model="description" counter :label="$t('description')" maxlength="400"
              single-line></v-textarea>
            <HeadingText :size="6"> {{ $t("tech-info") }}:</HeadingText>
            <div v-for="(textField, i) in textFields" :key="i" class="text-fields-row">
              <v-text-field class="mr-2" bg-color="primary" :label="textField.label1" v-model="textField.value1"></v-text-field>

              <v-text-field bg-color="primary" :label="textField.label2" v-model="textField.value2"></v-text-field>

              <v-icon size="30" @click="remove(i)" class="error"> mdi-trash-can-outline</v-icon>
            </div>
            <v-icon size="30" @click="add" class="mb-5"> mdi-plus</v-icon>
            <FullWidthButton> {{ $t("finish-add-product") }}</FullWidthButton>
          </v-window-item>
        </v-window>
      </v-card-text>
    </v-card>
  </div>
</template>

  
<script lang="ts">
import { LinkProps } from "@/appTypes/Link";
import TwoColumnsPanel from "@/layouts/Body/TwoColumnsPanel.vue";
import TitleCardLinksButton from "@/components/organisms/TitleCardLinksButton.vue";
import SimpleBodyLayout from "@/layouts/Body/SimpleBodyLayout.vue";
import TitleWithButton from "@/components/molecules/TitleWithButton.vue";
import BodyText from "@/components/atoms/Typography/BodyText.vue";
import FullWidthButton from "@/components/atoms/Button/FullWidthButton.vue";
import HeadingText from "@/components/atoms/Typography/HeadingText.vue";
import FilesInput from "@/components/molecules/FilesInput.vue";
import PrimaryButton from "@/components/atoms/Button/PrimaryButton.vue";

export default {
  name: "AddProduct",
  //TODO: ir buscar os direitos
  data: () => ({
    items: Array as () => LinkProps[],
    name: "",
    price: null,
    description: "",
    tab: null,
    textFields: [],
    isOneDisabled: false,
    isTwoDisabled: true,
    isThreeDisabled: true,
  }),
  mounted: function () {
    (this.items = [
      { icon: "numeric-1-circle", text: "name-price" },
      { icon: "numeric-2-circle-outline", text: "images" },
      { icon: "numeric-3-circle-outline", text: "description" },
    ]);
  },

  methods: {
    nextStep() {
      if (this.tab == "one") {
        this.isOneDisabled = true
        this.isTwoDisabled = false
        this.tab = "two"
      } else if (this.tab = "two") {
        this.isTwoDisabled = true
        this.isThreeDisabled = false
        this.tab = "three"
      }

    },
    add() {
      this.textFields.push({
        label1: this.$t("field"),
        value1: "",
        label2: this.$t("value"),
        value2: ""
      })
    },

    remove(index) {
      this.textFields.splice(index, 1)
    }
  },
  components: {
    TwoColumnsPanel,
    TitleCardLinksButton,
    SimpleBodyLayout,
    TitleWithButton,
    BodyText,
    FullWidthButton,
    HeadingText,
    FilesInput,
    PrimaryButton
  },
};
</script>

<style scoped>
.body {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 800px;
  margin: 3% auto auto auto;
}

.text-fields-row {
  display: flex;
}
</style>
  