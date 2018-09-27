<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <title>OpenAuth.net官方社区 - 最好用的.net权限工作流框架</title>
        <meta name="Keywords" content="openauth.net,Openauth,权限管理,工作流,workflow">
        <meta name="Description" content="openauth.net,openauth,权限管理，工作流,workflow">
        <link rel="stylesheet" href="../Resources/layui/css/layui.css">
        <link rel="stylesheet" href="../Resources/fly/css/global.css">
        <script src="../Resources/layui/layui.js"></script>
        <script src="/blljs/queryString.js?v=1"></script>
    </head>

    <body>

        <jsp:include page="../layoutbbs/header.jsp"></jsp:include>

        <div class="main layui-clear">
            <h2 class="page-title">修改问题</h2>

            <!-- <div class="fly-none">并无权限</div> -->

            <div class="layui-form layui-form-pane">
                <form action="/questions/edit" method="post">
                    <input type="hidden" id="L_id" name="id">
                    <div class="layui-form-item ">
                        <label for="L_title" class="layui-form-label ">标题</label>
                        <div class="layui-input-block ">
                            <input type="text " id="L_title" name="title" required lay-verify="required" autocomplete="off " class="layui-input ">
                        </div>
                    </div>
                    <div class="layui-form-item layui-form-text ">
                        <div class="layui-input-block ">
                            <textarea id="L_content" name="content" required lay-verify="required" placeholder="请输入内容 " class="layui-textarea fly-editor " style="height: 260px; "></textarea>
                        </div>
                        <label for="L_content" class="layui-form-label " style="top: -2px; ">描述</label>
                    </div>

                    <div class="layui-form-item ">
                        <button class="layui-btn" lay-filter="*" lay-submit>保存修改</button>
                    </div>
                </form>
            </div>
        </div>


        <jsp:include page="../layoutbbs/footer.jsp"></jsp:include>
        <script>
            layui.cache.page = 'jie';

            layui.config({
                version: "1.0.0",
                base: '../Resources/fly/mods/'
            }).extend({
                fly: 'index'
            }).use(['fly', 'jquery','form'], function () {
                var fly = layui.fly;
                var $ = layui.jquery;
                var form = layui.form();

                $.get("/questions/getone", { //问题详情
                    id: QueryString['id']
                }, function (data) {
                    var obj = JSON.parse(data);

                    $("#L_title").val(obj.Result.title);
                    $("#L_content").val(obj.Result.content);
                    $("#L_id").val(obj.Result.id);

                    fly.layEditor({elem: '.fly-editor'});
              });
            });

        </script>

    </body>

    </html>