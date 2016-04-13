<%@page import="java.sql.Timestamp"%>
<%@page import="org.quinnox.pojo.GetTimeAndFileCount"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
	<link href="http://demandware.edgesuite.net/aahb_prd/on/demandware.static/-/Sites/default/dw2cdc9f24/Motorola_US/favicon.ico" rel="shortcut icon">
    
    <title>Count of files</title>
    <!-- Datatable -->
    <link rel="stylesheet" type="text/css"
	href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">

    <!-- Bootstrap Core CSS -->
    <link href="bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

	
    <!-- MetisMenu CSS -->
    <link href="bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="dist/css/sb-admin-2.css" rel="stylesheet">
    

    <!-- Custom Fonts -->
    <link href="bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<!-- 	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet" type="text/css"> -->
<!-- 	<link href="https://cdn.datatables.net/1.10.10/css/dataTables.bootstrap.min.css" rel="stylesheet" type="text/css"> -->
	
	<!-- This is for ajax -->
	 	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> 	
 	
	
	<!-- This is for datatable -->
<!-- 	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"> -->
<!--     <link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css"> -->
<!--  	 <link rel="stylesheet" href="css/style.css"> -->
<!--        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>       -->
<!--       <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>   -->
<!--     <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script> -->
    
<!--     <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script> -->

	<!-- High carts -->
<!-- 	<script src="http://code.highcharts.com/highcharts.js"></script> -->
<!-- Datatable scripts -->



<!-- highcharts -->
	<script src="http://code.highcharts.com/highcharts.js"></script>
    <script src="https://code.highcharts.com/modules/exporting.js"></script>
    
	
	<script type="text/javascript" src="js/paginate.js"></script>
		 <style type="text/css">
    .pg-normal {
        color: black;
        font-weight: normal;
        text-decoration: none;
        cursor: pointer;
        font-family:    'Lucida Grande',Verdana,Arial,Sans-Serif;
        font-size:10px;
    }
    .pg-selected {
        color: black;
        font-weight: bold;
        text-decoration: underline;
        cursor: pointer;
        font-family:    'Lucida Grande',Verdana,Arial,Sans-Serif;
        font-size:10px;
    }
    </style>
    <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.js"></script>
     <script src="//cdn.datatables.net/tabletools/2.2.4/js/dataTables.tableTools.min.js"></script>
     <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/tabletools/2.2.4/css/dataTables.tableTools.css" />
<!--     <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/buttons/1.1.1/js/dataTables.buttons.min.js"></script> -->
<!--     <script type="text/javascript" charset="utf8" src="//cdn.datatables.net/buttons/1.1.1/js/buttons.flash.min.js"></script> -->
<!--     <script type="text/javascript" charset="utf8" src="//cdnjs.cloudflare.com/ajax/libs/jszip/2.5.0/jszip.min.js"></script> -->
<!--     <script type="text/javascript" charset="utf8" src="//cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/pdfmake.min.js"></script> -->
<!--     <script type="text/javascript" charset="utf8" src="//cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/vfs_fonts.js"></script> -->
<!--     <script type="text/javascript" charset="utf8" src="//cdn.datatables.net/buttons/1.1.1/js/buttons.html5.min.js"></script> -->
<!--     <script type="text/javascript" charset="utf8" src="//cdn.datatables.net/buttons/1.1.1/js/buttons.print.min.js"></script> -->
   
   
  	
  	 
    
</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html"><img src="images/moto-logo.png" height="65" width="280"/></a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
             
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="login.html"><img src="https://mail.google.com/mail/u/0/?logout&hl=en" style="display: none;" /><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                       <li><a href="home.jsp"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a></li>
					   <li><a href="page1.jsp"><i class="fa fa-bar-chart-o fa-fw"></i> Historical Analysis</a></li>
					   <li><a href="page4.jsp"><i class="glyphicon glyphicon-stats"></i> Reports</a></li>
                        

                     
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        
			 		<% List<GetTimeAndFileCount> lst = (List<GetTimeAndFileCount>)request.getAttribute("timeAndFileCountList");
 						   request.setAttribute("ArrayList", lst);%>
						<%! Timestamp timestamp; %>
						
						
						<c:if test="${ empty( ArrayList ) }">
        						<h3 style="color:red;margin-left: 230px;"> NO DELAYED FILES FOUND AT THIS TIME! </h3>
        						
    					</c:if>
						
						<c:if test="${! empty( ArrayList ) }">
						<h2 class="page-header">Files stuck in tranfer</h2>
						<div id ="datatable_wrapper"></div>
						<table width="100%" id="choose-address-table" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0">
							<thead>
								<tr class="ui-widget-header">
									<th> Date&Time </th>
									<th> File Count </th>
									<th></th> 
								</tr>
							</thead>
							<tbody id="myTable">
<!-- 								<tr class="ui-widget-header"> -->
<!-- 									<th> Date&Time </th> -->
<!-- 									<th> File Count </th> -->
<!-- 									<th></th> -->
<!-- 								</tr> -->
								<tr>
								<%Timestamp time;%>
								<% for(GetTimeAndFileCount category : lst) {%>
									<td class="nr"> <%=time = category.getTimestamp() %> </td>
									<td> <% out.println(category.getCount()); %> </td>						
									<td> <input type="submit" class="btn btn-success" value="Show Files"></td>
								</tr>	
								<%} %>
							</tbody>
						</table> 
<!-- 							<div id="pageNavPosition" style="position: absolute; left: 820px;"></div> -->
 						 <br><br> 
								
							<a href="page1.jsp"><button type = "button" class = "btn btn-info">Click here to go back</button></a>
<!-- 						<div class="col-lg-12"> -->
<!-- 							<div id="container" style="width: 100%; height: 300px;"></div> -->
<!-- 						</div>	  -->
						</c:if>
						
<!-- 						<iframe style="border: 0;width: 100%" src="file:///C:/Users/NHCE/Desktop/sai/pieChart.html"></iframe> -->
						
<!-- 						http://localhost:8085/FileDashBoard/ -->
<!-- 						http://100.65.177.177:7261/FileDashBoard/ -->
<!-- 						http://filedashboard.elasticbeanstalk.com/ -->
						<script type="text/javascript">
							$('.btn-success').click(function () {
					    	var id = $(this).closest("tr").find('td:eq(0)').text();
					    	//alert(id);
						    	$.ajax({
					                type: 'GET',
					                url: 'http://demandwaredashboard-dev.mot.com/FileDashBoard/GetFileListServlet',
					                data: {"frameID": id},
						    		success : function(responseText) {
						    			if(responseText == "ok"){
						                    window.location.assign("page3.jsp");
						                  }else{
						                      $('#ajaxGetUserServletResponse').text(responseText);
						                  }
						    		}
					           });
							});
														
						</script>
						
						<script type="text/javascript">
								jQuery(document).ready(function() {
								var json = ${Json};
								var jsonString = JSON.stringify(json);
							  	//alert(jsonString);
							  	
							  	/* This is for highcarts */
							  	var jsonArray = [];
							  	console.log("before loop");
							  	console.log(jsonString.length);
							  	for (var i = 0; i < json.length; i++) {
							  	    jsonArray.push({
							  	        name: json[i].map.timestamp,
							  	        
							  	        y: json[i].map.count
							  	    })
							  	  console.log("name");
							  	}
							 $(function(){
								  new Highcharts.Chart({
							  	            chart: {
							  	                plotBackgroundColor: null,
							  	                plotBorderWidth: null,
							  	                plotShadow: false,
							  	                type: 'bar',
							  	                renderTo: 'container'
							  	            },
							  	            title: {
							  	                text: 'FILES DELAYED IN TRANSFER'
							  	            },
							  	            xAxis: {
							  	            	type: 'category',
							  	          
							  	                title: {
							  	                    text: 'DATE & TIME '
							  	                }

							  	            },
							  	            yAxis: {
							  	            	
							  	                title: {
							  	                	
							  	                    text: 'NUMBER OF FILES'
							  	                }

							  	            },
							  	            credits: {
							  	                enabled: false
							  	            },
							  	            plotOptions: {
							  	                series: {
							  	                events: {
							  	                    legendItemClick: function () {
							  	                        return false;
							  	                        }
							  	                    }
							  	                }
							  	            },
							  	        
						  	            series:
						  	            		[{
 							  	                name:'Number of files',
 							  	                   showInLegend: false, 
 							  	                colorByPoint: true,
 							  	                data: jsonArray
 							  							}]
							  	        });
							  	});
							});

						</script>
						
						<script>
							var table = $('#choose-address-table').DataTable({
								/*dom: 'Bfrtip',

						        buttons: [

						            'copy', 'csv', 'excel', 'pdf', 'print'

						        ] */
						        
							});
							var tableTools = new $.fn.dataTable.TableTools(table, {
				                'aButtons': [
				                    {
				                        'sExtends': 'xls',
				                        'sButtonText': 'Save to Excel',
				                        'sFileName': 'Data.xls'
				                    },
				                    
				                    {
				                        'sExtends': 'pdf',
				                        'bFooter': false
				                    },
				                    
				                ],
				                'sSwfPath': '//cdn.datatables.net/tabletools/2.2.4/swf/copy_csv_xls_pdf.swf'
				            });
				            $(tableTools.fnContainer()).insertBefore('#datatable_wrapper');
						</script>	
						
											
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="dist/js/sb-admin-2.js"></script>

</body>

</html>
