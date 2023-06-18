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
                    single-line class="rounded-lg" required bg-color="primary" :rules="nameRules" />
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
                    single-line class="rounded-lg" required bg-color="primary" :rules="emailRules" />
            </v-col>
        </v-row>

        <v-row>
            <v-col cols="4">
                <v-list-subheader>
                    <BodyText>{{ $t("password") }}</BodyText>
                </v-list-subheader>
            </v-col>

            <v-col cols="8">
                <v-text-field
                  v-model="password"
                  name="password"
                  :label="$t('password')"
                  type="password"
                  :placeholder="$t('password')"
                  required
                  bg-color="primary"
                  single-line
                  :rules="passwordRules"
                  class="input-form"
                />
            </v-col>
        </v-row>

        <v-row>
            <v-col cols="4">
                <v-list-subheader>
                    <BodyText>{{ $t("confirm-pw") }}</BodyText>
                </v-list-subheader>
            </v-col>

            <v-col cols="8">
                <v-text-field
                  v-model="conf_password"
                  name="password"
                  :label="$t('confirm-pw')"
                  type="password"
                  :placeholder="$t('confirm-pw')"
                  required
                  bg-color="primary"
                  single-line
                  :rules="confirmPasswordRules"
                  class="input-form"
                />
            </v-col>
        </v-row>
        <FullWidthButton class="mt-2" :handle-click="saveChanges">
            {{ $t("save-changes") }}</FullWidthButton>
    </form>
</template>

<script lang="ts">
import BodyText from "@/components/atoms/Typography/BodyText.vue";
import FullWidthButton from "@/components/atoms/Button/FullWidthButton.vue";

export default {
    name: "EditProfileAdminForm",
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
            ],
        }
    },
    props: {
        nameAdmin: {
            type: String,
            required: true,
        },
        emailAdmin: {
            type: String,
            required: true,
        },
        passwordAdmin: {
            type: String,
            required: true,
        },
        saveChanges: {
            type: Function,
            required: true,
        },
    },
    components: {
        BodyText,
        FullWidthButton,
    },
}
</script>