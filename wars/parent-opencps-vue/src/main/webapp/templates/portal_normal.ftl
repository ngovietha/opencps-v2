<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>Hệ thống Dịch vụ công trực tuyến</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<base href="/">
	
	<@liferay_util["include"] page=top_head_include />
	
	<link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700,900|Material+Icons&amp;subset=vietnamese" rel="stylesheet">
	<link type="text/css" href="${themeDisplay.getPathThemeRoot()}/css/base-style.css?t=21" rel="stylesheet">
	<link type="text/css" href="${themeDisplay.getPathThemeRoot()}/css/app_custom.css?t=21" rel="stylesheet">
	
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" crossorigin="anonymous"></script>
	<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.5/handlebars.js"></script>
	<script type="text/javascript" src="http://code.cloudcms.com/alpaca/1.5.24/bootstrap/alpaca.min.js"></script>
	<script type="text/javascript" src="${themeDisplay.getPathThemeRoot()}/js/jquery_comment.js"></script>
	
</head>

<body class="${css_class} mBody">

	<@liferay_util["include"] page=body_top_include />
	
	<#if permissionChecker.isOmniadmin()>
	  	<@liferay.control_menu />
	<#else>
	  	<style>
		    html .has-control-menu #wrapper {
		        margin-top: 0 !important;
		    }
		    html body.open #wrapper {
		      padding-left: 0 !important;
		    }
	  	</style>
	</#if>

	<div class="mWrapper">
		<header id="banner">		
			<div class="container align-middle">
				<div class="logo">
					<a href="${site_default_url}" class="align-middle">
						<img src="${themeDisplay.getPathThemeRoot()}/images/logo.png">
						<div class="text-logo">
							${site_name}
							<span>HỆ THỐNG MỘT CỬA ĐIỆN TỬ VÀ DỊCH VỤ CÔNG TRỰC TUYẾN</span>
						</div>
					</a>
				</div>
				
			<@liferay_portlet["runtime"] portletName="npmreactlogin"/>

			</div>
		</header>
		
		<#if has_navigation && is_setup_complete>
			<#include "${full_templates_path}/navigation.ftl" />
		</#if>

		<section id="main-content">
			<div class="container-fluid">
				<#if selectable>
					<@liferay_util["include"] page=content_include />
				<#else>
					${portletDisplay.recycle()}

					${portletDisplay.setTitle(the_title)}
					
					<@liferay_theme["wrap-portlet"] page="portlet.ftl">
						<@liferay_util["include"] page=content_include />
					</@>
				</#if>
			</div>
		</section>

		<footer id="footer">
			<div class="container">
				<div class="left">
					<div class="site-name"><!--Cổng dịch vụ công trực tuyến--> <span>${site_name_cus}</span> </div>
					<div class="contact">
						<p><i class="fa fa-map-marker"></i> ${address}</p>
						<p><i class="fa fa-phone"></i> ${phone}</p>
						<p><i class="fa fa-envelope"></i> ${email}</p>
					</div>
				</div>
				<div class="right">
					<div class="hotline align-middle">
						<img src="${themeDisplay.getPathThemeRoot()}/images/hotline.png">
						<div>
							<p>Đường dây nóng</p>
							<span>${hotline}</span>
						</div>
					</div>
					<p class="align-middle">
						<img src="${themeDisplay.getPathThemeRoot()}/images/logo-viettel.png">
						Phát triển bởi Tập đoàn Công nghiệp - Viễn thông Quân đội <a href="http://viettel.com.vn/vi" target="_blank"> Viettel </a>
					</p>
				</div>
			</div>
		</footer>
	</div>
	
	<@liferay_util["include"] page=body_bottom_include />

	<@liferay_util["include"] page=bottom_include />

</body>

<script type="text/javascript">
	    $.ajaxSetup({
			headers: {"Token": Liferay.authToken},
			global: true
		});
</script>

</html>
