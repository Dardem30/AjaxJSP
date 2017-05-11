<%--
  Created by IntelliJ IDEA.
  User: УВД
  Date: 10.05.2017
  Time: 17:26
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
                var $department=$("select#department").val();
                $.get('ServletJSon',{
                    department: $department
                },function (responseJson) {
                    var $selected=$('#employee');
                    $selected.find('option').remove();
                    $.each(responseJson ,function (key, value) {
                        $('<option>').val(key).text(value).appendTo($selected);
                    });
                });
            });
            $('#employee').change(function(){
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

<select id="department">
    <option value="0" selected="selected"></option>
    <option value="1">marketting</option>
    <option value="2">sale</option>
</select>
<select id="employee">
    <option value="0"></option>
</select>
<div id="textSpace"></div>
</body>
</html>
