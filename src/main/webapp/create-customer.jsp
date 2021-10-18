<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		<title>Create Customer</title>
    </head>
    <body>
		<div>
			<form action="handleCreateCustomer">
				<!-- 2 column grid layout with text inputs for the first and last names -->
				<div class="row mb-4">
					<div class="col">
						<div class="form-outline">
							<input type="text" name="firstname" class="form-control" />
							<label class="form-label" for="firstname">First name</label>
						</div>
					</div>
					<div class="col">
						<div class="form-outline">
							<input type="text" name="lastname" class="form-control" />
							<label class="form-label" for="lastname">Last name</label>
						</div>
					</div>
				</div>

				<!-- Text input -->
				<div class="form-outline mb-4">
					<input type="text" name="SortCode" class="form-control" />
					<label class="form-label" for="SortCode">Sort-code</label>
				</div>

				<!-- Number input -->
				<div class="form-outline mb-4">
					<input type="number" name="CustomerID" class="form-control" />
					<label class="form-label" for="CustomerID">Customer Id</label>
				</div>

				<!-- Number input -->
				<div class="form-outline mb-4">
					<input type="number" name="Balance" class="form-control" />
					<label class="form-label" for="Balance">Balance</label>
				</div>

				<!-- Submit button -->
				<button name="createAccountButton" value="1" type="submit" class="btn btn-primary btn-block mb-4">Create Customer</button>
				<button name="reset" type="reset" class="btn btn-primary btn-block mb-4">Reset</button>
			</form>
		</div>
	</body>
</html>
