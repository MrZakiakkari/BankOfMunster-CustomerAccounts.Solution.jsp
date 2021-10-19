<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adjust Customer Balance</title>
    </head>
    <body>
        <h1>Account Adjust</h1>
        <h1>Drill Down on ${account.accountNumber}</h1>
		<form name="adjustBalance" action="HandleAdjustAccount">
			<input type="hidden" name="accountNumber" value="${account.accountNumber}">
			<table width='200' >
				<tr><td>Account ID</td><td>${account.accountNumber}</td></tr>
				<tr><td>First Name</td><td><input type="text" name="firstName" value="${account.firstName}" /></td></tr>
				<tr><td>Last Name</td><td><input type="text" name="lastName" value="${account.lastName}" /></td></tr>
				<tr><td>Sort Code</td><td><input type="text" name="sortCode" value="${account.sortCode}" /></td></tr>
				<tr><td>Balance</td><td><input type="number" name="balance" value="${account.balance}" /></td></tr>
			</table>
			<button type="submit" value="Update" name="updateButton">Update</button>

		</form>
		<a href="index.jsp">Home</a>
    </body>
</html>
