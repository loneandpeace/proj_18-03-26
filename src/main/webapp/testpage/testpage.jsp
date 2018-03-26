<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script>
		function _onload(){
			var parent=document.getElementsByTagName("body")[0];
			var script=document.createElement("script");
			script.src="http://localhost:8080/homework_sp/ResAllCartJSON?pageNo=1";
			script.type="text/javascript";
			parent.appendChild(script);
		}
		function _show(pageModel){
			
			var parent=document.getElementsByTagName("body")[0];
			var table=document.createElement("table");
			
			parent.appendChild(table);
			
			do{
				var table_tr=document.createElement("tr");
				var table_td1=document.createElement("td");
				var td1=document.createTextNode("id");
				table_td1.appendChild(td1);
				table_tr.appendChild(table_td1);
				var table_td2=document.createElement("td");
				var td2=document.createTextNode("用户名");
				table_td2.appendChild(td2);
				table_tr.appendChild(table_td2);
				var table_td3=document.createElement("td");
				var td3=document.createTextNode("商品名");
				table_td3.appendChild(td3);
				table_tr.appendChild(table_td3);
				var table_td4=document.createElement("td");
				var td4=document.createTextNode("数量");
				table_td4.appendChild(td4);
				table_tr.appendChild(table_td4);
				var table_td5=document.createElement("td");
				var td5=document.createTextNode("状态");
				table_td5.appendChild(td5);
				table_tr.appendChild(table_td5);
				var table_td6=document.createElement("td");
				var td6=document.createTextNode("更新时间");
				table_td6.appendChild(td6);
				table_tr.appendChild(table_td6);
				var table_td7=document.createElement("td");
				var td7=document.createTextNode("创建时间");
				table_td7.appendChild(td7);
				table_tr.appendChild(table_td7);
				
				table.appendChild(table_tr);
				
			}while(false);
			
			
			for(var i=0;i<pageModel.data.length;i++){
				var table_tr=document.createElement("tr");
				var cart=pageModel.data[i];
				
				var table_td1=document.createElement("td");
				var td1=document.createTextNode(cart.id);
				table_td1.appendChild(td1);
				table_tr.appendChild(table_td1);
				var table_td2=document.createElement("td");
				var td2=document.createTextNode(cart.user.username);
				table_td2.appendChild(td2);
				table_tr.appendChild(table_td2);
				var table_td3=document.createElement("td");
				var td3=document.createTextNode(cart.product.name);
				table_td3.appendChild(td3);
				table_tr.appendChild(table_td3);
				var table_td4=document.createElement("td");
				var td4=document.createTextNode(cart.quantity);
				table_td4.appendChild(td4);
				table_tr.appendChild(table_td4);
				var table_td5=document.createElement("td");
				var td5=document.createTextNode(cart.checked);
				table_td5.appendChild(td5);
				table_tr.appendChild(table_td5);
				var table_td6=document.createElement("td");
				var td6=document.createTextNode(cart.front_update_time);
				table_td6.appendChild(td6);
				table_tr.appendChild(table_td6);
				var table_td7=document.createElement("td");
				var td7=document.createTextNode(cart.front_create_time);
				table_td7.appendChild(td7);
				table_tr.appendChild(table_td7);
				
				table.appendChild(table_tr);
				
			}
			
			for(var i=1;i<=pageModel.totalCount;i++){
				var a=document.createElement("button");
				var no=i;
				a.onclick="_onclick('1321355')";
				a.innerHTML=i;
				parent.appendChild(a);
			}
			
		}
		
		function _onclick(i){
			alert(i);
			/*var parent=document.getElementsByTagName("body")[0];
			var script=document.createElement("script");
			script.src="http://localhost:8080/homework_sp/ResAllCartJSON?pageNo=2";
			script.type="text/javascript";
			parent.appendChild(script);*/
		}
		
	</script>
</head>
<body onload="_onload()">
	
</body>
</html>