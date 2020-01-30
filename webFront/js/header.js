Vue.component('app-header', {
    props: ['current'],
    data() {
        return {
            activeIndex: '1',
            activeIndex2: '1',
            user: {},
            isLogin: false
        }
    },
    created() {
        var isLogin = sessionStorage.isLogin
        if (isLogin === 'true') {
            var user = sessionStorage.user
            user = JSON.parse(user);
            this.user = user
            this.isLogin = true
        }
    },
    mounted() {
        console.log(this.current)
    },
    methods: {
        handleSelect(key, keyPath) {
            console.log(key, keyPath);
        },
        loginOut() {
            this.$confirm('是否退出登录?', '退出登录', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                //to do loginOut
                sessionStorage.isLogin = false
                sessionStorage.user = ''
                setTimeout(function () {
                    window.location.href = "../question/index.html"
                }, 1000)
//				service({
//					url: '/user/logout',
//					method: 'get',
//				}).then((res) => {
//					if(res.code !== 200) {
//						this.$notify.error({
//							title: '错误',
//							message: res.message
//						})
//						return
//					}
//					this.$notify.success({
//						title: '退出成功',
//					})
//					setTimeout(function() {
//						window.location.href = "../question/index.html"
//					}, 1000)
//				})
            })
        }
    },
    template: `
        <div class="container box-flex">
            <div class="left-logo box-flex align-center">
                <div class="nav">
                    <a href="../../pages/question/index.html"><img src="../../img/logo.png" /></a>
                </div>
                <!--<div class="nav p-l-m" :class="current === 'qa'?'active':''">-->
                    <!--<a href="../../pages/question/index.html"><i class="fa fa-question-circle-o fa-fw p-l-m p-r-m" aria-hidden="true"></i>问答</a>-->
                <!--</div>-->
                <!---->
                <!--<div  class="nav p-l-m m-l-llg" :class="current === 'ui'?'active':''"    >-->
              <!---->
                    <!--<a href="../../pages/main/index.html"><i class="fa fa-css3 fa-fw p-l-m p-r-m" aria-hidden="true"></i>框架</a>-->
                <!--</div>-->
                
            </div>
            <div class="right-nav flex-1 justify-end box-flex">
                <template v-if="!isLogin">
	                <div class="nav m-r-llg" :class="current === 'login'?'active':''">
	                    <a href="../../pages/user/login.html"><i class="fa fa-user-circle fa-fw p-r-m" aria-hidden="true"></i>登录</a>
	                </div>
	                <div class="nav m-l-llg" :class="current === 'register'?'active':''">
	                 <a href="../../pages/user/login.html?current='register'">注册</a>
	                </div>
	                <div class="nav m-l-llg">
	                    <i class="fa fa-qq fa-fw m-l-llg" style="display:none"   aria-hidden="true"></i>
	                </div>
	                <div class="nav m-l-llg">	
	                    <i class="fa fa-wechat fa-fw"  style="display:none"   aria-hidden="true"></i>
	                </div>
                </template>
                 <template v-else>
	                <div class="nav m-r-llg" :class="current === 'user'?'active':''">
	                    <a :href="'../../pages/user/index.html?id='+user.id"><img class="header-avator" :src="'../../img/avatar/'+user.pic" >{{user.name}}</a>
	                </div>
	                <div class="nav m-l-llg" :class="current === 'message'?'active':''">
	                   	 <a href="../../pages/user/message.html"><i class="fa fa-bell fa-fw p-r-m" aria-hidden="true"></i>消息</a>
	                </div>
	                <div class="nav m-l-llg" @click="loginOut">
	                 	  <i class="fa fa-power-off fa-fw p-r-m" aria-hidden="true"></i> 退出
	                </div>
                </template>
            </div>
        </div>
    `
})
