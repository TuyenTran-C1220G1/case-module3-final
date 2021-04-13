<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="background-color: lightgoldenrodyellow;padding: 5px">
    <div class="container">
        <div class="row">
            <nav class="navbar navbar-expand-lg ">
                <div class="navbar-collapse col-md-6" id="navbarSupportedContent">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <img src="logo.PNG" style="height: 50px;width: 70px;" onclick="window.open()">
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">About</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Contact</a>
                        </li>
                    </ul>
                </div>
                <div class="nav-item dropdown col-md-1">
                    <a class="nav-link dropdown-toggle" style="float: right" id="navbarDropdown" role="button"
                       data-bs-toggle="dropdown"
                       aria-expanded="false">
                        Tài Khoản
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#">Đăng nhập</a></li>
                        <li><a class="dropdown-item" href="#">Đăng ký</a></li>
                        <li><a class="dropdown-item" href="#">Khách sạn yêu thích</a></li>
                    </ul>
                </div>
            </nav>
        </div>
    </div>
</div>
