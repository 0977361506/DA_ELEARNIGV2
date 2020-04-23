<%@ page  pageEncoding="utf-8"%>
<header class="header">
	
	<!-- Top Bar -->
	<div class="top_bar" style="background: #ECECEC;">
		<div class="top_bar_container">
			<div class="container">
				<div class="row">
					<div class="col">
						<div class="top_bar_content d-flex flex-row align-items-center justify-content-start">
							<ul class="top_bar_contact_list">

								<li>
									<i class="fa fa-phone" aria-hidden="true"></i>
									<div><a href="tel:1900 54 54 81" title="">1900 54 54 81  | </a></div>
								</li>
								<li>
									<i class="fa fa-envelope-o" aria-hidden="true"></i>
									<div><a href="mailto:vanphong@vnpost.vn" title=""><b>vanphong@vnpost.vn</b></a></div>
								</li>
							</ul>
							
							<div class="top_bar_login ml-auto">
								<div class="login_button" style="background: #ECECEC;">
									<button class="btn btn-sm btn-primary dropdown-toggle " type="button" id="userDropdownMenuBtn" data-toggle="dropdown" style="padding:10px; font-size: 10px;">
										<i class="fa fa-sign-in"></i> &nbsp; Đăng nhập
									</button>
									<div class="dropdown-menu" style="position: absolute; transform: translate3d(0px, 30px, 0px); top: 0px; left: 0px; will-change: transform;">

										<a style="font-size: 90%;" class="dropdown-item" href="#" data-toggle="modal" data-target="#myModal" title="Đăng nhập bằng email cá nhân">Sử dụng Tên đăng nhập</a>
									</div>
								</div>
								
								<!-- Modal -->
								<!-- The Modal -->
								<div style="" class="modal" id="myModal">
									<div class="modal-dialog">
										<div class="modal-content">

											<!-- Modal Header -->
											<div class="modal-header">
												<h4 class="modal-title text-center">Nhập thông tin tài khoản của bạn</h4>
												<button type="button" class="close" data-dismiss="modal">&times;</button>
											</div>

											<!-- Modal body -->
											<div class="modal-body">
												<form action="hotro_submit" class="form-group">
													<label>Tên tài khoản</label>
													<input type="text" name="" class="form-control"> 
													<label>Nhập PassWord</label>
													<input type="text" name="" class="form-control"> 
													<button type="submit" class="btn btn-primary"  style="margin: 20px 170px;">Đăng Nhập</button>
												</form>
											</div>

											<!-- Modal footer -->


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

	<!-- Header Content -->
	<div class="header_container">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="header_content d-flex flex-row align-items-center justify-content-start">
						<div class="logo_container">
							<a href="#">
								<div class="logo_text"><a class="navbar-brand" href="/home/index"><img src="/image/trangchu.png" style="max-width: 120px; max-height: 90px; margin-top: -20px;"></a></div>
							</a>
						</div>
						<nav class="main_nav_contaner ml-auto">
							<ul class="main_nav">
								<li id ="replaceAll1" class="active"><a href="/home/introduce">Giới thiệu</a></li>
								<li id ="replaceAll2" class="sss"><a href="/home/courses">Khóa học</a></li>
								<li class="Competition"><a href="/competition/home">Cuộc thi</a></li>
								<li id ="replaceAll3"  class="info"><a  href="/home/document">Tài liệu</a></li>
								<li id ="replaceAll4"  class="new"><a href="/home/news">Tin tức</a></li>
								<li  id ="replaceAll5" class="new"><a href="/home/events">Sự Kiện</a></li>
								<li id ="replaceAll6"  class="support"><a href="/home/support">Hỗ trợ</a></li>
							</ul>
							<div class="search_button"></div>

							<!-- Hamburger -->

							<div class="shopping_cart"></div>
							<div class="hamburger menu_mm">
								<i class="fa fa-bars menu_mm" aria-hidden="true"></i>
							</div>
						</nav>

					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Header Search Panel -->
	<div class="header_search_container">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="header_search_content d-flex flex-row align-items-center justify-content-end">
						<form action="#" class="header_search_form">
							<input type="search" class="search_input" placeholder="Search" required="required">
							<button class="header_search_button d-flex flex-column align-items-center justify-content-center">
								<i class="fa fa-search" aria-hidden="true"></i>
							</button>
						</form>
					</div>
				</div>
			</div>
		</div>			
	</div>			
</header>

<!-- Menu -->

<div class="menu d-flex flex-column align-items-end justify-content-start text-right menu_mm trans_400">
	<div class="menu_close_container"><div class="menu_close"><div></div><div></div></div></div>
	<div class="search">
		<form action="#" class="header_search_form menu_mm">
			<input type="search" class="search_input menu_mm" placeholder="Search" required="required">
			<button class="header_search_button d-flex flex-column align-items-center justify-content-center menu_mm">
				<i class="fa fa-search menu_mm" aria-hidden="true"></i>
			</button>
		</form>
	</div>
	<nav class="menu_nav">
		<ul class="menu_mm">
			<li class="menu_mm"><a href="index.html">Giới thiệu</a></li>
			<li class="menu_mm"><a href="#">Khóa học</a></li>
			<li class="menu_mm"><a href="#">Cuộc thi</a></li>
			<li class="menu_mm"><a href="#">Tài liệu</a></li>
			<li class="menu_mm"><a href="#">Tin tức</a></li>
			<li class="menu_mm"><a href="contact.html">Hỗ trợ</a></li>
		</ul>
	</nav>
</div>

<!-- Home -->
