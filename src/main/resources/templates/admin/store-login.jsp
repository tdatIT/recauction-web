<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Latipe Vendor - Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/view/web/assets/img/favicon.png">
    <link rel="stylesheet" type="text/css" href="view/vendor/assets/css/adminx.css" media="screen"/>
</head>
<body>
<div class="adminx-container d-flex justify-content-center align-items-center">
    <div class="page-login">
        <div class="text-center">
            <a class="navbar-brand mb-4 h1" href="#">
                <img src="${pageContext.request.contextPath}/view/web/assets/img/favicon.png"
                     class="navbar-brand-image d-inline-block align-top mr-2"
                     alt="">
                Latipe Vendor
            </a>
        </div>

        <div class="card mb-0">
            <div class="card-body">
                <c:if test="${status eq 0}">
                    <div class="alert alert-danger" role="alert">
                        Sai tài khoản và mật khẩu !
                    </div>
                </c:if>
                <c:if test="${status eq 1}">
                    <div class="alert alert-success" role="alert">
                        Vui lòng đăng nhập lại tài khoản chủ cửa hàng !
                    </div>
                </c:if>
            </div>
            <div class="card-seperator">
                <span>Đăng nhập tài khoản bán hàng</span>
            </div>
            <div class="card-body">
                <form action="store-admin-login" method="post">
                    <div class="form-group">
                        <label for="exampleDropdownFormEmail1" class="form-label">Địa chỉ email</label>
                        <input name="email" type="email" class="form-control" id="exampleDropdownFormEmail1"
                               placeholder="email@example.com">
                    </div>
                    <div class="form-group">
                        <label for="exampleDropdownFormPassword1" class="form-label">Mật khẩu</label>
                        <input name="password" type="password" class="form-control" id="exampleDropdownFormPassword1"
                               placeholder="Password">
                    </div>
                    <div class="form-group">
                        <div class="custom-control custom-checkbox">
                            <input type="checkbox" class="custom-control-input" id="customCheck1">
                            <label class="custom-control-label" for="customCheck1">Remember me</label>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-sm btn-block btn-primary">Sign in</button>
                </form>
            </div>
            <div class="card-footer text-center">
                <a href="register-store"><small>Đăng Ký Cửa Hàng</small></a>
            </div>
            <div class="card-footer text-center">
                <a href="forgot"><small>Forgot your password?</small></a>
            </div>
        </div>
    </div>
</div>

<!-- If you prefer jQuery these are the required scripts -->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
<script src="view/vendor/assets/js/vendor.js"></script>
<script src="view/vendor/assets/js/adminx.js"></script>

<!-- If you prefer vanilla JS these are the only required scripts -->
<!-- script src="assets/js/vendor.js"></script>
<script src="assets/js/adminx.vanilla.js"></script-->
</body>
</html>