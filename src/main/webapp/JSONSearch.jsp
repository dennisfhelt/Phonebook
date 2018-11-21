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
    </div>

    <h3>Please Select a REST service</h3>
    <a href="homePage.jsp"><p>Click Here for Plain Text</p></a>
    <form id="restServiceForm" class="row" action="application/json" method="post">
        <div class="form-group col-sm-9">
            <label for="lastName">Last Name</label>
            <input type="radio" name="searchCriteria" id="lastName" value="lastName" checked="checked">
            <label for="id">Id:</label>
            <input type="radio" name="searchCriteria" id="id" value="id"><br>
        </div>
        <div class="form-group col-sm-12">
            <label>Search Value:</label>
            <input type="text" class="text form-control" name="value" />
        </div>
        <input type="submit" value="REST service"/><br><br>
    </form>
</div>

<jsp:include page="footer.jsp" />
</body>

</html>