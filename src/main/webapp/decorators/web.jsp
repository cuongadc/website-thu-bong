<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
	
	<!-- Favicon  -->
	<link rel="icon" href="web/img/core-img/favicon.ico">

	<!-- Style CSS -->
	<link rel="stylesheet" href="web/style.css">

	<script src="web/js/jquery.min.js"></script>
</head>
<body>

	<!-- Preloader -->
	<div id="preloader">
		<div class="spinner-grow" role="status">
			<span class="sr-only">Loading...</span>
		</div>
	</div>

	<!-- Navigation -->
	<%@ include file="/common/web/header.jsp" %>

	<dec:body/>

	<!-- Footer -->
	<%@ include file="/common/web/footer.jsp" %>

	<!-- jQuery (Necessary for All JavaScript Plugins) -->
	<script src="web/js/popper.min.js"></script>
	<script src="web/js/bootstrap.min.js"></script>
	<script src="web/js/jquery.easing.min.js"></script>
	<script src="web/js/default/classy-nav.min.js"></script>
	<script src="web/js/owl.carousel.min.js"></script>
	<script src="web/js/default/scrollup.js"></script>
	<script src="web/js/waypoints.min.js"></script>
	<script src="web/js/jquery.countdown.min.js"></script>
	<script src="web/js/jquery.counterup.min.js"></script>
	<script src="web/js/jquery-ui.min.js"></script>
	<script src="web/js/jarallax.min.js"></script>
	<script src="web/js/jarallax-video.min.js"></script>
	<script src="web/js/jquery.magnific-popup.min.js"></script>
	<script src="web/js/jquery.nice-select.min.js"></script>
	<script src="web/js/wow.min.js"></script>
	<script src="web/js/default/active.js"></script>
</body>
</html>