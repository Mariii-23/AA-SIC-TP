<template>
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
export default {
    name: "DoneOrdersDetails",
    data: () => ({
        //TODO: ir buscar os direitos
        items: Array as () => LinkProps[],
        order: Object as () => OrderAdmin,
    }),
    mounted: async function () {

        this.items = [
            { href: "/orders/pending", icon: "brightness-1", text: "pending" },
            { href: "/orders/ready", icon: "brightness-1", text: "ready" },
            { href: "/orders/done", icon: "bullseye", text: "done" },
        ];

        this.order = {
                id: 1,
                date: "2021-05-05",
                total: 500,
                state: "done",
                orderItems: [
                    {
                        name: "Cadeira",
                        quantity: 2,
                        price: 100,
                        img: "https://www.ikea.com/pt/pt/images/products/bergmund-cadeira-efeito-carvalho-hallarp-bege__0926594_pe789377_s5.jpg",
                    material: "https://upload.wikimedia.org/wikipedia/commons/thumb/4/43/Red_flag.svg/1280px-Red_flag.svg.png"
                    },
                    {
                        name: "Mesa",
                        quantity: 1,
                        price: 300,
                        img: "https://www.ikea.com/pt/pt/images/products/bergmund-cadeira-efeito-carvalho-hallarp-bege__0926594_pe789377_s5.jpg",
                    material: "https://upload.wikimedia.org/wikipedia/commons/thumb/4/43/Red_flag.svg/1280px-Red_flag.svg.png"
                    }
                ],
                user: 1,
                email: "joao@gmail.com"
            };
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
  