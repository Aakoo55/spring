<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Esimerkki 10</title>
<link rel="stylesheet" type="text/css" href="styles/common.css">
</head>
<body>
<h1><a href="http://agileo.fi" class="companylogo">Agileo<img src="images/agileo_logo.png" alt="Agileo"/></a></h1>
<h1 id="coursetitle">Spring Framework</h1>
<h2>Esimerkki 10</h2>

	<div id="contentbox">
		<h3>Sis�lt�</h3>
		<ul>
			<li>Sis��nkirjautuminen</li>
			<li>Uloskirjautuminen</li>
			<li>K�ytt�j�tiedot sessiossa</li>
			<li>Kryptattujen salasanojen vertaaminen toisiinsa</li>
		</ul>
		<h3>Toiminta</h3>
		<p>SiteServlet hoitaa ohjauksen joko etusivulle tai sis��n
			j�rjestelm��n. Sis��nkirjautumista, uloskirjautumista ja
			rekister�itymist� varten on omat servlettins�. K�ytt�j�n tiedot
			tallennetaan sis��nkirjauduttaessa sessioon atribuuttiin "k�ytt�j�".</p>
		<h3>Linkki</h3>
		<p>
			<a href="site">site</a>
		</p>
	</div>
</body>
</html>