<template>
    <div class="wrapper">
        <v-btn color="primary" size="medium" class="btn btn--minus" @click="changeCounter('-1')" type="button"
            name="button">
            -
        </v-btn>
        <input class="quantity" type="text" name="name" :value="counter">
        <v-btn color="primary" size="medium" class="btn btn--plus" @click="changeCounter('1')" type="button" name="button">
            +
        </v-btn>
    </div>
</template>

<style scoped>
*,
*::before,
*::after {
    box-sizing: border-box;
}

/* For decoration only */
body {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    box-sizing: border-box;
}

/* Product Quantity */
.wrapper {
    height: 30px;
    display: flex;
}

.quantity {
    border: none;
    text-align: center;
    width: 30px;

    font-size: 16px;
    font-weight: 300;
}

.btn {
    width: 30px;
    cursor: pointer;
}

button:focus,
input:focus {
    outline: 0;
}
</style>

<script>
export default {
    name: "QuantityButton",
    data: () => ({
        counter: 1
    }),
    methods: {
        changeCounter: function (num) {
            this.counter += +num
            console.log(this.counter)
            !isNaN(this.counter) && this.counter > 0 ? this.counter : this.counter = 0;

        }
    },
}
</script>
