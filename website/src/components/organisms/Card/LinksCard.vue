<template>
  <v-card color="secondary">
    <v-card-text color="secondary">
      <v-list :lines="false" density="compact" nav bg-color="secondary">
        <v-list-item v-for="(item, i) in items" :key="i" :value="item" bg-color="secondary"
          @click="navigateToRoute(item.href)">
          <template v-slot:prepend>
            <v-icon>mdi-{{ item.icon }}</v-icon>
          </template>
          <v-list-item-title>
            <SubtitleText>
              {{ $t(item.text) }}
            </SubtitleText>
          </v-list-item-title>
        </v-list-item>
      </v-list>
    </v-card-text>
  </v-card>
</template>

<script lang="ts">
import SubtitleText from "@/components/atoms/Typography/SubtitleText.vue";
import { LinkCardProps } from "@/appTypes/LinksCardProps";
import { RouteLocationNormalized } from "vue-router";

export default {
  props: {
    items: {
      type: Array as () => LinkCardProps[],
      required: true,
    },
  },
  methods: {
    navigateToRoute(route: RouteLocationNormalized) {
      this.$router.push(route);
    },
  },
  components: {
    SubtitleText,
  },
};
</script>
