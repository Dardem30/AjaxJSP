<%--
  Created by IntelliJ IDEA.
  User: УВД
  Date: 11.05.2017
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://code.jquery.com/jquery-1.10.2.js"
            type="text/javascript"></script>
    <script>
        $(document).ready(function () {
            $('#department').change(function (event) {
                var $department=$('select#department').val();
                $.get("ResponseServlet",{
                    department: $department
                },function (responseText) {
                    $('#textSpace').text(responseText);
                    }
                );
            });
        });
    </script>
</head>
<body>
<form>
    <select id="department">
    <option value="0" selected="selected"></option>
    <option value="1">marketting</option>
    <option value="2">sale</option>
    </select>
    <input id="entre" type="submit">
</form>
<div id="textSpace"></div>
</body>
</html>
