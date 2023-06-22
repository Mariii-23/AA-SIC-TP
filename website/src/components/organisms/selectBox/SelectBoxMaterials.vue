<template>
  <v-container fluid class="layout-select-material">
    <v-checkbox
      v-for="material in materials"
      v-model="selected"
      :label="material.id"
      :value="String(material.id)"
      :key="material.id"
    >
      <template v-slot:label>
        <div class="body-material-select">
          <AvatarLink :image-href="material.href" :size="30" />
          <HeadingText :size="5">
            {{ material.name }}
          </HeadingText>
        </div>
      </template>
    </v-checkbox>
  </v-container>

  <FullWidthButton :handle-click="clickHandler"
    >{{ buttonText }}
  </FullWidthButton>
</template>

<script lang="ts">
import { Material } from "@/appTypes/Product";
import AvatarLink from "@/components/molecules/AvatarLink.vue";
import HeadingText from "@/components/atoms/Typography/HeadingText.vue";
import FullWidthButton from "@/components/atoms/Button/FullWidthButton.vue";

export default {
  data() {
    return {
      selected: [] as string[],
    };
  },
  mounted() {
    this.selected = []
    if (this.materialsSelectInitial !== undefined) {
      for (const material of this.materialsSelectInitial) {
        this.selected.push(String(material.id));
      }
    }
  },
  props: {
    materialsSelectInitial: {
      type: Array as () => Material[],
    },
    materials: {
      type: Array as () => Material[],
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
      this.register(this.selected);
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
.body-material-select {
  display: flex;
  gap: 20px;
}

.layout-select-material {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
}

@media (max-width: 768px) {
  .layout-select-material {
    grid-template-columns: repeat(1, 1fr);
  }
}
</style>
