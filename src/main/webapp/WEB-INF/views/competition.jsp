<%@ page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
  
   <meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="description" content="Unicat project">
	<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.12.0.min.js">
		 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/styles/bootstrap4/bootstrap.min.css">
	<link href="/plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="/plugins/OwlCarousel2-2.2.1/owl.carousel.css">
	<link rel="stylesheet" type="text/css" href="/plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
	<link rel="stylesheet" type="text/css" href="/plugins/OwlCarousel2-2.2.1/animate.css">
	<link href="/plugins/colorbox/colorbox.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="/styles/main_styles.css">
	<link rel="stylesheet" type="text/css" href="/styles/responsive.css">
    <link rel="stylesheet" type="text/css" href="/styles/blog_single.css">
<link rel="stylesheet" type="text/css" href="/styles/blog_single_responsive.css">
<link rel="stylesheet" type="text/css" href="/styles/blog.css">


<link rel="stylesheet" type="text/css" href="/styles/blog_responsive.css">
<link rel="stylesheet" type="text/css" href="/styles/courses.css">


	<link rel="stylesheet" type="text/css" href="/styles/courses_responsive.css">
			<link rel="stylesheet" type="text/css" href="/styles/course.css">
	
	
             
		  	<script src="/js/jquery-3.2.1.min.js"></script>
			<script src="/styles/bootstrap4/popper.js"></script>
			<script src="/styles/bootstrap4/bootstrap.min.js"></script>
			<script src="/plugins/greensock/TweenMax.min.js"></script>
			<script src="/plugins/greensock/TimelineMax.min.js"></script>
			<script src="/plugins/scrollmagic/ScrollMagic.min.js"></script>
			<script src="/plugins/greensock/animation.gsap.min.js"></script>
			<script src="/plugins/greensock/ScrollToPlugin.min.js"></script>
			<script src="/plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
			<script src="/plugins/easing/easing.js"></script>
			<script src="/plugins/parallax-js-master/parallax.min.js"></script>
			<script src="/js/custom.js"></script>
			<script src="/js/khoahoc.js"></script>
			<script src="/js/mail.js"></script>
			<script src="/js/competition.js"></script>
			  <script src="/js/news.js"></script>
			  <script src="/js/rating.js"></script>
			  <script src="/js/blog.js"></script>
			  <script src="/js/comment.js"></script>
			  <script src="/plugins/masonry/masonry.js"></script>
			  	<script src="/plugins/colorbox/jquery.colorbox-min.js"></script>
		<script src="/js/courses.js"></script>
				<script src="/js/course.js"></script>

<style>
.sidebar_categories ul{
                width: 220px;
               
 }

.sidebar_categories ul li{

                height: 30px;           /*Cao 30px*/
                line-height: 30px;      /*Cho chữ canh giữa 30px*/    
                list-style: none;       /*Không hiển thị dấu chấm đầu menu*/
                padding: 0px 10px;      /*đẩy nôi dung menu vào 10cm (trái + phải)*/
                background: white;       /*màu nèn màu hồng*/
                 /*đường viền màu đỏ*/
                border-bottom: none;    /*vì menu liền kề nhau nên border-bottom không cần*/
                position: relative;  
                 height: 41px;   /*chọn làm khung*/
 }

          .sidebar_categories  ul li:last-child{
                border-bottom: solid 1px red;
            }

          .sidebar_categories  ul li ul{
                width: 250px;
                position: absolute;     
                top: -1px;          /*cho ngang hàng với menu cha, vì menu cha có border - 1 nên ta phải trừ đi 1*/
                right: -211px;      /*vì nàm ngoài khung và dài 250px nên là số âm 250px */
                display: none; 
                z-index: 99;     /*Ban đầu sẽ không hiển thị*/
            }

          .sidebar_categories  ul li:hover ul{
                display: block;
            }
            
            .userProfile{
              color: #f6821f !important;
            }
            .pro{
              margin-bottom: 20px;
            }
            .rounded-circle:hover{
             opacity: 0;
            }
            CSS đơn giản như sau.

div.stars {}
 
a.star {
    font-size: 24px;
    color: #f0f1f4;
    cursor: pointer;
    line-height: 1;
    transition: all 0.1s ease;
}

a.star.vote-hover {
    color: #96e2fb;
}

a.star:active {
    color: #56CCF2;
}

a.star.vote-active {
    color: #0faef1;
}

.blue {
    color: #0faef1;
}

</style>
 
</head>
<body>

 <div class="super_container">
 	<header class="header">
			
			<!-- Top Bar -->
			<div class="top_bar" style="background: #ECECEC;">
				<div class="top_bar_container">
					<div class="container">
						<div class="row">
							<div class="col">
								<div class="top_bar_content d-flex flex-row align-items-center justify-content-start">
									
							<ul class="top_bar_contact_list" >
                                    <li>
                         <i class="fa fa-phone" aria-hidden="true"></i>
                      <div><a href="tel:1900 54 54 81">Hotline 1: 1900 54 54 81</a> | <a href="tel:">Hotline 2: </a></div>
                      </li>
                      <li>
                      <i class="fa fa-envelope-o" aria-hidden="true"></i>
                      <div><a href="mailto:vanphong@vnpost.vn">vanphong@vnpost.vn</a></div>
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
										<li class="Competition"><a href="/home/competition">Cuộc thi</a></li>
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
					<li class="menu_mm"><a href="index.html">Home</a></li>
					<li class="menu_mm"><a href="#">About</a></li>
					<li class="menu_mm"><a href="#">Courses</a></li>
					<li class="menu_mm"><a href="#">Blog</a></li>
					<li class="menu_mm"><a href="#">Page</a></li>
					<li class="menu_mm"><a href="contact.html">Contact</a></li>
				</ul>
			</nav>
		</div>

		<!-- Home -->

		<div class="home">
			<div class="breadcrumbs_container">
				<div class="container">
					<div class="row">
						<div class="col">
							<div class="breadcrumbs">
								<ul>
									<li><a href="index.html">Home</a></li>
									<li>Courses</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>			
		</div>

		<!-- Courses -->

		<div class="courses">
			<div class="container">
				<div class="row">

					<!-- Courses Main Content -->
					<div class="col-lg-9">
<div class="courses_search_container">
	<form action="/document/search" id="courses_search_form" class="">
		<div class="courses_search_form d-flex flex-row align-items-center justify-content-start">
			<input style="width:100%" name="keyword" type="search" class="courses_search_input" required="required"  placeholder="Từ khóa" value="">
			<button type="submit" class="courses_search_button ml-auto">Tìm kiếm</button>
		</div>
		<p class="pb-2" style="margin-top: -10px;">
			<input type="checkbox" name="onlyStudentDonvi" id="filterOnlyStudentDonvi" value="1">
			<label for="filterOnlyStudentDonvi">Chỉ hiển thị tài liệu ở đơn vị của tôi</label>
		</p>
	</form>
</div>
						<div class="courses_container">
						
			
					
							<div class="row courses_row courses_rows">
                <c:forEach var="c" items="${listC}">
								<!-- Course -->
								<div class="col-lg-6 course_col">
									<div class="course" style="width: 90%">
										<div class="course_image"><img src="/images/${c.imageCompetition}" alt=""></div>
										<div class="course_body">
                                        <h3 class="course_title"><a href="/competition/listTest/index/${c.id}">${c. nameCompetition}</a></h3>
                                          <div class="course_text">
                                          <small class="text-info"><i class="fa fa-building-o"></i>${c.poscodeVnpost.unitVnpost.name}</small>
                                          <p>${c.describe}</p>
                                        </div>
                                    </div>
							
									</div>
								</div>
				</c:forEach>
							</div>
							
	
						</div>
					</div>

					<!-- Courses Sidebar -->
					<div class="col-lg-3">
								<div class="sidebar" style="padding-top: 0px;"> 

							<!-- Categories -->
							<div class="sidebar_section">
								
								<div class="sidebar_categorie" style="margin-top: 20px; padding-top: 0px;">
                                        <ul class="list-group">
                                         <li class="list-group-item active">Tất cả cuộc thi</li>
                                      <c:forEach var="c" items="${listDC}">
                                        <li class="list-group-item "><a href="/competition/category/${c.id}">${c.nameCompetition}</a></li>
                                      </c:forEach>
                                         
                                        
                                         
                                         </ul>
								</div>
								<div>
								<ul class="list-group mt-5">
                                <li class="list-group-item active bg-green-dark">
                                 <a href="#" style="color: white;"> Tất cả cuộc thi <i class="fa fa-circle pull-right" style="position: relative; top: 4px"></i></a>
                               </li>
                               </ul>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Newsletter -->


		<!-- Newsletter -->


	<div class="newsletter">
				<div class="newsletter_background parallax-window" data-parallax="scroll" data-image-src="images/newsletter.jpg" data-speed="0.8"></div>
				<div class="container">
					<div class="row">
						<div class="col">
							<div class="newsletter_container d-flex flex-lg-row flex-column align-items-center justify-content-start" style="padding-bottom: 20px;">

								<!-- Newsletter Content -->
								<div class="newsletter_content text-lg-left text-center">
									<div class="newsletter_title">Đăng ký để được thông tin mới nhất</div>
									<div class="newsletter_subtitle">
									những ưu đãi mới nhất và ưu đãi tuyệt vời mà chúng tôi đem tới</div>
								</div>

								<!-- Newsletter Form -->
								<div class="newsletter_form_container ml-lg-auto">
									<form action="#" id="newsletter_form" class="newsletter_form d-flex flex-row align-items-center justify-content-center">
										<input type="email" name="email" class="newsletter_input" placeholder="Email của bạn" required="required">
										
										<button type="button" class="newsletter_button">Đăng ký</button>
									</form>
									
									
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- Footer -->

		<footer id="FOOTER_1" style="margin-top: -30px;">
			<div id="DIV_2">
			</div>
			<div id="DIV_3">
				<div id="DIV_4">
					<div id="DIV_5">
						<div id="DIV_6">
							<div id="DIV_7">
								<div id="DIV_8">
									<!-- Footer About -->

									<div id="DIV_9">
										<div id="DIV_10">
											<a href="https://vnpost.vnpt.edu.vn/" id="A_11"></a>
											<div id="DIV_12">
												<small id="SMALL_13">VNPOST <span id="SPAN_14">E-Learning</span></small>
											</div>
										</div>
										<div id="DIV_15">
											<p id="P_16">
												CHUYÊN BIỆT- KHÁC BIỆT - HIỆU QUẢ
											</p>
										</div> <a href="https://vnpost.vnpt.edu.vn/default/contact" id="A_17"><img src="https://vnpost.vnpt.edu.vn/theme/vnptit/images/icon-download/Group%202.svg" alt="" id="IMG_18" /></a> <a href="https://vnpost.vnpt.edu.vn/default/contact" id="A_19"><img src="https://vnpost.vnpt.edu.vn/theme/vnptit/images/icon-download/Group%2078.svg" alt="" id="IMG_20" /></a>
									</div>
								</div>
								<div id="DIV_21">
									<!-- Footer Contact -->

									<div id="DIV_22">
										<div id="DIV_23">
											Thông tin liên hệ
										</div>
										<div id="DIV_24">
											<ul id="UL_25">
												<li id="LI_26">
													Email: vanphong@vnpost.vn
												</li>
												<li id="LI_27">
													Phone: 1900 54 54 81 |
												</li>
												<li id="LI_28">
													Địa chỉ: Số 05 đường Phạm Hùng - Mỹ Đình 2 - Nam Từ Liêm - Hà Nội - Việt Nam
												</li>
											</ul>
										</div>
									</div>
								</div>
								<div id="DIV_29">
									<!-- Footer links -->

									<div id="DIV_30">
										<div id="DIV_31">
											Danh mục
										</div>
										<div id="DIV_32">
											<ul id="UL_33">
												<li id="LI_34">
													<a href="https://vnpost.vnpt.edu.vn/" id="A_35">Trang chủ</a>
												</li>
												<li id="LI_36">
													<a href="https://vnpost.vnpt.edu.vn/default/about" id="A_37">Giới thiệu</a>
												</li>
												<li id="LI_38">
													<a href="https://vnpost.vnpt.edu.vn/default/contact" id="A_39">Liên hệ</a>
												</li>
												<li id="LI_40">
													<a href="https://vnpost.vnpt.edu.vn/course/index" id="A_41">Khóa học</a>
												</li>
												<li id="LI_42">
													<a href="https://vnpost.vnpt.edu.vn/news/index" id="A_43">Tin tức</a>
												</li>
											</ul>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div id="DIV_44">
				<small id="SMALL_45">10.159.133.17|10.159.133.39|15:59:02 19/03/2020</small>
			</div>
		</footer>

</div>

  
</body>

</html>