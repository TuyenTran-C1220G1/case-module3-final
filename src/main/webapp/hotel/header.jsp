<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="background-color: lightgoldenrodyellow;padding: 5px">
    <div class="container">
        <div class="row">
            <nav class="navbar navbar-expand-lg ">
                <div class="navbar-collapse col-md-6" id="navbarSupportedContent">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <img src="imageCity/dalat.webp" style="height: 50px;width: 70px;" onclick="window.open('/city')">
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">About</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Contact</a>
                        </li>
                        <c:if test="${sessionScope.customer != null}">
                            <li><a class="nav-link">Hello ${sessionScope.customer.nameCustomer}</a></li>
                        </c:if>
                    </ul>
                </div>
                <div class="nav-item dropdown col-md-1">
                    <a class="nav-link dropdown-toggle" style="float: right" id="navbarDropdown" role="button"
                       data-bs-toggle="dropdown"
                       aria-expanded="false">
                        Tài Khoản
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <c:if test="${sessionScope.customer != null}">
                            <li><a class="dropdown-item" href="/hotel/cart.jsp">Giỏ hàng</a></li>
                            <li><a class="dropdown-item" href="/hotel/signup.jsp">Sửa thông tin</a></li>
                            <li><a class="dropdown-item" href="/logout">LogOut</a></li>
                        </c:if>
                        <c:if test="${sessionScope.customer == null}">
                            <li><li><a class="dropdown-item" href="/hotel/login.jsp">Đăng nhập</a></li></li>
                            <li><a class="dropdown-item" href="/hotel/signup.jsp">Đăng ký</a></li>
                        </c:if>
                    </ul>
                </div>
            </nav>
        </div>
    </div>
</div>
