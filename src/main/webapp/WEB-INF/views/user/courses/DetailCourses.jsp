<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
							<form action="#" id="courses_search_form" class="courses_search_form d-flex flex-row align-items-center justify-content-start">
								<input type="search" class="courses_search_input" placeholder="Search Courses" required="required" style="width: 480px;">
								
								<button action="submit" class="courses_search_button ml-auto">search now</button>
							</form>
						</div>
				
						<div class="courses_container">
				<c:if  test="${fn:length(list)==0}">	
				<div class="alert alert-warning text-center w-100 mt-3" style="color: #f6821f;  background-color: #fff3cd; border-color: #ffeeba; margin-top: 200px;">
                        <i class="fa fa-exclamation-triangle"></i> ${mes} 
                        <a class="" href="/home/courses">Tất cả khóa học</a>
                 </div>
					</c:if>	
							<div class="row courses_row courses_rows">
							
             <c:forEach var="c" items="${list}">
								<!-- Course -->
								<div class="col-lg-4 course_col">
									<div class="course" style="width: 100%">
										<div class="course_image"><img src="/images/${c.avatar}" alt=""></div>
										<div class="course_body">
											<h3 class="course_title"><a href="/home/courses/detail/${c.id}">${c.name}</a></h3>
											<div class="course_teacher">${c.createdBy}</div>
											
											<div class="course_text">
											
												<p>Đơn vị : ${c.poscodeVnpost.address}</p>
											</div>
										</div>
										<div class="course_footer">
											<div class="course_footer_content d-flex flex-row align-items-center justify-content-start">
												<div class="course_info">
													<i class="fa fa-book" aria-hidden="true"></i>
													<span>20 chương mục</span>
												</div>
												<div class="course_info">
													<i class="fa fa-star" aria-hidden="true"></i>
													<span>5</span>
												</div>
												<div class="course_price ml-auto">${c.price}</div>
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
						<div class="sidebar">

							<!-- Categories -->
							<div class="sidebar_section">
								<div class="sidebar_section_title">Danh Mục Khóa Học</div>
								<div class="sidebar_categories">
									<ul class="cate">
									 <c:forEach var="c" items="${list1}">				
										<li style="margin-top: 5px; padding-bottom :10px;">
											<a id="${c.id}" data-id="${c.id}" href="/home/detail/course/${c.id}"><span>${c.name}</span><span class="fa fa-angle-right" style="margin-left: 30px;"></span></a>
											<ul>
												
											</ul>
										</li>
                                     </c:forEach>
										
										
									</ul>
								</div>
								<div>
								<ul class="list-group mt-5">
                                <li class="list-group-item active bg-green-dark">
                                 <a href="/home/courses" style="color: white;">Khóa học của tôi <i class="fa fa-circle pull-right" style="position: relative; top: 4px"></i></a>
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
