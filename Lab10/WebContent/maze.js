/**
 * 
 */
"use strict";


$(document).ready(function(){
 	 var start =  $("#start");
	 var end = $("#end");
	 var maze = $("#maze");
	 var wall = $(".boundary");
	 var playing = false;

	 maze.mouseleave(function(){ 
						loss() 
					});
	
	 start.click(function(){
		  playing = true;
 		  $("#status").text("Playing...");
		  if(wall.hasClass('youlose')){
		   		wall.removeClass('youlose');
		  }
		
		  wall.mousemove(function(){ 
							loss(); 
						}); 
	 });
	
	 end.mousemove(function(){
		  if(playing == true) 
			won(); 
		  else if(playing && wall.hasClass('youlose'))  
			loss(); 
	 
	 });
	
	 function won(){
		  playing = false;
		  $("#status").text("You win");
	 }
	
	 function loss(){
		  if(playing){
		   playing = false;
		   wall.addClass('youlose');
		   $("#status").text('You lose');
		  }
	 }
});