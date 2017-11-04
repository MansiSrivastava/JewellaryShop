<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="false"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Jewellary Shop- View Products</title>
    <!-- Bootstrap -->
    <link href="resources/css/footer.css" rel="stylesheet">
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/mystyle.css" rel="stylesheet">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
	<link href="http://fonts.googleapis.com/css?family=Cookie" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
  </head>
<body id="body1">
<div class="container"> 
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#"><img src="resources/images/logo.png" alt="Image Error" height="60px" width="125px"/></a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="index">Home</a></li>
      <li><a href="aboutus">About Us</a></li>
      <li><a href="contactus">Contact Us</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="signup"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="loginPage"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav> 
<div class="row container-fluid">
          <div class="col-lg-3">.
          <h1 class="my-4">Category</h1>
          <div class="list-group">
            <a href="#" class="list-group-item">Category 1</a>
            <a href="#" class="list-group-item">Category 2</a>
            <a href="#" class="list-group-item">Category 3</a>
          </div>
          </div>
          <!-- /.col-lg-3 -->
          
    <div id="myCarousel" class="carousel slide col-lg-9" data-ride="carousel" style="max-width:100%; margin: 50 auto; background-color: #000000">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
      <li data-target="#myCarousel" data-slide-to="4"></li>
      <li data-target="#myCarousel" data-slide-to="5"></li>
      <li data-target="#myCarousel" data-slide-to="6"></li>
      <li data-target="#myCarousel" data-slide-to="7"></li>
      <li data-target="#myCarousel" data-slide-to="8"></li>
      <li data-target="#myCarousel" data-slide-to="9"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
                     <img src="resources/images/Home Page slider/01.jpg" alt="error" style="max-width: 100%; height: auto;">
            </div>
            <div class="item">
                     <img src="resources/images/Home Page slider/02.jpg" alt="error" style="max-width: 100%; height: auto;">
            </div>
            <div class="item">
                     <img src="resources/images/Home Page slider/03.jpg" alt="error" style="max-width: 100%; height: auto;">
            </div>
            <div class="item">
                     <img src="resources/images/Home Page slider/04.jpg" alt="error" style="max-width: 100%; height: auto;">
            </div>
            <div class="item">
                     <img src="resources/images/Home Page slider/05.jpg" alt="error" style="max-width: 100%; height: auto;">
            </div>
            <div class="item">
                     <img src="resources/images/Home Page slider/06.jpg" alt="error" style="max-width: 100%; height: auto;">
            </div>
            <div class="item">
                     <img src="resources/images/Home Page slider/07.jpg" alt="error" style="max-width: 100%; height: auto;">
            </div>
            <div class="item">
                     <img src="resources/images/Home Page slider/08.jpg" alt="error" style="width:100%;">
            </div>
            <div class="item">
                     <img src="resources/images/Home Page slider/09.jpg" alt="error" style="width:100%;">
            </div>
            <div class="item">
                     <img src="resources/images/Home Page slider/10.jpg" alt="error" style="width:100%;">
            </div>
    </div>
    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>         
</div>

<div class="row" data-ng-app="myApp" data-ng-controller="pdtCtrl">
<div class="col-md-4" data-ng-repeat="x in products">
          <div class="thumbnail">
            <img src="{{ x.Imagepath }}" alt="Image error">
              <div class="caption">
                <h4 align="left">{{ x.Name }}</h4>
                <p align="left">{{ x.Description }}</p>
                <p align="left">Rs.{{ x.Price }}</p>
                <!-- <p><a href="addToCart?id={{ x.Id }}"><button type="button" class="btn btn-primary btn-block">Add to Cart</button></a></p>  
                <p><a href="memberShip"><button type="button" class="btn btn-primary btn-block">Add to Cart</button></a></p>-->
                <p align="left"><a href="productdetails?id={{ x.Id }}">More info...</a></p>
            </div>
          </div>
</div>
</div>

<script>
var app = angular.module('myApp', []);
app.controller('pdtCtrl', function($scope) {
	$scope.products = ${lists};
});
</script> 
 
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
