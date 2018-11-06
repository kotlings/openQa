<template>

  <div class="header">
    <div class="main">
      <a class="logo" href="/index" title="OpenAuth.Net">OpenAuth.Net社区</a>
      <div class="nav">
        <a class="nav-this" href="/#/index">
          <i class="iconfont icon-wenda"></i>问答
        </a>
        <a href="/static/index.html" target="_blank">
          <i class="iconfont icon-ui"></i>框架
        </a>
      </div>
      <div v-if="checkLogin()" class="nav-user">
        <div id="view">
          <!-- 成功登录，加载用户信息 -->
          <a class="avatar" :href="'/user/index?uid='+ user.loginState.id">
            <img :src="'static/fly/images/avatar/'+user.loginState.pic" alt="" />
            <cite>{{ user.loginState.name }}</cite>
            <i v-if="user.loginState.rmb>0">Vip{{ user.loginState.rmb}}</i>
          </a>

          <div class="nav">
            <a href="#/user/message"><i class="iconfont icon-qq" style="top: 0; font-size: 22px;"></i>消息</a>
            <a href="#" @click="logout"><i class="iconfont icon-tuichu" style="top: 0; font-size: 22px;"></i>退了</a>
          </div>
        </div>
      </div>

      <div v-else class="nav-user">
        <div id="view">
          <!-- 未登入状态 -->
          <a class="unlogin" href="#/login"><i class="iconfont icon-touxiang"></i></a> <span>
            <a href="#/login">登入</a><a href="#/user/reg">注册</a></span>
          <p class="out-login">
            <a href="" onclick="layer.msg('正在通过QQ登入', {icon:16, shade: 0.1, time:0})" class="iconfont icon-qq" title="QQ登入"></a>
            <a href="" onclick="layer.msg('正在通过微博登入', {icon:16, shade: 0.1, time:0})" class="iconfont icon-weibo" title="微博登入"></a>
          </p>
        </div>
      </div>
    </div>
  </div>

</template>

<script>
  import {
    mapGetters
  } from 'vuex'
  export default {
    data: function () {
      return {

      }
    },
    methods: {
      logout() {
        this.$store.dispatch('logout').then(() => {
          location.reload() // 为了重新实例化vue-router对象 避免bug
        })
      },
      checkLogin(){
        //console.log(JSON.stringify(this.user))
        return (this.user.loginState != null)
      }
    },
    computed: {
      ...mapGetters([
        'user'
      ])
    }
  }

</script>
