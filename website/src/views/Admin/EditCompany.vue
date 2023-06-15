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
                <TitleCardLinksButton :title="$t('store')" :items="items" :button-text="$t('logout')"
            :button-handler="openModal"/>
            </template>
            <template v-slot:second>
                <TitleWithButton :title="$t('company')" :buttonText="$t('save-changes')"
                    :buttonHandler="saveChanges" />
                <form ref="form">
                    <div class="custom-flex">
                        <v-row>
                            <v-col cols="4">
                                <v-list-subheader>
                                    <BodyText>{{ $t("name") }}</BodyText>
                                </v-list-subheader>
                            </v-col>

                            <v-col cols="8">
                                <v-text-field v-model="company.name" name="name" :label="$t('name')" type="name"
                                    :placeholder="$t('name')" single-line class="input-form rounded-lg" required
                                    bg-color="primary" />

                            </v-col>
                        </v-row>
                        <v-row>
                            <v-col cols="4">
                                <v-list-subheader>
                                    <BodyText>{{ $t("address") }}</BodyText>
                                </v-list-subheader>
                            </v-col>

                            <v-col cols="8">
                                <v-text-field v-model="company.address" name="address" :label="$t('address')" type="address"
                                    :placeholder="$t('address')" single-line class="input-form rounded-lg" required
                                    bg-color="primary" />

                            </v-col>
                        </v-row>

                        <v-row>
                            <v-col cols="4">
                                <v-list-subheader>
                                    <BodyText>{{ $t("postal-code") }}</BodyText>
                                </v-list-subheader>
                            </v-col>

                            <v-col cols="8">
                                <v-text-field v-model="company.postalCode" name="postalcode" :label="$t('postal-code')" type="address"
                                    :placeholder="$t('postal-code')" single-line class="input-form rounded-lg" required
                                    bg-color="primary" />

                            </v-col>
                        </v-row>

                        <v-row>
                            <v-col cols="4">
                                <v-list-subheader>
                                    <BodyText>{{ $t("schedule") }}</BodyText>
                                </v-list-subheader>
                            </v-col>

                            <v-col cols="8">
                                <v-text-field v-model="company.schedule" name="schedule" :label="$t('schedule')" type="schedule"
                                    :placeholder="$t('schedule')" single-line class="input-form rounded-lg" required
                                    bg-color="primary" />

                            </v-col>
                        </v-row>

                        <v-row>
                            <v-col cols="4">
                                <v-list-subheader>
                                    <BodyText>{{ $t("phoneNo") }}</BodyText>
                                </v-list-subheader>
                            </v-col>

                            <v-col cols="8">
                                <v-text-field v-model="company.phoneNo" name="phoneNo" :label="$t('phoneNo')" type="phoneNo"
                                    :placeholder="$t('phoneNo')" single-line class="input-form rounded-lg" required
                                    bg-color="primary" />

                            </v-col>
                        </v-row>

                        <v-row>
                            <v-col cols="4">
                                <v-list-subheader>
                                    <BodyText>{{ $t("email") }}</BodyText>
                                </v-list-subheader>
                            </v-col>

                            <v-col cols="8">
                                <v-text-field v-model="company.email" name="email" :label="$t('email')" type="email"
                                    :placeholder="$t('email')" single-line class="input-form rounded-lg" required
                                    bg-color="primary" />

                            </v-col>
                        </v-row>

                        <v-row v-for="social_media in company.socialMedia" :key="social_media.name">
                            <v-col cols="4">
                                <v-list-subheader>
                                    <BodyText>{{ social_media.name }}</BodyText>
                                </v-list-subheader>
                            </v-col>

                            <v-col cols="8">
                                <v-text-field v-model="social_media.link" name="socialmedia" :label="social_media.name" 
                                    :placeholder="social_media.name" single-line class="input-form rounded-lg" required
                                    bg-color="primary" />

                            </v-col>
                        </v-row>
                        <PrimaryButton :handleClick="addSocialNetwork" class="btn">{{ $t("add-social") }}</PrimaryButton>
                        <FullWidthButton :handle-click="saveChanges"> {{ $t("save-changes") }}</FullWidthButton>
                    </div>
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
import { Company } from "@/appTypes/Company";
import BodyText from "@/components/atoms/Typography/BodyText.vue";
import FullWidthButton from "@/components/atoms/Button/FullWidthButton.vue";
import PrimaryButton from "@/components/atoms/Button/PrimaryButton.vue";
import TitleWithButton from "@/components/molecules/TitleWithButton.vue";
import ConfirmationModal from "@/components/organisms/Modal/ConfirmationModal.vue";

export default {
    name: "EditCompany",
    data: () => ({
        items: Array as () => LinkProps[],
        isModalOpen: false,
        company: Object as () => Company,
    }),
    mounted: function () {
        this.items = [
            { href: "/admin/company", icon: "bullseye", text: "company" },
            { href: "/admin/categories", icon: "brightness-1", text: "categories" },
            { href: "/admin/materials", icon: "brightness-1", text: "materials" },
        ];
        this.company = {
            name: "Móveis Rodrigues",
            address: "Rua do Carvalhal, 18",
            postalCode: "4770-847",
            schedule: "Segunda a Sexta 09h00-12h30 | 14h00-19h00",
            phoneNo: "252 993 990",
            email: "email@email.com",
            socialMedia: [
                {
                    name: "Facebook",
                    link: "www.facebook.com"
                },
                {
                    name: "Instagram",
                    link: "www.instagram.com"
                }
            ]
        }
    },
    //TODO: ir buscar os direitos
    methods: {
        saveChanges()  {
            console.log("save changes")
        },
        addSocialNetwork()  {
            console.log("add social network")
        },
        logoutHandler() {
        console.log("logout")
      },
      closeModal() {
        this.isModalOpen = false;
      },
      openModal() {
        this.isModalOpen = true;
      }
    },
    components: {
        TwoColumnsPanel,
        TitleCardLinksButton,
        SimpleBodyLayout,
        BodyText,
        FullWidthButton,
        PrimaryButton,
        ConfirmationModal,
        TitleWithButton
    },
};
</script>

<style scoped>
.btn {
    margin-bottom: 20px;
}
</style>