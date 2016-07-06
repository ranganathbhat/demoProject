$('#map').mousemove(function(e){
	var x = (e.clientX - $('#map').offset().left)/80;
	var y = ($('#map').height() + $('#map').offset().top - e.clientY)/80;
  $('#position').text('Position:[' + x  +','+ y +']');
});