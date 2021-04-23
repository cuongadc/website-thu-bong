<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Trang chủ</title>
</head>
<body>
<!-- Welcome Slides Area -->
<section class="welcome_area">
    <div class="welcome_slides modern-slides owl-carousel">
        <!-- Single Slide -->
        <div class="single_slide bg-img bg-overlay" style="background-image: url(web/slide/slide-1.png);">
            <div class="container h-100">
                <div class="row h-100 align-items-center">
                    <div class="col-12">
                        <div class="welcome_slide_text text-center">
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Single Slide -->
        <div class="single_slide bg-img bg-overlay" style="background-image: url(web/slide/slide-2.jpg);">
            <div class="container h-100">
                <div class="row h-100 align-items-center">
                    <div class="col-12">
                        <div class="welcome_slide_text text-center">
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Single Slide -->
        <div class="single_slide bg-img bg-overlay" style="background-image: url(web/slide/slide-3.jpg);">
            <div class="container h-100">
                <div class="row h-100 align-items-center">
                    <div class="col-12">
                        <div class="welcome_slide_text text-center">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Welcome Slides Area -->

<!-- New Arrivals Area -->
<div class="new_arrival home-3 section_padding_100_70">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <div class="popular_section_heading mb-50 text-center">
                    <h5>Sản phẩm bán chạy</h5>
                </div>
            </div>
        </div>

        <div class="row justify-content-center">
            <c:forEach var="item" items="${productHots}">
                <div class="col-9 col-sm-6 col-md-4 col-lg-3">
                    <div class="single_popular_item">
                        <div class="product_image">
                            <!-- Product Image -->
                            <c:set var="thumbnail" value="/repository${item.thumbnail}"/>
                            <img class="first_img" src="${thumbnail}" alt="" style="width:300px; height:300px">
                        </div>
                        <!-- Product Description -->
                        <div class="product_description">
                            <h5><a href="<c:url value='/${item.seoUrl}-${item.id}'/>">${item.name}</a></h5>
                            <h6>${item.priceDescription}</h6>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<!-- New Arrivals Area -->
</body>
</html>