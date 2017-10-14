<!DOCTYPE html>
<html>
<head>
<title>Browse </title>
<link rel="stylesheet" type="text/css" href="style/styleSheet3.css">
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
  <h3>Please choose the secondary good that you are interested in.</h3>
  <ul>
  <li>
    <div class="imageContainer">
	<image class="images" src="image/bike.JPG" alt="bike on sale"/>
	</div>
	<div class="information">
	  <table class="info">
	  <tr spans="2">
	  <th>Bike Giant 2015
	  </tr>
	  <tr>
	    <th>Date Listed</th>
	    <td>07-NOV-16</td>
	  </tr>
	  <tr>
	    <th>Price</th>
	    <td>$500</td>
	  </tr>
	  <tr>
	    <th>Address</th>
		<td>CDN-NDG</td>
	  </tr>
	  <tr>
	    <th>Sold by</th>
		<td>Peter Johnson</td>
	  </tr>
	  <tr>
	    <th>Seller's email</th>
		<td>peterJohnson@hotmail.com</td>
	  </tr>
	  </table>
	</div>
	<div class="userContent">
	<p>
	   Excellent custom built folding road bike on sale. Comes with: 
	   - 26in disc wheels (DT Swiss XR 1501 front and Mavic XC 717 Disc with Shimano Acera 8 speed shifter) 
	   - TRP hydraulic disc brakes 
	   - Carbon Disc Fork from Trigon and carbon stem 
	   - San Marco saddle 
	   - Fit for someone who is at most 6ft tall 
	   - Schwalbe Durano Pro 26x1.1 tires 
	   Price is negotiable within reason</p>
	</div>
	</li>
	<li>
    <div class="imageContainer">
	<image class="images" src="image/computer.JPG" alt="bike on sale"/>
	</div>
	<div class="information">
	  <table class="info">
	   <tr spans="2">
	  <th>iMac 27'
	  </tr>
	  <tr>
	    <th>Date Listed</th>
	    <td>07-OCT-16</td>
	  </tr>
	  <tr>
	    <th>Price</th>
	    <td>$1500</td>
	  </tr>
	  <tr>
	    <th>Address</th>
		<td>Lasalle</td>
	  </tr>
	  <tr>
	    <th>Sold by</th>
		<td>Kim Witson</td>
	  </tr>
	  <tr>
	    <th>Seller's email</th>
		<td>kimwitson@hotmail.com</td>
	  </tr>
	  </table>
	</div>
	<div class="userContent">
	<p>iMac Core 2 Duo 20' CPU intelCore 2 Duo Memory 4GB 
	Disque Dur Sata 250 GB Wifi Webcam </p>
	</div>
	</li>
</ul>

</article>

<div class="footer">
<?php include 'footer.php';?>
</div>

</body>
</div>
</html>
		 