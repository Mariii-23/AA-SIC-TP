<template>
    <SimpleBodyLayout>
        <ConfirmationModal :title="$t('logout')" :text="$t('logout-text')" :confirmHandler="logoutHandler"
            :closeModal="closeModal" :isModalOpen="isModalOpen" />
        <TwoColumnsPanel>
            <template v-slot:first>
                <TitleCardLinksButton :title="$t('hello') + ', ' + user.name + '!'" :items="items"
                    :button-text="$t('logout')" :button-handler="openModal" />
            </template>
            <template v-slot:second>
                <TitleWithButtonGoBack :title="$t('edit-profile')" :button-text="$t('save-changes')"
                    :button-handler="editProfile" />
                <form ref="form">
                    <v-row>
                        <v-col cols="4">
                            <v-list-subheader>
                                <BodyText>{{ $t("name") }}</BodyText>
                            </v-list-subheader>
                        </v-col>
                        <v-col cols="8">
                            <v-text-field v-model="user.name" name="name" :label="$t('name')" type="name"
                                :placeholder="$t('name')" single-line class="input-form rounded-lg" required
                                bg-color="primary" :rules="nameRules" />
                        </v-col>
                    </v-row>
                    <v-row>
                        <v-col cols="4">
                            <v-list-subheader>
                                <BodyText>{{ $t("email") }}</BodyText>
                            </v-list-subheader>
                        </v-col>

                        <v-col cols="8">
                            <v-text-field v-model="user.email" name="email" :label="$t('email')" type="email"
                                :placeholder="$t('email')" single-line class="input-form rounded-lg" required
                                bg-color="primary" :rules="emailRules" />

                        </v-col>
                    </v-row>
                    <v-row>
                        <v-col cols="4">
                            <v-list-subheader>
                                <BodyText>{{ $t("nif") }}</BodyText>
                            </v-list-subheader>
                        </v-col>

                        <v-col cols="8">
                            <v-text-field v-model="user.nif" name="nif" :label="$t('nif')" type="nif"
                                :placeholder="$t('nif')" single-line class="input-form rounded-lg" required
                                bg-color="primary" :rules="nifRules" />

                        </v-col>
                    </v-row>
                    <v-row>
                        <v-col cols="4">
                            <v-list-subheader>
                                <BodyText>{{ $t("password") }}</BodyText>
                            </v-list-subheader>
                        </v-col>

                        <v-col cols="8">
                            <v-text-field v-model="password" name="password" :label="$t('password')" type="password"
                                :placeholder="$t('password')" single-line class="input-form rounded-lg" required
                                bg-color="primary" :rules="passwordRules" />

                        </v-col>
                    </v-row>
                    <v-row>
                        <v-col cols="4">
                            <v-list-subheader>
                                <BodyText>{{ $t("confirm-pw") }}</BodyText>
                            </v-list-subheader>
                        </v-col>

                        <v-col cols="8">
                            <v-text-field v-model="conf_password" name="password" :label="$t('confirm-pw')"
                                type="password" :placeholder="$t('confirm-pw')" single-line class="input-form rounded-lg"
                                required bg-color="primary" :rules="confirmPasswordRules"/>

                        </v-col>
                    </v-row>
                    <FullWidthButton class="mt-2" :handle-click="saveChanges"> {{ $t("save-changes") }}</FullWidthButton>

                </form>
            </template>
        </TwoColumnsPanel>
    </SimpleBodyLayout>
</template>
  
<script lang="ts">
import { LinkProps } from "@/appTypes/Link";
import TwoColumnsPanel from "@/layouts/Body/TwoColumnsPanel.vue";
import TitleCardLinksButton from "@/components/organisms/TitleCardLinksButton.vue";
import SimpleBodyLayout from "@/layouts/Body/SimpleBodyLayout.vue";
import { UserInfoProps } from "@/appTypes/User";
import { useRoute } from "vue-router";
import TitleWithButtonGoBack from "@/components/molecules/TitleWithButtonAndGoBack.vue";
import FullWidthButton from "@/components/atoms/Button/FullWidthButton.vue";
import ConfirmationModal from "@/components/organisms/Modal/ConfirmationModal.vue";

export default {
    name: "UserProfile",
    //TODO: ir buscar os direitos
    data() {
        return {
            items: [] as LinkProps[],
            user: Object as () => UserInfoProps,
            isModalOpen: false,
            nameRules: [
                value => {
                    if (value?.length >= 3 && /[^0-9]/.test(value)) return true

                    return this.$t('invalid-name')
                },
            ],
            emailRules: [
                value => {
                    if (/^[a-z.-]+[a-z0-9.-]+@[a-z.-]+\.[a-z]+$/i.test(value)) return true

                    return this.$t('invalid-email')
                },
            ],
            nifRules: [
                value => {
                    if (value?.length === 9 && /[0-9-]+/.test(value)) return true

                    return this.$t('invalid-nif')
                },
            ],
            password: "",
            passwordRules: [
                value => {
                    if (value?.length >= 8) return true

                    return this.$t('password-length')
                },
                //value => {
                //   if verificar password return true
                //
                //   return this.$t('incorrect-login')
                // }
            ],
            conf_password: "",
            confirmPasswordRules: [
                value => {
                    if (value === this.password) return true

                    return this.$t('password-match')
                },
            ],
        }
    },
    mounted: function () {
        const route = useRoute();
        //TODO: ir buscar o admin consoante o id dado
        this.user = {
            name: "Maria",
            email: "maria@hotmail.com",
            address: "Rua da Marina, Edificiona Nao sei , ablalkb",
            nif: "999888999",
            id: route.params.id,
        } as UserInfoProps;

        this.items = [
            { href: "/user/profile", icon: "bullseye", text: "profile" },
            { href: "/user/orders", icon: "brightness-1", text: "my-orders" },
        ];
    },
    //TODO: ir buscar os direitos
    methods: {
        logoutHandler() {
            console.log("logout");
        },
        editProfile() {
            console.log("edit profile");
        },
        saveChanges() {
            console.log("save changes");
        },

        closeModal() {
            this.isModalOpen = false;
        },
        openModal() {
            this.isModalOpen = true;
        },

    },
    components: {
        TwoColumnsPanel,
        TitleCardLinksButton,
        SimpleBodyLayout,
        TitleWithButtonGoBack,
        FullWidthButton,
        ConfirmationModal
    },
};
</script>
  