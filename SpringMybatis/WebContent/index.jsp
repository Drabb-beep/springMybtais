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
        <div class="layui-card-header"><div class="layui-form-item">
    	<div class="layui-inline">
      		<div class="layui-input-inline">
       		 <input type="text" id="name" name="name" placeholder="请输入关键字或姓名" " class="layui-input">
      	</div>
   		 </div>
    	<div class="layui-inline">
      		<div class="layui-input-inline">
        	<button class="layui-btn" onclick="queryUser()">搜索</button>
     	 </div>
     	 <div class="layui-inline">
      		<div class="layui-input-inline">
        	<a class='layui-btn layui-btn-xs'  href="insert.html">添加</a>
     	 </div>
    </div></div>
        <div class="layui-card-body">
        <table class="layui-table " id="test" border="" cellspacing="" cellpadding="">
	<thead>
		<tr>
			<td>id</td>
			<td>姓名</td>
			<td>密码</td>
			<td>操作</td>
		</tr>
		</thead>
		<tbody id="list"></tbody>
		</table>
</table>
</div>
      </div>
	
  </div>

<script src="js/jquery3.5.1.js">
</script>
<script type="text/javascript">
window.onload = function(){
 	$.ajax({
	        type:"get",
	        url:"list.do",
	        data:{}, 
	        dataType: "json",
	        contentType: "application/json; charset=utf-8",
	        success:function(data) {
		var list=data;
		var len=data.length;
		var str="";
	         for(i=0;i<len;i++){
				id=list[i].id;  
				name=list[i].name;
				password=list[i].password;
				num=list[i].num;
				str+="<tr><td>"
							+id+
					"</td><td>"+
							name+
					"</td><td>"+
							password+
					"</td><td>"+
							"<a class='layui-btn layui-btn-xs' lay-event='edit' href='update?num="+num+"'>编辑</a><a onclick=\"return confirm('是否确定删除当前用户吗？')\"  class='layui-btn layui-btn-danger layui-btn-xs' lay-event='del' href='deleteUser?num="+num+
					"'>删除</a></td></tr>";
		
	}
				$("#list").html(str);
	        },
	         error: function(){
	            alert('error');
	        } 
	      
	    });
}
function queryUser(){
	var n=$("#name").val();
	$.ajax({
		        type:"get",
		        url:"queryUser",
		        data:{name:n}, 
		        dataType: "json",
		        contentType: "application/json; charset=utf-8",
		        success:function(data) {
			var list=data;
			var len=data.length;
			var str="";
		         for(i=0;i<len;i++){
					id=list[i].id;  
					name=list[i].name;
					password=list[i].password;
					num=list[i].num;
					str+="<tr><td>"
						+id+
				"</td><td>"+
						name+
				"</td><td>"+
						password+
				"</td><td>"+
						"<a class='layui-btn layui-btn-xs' lay-event='edit' href='update?num="+num+"'>编辑</a><a onclick=\"return confirm('是否确定删除当前用户吗？')\"  class='layui-btn layui-btn-danger layui-btn-xs' lay-event='del' href='deleteUser?num="+num+
				"'>删除</a></td></tr>";
			
		}
					$("#list").html(str);
		        },
		         error: function(){
		            alert('error');
		        }
		      
		    });
	
}
</script>
</body>
</html>