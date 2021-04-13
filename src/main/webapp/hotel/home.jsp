<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <style>
        a{
            text-decoration: none;
        }
    </style>
</head>
<body>
<!--nav-->
<div class="container">
    <jsp:include page="header.jsp"></jsp:include>
</div>
<!--sss-->
<div style="background-color: lightblue;height: 425px;padding: 20px">
    <div class="container">

        <div class="row">
            <div class="col-4" style="background-color: blue;border-radius: 20px;padding: 15px">
                <div class="mb-3"><h4 style="text-align: center">Tìm kiếm khách sạn</h4></div>
                <div class="container">
                    <div class="form-floating mb-3">
                        <select class="form-select" id="floatingSelect" aria-label="Floating label select example">
                            <option value="1">Đà nẵng</option>
                            <option value="2">Bà rịa- Vũng tàu</option>
                            <option value="3">Đà Lạt</option>
                            <option value="4">Tp - HCM</option>
                            <option value="5">Nha Trang</option>
                            <option value="6">Phan Thiết</option>
                        </select>
                        <label for="floatingSelect">Nhập địa điểm</label>
                    </div>
                    <div class="mb-3">
                        <input class="form-control" type="text" placeholder="Ngày thuê"
                               aria-label="default input example">
                    </div>
                    <div class="mb-3">
                        <input class="form-control" type="text" placeholder="Ngày trả"
                               aria-label="default input example">
                    </div>
                    <select class="form-select form-select-md mb-3" aria-label="Default select example">
                        <option selected>Loại phòng</option>
                        <option value="1">1 phòng ngủ</option>
                        <option value="2">2 phòng ngủ</option>
                    </select>
                    <button type="submit" class="btn btn-primary ">Tìm kiếm</button>
                </div>
            </div>
            <div id="carouselExampleCaptions" class="carousel slide col-md-8" data-bs-ride="carousel">
                <div class="carousel-indicators">
                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active"
                            aria-current="true" aria-label="Slide 1"></button>
                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1"
                            aria-label="Slide 2"></button>
                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2"
                            aria-label="Slide 3"></button>
                </div>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="carousel1.webp" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="carousel2.webp" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="carousel3.webp" class="d-block w-100" alt="...">
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions"
                        data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions"
                        data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
        </div>
    </div>
</div>
<%---- hhh--%>
<div class="container" style="margin-top: 50px;padding: 10px">
    <div class="row">
        <c:forEach var="city" items="${cities}">
            <div class="card col-md-4" style="border: solid 0">
                <a href="/hotel?idCity=${city.idCity}">${city.nameCity}</a>
                <img onclick='window.location.href="/hotel?idCity=${city.idCity}"' src="${city.imageCity}" class="" alt="..." style="border-radius: 10px">
                <div class="card-body">
                    <p class="card-text">${city.descriptionCity}</p>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<div>
    <jsp:include page="footer.jsp"></jsp:include>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
        crossorigin="anonymous"></script>
</body>
</html>