<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Phonebook - Home</title>
    <jsp:include page="headTags.jsp" />
</head>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="userNavbar.jsp" />

<body>
<div class="container">
    <div class="title text-center">
        <h2>Welcome!</h2>
    </div>

<h3>Please enter a Value for REST service</h3>
<form action="edu/matc/controller/users" method="post">
    <input type="radio" name="searchCriteria" value="lastName">Last Name
    <input type="radio" name="searchCriteria" value="id">id<br>
    <input type="text" name="value"/><br/><br/>
    <input type="submit" value="REST service"/>
</form>
</div>


<jsp:include page="footer.jsp" />
</body>

</html>