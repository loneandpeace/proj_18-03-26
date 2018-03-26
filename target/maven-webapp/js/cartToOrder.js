/**
 * 
 */
/**
<table>
	<tr>
		<td>商品名称</td>
		<td>尺码</td>
		<td>单价</td>
		<td>数量</td>
		<td>优惠</td>
		<td>小计</td>
	</tr>
	<tr>
		<td>T恤 巴普洛夫的狗 白色</td>
		<td>S</td>
		<td>￥98.00</td>
		<td>1</td>
		<td>-</td>
		<td>￥98.00</td>
	</tr>
</table>
 * */
function _onload(){
	var parent=document.getElementById("info_continer");
	var script=document.createElement("script");
	script.src="http://localhost:8080/homework_sp/forpage/ResAllCartJSON?pageNo=1";
	script.type="text/javascript";
	parent.appendChild(script);
}
function _show(pageModel){
	//alert(JSON.stringify(pageModel.data));
	var parent=document.getElementById("info_continer");
	var table=document.createElement("table");
	table.id="ttt";
	parent.appendChild(table);
	var title_guid=new Array(/*"id","用户名",*/"商品名","数量","状态","更新时间","创建时间","操作");
	var table_tr1=document.createElement("tr");
	//输出表头
	for(var i=0;i<title_guid.length;i++){
		var table_td=document.createElement("td")
		var td=document.createTextNode(title_guid[i]);
		table_td.appendChild(td);
		table_tr1.appendChild(table_td);
	}
	table.appendChild(table_tr1);
	
	
	//循环输出信息
	for(var i=0;i<pageModel.data.length;i++){
		var table_tr2=document.createElement("tr");
		var cart=pageModel.data[i];
		
		for(var j=0;j<5;j++){//数字要改
			var cart_guid=new Array(/*cart.id,cart.user.username,*/cart.product.name,cart.quantity,
									cart.checked,cart.front_update_time,cart.front_create_time);
			var table_td=document.createElement("td");
			var td=document.createTextNode(cart_guid[j]);
			table_td.appendChild(td);
			table_tr2.appendChild(table_td);
		}
		
		///////////////////////
		//选择
		//var parent=document.getElementsByTagName("div")[0];
		var a1=document.createElement("button");
		var a2=document.createElement("button");
		
		var script1=document.createElement("script");
		script1.src="http://localhost:8080/homework_sp/forpage/ResAllCartJSON?pageNo=1&opType=1&id="+cart.id;
		script1.type="text/javascript";
		var script2=document.createElement("script");
		script2.src="http://localhost:8080/homework_sp/forpage/ResAllCartJSON?pageNo=1&opType=2&id="+cart.id;
		script2.type="text/javascript";
		
		a1.onclick=function a(){
			removeTable();
			parent.appendChild(script1);
		}
		a2.onclick=function a(){
			removeTable();
			parent.appendChild(script2);
		}
		
		a1.innerHTML="select";
		a2.innerHTML="deselect";
		var table_td_se=document.createElement("td");
		table_td_se.appendChild(a1);
		table_td_se.appendChild(a2);
		
		table_tr2.appendChild(table_td_se);
		///////////////////////////
		
		table.appendChild(table_tr2);
		
	}
	
	//分页标签
	var guid_tr=document.createElement("tr");
	for(var i=1;i<=pageModel.totalCount;i++){//pageModel.totalCount
		
		var table_td=document.createElement("td");
		var a=document.createElement("button");
		
		a.onclick=function _ok(){
			removeTable();
			
			var script=document.createElement("script");
			script.src="http://localhost:8080/homework_sp/forpage/ResAllCartJSON?pageNo="+this.innerText;
			//console.log(script.src)
			script.type="text/javascript";
			parent.appendChild(script);
			
		};
		a.innerHTML=i;
		table_td.appendChild(a);
		guid_tr.appendChild(table_td);
	}
	table.appendChild(guid_tr);
	
}

function removeTable(){
	var parent=document.getElementById("info_continer");
	var table=document.getElementById("ttt");  
	parent.removeChild(table);
}


function deleteCart() {
	var parent=document.getElementById("info_continer");
	var script=document.createElement("script");
	script.src="http://localhost:8080/homework_sp/forpage/";//地址没写完
	script.type="text/javascript";
	parent.appendChild(script);
}
function selectAll() {//ResAllCartJSON?pageNo=1&opType=1
	var parent=document.getElementById("info_continer");
	var script=document.createElement("script");
	script.src="http://localhost:8080/homework_sp/forpage/";//地址没写完
	script.type="text/javascript";
	parent.appendChild(script);
}
function unselectAll() {
	var parent=document.getElementById("info_continer");
	var script=document.createElement("script");
	script.src="http://localhost:8080/homework_sp/forpage/";//地址没写完
	script.type="text/javascript";
	parent.appendChild(script);
}