<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加部门</title>
</head>
<body>
	<form action="add.html" method="post">
		<table>
			<tr>
				<td>部门名称</td>
				<td>
					<!-- <input type="text" name="depart_name"/> --> <select
					class="combobox" name="depart_name">
						<!-- <option></option>
						<option value="PA">Pennsylvania</option>
						<option value="CT">Connecticut</option>
						<option value="NY">New York</option>
						<option value="MD">Maryland</option>
						<option value="VA">Virginia</option> -->
				</select>
				</td>
				<td>职务名称</td>
				<td>
					<!-- <input type="text" name="post_name"/> --> <select
					class="combobox" name="post_name" id="main_id">
						<option></option>
						<option value="PA">Pennsylvania</option>
						<option value="CT">Connecticut</option>
						<option value="NY">New York</option>
						<option value="MD">Maryland</option>
						<option value="VA">Virginia</option>
				</select>
				</td>
				<td><input type="submit" value="确认" /></td>
			</tr>
		</table>
	</form>
<script type="text/javascript">
	/* $("select[name=depart_name]").empty();
		var cType = '${sessionScope.taxDedPeopleT.credentialType }';
		//下拉数据加载
		$.ajax({
			type:"POST",                         //post请求
   			url:"${ctx}/people/getCtType",       //请求后台action 根据需求请求自己的后台数据
    		data:{"lookup_type":'CredentialType',
		  		"order":'asc',
		  		"lookupValuesCode":''}, 		//传到后台的参数
    		dataType:"json",                     //预期服务器返回的数据类型
    		error:function(){                    //ajax错误的方法
   			},
			success : function(data) {//返回list数据并循环获取
				var optionString;
        		var beanList = data;            //返回的json数据
        		if(beanList){                   //判断
        			for (var key in beanList){
        				// 给身份证类型赋值
            			if(key=='ct'){
            				optionString='';
            				optionString +="<option value=\"\" >--请选择--</option>";  
            				for(var i=0; i<beanList[key].length; i++){ //遍历，动态赋值
                				if(beanList[key][i].id == cType){
                					optionString +="<option value=\""+beanList[key][i].id+"\" selected = \"selected\"";  
                        			optionString += ">"+beanList[key][i].text+"</option>";  
                				}else{
	                    			optionString +="<option value=\""+beanList[key][i].id+"\"";  
	                   				 optionString += ">"+beanList[key][i].text+"</option>";  
                				}
            				}
            			}
        			}
        		}
			},
		});
            $("select[name=credentialType]").append(optionString);  //  */
            /* $(function(){
                $.ajax({
                  type:'post',
                  url:"/ getDepartname",
                  dataType:"json",
                  data:{pid:0},
                  success:function(data){
                    // console.log(data);
                    $("#main_id").empty();
                    $("#main_id").append("<option value=''>请选择主类</option>");
                    for(var i=0;i<data.length;i++){
                      $("#main_id").append('<option value='+data[i].id+'>'+data[i].class_name+'</option>');
                    }
                 }
             }); */
        

</script>
<!-- <script type="text/javascript">
$(function(){
	var str="";
	$.ajax({
		url:"../get/users.html",
		type:"get",
		dataType:"json",
		success:function(obj){
			alert(obj);
			$(obj).each(function(i,e){
				if(obj[i].nhead==null || obj[i].nhead==""){
					obj[i].nhead="默认头像.png";
				}
				//</td><td><img alt=\"头像\" src=\"../../upload/+"obj[i].nhead"+\"/>
				str+="<tr><td>"+obj[i].id+"</td><td>"
				+"<img alt=\"头像\" src=\"../../upload/"+obj[i].nhead+"\"/></td><td>"
				+obj[i].username+"</td><td>"
				+obj[i].password+"</td><td>"
				+obj[i].address+"</td><td>"
				+"<a href=\"../get/user/"+obj[i].id+".html\">详情</a>"
				+"&nbsp;<a href=\"../delete/user/"+obj[i].id+".html\">删除</a></td></tr>";
			}); 
			$("tr:first").after(str);
		},
		error:function(e){				
			alert("ajax请求失败");
		},
	});
});
	
</script> -->
</body>
</html>