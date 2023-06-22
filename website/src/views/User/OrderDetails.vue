<template>
  <SimpleBodyLayout>
    <TwoColumnsPanel>
      <template v-slot:first>
        <TitleCardLinks :title="$t('hello') + ', ' + userName + '!'"
          :items="items" />
      </template>
      <template v-slot:second>
        <TitleGoBack :title="$t('order-details')" />
        <OrderCard :order="order" />
      </template>
    </TwoColumnsPanel>
  </SimpleBodyLayout>
</template>

<script lang="ts">
import { LinkProps } from "@/appTypes/Link";
import TwoColumnsPanel from "@/layouts/Body/TwoColumnsPanel.vue";
import SimpleBodyLayout from "@/layouts/Body/SimpleBodyLayout.vue";
import { Order } from "@/appTypes/Order";
import OrderCard from "@/components/organisms/Card/OrderCard.vue";
import TitleGoBack from "@/components/molecules/TitleGoBack.vue";
import { useOrderStore } from "@/store/orders";
import { useUserStore } from "@/store/userStore";
import TitleCardLinks from "@/components/organisms/TitleCardLinks.vue";

const ordersStore = useOrderStore();
const userStore = useUserStore();

export default {
  name: "OrderDetails",
  data: () => ({
    items: [] as LinkProps[],
    userName: "",
    orderId: "",
    order: {} as Order,
  }),
  mounted: async function () {
    this.orderId = this.$route.params.id.toString();

    const r = await ordersStore.getOrder(this.orderId);
    if (r) this.order = r;

    if (userStore.isLoggedIn) {
      this.userName = userStore.name;
    }

    this.items = [
      { href: "/user/profile", icon: "brightness-1", text: "profile" },
      { href: "/user/orders", icon: "bullseye", text: "my-orders" },
    ];

    this.$watch(
      () => userStore,
      async (newValue) => {
        if (!newValue.isAdmin()) {
          this.userName = newValue.name;
          const r = await ordersStore.getOrder(this.orderId);
          if (r) this.order = r;
        }
      }
    );
  },
  components: {
    TwoColumnsPanel,
    SimpleBodyLayout,
    OrderCard,
    TitleGoBack,
    TitleCardLinks,
  },
};
</script>
