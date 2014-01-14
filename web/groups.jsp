<%-- 
    Document   : index
    Created on : Jan 5, 2014, 4:43:34 PM
    Author     : paolo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student's Forum | Groups</title>
        <%@include file="include/head.jsp" %>
    </head>
    <body>
        <div id="groups-page" data-role="page">
            <div data-role="header">
                <a href="#panel" data-icon="bars">Menu</a>
                <h2>Student's Forum | Groups</h2>
            </div>
            <div data-role="content">
                <ul data-role="listview" data-inset="true">
                    <li data-role="list-divider" data-theme="b">
                        Your groups
                    </li>
                    <li>
                        <a href="">
                            <h2>The Elder Scrolls</h2>
                            <span class="ui-li-count"><%= postNumber %></span>
                        </a>
                    </li>
                    <li>
                        <a href="">
                            <h2>Other games?</h2>
                            <span class="ui-li-count">2</span>
                        </a>
                    </li>
                </ul>
            </div>

            <%@include file="include/panel.jsp" %>
        </div>
    </body>
</html>
