<!DOCTYPE html>
<html lang="en">
<head>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <sec:authentication var="principal" property="principal" />
    <meta charset='utf-8'>
    <link href='https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css' rel='stylesheet'>
    <script type='text/javascript' src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
    </head>
<body class='snippet-body'>
<div class="container rounded bg-white mt-5 mb-5">
    <div class="row">
        <div class="col-md-3 border-right">
            <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                <img class="img-profile rounded-circle"
                     src="img/undraw_profile.svg">
                <span class="font-weight-bold">${principal.firstName}</span>
                <span class="text-black-50">${principal.email}</span>
                <span>
                </span>
            </div>
        </div>
        <form class="col-md-8 " method = "POST" id="edituser">
            <div class="p-3 py-5">
                <div class="d-flex justify-content-between align-items-center mb-3">
                    <h4 class="text-right">Profile Settings</h4>
                </div>
                <div class="row mt-2">
                <div class="col-md-6">
                    <label class="labels">First Name</label>
                    <input id = "inputfirstname" type="text" class="form-control" value="${principal.firstName}" placeholder="Enter your first name">
                </div>
                <div class="col-md-6">
                    <label class="labels">Last Name</label>
                    <input id = "inputlastname" type="text" class="form-control" placeholder="Enter last name" value="${principal.lastName}">
                </div>
            </div>
                <div class="row mt-3">
                    <div class="col-md-12">
                        <label class="labels">Phone Number</label>
                        <input id="inputphoneNumber" type="text" class="form-control" placeholder="Enter phone number" value=""></div>
                    <div class="col-md-12">
                        <label class="labels">Address</label>
                        <input id = "inputaddress" type="text" class="form-control" placeholder="Enter address" value="">
                    </div>
                    <div class="col-md-12">
                        <label class="labels">Email Address</label>
                        <input id ="inputemail" type="text" class="form-control" value="${principal.email}" placeholder="Enter email address">
                    </div>
                </div>

                <div class="mt-5 text-center">
                <button class="btn btn-primary profile-button" onClick =updateUser href="/profile"
                        type="submit">
                    Save Profile</button>
            </div>
            </div>
        </form>

    </div>
</div>
</div>
</div>
<script type='text/javascript' src='https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js'></script>
<script>
      function updateUser(element){
        var firstName,lastName,phoneNumber,address,email;
        const formData = new FormData()
            formData.append('firstName',document.getElementById("inputfirstName").value);
            formData.append('lastName',document.getElementById("inputlastName").value);
            formData.append('phoneNumber',document.getElementById("inputphoneNumber").value);
            formData.append('address',document.getElementById("inputaddress").value);
            formData.append('email',document.getElementById("inputemail").value);
            axios({
                method: "put",
                url: "http://localhost:8090/user/{id}",
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
</script>
</body>
</html>"
