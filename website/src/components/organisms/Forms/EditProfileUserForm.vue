<template>
   <form ref="form">
        <v-row>
            <v-col cols="4">
                <v-list-subheader>
                    <BodyText>{{ $t("name") }}</BodyText>
                </v-list-subheader>
            </v-col>
            <v-col cols="8">
                <v-text-field v-model="name" name="name" :label="$t('name')" type="name" :placeholder="$t('name')"
                    single-line class="input-form rounded-lg" required bg-color="primary" :rules="nameRules" />
            </v-col>
        </v-row>
        <v-row>
            <v-col cols="4">
                <v-list-subheader>
                    <BodyText>{{ $t("email") }}</BodyText>
                </v-list-subheader>
            </v-col>

            <v-col cols="8">
                <v-text-field v-model="email" name="email" :label="$t('email')" type="email" :placeholder="$t('email')"
                    single-line class="input-form rounded-lg" required bg-color="primary" :rules="emailRules" />

            </v-col>
        </v-row>
        <v-row>
            <v-col cols="4">
                <v-list-subheader>
                    <BodyText>{{ $t("nif") }}</BodyText>
                </v-list-subheader>
            </v-col>

            <v-col cols="8">
                <v-text-field v-model="nif" name="nif" :label="$t('nif')" type="nif" :placeholder="$t('nif')" single-line
                    class="input-form rounded-lg" required bg-color="primary" :rules="nifRules" />

            </v-col>
        </v-row>
        <v-row>
            <v-col cols="4">
                <v-list-subheader>
                    <BodyText>{{ $t("address") }}</BodyText>
                </v-list-subheader>
            </v-col>

            <v-col cols="8">
                <v-text-field v-model="address" name="address" :label="$t('address')" type="address"
                    :placeholder="$t('address')" single-line class="rounded-lg" required bg-color="primary"
                    :rules="addressRules" />

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
                    :placeholder="$t('password')" single-line class="input-form rounded-lg" required bg-color="primary"
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
                <v-text-field v-model="confirmPassword" name="password" :label="$t('confirm-pw')" type="password"
                    :placeholder="$t('confirm-pw')" single-line class="input-form rounded-lg" required bg-color="primary"
                    :rules="confirmPasswordRules" />

            </v-col>
        </v-row>
        <FullWidthButton class="mt-2" :handle-click="saveChanges"> {{ $t("save-changes") }}</FullWidthButton>
    </form>
</template>

<script lang="ts">
import FullWidthButton from "@/components/atoms/Button/FullWidthButton.vue";
import BodyText from "@/components/atoms/Typography/BodyText.vue";

export default {
    name: "EditProfileUserForm",
    data() {
        return {
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
            nif: "",
            nifRules: [
                value => {
                    if (value?.length === 9 && /[0-9-]+/.test(value)) return true

                    return this.$t("invalid-nif")
                },
            ],
            address: "",
            addressRules: [
                value => {
                    if (value?.length >= 8) return true

                    return this.$t("invalid-address")
                },
            ],
            password: "",
            passwordRules: [
                value => {
                    if (value?.length >= 8) return true

                    return this.$t("password-length")
                },
            ],
            confirmPassword: "",
            confirmPasswordRules: [
                value => {
                    if (value === this.password) return true

                    return this.$t("password-match")
                },
                value => {
                    if (value?.length >= 8) return true

                    return this.$t("password-length")
                },
            ],
        }
    },
    props: {
        nameUser: {
            type: String,
            required: true,
        },
        emailUser: {
            type: String,
            required: true,
        },
        nifUser: {
            type: String,
            required: true,
        },
        addressUser: {
            type: String,
            required: true,
        },
        passwordUser: {
            type: String,
            required: true,
        },
        saveChanges: {
            type: Function,
            required: true,
        },
    },
    components: {
        FullWidthButton,
        BodyText,
    },
}
</script>
