<template>
  <div class="parent">
      <div class="div1">
        <Header></Header>
      </div>
      <div class="div2">

        <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
          <el-form-item label="用户名" prop="name">
            <el-input v-model="ruleForm.email" ></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="pass">
            <el-input type="password" v-model="ruleForm.password" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
          </el-form-item>

        </el-form>

        <div>
          <span style="font-size: 13px">首次使用？</span>
          <el-button type="text" @click="register">点我注册</el-button>
        </div>

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

    var validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'));
      } else {
        if (this.ruleForm.checkPass !== '') {
          this.$refs.ruleForm.validateField('checkPass');
        }
        callback();
      }
    };
    var validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请再次输入密码'));
      } else if (value !== this.ruleForm.password) {
        callback(new Error('两次输入密码不一致!'));
      } else {
        callback();
      }
    };
    return {
      ruleForm: {
        email:'',
        password:''
      },
      rules: {
        pass: [
          { validator: validatePass, trigger: 'blur' }
        ],
        checkPass: [
          { validator: validatePass2, trigger: 'blur' }
        ],
      }
    }
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          console.log(this.ruleForm);
          this.$axios.post("/geeker/api/register", this.ruleForm).then(res=> {
            console.log(res.data);
            if(res.data.msg != "success") {
              alert(res.data.msg);
            }else{
              this.$router.push({name:"Index"});
              this.$store.state.isLogin = true;
              this.$store.state.user.email = this.res.data;
              this.$store.state.user.token = this.res.data;
            }
          })
          console.log(this.ruleForm);
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm(formName) {
      this.ruleForm = {};
    },
    register(){
      this.$router.push({name:"UserRegister"})
    }
  }
}
</script>

<style scoped>
.parent {
  display: grid;
  grid-template-columns: 1fr 7fr 1fr;
  grid-template-rows: 1fr 4fr 1fr;
  grid-column-gap: 0;
  grid-row-gap: 0;
}

.head{
  float: right;
  width: 100px;
  margin-right: 20px;
  margin-top: 15px;
  color: #2F55D4;
  background: rgba(2, 5, 12, 0.91);
}

.div1 { grid-area: 1 / 1 / 2 / 4; }
.div2 { grid-area: 2 / 2 / 3 / 3; }
</style>