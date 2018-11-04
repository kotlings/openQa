<template>
  <div class="main layui-clear">
    <h2 class="page-title">发表问题</h2>

    <div class="layui-form layui-form-pane">
      <form  method="post">
        <div class="layui-form-item ">
          <label for="L_title " class="layui-form-label ">标题</label>
          <div class="layui-input-block ">
            <input type="text " id="L_title " name="title" required lay-verify="required" autocomplete="off " class="layui-input ">
          </div>
        </div>
        <div class="layui-form-item layui-form-text ">
          <div class="layui-input-block ">
            <textarea id="L_content " name="content" required lay-verify="required" placeholder="请输入内容 " class="layui-textarea fly-editor "
              style="height: 260px; "></textarea>
          </div>
          <label for="L_content " class="layui-form-label " style="top: -2px; ">描述</label>
        </div>
        <div class="layui-form-item ">
          <div class="layui-inline ">
            <label class="layui-form-label ">悬赏金额</label>
            <div class="layui-input-block ">
              <select name="experience">
                <option value="5 " selected>5</option>
                <option value="20 ">20</option>
                <option value="50 ">50</option>
                <option value="100 ">100</option>
              </select>
            </div>
          </div>
        </div>

        <div class="layui-form-item ">
          <button class="layui-btn" lay-filter="*" lay-submit>立即发布</button>
        </div>
      </form>
    </div>
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
    mounted(){
      this.init();
    },
    methods: {
      init() {
        let _this = this;

        layui.use(['fly','form'], function () {
          var fly = layui.fly;
           var form = layui.form(),
          layer = layui.layer;
          form.render();
        //监听提交
        form.on("submit(*)", function(data) {
          questions.add(data.field).then(response=>{
              _this.$router.push({ path: "/question/detail?id="+response.data });
          }).catch(error => {
              layer.msg(error);
              _this.$router.push({ path: "/login"});
          });
          
          return false;
        });
          fly.layEditor({
            elem: '.fly-editor'
          });
        })
      }
    }
  };

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
