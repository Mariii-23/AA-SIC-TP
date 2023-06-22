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
        <Pagination :length="length" :total-visible="5" :handle-page-change="handlePageChange" />
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
import Pagination from "@/components/molecules/Pagination.vue";

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
    page: 1,
    length: 0,
    ordersOnPage: 20,
  }),
  mounted: async function () {
    if (userStore.isLoggedIn) {
      this.userName = userStore.name;
      this.userId = userStore.id;
    }

    this.length = Math.ceil((await ordersStore.getNumberOfCustomerOrders(this.userId))/this.ordersOnPage);
    await ordersStore.getAllOrders(this.userId, 0, this.ordersOnPage);
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
          await ordersStore.getAllOrders(this.userId, 0, this.ordersOnPage);
          this.orders = ordersStore.myOrders;
        }
      }
    );

    this.$watch(
      () => ({ orders: ordersStore.myOrders }),
      async (newValue) => {
        this.orders = newValue.orders;
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
    async handlePageChange(page: number){
      this.page = page;
      await ordersStore.getAllOrders(this.userId, (this.page-1)*this.ordersOnPage, this.ordersOnPage);
    }
  },
  components: {
    TwoColumnsPanel,
    TitleCardLinks,
    SimpleBodyLayout,
    HeadingText,
    OrderExpansionPanels,
    Pagination
},
};
</script>
