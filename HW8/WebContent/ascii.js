"use strict";
/*
Author: Duong Kha Nguyen
Student ID: 611952
Description: ascii.js implements all logics for ASCII animation.
*/
var fontSizes =
[{
    "text"  : "Tiny",
    "value" : "7pt"
  },
  {
    "text"     : "Small",
    "value"    : "10pt"
  },
  {
    "text"  : "Medium",
    "value" : "12pt",
    "selected" : true
  },
  {
    "text"  : "Large",
    "value" : "16pt"
  },
  {
    "text"  : "Extra Large",
    "value" : "24pt"
  },
  {
    "text"  : "XXL",
    "value" : "32pt"
  },

];

var animations = [
	{
	    "text"  : "Blank",
	    "value" : "BLANK",
    	"selected" : true
  	},
	{
	    "text"  : "Exercise",
	    "value" : "EXERCISE"
  	},
	{
	    "text"  : "Juggler",
	    "value" : "JUGGLER"
  	},
	{
	    "text"  : "BIKE",
	    "value" : "BIKE"
  	},
	{
	    "text"  : "Dive",
	    "value" : "DIVE"
  	},
	{
	    "text"  : "Custom",
	    "value" : "CUSTOM"
  	}
];

const SPEED = 250;
var speed = SPEED;
var playing = false;
var myVar;
var currentAnimation = "BLANK";
var currentFontSize;
var frames;
window.onload = function(){
	init();
	document.getElementById("btnStart").onclick = onStart;
	document.getElementById("btnStop").onclick = onStop;
	document.getElementById("chkTurbo").onchange = onTurboChanged;
	document.getElementById("animationSelect").onchange = onAnimationChanged;
	document.getElementById("fontSelect").onchange = onFontSizeChanged;
	currentFontSize = document.getElementById("fontSelect").value;
	currentAnimation = document.getElementById("animationSelect").value;
	onFontSizeChanged();
	onStateChanged();
	onStateChanged();
}

function init(){
	var fontSelect = document.getElementById('fontSelect');

	for(let i = 0, l = fontSizes.length; i < l; i++){
	  let option = fontSizes[i];
	  fontSelect.options.add( new Option(option.text, option.value, option.selected) );
	}
	
	var animationSelect = document.getElementById('animationSelect');

	for(let i = 0, l = animations.length; i < l; i++){
	  let option = animations[i];
	  animationSelect.options.add( new Option(option.text, option.value, option.selected) );
	}
}

function onTurboChanged(){
	var ele = document.getElementById("chkTurbo");
	if(ele.checked)
		speed = 50;
	else
		speed = SPEED;	
}

function onStateChanged(){
	var btnStart = document.getElementById("btnStart");
	var btnStop = document.getElementById("btnStop");
	var selectAnination = document.getElementById("animationSelect");
	btnStart.disabled = playing;
	btnStop.disabled = !playing;
	selectAnination.disabled = playing;
}
function onAnimationChanged(){
	currentAnimation = document.getElementById("animationSelect").value;
	let animationStr = ANIMATIONS[currentAnimation];
	var ele = document.getElementById("animationtext");
	if(animationStr !== ""){
		frames = animationStr.split("=====\n");
		var frame = frames[0];
		ele.value = frame;
	}
	else
	{
		ele.value = "";
	}
}
function onFontSizeChanged(){
	currentFontSize = document.getElementById("fontSelect").value;
	var ele = document.getElementById("animationtext");
	ele.style.fontSize = currentFontSize;
}
function onStart(){
	playing = true;
	onStateChanged();
	if(frames.length > 0){
		play(frames)();
	}
}
function onStop(){
	playing = false;
	clearTimeout(myVar);
	onStateChanged();
}
function play(frames){
	var index = 0;
	function animate(){
		var frame = frames[index];
		var ele = document.getElementById("animationtext");
		ele.value = frame;
		index++;
		if(index >= frames.length){
			index = 0;
		}
		myVar = setTimeout(animate,speed);
	}
	
	return animate;
	
}