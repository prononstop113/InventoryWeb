<!DOCTYPE  html>
<html lang="en">
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
<div class="container-fluid">
    <div>
        <button id ="btnOpenForm" class="btn btn-outline-success" type="button"
                data-toggle="collapse" data-target="#collapseForm" aria-expanded="false" aria-controls="collapseForm"
                onclick="openForm()">
            Add new Product
        </button>
    </div>

    <div class="collapse py-sm-1" id="collapseForm">
    <form id = "formGood">
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
        <button type="submit" class="btn btn-sm btn-success" onclick="addNewGood()">Submit</button>
        <button type="button" class="btn btn-sm btn-secondary"  data-toggle="collapse" data-target="#collapseForm" aria-expanded="false" aria-controls="collapseForm" onclick="closeForm()">Close</button>
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
                                        data-toggle="collapse" data-target="#collapseForm" aria-expanded="false" aria-controls="collapseForm"
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
    var isEdit =false;
    function  openForm(){
        document.getElementById("btnOpenForm").disabled=true;
    document.getElementById("customTB").style.height = "380px";
    }
    function closeForm(){
        document.getElementById("btnUpdate").disabled=false;
        document.getElementById("btnOpenForm").disabled=false;
        document.getElementById("customTB").style.height = "600px";
    }
    function deleteInfo(){

    }


    function updateInfo(){
        openForm();
        document.getElementById("btnUpdate").disabled=true;
        var productCode=document.getElementById("username");
        var productName=document.getElementById("firstname");
        var productDescription=document.getElementById("lastname");
        var unitID = document.getElementById("email")
        document.getElementById("inputProductCode").value=productCode;
        document.getElementById("inputProductName").value=productName;
        document.getElementById("inputProductDescription").value=productDescription;
        document.getElementById("inputUnitID").value=unitID;
        isEdit=true;
    }
    function addNewGood(){
        if(isEdit){

        }
        else{

        }
    }

</script>
<script>
    $(document).ready(function(){
        $(".btn-success").click(function(){

        });
        $(".btn-warning").click(function(){
            $(".collapse").collapse('hide');
        });
    });
</script>
</body>
</html>
