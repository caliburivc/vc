// JavaScript Document
var preClassName = "man_nav_1";
var aClassName = "a_nav_1";
function list_sub_nav(Id){
   if(preClassName != ""){
	   document.getElementById(preClassName).className="nav-top-item";
   }
   if(document.getElementById(Id).className == "nav-top-item"){
	   document.getElementById(Id).className="nav-top-item current";
	   preClassName = Id;
   }
}
function a_sub_nav(Id){
   if(aClassName != ""){
	   document.getElementById(aClassName).className="";
   }
   if(document.getElementById(Id).className == ""){
	   document.getElementById(Id).className="current";
	   aClassName = Id;
   }
}
function to(url){
		window.location.href=url;
}
function back(){
	history.go(-1);
}
function save(prop,url){
	alert(prop+'成功！');
	to(url);
}
function del(msg){
	if (window.confirm("确认删除"+msg+"？")){
		
	}
}


