<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADD CUSTOMER</title>
</head>
<body>
<form action="http://localhost:8080/JspProject/AddCustomer" method="post">
    <label>Enter First Name</label>
    <input type="text" name="firstname"><br>
    <label>Enter last Name</label>
    <input type="text" name="lastname"><br>
    <label>Enter date of birth in format</label>
    <input type='date' name="dob"><br>
    <label>Enter city</label>
    <input type="text" name="city"><br>
    <label>Enter country</label>
    <input type="text" name="country"><br>
    <label>Enter gender</label>
    <input type="radio" name="gender" value="male"><label>MALE</label>
    <input type="radio" name="gender" value="female"><label>FEMALE</label>
    <br>
    
    <input type="submit" value="Submit">
    <input type="reset" value="Reset">
</form>
</body>
</html>