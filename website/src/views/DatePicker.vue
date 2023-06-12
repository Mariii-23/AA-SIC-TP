<template>
    <v-text-field type="date" label="Date"></v-text-field>
    <div>
      <div class="mb-6">Active picker: <code>{{ activePicker || 'null' }}</code></div>
      <v-menu
        ref="menu"
        v-model="menu"
        :close-on-content-click="false"
        transition="scale-transition"
        offset-y
        min-width="auto"
      >
        <template v-slot:activator="{ on, attrs }">
          <v-text-field
            v-model="date"
            label="Birthday date"
            prepend-icon="mdi-calendar"
            readonly
            v-bind="attrs"
            v-on="on"
          ></v-text-field>
        </template>
        <v-text-field
          v-model="date"
          type="date"
          label="Birthday date"
          :active-picker="activePicker"
          :max="(new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10)"
          min="1950-01-01"
          @change="save"
        />
      </v-menu>
    </div>
    ola
    <v-menu
        ref="menu"
        v-model="menu"
        :close-on-content-click="false"
        transition="scale-transition"
        offset-y
        min-width="auto"
      >
      <template v-slot:activator="{ on, attrs }">
          <v-text-field
            type="date"
            label="Birthday date"
            readonly
            v-bind="attrs"
            v-on="on"
          ></v-text-field>
          <v-text-field type="date" label="Date"></v-text-field>
        </template>
    </v-menu>
    
  </template>

<script>
export default {
  data: () => ({
    activePicker: null,
    date: null,
    menu: false,
  }),
  watch: {
    menu (val) {
      val && setTimeout(() => (this.activePicker = 'YEAR'))
    },
  },
  methods: {
    save (date) {
      this.$refs.menu.save(date)
    },
  },
}
</script>