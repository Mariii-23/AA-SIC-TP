<template>
    <SimpleBodyLayout>
      <TwoColumnsPanel>
        <template v-slot:first>
          <TitleCardLinksButton
            :title="$t('allUsers')"
            :items="items"
            :button-text="$t('addAdmin')"
            :button-handler="addAdminHandler"
          />
        </template>
        <template v-slot:second>
          <TitleWithButton
            :title="$t('profile')"
            :button-text="$t('save-changes')"
            :button-handler="saveChanges"
          />
          <form ref="form">
                    <div class="custom-flex">
                        <v-row>
                            <v-col cols="4">
                                <v-list-subheader>
                                    <BodyText>{{ $t("name") }}</BodyText>
                                </v-list-subheader>
                            </v-col>

                            <v-col cols="8">
                                <v-text-field v-model="admin.name" name="name" :label="$t('name')" type="name"
                                    :placeholder="$t('name')" single-line class="input-form rounded-lg" required
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
                                <v-text-field v-model="admin.email" name="email" :label="$t('email')" type="email"
                                    :placeholder="$t('email')" single-line class="input-form rounded-lg" required
                                    bg-color="primary" />

                            </v-col>
                        </v-row>
                        <FullWidthButton :handle-click="saveChanges"> {{ $t("save-changes") }}</FullWidthButton>
                    
                    </div>
                </form>
        </template> </TwoColumnsPanel
    ></SimpleBodyLayout>
  </template>
  
  <script lang="ts">
  import { LinkProps } from "@/appTypes/Link";
  import TwoColumnsPanel from "@/layouts/Body/TwoColumnsPanel.vue";
  import TitleCardLinksButton from "@/components/organisms/TitleCardLinksButton.vue";
  import SimpleBodyLayout from "@/layouts/Body/SimpleBodyLayout.vue";
  import { UserInfoProps } from "@/appTypes/User";
  import TitleWithButton from "@/components/molecules/TitleWithButton.vue";
  import { useRoute } from "vue-router";
  import BodyText from "@/components/atoms/Typography/BodyText.vue";
  import FullWidthButton from "@/components/atoms/Button/FullWidthButton.vue";
  
  export default {
    name: "AdminAdminPage",
    //TODO: ir buscar os direitos
    data: () => ({
      items: Array as () => LinkProps[],
      admin: Object as () => UserInfoProps,
    }),
    mounted: function () {
      const route = useRoute();
      //TODO: ir buscar o admin consoante o id dado
      this.admin = {
        name: "Maria",
        email: "maria@hotmail.com",
        id: route.params.id,
      } as UserInfoProps;
  
      this.items = [
        { href: "/admin/profile", icon: "bullseye", text: "profile" },
        { href: "/admin", icon: "brightness-1", text: "admins" },
        { href: "/admin/client", icon: "brightness-1", text: "clients" },
      ];
    },
    //TODO: ir buscar os direitos
    methods: {
      addAdminHandler() {
        this.$router.push("/addAdmin/");
      },
      saveChanges() {
        console.log("save changes");
      },

    },
    components: {
      TwoColumnsPanel,
      TitleCardLinksButton,
      SimpleBodyLayout,
      TitleWithButton,
      BodyText,
      FullWidthButton
    },
  };
  </script>
  