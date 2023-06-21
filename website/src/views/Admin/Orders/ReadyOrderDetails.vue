<template>
  <SimpleBodyLayout>
    <TwoColumnsPanel>
      <template v-slot:first>
        <TitleCardLinksButton :title="$t('all-orders')" :items="items" />
      </template>
      <template v-slot:second>
        <TitleWithButtonAndGoBack
          :title="$t('order')"
          :button-text="$t('change-to') + ' ' + $t('done')"
          :button-handler="() => changeToDone && changeToDone(order.id)"
          :go-back-handler="goBack"
        />
        <OrderAdminCard :order="order" />
      </template>
    </TwoColumnsPanel>
  </SimpleBodyLayout>
</template>

<script lang="ts">
import { LinkProps } from "@/appTypes/Link";
import TwoColumnsPanel from "@/layouts/Body/TwoColumnsPanel.vue";
import TitleCardLinksButton from "@/components/organisms/TitleCardLinksButton.vue";
import SimpleBodyLayout from "@/layouts/Body/SimpleBodyLayout.vue";
import { OrderAdmin } from "@/appTypes/Order";
import OrderAdminCard from "../../../components/organisms/Card/OrderAdminCard.vue";
import TitleWithButtonAndGoBack from "@/components/molecules/TitleWithButtonAndGoBack.vue";
import { useOrderStore } from "@/store/orders";

const orderStore = useOrderStore();

export default {
  name: "ReadyOrdersDetails",
  data: () => ({
    items: [] as LinkProps[],
    order: Object as () => OrderAdmin,
  }),
  mounted: async function () {
    this.items = [
      { href: "/admin/orders/pending", icon: "brightness-1", text: "pending" },
      { href: "/admin/orders/ready", icon: "bullseye", text: "ready" },
      { href: "/admin/orders/done", icon: "brightness-1", text: "done" },
    ];

    const orderId = this.$route.params.id.toString();
    const order = orderStore.ordersReady.filter((e) => e.id == orderId);
    if (order) {
      this.order = order[0];
    }
  },
  methods: {
    async changeToDone(id: string) {
      await orderStore.setOrderDone(id);
      this.$router.push("/admin/orders/done/" + id);
    },
    async goBack() {
      this.$router.push("/admin/orders/done");
    },
  },
  components: {
    TwoColumnsPanel,
    TitleCardLinksButton,
    SimpleBodyLayout,
    TitleWithButtonAndGoBack,
    OrderAdminCard,
  },
};
</script>
