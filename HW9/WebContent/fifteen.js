/**
 * 
 */
"use strict";
$(document).ready(function(){
	var tiles = [];
	var positions = [];
	positions = loadPositions();
		
	$('#puzzlearea div').each(function(idx,e){
		var x = ((idx % 4) * 100) ;
        var y = (Math.floor(idx / 4) * 100) ;
		$(e).addClass("puzzlepiece");
		$(this).addClass("movablepiece");
		$(e).attr("id","quare_" + (idx % 4) + "_" + Math.floor(idx / 4));
		$(e).css({
			left: x + 'px',
			top : y + 'px',
			'backgroundImage':'url("background.jpg")',
			'backgroundPosition':-x + 'px ' + (-y) + 'px'
		});
		var position =  getPosition(idx % 4,Math.floor(idx / 4));
		position.free = false;
		var tile = new Tile(position.x, position.y,idx);
		tiles.push(tile);
	});
	
	function Tile(x,y,num){
		this.x = x;
		this.y = y;
		this.num = num;
	};
	
	function Position(x, y, free) {
		this.x = x;
		this.y = y;
		this.free = free;
	}
	
	function loadPositions() {
		var positions = [];
		for ( var i = 0; i < 4; i++) {
			for ( var j = 0; j < 4; j++) {
				positions.push(new Position(i, j, true));
			}
		}
		return positions;
	}
	
	function getRandomFreePosition(positions) {
		for(var i = 0; i < positions.length;i++){
			var position = positions[i];
			if(position.free == true)
				return position;
		}
	}
	
	function getPosition(x, y) {
		for ( var i = 0; i < positions.length; i++) {
			if (positions[i].x == x && positions[i].y == y) {
				return positions[i];
			}
		}
	}
	
	function getTileInPosition(x, y){
		for(var i = 0; i < tiles.length; i++){
			if(tiles[i].x == x && tiles[i].y == y){
				return tiles[i];
			}
		}
		return null;
	}

	function getFreePositionNearTile(tile) {
		var positionTmp = null;
		if (tile.y > 0) {
			positionTmp = getPosition(tile.x, tile.y - 1);
			if (positionTmp.free == true) {
				return positionTmp;
			}
		}
		if (tile.y < 3) {
			positionTmp = getPosition(tile.x, tile.y + 1);
			if (positionTmp.free == true) {
				return positionTmp;
			}
		}
		if (tile.x > 0) {
			positionTmp = getPosition(tile.x - 1, tile.y);
			if (positionTmp.free == true) {
				return positionTmp;
			}
		}
		if (tile.x < 3) {
			positionTmp = getPosition(tile.x + 1, tile.y);
			if (positionTmp.free == true) {
				return positionTmp;
			}
		}
		return null;
	}
	
	$("#shufflebutton").click(function(){
		shuffle();
	});
	
	function moveRandomTile(position){
		if(position.free){
			//x-1,y-1,x+1,y+1
			var array = [];
			array.push({"x":position.x -1,"y":position.y});
			array.push({"x":position.x +1,"y":position.y});
			array.push({"x":position.x,"y":position.y-1});
			array.push({"x":position.x,"y":position.y + 1});
			var tile = null;
			while(tile == null){
				var index = Math.floor(Math.random() * array.length);
				var pos = array[index];
				tile = getTileInPosition(pos.x,pos.y);
				if(tile){
					break;
				}
			}
			move(tile,position,$("#quare_" + tile.x + "_" + tile.y));
		}
	}
	
	function won(){
		for(var i = 0;i<tiles.length;i++){
			if(tiles[i].num != i)
				return false;
		}
		return true;
	}
	
	function shuffle(){
		var position = null;
		for(var i = 0; i < 16; i ++){
			position = getRandomFreePosition(positions);
			moveRandomTile(position);
		}
	}
	
	function move(tile,newPos,e){
		var x = (newPos.x * 100) ;
        var y = (newPos.y * 100) ;
		e.attr("id","quare_" + newPos.x + "_" + newPos.y);
		e.css({
			left: x + 'px',
			top : y + 'px'
		});
		var oldPos = getPosition(tile.x,tile.y);
		newPos.free = false;
		tile.x = newPos.x;
		tile.y = newPos.y;
		tile.num = tile.y*4 + tile.x;
		oldPos.free = true;
	}
	
	$(".puzzlepiece").click(function(){
		var id = $(this).attr("id");
		var arr = id.split("_");
		var tile = getTileInPosition(arr[1],arr[2]);
		var newPos = getFreePositionNearTile(tile);	
		
		if(newPos){
			move(tile,newPos,$(this));
			if(won())
				alert("You won!");
		}
	});
	
	$(".puzzlepiece").mouseover(function(){
		var id = $(this).attr("id");
		var arr = id.split("_");
		var tile = getTileInPosition(arr[1],arr[2]);
		var newPos = getFreePositionNearTile(tile);	
		if(newPos){
			$(this).addClass("movablepiece");
			$(this).hover();
		}
		
	});
	
	$(".puzzlepiece").mouseleave(function(){
		$(this).removeClass(".movablepiece");
	});
});
	