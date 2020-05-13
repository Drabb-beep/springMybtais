<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Layui</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="css/layui.css"  media="all">
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<div class="layui-card">
        <div class="layui-card-header">编辑用户</div>
        <div class="layui-card-body">
     
<form class="layui-form" action="update" method="post" onSubmit="return inputNull(this)">
  <div class="layui-form-item">
    <label class="layui-form-label">用户id</label>
    <div class="layui-input-block">
      <input type="text" name="id" placeholder="id" class="layui-input" value="<%=request.getAttribute("id")%>" disabled>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">用户名</label>
    <div class="layui-input-block">
      <input type="text" name="name" lay-verify="required" lay-reqtext="用户名是必填项，岂能为空？" placeholder="用户名" autocomplete="off" class="layui-input" value="<%=request.getAttribute("name")%>">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">密码</label>
    <div class="layui-input-block">
      <input type="text" name="password" lay-verify="required" lay-reqtext="密码是必填项，岂能为空？" placeholder="密码" autocomplete="off" class="layui-input" value="<%=request.getAttribute("password")%>">
    </div>
  </div>
  <div class="layui-form-item">
    <button class="layui-btn" type="submit">提交</button>
  </div>
</form>
          </div>
       </div> 
<script src="js/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
layui.use(['form'], function(){
  var form = layui.form;
 })
</script>
<script>
layui.use(['form'], function(){
  var form = layui.form;
 })
</script>
<script type="text/javascript">
  		function inputNull(form){
			for(i=0;i<form.length-1;i++){
                    //form属性的elements的首字母e要小写
				if(form.elements[i].value == ""){ 
					alert(form.elements[i].placeholder + "不能为空");
					form.elements[i].focus();	
					return false;
				}
			}
  	  	}
  	</script>
</body>
</html>