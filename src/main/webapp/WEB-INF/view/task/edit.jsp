<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />

  <title>AI+ 主题模板</title>

  <link rel="stylesheet" type="text/css" href="${base}/static/css/base.css">
  <link rel="stylesheet" type="text/css" href="${base}/static/css/font.min.css">
  <script type="text/javascript" src="${base}/static/js/jquery.min.js"></script>
  <script type="text/javascript" src="${base}/static/js/jquery.aiui.js"></script>

</head>
<body>
<div class="I-con">
  <div class="I-row">
    <div class="I-nav">
      <li><a class="on" href="javascript:;">任务</a></li>
    </div>
    <form class="J_form" method="post" action="/task/save">
      <input name="id" value="${task.id}" type="hidden">
      <div class="F-item">
        <div class="F-txt">任务名称</div>
        <div class="F-con">
          <div class="F-row">
            <div class="I-4"><input class="input-t" id="curl" name="taskName" type="text" value="${task.taskName}"></div>
          </div>
        </div>
      </div>
      <div class="F-item">
        <div class="F-txt">项目</div>
        <div class="F-con">
          <div class="F-row">
            <div class="J_select">
              <select name="projectId" class="input-t" >
                <option value="">请选择</option>
                <c:forEach items="${projectList}" var="item">
                  <option value="${item.id}" ${item.id == task.projectId ? "selected" :""}>${item.title}</option>
                </c:forEach>
              </select>
            </div>
          </div>
        </div>
      </div>
      <div class="F-item">
        <div class="F-txt">负责人</div>
        <div class="F-con">
          <div class="F-row">
            <div class="J_select">
              <select name="userId" class="input-t" >
                <option value="">请选择</option>
                <c:forEach items="${userList}" var="item">
                  <option value="${item.id}" ${item.id == task.userId ? "selected" :""}>${item.realName}</option>
                </c:forEach>
              </select>
            </div>
          </div>
        </div>
      </div>
      <div class="F-item">
        <div class="F-txt">任务说明</div>
        <div class="F-con">
          <div class="F-row">
            <div class="I-8"><textarea rows="4" cols="20" name="description">${task.description}</textarea></div>
          </div>
        </div>
      </div>
      <div class="F-submit">
        <button class="btn btn-submit" type="submit">提交</button>
      </div>
    </form>
  </div>
</div>
<script type="text/javascript" src="${base}/static/js/editor/zh_cn.js"></script>
<script type="text/javascript" src="${base}/static/js/date/date.js"></script>
</body>
</html>