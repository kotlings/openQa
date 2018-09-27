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
    </head>

    <body>

        <jsp:include page="layoutbbs/header.jsp"></jsp:include>

        <div class="main layui-clear">
            <h2 class="page-title">注册</h2>
            <div class="layui-form layui-form-pane">
                <form>
                    <div class="layui-form-item">
                        <label for="L_email" class="layui-form-label">邮箱</label>
                        <div class="layui-input-inline">
                            <input type="text" id="L_email" name="account" required autocomplete="off" class="layui-input">
                        </div>
                        <div class="layui-form-mid layui-word-aux">将会成为您唯一的登入名</div>
                    </div>
                    <div class="layui-form-item">
                        <label for="L_username" class="layui-form-label">昵称</label>
                        <div class="layui-input-inline">
                            <input type="text" id="L_username" name="name" required lay-verify="required" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label for="L_pass" class="layui-form-label">密码</label>
                        <div class="layui-input-inline">
                            <input type="password" id="L_pass" name="pwd" required lay-verify="required" autocomplete="off" class="layui-input">
                        </div>
                        <div class="layui-form-mid layui-word-aux">6到16个字符</div>
                    </div>
                    <div class="layui-form-item">
                        <label for="L_repass" class="layui-form-label">确认密码</label>
                        <div class="layui-input-inline">
                            <input type="password" id="L_repass" name="repass" required lay-verify="required" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <button class="layui-btn" lay-filter="*" lay-submit>立即注册</button>
                    </div>
                    <div class="layui-form-item fly-form-app">
                        <span>或者直接使用社交账号快捷注册</span>
                        <a href="" onclick="layer.msg('正在通过QQ登入', {icon:16, shade: 0.1, time:0})" class="iconfont icon-qq" title="QQ登入"></a>
                        <a href="" onclick="layer.msg('正在通过微博登入', {icon:16, shade: 0.1, time:0})" class="iconfont icon-weibo" title="微博登入"></a>
                    </div>
                </form>
            </div>
        </div>


        <jsp:include page="layoutbbs/footer.jsp"></jsp:include>
        <script src="../blljs/statistics.js"></script>
        <script src="../Resources/jquery.js"></script>
        <script>
            layui.use(['form', 'layedit', 'laydate'], function() {
                var form = layui.form(),
                    layer = layui.layer,
                    laydate = layui.laydate;
                //监听提交
                form.on('submit(*)', function(data) {
                    $.post("addUser", data.field,
                        function(obj) {
                            if (obj.Status) {
                                location.href = "login";
                            } else {
                                layer.msg(obj.Message);
                            }
                        }, "json");
                    return false;
                });


            });
        </script>

    </body>

    </html>