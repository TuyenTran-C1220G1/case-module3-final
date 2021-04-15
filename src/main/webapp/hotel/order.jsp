<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<!--NoiDung-->

<jsp:include page="header.jsp"></jsp:include>
<div class="container" style="margin-top: 30px">
    <div class="card">
        <div class="shadow-none p-3 mb-12 col-12 bg-light rounded container-fluid">
            <h3><strong>${room.nameHotel}</strong></h3>
            <span class="glyphicon glyphicon-star" aria-hidden="true"
                  style="color: yellow"></span>
            <span class="glyphicon glyphicon-star" aria-hidden="true"
                  style="color: yellow"></span>
            <span class="glyphicon glyphicon-star" aria-hidden="true"
                  style="color: yellow"></span>
            <span class="glyphicon glyphicon-star" aria-hidden="true"
                  style="color: yellow"></span>
            <span class="glyphicon glyphicon-star" aria-hidden="true"
                  style="color: yellow"></span>
            <dl>
                <dt><h3>${room.nameRoom}</h3></dt>
                <dt><h3>Loại Phòng: ${room.nameCate}</h3></dt>
                <dt><h3>Giá Phòng: ${room.price}</h3></dt>
                <dt><h2 style="color: red">${message}</h2></dt>
            </dl>
        </div>
        <div class="container-fluid" style="border-top: dashed; border-top-color: lightslategrey; margin-top: 20px ">
            <div class="col-md-3">
                <h3 style="margin-top: 20px"><strong>Nhập ngày thuê</strong></h3>
                <div class="form-group">
                    <form action="/order?name=find&idRoom=${room.idRoom}"
                          onclick="validateCheckin();validateCheckout()" method="post"
                          onsubmit="check()">
                        <label>
                            Ngày đặt <br>
                            <input style="height: 30px;width: 300px" id="checkin" name="checkin"
                                   type="date" value="${fromDate}" required>
                        </label> <br>
                        <label>
                            Ngày trả <br>
                            <input style="height: 30px;width: 300px" id="checkout" name="checkout"
                                   type="date" value="${toDate}" required>
                        </label> <br>
                        <button type="submit" class="btn btn-danger">Kiểm tra</button>
                    </form>

                    <form action="/order?name=add&idRoom=${room.idRoom}" method="post">
                        <label>
                            Họ và tên <br>
                            <input  name="nameCustomer" type="text" value="${nameCustomer}" required>
                        </label>
                        <label>
                            Số Điện thoại <br>
                            <input  name="phone" type="phone" value="${phone}" required>
                        </label>
                        <label>
                            Địa chỉ <br>
                            <input  name="address" type="text" value="${address}" required>
                        </label>
                        <button type="submit" class="btn btn-danger ${add}">Đặt phòng</button>
                    </form>

                </div>
            </div>
        </div>
        <div class="container">
            <c:forEach var="room" items="${rooms}">
                <div style="border-top-style:solid ;border-top-width: 5px; border-top-color: lightslategrey;margin-top: 8px">
                    <h4 style="color: #0081b0">${room.nameHotel}</h4>
                    <h4 style="color: #0081b0">Tên Phòng: ${room.nameRoom}</h4>
                    <h4 style="color: #0081b0">Loại Phòng: ${room.nameCate}</h4>
                </div>
                <div class="row">
                    <div class="col-3" style=" margin-top: 5px">
                        <img src="${room.imageRoom}" style="width: 200px;height: 200px">
                    </div>
                    <div class="col-9" style=" margin-top: 5px">
                        <div class="row">
                            <div class="col-4">
                                <span style="padding-left: 30px;text-align: left">${room.descriptionRoom}</span>
                                <br>
                            </div>
                            <div class="col-3" style="text-align: center;vertical-align: middle;margin: auto" ;>
                                <h3 style="color: #4caf50">Đơn giá: ${room.price}đ</h3>
                            </div>
                            <div class="col-1" ; style="margin: auto;vertical-align: middle">
                                <button type="button" class="btn btn-danger"
                                        onclick='window.location.href="/order?idRoom=${room.idRoom}"'>Đặt Phòng
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
    </div>




<jsp:include page="footer.jsp"></jsp:include>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
        crossorigin="anonymous"></script>
<script>
    function check() {
        var dateControl = document.querySelector('input[type="date"]')
        return dateControl.value
    }

    function validateCheckin() {
        var fromDate = new Date().toISOString().split('T')[0];
        document.getElementsByName("checkin")[0].setAttribute('min', fromDate);
    }

    function validateCheckout() {
        var toDate = new Date(new Date(document.getElementById("checkin").value).getTime() + 24 * 60 * 60 * 1000).toISOString().split('T')[0];
        document.getElementById("checkout").setAttribute("min", toDate);
    }
</script>
</body>
</html>
