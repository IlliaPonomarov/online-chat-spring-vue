<template>
  <div class="font-['Cambria']">

    <header class="rounded-T-lg flex flex-row shadow-2xl  text-4xl bg-purple-800 text-white p-8 mb-10">
      <div
          class="text-left font-bold mb-3 brightness-125 italic hover:not-italic"
          @click="$router.push('/hello')"><i class="fa fa-paper-plane"></i> wechat
      </div>

      <div  class="ml-auto text-1xl">
          <div class="text-lowercase">
            <router-link class="no-underline hover:no-underline text-white hover:text-red-300" to="/hello">logout</router-link>
          </div>
      </div>

    </header>

  </div>
</template>

<script>
export default {
  name: "my-navbar"
}
</script>

<style scoped>

</style>chat