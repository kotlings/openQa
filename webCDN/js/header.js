Vue.component('app-header', {
    props: ['current'],
    data() {
        return {
            activeIndex: '1',
            activeIndex2: '1'
        };
    },
    created(){
        console.log(this.current)
    },
    mounted(){
        console.log(this.current)
    },
    methods: {
        handleSelect(key, keyPath) {
            console.log(key, keyPath);
        }
    },
    template: `
        <div class="container box-flex">
            <div class="left-logo box-flex align-center">
                <div class="nav">
                    <a href="../../pages/main/index.html"><img src="../../img/logo.png" /></a>
                </div>
                <div class="nav p-l-m" :class="current === 'qa'?'active':''">
                    <a href="../../pages/main/index.html"><i class="fa fa-question-circle-o fa-fw p-l-m p-r-m" aria-hidden="true"></i>问答</a>
                </div>
                <div class="nav p-l-m m-l-llg" :class="current === 'ui'?'active':''">
                    <a href="../../pages/main/index.html"><i class="fa fa-css3 fa-fw p-l-m p-r-m" aria-hidden="true"></i>框架</a>
                </div>
            </div>
            <div class="right-nav flex-1 justify-end box-flex">
                <div class="nav m-r-llg" :class="current === 'login'?'active':''">
                    <i class="fa fa-user-circle fa-fw p-r-m" aria-hidden="true"></i>登录
                </div>
                <div class="nav m-l-llg" :class="current === 'register'?'active':''">
                        注册
                </div>
                <div class="nav m-l-llg">
                    <i class="fa fa-qq fa-fw m-l-llg" aria-hidden="true"></i>
                </div>
                <div class="nav m-l-llg">	
                    <i class="fa fa-wechat fa-fw" aria-hidden="true"></i>
                </div>
            </div>
        </div>
    `
})