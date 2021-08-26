<template>
    <div class="head-container">
        <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect"
                 text-color="#646464"
                 active-text-color="#2F55D4">
            <el-button type="text" class="head-tag" @click="toIndex"><img src="../assets/geeker-logo.png"/><span>Geerker</span></el-button>
            <el-menu-item index="1" id="item-1">主页</el-menu-item>
            <el-submenu index="2" id="item-2">
                <template slot="title">筛选</template>
                <el-menu-item index="2-1">今日</el-menu-item>
                <el-menu-item index="2-2">已完成</el-menu-item>
                <el-menu-item index="2-3">未完成</el-menu-item>
            </el-submenu>
            <el-menu-item index="3" id="item-3">详情</el-menu-item>
            <el-menu-item index="4" id="item-4">历史</el-menu-item>
            <el-submenu index="5" class="flexible-content">
                <template slot="title">📋</template>
                <el-menu-item index="5-1">主页</el-menu-item>
                <el-submenu index="5-2">
                    <template slot="title">筛选</template>
                    <el-menu-item index="5-2-1">今日</el-menu-item>
                    <el-menu-item index="5-2-2">已完成</el-menu-item>
                    <el-menu-item index="5-2-3">未完成</el-menu-item>
                </el-submenu>
                <el-menu-item index="5-3" >登录</el-menu-item>
            </el-submenu>
            <el-button type="text" class="head-login" @click="loginEvent" id="item-login">登录</el-button>
        </el-menu>
        <div class="line"></div>
    </div>
</template>

<script>
    import router from "../router";

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
                router.push({name:"register"});
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
    }
    .head-tag img {
        margin-top: -10px;
        margin-left: 40px;
        height: 50px;
        width: 50px;
        float: left;
    }
    .head-tag span {
        margin-left: 6px;
        margin-top: 8px;
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
    }
    .flexible-content {
        display: none;
        float: right;
        margin-left: 300px;
        margin-top: 7px;
    }
    @media (max-width: 768px) {
        .flexible-content {
            display: block;
        }
        .el-menu #item-1{
            display: none;
        }
        .el-menu #item-2{
            display: none;
        }
        .el-menu #item-3{
            display: none;
        }
        .el-menu #item-4{
            display: none;
        }
        .el-menu #item-login{
            display: none;
        }
    }
    /*再修改 这样不好*/
    @media (max-width: 660px) {
        .flexible-content {
            display: block;
            margin-left: 200px;
        }
    }
    @media (max-width: 560px) {
        .flexible-content {
            display: block;
            margin-left: 140px;
        }
    }
    @media (max-width: 494px) {
        .flexible-content {
            display: block;
            margin-left: 100px;
        }
    }
    @media (max-width: 456px) {
        .flexible-content {
            display: block;
            margin-left: 70px;
        }
    }
    @media (max-width: 430px) {
        .flexible-content {
            display: block;
            margin-left: 50px;
        }
    }
    @media (max-width: 405px) {
        .flexible-content {
            display: block;
            margin-left: 20px;
        }
    }
    @media (max-width: 372px) {
        .flexible-content {
            display: block;
            margin-left: -10px;
        }
    }
</style>