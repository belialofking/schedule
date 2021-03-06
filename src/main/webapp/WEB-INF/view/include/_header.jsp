<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>

<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="Bookmark" href="favicon.ico">
    <link rel="Shortcut Icon" href="favicon.ico" />
    <link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="static/lib/hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/blue/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
    <!--/meta 作为公共模版分离出去-->

    <title>后台管理</title>
</head>

<body>
    <!--_header 作为公共模版分离出去-->
    <header class="navbar-wrapper">
        <div class="navbar navbar-fixed-top">
            <div class="container-fluid cl">
                <a class="logo navbar-logo f-l mr-10 hidden-xs" href="/aboutHui.shtml">后台管理</a>
                <nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
                    <ul class="cl">
                        <li>超级管理员</li>
                        <li class="dropDown dropDown_hover">
                            <a href="#" class="dropDown_A">admin
                                <i class="Hui-iconfont">&#xe6d5;</i>
                            </a>
                            <ul class="dropDown-menu menu radius box-shadow">
                                <li>
                                    <a href="javascript:;" onClick="myselfinfo()">个人信息</a>
                                </li>
                                <li>
                                    <a href="#">切换账户</a>
                                </li>
                                <li>
                                    <a href="${base}/logout">退出</a>
                                </li>
                            </ul>
                        </li>
                        <li id="Hui-msg">
                            <a href="#" title="消息">
                                <span class="badge badge-danger">1</span>
                                <i class="Hui-iconfont" style="font-size:18px">&#xe68a;</i>
                            </a>
                        </li>
                        <li id="Hui-skin" class="dropDown right dropDown_hover">
                            <a href="javascript:;" class="dropDown_A" title="换肤">
                                <i class="Hui-iconfont" style="font-size:18px">&#xe62a;</i>
                            </a>
                            <ul class="dropDown-menu menu radius box-shadow">
                                <li>
                                    <a href="javascript:;" data-val="blue" title="默认（蓝色)">默认（蓝色)</a>
                                </li>
                                <li>
                                    <a href="javascript:;" data-val="black" title="黑色">黑色</a>
                                </li>
                                <li>
                                    <a href="javascript:;" data-val="green" title="绿色">绿色</a>
                                </li>
                                <li>
                                    <a href="javascript:;" data-val="red" title="红色">红色</a>
                                </li>
                                <li>
                                    <a href="javascript:;" data-val="yellow" title="黄色">黄色</a>
                                </li>
                                <li>
                                    <a href="javascript:;" data-val="orange" title="橙色">橙色</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    </header>
    <!--/_header 作为公共模版分离出去-->