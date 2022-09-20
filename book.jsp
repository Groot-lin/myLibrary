<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>myLibrary</title>
</head>

<body>
<hr>
<h1>${user.getName()},欢迎你</h1>
<table border="1" cellsqacing="0" width="800">

    <tr>
        <th>序号</th>
        <th>书名</th>
        <th>作者</th>
        <th>发行时间</th>
        <th>类型</th>
        <th>剩余数量</th>
    </tr>
    <c:forEach items="${Books}" var="book" varStatus="status">
            <tr>

                 <td align = "center">${book.id}</td>
                 <td align = "center">${book.bookname}</td>
                 <td align = "center">${book.author}</td>
                 <td align = "center">${book.release_time}</td>
                 <td align = "center">${book.type}</td>
                 <td align = "center">${book.status}</td>
             </tr>
    </c:forEach>
</table>

</body>
</html>
