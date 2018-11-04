<template>
  <div class="edge">


    <h3 class="page-title">新注册用户</h3>
    <div class="user-looklog leifeng-rank">
      <span>
        <!-- todo:原来这个循环是直接在a标签上的！！！！ -->
        <ul>
          <a :href="'/user/index?uid=' + item.id" v-for="item in newUsers" :key="item.id">
            <img :src="'static/fly/images/avatar/' +  item.pic">
            <cite>{{ item.name }}</cite>
            <i>{{ item.answercnt }}次回答</i>
          </a>
        </ul>
      </span>
    </div>

    <h3 class="page-title">最近热帖</h3>
    <ol class="fly-list-one">
      <ul>
        <li v-for="item in hotQuestions" :key="item.id">
          <a :href="'/#/question/detail?id=' +  item.id">{{ item.title }}</a>
          <span><i class="iconfont">&#xe60b;</i> {{ item.hits }}</span>
        </li>
      </ul>

    </ol>


    <div class="fly-link">
      <span>友情链接：</span>
      <a href="http://www.layui.com/" target="_blank">Layui</a>
      <a href="http://www.openauth.me/" target="_blank">openauth.me</a>
      <a href="http://layer.layui.com/" target="_blank">layer</a>
    </div>


  </div>
</template>

<script>
  import * as questions from "@/api/questions";
  import * as user from "@/api/users";
  export default {
    created() {
      this.init();
    },
    data() {
      return {
        newUsers: [],
        hotQuestions: [],
      };
    },
    methods: {
      init() {
        questions.getHot().then(response => {
          this.hotQuestions = response.data.objects;
        });

        user.getNew().then(response => {
          this.newUsers = response.data.objects;
        });
      }
    }
  };

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
