<template>
  <Navbar></Navbar>
  <div id="app">
    <div class="container">
      <router-view></router-view>
    </div>
  </div>

  <MyFooter></MyFooter>
</template>


<script>
import Navbar from "@/components/Navbar";
import MyFooter from "@/components/MyFooter";
export default {
  components: {Navbar, MyFooter}
}
</script>



<style scoped>

</style>
