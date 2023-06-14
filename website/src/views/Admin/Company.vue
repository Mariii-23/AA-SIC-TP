<template>
    <SimpleBodyLayout>
      <TwoColumnsPanel>
        <template v-slot:first>
          <TitleCardLinksButton :title="$t('store')" :items="items" />
        </template>
        <template v-slot:second>
          <TitleWithButton
              :title="$t('company')"
              :buttonText="$t('edit-company-info')"
              :buttonHandler="editMaterialsHandler"
            />
          <CompanyTable :company="company"/>
          <TestTable></TestTable>
        </template> </TwoColumnsPanel
    ></SimpleBodyLayout>
  </template>
  
  <script lang="ts">
  import { LinkProps } from "@/appTypes/Link";
  import TwoColumnsPanel from "@/layouts/Body/TwoColumnsPanel.vue";
  import TitleCardLinksButton from "@/components/organisms/TitleCardLinksButton.vue";
  import SimpleBodyLayout from "@/layouts/Body/SimpleBodyLayout.vue";
  import { Company } from "@/appTypes/Company";
  import MaterialsTable from "@/components/organisms/Table/MaterialsTable.vue";
  import TitleWithButton from "@/components/molecules/TitleWithButton.vue";
  import CompanyTable from "@/components/organisms/Table/CompanyTable.vue";

  export default {
    name: "Materials",
    data: () => ({
      items: Array as () => LinkProps[],
      isModalOpen: false,
      company: Object as () => Company,
    }),
    mounted: function () {
      this.items = [
        { href: "/company", icon: "bullseye", text: "company" },
        { href: "/materials", icon: "brightness-1", text: "categories" },
        { href: "/materials", icon: "brightness-1", text: "materials" },
      ];
      this.company = {
        name: "Móveis Rodrigues",
        address:"Rua do Carvalhal, 18",
        postalCode:"4770-847",
        schedule: "Segunda a Sexta 09h00-12h30 | 14h00-19h00",
        phoneNo: "252 993 990",
        email: "email@email.com",
        socialMedia : [
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
      editMaterialsHandler() {
        console.log("edit materials")
      }
    },
    components: {
      TwoColumnsPanel,
      TitleCardLinksButton,
      SimpleBodyLayout,
      MaterialsTable,
      TitleWithButton,
      CompanyTable
    },
  };
  </script>
  