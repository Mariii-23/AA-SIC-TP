  <template>
    <v-card color="secondary">  
      <v-tabs v-model="tab" bg-color="transparent" color="black"
        grow
      >
        <v-tab>
          {{ $t('product-details') }}
        </v-tab>
        <v-tab>
          {{ $t('tech-info') }}
        </v-tab>
      </v-tabs>
  
      <v-window v-model="tab">
        <v-window-item>
          <v-card color="secondary" flat>
            <v-card-text>{{ text }}</v-card-text>
          </v-card>
        </v-window-item>

        <v-window-item>
          <v-card color="secondary" flat>
            <v-card-text>{{ text }}</v-card-text>
          </v-card>
        </v-window-item>

      </v-window>
    </v-card>
  </template>

  <script>
    export default {
      data () {
        return {
          tab: "Product Details" || "Detalhes do Produto",
          //FIXME: get data
          text: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
        }
      },
    }
  </script>