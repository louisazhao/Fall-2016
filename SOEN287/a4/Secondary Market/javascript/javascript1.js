window.onload=function timer(){
	var d=new Date()
	var hours=d.getHours()
	var minutes=d.getMinutes()
	var sec=d.getSeconds()
	var date=d.getDate()
	var months=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"]
	var month=months[d.getMonth()];
	if(minutes<10)
	{
		minutes="0"+minutes;
	}
	if(sec<10)
	{
		sec="0"+sec;
	}
	if(date<10)
	{
		date="0"+date;
	}
	var display=hours+":"+minutes+":"+sec+" "+month+" "+date;
	document.getElementById("time_span").innerHTML=display;
	setTimeout(timer,1000);
}

function validateForm()
{
	if(document.myForm.firstName.value=="")
		alert("You must enter your first name in order to continue.");
	if(document.myForm.lastName.value=="")
		alert("You must enter your last name in order to continue.");
	if(document.myForm.email.value=="")
		alert("You must enter your email in order to continue.");
	if(document.myForm.Classification.value=="")
		alert("You must choose a classification.");
	if(document.myForm.price.value=="")
		alert("You must enter the price in order to continue.");
	if(document.myForm.location.value="")
		alert("You must choose your location.");
	if(document.myForm.Description.value=="")
		alert("You must enter some descriptions for your goods.");
	var x=document.myForm.email.value;
	var pattern=/[\w._%+-]+@[\w.-]+\.[\w]{2,}/
	var result=pattern.test(x);
	if (result==false)
		alert("Not a valid email address");
	return false;
}
