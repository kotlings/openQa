<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>OpenAuth.net官方社区 - 基于DDD的权限管理系统</title>
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

<script id="detail" type="text/html">
    {{#
    var info = layui.cache.user || {}, jie = d.objects, da = d.objects;
    }}


    <div class="fly-home" style="background-image: url();">
        <img src="../Resources/fly/images/avatar/{{info.pic}}" alt="{{info.name}}">
        <h1>{{info.name}}
            <i class="iconfont
  {{# if(info.sex == 0){ }}
  icon-nan
  {{# } else if(info.sex == 1){ }}
  icon-nv
  {{# } }}
  "></i>
            {{# if(info.rmb) { }}
            <span style="color: #FF7200;">VIP{{ info.rmb }}</span>
            {{# } }}
            {{# if(info.auth == 1){ }}
            <span style="color:#c00;">（超级码农）</span>
            {{# } else if(info.auth == 2) { }}
            <span style="color:#5FB878;">（活雷锋）</span>
            {{# } else if(info.auth == -1) { }}
            <span>（该号已被封）</span>
            {{# } }}
        </h1>
        <div class="layui-main">
            <p style="display: inline-block; max-width: 800px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap; color: #999; margin-top: 10px;">（{{= info.sign||'这个人懒得留下签名' }}）</p>
        </div>
        <!--<div class="fly-sns">
          <span lay-event="">添加好友</span>
        </div>-->
    </div>

    <div class="main layui-clear">
        <div class="fly-main layui-clear">

            <div class="home-nav">
                <a href="">主页</a>
                <!--<a href="">求解</a>-->
            </div>
            <div class="home-left">
                <h2>最近发表的求解</h2>
                <ul class="jie-row">
                    {{# jie.forEach(function(item, index){ }}
                    <li>
                        {{ item.status == 1 ? '<span class="fly-jing">精</span>' : ''}}
                        {{# if(item.accept >= 0){ }}
                        <span class="jie-status jie-status-ok">已解决</span>
                        {{# } else if(item.comment === 0 ){ }}
                        <span class="jie-status">求解中</span>
                        {{# } }}
                        <a href="/questions/detail?id={{ item.id }}">{{ item.title }}</a>
                        <i>{{item.time}}</i>
                        <em>{{item.hits}}阅/{{item.comment}}答</em>
                    </li>
                    {{# }); }}

                    {{# if(jie.length === 0){ }}
                    <li class="fly-none" style="min-height: 50px; padding:30px 0; height:auto;"><i style="font-size:14px;">没有发表任何求解</i></li>
                    {{# } }}
                </ul>

                <h2 style="margin-top:30px;">最近的回答</h2>
                <ul class="home-jieda">
                    {{# da.forEach(function(item, index){ }}
                    <li>
                        <p>
                            <span>{{item.time}}</span>
                            在<a href="/questions/detail?id={{ item.id }}" target="_blank">{{= item.title||'求解'}}</a>中回答：
                        </p>
                        <div class="home-dacontent">{{item.content}}</div>
                    </li>
                    {{# }); }}

                    {{# if(da.length === 0){ }}
                    <li class="fly-none" style="min-height: 50px; padding:30px 0; height:auto;"><span>没有回答任何问题</span></li>
                    {{# }; }}
                </ul>
            </div>
            <div class="home-right">
                <ul class="home-info">
                    <li><i class="iconfont icon-zuichun"></i>拥有飞吻：<span style="color: #FF7200;">{{info.experience}}</span></li>
                    <li><i class="iconfont icon-shijian"></i>加入时间：<span>{{info.createtime}}</span></li>
                    <li><i class="iconfont icon-chengshi"></i>城市：<span>{{= info.city||'中国 某城'}}</span></li>
                </ul>
                <!-- layer-300*250 -->
                <ins class="adsbygoogle"
                     style="display:inline-block;width:300px;height:250px"
                     data-ad-client="ca-pub-6111334333458862"
                     data-ad-slot="2182025432"></ins>

            </div>
        </div>
    </div>
</script>
<div id="details"></div>

<jsp:include page="../layoutbbs/footer.jsp "></jsp:include>
<script>
    $.get("/questions/getbyuser", { //问题详情
        uid: QueryString['uid'],
        index:1,
        size:10
    }, function (data) {
        var obj = JSON.parse(data);

        layui.use(['jquery', 'laytpl'], function () {
            var $ = layui.jquery;
            var laytpl = layui.laytpl;

            var getTpl = $("#detail").html();
            laytpl(getTpl).render(obj.Result, function (html) {
                $("#details").html(html);
            });
        });
    });
</script>

</body>

</html>