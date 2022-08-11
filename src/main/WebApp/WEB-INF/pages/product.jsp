<!DOCTYPE  html>
<html lang="en">
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
<div class="container-fluid">
    <div>
        <button id ="btnAddGood" class="btn btn-outline-success" type="button" data-toggle="collapse" data-target="#collapseForm" aria-expanded="false" aria-controls="collapseForm">
            Add new Product
        </button>
    </div>

    <div class="collapse py-sm-1" id="collapseForm">
    <form>
        <div class="form-row">
            <div class="form-group col-md-4">
                <label for="inputProductName">Product Name</label>
                <input type="text" class="form-control" id="inputProductCode" placeholder="Enter Product Code">
            </div>
            <div class="form-group col-md-4">
                <label for="inputProductCode">Product Code</label>
                <input type="text" class="form-control" id="inputProductName" placeholder="Enter Product Name">
            </div>
        </div>
        <div class="form-group">
            <label for="inputProductDescription">Description</label>
            <input type="text" class="form-control" id="inputProductDescription" placeholder="Enter Product Description">
        </div>
        <label for="inputUnitID">Unit ID</label>
        <div class="form-row">
            <div class="form-group col-md-4">
                <input type="text" class="form-control" id="inputUnitID" placeholder="Enter Unit ID">

            </div>
        </div>
        <button type="submit" class="btn btn-sm btn-success">Submit</button>
    </form>
    </div>
    <h1 class="h3 mb-0 text-gray-800 py-sm-2">
        List of product
    </h1>
    <div class="table-responsive-sm" style="height: 380px;overflow: scroll;">
        <table class="table table-bordered table-striped mb-0">
            <thead class="thead-dark">
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Product Code</th>
                <th scope="col">Product Name</th>
                <th scope="col">Product Description</th>
                <th scope="col">Unit ID</th>
                <th scope="col">Function</th>
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
                            <td><button id="btnUpdate" type="submit" class="btn btn-sm btn-warning">Update</button>
                                <button id="btnDelete" type="submit" class="btn btn-sm btn-danger">Delete</button></td>
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
