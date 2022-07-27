<template>
  <div>
    <header class="flex flex-row shadow-2xl  font-['Segoe UI']  text-4xl bg-purple-800 text-white p-8 mb-10">
      <div
          class="text-left font-bold mb-3 brightness-125 italic hover:not-italic"
          @click="$router.push('/')"><i class="fa fa-paper-plane"></i> wechat
      </div>

      <div class="ml-auto">
        <router-link to="/">Main</router-link>
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