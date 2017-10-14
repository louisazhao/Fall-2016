<?php 
if(isset($_SESSION['login_user']))
		header('location: browseGoods.php');
?>

<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<link rel="stylesheet" type="text/css" href="style/styleSheet2.css">
<script src="javascript/javascript1.js"></script>
</head>
<body>

<?php
session_start();
$error='';
if($_SERVER["REQUEST_METHOD"]=="POST")
{
	if(empty($_POST['username'])||empty($_POST['password']))
	{
		$error="Username or password is invalid.";
	}
    else
	{
		$username=$_POST['username'];
		$password=$_POST['password'];
		if(check($username,$password))
		{
			$_SESSION['login_user']=$username;
			header('location: browseGoods.php');
		}
		else
		{
			$error="Username or password is invalid.";
		}
	}
}//if end

 function check($data1,$data2)
	  {
		  $fn=fopen("files/login.txt","r");
		  if($fn==false)
		  {
			  echo "Problem with opening the file.";
		  }
		  
		  while(!feof($fn))
		  {
			  $line=fgets($fn);
			  list($member1,$member2)=explode(' ', "$line ");
			  if($data1==trim($member1)&&$data2==trim($member2))
			  {
				  fclose($fn);
				  return true;
			  }
		  }
		  fclose($fn);
		  return false;
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
    <h3>You have to login to browse available goods.</h3>
    <h3>Please enter your username and password:</h3>
	<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>" method="post">
	Username:<input id="name" type="text" name="username">
	<br><br>
	Password:<input id="password" type="password" name="password">
	<br><br>
	<input name="submit" type="submit" value="Login">
	<br><br>
	<?php 
		echo "<p>$error</p>";	
	?>
	
	</form>
	
</article>
<div class="footer">
<?php include 'footer.php';?>
</div>
</body>
</html>