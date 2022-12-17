<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/2/2022
  Time: 10:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>

    <title>Quản lý sản phẩm - Laptipe</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/view/web/assets/img/favicon.png">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/vendor/assets/css/adminx.css"
          media="screen"/>
</head>
<body>
<div class="adminx-container">

    <c:import url="admin-fragments.html"></c:import>

    <!-- Main Content -->
    <div class="adminx-content">
        <div class="adminx-main-content">
            <div class="container-fluid">
                <!-- BreadCrumb -->
                <nav aria-label="breadcrumb" role="navigation">
                    <ol class="breadcrumb adminx-page-breadcrumb">
                        <li class="breadcrumb-item"><a href="#">Dashboard</a></li>
                        <li class="breadcrumb-item"><a href="#">Quản lý đơn hàng</a></li>
                        <li class="breadcrumb-item active  aria-current=" page
                        ">Bảng</li>
                    </ol>
                </nav>
                <div class="pb-3">
                    <h1>Tất cả các đơn hàng</h1>
                </div>
                <div class="row">
                    <div class="col">
                        <div class="card mb-grid">
                            <div class="table-responsive-md">
                                <table class="table table-actions table-striped table-hover mb-0" data-table>
                                    <thead>
                                    <tr>
                                        <th scope="col">

                                            <label class="custom-control custom-checkbox m-0 p-0">
                                                <input type="checkbox" class="custom-control-input table-select-all">
                                                <span class="custom-control-indicator"></span>
                                            </label>
                                        </th>
                                        <th scope="col">ID</th>
                                        <th scope="col">Người tạo</th>
                                        <th scope="col">Đơn giá</th>
                                        <th scope="col">Ngày tạo</th>
                                        <th scope="col">Trạng thái</th>
                                        <th scope="col">Chức năng</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${orders}" var="i">
                                        <tr>
                                            <th scope="row">
                                                <label class="custom-control custom-checkbox m-0 p-0">
                                                    <input type="checkbox"
                                                           class="custom-control-input table-select-row">
                                                    <span class="custom-control-indicator"></span>
                                                </label>
                                            </th>
                                            <td>
                                                    ${i.orderId}
                                            </td>
                                            <td>${i.userId}</td>
                                            <td>${i.amountFromUser.intValue()}</td>
                                            <td>${i.createDate}</td>
                                            <c:if test="${i.status eq 1}">
                                                <td>
                                                    <span class="badge badge-pill badge-primary">Xử lý</span>
                                                </td>
                                            </c:if>
                                            <c:if test="${i.status eq 2}">
                                                <td>
                                                    <span class="badge badge-pill badge-danger">Vận chuyển</span>
                                                </td>
                                            </c:if>
                                            <c:if test="${i.status eq 3}">
                                                <td>
                                                    <span class="badge badge-pill badge-success">Hoàn tất</span>
                                                </td>
                                            </c:if>
                                            <td>
                                                <a class="btn btn-sm btn-primary"
                                                   href="${pageContext.request.contextPath}/store-admin/order-process?orderId=${i.orderId}">Chỉnh
                                                    sửa</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- // Main Content -->
</div>

<!-- If you prefer jQuery these are the required scripts -->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap4.min.js"></script>
<script src="${pageContext.request.contextPath}/view/vendor/assets/js/vendor.js"></script>
<script src="${pageContext.request.contextPath}/view/vendor/assets/js/adminx.js"></script>
<script>
    $(document).ready(function () {
        var table = $('[data-table]').DataTable({
            "columns": [
                null,
                null,
                null,
                null,
                null,
                null,
                {"orderable": false}
            ]
        });

        /* $('.form-control-search').keyup(function(){
          table.search($(this).val()).draw() ;
        }); */
    });
</script>

<!-- If you prefer vanilla JS these are the only required scripts -->
<!-- script src="assets/js/vendor.js"></script>
<script src="assets/js/adminx.vanilla.js"></script-->
</body>
</html>