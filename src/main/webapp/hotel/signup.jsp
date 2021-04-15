<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <jsp:include page = "header.jsp"></jsp:include>
    <div class="container" style="padding: 150px;background-color: lightgoldenrodyellow;border-radius: 20px">
        <form class="row g-3" action="/signup">
            <fieldset>
                <legend style="text-align: center;color: black">Đăng Ký Thành Viên Mới</legend>
                <div>
                    <label for="validationDefault01" class="form-label">Tên người dùng</label>
                    <input type="text" name="nameCus" class="form-control" id="validationDefault01"  maxlength="10" required>
                </div>
                <div>
                    <label for="validationDefaultUsername" class="form-label">Username</label>
                    <div class="input-group">
                        <input type="text" name="userCus" class="form-control" id="validationDefaultUsername"  aria-describedby="inputGroupPrepend2"  required>
                    </div>
                    <p class="text-danger">${messsignup}</p>
                </div>
                <div>
                    <label for="inputPassword5" class="form-label">Password</label>
                    <input type="password"  name="passCus" id="inputPassword5" class="form-control" aria-describedby="passwordHelpBlock">
                    <div id="passwordHelpBlock" class="form-text">
                        Your password must be 8-20 characters long, contain letters and numbers, and must not contain spaces, special characters, or emoji.
                    </div>
                </div>
                <div >
                    <label for="validationDefault02" class="form-label">Địa chỉ</label>
                    <input type="text" name="addCus" class="form-control" id="validationDefault02" required>
                </div>
                <div>
                    <label for="validationDefault05" class="form-label">Số điện thoại</label>
                    <input type="text" name="phone" class="form-control" id="validationDefault05" pattern="(84|0[3|5|7|8|9])+([0-9]{8})\b" required>
                </div>
                <div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="invalidCheck2" required>
                        <label class="form-check-label" for="invalidCheck2">
                            Agree to terms and conditions
                        </label>
                    </div>
                </div>
                <div>
                    <button class="btn btn-primary" type="submit">Submit form</button>
                </div>
            </fieldset>
        </form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
</body>
</html>