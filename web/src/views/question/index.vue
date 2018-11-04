<template>
  <div class="main layui-clear">
    <div class="wrap">
      <div class="content">
        <div class="fly-tab">
          <span>
            <a href="/club/index">全部</a>
            <a href="/club/index?type=unresolved">未结帖</a>
            <a href="/club/index?type=resolved">已采纳</a>
            <a href="/club/index?type=wonderful">精帖</a>
          </span>
          <form action="http://cn.bing.com/search" class="fly-search">
            <i class="iconfont icon-sousuo"></i>
            <input class="layui-input" autocomplete="off" placeholder="搜索内容，回车跳转" type="text" name="q">
          </form>
          <a href="#/question/add" class="layui-btn jie-add">发布问题</a>
        </div>


        <ul class="fly-list">
          <ul>
            <li class="fly-list-li" :key="item.id" v-for="item in list">
              <a :href="'/user/index?uid='+item.user.id" class="fly-list-avatar">
                <img :src="'static/fly/images/avatar/'+item.user.pic" alt="" />
              </a>
              <h2 class="fly-tip">
                <a :href="'/#/question/detail?id='+item.id"> {{ item.title }}</a>
                <span v-if="item.stick > 0" class="fly-tip-stick">置顶</span>
                <span v-if="item.status == 1 " class="fly-tip-jing">精帖</span>
              </h2>
              <p>
                <span><a href="#">{{ item.user.name }}</a></span>
                <span>{{item.time}} </span>
                <span>OpenAuth.Net框架综合</span>
                <span class="fly-list-hint">
                  <i class="iconfont" title="回答">&#xe60c;</i> {{ item.comment }}
                  <i class="iconfont" title="人气">&#xe60b;</i> {{ item.hits }}
                </span>
              </p>
            </li>
          </ul>
        </ul>

        <div id="pager"></div>
      </div>
    </div>
    <layout-right></layout-right>
  </div>
</template>

<script>
  import * as questions from "@/api/questions";
  import right from "@/views/layout/right"
  export default {
    components: {
      'layout-right': right
    },
    created() {
      this.init();
    },
    data() {
      return {
        list: [],
        newUsers: [],
        hotQuestions: [],
        listQuery: {
          index: 1,
          size: 12,
          key: '',
          type: ''
        }
      };
    },
    methods: {
      init(first) {
        this.listQuery.type = this.$route.query && this.$route.query.type;
        let _this = this;
        questions.queryList(this.listQuery).then(response => {
          this.list = response.data.objects;

          layui.use(['laypage'], function() {
            var laypage = layui.laypage;

            if(first != undefined && first) return;
             laypage({
            cont: 'pager'
            ,pages: response.data.pagecnt //总页数
            ,groups: 8 //连续显示分页数
            ,jump: function(obj, first){
                //得到了当前页，用于向服务端请求对应数据
                _this.listQuery.index = obj.curr
                if(!first){
                    _this.init(true);
                }
            }
        });
          })
        });
      }
    }
  };

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
