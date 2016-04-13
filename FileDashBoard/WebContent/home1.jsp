<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- This is for ajax -->
	 	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> 	
 	
</head>
<body>
	
	<script type="text/javascript">
		$(window).load(function() {
			console.log("window is loaded");
			$.ajax({
				  type:"post",
				  url:'http://localhost:8085/FileDashBoard/GettingFolderWiseCountServlet',
				  success:function(data){
					console.log(data)	  
				  }
			});
			$.ajax({
				  type:"post",
				  url:'http://localhost:8085/FileDashBoard/GettingOverallCountServlet',
				  success:function(data1){
					console.log(data1)	  
				  }
			});
		});
	</script>
	
</body>
</html>
