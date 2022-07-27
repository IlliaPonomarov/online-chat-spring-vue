<template>
  <Navbar></Navbar>
  <div id="app">
    <div class="container">
      <router-view></router-view>
    </div>
  </div>
</template>


<script>
import Navbar from "@/components/Navbar";
export default {
  components: {Navbar}
}
</script>



<style scoped>

</style>
