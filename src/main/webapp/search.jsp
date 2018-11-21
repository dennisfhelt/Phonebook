<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Phonebook - Home</title>
    <jsp:include page="headTags.jsp" />
</head>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
<jsp:include page="userNavbar.jsp" />
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
<div class="container">
    <div class="title text-center">
        <h2>Search Profiles</h2>
    </div>
</div>

<h3>Please enter User ID to search or View all.</h3>
<form action="searchUser">
    <input type="text" id="searchTerm" name="searchTerm">

    <button type="submit" name="submit" value="search">Search</button>
    <button type="submit" name="submit" value="viewAll">View All</button>
</form>



<jsp:include page="footer.jsp" />
</body>

</html>