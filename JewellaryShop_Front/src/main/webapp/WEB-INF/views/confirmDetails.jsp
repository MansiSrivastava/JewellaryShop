<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Confirm Details</title>
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
           </div>
         </nav> 
           <div class="container">
               <div class="row">
               <div class="col-md-4 col-md-offset-4">
			<fieldset>
				<legend>Confirm Details</legend>
				<!-- for triggering webflow events using links,
					 the eventId to be triggered is given in "href" attribute as:
				 -->
				<sf:form modelAttribute="user">
					<sf:label path="houseno">House No.:</sf:label>${user.houseno}
					<br /><br />
					<sf:label path="city">City:</sf:label>${user.city}
					<br /><br />
					<sf:label path="state">State :</sf:label>${user.state}
					<br /><br />
					<sf:label path="country">Country :</sf:label>${user.country}
					<br /><br />
					<!-- for triggering webflow events using form submission,
					 the eventId to be triggered is given in "name" attribute as:
					-->
					<input name="_eventId_edit" type="submit" value="Edit" /> 
					<input name="_eventId_submit" type="submit" value="Confirm Details" /><br />
				</sf:form>
			</fieldset>
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
	</body>
</html>