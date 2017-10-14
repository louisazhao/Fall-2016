<!DOCTYPE html>
<html>
<head>
<title>Exercise 1</title>
</head>
<body>
<?php
  function  splitSort($str)
  {
	  $strArr=preg_split("/[ ,.:;!?]\s*/", $str);
	  sort($strArr);
	  foreach($strArr as $word)
		print ("$word <br/>");		
  }
 ?>

<?php
   function uppercaseFirstandLast($str)
   {
	$strArr=explode(" ", $str);
    foreach($strArr as $word)
	{
		$word=ucfirst($word);
		$word=strrev(ucfirst(strrev($word)));
		print ("$word"." ");
	}	
   }
?>

<?php 
    function findAverage_and_Median($numbers)
	{
		$sum=0;
		$count=0;
		$numArr=explode(",",$numbers);
		foreach($numArr as $number)
		{
			$sum+=$number;
			$count++;
		}
		$average=$sum/$count;
		sort($numArr);
		$midIndex=$count/2;
		$median=$numArr[$midIndex];
		print ("The average is "."$average<br/><br/>");
		print("The median is "."$median");
	}
 ?>
 
 
 
 
<h2> 1. Function splitSort</h2>
<p>The original string is "Concordia University is welcoming, engaged, and committed to innovation and excellence in education, research, creative activity and community partnerships.</p>
<p>The result is:<br/></p>
<?php
splitSort("Concordia University is welcoming, engaged, and committed to innovation and excellence in education, research, creative activity and community partnerships.");
?>

<h2> 2. Function uppercaseFirstandLast</h2>
<p>The original string is "PHP is a server scripting language used to make web pages interactive"</p>
<p>After calling the function:<br/></p>
<?php
uppercaseFirstandLast("PHP is a server scripting language used to make web pages interactive");
?>

<h2> 3. Function findAverage_and_Median</h2>
<p>The array of number is "0,5,7,3,43,6,8"</p>
<p>After calling the function:<br/></p>
<?php
findAverage_and_Median("0,5,7,3,43,6,8");
?>


</body>
</html>