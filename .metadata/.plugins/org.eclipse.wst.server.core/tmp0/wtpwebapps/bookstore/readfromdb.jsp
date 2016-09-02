<%@page import="com.bookstore.DAO"%>
<%@page import="com.bookstore.Book"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Jon's Bookstore</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="styles.css">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row content">
			<div class="col-sm-3 sidenav">
				<h4>
					<a href="index.html">Jon's Bookstore</a>
				</h4>
				<ul class="nav nav-pills nav-stacked">
					<li><a href="index.html">Home</a></li>
					<li class="active"><a href="readfromdb.jsp">View Database</a></li>
					<li><a href="addbook.html">Add Book</a></li>
					<li><a href="deletebook.html">Delete Book</a></li>
				</ul>
				<br>
			</div>

			<div class="col-sm-9">
				<h1>
					<em>Jon's Bookstore!</em>
					</h4>
					<hr>
					<p>Welcome to Jon's friendly bookstore!</p>
					<br>
					<h3>Inventory</h3>
					<p>Below is our current inventory! To add or delete a book,
						click one of the below buttons.</p>
					<br> 
					<a href="addbook.html" class="btn btn-success" role="button">Add Book!</a> 
					<br>
					<div class="dropdown" id="deleteDropDown">
					    <form id="deleting" action="DeleteFromDB2" method="POST">    
							    <select name="deletename" onchange="this.form.submit()">
							    	<option selected="selected" style="display:none">Select a Book to Delete.</option>
							    	<%
										com.bookstore.DAO.readFromDB();
									%>
									<%
										Book readToJSP = new Book();
										
										
										for (int i = 0; i < DAO.ourBooks.size(); i++) {
											readToJSP = DAO.ourBooks.get(i);
									%>
									<option><%=readToJSP.getBookName()%></option>
									<% } %>
							    </select>
					    </form>
				  	</div>
					
					<table class="table table-striped">
						<thead>
							<tr>
								<th>ID</th>
								<th>Name</th>
								<th>Price</th>
								<th>Number in Inventory</th>
								<th>Description</th>
							</tr>
						</thead>
						<tbody>
							<%
								Book displayBook = new Book();
							
								for (int j = 0; j < DAO.ourBooks.size(); j++) {
									displayBook = DAO.ourBooks.get(j);
							%>
							<tr>
								<td><%=displayBook.getBookID()%></td>
								<td><%=displayBook.getBookName()%></td>
								<td><%=displayBook.getBookPrice()%></td>
								<td><%=displayBook.getBookCount()%></td>
								<td><%=displayBook.getBookDesc()%></td>
							</tr>
							<%
								}
								DAO.ourBooks.clear();
							%>

						</tbody>
					</table>
					
			</div>
		</div>
	</div>

	<footer class="container-fluid">
	<p>Jon's Bookstore - Where bargains are king!</p>
	</footer>
</body>
</html>