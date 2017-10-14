<!DOCTYPE html>
<html>
<head>
<title>Have something to sell</title>
<link rel="stylesheet" type="text/css" href="style/styleSheet2.css">
<script src="javascript/javascript1.js"></script>
</head>

<body>

<?php
$firstName="";
$lastName="";
$email="";
$classification="";
$price="";
$location="";
$description="";
$result="";

if($_SERVER["REQUEST_METHOD"]=="POST")
    {
	  if($_POST["firstName"]==""||$_POST["lastName"]==""||$_POST["email"]==""||
	  $_POST["Classification"]==""||$_POST["price"]==""||$_POST["area"]==""||$_POST["Description"]==""
	  ||(!preg_match("/[\w._%+-]+@[\w.-]+\.[\w]{2,}/",$_POST["email"])))
	  {
		  $result="The information you entered does not meet our requirement, please try again.";
	  }
	  else
	  {
		  $firstName=$_POST["firstName"];
	      $lastName=$_POST["lastName"];
	      $email=$_POST["email"];
	      $classification=$_POST["Classification"];
	      $price=$_POST["price"];
	      $location=$_POST["area"];
	      $description=$_POST["Description"];
	      $fn=fopen("files/information.txt","a+");
		  if($fn==false)
		  {
			  echo "Problem with opening the file.";
		  }
	      fwrite($fn,$firstName." ".$lastName." ".$email." ".$classification." ".$price." ".$location.PHP_EOL);
	      fwrite($fn,$description.PHP_EOL);
          fclose($fn);	
	      $result="Your goods has been saved.";
	  }
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
  <h3>Having something to sell? Please complete the following fields:</h3>
  <form name="myForm" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>" method="post">
     <p></p>
     <table>
	    <tr>
		    <td>Please enter your name:</td>
			<td>
			    <label>First name</label>
				<input type="text" name="firstName">
		    </td>
		</tr>
		<tr>
		    <td></td>
		    <td>
		    <label>Last name</label>
				<input type="text" name="lastName">
		    </td>
		</tr>
   
        <tr>
            <td>Email address:</td>
            <td colspan="2">
                <input type="text" name="email">
           </td>
        </tr>		
  
        <tr>
		    <td>Classification of the goods:</td>
			<td>
			   <select name="Classification">
			       <option value="Electronic appliance">Electronic appliance</option>
				   <option value="Women's clothes">Women's clothes</option>
				   <option value="Men's clothes">Men's clothes</option>
				   <option value="children's clothes">Children's clothes</option>
				   <option value="Funiture">Furniture</option>
				   <option value="Cellphone">Cellphone</option>
				   <option value="Computer">Computer&Laptop</option>
			   </select>
			</td>
		</tr>
		
		<tr>
		    <td>The price that you want to sell for:</td>
			<td colspan="2">
			   <input type="text" name="price">
		    </td>
		</tr>
		
		<tr>
		   <td>Please choose your location:</td>
		   <td>
		       <select name="area">
			       <option value="Ahuntsic-Cartierville">Ahuntsic-Cartierville</option>
				   <option value="Anjou">Anjou</option>
				   <option value="CDN&NDG">CDN & NDG</option>
				   <option value="Lachine">Lachine</option>
				   <option value="Lasalle">Lasalle</option>
				   <option value="Le Plateau">Le Plateau-Mont-Royal</option>
				   <option value="Le sud-Ouest">Le Sud-Ouest</option>
				   <option value="West Island">West Island</option>
				   <option value="South shore">South Shore</option>
				   <option value="Centre">Centre ville</option>
			   </select>
			</td>
		</tr>
		
		<tr>
		    <td colspan="3">Please describe your goods briefly: </td>
		</tr>
	</table>
		
		   <p>
		   <textarea name="Description" placeholder="Please describe your goods briefly:"></textarea>
	       </p>
   
	<p></p>
	<input type="submit"  onclick="validateForm()" value="Submit">
	<input type="reset" value="Reset">
	<?php 
		echo "<br/><br/><h3>$result</h3><br/><br/>";	
	?>
	
</form>
</article>

<div class="footer">
<?php include 'footer.php';?>
</div>
</body>

</html>
		 