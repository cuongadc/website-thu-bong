<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="apiAddToCart" value="/api/order"/>
<html>
<head>
    <title>Chi tiết sản phẩm</title>
</head>
<body>
<!-- Breadcumb Area -->
<div class="breadcumb_area">
    <div class="container h-100">
        <div class="row h-100 align-items-center">
            <div class="col-12">
                <h5>${model.name}</h5>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="<c:url value="/trang-chu"/>">Trang chủ</a></li>
                    <li class="breadcrumb-item"><a href="<c:url value="/the-loai-${model.productCategoryCode}"/>">${model.productCategoryName}</a></li>
                    <li class="breadcrumb-item active">${model.name}</li>
                </ol>
            </div>
        </div>
    </div>
</div>
<!-- Breadcumb Area -->

<!-- Single Product Details Area -->
<section class="single_product_details_area section_padding_100">
    <div class="container">
        <div class="row">
            <div class="col-12 col-lg-6">
                <div class="single_product_thumb">
                    <div id="product_details_slider" class="carousel slide" data-ride="carousel">

                        <!-- Carousel Inner -->
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <c:set var="firstImage" value="/repository${model.firstImage}"/>
                                <a class="gallery_img" href="${firstImage}" title="First Slide">
                                    <img class="d-block w-100" src="${firstImage}" alt="First slide">
                                </a>
                            </div>
                            <c:forEach var="item1" items="${model.imageProducts}">
                                <div class="carousel-item">
                                    <c:set var="imageProductDetailv1" value="/repository${item1}"/>
                                    <a class="gallery_img" href="${imageProductDetailv1}" title="">
                                        <img class="d-block w-100" src="${imageProductDetailv1}" alt="">
                                    </a>
                                </div>
                            </c:forEach>
                        </div>

                        <!-- Carosel Indicators -->
                        <ol class="carousel-indicators">
                            <li class="active" data-target="#product_details_slider" data-slide-to="0" style="background-image: url(${firstImage});">
                            </li>
                            <c:forEach var="item2" items="${model.imageProducts}" varStatus="count">
                                <c:if test="${count.index >= 1}">
                                    <c:set var="imageProductDetailv2" value="/repository${item2}"/>
                                    <li data-target="#product_details_slider" data-slide-to="${count.index}" style="background-image: url(${imageProductDetailv2});">
                                    </li>
                                </c:if>
                            </c:forEach>
                        </ol>
                    </div>
                </div>
            </div>

            <!-- Single Product Description -->
            <div class="col-12 col-lg-6">
                <div class="single_product_desc">
                    <h4 class="title mb-2">${model.name}</h4>
                    <h4 class="price mb-4">${model.priceDescription}</h4>

                    <!-- Overview -->
                    <div class="short_overview mb-4">
                        <p>${model.shortDescription}</p>
                    </div>

                    <!-- Add to Cart Form -->
                    <form class="cart clearfix my-5 d-flex flex-wrap align-items-center" method="post">
                        <div class="quantity">
                            <input type="number" class="qty-text form-control" id="quantity" step="1" min="1" max="12" name="quantity" value="1">
                        </div>
                        <button type="button" name="addtocart" value="5" class="btn btn-primary mt-1 mt-md-0 ml-1 ml-md-3" id="addtocart">Chọn mua</button>
                    </form>
                    <input type="hidden" value="${model.id}" id="productId"/>
                </div>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-12">
                <div class="product_details_tab section_padding_100_0 clearfix">
                    <!-- Tabs -->
                    <ul class="nav nav-tabs" role="tablist" id="product-details-tab">
                        <li class="nav-item">
                            <a href="#description" class="nav-link active" data-toggle="tab" role="tab">Mô tả sản phẩm</a>
                        </li>
                    </ul>
                    <!-- Tab Content -->
                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane fade show active" id="description">
                            <div class="description_area">
                                <p>${model.content}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Single Product Details Area End -->

<script>
    $(document).ready(function () {

    });

    $('#addtocart').click(function (event) {
        event.preventDefault();
        var data = {};
        var productId = $('#productId').val();
        var quantity = $('#quantity').val();
        data["productId"] = productId;
        data["quantity"] = quantity;
        $.ajax({
            url: '${apiAddToCart}',
            type: 'POST',
            contentType:'application/json',
            data: JSON.stringify(data),
            success: function(res) {
                window.location.href = "<c:url value='/don-hang'/>";
            },
            error: function(res) {
                console.log(res);
            }
        });
    });
</script>
</body>
</html>
