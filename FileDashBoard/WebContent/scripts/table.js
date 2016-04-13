$.ajax({
		  type:"post",
		  url:'http://demandwaredashboard-dev.mot.com/FileDashBoard/GettingFolderWiseCountServlet',
		  success:function(data){
			  
			console.log(data);	  		  
			var json1 = JSON.parse(data);
			//alert(json1.length);
			if(json1.length == 0){
				ajaxCall2();
			}else{
			drawTable(json1);
			// var jsonData = '[{"rank":"9","content":"Alon","UID":"5"},{"rank":"6","content":"Tala","UID":"6"}]';
			}
}});

function ajaxCall2(){
	console.log("Inside ajaxCall2");
    $.ajax({
    	type:"post",
		url:'http://demandwaredashboard-dev.mot.com/FileDashBoard/GettingFolderNamesServlet',
        success: function(data){
        	console.log(data);
        	var json2 = JSON.parse(data);
        	drawTableForFolder(json2);
        }
    });
}

function drawTable(data) {
    for (var i = 0; i < data.length; i++) {
        drawRow(data[i].map);
    }
}

function drawRow(rowData) {
    var row = $("<tr>");
    
    $("#records_table").append(row); //this will append tr element to table... keep its reference for a while since we will add cels into it
    //row.append($("<td> <a href=# class=Edit_link onclick=EditRow();" + rowData.folderName + "</td>"));
    
    row.append($('<a href="#" onclick=EditRow(this);><td>'+rowData.folderName+'</td></a>'));
    row.append($("<td>" + rowData.fileCount + "</td>"));    
}

function drawTableForFolder(data) {
    for (var i = 0; i < data.length; i++) {
    	drawRowForFolder(data[i].map);
    }
}

function drawRowForFolder(rowData) {
    var row = $("<tr>");
    
    $("#records_table").append(row); //this will append tr element to table... keep its reference for a while since we will add cels into it
   // row.append($("<td> <a href="#" class="Edit_link" onclick="EditRow();" + rowData.folderName + </td>"));
    
    row.append($('<td>'+rowData.folderName+' </td>'));
    row.append($("<td> 0 </td>"));    
}