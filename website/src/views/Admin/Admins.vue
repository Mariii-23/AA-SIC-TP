<template>
  <SimpleBodyLayout>
    <TwoColumnsPanel>
      <template v-slot:first>
        <TitleCardLinksButton
          :title="$t('allAdmins')"
          :items="items"
          :button-text="$t('addAdmin')"
          :button-handler="addAdminHandler"
        />
      </template>
      <template v-slot:second>
        <HeadingText>{{ $t("admins") }}</HeadingText>
        <SearchBar bg-color="primary" />
        <AdminExpansionPanels
          :admins="admins"
          :view-details-handler="viewDetailsHandler"
        />
      </template> </TwoColumnsPanel
  ></SimpleBodyLayout>
</template>

<script lang="ts">
import { LinkProps } from "@/appTypes/Link";
import TwoColumnsPanel from "@/layouts/Body/TwoColumnsPanel.vue";
import TitleCardLinksButton from "@/components/organisms/TitleCardLinksButton.vue";
import SimpleBodyLayout from "@/layouts/Body/SimpleBodyLayout.vue";
import HeadingText from "@/components/atoms/Typography/HeadingText.vue";
import SearchBar from "@/components/molecules/SearchBar.vue";
import { UserInfoProps } from "@/appTypes/User";
import AdminExpansionPanels from "@/components/molecules/expansionPanels/AdminExpansionPanels.vue";

export default {
  name: "AdminsAdminPage",
  //TODO: ir buscar os direitos
  data: () => ({
    items: Array as () => LinkProps[],
    admins: Array as () => UserInfoProps[],
  }),
  mounted: function () {
    const admin = {
      name: "Maria",
      email: "maria@hotmail.com",
      address: "Rua da Marina, Edificiona Nao sei , ablalkb",
      nif: "999888999",
      id: "1234",
    } as UserInfoProps;
    let users1: UserInfoProps[] = [];
    for (let i = 0; i < 8; i++) {
      users1.push(admin);
    }
    this.admins = users1;

    this.items = [
      { href: "/admin/profile", icon: "brightness-1", text: "profile" },
      { href: "/admin/company", icon: "brightness-1", text: "company" },
      { href: "/admin", icon: "bullseye", text: "admins" },
      { href: "/admin/client", icon: "brightness-1", text: "clients" },
    ];
  },
  methods: {
    viewDetailsHandler(id: string) {
      this.$router.push("/admin/" + id);
    },
    addAdminHandler() {
      this.$router.push("/addAdmin/");
    },
  },
  components: {
    TwoColumnsPanel,
    TitleCardLinksButton,
    SimpleBodyLayout,
    HeadingText,
    SearchBar,
    AdminExpansionPanels,
  },
};
</script>
