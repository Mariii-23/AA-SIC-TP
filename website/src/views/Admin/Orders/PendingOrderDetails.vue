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
                <TitleWithButtonAndGoBack 
                    :title="$t('order')"
                    :button-text="$t('change-to') + ' ' + $t('ready')" 
                    :button-handler="() => changeToReady && changeToReady(order.id)"
                    :go-back-handler="goBack"
                />
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
import TitleWithButtonAndGoBack from "@/components/molecules/TitleWithButtonAndGoBack.vue";
import { useOrderStore } from "@/store/orders";

const orderStore = useOrderStore();

export default {
    name: "PendingOrderDetails",
    data: () => ({
        items: [] as LinkProps[],
        order: Object as () => OrderAdmin,
    }),
    mounted: async function () {

        this.items = [
            { href: "/admin/orders/pending", icon: "bullseye", text: "PENDING" },
            { href: "/admin/orders/ready", icon: "brightness-1", text: "READY" },
            { href: "/admin/orders/done", icon: "brightness-1", text: "DONE" },
        ];

        const orderId = this.$route.params.id.toString();
        const order = orderStore.ordersPending.filter(e => e.id == orderId)
        if (order) {
            this.order = order[0];
        }
    },
    methods: {
    async changeToReady(id: string) {
      await orderStore.setOrderReady(id);
      this.$router.push("/admin/orders/ready/" + id);
    },
    async goBack() {
      this.$router.push("/admin/orders/ready");
    },
    },
    components: {
        TwoColumnsPanel,
        TitleCardLinksButton,
        SimpleBodyLayout,   
        TitleWithButtonAndGoBack,
        OrderAdminCard
    },
};
</script>
  