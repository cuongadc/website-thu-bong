<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><html>
<head>
    <title>Title</title>
</head>
<body>
<!-- Breadcumb Area -->
<div class="breadcumb_area">
    <div class="container h-100">
        <div class="row h-100 align-items-center">
            <div class="col-12">
                <h5>${category.name}</h5>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="<c:url value="/trang-chu"/>">Trang chủ</a></li>
                    <li class="breadcrumb-item active">${category.name}</li>
                </ol>
            </div>
        </div>
    </div>
</div>
<!-- Breadcumb Area -->

<!-- Shop List Area -->
<section class="shop_list_area section_padding_100">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-12 col-md-10">
                <div class="shop_list_product_area">
                        <div class="row">
                            <c:forEach var="item" items="${products}">
                                <!-- Single Product -->
                                <div class="col-12">
                                    <div class="single-product-area mb-30">
                                        <div class="product_image">
                                            <!-- Product Image -->
                                            <c:set var="thumbnail" value="/repository${item.singleImage}"/>
                                            <img class="normal_img" src="${thumbnail}" alt="">
                                        </div>

                                        <!-- Product Description -->
                                        <div class="product_description">
                                            <!-- Add to cart -->
                                            <div class="product_add_to_cart">
                                                <a href="<c:url value='/${item.seoUrl}-${item.id}'/>"><i class="icofont-eye-alt"></i> Xem chi tiết</a>
                                            </div>
                                            <a href="<c:url value='/${item.seoUrl}-${item.id}'/>">${item.name}</a>
                                            <h6 class="product-price">${item.priceDescription}</h6>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Shop List Area -->
</body>
</html>
