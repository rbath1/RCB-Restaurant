<%-- 
    Document   : menu
    Created on : Sep 18, 2013, 9:26:52 PM
    Author     : Bob
--%>

<%@page import="model.MenuItem"%>
<%@page import="java.util.List"%>
<%@page import="java.text.NumberFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <%
	List<MenuItem> menuList = (List<MenuItem>) request.getAttribute("menuList");
	List<MenuItem> orderList = (List<MenuItem>) request.getAttribute("orderList");
%>
        <title>Create an Order</title>
    </head>
    <body>
        <h1 align="center">Simple Restaurant</h1>
        <form id="form1" name="form1" method="POST" action="OrderController">
         <%
                        NumberFormat nf = NumberFormat.getCurrencyInstance();
                        for(MenuItem menuItem : menuList) {
                            String item = menuItem.getItemName();
                            double itemPrice = menuItem.getItemPrice();
                    %>
         <!-- Remember, using the %= notation below is a shortcut for out.print -->
                    <input type="checkbox" name="menuItems" value="<%= item %>" /> <%= (item + ", " + nf.format(itemPrice)) %><br/>
                    
                    <%
                        }
                        
                     %>

                     <br/>
         <input id="orderSubmit" name="Submit Order" type="submit" value="Get Order">
        </form>
    </body>
</html>
