<template>
    <div>
        <Header class="header"></Header>
        <div class="tasks-container">
            <el-card class="box-card" v-for="(item,id) in tasks" :key="id" ref="boxCards">
                <div class="task-item">
                    <el-button size="mini" class="finishButton" circle @mouseover.native="hoverButton(item.index)" @mouseleave.native="leaveButton(item.index)" @click="clickButton(item.index)">
                        <i class="el-icon-check" ref="icons" style="color: white"></i>
                    </el-button>
                    <div class="task-content">
                        {{item.task_content}}
                    </div>
                    <el-dropdown class="moreButton">
                          <span class="el-dropdown-link">
                            <i class="el-icon-more"></i>
                          </span>
                        <el-dropdown-menu slot="dropdown">
                            <el-dropdown-item>创建时间:{{item.task_createtime}}</el-dropdown-item>
                            <el-dropdown-item divided>狮子头</el-dropdown-item>
                            <el-dropdown-item divided>螺蛳粉</el-dropdown-item>
                            <el-dropdown-item divided>蚵仔煎</el-dropdown-item>
                        </el-dropdown-menu>
                    </el-dropdown>
                    <!--<el-link icon="el-icon-more" class="moreButton"  :underline="false"></el-link>-->
                </div>
            </el-card>
            <el-button class="finishedButton"  size="mini" @click="loadFinishedTasks"><i class="el-icon-arrow-right" ref="finishedButtonIcon"></i> 已完成
                <span style="color:#ACB0AE">
                    {{finishedTasks.length}}
                </span>
            </el-button>
            <el-card class="box-card" v-if="showFinished" v-for="(item,index) in finishedTasks" :key="'finished-'+index">
                <div class="task-item">
                    <el-button size="mini" class="finishButton" circle>
                        <i class="el-icon-check" ref="icons" style="color: green"></i>
                    </el-button>
                    <div class="task-content" style="text-decoration: line-through;">
                        {{item.task_content}}
                    </div>
                    <el-dropdown class="moreButton">
                          <span class="el-dropdown-link">
                            <i class="el-icon-more"></i>
                          </span>
                        <el-dropdown-menu slot="dropdown">
                            <el-dropdown-item>创建时间:{{item.task_createtime}}</el-dropdown-item>
                            <el-dropdown-item divided>狮子头</el-dropdown-item>
                            <el-dropdown-item divided>螺蛳粉</el-dropdown-item>
                            <el-dropdown-item divided>蚵仔煎</el-dropdown-item>
                        </el-dropdown-menu>
                    </el-dropdown>
                    <!--<el-link icon="el-icon-more" class="moreButton"  :underline="false"></el-link>-->
                </div>
            </el-card>
        </div>
        <el-backtop></el-backtop>
    </div>
</template>

<script>
    import Header from "../components/Header";
    export default {
        name: "Tasks",
        components: {Header},
        data() {
            return{
                tasksCount:0,
                finishedTasksCount:24,
                showFinished:false,
                tasks: {},
                finishedTasks:{},
                boxCardsWidth:0
            }
        },
        mounted() {
            if (this.$store.state.user.token === '') {
                this.$router.push("/login")
            } else {
                window.addEventListener('scroll',this.handleScroll,true);
                    setTimeout(()=> {
                        //code
                        this.boxCardsWidth = this.$refs.boxCards['0'].$el.clientWidth;
                    }, 500);
            }
        },
        created() {
          this.$store.commit("SET_TOKEN", localStorage.getItem("userToken"));
            if (this.$store.state.user.token === '') {
                this.$router.push("/login")
            } else {
              this.$store.commit("LOGIN");
                console.log(this.$store.state.user.token);
                let param = new FormData;
                param.append("token",this.$store.state.user.token)
                this.$axios.post("/geeker/api/tasks",param).then(res=>{
                    console.log(res.data)
                    this.tasks = res.data.result
                })
                this.$axios.post("/geeker/api/finished",param).then(res=> {
                    this.finishedTasks = res.data.result
                })
            }
        },
      beforeUpdate() {
        if( !this.$store.state.isLogin ) {
            this.tasks = {};
            alert("请登录后再试");
            this.$router.push({name:"Login"});
          }
      },
      methods:{
            hoverButton(index) {
                this.$refs.icons[index].style.color = "green";
            },
            leaveButton(index) {
                this.$refs.icons[index].style.color = "white";
            },
            clickButton(index) {
            },
            load() {

            },
            handleScroll(){
                let scrollTop = document.body.scrollTop || document.documentElement.scrollTop;
                let length = this.tasks.length
                if (scrollTop <= 10) {
                    for (let i = 0; i < length; i++) {
                        this.$refs.boxCards[i].$el.style.width = this.boxCardsWidth + "px"
                        this.$refs.boxCards[i].$el.style.opacity = "100%"
                    }
                    return
                }
                let sum = 0
                let index = -1;
                let opacity = 0;
                for (let i = 0; i < length; i++) {
                    let tempHeight = this.$refs.boxCards[i].$el.offsetHeight
                    sum += tempHeight
                    if (scrollTop <= sum && scrollTop >= sum - tempHeight) {
                        opacity = (sum - scrollTop) + 10 > 100 ? 100 : (sum - scrollTop) + 10
                        index = i
                        break
                    }
                }
               /* console.log("opacity:"+opacity)
                console.log("index:"+index)*/
                let currentWidth = this.$refs.boxCards[index].$el.clientWidth;
              /*console.log(currentWidth + " <--> "+ this.boxCardsWidth)*/
                this.$refs.boxCards[index].$el.style.opacity = opacity + "%"
                if (currentWidth === this.boxCardsWidth) {
                    let out =  currentWidth - 15
                    this.$refs.boxCards[index].$el.style.width = out + "px"
                    if (index >= 1) { //宽度调正回来
                        for (let i = 0; i < index; i++) {
                            this.$refs.boxCards[i].$el.style.width = this.boxCardsWidth + "px"
                            this.$refs.boxCards[i].$el.style.opacity = "100%"
                        }
                    }
                    for (let i = index + 1; i < length; i++) {
                        this.$refs.boxCards[i].$el.style.width = this.boxCardsWidth + "px"
                        this.$refs.boxCards[i].$el.style.opacity = "100%"
                    }
                }

                /*console.log(this.$refs.boxCards['0'].$el.offsetHeight)
                console.log(this.$refs.boxCards['1'].$el.offsetHeight)
                console.log(this.$refs.boxCards['2'].$el.offsetHeight)*/
            },
            loadFinishedTasks(evt) {
                /*console.log(this.$refs.finishedButtonIcon.removeAttribute('class'))
                this.$refs.finishedButtonIcon.class = "el-icon-arrow-down";*/
                if (this.$refs.finishedButtonIcon.className === "el-icon-arrow-right") { //显示已完成的任务
                    this.$refs.finishedButtonIcon.setAttribute('class', "el-icon-arrow-down")
                    this.showFinished = true
                } else { //不显示已完成的任务
                    this.$refs.finishedButtonIcon.setAttribute('class', "el-icon-arrow-right")
                    this.showFinished = false
                }

                let target = evt.target;
                if(target.nodeName == "SPAN"){
                    target = evt.target.parentNode;
                }
                target.blur();

            }
        }
    }
</script>

<style scoped>
    .tasks-container {
        max-width: 980px;
        margin: 0 auto;
        border: #409EFF 2px solid;
        padding-top: 20px;
        padding-bottom: 30px;
    }
    .box-card {
        margin: 0 auto;
        max-width: 780px;
        padding: 0 0;
    }
    .el-icon-check {
        font-weight: bolder;
    }
    .task-item {
        font-size: 14px;
        /*border: black 2px solid;*/
        overflow: hidden;
    }
    .task-content {
        float: left;
        max-width: 600px;
        margin-top: 3px;
        /*border: brown 2px solid;*/
    }
    .finishButton {
        float: left;
        margin-right: 20px;
    }
    .moreButton {
        float: right;
        margin-right: 10px;
    }
    .finishedButton {
        margin-top: 20px;
        margin-left: 100px;;
        margin-bottom: 10px;
    }
</style>
