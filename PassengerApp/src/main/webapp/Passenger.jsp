<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Passenger Search Engine</title>
<style>
input[type=text] {
    width: 15%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}
p {
    width: 12%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}
input[type=button] {
    width: 10%;
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=button]:hover {
    background-color: #45a049;
}

div {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
}
</style>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    $('#searchPassenger').click(function() {
    	 var ticketNo = $('#ticketNbr').val();
            	$.ajax({
            	type:'GET',
            	datatype:'json',
            	url: 'http://localhost:8080/PassengerApp/passengers/get?ticketNumber='+ticketNo,
            	success: function (result){ 
            			 var myObj = JSON.parse(result);
            			 document.getElementById("ticket").value = myObj.ticketNumber;
            			 document.getElementById("firstN").value = myObj.firstName;
            			 document.getElementById("lastN").value = myObj.lastName;
            			 document.getElementById("passN").value = myObj.passportNumber;
            			 document.getElementById("seatN").value = myObj.seatNumber;
            			 document.getElementById("mealT").value = myObj.mealType;
            			 document.getElementById("passengerGender").value = myObj.gender;
            			 document.getElementById("passengerAge").value = myObj.age;
            			 $("#passengerDetails").css("display", "block");
              }
          });
    });
    
    $('#editPass').click(function() {
   	 var ticket = $('#ticket').val();
   	 var pass=$('#passN').val();
   	       	$.ajax({
           	type:'POST',
           	data:{passportNumber:pass},
           	headers: { 'passportNumber': pass},
           	datatype:'json',
           	url: 'http://localhost:8080/PassengerApp/passengers/update/'+ticket,
           	success: function (result){ 
           			 var myObj = JSON.parse(result);
           			 document.getElementById("ticket").value = myObj.ticketNumber;
           			 document.getElementById("firstN").value = myObj.firstName;
           			 document.getElementById("lastN").value = myObj.lastName;
           			 document.getElementById("passN").value = myObj.passportNumber;
           			 document.getElementById("seatN").value = myObj.seatNumber;
           			 document.getElementById("mealT").value = myObj.mealType;
           			 document.getElementById("passengerGender").value = myObj.gender;
           			 document.getElementById("passengerAge").value = myObj.age;
           		        }
         });
   });
    $('#editSeat').click(function() {
   	 var ticket = $('#ticket').val();
   	 var seat=$('#seatN').val();
   	       	$.ajax({
           	type:'POST',
           	data:{seatNumber:seat},
           	headers: { 'seatNumber': seat},
           	datatype:'json',
           	url: 'http://localhost:8080/PassengerApp/passengers/update/'+ticket,
           	success: function (result){ 
           			 var myObj = JSON.parse(result);
           			 document.getElementById("ticket").value = myObj.ticketNumber;
           			 document.getElementById("firstN").value = myObj.firstName;
           			 document.getElementById("lastN").value = myObj.lastName;
           			 document.getElementById("passN").value = myObj.passportNumber;
           			 document.getElementById("seatN").value = myObj.seatNumber;
           			 document.getElementById("mealT").value = myObj.mealType;
           			 document.getElementById("passengerGender").value = myObj.gender;
           			 document.getElementById("passengerAge").value = myObj.age;
           		        }
         });
   });
    $('#editMeal').click(function() {
   	 var ticket = $('#ticket').val();
   	 var meal=$('#mealT').val();
   	       	$.ajax({
           	type:'POST',
           	data:{mealType:meal},
           	headers: { 'mealType': meal},
           	url: 'http://localhost:8080/PassengerApp/passengers/update/'+ticket,
           	datatype:'json',
           	success: function (result){ 
           			 var myObj = JSON.parse(result);
           			 document.getElementById("ticket").value = myObj.ticketNumber;
           			 document.getElementById("firstN").value = myObj.firstName;
           			 document.getElementById("lastN").value = myObj.lastName;
           			 document.getElementById("passN").value = myObj.passportNumber;
           			 document.getElementById("seatN").value = myObj.seatNumber;
           			 document.getElementById("mealT").value = myObj.mealType;
           			 document.getElementById("passengerGender").value = myObj.gender;
           			 document.getElementById("passengerAge").value = myObj.age;
           		        }
         });
   });
});
</script>
</head>
<body>
<h1>Welcome to Search Passenger</h1>
<div id="searchPass">
<p>Ticket Number :</p> <input type="text" id="ticketNbr">
<input type="button" value="Search Passenger" id="searchPassenger"/>
</div>

<div id="passengerDetails" style="display: none;">
<p>Ticket Number : </p><input width ="20" type="text" id="ticket" readonly/><br/>
<p>First Name : </p><input width ="20" type="text" id="firstN" readonly/><br/>
<p>Last Name : </p><input width ="20" type="text" id="lastN" readonly/><br/>
<p>Gender : </p><input width ="20" type="text" id="passengerGender" readonly/><br/>
<p>Age : </p><input width ="20" type="text" id="passengerAge" readonly/><br/>
<p>Passport Number : </p><input width ="20" type="text" id="passN"/>&nbsp;<input type="button" value="Edit Passport Number" id="editPass"/><br/>
<p>Seat Number : </p><input width ="20" type="text" id="seatN"/>&nbsp;<input type="button" value="Edit Seat Number" id="editSeat"/><br/>
<p>Meal Type : </p><input width ="20" type="text" id="mealT"/>&nbsp;<input type="button" value="Edit Meal Type" id="editMeal"/><br/>
</div>
</body>
</html>