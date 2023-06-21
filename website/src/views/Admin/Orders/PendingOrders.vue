<template>
  <div v-if="orders.length == 0">
      <v-progress-linear
      indeterminate
    />
    </div>
  <SimpleBodyLayout>
    <TwoColumnsPanel>
      <template v-slot:first>
        <TitleCardLinksButton :title="$t('all-orders')" :items="items" />
      </template>
      <template v-slot:second>
        <HeadingText>{{ $t("pending-orders") }}</HeadingText>
        <SearchBar bg-color="primary" />
        <OrderAdminExpansionPanel
          :orders="orders"
          :changing-to="`${$t('ready')}`"
          :change-state="changeToReady"
          :viewDetailsHandler="viewDetailsHandler"
        />
      </template>
    </TwoColumnsPanel>
  </SimpleBodyLayout>
</template>

<script lang="ts">
import { LinkProps } from "@/appTypes/Link";
import TwoColumnsPanel from "@/layouts/Body/TwoColumnsPanel.vue";
import TitleCardLinksButton from "@/components/organisms/TitleCardLinksButton.vue";
import SimpleBodyLayout from "@/layouts/Body/SimpleBodyLayout.vue";
import HeadingText from "@/components/atoms/Typography/HeadingText.vue";
import SearchBar from "@/components/molecules/SearchBar.vue";
import { OrderAdmin } from "@/appTypes/Order";
import OrderAdminExpansionPanel from "@/components/molecules/expansionPanels/OrderAdminExpansionPanel.vue";
import { useOrderStore } from "@/store/orders";

const orderStore = useOrderStore();

export default {
  name: "PendingOrders",
  data: () => ({
    items: Array as () => LinkProps[],
    orders: Array as () => OrderAdmin[],
  }),
  mounted: async function () {
    this.items = [
      { href: "/admin/orders/pending", icon: "bullseye", text: "pending" },
      { href: "/admin/orders/ready", icon: "brightness-1", text: "ready" },
      { href: "/admin/orders/done", icon: "brightness-1", text: "done" },
    ];

    if (orderStore.ordersPending.length <= 0)
      await orderStore.getAllOrdersPending();
    this.orders = orderStore.ordersPending;
  },
  methods: {
    viewDetailsHandler(id: number) {
      this.$router.push("/admin/orders/pending/" + id);
    },
    async changeToReady(id: string) {
      await orderStore.setOrderReady(id);
      this.$router.push("/admin/orders/ready/" + id);
    },
  },
  components: {
    TwoColumnsPanel,
    TitleCardLinksButton,
    SimpleBodyLayout,
    HeadingText,
    SearchBar,
    OrderAdminExpansionPanel,
  },
};
</script>
