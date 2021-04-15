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
    <div class="row">
        <div class="col-sm-7">
            <div class="card">
                <div class="card-body">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="shadow-none p-3 mb-12 col-12 bg-light rounded">
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
                            <div style="border-top: dashed; border-top-color: lightslategrey; margin-top: 20px ">
                                <h4 style="margin-top: 20px"><strong>Thông tin liên hệ</strong></h4>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <form action="/order?name=add&idRoom=${room.idRoom}"
                                              onclick="validateCheckin();validateCheckout()" method="post"
                                              onsubmit="check()">
                                            <label>
                                                Họ và tên <br>
                                                <input name="nameCustomer" type="text" value="${nameCustomer}" required>
                                            </label>
                                            <label>
                                                Số Điện thoại <br>
                                                <input name="phone" type="phone" value="${phone}" required>
                                            </label>
                                            <label>
                                                Địa chỉ <br>
                                                <input name="address" type="text" value="${address}" required>
                                            </label>
                                            <label>
                                                Ngày đặt <br>
                                                <input id="checkin" name="checkin" type="date" value="${fromDate}"
                                                       required>
                                            </label>
                                            <label>
                                                Ngày trả <br>
                                                <input id="checkout" name="checkout" type="date" value="${toDate}"
                                                       required>
                                            </label>
                                            <button type="submit" class="btn btn-danger"
                                                    >
                                                Kiểm tra phòng trống
                                            </button>
                                            <p>${message1}</p>
                                            <button type="submit" class="btn btn-danger">Gửi yêu cầu đặt phòng</button>
                                        </form>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="card">
                <div class="shadow-none p-3 mb-12 col-12 bg-light rounded">
                    <h5 class="card-header">Hóa Đơn</h5>
                    <div class="card-body">
                        <h5 class="card-title"><strong>Tên khách hàng: ${nameCustomer}</strong></h5>
                        <h5 class="card-title"><strong>Ngày thuê: ${fromDate}</strong></h5>
                        <h5 class="card-title"><strong>Ngày trả: ${toDate}</strong></h5>
                        <h5 class="card-title"><strong>Số ngày thuê: ${days} ngày</strong></h5>
                        <h5>Giá: ${room.price}/ngày</h5>
                        <p class="card-text"><strong>Thanh toán</strong></p>
                        <h5>${total}</h5>
                    </div>
                </div>
            </div>
            <div>
                <p>danh sách gợi ý</p>
                <ul>
                    <li>${advise.nameHotel}</li>
                </ul>
            </div>
        </div>
    </div>
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
