<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/2/2022
  Time: 10:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>

    <title>Danh sách đơn hàng trong đơn hàng</title>
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
                    <h1>Thông tin chi tiết đơn hàng ID: [${order.orderId}]</h1>
                </div>
                <div class="row">
                    <div class="col-lg-6">
                        <div class="card mb-grid">
                            <div class="card-header">
                                <div class="card-header-title">Thông tin của khách hàng</div>
                            </div>
                            <div class="card-body">
                                <div class="form-group">
                                    <label class="form-label"></label>
                                    <input name="productId" id="productId" class="form-control mb-2"
                                           type="hidden"
                                           value="${order.orderId}">
                                </div>
                                <c:if test="${success eq false}">
                                    <div class="form-group">
                                        <div class="alert alert-warning" role="alert">
                                            Cập nhật trạng thái đơn hàng thất bại
                                        </div>
                                    </div>
                                </c:if>
                                <div class="form-group">
                                    <label class="form-label">Tên Khách Hàng</label>
                                    <input class="form-control mb-2" type="text" placeholder="null"
                                           value="[${order.userId}]:${user.userByUserId.lastname}" disabled>
                                </div>
                                <div class="form-group">
                                    <label class="form-label">Địa chỉ giao</label>
                                    <input class="form-control  mb-2" type="text"
                                           placeholder="null" value="${order.address}" disabled>
                                </div>
                                <div class="form-group">
                                    <label class="form-label">Số điện thoại khách hàng</label>
                                    <input class="form-control  mb-2" type="number"
                                           placeholder="null" value="${order.phone}" disabled>
                                </div>
                                <div class="form-group">
                                    <label class="form-label">Trạng thái thanh toán </label>
                                    <select name="status" class="form-control js-choice" disabled>
                                        <option value="1" selected>Thanh toán trước</option>
                                        <option value="2">Thanh toán khi nhận hàng</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label class="form-label">Ngày tạo đơn hàng</label>
                                    <input name="price" class="form-control  mb-2" type="date"
                                           placeholder="null" value="${order.createDate}" disabled>
                                </div>
                            </div>
                            <div class="card-footer">
                                Nhà cung cấp vui lòng chuẩn bị giao hàng như thông tin <strong>khách
                                hàng</strong> chính xác !
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="card mb-grid">
                            <div class="card-header">
                                <div class="card-header-title">Thông tin về chiết khấu đơn hàng</div>
                            </div>
                            <div class="card-body">
                                <div class="form-group">
                                    <label class="form-label">Thông tin cửa hàng</label>
                                    <input class="form-control  mb-2" type="text"
                                           placeholder="null"
                                           value="[${store.storeId}] - ${store.name}" disabled>
                                </div>
                                <div class="form-group">
                                    <label class="form-label">Số tiền KH thanh toán</label>
                                    <input class="form-control  mb-2" type="number"
                                           placeholder="null"
                                           value="${order.amountFromUser.intValue()}" disabled>
                                </div>
                                <div class="form-group">
                                    <label class="form-label">Số tiền chiết khấu cho hệ thống</label>
                                    <input class="form-control mb-2" type="number"
                                           placeholder="null"
                                           value="${order.amountToGd.intValue()}" disabled>
                                </div>
                                <div class="form-group">
                                    <label class="form-label">Số tiền của hàng nhận</label>
                                    <input class="form-control mb-2" type="number"
                                           placeholder="null"
                                           value="${order.amountToStore.intValue()}" disabled>
                                </div>
                                <div class="form-group">
                                    <label class="form-label">Trạng thái xử lý</label>
                                    <select class="form-control js-choice" disabled>
                                        <c:if test="${order.status eq 1}">
                                            <option value="1" selected>Xử lý</option>
                                        </c:if>
                                        <c:if test="${order.status eq 2}">
                                            <option value="2" selected>Vận chuyển</option>
                                        </c:if>
                                        <c:if test="${order.status eq 3}">
                                            <option value="3" selected>Hoàn thất</option>
                                        </c:if>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label class="form-label">Ngày cập nhật</label>
                                    <input class="form-control mb-2" type="date"
                                           placeholder="${order.updateDate}" disabled>
                                </div>
                            </div>
                            <div class="card-footer">
                                <div class="d-flex justify-content-between">
                                    Giá trên đã được thỏa thuận trong điều khoản bán hàng
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
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
                                    <th scope="col">Ảnh</th>
                                    <th scope="col">ID Sản Phẩm</th>
                                    <th scope="col">Tên</th>
                                    <th scope="col">Đơn giá</th>
                                    <th scope="col">Số lượng</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${items}" var="i">
                                    <tr>
                                        <th scope="row">
                                            <label class="custom-control custom-checkbox m-0 p-0">
                                                <input type="checkbox"
                                                       class="custom-control-input table-select-row">
                                                <span class="custom-control-indicator"></span>
                                            </label>
                                        </th>
                                        <td>
                                            <img src="${pageContext.request.contextPath}/upload/${i.productByProductId.productImgsByProductId[0].fileName}"
                                                 height="40px" width="40px">
                                        </td>
                                        <td>${i.productByProductId.productId}</td>
                                        <td>${i.productByProductId.name}</td>
                                        <td>${i.productByProductId.price}</td>
                                        <td>${i.quantity}</td>

                                    </tr>
                                </c:forEach>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-12">
                <form action="order-process" method="post">
                    <div class="card mb-grid">
                        <div class="card-header">
                            <div class="card-header-title">Chỉnh sửa trạng thái đơn</div>
                        </div>
                        <div class="card-body">
                            <div class="form-group">
                                <label class="form-label">Mã đơn hàng: ${order.orderId}</label>
                                <input name="orderId" class="form-control mb-2"
                                       type="number"
                                       value="${order.orderId}" hidden>
                            </div>


                            <div class="form-group">
                                <label class="form-label">Trạng thái thanh toán </label>
                                <select name="status" class="form-control js-choice">
                                    <c:if test="${order.status eq 1}">
                                        <option value="1" selected hidden>Xử lý</option>
                                    </c:if>
                                    <c:if test="${order.status eq 2}">
                                        <option value="2" selected hidden>Vận chuyển</option>
                                    </c:if>
                                    <c:if test="${order.status eq 3}">
                                        <option value="3" selected hidden>Hoàn tất</option>
                                    </c:if>
                                    <option value="1">Xử lý</option>
                                    <option value="2">Vận chuyển</option>
                                    <option value="3">Hoàn tất</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn-primary btn">Hoàn tất</button>
                            </div>
                        </div>
                    </div>
                </form>
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