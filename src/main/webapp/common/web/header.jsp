<%@ page import="com.laptrinhjavaweb.security.utils.SecurityUtils" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- Header Area -->
<header class="header_area">

	<!-- Main Menu -->
	<div class="bigshop-main-menu">
		<div class="container">
			<div class="classy-nav-container breakpoint-off">
				<nav class="classy-navbar" id="bigshopNav">

					<!-- Nav Brand -->
					<a href="<c:url value="/trang-chu"/>" class="nav-brand"><img src="web/img/core-img/logo.png" alt="logo"></a>

					<!-- Toggler -->
					<div class="classy-navbar-toggler">
						<span class="navbarToggler"><span></span><span></span><span></span></span>
					</div>

					<!-- Menu -->
					<div class="classy-menu">
						<!-- Close -->
						<div class="classycloseIcon">
							<div class="cross-wrap"><span class="top"></span><span class="bottom"></span></div>
						</div>

						<!-- Nav -->
						<div class="classynav">
							<ul>
								<c:forEach var="item" items="${categories}">
									<li><a href="<c:url value='/the-loai-${item.code}'/>">${item.name}</a></li>
								</c:forEach>
							</ul>
						</div>
					</div>

					<!-- Hero Meta -->
					<div class="hero_meta_area ml-auto d-flex align-items-center justify-content-end">
						<security:authorize access="isAuthenticated()">
							<c:set var="id" value="<%=SecurityUtils.getPrincipal().getId()%>"/>
							<div class="account-area">
								<div class="user-thumbnail">
									<img src="img/bg-img/user.jpg" alt="">
								</div>
								<ul class="user-meta-dropdown">
									<li class="user-title"><span>Hello,</span> <%=SecurityUtils.getPrincipal().getFullName()%></li>
									<li><a href="<c:url value='/profile?id=${id}'/>">Tài khoản</a></li>
									<li><a href="<c:url value='/don-hang'/>">Đơn hàng</a></li>
									<li><a href="<c:url value='/logout'/>"><i class="icofont-logout"></i> Thoát</a></li>
								</ul>
							</div>
						</security:authorize>
						<security:authorize access="!isAuthenticated()">
							<!-- Account -->
							<div class="account-area">
								<div class="user-thumbnail">
									<img src="img/bg-img/user.jpg" alt="">
								</div>
								<ul class="user-meta-dropdown">
									<li><a href="<c:url value='/login'/>">Đăng nhập</a></li>
									<li><a href="<c:url value='/profile'/>">Đăng ký</a></li>
								</ul>
							</div>
						</security:authorize>
					</div>
				</nav>
			</div>
		</div>
	</div>
</header>
<!-- Header Area End -->