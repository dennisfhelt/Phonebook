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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Phonebook - Sign Up</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href='http://fonts.googleapis.com/css?family=Pontano+Sans' rel='stylesheet' type='text/css' />
<link href="css/default.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/fonts.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/phonebook.css" rel="stylesheet" type="text/css" media="all" />


</head>
<body>
<div id="header-wrapper">
	<nav class="container navbar">
        <a href="index.jsp" class="nav-link-home">Phonebook</a>
        <a href="logIn.jsp" class="nav-link">Log In</a>
        <a href="signUp.jsp" class="nav-link">Sign Up</a>
    </nav>
</div>

<div class="container" id="signUp">
    <div class="title">
        <h2>Create a New Account:</h2>
    </div>

    <form id="signUpForm" action="index.jsp" method="post">
        <input type="text" class="text" name="firstName" placeholder="*First Name" />
        <input type="text" class="text" name="lastName" placeholder="*Last Name" />

        <input type="text" class="text" name="address" placeholder="*Street Address" />
        <input type="text" class="text" name="city" placeholder="*City" />
        <input type="text" class="text" name="state" placeholder="*State" />
        <input type="text" class="text" name="zipCode" placeholder="*Zip Code" />

        <input type="text" class="text" name="homeNumber" placeholder="Home Number" />
        <input type="text" class="text" name="cellNumber" placeholder="Cell Number" />

        <input type="text" class="text" name="email" placeholder="*Email Address" />

        <input type="password" class="text" name="password" placeholder="*Password" />
        <input type="password" class="text" name="confirmPassword" placeholder="*Confirm Password" />

        <input type="submit" class="button" name="submit" value="Create Account" />
    </form>
</div>



<div id="copyright" class="container">
	<p>&copy;Phonebook All rights reserved. | Photos by <a href="http://fotogrph.com/">Fotogrph</a> | Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a>.</p>
</div>
</body>
</html>
