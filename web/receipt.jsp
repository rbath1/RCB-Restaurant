<%-- 
    Document   : receipt
    Created on : Sep 22, 2013, 3:31:19 PM
    Author     : Bob
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.*, model.MenuItem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Receipt</title>
    </head>
    <body>
        <h1> Receipt for your order</h1>
        
        <%
                double totalBill = 0;
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                Object objOrderList = request.getAttribute("orderList");
                if(objOrderList != null) {
                    List<MenuItem> orderList = (List<MenuItem>)objOrderList;
                    for(MenuItem item : orderList) {
                        out.println("<li>" + item.getItemName() + ", " + nf.format(item.getItemPrice()) + "</li>");
                        totalBill += item.getItemPrice();
                    }
                    out.println("<br/><br/>");
                    out.println("Subtotal: " + nf.format(totalBill) + "<br/>");
                    out.println("Tax: " + (nf.format(totalBill * .051)) + "<br/>");
                    out.println("Total Bill: " + (nf.format(totalBill * 1.051)) + "<br/>");
                    out.println("Tip: " + (nf.format(totalBill * 1.051 * 0.17)) + "<br/>");
                    out.println("Total w/ Tip: " + (nf.format(totalBill * 1.051 * 1.17)) + "<br/>");
                } else {
                    out.print("Order Cannot Be Found!!");
                }
            %>
        
    </body>
</html>
