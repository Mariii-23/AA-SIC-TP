<template>
  <div v-if="!loaded">
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
        <HeadingText>{{ $t("ready-orders") }}</HeadingText>
        <SearchBar bg-color="primary" />
        <OrderAdminExpansionPanel
          :orders="orders"
          :changing-to="`${$t('done')}`"
          :change-state="changeToDone"
          :viewDetailsHandler="viewDetailsHandler"
        />
        <Pagination :length="length" :total-visible="5" :handle-page-change="handlePageChange" />
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
import Pagination from "@/components/molecules/Pagination.vue";
const orderStore = useOrderStore();

export default {
  name: "ReadyOrders",
  data: () => ({
    items: Array as () => LinkProps[],
    orders: Array as () => OrderAdmin[],
    loaded: false,

    page: 1,
    length: 0,
    ordersOnPage: 5,
    
  }),
  mounted: async function () {
    this.items = [
      { href: "/admin/orders/pending", icon: "brightness-1", text: "PENDING" },
      { href: "/admin/orders/ready", icon: "bullseye", text: "READY" },
      { href: "/admin/orders/done", icon: "brightness-1", text: "DONE" },
    ];

    if (orderStore.ordersReady.length <= 0)
      await orderStore.getAllOrdersReady(0, this.ordersOnPage);
    this.loaded = true;
    this.orders = orderStore.ordersReady;

    this.$watch(
      () => ({orders: orderStore.ordersReady}),
      (newValue) => {
        this.orders = newValue.orders
        this.loaded = true
      }
    )

  },
  methods: {
    viewDetailsHandler(id: number) {
      this.$router.push("/admin/orders/ready/" + id);
    },
    async changeToDone(id: string) {
      await orderStore.setOrderDone(id);
      this.$router.push("/admin/orders/done/" + id);
    },
    async handlePageChange(page: number){
      this.page = page;
      await orderStore.getAllOrdersReady((this.page-1)*this.ordersOnPage, this.ordersOnPage);
    }
  },
  components: {
    TwoColumnsPanel,
    TitleCardLinksButton,
    SimpleBodyLayout,
    HeadingText,
    SearchBar,
    OrderAdminExpansionPanel,
    Pagination
  },
};
</script>
