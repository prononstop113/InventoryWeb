<!DOCTYPE  html>
<html lang="en">
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
<div class="container-fluid">
        <h1 class="h3 mb-0 text-gray-800">List User</h1>
        <div class="table-responsive-sm" style="height: 700px;overflow: scroll;">
            <table class="table table-bordered table-striped mb-0">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Username</th>
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name</th>
                    <th scope="col">Email</th>
                </tr>
                </thead>
                <tbody>
                <c:choose>
                    <c:when test="${not empty listofuser}">
                        <c:forEach items="${listofuser}" var="lists">
                            <tr>
                                <th scope="row"> ${lists.id} </th>
                                <td>        ${lists.username}</td>
                                <td>        ${lists.firstName}</td>
                                <td>        ${lists.lastName}</td>
                                <td>        ${lists.email}</td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                       No data in table
                        <br />
                    </c:otherwise>
                </c:choose>
                </tbody>
            </table>
        </div>
    </div>

</body>
</html>
