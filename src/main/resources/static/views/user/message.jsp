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
    <script src="../Resources/jquery.js"></script>
    <script src="../Resources/layui/layui.js"></script>
    <script src="/blljs/queryString.js"></script>
</head>

<body>

<jsp:include page="../layoutbbs/header.jsp"></jsp:include>

<div class="main layui-clear">
    <h2 class="page-title">
        我的消息
        <button class="layui-btn layui-btn-small layui-hide" id="LAY_delallmsg" style="position: absolute; right: 0;">清空全部消息</button>
    </h2>
    <div id="LAY_minemsg"></div>
    <div id="pager"></div>
</div>

<jsp:include page="../layoutbbs/footer.jsp"></jsp:include>

</body>
</html>

<script type="text/javascript">
    /*
     * index:当前页码
     * renderpager:是否绘制分页导航
     */
    function loadQuestions(fly,laytpl, laypage, index, renderpager){

        var tpl = '{{# var len = d.objects.length;\
                            if(len === 0){ }}\
                              <div class="fly-none">您暂时没有最新消息</div>\
                            {{# } else { }}\
                              <ul class="mine-msg">\
                              {{# for(var i = 0; i < len; i++){ }}\
                                <li data-id="{{d.objects[i].id}}">\
                                <a href="{{d.objects[i].href}}" target="_blank">{{ d.objects[i].content}}</a>\
                                <p><span>{{d.objects[i].time}}</span>\
                                <a href="javascript:;" class="layui-btn layui-btn-small fly-delete">删除</a></p></li>\
                              {{# } }}\
                              </ul>\
                            {{# } }}';


        fly.json('/message/get',
                {
                    index:index,
                    size:3,
                    key:""
                }, function(res){
                    var html = laytpl(tpl).render(res.Result);
                    $('#LAY_minemsg').html(html);
                    if(res.Status){
                        var delAll = $('#LAY_delallmsg');
                        delAll.removeClass('layui-hide');

                        if(!renderpager) return;

                        laypage({
                            cont: 'pager'
                            ,pages: res.Result.pagecnt //总页数
                            ,groups: 8 //连续显示分页数
                            ,jump: function(obj, first){
                                //得到了当前页，用于向服务端请求对应数据
                                if(!first){
                                    loadQuestions(fly, laytpl, laypage, obj.curr, false);
                                }
                            }
                        });
                    }
                });

    }

    layui.config({
        version: "1.0.0",
        base: '../Resources/fly/mods/'
    }).extend({
        fly: 'index'
    }).use(['laypage','laytpl', 'fly'], function(){

        var $ = layui.jquery;
        var layer = layui.layer;
        var laytpl = layui.laytpl;
        var laypage = layui.laypage;
        var fly = layui.fly;

        loadQuestions(fly, laytpl, laypage, 1, true);

        var gather = {}, dom = {
            minemsg: $('#LAY_minemsg')
        };



        //我的消息
        gather.minemsg = function(){

            var delEnd = function(clear){
                if(clear || dom.minemsg.find('.mine-msg li').length === 0){
                    dom.minemsg.html('<div class="fly-none">您暂时没有最新消息</div>');
                }
            }

            //阅读后删除
            dom.minemsg.on('click', '.mine-msg li .fly-delete', function(){
                var othis = $(this).parents('li'), id = othis.data('id');
                fly.json('/message/del', {id: id}, function(res){
                    if(res.Status){
                        othis.remove();
                        delEnd();
                    }
                });
            });

            //删除全部
            $('#LAY_delallmsg').on('click', function(){
                var othis = $(this);
                layer.confirm('确定清空吗？', function(index){
                    fly.json('/message/clear', {
                        type: 'all'
                    }, function(res){
                        if(res.Status){
                            layer.close(index);
                            othis.addClass('layui-hide');
                            delEnd(true);
                        }
                    });
                });
            });

        };
        dom.minemsg[0] && gather.minemsg();

    });
</script>