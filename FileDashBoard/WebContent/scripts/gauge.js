//$("#use-address").click(function() {
function EditRow(obj){
	ajaxindicatorstart('loading... please wait..');
	//alert("Hello");
	var FolderName = $(obj).text();
    //alert(t);
    $.ajax({
        type: 'GET',
        url: 'http://demandwaredashboard-dev.mot.com/FileDashBoard/GetFileListBasedOnFolderNameServlet',
        data: {"frameID": FolderName},
		success : function(responseText) {
			ajaxindicatorstop();
			console.log(responseText);
			$("#dialog").dialog({
					position: { my: "center", at: "center", of: window },
					closeOnEscape: true,
					 buttons: [
					           {
					             text: "Ok",
					             icons: {
					               primary: " ui-icon-check"
					             },
					             click: function() {
					               $( this ).dialog( "close" );
					             }
					        
					             //showText: false
					           }
					         ],
					         width: 800,
					         height: 300,
					         open: function(event, ui) { 
					        	    //hide close button.
					        	    $(this).parent().children().children('.ui-dialog-titlebar-close').hide();
					        	}
			});
			$('#dialog').html(responseText);
		}
    });  
}

//function EditRow()
  //      {   
			
	
			//var row= $(this).closest('tr');  
            //var FolderName=$("td").text();
			//var FolderName = $(this).closest("tr").find('td:eq(0)').text();
           
            //alert(FolderName);
            //alert($(this).closest('tr').find('#clustr').text());
           /* $.ajax({
                type: 'GET',
                url: 'http://localhost:8081/FileDashBoard/GetFileListBasedOnFolderNameServlet',
                data: {"frameID": FolderName},
	    		success : function(responseText) {
	    			console.log(responseText);
	    			alert(responseText);
	    			if(responseText == "ok"){
	                    //window.location.assign("page4.jsp");
	                  }else{
	                      $('#ajaxGetUserServletResponse').text(responseText);
	                  }
	    		}
           });*/
            
        //}