$(function() {
	'use strict';

	var client;
	var data = [];
	var iter = 1;
	var pieData = [ {
		values : [],
		labels : [],
		marker : {
			colors : []
		},
		type : 'pie'
	} ];
	var layout = {
			height : 350,
			width : 350
		};
	function showMessage(mesg) {
		$('#messages').append(
				'<tr>' + '<td>' + mesg.from + ' ' + iter + '</td>' + '<td>'
						+ mesg.message + '</td>' + '</tr>');

		//console.log(" SVG var " + d3.select("svg"));
		//svg.selectAll("circle").data(data).enter().append('circle');
		d3.select('.chart').selectAll('svg').remove();
		var readings = mesg.message.split('/');
		var colorCode = null;
		var filledColor = '';
		
		if (readings[0] < 125 ) {
			colorCode = 4;
			filledColor = '#5DC621';
		}
		if ((readings[0] >= 125 && readings[0] <= 140)) {
			colorCode = 6;
			filledColor = '#DFDF55';

		}
		if ((readings[0] > 140)) {
			colorCode = 8;
			filledColor = '#FB7308';

		}
		console.log("Printing readongs " + readings);

		var height = 400;
		var width = 350;
		var margin = 40;

		if (!(data && data.length)) {
			data.push({
				x : 180,
				y : 150,
				c : -1,
				size : -1
			});

			data.push({
				x : 60,
				y : 60,
				c : -1,
				size : -1
			});

		}

		console.log(JSON.stringify(data));

		data.push({
			x : readings[0],
			y : readings[1],
			c : filledColor,
			size : Math.random() * 200
		});

		//	data.push({
		//    	x: Math.random() * 160,
		//        y: Math.random() * 160,
		//        c: Math.round(Math.random() * 5),
		//        size: Math.random() * 200,
		//        });

		var labelX = 'Systolic Blood Pressure';
		var labelY = 'Diastolic Blood Pressure';
		var svg = d3.select('.chart').append('svg').attr('class', 'chart')
				.attr("width", width + margin + margin).attr("height",
						height + margin + margin).append("g").attr("transform",
						"translate(" + margin + "," + margin + ")");

		var x = d3.scale.linear().domain([ d3.min(data, function(d) {
			return d.x;
		}), d3.max(data, function(d) {
			return d.x;
		}) ]).range([ 0, width ]);

		var y = d3.scale.linear().domain([ d3.min(data, function(d) {
			return d.y;
		}), d3.max(data, function(d) {
			return d.y;
		}) ]).range([ height, 0 ]);

		var scale = d3.scale.sqrt().domain([ d3.min(data, function(d) {
			return d.size;
		}), d3.max(data, function(d) {
			return d.size;
		}) ]).range([ 1, 20 ]);

		console.log("Printing scale " + scale + " " + x + " " + y);

		var opacity = d3.scale.sqrt().domain([ d3.min(data, function(d) {
			return d.size;
		}), d3.max(data, function(d) {
			return d.size;
		}) ]).range([ 1, .5 ]);

		var color = d3.scale.category10();

		var xAxis = d3.svg.axis().scale(x);
		var yAxis = d3.svg.axis().scale(y).orient("left");

		svg.append("g").attr("class", "y axis").call(yAxis).append("text")
				.attr("transform", "rotate(-90)").attr("x", 20).attr("y",
						-margin).attr("dy", ".71em")
				.style("text-anchor", "end").text(labelY);
		// x axis and label
		svg.append("g").attr("class", "x axis").attr("transform",
				"translate(0," + height + ")").call(xAxis).append("text").attr(
				"x", width + 20).attr("y", margin - 10).attr("dy", ".71em")
				.style("text-anchor", "end").text(labelX);

		svg.selectAll("circle").data(data).enter().insert("circle").attr("cx",
				width / 2).attr("cy", height / 2).attr("opacity", function(d) {
			return opacity(d.size);
		}).attr("r", function(d) {
			return scale(d.size);
		}).style("fill", function(d) {
			return d.c;
		}).on('mouseover', function(d, i) {
			fade(d.c, .1);
		}).on('mouseout', function(d, i) {
			fadeOut();
		}).transition().delay(function(d, i) {
			return x(d.x) - y(d.y);
		}).duration(500).attr("cx", function(d) {
			return x(d.x);
		}).attr("cy", function(d) {
			return y(d.y);
		}).ease("bounce");

		pieData[0].values.push(readings[0]);
		pieData[0].labels.push(mesg.from + ' ' + iter);
		
		if (readings[0] < 125 ) {
			pieData[0].marker.colors.push('#5DC621');
		}
		if ((readings[0] >= 125 && readings[0] <= 140)) {
			pieData[0].marker.colors.push('#DFDF55');
		}
		if (readings[0] > 140) {
			pieData[0].marker.colors.push('#FB7308');
		}
		

		

		Plotly.newPlot('pieChart', pieData, layout);
		iter++;

	}

	function fade(c, opacity) {
		svg.selectAll("circle").filter(function(d) {
			return d.c != c;
		}).transition().style("opacity", opacity);
	}

	function fadeOut() {
		svg.selectAll("circle").transition().style("opacity", function(d) {
			opacity(d.size);
		});
	}

	function setConnected(connected) {
		$("#connect").prop("disabled", connected);
		$("#disconnect").prop("disabled", !connected);
		$('#from').prop('disabled', connected);
		$('#text').prop('disabled', !connected);
		if (connected) {
			$("#conversation").show();
			$('#text').focus();
		} else
			$("#conversation").hide();
		$("#messages").html("");
	}

	$("form").on('submit', function(e) {
		e.preventDefault();
	});

	$('#from').on('blur change keyup', function(ev) {
		$('#connect').prop('disabled', $(this).val().length == 0);
	});
	$('#connect,#disconnect,#text').prop('disabled', true);

	$('#connect').click(function() {
		client = Stomp.over(new SockJS('/chat'));
		client.connect({}, function(frame) {
			setConnected(true);
			client.subscribe('/topic/messages', function(message) {
				showMessage(JSON.parse(message.body));
			});
		});
	});

	$('#disconnect').click(function() {
		if (client != null) {
			client.disconnect();
			setConnected(false);
		}
		client = null;
	});

	$('#send').click(function() {
		var topic = $('#topic').val();
		client.send("/app/chat/" + topic, {}, JSON.stringify({
			from : $("#from").val(),
			text : $('#text').val(),
		}));
		$('#text').val("");
	});
});
