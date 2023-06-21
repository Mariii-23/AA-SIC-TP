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
                <TitleGoBack :title="$t('order')" />
                <OrderAdminCard :order="order"/>
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
import TitleGoBack from "@/components/molecules/TitleGoBack.vue";
import { useOrderStore } from "@/store/orders";

const orderStore = useOrderStore();

export default {
    name: "DoneOrdersDetails",
    data: () => ({
        //TODO: ir buscar os direitos
        items: Array as () => LinkProps[],
        order: Object as () => OrderAdmin,
    }),
    mounted: async function () {

        this.items = [
            { href: "/admin/orders/pending", icon: "brightness-1", text: "pending" },
            { href: "/admin/orders/ready", icon: "brightness-1", text: "ready" },
            { href: "/admin/orders/done", icon: "bullseye", text: "done" },
        ];

        const orderId = this.$route.params.id.toString();
        const order = orderStore.ordersDone.filter(e => e.id == orderId)
        if (order) {
            this.order = order[0];
        }
    },
    components: {
        TwoColumnsPanel,
        TitleCardLinksButton,
        SimpleBodyLayout,
        OrderAdminCard,
        TitleGoBack
    },
};
</script>
  