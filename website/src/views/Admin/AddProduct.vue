<template>
  <div class="body">
    <v-card width="100%">
      <NextTabs :tabs="tabs" v-bind:selected-tab="tab">
        <template v-slot:tab1>
          <AddNamePriceForm
            :register="updateNameAndPriceHandler"
            :button-text="$t('next-step')"
          />
        </template>
        <template v-slot:tab2>
          <TitleWithGoBackIcon :title="$t('previos-step')" :goBack="goBack" />
          <FilesInput
            :label="$t('images')"
            :register="updateImages"
            :button-text="$t('next-step')"
          />
        </template>
        <template v-slot:tab3>
          <TitleWithGoBackIcon :title="$t('previos-step')" :goBack="goBack" />
          <ProductDescriptionAndTechInfoForm
            :register="updateDescriptionTechincalInfo"
            :button-text="$t('next-step')"
          />
        </template>
        <template v-slot:tab4>
          <TitleWithGoBackIcon :title="$t('previos-step')" :goBack="goBack" />
          <SelectBoxMaterials
            v-bind:materials="materials"
            :register="updateMaterials"
            :button-text="$t('next-step')"
          />
        </template>
        <template v-slot:tab5>
          <TitleWithGoBackIcon :title="$t('previos-step')" :goBack="goBack" />
          <SelectBoxCategoryAndSubcategory
            v-bind:categories="categoriesInfo"
            :register="updateCategories"
            :button-text="$t('next-step')"
          />
        </template>
      </NextTabs>
    </v-card>
  </div>
</template>

<script lang="ts">
import SelectBoxCategoryAndSubcategory from "@/components/organisms/selectBox/SelectBoxCategoryAndSubcategory.vue";
import FilesInput from "@/components/molecules/FilesInput.vue";
import AddNamePriceForm from "@/components/organisms/Forms/AddNamePriceForm.vue";
import { Category, Material, TechnicalInfo } from "@/appTypes/Product";
import ProductDescriptionAndTechInfoForm from "@/components/organisms/Forms/ProductDescriptionAndTechInfoForm.vue";
import NextTabs from "@/components/organisms/NextTabs.vue";
import { useProductStore } from "@/store/productStore";
import { useNotificationStore } from "@/store/notificationStore";
import SelectBoxMaterials from "@/components/organisms/selectBox/SelectBoxMaterials.vue";
import { useMaterialStore } from "@/store/materialsStore";
import TitleWithGoBackIcon from "@/components/molecules/TitleWithGoBackIcon.vue";
import { useCategoriesStore } from "@/store/categoriesStore";

const productStore = useProductStore();
const notificationStore = useNotificationStore();
const materialsStore = useMaterialStore();
const categoriesStore = useCategoriesStore();

export default {
  name: "AddProduct",
  data() {
    return {
      name: "",
      price: 0,
      images: [] as string[],
      description: "",
      technicalInfo: [] as TechnicalInfo[],
      materialsId: [] as string[],
      categoryId: "",
      subcategoryId: "",

      tabs: [] as {
        label: string;
      }[],
      tab: 0,

      materials: [] as Material[],
      categoriesInfo: [] as Category[],
    };
  },
  mounted: async function () {
    this.tabs = [
      {
        label: this.$t("name-price"),
      },
      {
        label: this.$t("images"),
      },
      {
        label: this.$t("description"),
      },
      {
        label: this.$t("select-materials"),
      },
      {
        label: this.$t("category"),
      },
    ];

    if (materialsStore.materials.length <= 0) {
      await materialsStore.getAllMaterials();
    }

    this.materials = materialsStore.materials;

    this.$watch(
      () => materialsStore.materials,
      (newValues) => {
        this.materials = newValues;
      }
    );

    //CATEGORIES
    if (categoriesStore.categories.length <= 0) {
      await categoriesStore.categories;
    }

    this.categoriesInfo = categoriesStore.categories;

    this.$watch(
      () => categoriesStore.categories,
      (newValues) => {
        this.categoriesInfo = newValues;
      }
    );
  },

  methods: {
    updateNameAndPriceHandler(name: string, price: number) {
      this.name = name;
      this.price = price;
      this.nextStep();
    },
    updateImages(photos: string[]) {
      this.images = photos;
      this.nextStep();
    },
    updateDescriptionTechincalInfo(
      description: string,
      technicalInfo: TechnicalInfo[]
    ) {
      this.description = description;
      this.technicalInfo = technicalInfo;
      this.nextStep();
    },
    updateMaterials(materialsId: string[]) {
      this.materialsId = materialsId;
      this.nextStep();
    },
    updateCategories(categoryId: string, subcategoryId: string) {
      this.categoryId = categoryId;
      this.subcategoryId = subcategoryId;
      this.addProduct();
    },
    async addProduct() {
      const r = await productStore.addProduct(
        this.name,
        this.description,
        this.price,
        this.categoryId,
        this.subcategoryId,
        this.materialsId,
        this.technicalInfo,
        this.images
      );

      if (typeof r !== "string") {
        notificationStore.openSuccessAlert("add-product-success");
        this.$router.push(`/product/${r.id}`);
      } else {
        notificationStore.openErrorAlert("add-product-error");
      }
    },
    goBack() {
      this.tab = this.tab - 1;
    },
    nextStep() {
      this.tab = this.tab + 1;
    },
  },
  components: {
    FilesInput,
    AddNamePriceForm,
    ProductDescriptionAndTechInfoForm,
    NextTabs,
    SelectBoxMaterials,
    TitleWithGoBackIcon,
    SelectBoxCategoryAndSubcategory,
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
