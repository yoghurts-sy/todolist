<template>
    <div class="head-container">
        <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect"
                 text-color="#646464"
                 active-text-color="#2F55D4">
            <el-button type="text" class="head-tag" @click="toIndex"><img src="../assets/geeker-logo.png"/><span>Geerker</span></el-button>
            <el-menu-item index="1">主页</el-menu-item>
            <el-submenu index="2">
                <template slot="title">筛选</template>
                <el-menu-item index="2-1">今日</el-menu-item>
                <el-menu-item index="2-2">已完成</el-menu-item>
                <el-menu-item index="2-3">未完成</el-menu-item>
            </el-submenu>
            <el-menu-item index="3">消息中心</el-menu-item>
            <el-menu-item index="4">订单管理</el-menu-item>
            <el-button type="text" class="head-login" @click="loginEvent" >登录</el-button>

        </el-menu>
        <div class="line"></div>
    </div>
</template>

<script>
    export default {
        name: "Header",
        data() {
            return {
                activeIndex: '1'
            }
        },
        methods:{
            handleSelect(key, keyPath) {
                console.log(key);
            },
            loginEvent() {
                console.log("login")
            },
            toIndex() {
                console.log("index")
            }
        }
    }
</script>

<style scoped>
    .head-container {
        max-width: 1080px;
        margin: 0 auto;
        height: 70px;
        z-index: 5;
        background: #F8F9FC;
        border: black 2px solid;
        padding-top: 10px;
    }
    .head-tag {
        color: #409EFF;
        font-size: larger;
        font-weight: bolder;
        margin-top: 4px;
        width: 220px;
        height: 100%;
        float: left;
        margin-right: 30px;
        border: blueviolet 1px solid;
    }
    .head-tag img {
        border: red 1px solid;
        margin-top: -10px;
        margin-left: 40px;
        height: 50px;
        width: 50px;
        float: left;
    }
    .head-tag span {
        margin-left: 6px;
        margin-top: 8px;
        border: black 1px solid;
        display:block;
        float: left;
        color: #2F55D4;
    }
    .el-menu-demo{
        width: 100%;
        float: left;
        height: 100%;
    }
    .head-login {
        float: right;
        width: 100px;
        margin-right: 20px;
        margin-top: 15px;
        color: #2F55D4;
        border: #2ECA9A 2px solid;
    }
</style>