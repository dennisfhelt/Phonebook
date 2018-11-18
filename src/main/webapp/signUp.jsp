<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>Phonebook - Sign Up</title>
	<jsp:include page="headTags.jsp" />
</head>

<body>
<jsp:include page="navbar.jsp" />

<div class="container" id="signUp">
    <div class="title text-center">
        <h2>Create a New Account:</h2>
    </div>

    <form id="signUpForm" class="row" action="addUser" method="post">
		<div class="form-group col-sm-4">
			<label>*Username:</label>
			<input type="text" class="text form-control" name="username" required="required" />
		</div>
		<div class="form-group col-sm-4">
			<label for="Password">*Password:</label>
			<input type="password" class="text form-control" name="password" />
		</div>
		<div class="form-group col-sm-4">
			<label for="confirmPassword">*Confirm Password:</label>
			<input type="password" class="text form-control" name="confirmPassword" />
		</div>
		<hr />
		<div class="form-group col-sm-6">
			<label for="firstName">*First Name:</label>
	        <input type="text" class="text form-control" name="firstName" required="required" />
		</div>
		<div class="form-group col-sm-6">
			<label for="lastName">*Last Name:</label>
        	<input type="text" class="text form-control" name="lastName" required="required" />
		</div>
		<div class="form-group col-sm-12">
			<label for="Address">*Street Address:</label>
	        <input type="text" class="text form-control" name="address" required="required" />
		</div>
		<div class="form-group col-sm-4">
			<label for="city">*City:</label>
        	<input type="text" class="text form-control" name="city" required="required" />
		</div>
		<div class="form-group col-sm-4">
			<label for="state">*State:</label>
			<select name="state" class="select">
				<option value="none">Select State</option>
				<option value="Alabama">Alabama</option>
				<option value="Alaska">Alaska</option>
				<option value="Arizona">Arizona</option>
				<option value="Arkansas">Arkansas</option>
				<option value="California">California</option>
				<option value="Colorado">Colorado</option>
				<option value="Connecticut">Connecticut</option>
				<option value="Delaware">Delaware</option>
				<option value="Florida">Florida</option>
				<option value="Georgia">Georgia</option>
				<option value="Hawaii">Hawaii</option>
				<option value="Idaho">Idaho</option>
				<option value="Illinois">Illinois</option>
				<option value="Indiana">Indiana</option>
				<option value="Iowa">Iowa</option>
				<option value="Kansas">Kansas</option>
				<option value="Kentucky">Kentucky</option>
				<option value="Louisiana">Louisiana</option>
				<option value="Maine">Maine</option>
				<option value="Maryland">Maryland</option>
				<option value="Massachusetts">Massachusetts</option>
				<option value="Michigan">Michigan</option>
				<option value="Minnesota">Minnesota</option>
				<option value="Mississippi">Mississippi</option>
				<option value="Missouri">Missouri</option>
				<option value="Montana">Montana</option>
				<option value="Nebraska">Nebraska</option>
				<option value="Nevada">Nevada</option>
				<option value="New Hampshire">New Hampshire</option>
				<option value="New Jersey">New Jersey</option>
				<option value="New Mexico">New Mexico</option>
				<option value="New York">New York</option>
				<option value="North Carolina">North Carolina</option>
				<option value="North Dakota">North Dakota</option>
				<option value="Ohio">Ohio</option>
				<option value="Oklahoma">Oklahoma</option>
				<option value="Oregon">Oregon</option>
				<option value="Pennsylvania">Pennsylvania</option>
				<option value="Rhode Island">Rhode Island</option>
				<option value="South Carolina">South Carolina</option>
				<option value="South Dakota">South Dakota</option>
				<option value="Tennessee">Tennessee</option>
				<option value="Texas">Texas</option>
				<option value="Utah">Utah</option>
				<option value="Vermont">Vermont</option>
				<option value="Virginia">Virginia</option>
				<option value="Washington">Washington</option>
				<option value="West Virginia">West Virginia</option>
				<option value="Wisconsin">Wisconsin</option>
				<option value="Wyoming">Wyoming</option>
			</select>
		</div>
		<div class="form-group col-sm-4">
			<label for="zipCode">*Zip Code:</label>
        	<input type="text" class="text form-control" name="zipCode" required="required" />
		</div>
		<div class="form-group col-sm-4">
			<label for="homeNumber">&nbsp;Home Phone:</label>
        	<input type="text" class="text form-control" name="homeNumber" placeholder="###-###-####" />
		</div>
		<div class="form-group col-sm-4">
			<label for="cellNumber">&nbsp;Cell Number:</label>
        	<input type="text" class="text form-control" name="cellNumber" placeholder="###-###-####" />
		</div>
		<div class="form-group col-sm-4">
			<label for="workNumber">&nbsp;Work Number:</label>
        	<input type="text" class="text form-control" name="workNumber" placeholder="###-###-####" />
		</div>

		<div class="form-group col-sm-12">
			<label for="Email">*Email:</label>
        	<input type="text" class="text form-control" name="email" required="required" />
		</div>
		<div class="form-group col-sm-12">
        	<input type="submit" class="button btn-block" name="submit" value="Create Account" />
		</div>
    </form>
</div>

<jsp:include page="footer.jsp" />

</body>
</html>
