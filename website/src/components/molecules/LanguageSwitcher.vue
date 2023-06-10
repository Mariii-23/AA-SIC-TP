<template>
  <v-menu>
    <template v-slot:activator="{ props }">
      <v-btn v-bind="props" icon>
        <img :src="findCurrentLang()" class="flag" />
      </v-btn>
    </template>

    <v-list bg-color="secondary">
      <v-list-item v-for="(item, i) in items" :key="i" class="item" @click.prevent="setLocale(item.shortName)">
        <template v-slot:prepend>
          <v-img :src="item.img" class="flag" />
        </template>
        <v-list-item-title>
          {{ $t(item.longName) }}
        </v-list-item-title>
      </v-list-item>
    </v-list>
  </v-menu>
</template>
  
<script lang="ts">
import { LanguageItem } from "@/appTypes/LanguageItem";
import flag_en from "@/assets/flag_en.png";
import flag_pt from "@/assets/flag_pt.png";

export default {
  data: () => ({
    current: String,
    items: [] as LanguageItem[],
  }),
  mounted: function () {
    this.current = this.$i18n.locale;
    this.items = [
      { shortName: "en", longName: "english", img: flag_en },
      { shortName: "pt", longName: "portuguese", img: flag_pt },
    ];
  },
  methods: {
    setLocale(locale) {
      this.$i18n.locale = locale;
      this.current = locale;
    },
    findCurrentLang() {
      const currentLang = this.items.find(
        (e) => e.shortName == this.current.toString()
      );
      if (currentLang) {
        return currentLang.img;
      }
      return "";
    },
  },
};
</script>

<style scoped>
.flag {
  width: 20px;
  height: 20px;
}

.item {
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  gap: 10px;
}
</style>
  