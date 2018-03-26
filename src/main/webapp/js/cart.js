/**
 * 
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
	var parent=document.getElementsByTagName("body")[0];
	var script=document.createElement("script");
	script.src="http://localhost:8080/homework_sp/forpage/ResAllCartJSON?opType=6&id="+id+"&quantity="+quantity;
	script.type="text/javascript";
	//removeTable();
	parent.appendChild(script);
}
////////////////////////////////////
function _show(pageModel){
	
	//alert(JSON.stringify(pageModel));
	
	var parent=document.getElementById("print");
	var table=document.createElement("table");
	var tr=document.createElement("tr");
	table.id="tttable";
	
	//表头
	var top_guid=new Array("","商品名称","数量","状态","创建时间","更新时间","操作");
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
		checkbox_input.style.marginTop="30%";
		checkbox_input.style.marginLeft="40%";
		checkbox_input.type="checkbox";
		////////////////////////////////////////////////////////////
		if(cart.checked==1){
			checkbox_input.value="1";
			checkbox_input.checked=true;
		}else{
			checkbox_input.value="0";
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
				cart.checked,cart.front_create_time,cart.front_update_time);
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
		//a1.href="";
		a1.onclick=function(){
			var cartid=cart.id;
			return function() {
				deleteCart(cartid);
			}
		}();
		href_td.appendChild(a1);
		table_tr2.appendChild(href_td);
		
		table.appendChild(table_tr2);
	}
	parent.appendChild(table);
	
}


function removeTable(){
	var parent=document.getElementById("print");
	var div=document.getElementById("tttable"); 
	if(div!=null){
		parent.removeChild(div);
	}
}


function deleteCart(id) {
	console.log("delete"+id);
	var parent=document.getElementsByTagName("body")[0];
	var script=document.createElement("script");
	script.src="http://localhost:8080/homework_sp/forpage/ResAllCartJSON?opType=0&id="+id;
	script.type="text/javascript";
	//removeTable();
	parent.appendChild(script);
}
function selectAll() {
	var parent=document.getElementsByTagName("body")[0];
	var script=document.createElement("script");
	script.src="http://localhost:8080/homework_sp/forpage/ResAllCartJSON?pageNo=1&opType=3";
	script.type="text/javascript";
	//removeTable();
	parent.appendChild(script);
}
function unselectAll() {
	var parent=document.getElementsByTagName("body")[0];
	var script=document.createElement("script");
	script.src="http://localhost:8080/homework_sp/forpage/ResAllCartJSON?pageNo=1&opType=4";
	script.type="text/javascript";
	//removeTable();
	parent.appendChild(script);
}