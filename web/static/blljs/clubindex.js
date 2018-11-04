
/*
 * index:当前页码
 * renderpager:是否绘制分页导航
 */
function loadQuestions(laytpl, laypage, index, renderpager){
    var type = QueryString['type'];
    $.get("/questions/get", {
        index: index,
        size: 10,
        type: type
    }, function(data) {
        var obj = JSON.parse(data);
        var getTpl = $("#question").html();
        laytpl(getTpl).render(obj, function(html) {
            $("#questions").html(html);
        });

        if(!renderpager) return;

        laypage({
            cont: 'pager'
            ,pages: obj.Result.pagecnt //总页数
            ,groups: 8 //连续显示分页数
            ,jump: function(obj, first){
                //得到了当前页，用于向服务端请求对应数据
                if(!first){
                    loadQuestions(laytpl, laypage, obj.curr, false);
                }
            }
        });
    });
}

layui.use(['laypage', 'laytpl'], function() {
      var laytpl = layui.laytpl;
      var laypage = layui.laypage;

    loadQuestions(laytpl, laypage, 1, true);

    $.get("/user/getnew", {
          index: 1,
          size: 8
      }, function(data) {
          var obj = JSON.parse(data);
          var getTpl = $("#user").html();
          laytpl(getTpl).render(obj, function(html) {
              $("#users").html(html);
          });
      });

      $.get("/questions/gethot", {
          index: 1,
          size: 10
      }, function(data) {
          var obj = JSON.parse(data);
          var getTpl = $("#hotquestion").html();
          laytpl(getTpl).render(obj, function(html) {
              $("#hotquestions").html(html);
          });
      });
  });