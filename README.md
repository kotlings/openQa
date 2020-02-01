本项目是基于[openauth](https://gitee.com/yubaolee/openauth.qa) 改造 ,通过Gradle管理的[Spring Boot问答社区项目](https://github.com/kotlings/openQa)
适用于Spring Boot 入门试手

目前支持完整的网页端的论坛功能，后续将支持App相关功能

webApi 为api接口部分&ensp;&ensp; webFront为网页前端

功能：

    提问、回答及采纳一个都不能少；
    上传、表情及消息提示也是不可或缺；
    设置精华、置顶及积分怎能落下；

如何运行：

    1.初始化sql脚本；
    2.将项目导入到IDEA中；
    3.修改webapi中数据库的连接信息；
    4.运行Appllication
    5.IDEA中打开webFront/index.html选择右上角的相应的浏览器打开（或者将目录路径映射到Apache && Tomcat下）
    
    
    

 如果出现Tomcat和Javax.servlet 冲突无法启动情况请将grade缓存目录下的Javax.servlet jar删除在启动
    

快速预览：

![输入图片说明](http://git.oschina.net/uploads/images/2017/0214/142742_1461ee99_362401.png "在这里输入图片标题")


