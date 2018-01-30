<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>

    <title>管理系统</title>

    <link rel="stylesheet" type="text/css" href="${base}/static/css/ai.css">
    <link rel="stylesheet" type="text/css" href="${base}/static/css/font.min.css">
    <script type="text/javascript" src="${base}/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="${base}/static/js/jquery.tab.js"></script>
</head>
<body style="overflow:hidden">
<div class="header">
    <div class="user">
        <div class="user-con">
            <div class="user-img"><img src="static/img/a1.jpg"></div>
            <div class="user-info">
                <span>管理员</span>
                <span>超级管理员</span>
                <span><a href="/logout"><span>退出</span></a></span>
            </div>
        </div>
    </div>
    <div class="con">
        <div class="menu">
            <div class="menu-con">
                <li class="no">
                    <a class="J_menu" href="javascript:;" data-id="1"><i class="icon ai-home"></i><span>首页</span></a>
                </li>
                <li>
                    <a class="J_menu" href="javascript:;" data-id="2"><i class="icon ai-users"></i><span>会员管理</span></a>
                </li>
                <li>
                    <a class="J_menu" href="javascript:;" data-id="3"><i class="icon ai-set"></i><span>系统管理</span></a>
                </li>
                <li>
                    <a class="J_menu" href="javascript:;" data-id="4"><i class="icon ai-set"></i><span>任务管理</span></a>
                </li>

            </div>
        </div>
        <div class="tab">
            <a class="tab-btn J_Left"><i class="icon ai-rew-left"></i></a>
            <div class="J_Tabs">
                <div class="page-con">
                    <a class="no J_Tab" href="javascript:;" data-url="set/home.html">首页</a>
                </div>
            </div>
            <a class="tab-btn J_Right"><i class="icon ai-rew-right"></i></a>
            <a class="tab-btn J_Home" href="/" target="_blank"><i class="icon ai-home"></i></a>
        </div>
    </div>
</div>
<ul class="J_nav">
    <li data-id="1">
        <dl class="J_fold">
            <h1><i class="icon ai-user"></i><span>个人中心</span><em class="more"></em></h1>
            <dd>
                <a class="J_Item" href="javascript:;" data-url="set/clear.html">清理缓存</a>
                <a class="J_Item" href="javascript:;" data-url="user/paw.html">修改密码</a>
            </dd>
        </dl>
        <dl class="J_fold">
            <h1><i class="icon ai-i"></i><span>模板帮助</span><em class="more"></em></h1>
            <dd>
                <a class="J_Item" href="javascript:;" data-url="i/icon.html">图标</a>
                <a class="J_Item" href="javascript:;" data-url="i/btn.html">按钮</a>
                <a class="J_Item" href="javascript:;" data-url="i/form.html">表单</a>
                <a class="J_Item" href="javascript:;" data-url="i/table.html">表格</a>
                <a class="J_Item" href="javascript:;" data-url="i/sku.html">SKU</a>
            </dd>
        </dl>
    </li>
    <li style="display:none" data-id="2">
        <dl class="J_fold">
            <h1><i class="icon ai-users"></i><span>用户管理</span><em class="more"></em></h1>
            <dd>
                <a class="J_Item" href="javascript:;" data-url="user/user.html">会员列表</a>
                <a class="J_Item" href="javascript:;" data-url="user/vip.html">VIP设置</a>
            </dd>
        </dl>
    </li>
    <li style="display:none" data-id="3">
        <dl class="J_fold">
            <h1><i class="icon ai-set"></i><span>系统管理</span><em class="more"></em></h1>
            <dd>
                <a class="J_Item" href="javascript:;" data-url="set/set.html">系统设置</a>
                <a class="J_Item" href="javascript:;" data-url="nav/nav.html">节点管理</a>
            </dd>
        </dl>
    </li>
    <li style="display:none" data-id="4">
        <dl class="J_fold">
            <h1><i class="icon ai-set"></i><span>任务管理</span><em class="more"></em></h1>
            <dd>
                <a class="J_Item" href="javascript:;" data-url="/project/index">项目管理</a>
                <a class="J_Item" href="javascript:;" data-url="/task/index">任务管理</a>
                <a class="J_Item" href="javascript:;" data-url="nav/nav.html">进度管理</a>
            </dd>
        </dl>
    </li>
</ul>
<div class="J_main">
    <iframe class="J_iframe" src="set/home.html" data-url="set/home.html"></iframe>
</div>
<div class="footer">
    <div class="copy"></div>
</div>
<ul class="J_click">
    <li><a href="javascript:;">取消操作</a></li>
    <li><a href="javascript:;" data-event="fresh">重新加载</a></li>
    <li><a href="javascript:;" data-event="other">关闭其它</a></li>
    <li><a href="javascript:;" data-event="all">全部关闭</a></li>
</ul>
</body>
</html>