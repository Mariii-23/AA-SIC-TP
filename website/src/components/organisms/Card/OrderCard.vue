<template>
    <CardLayout class="bg-secondary">
        <v-card-item>
            <div class="product-state">
            <HeadingText>{{ $t("order") }} #{{ order.id }}</HeadingText>
            <v-chip class="ml-2">{{ order.state ?  $t(order.state) : "" }}</v-chip>
        </div>
        </v-card-item>
        <v-card-item>
            <div class="user-title-info-wrapper">
                <div>{{ $t("date-text") }} {{ order.date }}</div>
                <div>{{ $t("total") }}: {{ order.total }}€</div>
            </div>

            <v-table class="bg-secondary">
                <thead>
                    <tr>
                        <th>{{ $t("article") }}</th>
                        <th>{{ $t("material") }}</th>
                        <th>{{ $t("quantity") }}</th>
                        <th>{{ $t("price") }}</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="item in order.orderItems" :key="item.name">
                        <td class="product">
                            <v-img max-height="50px" max-width="50px" class="mr-2" :src="item.img"/>
                            {{ item.name }}
                        </td>
                        <td>
                            <Avatar :href="item.materialHref" :size="30" />
                        </td>
                        <td>{{ item.quantity }}</td>
                        <td>{{ item.price }}€</td>
                    </tr>
                </tbody>
            </v-table>
        </v-card-item>
    </CardLayout>
</template>
  
<script lang="ts">
import { Order } from "@/appTypes/Order";
import CardLayout from "@/layouts/CardLayout.vue";
import Avatar from "@/components/atoms/AvatarVue.vue";
import HeadingText from "@/components/atoms/Typography/HeadingText.vue";

export default {
    name: "OrderCard",
    props: {
        order: {
            type: Object as () => Order,
            required: true,
        },
    },
    components: { CardLayout, Avatar, HeadingText },
};
</script>
  
<style>
.user-title-info-wrapper {
    display: flex;
    flex-direction: column;
    gap: 10px;
}

.product {
    display: flex;
    flex-direction: row;
    justify-content: flex-start;
    align-items: center;
}

.product-state {
    display: flex;
    flex-direction: row;
    justify-content: flex-start;
    align-items: center;
}
</style>