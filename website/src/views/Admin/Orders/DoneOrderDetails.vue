<template>
  <div v-if="!order">
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
        <TitleWithGoBackIcon :title="$t('order')" :go-back="goBack" />
        <OrderAdminCard :order="order" />
      </template>
    </TwoColumnsPanel>
  </SimpleBodyLayout>
</template>

<script lang="ts">
import TitleWithGoBackIcon from "@/components/molecules/TitleWithGoBackIcon.vue";
import { LinkProps } from "@/appTypes/Link";
import TwoColumnsPanel from "@/layouts/Body/TwoColumnsPanel.vue";
import TitleCardLinksButton from "@/components/organisms/TitleCardLinksButton.vue";
import SimpleBodyLayout from "@/layouts/Body/SimpleBodyLayout.vue";
import { OrderAdmin } from "@/appTypes/Order";
import OrderAdminCard from "../../../components/organisms/Card/OrderAdminCard.vue";
import { useOrderStore } from "@/store/orders";

const orderStore = useOrderStore();

export default {
  name: "DoneOrdersDetails",
  data: () => ({
    items: Array as () => LinkProps[],
    order: Object as () => OrderAdmin,
  }),
  methods: {
    async goBack() {
      this.$router.push("/admin/orders/ready");
    },
  },
  mounted: async function () {
    this.items = [
      { href: "/admin/orders/pending", icon: "brightness-1", text: "PENDING" },
      { href: "/admin/orders/ready", icon: "brightness-1", text: "READY" },
      { href: "/admin/orders/done", icon: "bullseye", text: "DONE" },
    ];

    const orderId = this.$route.params.id.toString();
    const order = orderStore.ordersDone.filter((e) => e.id == orderId);
    if (order) {
      this.order = order[0];
    }
  },
  components: {
    TwoColumnsPanel,
    TitleCardLinksButton,
    SimpleBodyLayout,
    OrderAdminCard,
    TitleWithGoBackIcon,
  },
};
</script>
