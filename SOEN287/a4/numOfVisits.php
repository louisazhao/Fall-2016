<!DOCTYPE html>
<html>
<head>
<title>Exercise 2</title>
</head>
<body>

<?php
     $countVisit = 0;
     if(isset($_COOKIE['countVisit']))
	 {
       $countVisit = $_COOKIE['countVisit'];
       $countVisit ++;
     }

     if(isset($_COOKIE['lastVisit']))
	 {
       $lastVisit = $_COOKIE['lastVisit'];
     }

     setcookie('countVisit', $countVisit,  time()+60);
	 date_default_timezone_set("America/New_York");
     setcookie('lastVisit', date("D M d H:i:s T Y"),  time()+60);


     if($countVisit == 0)
	 {
     echo "Welcome to my webpage! It is your first time that you are here.";
     }    
     else 
	 {
     echo "Hello, this is the ".($countVisit+1). " time that you are visiting my webpage. <br/>";
     echo "Last time you visited my webpage on: ".$lastVisit;
	 }
?>



</body>
</html>