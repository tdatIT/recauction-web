<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Thông tin sản phẩm - Laptipe</title>
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
        <div class="adminx-content">
            <div class="adminx-main-content">
                <div class="container-fluid">
                    <!-- BreadCrumb -->
                    <nav aria-label="breadcrumb" role="navigation">
                        <ol class="breadcrumb adminx-page-breadcrumb">
                            <li class="breadcrumb-item"><a href="./dashboard">Dashboard</a></li>
                            <li class="breadcrumb-item"><a href="./product">Sản phẩm</a></li>
                            <li class="breadcrumb-item active  aria-current=" page
                            ">Thông tin</li>
                        </ol>
                    </nav>
                    <div class="pb-3">
                        <h1>Thông tin sản phẩm</h1>
                    </div>
                    <form id="form-data" enctype="multipart/form-data" method="post">
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="card mb-grid">
                                    <div class="card-header">
                                        <div class="card-header-title">Thông tin</div>
                                    </div>
                                    <div class="card-body">
                                        <div class="form-group">
                                            <label class="form-label"></label>
                                            <input name="productId" id="productId" class="form-control mb-2"
                                                   type="hidden"
                                                   value="${product.productId}">
                                        </div>
                                        <c:if test="${status eq 0}">
                                            <div class="form-group">
                                                <div class="alert alert-warning" role="alert">
                                                    Thêm sản phẩm thất bại
                                                </div>
                                            </div>
                                        </c:if>
                                        <c:if test="${status eq 1}">
                                            <div class="form-group">
                                                <div class="alert alert-warning" role="alert">
                                                    Cập nhật sản phẩm thất bại
                                                </div>
                                            </div>
                                        </c:if>
                                        <div class="form-group">
                                            <label class="form-label">Tên sản phẩm</label>
                                            <input name="name" class="form-control mb-2" type="text" placeholder="Tên"
                                                   value="${product.name}">
                                        </div>
                                        <div class="form-group">
                                            <label class="form-label">Doanh mục sản phẩm</label>
                                            <select name="categoryId" name="select" class="form-control js-choice">
                                                <c:forEach items="${categories}" var="i">
                                                    <option value="${i.categoryId}">${i.name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>

                                        <div class="form-group">
                                            <label class="form-label">Giá Tiền</label>
                                            <input name="price" class="form-control  mb-2" type="number"
                                                   placeholder="Giá tiền sản phẩm" value="${product.price.intValue()}">
                                        </div>

                                        <div class="form-group">
                                            <label class="form-label">Giá tiền ưu đãi</label>
                                            <input name="promotionalPrice" class="form-control mb-2" type="number"
                                                   placeholder="Discount price"
                                                   value="${product.promotionalPrice.intValue()}">
                                        </div>

                                        <div class="form-group">
                                            <label class="form-label">Số lượng hàng</label>
                                            <input name="quantity" class="form-control mb-2" type="number"
                                                   placeholder="Số lượng trong kho hiện có" value="${product.quantity}">
                                        </div>
                                    </div>
                                    <div class="card-footer">
                                        Vui lòng nhập đúng thông tin <strong>sản phẩm</strong> để dễ dàng quản lý
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="card mb-grid">
                                    <div class="card-header">
                                        <div class="card-header-title">Thông tin bổ sung cho sản phẩm</div>
                                    </div>
                                    <div class="card-body">
                                        <div class="form-group">
                                            <label class="form-label">Trạng thái</label>
                                            <select name="status" class="form-control js-choice">
                                                <option value="1">Hoạt động</option>
                                                <option value="2">Không hoạt động</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label class="form-label">Mô tả sản phẩm</label>
                                            <textarea name="description" class="form-control mb-2" type="text"
                                                      placeholder="Chi tiết">${product.description}
                                            </textarea>
                                        </div>

                                        <div class="form-group">
                                            <label class="form-label">Link Video giới thiệu</label>
                                            <input name="video" class="form-control mb-2" type="text"
                                                   placeholder="Link youtube or cdn" value="${product.video}">
                                        </div>
                                        <c:if test="${images ne null}">
                                            <div class="form-group">
                                                <label class="form-label">Hình Ảnh</label>
                                                <div class="mb-2">
                                                    <img height="80px" width="80px"
                                                         src="${pageContext.request.contextPath}/${images[0].location}/${images[0].fileName}">
                                                </div>
                                            </div>
                                        </c:if>
                                        <div class="form-group">
                                            <label class="form-label">Hình Ảnh</label>
                                            <div class="mb-2">
                                                <input name="images" class="form-control" type="file"
                                                       accept="image/*"
                                                       id="formFileMultiple" multiple>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="card-footer">

                                        <div class="d-flex justify-content-between">
                                            <c:if test="${product eq null}">
                                                <a id="add-btn" class="btn btn-success text-white">Hoàn tất</a>
                                            </c:if>
                                            <c:if test="${product ne null}">
                                                <a id="update-btn" class="btn btn-primary text-white">Cập nhật</a>
                                                <a id="delete-btn" class="btn btn-warning text-white">Xóa sản phẩm</a>
                                            </c:if>

                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
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
<script src="${pageContext.request.contextPath}/view/vendor/assets/js/vendor.js"></script>
<script src="${pageContext.request.contextPath}/view/vendor/assets/js/adminx.js"></script>
<script>

    $('#add-btn').on('click', function () {
        $('#form-data').attr('action', 'product-create')
        document.getElementById("form-data").submit()
    })
    $('#update-btn').on('click', function () {
        $('#form-data').attr('action', 'product-update')
        document.getElementById("form-data").submit()

    })
    $('#delete-btn').on('click', function () {
        let productId = $('#productId').val();
        //create http request using ajax delete method
        $.post({
            url: 'product-delete',
            data: {
                productId: productId,
            },
            success: function (data) {
                window.location.href = 'http://localhost:8080/latipe_war_exploded/store-admin/product'
            }
        })
    })
    var choices = new Choices('.js-choice');

    var choices2 = new Choices('.js-choice-remove', {
        removeItemButton: true,
    });

    flatpickr(".date-default", {
        allowInput: true
    });
    flatpickr(".date-time", {
        allowInput: true,
        enableTime: true,
    });
    flatpickr(".date-human", {
        allowInput: true,
        altInput: true,
    });
    flatpickr(".date-inline", {
        allowInput: true,
        inline: true,
    });

</script>
</body>
</html>