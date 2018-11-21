<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Phonebook - Home</title>
    <jsp:include page="headTags.jsp" />
</head>

<body>
<jsp:include page="userNavbar.jsp" />

<div class="container">
    <div class="title text-center">
        <h2>Welcome!</h2>
        <hr /><br />
    </div>

    <div class="row">
        <div class="col-sm-1"></div>
        <div id="initialNav" class="col-sm-1 bg-yellow rounded">
            <nav class="navbar">
                <ul class="navbar-nav w-100">
                    <li class="nav-item text-center">
                        <a class="nav-link font-weight-bold" href="application/users?initial=A">A</a>
                        <a class="nav-link font-weight-bold" href="application/users?initial=B">B</a>
                        <a class="nav-link font-weight-bold" href="application/users?initial=C">C</a>
                        <a class="nav-link font-weight-bold" href="application/users?initial=D">D</a>
                        <a class="nav-link font-weight-bold" href="application/users?initial=E">E</a>
                        <a class="nav-link font-weight-bold" href="application/users?initial=F">F</a>
                        <a class="nav-link font-weight-bold" href="application/users?initial=G">G</a>
                        <a class="nav-link font-weight-bold" href="application/users?initial=H">H</a>
                        <a class="nav-link font-weight-bold" href="application/users?initial=I">I</a>
                        <a class="nav-link font-weight-bold" href="application/users?initial=J">J</a>
                        <a class="nav-link font-weight-bold" href="application/users?initial=K">K</a>
                        <a class="nav-link font-weight-bold" href="application/users?initial=L">L</a>
                        <a class="nav-link font-weight-bold" href="application/users?initial=M">M</a>
                        <a class="nav-link font-weight-bold" href="application/users?initial=N">N</a>
                        <a class="nav-link font-weight-bold" href="application/users?initial=O">O</a>
                        <a class="nav-link font-weight-bold" href="application/users?initial=P">P</a>
                        <a class="nav-link font-weight-bold" href="application/users?initial=Q">Q</a>
                        <a class="nav-link font-weight-bold" href="application/users?initial=R">R</a>
                        <a class="nav-link font-weight-bold" href="application/users?initial=S">S</a>
                        <a class="nav-link font-weight-bold" href="application/users?initial=T">T</a>
                        <a class="nav-link font-weight-bold" href="application/users?initial=U">U</a>
                        <a class="nav-link font-weight-bold" href="application/users?initial=V">V</a>
                        <a class="nav-link font-weight-bold" href="application/users?initial=W">W</a>
                        <a class="nav-link font-weight-bold" href="application/users?initial=X">X</a>
                        <a class="nav-link font-weight-bold" href="application/users?initial=Y">Y</a>
                        <a class="nav-link font-weight-bold" href="application/users?initial=Z">Z</a>
                    </li>
                </ul>
            </nav>
        </div>

        <div class="col-sm-1"></div>

        <div class="col-sm-6 text-center">
            <h3>To use this REST service:</h3>
            <br />

            <h5>Select a letter to view all the phone numbers and addresses of users whose last name begins
                with the selected letter.
                <br />
                Or enter the last name / id below to find a specific
                user.</h5>
            <br />
            <form action="application/json" method="post">
                <input type="text" class="text form-control" name="value" required="required" />

                <div class="form-check-inline">
                    <label class="form-check-label">
                        <input type="radio" class="form-check-input" name="searchCriteria" value="lastName" />Last Name
                    </label>
                </div>
                &nbsp;&nbsp;&nbsp;
                <div class="form-check-inline">
                    <label class="form-check-label">
                        <input type="radio" class="form-check-input" name="searchCriteria" value="id" />Id
                    </label>
                </div>

                <br />
                <input type="submit" class="button" value="REST service" />
            </form>
            <a href="JSONSearch.jsp"><p>Click Here for JSON</p></a>
        </div>


    </div>
</div>

<br /><br /><br />
<jsp:include page="footer.jsp" />
</body>

</html>