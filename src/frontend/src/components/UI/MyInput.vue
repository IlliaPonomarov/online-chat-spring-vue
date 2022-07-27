<template>
  <input class="text-sm text-gray-base w-full
                              mr-3 py-5 px-4 h-2 border
                              border-gray-200 rounded mb-2" type="text"
         @input="updateInput"
         :value="modelValue"/>
</template>

<script>
 export default {
  name: "my-input",

  props: {
    modelValue: [String, Number]
  },

   methods: {
    updateInput(event){
      this.$emit('update:modelValue', event.target.value)
    }
   }



}
</script>

<style scoped>

</style>