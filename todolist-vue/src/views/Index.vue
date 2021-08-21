<template>
    <div>
        <Header></Header>
        index
        首页的展示
    </div>
</template>

<script>
    import Header from "../components/Header";
    export default {
        name: "index",
        components: {Header},
        data() {
            return {
                color:'#409EFF'
            }
        }
    }
</script>

<style scoped>

</style>