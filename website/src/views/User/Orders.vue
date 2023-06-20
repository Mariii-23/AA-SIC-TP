<template>
  <SimpleBodyLayout>
    <TwoColumnsPanel>
      <template v-slot:first>
        <TitleCardLinks :title="$t('hello') + ', ' + user.name + '!'" :items="items" />
      </template>
      <template v-slot:second>
        <HeadingText> {{ $t("my-orders") }} </HeadingText>
        <OrderExpansionPanels :orders="orders" :view-details-handler="viewDetailsHandler" />
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
import TitleCardLinks from "@/components/organisms/TitleCardLinks.vue";

export default {
  name: "Orders",
  //TODO: ir buscar os direitos
  data: () => ({
    items: [] as LinkProps[],
    orders: [] as Order[],
    userName: "",
    isModalOpen: false,
  }),
  mounted: function () {
    //TODO: ir buscar o admin consoante o id dado
    this.orders = [
      {
        id: 1,
        date: "2021-05-05",
        total: 100,
        state: "pending",
        orderItems: [
          {
            name: "Cadeira",
            quantity: 2,
            price: 50,
          },
        ],
      },
    ];
    this.userName = "Maria";

    this.items = [
      { href: "/user/profile", icon: "brightness-1", text: "profile" },
      { href: "/user/orders", icon: "bullseye", text: "my-orders" },
    ];
  },
  //TODO: ir buscar os direitos
  methods: {
    editProfile() {
      this.$router.push("/user/profile/edit");
    },
    viewDetailsHandler(productId: number) {
      this.$router.push("/user/orders/" + productId);
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
