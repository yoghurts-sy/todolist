<template>
  <div class="parent">
      <div class="div1">
        <Header></Header>
      </div>
      <div class="div2">

        <el-form ref="form" :model="form" label-width="80px">

          <el-form-item label="用户名">
            <el-input v-model="form.name"></el-input>
          </el-form-item>

          <el-form-item label="邮箱">
            <el-input v-model="form.email"></el-input>
          </el-form-item>

          <el-form-item label="密码">
            <el-input v-model="form.password"></el-input>
          </el-form-item>

          <el-form-item>
            <el-button type="primary" @click="onSubmit">立即注册</el-button>
            <el-button>取消</el-button>
          </el-form-item>

        </el-form>
      </div>

  </div>
</template>

// 改用带表单校验

<script>
import Header from "../components/Header";

export default {
  name: "Register",
  components: {Header},
  data(){
    return {
      form:{}
    }
  },
  methods: {
    onSubmit() {
      console.log('submit!');
      console.log(this.form);
    }
  }
}
</script>

<style scoped>
.parent {
  display: grid;
  grid-template-columns: 1fr 7fr 1fr;
  grid-template-rows: 1fr 4fr 1fr;
  grid-column-gap: 0px;
  grid-row-gap: 0px;
}

.div1 { grid-area: 1 / 1 / 2 / 4; }
.div2 { grid-area: 2 / 2 / 3 / 3; }
</style>