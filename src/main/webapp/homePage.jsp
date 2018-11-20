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
                        <a class="nav-link font-weight-bold" href="#">J</a>
                        <a class="nav-link font-weight-bold" href="#">K</a>
                        <a class="nav-link font-weight-bold" href="#">L</a>
                        <a class="nav-link font-weight-bold" href="#">M</a>
                        <a class="nav-link font-weight-bold" href="#">N</a>
                        <a class="nav-link font-weight-bold" href="#">O</a>
                        <a class="nav-link font-weight-bold" href="#">P</a>
                        <a class="nav-link font-weight-bold" href="#">Q</a>
                        <a class="nav-link font-weight-bold" href="#">R</a>
                        <a class="nav-link font-weight-bold" href="#">S</a>
                        <a class="nav-link font-weight-bold" href="#">T</a>
                        <a class="nav-link font-weight-bold" href="#">U</a>
                        <a class="nav-link font-weight-bold" href="#">V</a>
                        <a class="nav-link font-weight-bold" href="#">W</a>
                        <a class="nav-link font-weight-bold" href="#">X</a>
                        <a class="nav-link font-weight-bold" href="#">Y</a>
                        <a class="nav-link font-weight-bold" href="#">Z</a>
                    </li>
                </ul>
            </nav>
        </div>

        <div class="col-sm-1"></div>

        <div class="col-sm-6 text-center">
            <h3>To use this REST service:</h3>
            <br />

            <h5>Select a letter to view all users whose last name begins
                with the selected letter.
                <br />
                Or enter the last name / id below to find a specific
                user.</h5>
            <br />
            <form action="application/users" method="post">
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
        </div>

        <div class="col-sm-3"></div>
    </div>

    <h3>Please Select a REST service</h3>
    <a href="JSONSearch.jsp"><p>Click Here for JSON</p></a>
    <form id="restServiceForm" class="row" action="application/text" method="post">
        <div class="form-group col-sm-9">
            <label for="searchCriteria">Search By Field:</label>
            <input type="radio" name="searchCriteria" id="lastName" value="lastName" checked="checked">
            <span>Last Name</span>
            <input type="radio" name="searchCriteria" id="id" value="id"><span>ID</span><br>
        </div>
        <div class="form-group col-sm-12">
            <label>Search Value:</label>
            <input type="text" class="text form-control" name="value"  />
        </div>
        <input type="submit" value="REST service"/><br><br>
    </form>
</div>

<br /><br /><br />
<jsp:include page="footer.jsp" />
</body>

</html>