<%@page import="org.quinnox.pojo.FolderNameList"%>
<%@page import="org.quinnox.dao.DashBoardDAO"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="org.quinnox.pojo.GetTimeAndFileCount"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
	<link href="http://demandware.edgesuite.net/aahb_prd/on/demandware.static/-/Sites/default/dw2cdc9f24/Motorola_US/favicon.ico" rel="shortcut icon">
    
    <title>Dashboard</title>

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
	
	<!-- This is for datetime picker -->
	<meta charset='utf-8'>

    <meta name="description" content="A javascript plugin for intelligently selecting date and time ranges inspired by Google Calendar." />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

    <script src="https://jonthornton.github.io/jquery-timepicker/jquery.timepicker.js"></script>
    <link rel="stylesheet" type="text/css" href="https://jonthornton.github.io/jquery-timepicker/jquery.timepicker.css" />

    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/css/bootstrap-datepicker.standalone.css" />

    <script src="lib/pikaday.js"></script>
    <link rel="stylesheet" type="text/css" href="lib/pikaday.css" />

    <script src="lib/jquery.ptTimeSelect.js"></script>
    <link rel="stylesheet" type="text/css" href="lib/jquery.ptTimeSelect.css" />
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/themes/ui-lightness/jquery-ui.css" type="text/css" media="all" />

    <script src="lib/moment.min.js"></script>
    <script src="lib/site.js"></script>

    <script src="dist/datepair.js"></script>
    <script src="dist/jquery.datepair.js"></script>
	
	<script src="http://code.highcharts.com/highcharts.js"></script>
	<script src="https://code.highcharts.com/modules/no-data-to-display.js"></script>
    <script src="https://code.highcharts.com/modules/exporting.js"></script>
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
                        <h3 class="page-header">Analysis based on date and time</h3>
							<section id="examples">
							<article>
								<div class="demo">
								  <form action="GetTheCountOfFilesServlet" method="post" style="margin-left: 100px;"> 
									<p id="basicExample">
										<input type="text" class="date start" name="txtStartDate" placeholder="Select start date" required="required"/>
										<input type="text" class="time start" name="txtStartTime" placeholder="Select start time" required="required"/> to
										<input type="text" class="time end" name="txtEndTime" placeholder="Select end time" required="required"/>
										<input type="text" class="date end" name="txtEndDate" placeholder="Select end date" required="required"/>
									</p>
									
									<br>
									<%List<FolderNameList> folderNameLists; %>
                        			<%DashBoardDAO dashBoardDAO = new DashBoardDAO(); %>
                        			<select name="mydropdown2" class="dropdown-header" id="my_dropdown" style="margin-left: 190px;">
                        			<%
                        				folderNameLists = dashBoardDAO.getFolderName();
                        				for(FolderNameList list : folderNameLists){
                        					out.println("<option value="+list.getFolderName()+">"+list.getFolderName()+"</option>");
                        				}
                        			%>
                        			</select> <br>
										<input type="submit" class="btn btn-success" value="submit" style="margin-left: 290px;"/>
								  </form> 
								</div> <br><br>
								
<!-- 								<div id="container" style="300px;"></div> -->
								
								

								<script>
									$('#basicExample .time').timepicker({
										'showDuration': true,
										'timeFormat': 'G:i'
									});

									$('#basicExample .date').datepicker({
										'format': 'yyyy-mm-dd',
										'autoclose': true
									});

									var basicExampleEl = document.getElementById('basicExample');
									var datepair = new Datepair(basicExampleEl);
								</script>
							</article>
						</section>
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
