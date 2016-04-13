$(document).ready(function() {  
	$.ajax({
		  type:"post",
		  url:'http://localhost:8081/FileDashBoard/GettingFolderWiseCountServlet',
		  success:function(data){
			console.log(data);	  
		  
	
	var json = JSON.parse(data);
    console.log(json);
		//This is for highcarts 
   var jsonArray = [];
 	console.log("before loop");
 	console.log(json.length);
 	for (var k = 0; k < json.length; k++) {
 		
 	    jsonArray.push({
 	        name: json[k].map.folderName,
 	        
 	        y: json[k].map.fileCount
 	    });
 	  console.log("name");
 	}
	
	var chart = {
       plotBackgroundColor: null,
       plotBorderWidth: null,
       plotShadow: false
   };
   var title = {
      text: 'Folder wise delayed files'   
   };      
   var tooltip = {
      pointFormat: 'File Count: <b>{point.y:.1f}</b>'
   };
   var plotOptions = {
      pie: {
         allowPointSelect: true,
         cursor: 'pointer',
         dataLabels: {
            enabled: false,
           
            style: {
               color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
            }
         }
      }
   };
   var credits = {
		      enabled: false
		   };
   var series= [{
      type: 'pie',
      name: 'Browser share',
      data:jsonArray
   }];
    	  
   var json = {};   
   json.chart = chart; 
   json.title = title;     
   json.tooltip = tooltip;  
   json.series = series;
   json.plotOptions = plotOptions;
   json.credits = credits;
   $('#container5').highcharts(json);  
		  }
	});
});