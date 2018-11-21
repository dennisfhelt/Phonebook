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
    <title>Phonebook - User Guide</title>
    <jsp:include page="headTags.jsp" />
</head>

<body>
<jsp:include page="userNavbar.jsp" />
<br /><br /><br />

<div class="container">

    <div class="row">
        <div class="col-sm-2"></div>

        <div style="padding:1.5em;" class="col-sm-8 bg-yellow rounded">
            <h1 class="text-center">How this application works:</h1>
            <br /><br />

            <ul>
                <li>You can use this Phonebook application which consumes our REST services to produce either plain text, HTML, or JSON.</li>
                <br />
                <li>The vertical navbar has a link for each letter of the alphabet and will send a GET request with a parameter
                    of the selected letter. This GET request will pull all the users whose last name begins with that letter, and
                    display their first name, last name, address, city, state, and zip code as an HTML table.</li>
                <br />
                <li>The form located in the home page will allow you to enter either a users id or last name. This form will send
                    a POST request that display plain text containing all the contact information of the selected user. Below
                    this form is a link to a similar page that contains a separate form for producing a JSON object. Simply
                    follow this link, and complete the form the same way as the first form, and the response will send JSON
                    instead of plain text.</li>
            </ul>
        </div>

        <div class="col-sm-2"></div>
    </div>
</div>

<br /><br /><br />
<jsp:include page="footer.jsp" />

</body>
</html>
