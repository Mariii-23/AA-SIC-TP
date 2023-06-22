<template>
    <SimpleBodyLayout>
        <div v-if="!loaded">
            <v-progress-linear indeterminate />
        </div>
        <HeadingText>{{ $t("favourites") }}</HeadingText>
        <ProductPreviewUserCards :products="favourites" :view-more-handler="viewMoreHandler"
            :favorite-icon-handler="favoriteIconHandler" />
        <div v-if="loaded && favourites.length == 0">
            <BodyText>{{ $t("no-favourites") }}</BodyText>
        </div>
        <Pagination :length="length" :total-visible="5" :handle-page-change="handlePageChange" />
    </SimpleBodyLayout>
</template>

<script lang="ts">
import SimpleBodyLayout from "@/layouts/Body/SimpleBodyLayout.vue";
import HeadingText from "@/components/atoms/Typography/HeadingText.vue";
import BodyText from "@/components/atoms/Typography/BodyText.vue";
import { useProductStore } from "@/store/productStore";
import { useUserStore } from "@/store/userStore";
import { useNotificationStore } from "@/store/notificationStore";
import ProductPreviewUserCards from "@/components/organisms/Cards/ProductPreviewUserCards.vue";
import { ProductUserProps } from "@/appTypes/ProductUserProps";
import Pagination from "@/components/molecules/Pagination.vue";

const productStore = useProductStore();
const userStore = useUserStore();
const notificationStore = useNotificationStore();

export default {
    name: "Favourites",
    data: () => ({
        favourites: [] as ProductUserProps[],
        loaded: false,
        length: 0,
        page: 1,
        productPerPage: 20,
    }),
    mounted: async function () {
        this.length = Math.ceil((await productStore.getNumberOfFavorites(userStore.id)) / this.productPerPage);
        await productStore.getAllFavoriteProducts(userStore.id, 0, this.productPerPage);
        this.loaded = true;
        this.favourites = []
        for (let i = 0; i < productStore.productsFavorites.length; i++) {
            this.favourites.push({
                favourite: true,
                ...productStore.productsFavorites[i],
            });
        }
        this.$watch(
            () => productStore.productsFavorites,
            (newValues) => {
                this.favourites = []
                for (let i = 0; i < newValues.length; i++) {
                    this.favourites.push({
                        favourite: true,
                        ...newValues[i],
                    });
                }
            }
        );
    },
    methods: {
        viewMoreHandler(productId: string) {
            this.$router.push(`/product/${productId}`);
        },
        async favoriteIconHandler(productId: string) {
            const userId = userStore.id;
            if (!userStore.isLoggedIn) {
                this.$router.push("/login");
                return;
            }
            const product = this.favourites.find((e) => e.id == productId);
            const req = await productStore.addRmvFavoriteProducts(userId, productId);
            if (req) {
                this.length = Math.ceil((await productStore.getNumberOfFavorites(userStore.id)) / this.productPerPage);
                if (product) {
                    notificationStore.openSuccessAlert("rm-favorite-success");
                } else {
                    await productStore.getAllFavoriteProducts(userId, (this.page - 1) * this.productPerPage, this.productPerPage);
                    notificationStore.openSuccessAlert("add-favorite-success");
                }
            } else {
                if (product) {
                    notificationStore.openErrorAlert("rm-favorite-error");
                } else notificationStore.openErrorAlert("add-favorite-error");
            }
        },
        async handlePageChange(page: number) {
            this.page = page;
            await productStore.getAllFavoriteProducts(userStore.id, (this.page - 1) * this.productPerPage, this.productPerPage);
        }
    },
    components: {
        SimpleBodyLayout,
        HeadingText,
        ProductPreviewUserCards,
        BodyText,
        Pagination
    },
}
</script>