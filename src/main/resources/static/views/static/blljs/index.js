//打赏模块
window.tctipConfig = {
  //图片路径前缀，用来修订图片相对路径,默认为""
  imagePrefix: "tctip-master",
  //css路径前缀，用来修订css相对路径,默认为""
  cssPrefix: "tctip-master",
  buttonImageId: 3,
  buttonTip: "zanzhu",
  list: {
    alipay: {
      qrimg: "img/alipayqr.png"
    },
    weixin: {
      qrimg: "img/weipayimg.png"
    },
  }
};

layui.use(['element', 'layer', 'jquery', 'laytpl'], function () {
  var element = layui.element(); //导航的hover效果、二级菜单等功能，需要依赖element模块
  var layer = layui.layer;
  var $ = layui.jquery;
  var laytpl = layui.laytpl;

  $.get("/main/getversion", function (data) {
    var getTpl = $("#version").html();
    laytpl(getTpl).render(data.Result, function (html) {
      $("#versionresult").html(html);
    });
  });
  //监听导航点击
  element.on('nav(demo)', function (elem) {
    //console.log(elem)
    layer.msg(elem.text());
  });

  $(function () {
    $("#downloadBtn").click(function () {
      $.post("main/addDownload", function (data) {
        //下载数增加
      });
    });
  });
});