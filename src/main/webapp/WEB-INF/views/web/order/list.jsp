<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đơn hàng</title>
</head>
<body>
<div class="comingsoon_area section_padding_100 bg-gray">
    <div class="container">
        <div class="row align-items-center justify-content-center">
            <div class="col-12 col-md-9 col-lg-6">
                <div class="cooming_soon_content text-center">
                    <div class="subscribe_bar">
                        <p>Thông tin đơn hàng của bạn</p>
                        <form class="bg0 p-t-75 p-b-85">
                            <div class="container">
                                <div class="row">
                                    <div class="col-lg-10 col-xl-7 m-lr-auto m-b-50">
                                        <div class="m-l-25 m-r--38 m-lr-0-xl">
                                            <div class="wrap-table-shopping-cart">
                                                <table class="table table-bordered">
                                                    <thead>
                                                    <tr>
                                                        <th>Tên sản phẩm</th>
                                                        <th>Số lượng</th>
                                                        <th>Giá</th>
                                                        <th>Tổng giá</th>
                                                        <th>Ngày</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <c:forEach var="item" items="${orders}">
                                                        <tr>
                                                            <td>${item.productName}</td>
                                                            <td>${item.quantity}</td>
                                                            <td>${item.price}</td>
                                                            <td>${item.totalPrice}</td>
                                                            <td>${item.createdDate}</td>
                                                        </tr>
                                                    </c:forEach>
                                                    </tbody>
                                                </table>
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
    </div>
</div>
<!-- Coming Soon Area End -->
<!-- Shoping Cart -->

<script>

    $(document).ready(function () {

    });
</script>
</body>
</html>
