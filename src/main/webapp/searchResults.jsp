<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <style>
        body {
            background-color: #333;
            color :white;
            padding: 1em;
            text-align: center;
        }
        h1 {
            color: #F3CD52;
        }
        #error {
            color: red;
            font-size: 1.5em;
        }
        th {
            font-size: 1.5em;
        }
    </style>
</head>

<body class="container">

    <br /><br />
    <h1>Search Results:</h1>
    <a href="homePage.jsp">&lt;Back to Search</a>
    <br /><br />

    <p class="errorMessage">${errorMessage}</p>
    <c:remove var="errorMessage" />

    <c:choose>
        <c:when test="${user!=null}">
            <tr>
                <th>Id</th>
                <th>First Name</th>
                <th>Last Name</th>
            </tr>
            <tr>
                <td>${user.id}</td>
                <td>${user.firstName} </td>
                <td>${user.lastName}</td>
            </tr>
        </c:when>

        <c:otherwise>
            <table class="table table-borderless">
                <tr>
                    <th>Id</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                </tr>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>

</body>
</html>
