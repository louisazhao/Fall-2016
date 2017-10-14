<!DOCTYPE html>
<html>
<head>
<title>Register</title>
<link rel="stylesheet" type="text/css" href="style/styleSheet2.css">
<script src="javascript/javascript1.js"></script>
</head>
<body>

<?php
$usernameErr="";
$passwordErr="";
$username="";
$password="";
$pair="";
$result="";


if($_SERVER["REQUEST_METHOD"]=="POST")
    {
	  if($_POST["username"]=="")
	  {
		  $usernameErr="Username is required";
	  }
	  else
	  {
		  $username=$_POST["username"];
		  if(!preg_match("/^[a-zA-Z0-9]*$/",$username))
		  {
			  $username=false;
			  $usernameErr="Only letters and digits allowed.";

		  }
		  else
		  {
			  if(ifExist($username))
			  $username=false;
			  $usernameErr="Username already exist, please try another one.";
		  }
	  }
	  
	  if (empty($_POST["password"]))
      {
		$password=false;
		$passwordErr="Password required.";
	  } 
	  else
	  {
	    $password=$_POST["password"];
		if(!preg_match("/^(?=.*[0-9])(?=.*[a-zA-Z])[0-9a-zA-Z]{4,}/",$password))
			{
				$password=false;
				$passwordErr="Password does not match the requried format.";
			}
	  }
	  if($username!=false&&$password!=false)
	  {
	  writeToFile($username,$password); 
	  $result="Your account has been created, your username is ".$username;
	  }
	} 
	  
	  function ifExist($data)
	  {
		  $fn=fopen("files/login.txt","r");
		  if($fn==false)
		  {
			  echo "Problem with opening the file.";
		  }
		  
		  while(!feof($fn))
		  {
			  $line=fgets($fn);
			  $members=explode(" ", $line);
			  if($data==$members[0])
			  {
				  fclose($fn);
				  return true;
			  }
		  }
		  fclose($fn);
		  return false;
	  }
	  
	 function writeToFile($name,$value)
	 {
		  $fn=fopen("files/login.txt","a+");
		  if($fn==false)
		  {
			  echo "Problem with opening the file.";
		  }
		  $pair[$name]=$value;
		  fwrite($fn,$name." ".$value.PHP_EOL);
          fclose($fn);		  
	 }
?>


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
    <h3>Please enter your username and password:</h3>
	<p> * Your username can only contain letters and digits; your password should 
	be at least 4 characters long (with letters and digits only), have at least one letter and at least one digit.</p>
	<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>" method="post">
	Username:<input type="text" name="username">
	<span class="error">*<?php echo $usernameErr;?></span>
	<br><br>
	Password:<input type="password" name="password">
	<span class="error">*<?php echo $passwordErr;?></span>
	<br><br>
	<input type="submit" value="Register">
	<br><br>
	<?php 
	echo "<h3>$result</h3>";?>
	
	</form>
	
</article>
<div class="footer">
<?php include 'footer.php';?>
</div>
</body>
</html>