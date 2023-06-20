<template>
  <v-container fluid class="layout-select-category-wrapper">
    <v-radio-group v-model="categoryId">
      <HeadingText :size="5">
        {{ $t("select-category") }}
      </HeadingText>
      <v-radio
        v-for="category in categories"
        :label="category.id"
        :value="String(category.id)"
        :key="category.id"
      >
        <template v-slot:label>
          <div class="body-category-select-wrapper">
            <AvatarLink :image-href="category.href" :size="30" />
            <HeadingText :size="5">
              {{ category.name }}
            </HeadingText>
          </div>
        </template>
      </v-radio>
    </v-radio-group>

    <v-radio-group v-model="subcategoryId">
      <HeadingText :size="5">
        {{ $t("select-subcategory") }}
      </HeadingText>
      <v-radio
        v-for="subcategory in subCategorys"
        :label="subcategory.id"
        :value="String(subcategory.id)"
        :key="subcategory.id"
      >
        <template v-slot:label>
          <div class="body-category-select-wrapper">
            <AvatarLink :image-href="subcategory.href" :size="30" />
            <HeadingText :size="5">
              {{ subcategory.name }}
            </HeadingText>
          </div>
        </template>
      </v-radio>
    </v-radio-group>
  </v-container>

  <FullWidthButton :handle-click="clickHandler"
    >{{ buttonText }}
  </FullWidthButton>
</template>

<script lang="ts">
import { Category, SubCategory } from "@/appTypes/Product";
import AvatarLink from "@/components/molecules/AvatarLink.vue";
import HeadingText from "@/components/atoms/Typography/HeadingText.vue";
import FullWidthButton from "@/components/atoms/Button/FullWidthButton.vue";

export default {
  data() {
    return {
      categoryId: "0",
      subcategoryId: "0",
      subCategorys: [] as SubCategory[],
    };
  },
  mounted() {
    if (this.categories.length > 0) {
      const category = this.categories[0];
      //FIXME:
      this.categoryId = category.id;
      this.subCategorys = category.subCategories;
    }

    this.$watch(
      () => this.categoryId,
      (newValue) => {
        this.subcategoryId = "0";
        const category = this.categories.find((e) => e.id == newValue);
        if (category) {
          this.subCategorys = category.subCategories;
        }
      }
    );
  },
  props: {
    categories: {
      type: Array as () => Category[],
      required: true,
    },
    register: {
      type: Function,
      required: true,
    },
    buttonText: {
      type: String,
      required: true,
    },
  },
  methods: {
    clickHandler() {
      this.register(this.categoryId, this.subcategoryId);
    },
  },
  components: {
    AvatarLink,
    HeadingText,
    FullWidthButton,
  },
};
</script>

<style>
.body-category-select-wrapper {
  display: flex;
  gap: 20px;
}

.layout-select-category-wrapper {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}

@media (max-width: 768px) {
  .layout-select-category-wrapper {
    flex-direction: column;
  }
}
</style>
