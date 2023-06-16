<template>
  <ConfirmationModal
    :title="$t('logout')"
    :text="$t('logout-text')"
    :confirmHandler="logoutHandler"
    :closeModal="closeModal"
    :isModalOpen="isModalOpen"
  />
  <SimpleBodyLayout>
    <TwoColumnsPanel>
      <template v-slot:first>
        <TitleCardLinksButton
          :title="$t('hello') + ', ' + userName + '!'"
          :items="items"
          :button-text="$t('logout')"
          :button-handler="openModal"
        />
      </template>
      <template v-slot:second>
        <HeadingText> {{ $t("my-orders") }} </HeadingText>
        <OrderExpansionPanels
          :orders="orders"
          :view-details-handler="viewDetailsHandler"
        />
      </template> </TwoColumnsPanel
  ></SimpleBodyLayout>
</template>

<script lang="ts">
import { LinkProps } from "@/appTypes/Link";
import TwoColumnsPanel from "@/layouts/Body/TwoColumnsPanel.vue";
import TitleCardLinksButton from "@/components/organisms/TitleCardLinksButton.vue";
import SimpleBodyLayout from "@/layouts/Body/SimpleBodyLayout.vue";
import { useRoute } from "vue-router";
import ConfirmationModal from "@/components/organisms/Modal/ConfirmationModal.vue";
import HeadingText from "@/components/atoms/Typography/HeadingText.vue";
import OrderExpansionPanels from "@/components/molecules/expansionPanels/OrderExpansionPanel.vue";
import { Order } from "@/appTypes/Order";

export default {
  name: "Orders",
  //TODO: ir buscar os direitos
  data: () => ({
    items: [] as LinkProps[],
    orders: Array as () => Order[],
    userName: "",
    isModalOpen: false,
  }),
  mounted: function () {
    const route = useRoute();
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
    logoutHandler() {
      console.log("logout");
    },
    editProfile() {
      this.$router.push("/user/profile/edit");
    },
    closeModal() {
      this.isModalOpen = false;
    },
    openModal() {
      this.isModalOpen = true;
    },
    viewDetailsHandler(productId: number) {
      this.$router.push("/user/orders/" + productId);
    },
  },
  components: {
    TwoColumnsPanel,
    TitleCardLinksButton,
    SimpleBodyLayout,
    ConfirmationModal,
    HeadingText,
    OrderExpansionPanels,
  },
};
</script>
