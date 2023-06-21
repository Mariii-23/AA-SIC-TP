<template>
  <CardLayout class="bg-secondary">
    <v-card-item>
      <div
        v-for="subcategory in subCategories"
        :key="subcategory.id"
        class="body-subcategory-wrapper"
      >
        <div class="avatar-subcategory-wrapper">
          <AvatarLink :image-href="subcategory.href" :size="30" />
          <HeadingText :size="5">
            {{ subcategory.name }}
          </HeadingText>
        </div>

        <v-btn
          icon
          @click="removeSubcategory(subcategory.id)"
          class="elevation-0 bg-secondary"
        >
          <v-icon icon="mdi-trash-can-outline" />
        </v-btn>
      </div>
    </v-card-item>
    <v-card-text class="fill-height">
      <form ref="form" @submit.prevent="addHandler()">
        <div
          v-for="(textField, i) in textFields"
          :key="i"
          class="text-fields-row"
        >
          <v-file-input
            class="mr-2"
            bg-color="primary"
            :label="textField.value1"
            accept="image/*"
            @change="(e) => handleFileUpload(e, i)"
            @click:clear="(e) => clearInput(e, i)"
          />

          <v-text-field
            bg-color="primary"
            :label="$t('value')"
            v-model="textField.value2"
          />

          <v-btn icon @click="remove(i)" class="elevation-0 bg-secondary">
            <v-icon icon="mdi-trash-can-outline" />
          </v-btn>

          <v-btn
            icon
            v-if="i + 1 === textFields.length"
            @click="add"
            class="elevation-0 bg-secondary"
          >
            <v-icon icon="mdi-plus" />
          </v-btn>
        </div>
        <FullWidthButton :handleClick="() => {}">
          {{ textButton }}
        </FullWidthButton>
      </form>
    </v-card-text>
  </CardLayout>
</template>

<script lang="ts">
import { SubCategory } from "@/appTypes/Product";
import FullWidthButton from "@/components/atoms/Button/FullWidthButton.vue";
import CardLayout from "@/layouts/CardLayout.vue";
import AvatarLink from "@/components/molecules/AvatarLink.vue";
import HeadingText from "@/components/atoms/Typography/HeadingText.vue";

export default {
  name: "Update Subcategories Form",
  data() {
    return {
      textFields: [] as {
        value1: string;
        value2: string;
        photo: string;
      }[],
    };
  },
  mounted: function () {
    this.textFields.push({
      value1: "",
      value2: "",
      photo: "",
    });
  },
  methods: {
    add() {
      this.textFields.push({
        value1: "",
        value2: "",
        photo: "",
      });
    },
    clearInput(e, i) {
      console.log(i);
    },
    remove(index: number) {
      if (index != 0) this.textFields.splice(index, 1);
    },
    handleFileUpload(event, index) {
      const file = event.target.files[0];

      const reader = new FileReader();
      reader.onload = () => {
        const arrayBuffer = reader.result;
        const bytes = new Uint8Array(arrayBuffer);
        let binaryString = "";
        for (let j = 0; j < bytes.length; j++) {
          binaryString += String.fromCharCode(bytes[j]);
        }
        const photo = btoa(binaryString);
        this.textFields[index].photo = photo;
      };
      reader.readAsArrayBuffer(file);
    },
    addHandler() {
      const subCategories: { name: string; photo: string }[] = [];
      for (let i = 0; i < this.textFields.length; i++) {
        const textField = this.textFields[i];
        subCategories.push({
          name: textField.value2,
          photo: textField.photo,
        });
      }

      this.addSubcategories(subCategories);
    },
  },
  props: {
    textButton: {
      type: String,
      required: true,
    },
    addSubcategories: {
      type: Function,
      required: true,
    },
    removeSubcategory: {
      type: Function,
      required: true,
    },
    subCategories: {
      type: Array as () => SubCategory[],
      required: true,
    },
  },
  components: { FullWidthButton, CardLayout, AvatarLink, HeadingText },
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

.body-subcategory-wrapper {
  display: flex;
  justify-content: space-between;
}

.avatar-subcategory-wrapper {
  display: flex;
  gap: 20px;
}
</style>
