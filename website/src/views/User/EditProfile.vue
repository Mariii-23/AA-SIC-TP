<template>
    <SimpleBodyLayout>
        <TwoColumnsPanel>
            <template v-slot:first>
                <TitleCardLinks :title="$t('hello') + ', ' + name + '!'" :items="items" />
            </template>
            <template v-slot:second>
                <TitleWithButtonGoBack :title="$t('edit-profile')" :button-text="$t('save-changes')"
                    :button-handler="saveChanges" />
                <form ref="form" @submit.prevent="saveChanges()">
                    <v-row>
                        <v-col cols="4">
                            <v-list-subheader>
                                <BodyText>{{ $t("name") }}</BodyText>
                            </v-list-subheader>
                        </v-col>
                        <v-col cols="8">
                            <v-text-field v-model="name" name="name" :label="$t('name')" type="name"
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
                            <v-text-field v-model="email" name="email" :label="$t('email')" type="email"
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
                            <v-text-field v-model="nif" name="nif" :label="$t('nif')" type="nif" :placeholder="$t('nif')"
                                single-line class="input-form rounded-lg" required bg-color="primary" :rules="nifRules" />

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
                                :placeholder="$t('password')" single-line class="input-form rounded-lg" bg-color="primary"
                                :rules="passwordRules" />

                        </v-col>
                    </v-row>
                    <v-row>
                        <v-col cols="4">
                            <v-list-subheader>
                                <BodyText>{{ $t("confirm-pw") }}</BodyText>
                            </v-list-subheader>
                        </v-col>

                        <v-col cols="8">
                            <v-text-field v-model="conf_password" name="password" :label="$t('confirm-pw')" type="password"
                                :placeholder="$t('confirm-pw')" single-line class="input-form rounded-lg" bg-color="primary"
                                :rules="confirmPasswordRules" />

                        </v-col>
                    </v-row>
                    <FullWidthButton class="mt-2"> {{ $t("save-changes") }}</FullWidthButton>

                </form>
            </template>
        </TwoColumnsPanel>
    </SimpleBodyLayout>
</template>
  
<script lang="ts">
import { LinkProps } from "@/appTypes/Link";
import TwoColumnsPanel from "@/layouts/Body/TwoColumnsPanel.vue";
import SimpleBodyLayout from "@/layouts/Body/SimpleBodyLayout.vue";
import TitleWithButtonGoBack from "@/components/molecules/TitleWithButtonAndGoBack.vue";
import FullWidthButton from "@/components/atoms/Button/FullWidthButton.vue";
import TitleCardLinks from "@/components/organisms/TitleCardLinks.vue";
import { useCustomerStore } from "@/store/customerStore";
import { useUserStore } from "@/store/userStore";

const customerStore = useCustomerStore();
const userStore = useUserStore();

export default {
    name: "EditUserProfile",
    data() {
        return {
            items: [] as LinkProps[],
            id: "",
            name: "",
            nameRules: [
                value => {
                    if (value?.length >= 3 && /[^0-9]/.test(value)) return true
                    return this.$t("invalid-name")
                },
            ],
            email: "",
            emailRules: [
                value => {
                    if (/^[a-z.-]+[a-z0-9.-]+@[a-z.-]+\.[a-z]+$/i.test(value)) return true
                    return this.$t("invalid-email")
                },
            ],
            address: "",
            nif: "",
            nifRules: [
                value => {
                    if (value?.length === 9 && /[0-9-]+/.test(value)) return true
                    return this.$t("invalid-nif")
                },
            ],
            password: "",
            passwordRules: [
                //value => {
                //    if (value?.length >= 8) return true
                //    return this.$t("password-length")
                //},
            ],
            conf_password: "",
            confirmPasswordRules: [
                //value => {
                //    if (value === this.password) return true
                //    return this.$t("password-match")
                //},
            ],
        }
    },
    mounted: function () {
        (this.name = userStore.name),
            (this.email = userStore.email),
            (this.address = customerStore.address),
            (this.nif = customerStore.nif),
            (this.id = userStore.id),
            (this.items = [
                { href: "/user/profile", icon: "bullseye", text: "profile" },
                { href: "/user/orders", icon: "brightness-1", text: "my-orders" },
            ]);
    },
    methods: {
        async saveChanges() {
            let argName, argEmail, argAddress, argNif;
            if (this.name == userStore.name) argName = ""; else argName = this.name;
            if (this.email == userStore.email) argEmail = ""; else argEmail = this.email;
            if (this.address == customerStore.address) argAddress = ""; else argAddress = this.address;
            if (this.nif == customerStore.nif) argNif = ""; else argNif = this.nif;

            const r = await customerStore.editCustomer(this.id, argName, argEmail, argAddress, argNif, this.password)
            if (r) {
                userStore.update(argName, argEmail);
                customerStore.update(argAddress, argNif);
                this.$router.push("/user/profile");
            }
        },

    },
    components: {
        TwoColumnsPanel,
        SimpleBodyLayout,
        TitleWithButtonGoBack,
        FullWidthButton,
        TitleCardLinks
    },
};
</script>
  