<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Phonebook - Home</title>
    <jsp:include page="headTags.jsp" />
</head>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="userNavbar.jsp" />

<div class="container">
    <div class="title text-center">
        <h2>Welcome!</h2>
    </div>
</div>
<body>
<h2>PhoneBook, the app</h2>

<p>Sign in or Sign up to view all of our user</p>
<form action="searchUser">
    <input type="text" id="searchTerm" name="searchTerm">

    <button type="submit" name="submit" value="search">Search</button>
    <button type="submit" name="submit" value="viewAll">View All</button>
</form>

<c:choose>
    <c:when test="${user!=null}">
        <th> Total Users: </th>
        <tr>
            <td>${user.firstName} ${user.lastName}</td>
        </tr>
    </c:when>
    <c:otherwise>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.firstName} ${user.lastName}</td>
            </tr>
        </c:forEach>
    </c:otherwise>
</c:choose>
<c:choose>
    <c:when test="${location!=null}">
        <th> Total Users: </th>
        <tr>
            <td>${location.streetAddress} ${location.city}</td>
        </tr>
    </c:when>
    <c:otherwise>
        <c:forEach var="location" items="${locations}">
            <tr>
                <td>${location.streetAddress} ${location.city} ${location.state} ${location.statePostal}</td>
            </tr>
        </c:forEach>
    </c:otherwise>
</c:choose>

<!--c:choose>
    c:when test="$number!=null}">
        <th> Total Users: </th>
        <tr>
            <td>$number.number} </td>
        </tr>
    /c:when>
    c:otherwise>
        c:forEach var="number" items="$numbers}">
            <tr>
                <td>$number.number} </td>
            </tr>
        /c:forEach>
    /c:otherwise>
/c:choose>
-->

<form action="edu/matc/controller/application/users/id" method="post">
    Enter Id:<input type="text" name="id"/><br/><br/>
    <input type="submit" value="REST service"/>
</form>



<jsp:include page="footer.jsp" />
</body>

</html>