<%-- 
    Document   : editNote
    Created on : 1-Oct-2020, 9:09:19 AM
    Author     : Andrew
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        <form method="post" action="viewNote" id="noteForm">
            Title: <input type="text" name="title" value="${note.title}">
            <input type="submit" value="Save">
        </form>
        Contents: <textarea name="contents" form="noteForm">${note.contents}</textarea>
    </body>
</html>
