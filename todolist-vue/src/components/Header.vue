<template>
    <div class="head-container">
        <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect"
                 text-color="#646464"
                 active-text-color="#409EFF">
            <el-button type="text" class="head-tag">Geerker TodoList</el-button>
            <el-menu-item index="1">主页</el-menu-item>
            <el-submenu index="2">
                <template slot="title">筛选</template>
                <el-menu-item index="2-1">今日</el-menu-item>
                <el-menu-item index="2-2">已完成</el-menu-item>
                <el-menu-item index="2-3">未完成</el-menu-item>
            </el-submenu>
            <el-menu-item index="3">消息中心</el-menu-item>
            <el-menu-item index="4"><a target="_blank">订单管理</a></el-menu-item>
            <el-button type="text" class="head-login" @click="loginEvent">登录</el-button>

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
            }
        }
    }
</script>

<style scoped>
    .head-container {
        max-width: 1080px;
        margin: 0 auto;
        height: 70px;
    }
    .head-tag {
        color: #409EFF;
        font-size: larger;
        font-weight: bolder;
        margin-top: 9px;
        width: 220px;
        float: left;
        margin-right: 30px;
    }
    .el-menu-demo{
        width: 100%;
        float: left;
        height: 100%;
    }
    .head-login {
        float: none;
        width: 100px;
        margin-left: 350px;
        margin-top: 15px;
    }
</style>