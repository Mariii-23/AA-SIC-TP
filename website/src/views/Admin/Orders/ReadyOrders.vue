<template>
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
                    :changing-to="`${$t('done') }`"
                    :change-state="changeToDone"
                    :viewDetailsHandler="viewDetailsHandler"
                 />
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

export default {
    name: "ReadyOrders",
    data: () => ({
        //TODO: ir buscar os direitos
        items: Array as () => LinkProps[],
        orders: Array as () => OrderAdmin[],
    }),
    mounted: async function () {

        this.items = [
            { href: "/orders/pending", icon: "brightness-1", text: "pending" },
            { href: "/orders/ready", icon: "bullseye", text: "ready" },
            { href: "/orders/done", icon: "brightness-1", text: "done" },
        ];

        this.orders = [
            {
                id: 1,
                date: "2021-05-05",
                total: 500,
                orderItems: [
                    {
                        name: "Cadeira",
                        quantity: 2,
                        price: 100,
                    },
                    {
                        name: "Mesa",
                        quantity: 1,
                        price: 300,
                    }
                ],
                user: 1,
            },
            {
                id: 2,
                date: "2021-05-04",
                total: 1000,
                orderItems: [
                    {
                        name: "Cadeira2",
                        quantity: 2,
                        price: 100,
                    },
                    {
                        name: "Mesa2",
                        quantity: 1,
                        price: 300,
                    },
                    {
                        name: "Mesa3",
                        quantity: 1,
                        price: 300,
                    }
                ],
                user: 2,
            }
        ];
    },
    //TODO: handlers
    methods: {
        viewDetailsHandler(id: number) {
            this.$router.push("/orders/ready/" + id)
        },
        changeToDone(id: number) {
            this.$router.push("/orders/done/" + id)
        }
    },
    components: {
        TwoColumnsPanel,
        TitleCardLinksButton,
        SimpleBodyLayout,
        HeadingText,
        SearchBar,
        OrderAdminExpansionPanel
    },
};
</script>
  