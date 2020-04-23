<%@ page  pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="home" style="margin-bottom:300px; margin-top: 133px;">
			<div class="home_slider_container">

				<!-- Home Slider -->
				<div class="owl-carousel owl-theme home_slider">

					<!-- Home Slider Item -->
					<div class="owl-item">
						<div class="home_slider_background" style="background-image:url(/images/home_slider_1.jpg)"></div>
						
					</div>

					<!-- Home Slider Item -->
					<div class="owl-item">
						<div class="home_slider_background" style="background-image:url(/images/home_slider_1.jpg)"></div>
						
					</div>

					<!-- Home Slider Item -->
					<div class="owl-item">
						<div class="home_slider_background" style="background-image:url(/images/home_slider_1.jpg)"></div>
						
					</div>

				</div>
			</div>

			<!-- Home Slider Nav -->

			<div class="home_slider_nav home_slider_prev "  style="margin-top:190px;" ><i class="fa fa-angle-left" aria-hidden="true"></i></div>
			<div class="home_slider_nav home_slider_next" style="margin-top:190px;"><i class="fa fa-angle-right" aria-hidden="true"></i></div>
		</div>

		<!-- Features -->

		

		<!-- Popular Courses -->

		<div class="courses" >
			
			<div class="container">
				<div class="row">
					<div class="col">
						<div class="section_title_container text-center">
							<h2 class="section_title">Khóa Học Nổi Bật</h2>
							
						</div>
					</div>
				</div>
				<div class="row courses_row">
      <c:forEach var="c" items="${cou}">  
					<!-- Course -->
					<div class="col-lg-4 course_col">
						<div class="course">
							<div class="course_image"><img src="/images/${c.avatar}" alt=""></div>
							<div class="course_body">
								<h3 class="course_title"><a href="/home/courses/detail/${c.id}" class="text-center" style="font-size:15px;">${c.name}</a></h3>
								<div class="course_teacher">${c.createdBy}</div>
								<div class="course_text">
									  <c:if test="${c.courseConfig.approveAuto == 1}">
									  <p>Đăng kí tự do</p>
									  </c:if>
								        <c:if test="${c.courseConfig.approveAuto == 0}">
									  <p>Khóa học không cho phép đăng kí tự do</p>
									  </c:if>
								</div>
							</div>
							<div class="course_footer">
								<div class="course_footer_content d-flex flex-row align-items-center justify-content-start">
									<div class="course_info">
										<i class="fa fa-book" aria-hidden="true"></i>
										<span>Chủ đề</span>
									</div>
									<div class="course_info">
										<i class="fa fa-star" aria-hidden="true"></i>
										<span>5</span>
									</div>
									<div class="course_price ml-auto"> <c:if test="${c.price==0}">
													<div class="courses_price">Miễn Phí</div>
                                                     </c:if>
                                                     <c:if test="${c.price > 0}">
													<div class="courses_price">${c.price}</div>
                                                     </c:if></div>
								</div>
							</div>
						</div>
					</div>
 </c:forEach>
		

				</div>
			</div>
  </div>
			<!-- Counter -->


			<div class="courses" style=" background: #ECECEC;">
				<div class="section_background parallax-window" data-parallax="scroll"  data-speed="0.8"></div>
				<div class="container">
					<div class="row">
						<div class="col">
							<div class="section_title_container text-center">
								<h2 class="section_title">Khóa Học Mới</h2>

							</div>
						</div>
					</div>
					<div class="row courses_row">
                              <c:forEach var="c" items="${cous}">  
					<!-- Course -->
					<div class="col-lg-4 course_col">
						<div class="course">
							<div class="course_image"><img src="/images/${c.avatar}" alt=""></div>
							<div class="course_body">
								<h3 class="course_title"><a href="/home/courses/detail/${c.id}" class="text-center" style="font-size:15px;">${c.name}</a></h3>
								<div class="course_teacher">${c.createdBy}</div>
								<div class="course_text">
									  <c:if test="${c.courseConfig.approveAuto == 1}">
									  <p>Đăng kí tự do</p>
									  </c:if>
								        <c:if test="${c.courseConfig.approveAuto == 0}">
									  <p>Khóa học không cho phép đăng kí tự do</p>
									  </c:if>
								</div>
							</div>
							<div class="course_footer">
								<div class="course_footer_content d-flex flex-row align-items-center justify-content-start">
									<div class="course_info">
										<i class="fa fa-book" aria-hidden="true"></i>
										<span>Chủ đề</span>
									</div>
									<div class="course_info">
										<i class="fa fa-star" aria-hidden="true"></i>
										<span>5</span>
									</div>
									<div class="course_price ml-auto"> <c:if test="${c.price==0}">
													<div class="courses_price">Miễn Phí</div>
                                                     </c:if>
                                                     <c:if test="${c.price > 0}">
													<div class="courses_price">${c.price}</div>
                                                     </c:if></div>
								</div>
							</div>
						</div>
					</div>
 </c:forEach>
		
						<!-- Course -->
	

						<!-- Course -->
	


						<!-- Course -->


					</div>
				</div>

			</div>


			<div class="courses">
				<div class="section_background parallax-window" data-parallax="scroll"  data-speed="0.8"></div>
				<div class="container">
					<div class="row">
						<div class="col">
							<div class="section_title_container text-center">
								<h2 class="section_title">Cuộc thi nổi bật</h2>

							</div>
						</div>
					</div>
					<div class="row courses_row">
            
						<!-- Course -->
						<div class="col-lg-4 course_col">
							<div class="course">
								<div class="course_image"><img src="/images/cours.jpg" alt=""></div>
								<div class="course_body">
									<h3 class="course_title"><a href="course.html">Đào tạo tiếng anh</a></h3>
									<div class="course_teacher">Lê Hiếu</div>
									<div class="course_text">
										<p>Đăng kí tự do</p>
									</div>
								</div>

							</div>
						</div>

						<!-- Course -->
						<div class="col-lg-4 course_col">
							<div class="course">
								<div class="course_image"><img src="/images/cours.jpg" alt=""></div>
								<div class="course_body">
									<h3 class="course_title"><a href="course.html">Đào tạo tiếng anh</a></h3>
									<div class="course_teacher">Lê Hiếu</div>
									<div class="course_text">
										<p>Đăng kí tự do</p>
									</div>
								</div>

							</div>
						</div>


						<!-- Course -->


					</div>
				</div>

			</div>
			<!-- Events -->

			<div class="events">
				<div class="container">
					<div class="row">
						<div class="col">
							<div class="section_title_container text-center">
								<h2 class="section_title">Sự kiện sắp diễn ra</h2>

							</div>
						</div>
					</div>
					<div class="row events_row">

						<!-- Event -->
						      <c:forEach var="cc" items="${list2}">
						<!-- Event -->
						<div class="col-lg-4 event_col">
							<div class="event event_left">
								<div class="event_image"><img src="/images/${cc.image}" alt=""></div>
								<div class="event_body d-flex flex-row align-items-start justify-content-start">
									<div class="event_date">
										<div class="d-flex flex-column align-items-center justify-content-center trans_200">
											<div class="event_day trans_200"><fmt:formatDate value="${cc.timeStart}" pattern="dd"/></div>
											<div class="event_month trans_200"><fmt:formatDate value="${cc.timeStart}" pattern="MM"/></div>
										</div>
									</div>
									<div class="event_content">
										<div class="event_title"><a href="/event/chitiet/${cc.id}">
											${cc.title}</a></div>
										<div class="event_info_container">
											<div class="event_info"><i class="fa fa-clock-o" aria-hidden="true"></i><span>Tác Giả  :  ${cc.user.username}</span></div>
											<div class="event_info"><i class="fa fa-map-marker" aria-hidden="true"></i><span><fmt:formatDate value="${cc.timeCreate}" pattern="dd-MM-yyyy"/></span></div>
											<div class="event_text">
												<p>${cc.tomtat}</p>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
      </c:forEach>
						<!-- Event -->
					

						<!-- Event -->
						
					</div>
				</div>
			</div>

			<!-- Team -->

			<div class="events">
				<div class="container">
					<div class="row">
						<div class="col">
							<div class="section_title_container text-center">
								<h2 class="section_title">Tin Tức</h2>

							</div>
						</div>
					</div>
					<div class="row events_row events_rows ">
          <c:forEach var="c" items="${list}">
						<!-- Event -->
						<div class="col-lg-4 event_col">
							<div class="event event_left">
								<div class="event_image"><img src="/images/${c.images}" alt=""></div>
								<div class="event_body d-flex flex-row align-items-start justify-content-start">
									<div class="event_date">
										<div class="d-flex flex-column align-items-center justify-content-center trans_200">
											<div class="event_day trans_200"> <fmt:formatDate value="${c.timeCreate}" pattern="dd"/></div>
											<div class="event_month trans_200"> <fmt:formatDate value="${c.timeCreate}" pattern="MM"/></div>
										</div>
									</div>
									<div class="event_content">
										<div class="event_title"><a href="/new/chitiet/${c.id}">
										${c.title}</a></div>
										<div class="event_info_container">
											<div class="event_info"><i class="fa fa-calendar-check-o" aria-hidden="true"></i><span> <fmt:formatDate value="${c.timeCreate}" pattern="dd-MM-yyyy"/></span></div>
											<div class="event_info"><i class="fa fa-map-marker" aria-hidden="true"></i><span>Hà Nội</span></div>
											<div class="event_text">
												<p>${c.tomtat}</p>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
             </c:forEach>
						<!-- Event -->
					   

						<!-- Event -->
						
					</div>
				</div>
			</div>