<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Jewelry Shop- Sign Up</title>
    <!-- Bootstrap -->
    <link href="resources/css/footer.css" rel="stylesheet">
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/mystyle3.css" rel="stylesheet">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
	<link href="http://fonts.googleapis.com/css?family=Cookie" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </head>
<body id="body3">
<div class="container"> 
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#"><img src="resources/images/logo.png" alt="Image Error" height="60px" width="125px"/></a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="index">Home</a></li>
      <li><a href="aboutus">About Us</a></li>
      <li><a href="products">Products</a></li>
      <li><a href="contactus">Contact Us</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="loginPage"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav> 
  <div class="container">
        <div class="row">
        <div class="col-md-4 col-md-offset-4">
        	<div class="panel panel-default div2">
        		<div class="panel-heading">
			    		<h2><span class="glyphicon glyphicon-user"></span> Sign Up</h2>
			 			</div>
			 			<div class="panel-body">
			    		<form:form role="form" modelAttribute="user" action="registerProcess" method="post">
			    			<div class="row">
			    				<div class="col-xs-12 col-sm-12 col-md-12">
			    					<div class="form-group">
			                        <form:input type="text" path="name" name="name" class="form-control input-sm" placeholder="Enter name"/>
			    					<form:errors path="name" cssStyle="color: #ff0000;"/>
			    					</div>
			    				</div>
			    			</div>
			    			<div class="form-group">
			    				<form:input type="email" path="email" name="email" class="form-control input-sm" placeholder="Enter email"/>
			    			    <form:errors path="email" cssStyle="color: #ff0000;"/>
			    			</div>

			    			<div class="row">
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    						<form:input type="password" path="password" id="password" class="form-control input-sm" placeholder="Password"/>
			    					    <form:errors path="password" cssStyle="color: #ff0000;"/>
			    					</div>
			    				</div>
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    						<form:input type="password" path="confirm_password" id="confirm_password" class="form-control input-sm" placeholder="Confirm Password" onkeyup='check();'/>
			    					    <span id='message'></span>
			    					</div>
			    				</div>
			    			</div>
			    			<div class="form-group">
			    				<form:input type="text" path="phoneno" name="phoneno" class="form-control input-sm" placeholder="Enter Phone Number"/>
			    			</div>
			    			<div class="form-group">
			    				<form:input type="text" path="houseno" name="houseno" class="form-control input-sm" placeholder="Enter House Number"/>
			    			</div>
			    			<div class="form-group">
			    				<form:input type="text" path="city" name="city" class="form-control input-sm" placeholder="Enter City"/>
			    			</div>
			    			<div class="form-group">
			    				<form:input type="text" path="state" name="state" class="form-control input-sm" placeholder="Enter State"/>
			    			</div>
			    			<div class="form-group">
			    				<form:input type="text" path="country" name="country" class="form-control input-sm" placeholder="Enter Country"/>
			    			</div>
			    			<input type="submit" value="SIGN UP" class="btn btn-info btn-block">
			    		
			    		</form:form>
			    	</div>
			    </div>
			  </div>
		</div>
</div>
<footer class="footer-distributed">

			<div class="footer-left">

				<h3><img src="resources/images/logo.png" alt="Image Error" height="60px" width="125px"/></h3>

				<p class="footer-links">
					<a href="index">Home</a><br>
					<a href="#">Blog</a><br>
					<a href="#">Pricing</a><br>
					<a href="aboutus">About</a><br>
					<a href="#">Faq</a><br>
					<a href="contactus">Contact</a>
				</p>

				<p class="footer-company-name">Jewelry shop &copy; 2017</p>
			</div>

			<div class="footer-center">

				<div>
					<i class="fa fa-map-marker"></i>
					<p><span>H12, Vadala Street</span> New Delhi, India</p>
				</div>

				<div>
					<i class="fa fa-phone"></i>
					<p>011-2546113</p>
				</div>

				<div>
					<i class="fa fa-envelope"></i>
					<p><a href="mailto:customersupport@jewels.com">customersupport@jewels.com</a></p>
				</div>

			</div>

			<div class="footer-right">

				<p class="footer-company-about">
					<span>About the company</span>
					Our vision is to generate happiness and confidence in every Indian women. In 1995, Ms. Reema Seth, Founder President of JewelryShop, started jewelshop.com with a successful market of 55 million beauty products and more than 100 thousand services across the world.
				</p>

				<div class="footer-icons">

					<a href="https://www.facebook.com/"><i class="fa fa-facebook"></i></a>
					<a href="https://twitter.com/"><i class="fa fa-twitter"></i></a>
					<a href="https://in.linkedin.com/"><i class="fa fa-linkedin"></i></a>

				</div>

			</div>

		</footer>
</div>
<script type="text/javascript">
var check = function() {
	  if (document.getElementById('password').value ==
	    document.getElementById('confirm_password').value) {
	    document.getElementById('message').style.color = 'green';
	    document.getElementById('message').innerHTML = 'password matching';
	  } else {
	    document.getElementById('message').style.color = 'red';
	    document.getElementById('message').innerHTML = 'password not matching';
	  }
	}
</script>
</body>
</html>
