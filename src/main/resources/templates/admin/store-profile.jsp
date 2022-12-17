<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/2/2022
  Time: 10:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}/view/vendor/assets" var="assets"></c:set>
<c:set value="${pageContext.request.contextPath}/upload" var="upload"></c:set>
<!DOCTYPE html>
<html lang="en">
<head>

    <title>${store.name} - Laptipe</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" type="image/x-icon" href="${assets}/img/favicon.png">
    <link rel="stylesheet" type="text/css" href="${assets}/css/adminx.css"
          media="screen"/>
</head>
<body>
<div class="adminx-container">

    <c:import url="admin-fragments.html"></c:import>

    <!-- Main Content -->
    <div class="adminx-content">
        <div class="adminx-main-content">
            <div class="container-fluid">
                <div class="container">
                    <div class="main-body">

                        <!-- Breadcrumb -->
                        <nav aria-label="breadcrumb" class="main-breadcrumb">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="dashboard">Trang chủ</a></li>
                                <li class="breadcrumb-item" aria-current="page"><a href="info">Thông tin cửa hàng</a>
                                </li>
                            </ol>
                        </nav>
                        <!-- /Breadcrumb -->

                        <div class="row gutters-sm">
                            <div class="col-md-4 mb-3">
                                <div class="card">
                                    <div class="card-body">
                                        <div class="d-flex flex-column align-items-center text-center">
                                            <img src="${upload}/${store.avatar}" alt="Admin"
                                                 class="rounded-circle" width="150">
                                            <div class="mt-3">
                                                <h4>${store.name}</h4>
                                                <p class="text-secondary mb-1">
                                                    <c:if test="${store.isActive() eq true}">
                                                        <span class="badge bg-primary text-white">Hoạt động</span>
                                                    </c:if>
                                                    <c:if test="${store.isActive() ne true}">
                                                        <span class="badge bg-danger text-white">Ngừng</span>
                                                    </c:if>
                                                </p>
                                                <p class="text-muted font-size-sm">Ngày tạo: ${store.createDate}</p>
                                                <button class="btn btn-primary">Follow:${follow}</button>
                                                <button class="btn btn-outline-primary">Point: ${store.point}</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="card mt-3">
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                            <h6 class="mb-0">
                                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                                                     viewBox="0 0 24 24" fill="none" stroke="currentColor"
                                                     stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                                                     class="feather feather-globe mr-2 icon-inline">
                                                    <circle cx="12" cy="12" r="10"></circle>
                                                    <line x1="2" y1="12" x2="22" y2="12"></line>
                                                    <path d="M12 2a15.3 15.3 0 0 1 4 10 15.3 15.3 0 0 1-4 10 15.3 15.3 0 0 1-4-10 15.3 15.3 0 0 1 4-10z"></path>
                                                </svg>
                                                Website
                                            </h6>
                                            <span class="text-secondary">https://wwww.store.com</span>
                                        </li>

                                        <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                            <h6 class="mb-0">
                                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                                                     viewBox="0 0 24 24" fill="none" stroke="currentColor"
                                                     stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                                                     class="feather feather-twitter mr-2 icon-inline text-info">
                                                    <path d="M23 3a10.9 10.9 0 0 1-3.14 1.53 4.48 4.48 0 0 0-7.86 3v1A10.66 10.66 0 0 1 3 4s-4 9 5 13a11.64 11.64 0 0 1-7 2c9 5 20 0 20-11.5a4.5 4.5 0 0 0-.08-.83A7.72 7.72 0 0 0 23 3z"></path>
                                                </svg>
                                                @store
                                            </h6>
                                            <span class="text-secondary">@store</span>
                                        </li>
                                        <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                            <h6 class="mb-0">
                                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                                                     viewBox="0 0 24 24" fill="none" stroke="currentColor"
                                                     stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                                                     class="feather feather-instagram mr-2 icon-inline text-danger">
                                                    <rect x="2" y="2" width="20" height="20" rx="5" ry="5"></rect>
                                                    <path d="M16 11.37A4 4 0 1 1 12.63 8 4 4 0 0 1 16 11.37z"></path>
                                                    <line x1="17.5" y1="6.5" x2="17.51" y2="6.5"></line>
                                                </svg>
                                                Instagram
                                            </h6>
                                            <span class="text-secondary">store</span>
                                        </li>
                                        <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                            <h6 class="mb-0">
                                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                                                     viewBox="0 0 24 24" fill="none" stroke="currentColor"
                                                     stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                                                     class="feather feather-facebook mr-2 icon-inline text-primary">
                                                    <path d="M18 2h-3a5 5 0 0 0-5 5v3H7v4h3v8h4v-8h3l1-4h-4V7a1 1 0 0 1 1-1h3z"></path>
                                                </svg>
                                                store
                                            </h6>
                                            <span class="text-secondary">store</span>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-md-8">
                                <div class="card mb-3">
                                    <c:if test="${update eq null}">
                                        <div class="card-body">
                                            <div class="row">
                                                <div class="col-sm-3">
                                                    <h6 class="mb-0">Tên cửa hàng</h6>
                                                </div>
                                                <div class="col-sm-9 text-secondary">
                                                        ${store.name}
                                                </div>
                                            </div>
                                            <hr>
                                            <div class="row">
                                                <div class="col-sm-3">
                                                    <h6 class="mb-0">Mô tả thông tin</h6>
                                                </div>
                                                <div class="col-sm-9 text-secondary">
                                                    <div style="width: 400px">
                                                        <div style="width: 400px">
                                                                ${store.bio}
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <hr>
                                            <div class="row">
                                                <div class="col-sm-3">
                                                    <h6 class="mb-0"> Số điện thoại</h6>
                                                </div>
                                                <div class="col-sm-9 text-secondary">
                                                        ${user.phone}
                                                </div>
                                            </div>
                                            <hr>
                                            <div class="row">
                                                <div class="col-sm-3">
                                                    <h6 class="mb-0"> Email</h6>
                                                </div>
                                                <div class="col-sm-9 text-secondary">
                                                        ${user.email}
                                                </div>
                                            </div>
                                            <hr>
                                            <div class="row">
                                                <div class="col-sm-3">
                                                    <h6 class="mb-0"> Loại hoa hồng</h6>
                                                </div>
                                                <div class="col-sm-9 text-secondary">
                                                        ${store.commissionByCommissionId.name}
                                                </div>
                                            </div>
                                            <hr>
                                            <div class="row">
                                                <div class="col-sm-12">
                                                    <a class="btn btn-info " target="__blank"
                                                       href="update-info">Cập nhật thông tin</a>
                                                </div>
                                            </div>
                                        </div>
                                    </c:if>
                                    <c:if test="${update eq true}">
                                        <div class="card-body">
                                            <form action="update-info" method="post">
                                                <div class="row">
                                                    <div class="col-sm-3">
                                                        <h6 class="mb-0">Tên cửa hàng</h6>
                                                    </div>
                                                    <div class="col-sm-9 text-secondary">
                                                        <input name="name" type="text" value="${store.name}">
                                                    </div>
                                                </div>
                                                <hr>
                                                <div class="row">
                                                    <div class="col-sm-3">
                                                        <h6 class="mb-0">Mô tả thông tin</h6>
                                                    </div>
                                                    <div class="col-sm-9 text-secondary">
                                                        <textarea name="bio" type="text"
                                                                  style="width: 400px">${store.bio}</textarea>
                                                    </div>
                                                </div>
                                                <hr>
                                                <div class="row">
                                                    <div class="col-sm-3">
                                                        <h6 class="mb-0">Số điện thoại</h6>
                                                    </div>
                                                    <div class="col-sm-9 text-secondary">
                                                        <input name="phone" type="text" value="${user.phone}">
                                                    </div>
                                                </div>
                                                <hr>
                                                <div class="row">
                                                    <div class="col-sm-3">
                                                        <h6 class="mb-0">Email</h6>
                                                    </div>
                                                    <div class="col-sm-9 text-secondary">
                                                        <input name="email" type="email" value=" ${user.email}">
                                                    </div>
                                                </div>
                                                <hr>
                                                <div class="row">
                                                    <div class="col-sm-3">
                                                        <h6 class="mb-0"> Trạng thái</h6>
                                                    </div>
                                                    <div class="col-sm-9 text-secondary">
                                                        <select name="active">
                                                            <option value="true" selected>Hoạt động</option>
                                                            <option value="false">Ngừng hoạt động</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <hr>
                                                <div class="row">
                                                    <div class="col-sm-12">
                                                        <button class="btn btn-info" type="submit">Cập nhật thông
                                                            tin
                                                        </button>
                                                    </div>
                                                </div>
                                            </form>
                                            <hr>
                                            <div class="row">
                                                <div class="col-sm-3">
                                                    <h6 class="mb-0"> Ảnh đại diện</h6>
                                                </div>
                                                <div class="col-sm-9 text-secondary">
                                                    <form id="change-avatar" method="post"
                                                          enctype="multipart/form-data">
                                                        <input name="avatar" type="file">
                                                        <button class="btn btn-primary" type="submit">Thay đổi
                                                        </button>
                                                    </form>
                                                </div>
                                            </div>
                                            <hr>
                                            <div class="row">
                                                <div class="col-sm-3">
                                                    <h6 class="mb-0"> Ảnh bìa</h6>
                                                </div>
                                                <div class="col-sm-9 text-secondary">
                                                    <form id="change-cover" method="post"
                                                          enctype="multipart/form-data">
                                                        <input name="cover" type="file">
                                                        <button class="btn btn-primary" type="submit">Thay đổi
                                                        </button>
                                                    </form>
                                                </div>
                                            </div>
                                            <hr>
                                        </div>
                                    </c:if>

                                </div>

                                <div class="row gutters-sm">
                                    <div class="col-sm-6 mb-3">
                                        <div class="card h-100">
                                            <div class="card-body">
                                                <h6 class="d-flex align-items-center mb-3"><i
                                                        class="material-icons text-info mr-2">Độ hài lòng</i> [Khách
                                                    hàng]
                                                </h6>
                                                <small>Chuẩn bị đơn hàng</small>
                                                <div class="progress mb-3" style="height: 5px">
                                                    <div class="progress-bar bg-primary" role="progressbar"
                                                         style="width: 80%" aria-valuenow="80" aria-valuemin="0"
                                                         aria-valuemax="100"></div>
                                                </div>
                                                <small>Phản hồi</small>
                                                <div class="progress mb-3" style="height: 5px">
                                                    <div class="progress-bar bg-primary" role="progressbar"
                                                         style="width: 72%" aria-valuenow="72" aria-valuemin="0"
                                                         aria-valuemax="100"></div>
                                                </div>
                                                <small>Khuyến mãi</small>
                                                <div class="progress mb-3" style="height: 5px">
                                                    <div class="progress-bar bg-primary" role="progressbar"
                                                         style="width: 89%" aria-valuenow="89" aria-valuemin="0"
                                                         aria-valuemax="100"></div>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <div class="card h-100">
                                            <div class="card-body">
                                                <h6 class="d-flex align-items-center mb-3"><i
                                                        class="material-icons text-info mr-2">Độ uy tính</i>[Trên hệ
                                                    thống]</h6>
                                                <small>Tốc độ chuẩn bị đơn hàng</small>
                                                <div class="progress mb-3" style="height: 5px">
                                                    <div class="progress-bar bg-primary" role="progressbar"
                                                         style="width: 80%" aria-valuenow="80" aria-valuemin="0"
                                                         aria-valuemax="100"></div>
                                                </div>
                                                <small>Xử lý khiếu nại</small>
                                                <div class="progress mb-3" style="height: 5px">
                                                    <div class="progress-bar bg-primary" role="progressbar"
                                                         style="width: 72%" aria-valuenow="72" aria-valuemin="0"
                                                         aria-valuemax="100"></div>
                                                </div>
                                                <small>Đánh giá tốt</small>
                                                <div class="progress mb-3" style="height: 5px">
                                                    <div class="progress-bar bg-primary" role="progressbar"
                                                         style="width: 89%" aria-valuenow="89" aria-valuemin="0"
                                                         aria-valuemax="100"></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>


                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- // Main Content -->
</div>
<style>
    body {
        margin-top: 20px;
        color: #1a202c;
        text-align: left;
        background-color: #e2e8f0;
    }

    .main-body {
        padding: 15px;
    }

    .card {
        box-shadow: 0 1px 3px 0 rgba(0, 0, 0, .1), 0 1px 2px 0 rgba(0, 0, 0, .06);
    }

    .card {
        position: relative;
        display: flex;
        flex-direction: column;
        min-width: 0;
        word-wrap: break-word;
        background-color: #fff;
        background-clip: border-box;
        border: 0 solid rgba(0, 0, 0, .125);
        border-radius: .25rem;
    }

    .card-body {
        flex: 1 1 auto;
        min-height: 1px;
        padding: 1rem;
    }

    .gutters-sm {
        margin-right: -8px;
        margin-left: -8px;
    }

    .gutters-sm > .col, .gutters-sm > [class*=col-] {
        padding-right: 8px;
        padding-left: 8px;
    }

    .mb-3, .my-3 {
        margin-bottom: 1rem !important;
    }

    .bg-gray-300 {
        background-color: #e2e8f0;
    }

    .h-100 {
        height: 100% !important;
    }

    .shadow-none {
        box-shadow: none !important;
    }
</style>
<!-- If you prefer jQuery these are the required scripts -->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap4.min.js"></script>
<script src="${assets}/js/vendor.js"></script>
<script src="${assets}/js/adminx.js"></script>
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

    $("form#change-avatar, form#change-cover").submit(function (e) {
        e.preventDefault();
        var formData = new FormData(this);
        alert("chạy")
        $.ajax({
            url: 'upload-image-store',
            type: 'POST',
            data: formData,
            success: function (data) {
                alert('Cập nhật thành công !')
            },
            cache: false,
            contentType: false,
            processData: false
        });
    });

</script>

<!-- If you prefer vanilla JS these are the only required scripts -->
<!-- script src="assets/js/vendor.js"></script>
<script src="assets/js/adminx.vanilla.js"></script-->
</body>
</html>