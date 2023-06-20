<template>
  <SimpleBodyLayout>
    <TwoColumnsPanel>
      <template v-slot:first>
          <TitleCardLinks :title="$t('hello') + ', ' + user.name + '!'" :items="items" />
      </template>
      <template v-slot:second>
        <TitleWithButton :title="$t('profile')" :button-text="$t('edit-profile')" :button-handler="editProfile" />
        <ClientCard :client="user" />
      </template>
    </TwoColumnsPanel>
  </SimpleBodyLayout>
</template>
  
<script lang="ts">
import { LinkProps } from "@/appTypes/Link";
import TwoColumnsPanel from "@/layouts/Body/TwoColumnsPanel.vue";
import SimpleBodyLayout from "@/layouts/Body/SimpleBodyLayout.vue";
import { UserInfoProps } from "@/appTypes/User";
import TitleWithButton from "@/components/molecules/TitleWithButton.vue";
import ClientCard from "@/components/organisms/Card/ClientCard.vue";
import { useUserStore } from "@/store/userStore";
import { useCustomerStore } from "@/store/customerStore";
import TitleCardLinks from "@/components/organisms/TitleCardLinks.vue";

const userStore = useUserStore();
const customerStore = useCustomerStore();

export default {
  name: "UserProfile",
  data: () => ({
    items: [] as LinkProps[],
    user:{} as UserInfoProps,
  }),
  mounted: function () {
    this.user = {
      id: userStore.id,
      name: userStore.name,
      email: userStore.email,
      nif: customerStore.nif,
      address: customerStore.address
    } as UserInfoProps;

    this.items = [
      { href: "/user/profile", icon: "bullseye", text: "profile" },
      { href: "/orders", icon: "brightness-1", text: "my-orders" },
    ];
  },
  //TODO: ir buscar os direitos
  methods: {
    editProfile() {
      this.$router.push("/user/profile/edit");
    },

  },
  components: {
    TwoColumnsPanel,
    SimpleBodyLayout,
    TitleWithButton,
    ClientCard,
    TitleCardLinks
  },
};
</script>
  