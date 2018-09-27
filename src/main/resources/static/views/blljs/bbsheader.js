$.get("/user/getuser", function (data) {
    var obj = JSON.parse(data);

    if (obj.Status) {
        layui.cache.user = {
            username: obj.Result.name,
            uid: obj.Result.id,
            avatar: '../Resources/fly/images/avatar/' + obj.Result.pic,
            experience: obj.Result.experience,
            sex: '男',
            auth: obj.Result.auth
        };
    }
    else {
        layui.cache.user = {
            username: '游客',
            uid: -1,
            avatar: '../Resources/fly/images/avatar/00.jpg',
            experience: 83,
            sex: '男',
            auth: 0
        };
    }

    layui.use('laytpl', function () {
        var laytpl = layui.laytpl;

        var getTpl = $("#demo").html();
        laytpl(getTpl).render(obj, function (html) {
            $("#view").html(html);
        });
    });
});