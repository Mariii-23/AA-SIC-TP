<template>
  <div v-if="!loaded">
      <v-progress-linear
      indeterminate
    />
    </div>
  <SimpleBodyLayout>
    <TwoColumnsPanel>
      <template v-slot:first>
        <TitleCardLinks
          :title="$t('hello') + ', ' + userName + '!'"
          :items="items"
        />
      </template>
      <template v-slot:second>
        <HeadingText> {{ $t("my-orders") }} </HeadingText>
        <OrderExpansionPanels
          :orders="orders"
          :view-details-handler="viewDetailsHandler"
        />
      </template>
    </TwoColumnsPanel>
  </SimpleBodyLayout>
</template>

<script lang="ts">
import { LinkProps } from "@/appTypes/Link";
import TwoColumnsPanel from "@/layouts/Body/TwoColumnsPanel.vue";
import SimpleBodyLayout from "@/layouts/Body/SimpleBodyLayout.vue";
import HeadingText from "@/components/atoms/Typography/HeadingText.vue";
import OrderExpansionPanels from "@/components/molecules/expansionPanels/OrderExpansionPanel.vue";
import { Order } from "@/appTypes/Order";
import { useOrderStore } from "@/store/orders";
import TitleCardLinks from "@/components/organisms/TitleCardLinks.vue";
import { useUserStore } from "@/store/userStore";

const ordersStore = useOrderStore();
const userStore = useUserStore();

export default {
  name: "Orders",
  data: () => ({
    items: [] as LinkProps[],
    orders: [] as Order[],
    userName: "",
    userId: "",
    isModalOpen: false,
    loaded: false,
  }),
  mounted: async function () {
    if (userStore.isLoggedIn) {
      this.userName = userStore.name;
      this.userId = userStore.id;
    }

    await ordersStore.getAllOrders(this.userId);
    this.loaded = true;
    this.orders = ordersStore.myOrders;

    this.items = [
      { href: "/user/profile", icon: "brightness-1", text: "profile" },
      { href: "/user/orders", icon: "bullseye", text: "my-orders" },
    ];

    this.$watch(
      () => userStore,
      async (newValue) => {
        if (!newValue.isAdmin()) {
          this.userName = newValue.name;
          this.userId = newValue.id;
          await ordersStore.getAllOrders(this.userId);
          this.orders = ordersStore.myOrders;
        }
      }
    );

  },
  methods: {
    editProfile() {
      this.$router.push("/user/profile/edit");
    },
    viewDetailsHandler(productId: number) {
      this.$router.push("orders/" + productId);
    },
  },
  components: {
    TwoColumnsPanel,
    TitleCardLinks,
    SimpleBodyLayout,
    HeadingText,
    OrderExpansionPanels,
  },
};
</script>
