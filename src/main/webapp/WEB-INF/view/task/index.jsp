<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp"/>

  <title>任务管理</title>

  <link rel="stylesheet" type="text/css" href="${base}/static/css/base.css">
  <link rel="stylesheet" type="text/css" href="${base}/static/css/font.min.css">
  <script type="text/javascript" src="${base}/static/js/jquery.min.js"></script>
  <script type="text/javascript" src="/static/js/jquery.aiui.js"></script>
</head>
<body>
<div class="I-con">
  <div class="I-row">
    <div class="I-nav">
      <li>
        <a class="on" href="/task/index">任务列表</a>
      </li>
      <dl>

      </dl>
    </div>
    <div class="box-filter">
      <div class="I-2 fr" style="text-align: right;">
        <a class="btn btn-add" href="/task/add"><i class="icon ai-edit"></i>增加任务</a>
      </div>
      <div class="I-4 fl">
        <form class="J_form" name="" method="post">

          <div class="input-btn">
            <input name="key" type="text" placeholder="请输入关键词" value="${key}">
            <label>
              <button class="J_copy" type="submit">
                <i class="icon ai-search"></i>搜索
              </button>
            </label>
          </div>
        </form>
      </div>
    </div>
    <div class="I-table">
      <table>
        <thead>
        <tr class="tr-center">
          <th width="20%">任务</th>
          <th width="20%">项目</th>
          <th width="10%">负责人</th>
          <th width="10%">进度</th>
          <th width="25%">说明</th>
          <th width="15%">操作</th>
        </tr>
        </thead>
        <tbody id="id">
        <c:forEach var="item" items="${taskList}">
          <tr>
            <td>${item.taskName}</td>
            <td>${item.projectId}</td>
            <td>${item.userId}</td>
            <td>${item.progress}</td>
            <td>${item.description}</td>
            <td>
              <a class="btn btn-info" href='/task/edit/${item.id}'><i class="icon ai-edit"></i> 编辑</a>
              <a class="btn" href='/task/remove/${item.id}'><i class="icon ai-delete"></i>删除</a>
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>

  </div>
</div>
</div>
</body>
</html>