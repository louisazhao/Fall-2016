<?php
session_start();
$confirm="";
if(session_destroy()) 
{
 $confirm="You have been loged out.";
}
?>

<!DOCTYPE html>
<html>
<head>
<title>Register</title>
<link rel="stylesheet" type="text/css" href="style/styleSheet2.css">
<script src="javascript/javascript1.js"></script>
</head>
<body>
<div class="container">
<div class="header">
<?php include 'header.php';?>
</div>
  
 <nav>
    <ul>
	   <li><a href="index.php">Home Page</a></li>
	   <li><a href="register.php">Creat an account</a></li>
	   <li><a href="login.php">Browse Available Goods</a></li>
	   <li><a href="login1.php">Have something to sell</a></li>
	   <li><a href="logout.php">Log out</a></li>
	   <li><a href="contactUs.php">Contact US</a></li>
	</ul>
</nav>

<article>
<?php 
	echo "<h3><br/><br/>$confirm<br/><br/></h3>";?>
	
</article>
<div class="footer">
<?php include 'footer.php';?>
</div>
</body>
</html>