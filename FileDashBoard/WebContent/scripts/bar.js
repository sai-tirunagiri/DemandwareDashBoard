$(document).ready(function() {  
	$.ajax({
		  type:"post",
		  url:'http://demandwaredashboard-dev.mot.com/FileDashBoard/GettingOverallCountServlet',
		  success:function(data1){
			console.log(data1);	  
	var json = JSON.parse(data1);
    console.log(json);
		//This is for highcarts 
   var jsonArray = [];
 	console.log("before loop");
 	console.log(json.length);
 	 
 	for (var k = 0; k < json.length; k++) {
 		
 	    jsonArray.push({
 	        name: json[k].map.timestamp,
 	        
 	        y: json[k].map.count
 	    });
 	  console.log("name");
 	}
	
   var chart = {
      type: 'column'
   };
   var title = {
      text: 'Weekly historical data'   
   };
   var xAxis = {
		   type:'category',
		   title: {
		         text: 'Date'         
		      },
		   labels: {
	                rotation: 0
	            }
   };
   var yAxis = {
      min: 0,
      title: {
         text: 'Number of files'         
      }      
   };
   var tooltip = {
      headerFormat: '<table><span style="font-size:10px">Date :{point.key}</span>',
      pointFormat: '<tr><td style="font-size:10px">Number of files: </td>' +
         '<td style="padding:0">{point.y:.1f}</td></tr>',
      footerFormat: '</table>',
      shared: true,
      useHTML: true
   };
   var plotOptions = {
      column: {
         pointPadding: 0.2,
         borderWidth: 0,
         colorByPoint: true
      }
   };
   var colors = ['#058DC7', 
                 '#50B432', 
                 '#ED561B', 
                 '#DDDF00', 
                 '#24CBE5', 
                 '#64E572', 
                 '#FF9655', 
                 '#FFF263', 
                 '#6AF9C4'
                ];
   var credits = {
      enabled: false
   };
   var series= [{
	   showInLegend: false, 
            data: jsonArray,
            pointWidth: 40
   }];
  
      
   var json = {};   
   json.chart = chart; 
   json.title = title;   
   json.tooltip = tooltip;
   json.xAxis = xAxis;
   json.yAxis = yAxis;  
   json.series = series;
   json.plotOptions = plotOptions;  
   json.colors = colors;
   json.credits = credits;
   $('#container9').highcharts(json);
		  }
	});
  
});