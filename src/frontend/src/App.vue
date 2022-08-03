<template>

  <div id="app" >
    <div >
      <router-view></router-view>
    </div>
  </div>

</template>


<script>

export default {


  data: function (){
    return{
      currentPath: this.$router.name,
    }
  },

  computed: {
    getCurrentPath(){
      console.log("Current Path: " + this.currentPath);
      return this.currentPath;
    }
  }
}
</script>



<style scoped>

</style>
