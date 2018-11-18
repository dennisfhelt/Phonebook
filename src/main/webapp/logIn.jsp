<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Phonebook - Log In</title>
    <jsp:include page="headTags.jsp" />
</head>

<body>
<jsp:include page="navbar.jsp" />

<div class="container" id="logIn">
    <div class="title text-center">
        <h2>Log In:</h2>
    </div>

    <form id="logInForm" class="row" action="j_security_check" method="post">
        <div class="form-group col-sm-12">
            <label>Username:</label>
            <input type="text" class="text form-control" name="j_username" required="required" />
        </div>
        <div class="form-group col-sm-12">
            <label>Password:</label>
            <input type="password" class="text form-control" name="j_password" required="required" />
        </div>
        <div class="form-group col-sm-12">
            <input type="submit" class="button btn-block" name="submit" value="Log In" />
        </div>
    </form>
</div>

<jsp:include page="footer.jsp" />

</body>
</html>
