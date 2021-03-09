"use strict";
window.onload = function() {
	document.getElementById("decoratebtn").onclick = biggerFontOnclick;
	document.getElementById("chkbling").onchange = bling;
	document.getElementById("btnMalkovitch").onclick = malkovitch;
	document.getElementById("btnIgpayAtinlay").onclick = igpayAtinlay;
};
function biggerFontOnclick(){
	setInterval (biggerFont,500);
}
function biggerFont(){
	var ele = document.getElementById("text");
	var size = parseInt(window.getComputedStyle(ele).fontSize);
	ele.style.fontSize = size + 2 + "pt";
}
function bling(){
	var checked = document.getElementById("chkbling").checked;
	var style = document.getElementById("text").style;
	if(checked){
		style.fontWeight = "bold";
		style.color = "green";
		style.textDecoration = "underline";
	}
	else{
		style.fontWeight = "normal";
	}
	document.body.style.backgroundImage = "url('hundred-dollar-bill.jpg')";
}
function igpayAtinlay(){
	var vowels = ["a","o","i","y","e","u"];
	var ele = document.getElementById("text");
	var text = ele.value;
	var words = text.split(" ");
	for(var i = 0; i < words.length; i++){
		var firstChar = words[i][0];
		var index = text.indexOf(words[i] + " ");
		if(vowels.includes(firstChar)){
			text = text.substr(0,index) + words[i] + "-ay" + text.substr(index+words[i].length) ;
		}
		else{
			text = text.substring(0,index) + text.substr(index+words[i].length + 1) + " " + words[i] + "-ay";
		}
	}
	ele.value = text;
}
function malkovitch(){
	var ele = document.getElementById("text");
	var text = ele.value;
	var words = text.split(" ");
	for(var i = 0; i < words.length; i++){
		if(words[i].length >= 5){
			text = text.replace(words[i], "Malkovich");
		}
	}
	ele.value = text;
}
