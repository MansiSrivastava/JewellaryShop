<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Jewelry Shop</title>
    <!-- Bootstrap -->
    <link href="resources/css/footer.css" rel="stylesheet">
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/mystyle2.css" rel="stylesheet">
    <link href="resources/css/table.css" rel="stylesheet">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
	<link href="http://fonts.googleapis.com/css?family=Cookie" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </head>
<body id="body2">
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
      <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>
<div class="container">
<h2 class="head1">PRODUCT'S LIST</h2>
    <div class="row col-md-3">
    <c:if test="${not empty lists}">
    <table class="table mytable-striped custab">
        <tr class="addr1">
            <th>Email</th>
		    <th>Name</th>
		    <th>Age</th>
		    <th>Password</th>
		    <th>Phone No.</th>
            <th class="text-center">Action</th>
        </tr>
        <c:forEach items="${lists}" var="user" varStatus="status">
            <tr>
                <td><input name="lists[${status.index }].email" value="${user.email}"/></td>
			    <td><input name="lists[${status.index }].name" value="${user.name}"/></td>
			    <td><input name="lists[${status.index }].age" value="${user.age}"/></td>
			    <td><input name="lists[${status.index }].password" value="${user.password}"/></td>
			    <td><input name="lists[${status.index }].phoneno" value="${user.phoneno}"/></td>
                <td class="text-center"><a class='btn btn-info btn-xs' href="#"><span class="glyphicon glyphicon-edit"></span> Edit</a> <a href="#" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> Del</a></td>
            </tr>
        </c:forEach>   
    </table>
    </c:if>
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

					<a href="#"><i class="fa fa-facebook"></i></a>
					<a href="#"><i class="fa fa-twitter"></i></a>
					<a href="#"><i class="fa fa-linkedin"></i></a>
					<a href="#"><i class="fa fa-github"></i></a>

				</div>

			</div>

		</footer>
</div>
</body>
</html>