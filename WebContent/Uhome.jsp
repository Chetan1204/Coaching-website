<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Programmers Point</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<!--
Template 2034 Iron Rush
http://www.tooplate.com/view/2034-iron-rush
-->
<link href="css/tooplate_style.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" href="css/nivo-slider.css" type="text/css" media="screen" />
<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/jquery.nivo.slider.js" type="text/javascript"></script>

<script type="text/javascript">
$(window).load(function() {
	$('#slider').nivoSlider({
		effect:'random',
		slices:15,
		animSpeed:500,
		pauseTime:3000,
		startSlide:0, //Set starting Slide (0 index)
		directionNav:false,
		directionNavHide:false, //Only show on hover
		controlNav:false, //1,2,3...
		controlNavThumbs:false, //Use thumbnails for Control Nav
		pauseOnHover:true, //Stop animation while hovering
		manualAdvance:false, //Force manual transitions
		captionOpacity:0.8, //Universal caption opacity
		beforeChange: function(){},
		afterChange: function(){},
		slideshowEnd: function(){} //Triggers after all slides have been shown
	});
});
</script>

</head>
<body>
<div id="tooplate_body_wrapper">
<div id="tooplate_wrapper">
	<div id="tooplate_top_bar"></div>	
    
    <div id="tooplate_header">
        <div id="site_title"><img height="40px" width="300px" src="http://programmerspoint.in/images/logo.png" />
        </div>
        <div id="tooplate_menu">
            <ul>
                <li><a href="index.html" class="current">Home</a></li>
                <li><a href="about.html">About Us</a></li>
                
            </ul>    	
        </div> <!-- end of tooplate_menu -->
    </div> <!-- end of forever header -->
    
    <div id="tooplate_middle">
    	<div id="slider">
            <a href="#"><img src="images/slideshow/05.png"  /></a>
            <a href="#"><img src="images/slideshow/06.png"  /></a>
            <a href="#"><img src="images/slideshow/01.png" /></a>
            <a href="#"><img src="images/slideshow/02.png" /></a>
        </div>	
	</div> <!-- end of middle -->
    
    <div id="tooplate_main">
    
    	<div class="col_allw300">
        	<%@include file="db.jsp" %>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%
String email=(String) session.getAttribute("id");
out.println(email);
%>
<a href="Logout"><h5>Logout</h5></a>
<div>
<%
String qr="select * from course";
Statement st=con.createStatement();
ResultSet rs=st.executeQuery(qr);
if(rs.next())
{
	do
	{
		String cname=rs.getString("cname");
		String duration=rs.getString("duration");
		int fees=rs.getInt("fees");
		String trainer=rs.getString("trainer");
		String img=rs.getString("img");
		%>
		<div style="height: 300px;width: 220px;background-color: black;color: white;float: left;margin: 2px">
		<img alt="" src="<%=img%>" height="100px" width="100px" /><br>
		COURSE Details:-<br>
		NAME : <%=cname %><br>
		DURATION : <%=duration %><br>
		FEES : <%=fees %><br>
		TRAINER : <%=trainer %><br>
		<a href="register.jsp?cname=<%=cname %>">REGISTER NOW</a>
		</div>
		<%
	}while(rs.next());
}else
{
	out.println("no languages found");
}
con.close();
%>
</div>
            <div class="cleaner"></div>
        </div>
        
        <div class="cleaner"></div>
    </div> <!-- end of main -->

	<div class="cleaner"></div>
</div> <!-- end of forever wrapper -->
</div> <!-- end of forever body wrapper -->

<div id="tooplate_footer_wrapper">
	<div id="tooplate_footer">
	  <div class="cleaner"></div>
    </div>
</div>

<div id="tooplate_copyright_wrapper">
	<div id="tooplate_copyright"></div>
</div>
</body>
</html>