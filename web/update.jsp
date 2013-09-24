<%-- 
    Document   : update
    Created on : Sep 23, 2013, 9:43:22 PM
    Author     : rbath1
--%>

<%@page import="model.MenuItem"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Menu</title>
    </head>
    <body>
        <%
	List<MenuItem> menuList = (List<MenuItem>) request.getAttribute("menuList");
	
%>

<form id="form1" name="form1" method="POST" action="OrderController">
         <%
                        NumberFormat nf = NumberFormat.getCurrencyInstance();
                        for(MenuItem menuItem : menuList) {
                            String item = menuItem.getItemName();
                            double itemPrice = menuItem.getItemPrice();
                    %>
         
                    <input type="checkbox" name="menuItems" value="<%= item %>" /> <%= (item + ", " + nf.format(itemPrice)) %><br/>
                    
                    <%
                        }
                        
                     %>

                     <br/>
   

        <input type="submit" value="Add/Edit" name="addEdit" />&nbsp;
        <input type="submit" value="Delete" name="delete" />
</form>
    </body>
</html>
