<template>
    <SimpleBodyLayout>
        <TwoColumnsPanel>
            <template v-slot:first>
                <TitleCardLinksButton :title="$t('all-orders')" :items="items" />
            </template>
            <template v-slot:second>
                <TitleWithButtonAndGoBack 
                    :title="$t('order')"
                    :button-text="$t('change-to') + ' ' + $t('done')" 
                    :button-handler="() => changeToDone && changeToDone(order.id)"
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

export default {
    name: "ReadyOrdersDetails",
    data: () => ({
        //TODO: ir buscar os direitos
        items: [] as LinkProps[],
        order: Object as () => OrderAdmin,
    }),
    mounted: async function () {

        this.items = [
            { href: "/admin/orders/pending", icon: "brightness-1", text: "pending" },
            { href: "/admin/orders/ready", icon: "bullseye", text: "ready" },
            { href: "/admin/orders/done", icon: "brightness-1", text: "done" },
        ];

        this.order = {
                id: 1,
                date: "2021-05-05",
                total: 500,
                state: "ready",
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
    //TODO: handlers
    methods: {
        changeToDone(id: number) {
            this.$router.push("admin/orders/done/${id}");
        }
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
  