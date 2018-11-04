<template>
  <div class="main layui-clear">

    <div class="wrap">
      <div class="content detail">
        <h1>{{ question.title}}</h1>
        <div class="fly-tip fly-detail-hint">
          <span class="fly-tip-stick" v-if="question.stick>0">置顶帖</span>
          <span class="fly-tip-jing" v-if="question.status==1">精帖</span>

          <span v-if="question.accept == undefined">未结贴</span>
          <span class="fly-tip-jie" v-else>已采纳</span>

          <span v-if="user.auth ==1" class="jie-admin" type="del" style="margin-left: 20px;">删除</span>

          <div v-if="user.auth==1 || user.auth==2">
            <span v-if="question.stick>0" class="jie-admin" type="set" field="stick" rank="0" style="background-color:#ccc;">取消置顶</span>
            <span v-else class="jie-admin" type="set" field="stick" rank="1">置顶</span>

            <span v-if="question.status==1" class="jie-admin" type="set" field="status" rank="0" style="background-color:#ccc;">取消加精</span>
            <span v-else class="jie-admin" type="set" field="status" rank="1">加精</span>
          </div>

          <div class="fly-list-hint">
            <i class="iconfont" title="回答">&#xe60c;</i> {{question.comment}}
            <i class="iconfont" title="人气">&#xe60b;</i> {{question.hits}}
          </div>
        </div>
        <div class="detail-about">
          <a class="jie-user" :href="'#/user/detail?uid='+ question.user.id">
            <img :src="'static/fly/images/avatar/'+question.user.pic" :alt="question.user.name">
            <cite>
              {{question.user.name}}
              <em v-if="question.user.rmb" style="padding:0 5px; color: #FF7200;">VIP{{question.user.rmb}}</em>
              <em>发布于{{question.time}}</em>
            </cite>
          </a>
          <div class="detail-hits">

            <span style="color:#FF7200">悬赏：{{question.experience}}飞吻</span>

            <span v-if="(user && myself && question.accept == undefined) || user.auth == 1" class="jie-admin" type="edit">
              <a :href="'/questions/edit?id='+question.id">编辑此贴</a>
            </span>

          </div>
        </div>

        <div class="detail-body photos" style="margin-bottom: 20px;" v-html="question.content">
        </div>

        <a name="comment"></a>
        <h2 class="page-title">热忱回答<span>
            <em v-if="question.answers.length>0" id="jiedaCount"></em></span>
        </h2>

        <ul class="jieda photos" id="jieda">
          <li v-for="item in question.answers" :key="item.id" :class="{'jieda-daan':item.id== question.accept }">
            <a :name="'item-'+item.time"></a>
            <div class="detail-about detail-about-reply">
              <a class="jie-user" :href="'/user/index?uid='+item.user.id">
                <img :src="'static/fly/images/avatar/'+item.user.pic" :alt="item.user.name">
                <cite>
                  <i>{{item.user.name}}</i>
                  <em v-if="item.user.rmb" style="padding:0 ; color: #FF7200;">VIP{{ item.user.rmb }}</em>
                  <em v-if="item.user.id == question.user.id">(楼主)</em>
                  <em style="color:#5FB878" v-else-if="item.user.auth == 1">(管理员)</em>
                  <em style="color:#FF9E3F" v-else-if="item.user.auth == 2">（活雷锋）</em>
                  <em style="color:#999" v-else-if="item.user.auth == -1">（该号已被封）</em>
                </cite>
              </a>
              <div class="detail-hits">
                <span>{{item.time}}</span>
              </div>
              <i v-if="item.id == question.accept" class="iconfont icon-caina" title="最佳答案"></i>
            </div>
            <div class="detail-body jieda-body" v-html="item.content">
            </div>
            <div class="jieda-reply">
              <span type="reply"><i class="iconfont icon-svgmoban53"></i>回复</span>
              <div v-if="user.auth == 1 || user.auth == 2 || (myself && !item.mine)" class="jieda-admin">
                <div v-if="user.auth == 1 || (user.auth == 2 && item.accept != 1)">
                  <span type="edit">编辑</span>
                  <span type="del">删除</span>
                  <span v-if="question.accept == undefined" class="jieda-accept" type="accept">采纳 </span>
                </div>
                <span v-if="question.accept == undefined && !item.mine" class="jieda-accept" type="accept">采纳</span>
              </div>

            </div>
          </li>
        </ul>

        <div class="layui-form layui-form-pane">
          <form method="post">
            <div class="layui-form-item layui-form-text">
              <div class="layui-input-block">
                <textarea id="L_content" name="content" v-model="newcontent" required lay-verify="required" placeholder="我要回答"
                  class="layui-textarea fly-editor" style="height: 150px;"></textarea>
              </div>
            </div>
            <div class="layui-form-item">
              <input type="hidden" name="jid" :value="question.id">
              <button class="layui-btn" lay-filter="*" lay-submit>提交回答</button>
            </div>
          </form>
        </div>

      </div>
    </div>

    <layout-right></layout-right>
  </div>
</template>

<script>
  import * as questions from "@/api/questions";
  import right from "@/views/layout/right";
  import {
    mapGetters
  } from "vuex";
  export default {
    components: {
      "layout-right": right
    },
    data() {
      return {
        newcontent: '',
        myself: false, //标识该问题是否是登录的用户的
        question: {
          user: {
            id: '',
            name: '',
            pic: '',
            rmb: 0,
            auth: 0
          },
          answers: []
        }
      };
    },
    computed: {
      ...mapGetters(["user"])
    },

    mounted() {
      this.init()
    },
    methods: {
      init() {
        let _this = this;
        const id = this.$route.query && this.$route.query.id;
        questions.getone({
          id: id
        }).then(response => {
          _this.question = response.data;

          layui.use(['fly', 'form'], function () {
            var fly = layui.fly;
            var form = layui.form();
            var layer = layui.layer;
            _this.question.content = fly.content(_this.question.content)

            if (_this.user.token != undefined) {
              _this.myself = _this.user.token == _this.question.id
              _this.question.answers.forEach(val => {
                val.mine = _this.user.token == val.user.id //标识该回答是不是登录用户的
                val.content = fly.content(val.content)
              })
            }

            //监听提交
            form.on("submit(*)", function (data) {
              questions.addAnswer(data.field).then((addResp) => {
                _this.question.answers.push({
                  user: _this.user,
                  id: addResp.data,
                  content: fly.content(data.field.content)
                }) //直接加一条上去
                _this.newcontent = ''
              }).catch(error => {
                layui.layer.msg(error);
              });

              return false;
            });

            fly.layEditor({
              elem: '.fly-editor'
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
