<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design by TEMPLATED
http://templated.co
Released for free under the Creative Commons Attribution License

Name       : Polychromasia
Description: A two-column, fixed-width design with dark color scheme.
Version    : 1.0
Released   : 20131021

-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>Phonebook</title>
	<jsp:include page="headTags.jsp" />
</head>

<body>
<div id="header-wrapper">
	<div id="header" class="container">
		<div id="logo">
			<h1><a href="index.jsp">Phonebook</a></h1>
		</div>
	</div>
	<div id="banner" class="container">
		<div class="heading">
			<h2>Shows contact information for all your family and friends!</h2>
			<p>Keeping track of information in our daily lives can be chore.
			   Wouldn't it be nice to save all that information in one place?
		       Phonebook makes it easy to keep track of the people that matter
		       the most in your life.
		   </p>
			<a href="homePage.jsp" class="button button-inverse">Log In</a>
			&nbsp;&nbsp;&nbsp;
			<a href="signUp.jsp" class="button">Sign Up</a>
		</div>
	</div>
</div>

<div id="three-column" class="container">
	<div class="row">
		<div class="title col-sm-4">
			<h2 class="icon icon-search"></h2>
			<p>Search for people you know using their last name or unique identifier. Or, select any letter of the alphabet
			   to see all users whose last name begins with the selected letter.</p>
		</div>

		<div class="title col-sm-4">
			<h2 class="icon icon-book"></h2>
			<p>Store all your contacts in one place, so you can find who you want, when you want.</p>
		</div>

		<div class="title col-sm-4">
			<h2 class="icon icon-refresh"></h2>
			<p>Any changes your contacts make to their information is automatically updated,
			   so you no longer have to worry about making those changes yourself.</p>
		</div>
	</div>
</div>

<jsp:include page="footer.jsp" />

</body>
</html>
