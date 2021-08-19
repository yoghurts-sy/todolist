<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <HelloWorld :msg="msg"/>
  </div>
</template>

<script>
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'Home',
  components: {
    HelloWorld
  },
  data() {
    return{
        msg:''
    }
  },
  created() {
    let _this = this
    this.$axios.get('/hello').then(res=>{
        _this.msg = res.data
       console.log(res.data)
    })
  }
}
</script>
