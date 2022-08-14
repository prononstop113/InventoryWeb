<!DOCTYPE  html>
<html lang="en">
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
<div class="container-fluid">
    <div>
        <button id ="btnOpenForm" class="btn btn-outline-success" type="button"
                onclick="openForm()">
            Add new Product
        </button>
    </div>

    <div class="collapse py-sm-1" id="collapseForm">
    <form id = "formGood" method="post" action="/good">
        <div class="form-row">
            <div class="form-group col-md-4">
                <label for="inputProductName">Product Name</label>
                <input type="text" class="form-control" id="inputProductCode" name="productCode" placeholder="Enter Product Code">
            </div>
            <div class="form-group col-md-4">
                <label for="inputProductCode">Product Code</label>
                <input type="text" class="form-control" id="inputProductName" name="productName"  placeholder="Enter Product Name">
            </div>
        </div>
        <div class="form-group">
            <label for="inputProductDescription">Description</label>
            <input type="text" class="form-control" id="inputProductDescription"  name="productDescription" placeholder="Enter Product Description">
        </div>
        <div class="form-row">
            <div class="form-group col-md-4">
                <label for="inputUnitID">Unit ID</label>
                <input type="text" class="form-control" id="inputUnitID" name="unitID" placeholder="Enter Unit ID">
            </div>

            <div class="form-group col-md-4">
                <label for="productIDout">Product ID</label>
                <input type="text" class="form-control" id="productIDout" name="id" readonly>

            </div>
        </div>
        <button type="button" class="btn btn-sm btn-success" onclick="addNewGood()">Submit</button>
        <button type="button" class="btn btn-sm btn-secondary"  onclick="closeForm()">Close</button>
    </form>
    </div>
    <h1 class="h3 mb-0 text-gray-800 py-sm-2">
        List of product
    </h1>
    <div id ="customTB"class="table-responsive-sm" style="height: 600px;overflow: scroll;">
        <table id = "tableRS" class="table table-bordered table-striped mb-0">
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
                <c:when test="${not empty listofGood}">

                    <c:forEach items="${listofGood}" var="lists">
                        <tr>
                            <th scope="row"> ${lists.id} </th>
                            <td>        ${lists.productCode}</td>
                            <td>        ${lists.productName}</td>
                            <td>        ${lists.productDescription}</td>
                            <td>        ${lists.unitId}</td>
                            <td><button id="btnUpdate" type="submit" class="btn btn-sm btn-warning"
                                        onclick="updateInfo(this)">Update</button>
                                <button id="btnDelete" type="submit" class="btn btn-sm btn-danger" onclick="deleteInfo(this)">Delete</button></td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <h6> No data in table</h6>
                    <br />
                </c:otherwise>
            </c:choose>
            </tbody>
        </table>
    </div>
</div>
<script  type='text/javascript'>
    import axios from "axios";
    var isEdit =false;
    var isExpanded = false;
    var tableRS = document.getElementById("tableRS");
    function  openForm(){
        isExpanded=true;
        $("#collapseForm").collapse('show');
        document.getElementById("btnOpenForm").disabled=true;
    document.getElementById("customTB").style.height = "350px";
    }
    function closeForm(){
        $("#collapseForm").collapse('hide');
        isExpanded= false;
        document.getElementById("btnUpdate").disabled=false;
        document.getElementById("btnOpenForm").disabled=false;
        document.getElementById("customTB").style.height = "600px";
    }
    function deleteInfo(element){
        var rows = element.parentNode.parentNode;
        var id =document.getElementById("productIDout").value=tableRS.rows[rows.rowIndex].cells[0].innerHTML.trim();
        axios({
            method: "delete",
            url: "http://localhost:8091/good/{id}",
            data: id,
            headers: { "Content-Type": "multipart/form-data" },
        })
            .then(function (response) {
                location.reload()
                console.log(response);
            })
            .catch(function (response) {
                location.reload()
                console.log(response);
            });

    }
    function updateInfo(element){
        if(isExpanded==false){
            openForm();
        }
        var rows = element.parentNode.parentNode;
        isEdit=true;
        document.getElementById("inputProductCode").value=tableRS.rows[rows.rowIndex].cells[2].innerHTML.trim();
        document.getElementById("inputProductName").value=tableRS.rows[rows.rowIndex].cells[1].innerHTML.trim();
        document.getElementById("inputProductDescription").value=tableRS.rows[rows.rowIndex].cells[3].innerHTML.trim();
        document.getElementById("inputUnitID").value=tableRS.rows[rows.rowIndex].cells[4].innerHTML.trim();
        document.getElementById("productIDout").value=tableRS.rows[rows.rowIndex].cells[0].innerHTML.trim();
        isEdit=true;
    }
    function addNewGood(){
        if(isEdit){
            const formData = new FormData()
            formData.append('id',document.getElementById("productIDout").value);
            formData.append('productCode',document.getElementById("inputProductCode").value);
            formData.append('productName',document.getElementById("inputProductName").value);
            formData.append('productDescription',document.getElementById("inputProductDescription").value);
            formData.append('unitID',document.getElementById("inputUnitID").value);
            axios({
                method: "put",
                url: "http://localhost:8091/good/{id}",
                data: formData,
                headers: { "Content-Type": "multipart/form-data" },
            })
                .then(function (response) {
                    location.reload()
                    console.log(response);
                })
                .catch(function (response) {
                    location.reload()
                    console.log(response);
                });
        }
        else{
            document.getElementById("formGood").submit();
        }
    }
</script>
</body>
</html>
