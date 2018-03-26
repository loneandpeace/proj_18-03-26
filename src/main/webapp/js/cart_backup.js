/**
 * 购物车
 */
window.onload=function(){
	
	var parent=document.getElementsByTagName("body")[0];
	var script=document.createElement("script");
	script.src="http://localhost:8080/homework_sp/forpage/ResAllCartJSON?pageNo=1";
	script.type="text/javascript";
	parent.appendChild(script);
	
}
///////////////////////////////////
function getCount(count) {
	//alert(count);
	document.getElementById("count").innerHTML="&nbsp;数量共计：&nbsp;&nbsp;"+count+"&nbsp;件";
}
function getPrice(price) {
	document.getElementById("count").innerHTML="&nbsp;数量共计：&nbsp;&nbsp;"+count+"&nbsp;件";
}
function selectOption(input,id) {
	input.value=1-input.value;
	var parent=document.getElementsByTagName("body")[0];
	var script=document.createElement("script");
	if(input.value==1){
		script.src="http://localhost:8080/homework_sp/forpage/ResAllCartJSON?pageNo=1&opType=1&id="+id;
	}else{
		script.src="http://localhost:8080/homework_sp/forpage/ResAllCartJSON?pageNo=1&opType=2&id="+id;
	}
	script.type="text/javascript";
	//removeTable();
	parent.appendChild(script);
}
function setQuantity(id,quantity) {
	//alert(id+" "+quantity);
	var parent=document.getElementsByTagName("body")[0];
	var script=document.createElement("script");
	script.src="http://localhost:8080/homework_sp/forpage/ResAllCartJSON?opType=6&id="+id+"&quantity="+quantity;
	script.type="text/javascript";
	//removeTable();
	parent.appendChild(script);
}
function setPrice(price) {
	$("#totalPrice").text("￥"+price.toFixed(2));
}
////////////////////////////////////
function _show(info){
	if(info.errorno==0){
		alert('查询失败');
		window.location.href="http://localhost:8080/homework_sp/forpage/user/user_login.jsp";
	}
	
	var pageModel=info.pageModel;
	//alert(JSON.stringify(pageModel));
	
	var parent=document.getElementById("print");
	var table=document.createElement("table");
	var tr=document.createElement("tr");
	table.id="tttable";
	
	//表头
	var top_guid=new Array("","商品名称","数量","价格","创建时间","更新时间","操作");
	for(var k=0;k<top_guid.length;k++){//数字要改
		
		var table_td3=document.createElement("td");
		var td3=document.createTextNode(top_guid[k]);
		table_td3.appendChild(td3);
		tr.appendChild(table_td3);
	}
	//tr.id="tttr";
	table.appendChild(tr);
	
	
	//循环输出信息
	for(var i=0;i<pageModel.data.length;i++){
		var table_tr2=document.createElement("tr");
		var cart=pageModel.data[i];
		
		var checkbox_td=document.createElement("td");
		var checkbox_input=document.createElement("input");
		checkbox_input.style.marginTop="25%";
		checkbox_input.style.marginLeft="40%";
		checkbox_input.type="checkbox";
		checkbox_input.className="check";
		checkbox_input.id="checkbox_"+cart.id;
		////////////////////////////////////////////////////////////
		if(cart.checked==1){
			checkbox_input.value="1";
			checkbox_input.checked=true;
		}else{
			checkbox_input.value="0";
			checkbox_input.checked=false;
		}
		checkbox_input.onclick=function(){
			var id=cart.id;
			return function() {
				selectOption(this,id);
			}
		}();
		////////////////////////////////////////////////////////////
		checkbox_input.appendChild(checkbox_td);
		table_tr2.appendChild(checkbox_input);
		var cart_guid=new Array(cart.product.name,cart.quantity,
				cart.product.price,cart.front_create_time,cart.front_update_time);
		for(var j=0;j<cart_guid.length;j++){
			
			if(j!=1){//注意编号
				var table_td=document.createElement("td");
				var td=document.createTextNode(cart_guid[j]);
				table_td.appendChild(td);
				table_tr2.appendChild(table_td);
			}else{
				var table_td=document.createElement("td");
				var quantity_input=document.createElement("input");
				quantity_input.value=cart.quantity;
				quantity_input.id="quantity_"+cart.id;
				quantity_input.type="number";
				quantity_input.style.width="70px";
				quantity_input.onchange=function(){
					var id=cart.id;
					return function(){
						setQuantity(id,this.value);
					}
				}();
				table_td.appendChild(quantity_input);
				table_tr2.appendChild(table_td);
			}
		}
		
		var href_td=document.createElement("td");
		var a1=document.createElement("a");
		a1.innerText="删除";
		a1.href="";
		a1.onclick=function(){
			var cartid=cart.id;
			return function(e) {
				e.preventDefault();
				deleteCart(cartid);
			}
		}();
		href_td.appendChild(a1);
		table_tr2.appendChild(href_td);
		
		table.appendChild(table_tr2);
	}
	
	
	
	var guid_tr=document.createElement("tr");
	var guid_td=document.createElement("td");
	guid_td.setAttribute("colspan",7);
	guid_td.style.textAlign="center";
	for(var i=1;i<=pageModel.totalCount;i++){//pageModel.totalCount
		
		
		var a=document.createElement("a");
		a.innerHTML=i;
		a.href="";
		a.style.paddingLeft="3px";
		a.style.paddingRight="3px";
		a.style.marginLeft="3px";
		a.style.marginRight="3px";
		a.onclick=function(){
			var num=i;
			return function(e){
				//alert(JSON.stringify(e));
				e.preventDefault();
				var container=document.getElementsByTagName("body")[0];
				var pagescript=document.createElement("script");
				pagescript.src="http://localhost:8080/homework_sp/forpage/ResAllCartJSON?pageNo="+num;
				pagescript.type="text/javascript";
				//alert(pagescript.src);
				container.appendChild(pagescript);
			}
		}();
		
		guid_td.appendChild(a);
		guid_tr.appendChild(guid_td);
	}
	table.appendChild(guid_tr);
	
	parent.appendChild(table);
	//parent.appendChild(guaiDiv);
}



function removeTable(){
	var parent=document.getElementById("print");
	var div=document.getElementById("tttable"); 
	if(div!=null){
		parent.removeChild(div);
	}
}


function deleteCart(id) {
	//console.log("delete"+id);
	var parent=document.getElementsByTagName("body")[0];
	var script=document.createElement("script");
	script.src="http://localhost:8080/homework_sp/forpage/ResAllCartJSON?opType=0&id="+id;
	script.type="text/javascript";
	//removeTable();
	parent.appendChild(script);
}

function select_unselectAll(type) {
	var parent=document.getElementsByTagName("body")[0];
	var script=document.createElement("script");
	if(type==1){
		script.src="http://localhost:8080/homework_sp/forpage/ResAllCartJSON?pageNo=1&opType=3";
	}else if(type==0){
		script.src="http://localhost:8080/homework_sp/forpage/ResAllCartJSON?pageNo=1&opType=4";
	}
	script.type="text/javascript";
	//removeTable();
	parent.appendChild(script);
}
/*function select_unselectItem(type) {
	var parent=document.getElementById("body")[0];
	var script=document.createElement("script");
	if(type==1){
		script.src="http://localhost:8080/homework_sp/forpage/ResAllCartJSON?pageNo=1&opType=3";
	}else if(type==0){
		script.src="http://localhost:8080/homework_sp/forpage/ResAllCartJSON?pageNo=1&opType=4";
	}
	script.type="text/javascript";
	//removeTable();
	parent.appendChild(script);
}*/
//页面反应函数
function selectAction(errorno,check){
	if(errorno==1){
		var checkbox_array=document.getElementsByClassName("check");
		if(check==1){
			for(x in checkbox_array){
				checkbox_array[x].checked=true;
			}
		}else if(check==0){
			for(x in checkbox_array){
				checkbox_array[x].checked=false;
			}
		}
	}
}
function changeItemselectAction(errorno,check,id){
	if(errorno==1){
		var checkbox_item=document.getElementById("checkbox_"+id);
		if(check==1){
			checkbox_item.checked=true;
			checkbox_item.value=1;
		}else if(check==0){
			checkbox_item.checked=false;
			checkbox_item.value=0;
		}
	}
}
function setQuantityAction(errorno,quantity,cid,count) {
	if(errorno==1){
		var item_quantity=document.getElementById("quantity_"+cid);
		item_quantity.value=quantity;
		getCount(count);
	}
}



/*

//XMLHttpRequest

var xmlHttpRequest;

if (window.XMLHttpRequest){// code for IE7+, Firefox, Chrome, Opera, Safari[
	xmlHttpRequest=new XMLHttpRequest();
}
else{// code for IE6, IE5
	xmlHttpRequest=new ActiveXObject("Microsoft.XMLHTTP");
}

xmlHttpRequest.open("GET","地址",true);
//xmlHttpRequest.setRequestHeader("Content-type","application/x-www-form-urlencoded");
xmlHttpRequest.send();//post下："fname=Bill&lname=Gates"

xmlhttp.onreadystatechange=function(){
	if (xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
		var text=xmlhttp.responseText;
	}
}


 */