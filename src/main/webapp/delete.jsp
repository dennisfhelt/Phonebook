<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>Phonebook - Sign Up</title>
	<jsp:include page="headTags.jsp" />
</head>

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
<div class="container" id="signUp">
    <div class="title text-center">
        <h2>Delete a User:</h2>
		<p class="errorMessage">${errorMessage}</p>
		<c:remove var="errorMessage" />
    </div>

    <form id="delete" class="row" action="deleteUser" method="post">
		<div class="form-group col-sm-4">
			<label>*ID:</label>
			<input type="text" class="text form-control" name="id" required="required" />
		</div>
		<div class="form-group col-sm-6">
			<label for="firstName">*First Name:</label>
	        <input type="text" class="text form-control" name="firstName" required="required" />
		</div>
		<div class="form-group col-sm-6">
			<label for="lastName">*Last Name:</label>
        	<input type="text" class="text form-control" name="lastName" required="required" />
		</div>

		<div class="form-group col-sm-12">
        	<input type="submit" class="button btn-block" name="submit" value="delete" />
		</div>
    </form>
</div>

<jsp:include page="footer.jsp" />

</body>
</html>
