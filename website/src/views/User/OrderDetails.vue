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
                <TitleCardLinksButton :title="$t('hello') + ', ' + userName + '!'" :items="items"
                    :button-text="$t('logout')" :button-handler="openModal" />
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
import TitleCardLinksButton from "@/components/organisms/TitleCardLinksButton.vue";
import SimpleBodyLayout from "@/layouts/Body/SimpleBodyLayout.vue";
import { Order } from "@/appTypes/Order";
import { useRoute } from "vue-router";
import OrderCard from "@/components/organisms/Card/OrderCard.vue";
import TitleGoBack from "@/components/molecules/TitleGoBack.vue";
import ConfirmationModal from "@/components/organisms/Modal/ConfirmationModal.vue";

export default {
    name: "OrderDetails",
    data: () => ({
        items: [] as LinkProps[],
        userName: "",
        order: Object as () => Order,
        isModalOpen: false,
    }),
    methods: {
        logoutHandler() {
        console.log("logout");
      },
      closeModal() {
        this.isModalOpen = false;
      },
      openModal() {
        this.isModalOpen = true;
      },
    },
    mounted: function () {
        const route = useRoute();
        //TODO: ir buscar os direitos
        this.userName = "Maria";

        this.items = [
            { href: "/user/profile", icon: "brightness-1", text: "profile" },
            { href: "/user/orders", icon: "bullseye", text: "my-orders" },
        ];
        this.order = {
            id: 1,
            date: "2021-05-05",
            total: 100,
            state: "pending",
            orderItems: [
                {
                    name: "Cadeira",
                    quantity: 2,
                    price: 50,
                    img: "https://www.ikea.com/pt/pt/images/products/bergmund-cadeira-efeito-carvalho-hallarp-bege__0926594_pe789377_s5.jpg",
                    material: "https://upload.wikimedia.org/wikipedia/commons/thumb/4/43/Red_flag.svg/1280px-Red_flag.svg.png"
                }
        ]};
    },
    components: {
        TwoColumnsPanel,
        TitleCardLinksButton,
        SimpleBodyLayout,
        OrderCard,
        TitleGoBack,
        ConfirmationModal
    },
};
</script>
  