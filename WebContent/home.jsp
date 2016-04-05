<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="birt" uri="WEB-INF/tlds/birt.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link href="http://demandware.edgesuite.net/aahb_prd/on/demandware.static/-/Sites/default/dw2cdc9f24/Motorola_US/favicon.ico"
	rel="shortcut icon">
<title>Home</title>
<!-- <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script> -->
<!-- Bootstrap Core CSS -->
<link href="bower_components/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="bower_components/metisMenu/dist/metisMenu.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="dist/css/sb-admin-2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/redmond/jquery-ui.css" rel="stylesheet" type="text/css"/>
<link href="bower_components/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="css/pagination.css" media="all" rel="stylesheet" type="text/css" />	
<style type="text/css">
	body {
		padding-right:0px !important;
		overflow-x:hidden !important;
		}
	#left{
		height: 100%;
        overflow-y: auto;
	}
	
</style>


<!-- <script -->
<!-- 	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script> -->	
	<!-- <script src="http://code.highcharts.com/highcharts.js"></script>
	<script src="http://code.highcharts.com/highcharts-more.js"></script> -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>

<script src="http://code.highcharts.com/highcharts.js"></script>
<script src="http://code.highcharts.com/highcharts-more.js"></script>
<!-- <script src="http://code.highcharts.com/modules/exporting.js"></script> -->

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
				<a class="navbar-brand" href="index.html">
				<img src="images/moto-logo.png" height="65" width="280" /></a>
			</div>
		
		<!-- /.navbar-header -->

		
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
		<!-- /.navbar-static-side --> </nav>

		<!-- Page Content -->
		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12" >
						<div id="dialog">
					</div>


				
				</div>
				<br>
				
	<div class="container">
	<div class="row" style="margin-top: 60px;">
		
		<!-- col-md-6 -->
			<div id="pageNavPosition" style="position: absolute; left: 820px;"></div>
			<div class="col-md-4" style="margin: -6% 0px 0px -9px;width: 121px;">
			<div class="panel panel-primary" id="left" style="height: 379px;margin: 1px -418px 16px 0px;">
				<div class="panel-heading">Stuck files from past hour</div>
				<div class="panel-body">
				<div id="cont"></div>
					<table id="records_table" class="table">
					
						<thead>
							<tr>
								<th>Folder Name</th>
								<th>Count</th>
							</tr>
						</thead>	
									
					</table>
				</div>
				
        		
    		</div>
			</div>
			<div class="col-md-4" style="margin:-6% 0px 0px 408px;width: 125px;">
			<div class="panel panel-primary" style="height: 379px;margin: 1px -418px 16px 0px;">
				<div class="panel-heading">Current time</div>
				<div class="panel-body">
				<div id="cont"></div>
					<div id="container" style="width: 400px; height: 400px; margin: 0 auto">
				
        		
    		</div>
			</div>
			
			<!--panel -->
		</div>
		<!--col-md-6 -->
	</div>
	
	</div>
	
	<div class="row">
		
			<!--panel -->
		
		<!-- col-md-6 -->
		<div class="col-md-6">
			
		<div class="col-md-6" style="width: 120%;margin: -4px 0px 0px -23px;">
			<div class="panel panel-primary" style="width: 1041px;">
				<div class="panel-heading">Weekly historical data</div>
				<div class="panel-body">
				<div id="container9" style="style=width: 100%;height: 100%;"></div></div>
			</div>
			</div>
			<!--panel -->
		</div>
		</div>
							</div>
					</div>
				
				
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>
	
	<!-- /#page-wrapper -->
	<!-- jQuery -->
	<script src="scripts/bar.js"></script>
	<script src="scripts/clock.js"></script>
	<script src="scripts/table.js"></script>
	<script src="scripts/pageLoad.js"></script>
	<script src="scripts/gauge.js"></script>
	<!-- Bootstrap Core JavaScript -->

	<!-- Metis Menu Plugin JavaScript -->
	<!-- <script src="bower_components/metisMenu/dist/metisMenu.min.js"></script> -->

	<!-- Custom Theme JavaScript -->
	<!-- <script src="dist/js/sb-admin-2.js"></script> -->

</body>

</html>
