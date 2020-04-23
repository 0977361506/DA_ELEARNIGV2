<%@ page  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div class="home">
			<div class="breadcrumbs_container">
				<div class="container">
					<div class="row">
						<div class="col">
							<div class="breadcrumbs">
								<ul>
									<li><a href="index.html">Home</a></li>
									<li><a href="coursess.html">coursess</a></li>
									<li>courses Details</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>			
		</div>

		<!-- courses -->

		<div class="courses">
			<div class="container">
				<div class="row">

					<!-- courses -->
					<div class="col-lg-8">

						<div class="courses_container">
							<div class="courses_title">${chitiet.name}</div>
							<div class="courses_info d-flex flex-lg-row flex-column align-items-lg-center align-items-start justify-content-start">

								<!-- courses Info Item -->
								<div class="courses_info_item">
									<div class="courses_info_title">Người tạo:</div>
									<div class="courses_info_text"><a href="#">${chitiet.createdBy}</a></div>
								</div>

								<!-- courses Info Item -->
								<div class="courses_info_item">
									<div class="courses_info_title">Đánh giá:</div>
									<div class="rating_r rating_r_4">  ${slvote} / 5 <i></i></div>
								</div>

								<!-- courses Info Item -->
								<div class="courses_info_item">
									<div class="courses_info_title">Danh mục:</div>
									<div class="courses_info_text"><a href="#">${chitiet.coursecategory.name}</a></div>
								</div>

							</div>

							<!-- courses Image -->
							<div class="courses_image"><img src="/images/${chitiet.avatar}" alt=""></div>

							<!-- courses Tabs -->
							<div class="courses_tabs_container">
								<div class="tabs d-flex flex-row align-items-center justify-content-start">
									<div class="tab active">Miêu tả</div>
									<div class="tab">Đề cương</div>
									<div class="tab danhgia">Tài Liệu</div>
									<div class="tab">Đánh giá</div>
								</div>
								<div class="tab_panels">

									<!-- Description -->
									<div class="tab_panel active">

										<div class="tab_panel_content">
											<div class="tab_panel_text">
												<p>${chitiet.description}</p>
											</div>

										</div>
									</div>

									<!-- Curriculum -->
									<div class="tab_panel tab_panel_2">
										<div class="tab_panel_content">

											<div class="tab_panel_content">

                                                                         <!-- Dropdowns  TÀI LIỆU CBYOWNG MỤC -->
												<!-- Dropdowns -->
												<ul class="dropdowns">
												<c:if test="${fn:length(list4)==0}"><div class="alert alert-warning"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i> Chưa có học liệu nào</div></c:if>
												<c:forEach var="c" items="${list4}">
													<li class="has_children">
														<div class="dropdown_item">
														
															<div data-id="${c.id}" class="dropdown_item_title"><span>${c.name}</span></div>
                                                
														</div>
														<ul id="${c.id}" class="list">
													
														
													 
															
														</ul>
													</li>
												    </c:forEach>
		
												</ul>
												
								<!--điểm kết thúc của một đề cương-->
								
												
											</div>
										</div>
									</div>

									<!-- Tài liệu khóa học -->
	
<div class="tab_panel  active" style="max-height: 450px; overflow-y: scroll">
<div class="tab_panel_title">Các tài liệu</div>
<div class="tab_panel_content">
<ul class="dropdowns">
<c:if test="${fn:length(tailieu)>0}">
<c:forEach var="c" items="${tailieu}">
<li>
<div class="dropdown_item dropdown_item_hoclieu">
<div class="item_document"><i class="fa fa-paperclip" aria-hidden="true"></i> <span>${c.name}</span></div>
</div>
</li>
</c:forEach>
</c:if>
<c:if test="${fn:length(tailieu)==0}">
<div class="tab_panel_content">
<div class="alert alert-warning mt-3"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i> Chưa có tài liệu nào</div>
</div>
</c:if>
</ul>
</div>
</div>

<!-- Tài liệu khóa học -->

		<!-- Đánh giá -->
		
 <div class="tab_panel tab_panel_3">               
																                   
 <div id="${chitiet.id} " class="review_rating_container course_rating_outer">
    <div class="review_rating">
        <div class="review_rating_num">${slvote}</div>
        <div class="review_rating_stars">
            <div class="rating_r rating_r_4">
               <div id="cate-rating" class="cate-rating">
	<div class="stars">
		<a id="star-1" class="star"><span class="glyphicon glyphicon-star"></span></a>
		<a id="star-2" class="star"><span class="glyphicon glyphicon-star"></span></a>
		<a id="star-3" class="star"><span class="glyphicon glyphicon-star"></span></a>
		<a id="star-4" class="star"><span class="glyphicon glyphicon-star"></span></a>
		<a id="star-5" class="star"><span class="glyphicon glyphicon-star"></span></a>
		
		<p id="vote-desc">Mời bạn cho điểm!</p>
	</div>
	<div class="clearfix"></div>
</div>
            </div>
        </div>
        <div class="review_rating_text">${sldanhgia} bình chọn</div>
    </div>
    <div id="cate-rating" class="review_rating_bars cate-rating">
        <ul>
            <li><span>5 <img class="star1"  alt="5" src="/images/star.png" title="bad"></span><div class="review_rating_bar"><div class="voted-5" style="${rate.star_five}"></div></div></li>
            <li><span>4 <img  class="star1" alt="4" src="/images/star.png" title="bad"></span><div class="review_rating_bar"><div class="voted-4" style="${rate.star_for}"></div></div></li>
            <li><span>3 <img  class="star1"  alt="3" src="/images/star.png" title="bad"></span><div class="review_rating_bar"><div class="voted-3" style="${rate.star_three}"></div></div></li>
            <li><span>2 <img  class="star1" alt="2" src="/images/star.png" title="bad"></span><div class="review_rating_bar"><div class="voted-2" style="${rate.star_two}"></div></div></li>
            <li><span>1 <img  class="star1" alt="1" src="/images/star.png" title="bad"></span><div class="review_rating_bar"><div class="voted-1" style="${rate.star_one}"></div></div></li>
        </ul>
    </div>
</div>
						   <c:if test="${fn:length(yes)==0}">
						   
                            <div class="alert alert-warning text-center" style="margin-top: 50px;"><i class="fa fa-exclamation-triangle"></i> Bạn cần đăng kí khóa học để bình luận và đánh giá. </div>
                            
						   </c:if>
                           <c:if test="${fn:length(yes)>0}">
										<!-- Comments -->
										<div class="comments_container">
											<ul class="comments_list">
												<li class="add_new_comment">
													<div class="wrapper">
														<div class="comment_image">
														
															<img class="img-fluid" src="/images/LeTheHieu.jpg" alt="Tuấn Anh" style="max-width: 80px; max-height: 100px;">
														</div>
														<div class="new_comment_input">
															<div class="form-group">
																<textarea id ="${chitiet.id}" class="form-control rounded-10 txtNewComment" rows="2"  ></textarea>
															</div>
															<div class="form-group">
																<div id="recaptcha-formcoursesCommentRoot"></div>                        </div>
																<div class="text-right">
																	<button id = "${chitiet.id}"  type="button" class="btn btn-primary btn-sm btn-send-new-comment btn-send-comment">
																		<i class="fa fa-paper-plane"></i> Gửi</button>
																	</div>
																</div>
															</div>
												</li>
                                                        <!-- hieenj  Comments -->
            <!-- hiển thị list comments -->	     <c:forEach var="c" items="${comments}">
														<li>
															<div class="comment_item d-flex flex-row align-items-start jutify-content-start">
																<div class="comment_image">
																	<div>
																		<img class="img-fluid" src="/images/teacher.jpg" alt="Nguyễn Ngọc Cảnh">
																	</div>
																</div>
																<div class="comment_content">
																	<div class="comment_title_container d-flex flex-row align-items-center justify-content-start">
																		<div class="comment_author"><a href="#">${c.createdBy}</a></div>
																		<div class="comment_time ml-auto">
																		${c.createdDate} </div>
																	</div>
																	<div class="comment_text">
																		<p>${c.contents}</p>
																	</div>
																	<div class="comment_extras d-flex flex-row align-items-center justify-content-start">
																		<div  class="comment_extra comment_reply">
																			<a id ="${c.id}" type="button" href="#icon" class="ans"> 
																				<i class="fa fa-reply" aria-hidden="true"></i>
																				<span>Trả lời</span>
																			</a>
						             	 <!-- hiển thị form trả lời -->		<div  id="icon"  class="input_reply_comment form-group" style="display:none ; ">
				     <!-- hiển thị form trả lời -->								  <div>
			  <!-- hiển thị form trả lời -->										<div class="form-group">
																						<input data-id="${c.id}" class=" form-control retxtNewComment" rows="2" style="width: 450px;"></input>
																						<button id ="${c.id}" type="button" class="sendAns"><i class="fa fa-paper-plane"></i> gửi</button>
																					</div>
																					
																						
																					</div>
																			</div>
																	    </div>
																	</div>
																	</div>
																</div>
																<ul  class=" ${c.id} sub_comment ul_inner_5e195401815bc">
																	
																</ul>
															</li>
												  </c:forEach>      <!-- hiển thị list commnet -->	
															</ul>
														</div>
											</c:if>
													</div>

												</div>
											</div>
										</div>
								</div>
								
				<!-- courses Sidebar -->
				
				
				
									<!-- courses Sidebar -->
									<div class="col-lg-4">
										<div class="sidebar">

											<!-- Feature -->
											<div class="sidebar_section">
												<div class="sidebar_section_title">Thông tin khóa học</div>
												<div class="sidebar_feature">
												 <c:if test="${chitiet.price==0}">
													<div class="courses_price">Miễn Phí</div>
                                                     </c:if>
                                                     <c:if test="${chitiet.price > 0}">
													<div class="courses_price">${chitiet.price}</div>
                                                     </c:if>
													<!-- Features -->
													<div class="feature_list">

														<!-- Feature -->
														<div class="feature d-flex flex-row align-items-center justify-content-start" style="margin-top:0px; padding:0px;">
															<div class="feature_title" style="margin-top:0px; margin-left: 0px;"><i class="fa fa-clock-o" aria-hidden="true" style="margin-right:20px;"></i><span>Thời gian bắt đầu :</span></div>


															<div class="feature_text ml-auto"><fmt:formatDate value="${chitiet.courseConfig.starts}" pattern="dd/MM/yyyy"/></div>
														</div>

														<!-- Feature -->
														<div class="feature d-flex flex-row align-items-center justify-content-start" style="margin-top:0px; padding:0px; ">
															<div class="feature_title" style="margin-top:0px; margin-left: 0px;"><i class="fa fa-clock-o" aria-hidden="true" style="margin-right:20px;"></i><span>Thời gian kết thúc :</span></div>
															<div class="feature_text ml-auto"><fmt:formatDate value="${chitiet.courseConfig.ends}" pattern="dd/MM/yyyy"/></div>
														</div>

														<!-- Feature -->
														<div class="feature d-flex flex-row align-items-center justify-content-start" style="margin-top:0px; padding:0px;">
															<div class="feature_title" style="margin-top:0px; margin-left: 0px;"><i class="fa fa-sign-in" aria-hidden="true" style="margin-right:20px;"></i><span>Đăng ký học :</span></div>
															<div class="feature_text ml-auto"><c:if test="${chitiet.courseConfig.approveAuto == 1}">
									  <p>Đăng kí tự do</p>
									  </c:if>
								        <c:if test="${chitiet.courseConfig.approveAuto == 0}">
									  <p style="font-size: 6px;">Không được đăng kí tự do</p>
									  </c:if></div>
														</div>

														<!-- Feature -->
														<div class="feature d-flex flex-row align-items-center justify-content-start" style="margin-top:0px; padding:0px;">
															<div class="feature_title" style="margin-top:0px; margin-left: 0px;"><i class="fa fa-tag" aria-hidden="true" style="margin-right:20px;"></i><span>Tag:</span></div>
															<div class="feature_text ml-auto">
																<div class="feature_text ml-auto">tag</div>
															</div>

														</div>

														<!-- Feature -->
														<div class="feature d-flex flex-row align-items-center justify-content-start" style="margin-top:0px; padding:20px;">
															<div class="feature_title" style="margin-top:0px; margin-left: 0px;"><i class="fa fa-users" aria-hidden="true" style="margin-right:20px;"></i><span>Số học viên:</span></div>
															<div class="feature_text ml-auto">${fn:length(chitiet.courseJoins)}</div>
														</div>

														<!-- Feature -->
														<div class="feature d-flex flex-row align-items-center justify-content-start" style="margin-top:0px; padding:0px;">
															<div class="feature_title" style="margin-top:0px; margin-left: 0px;"><i class="fa fa-users" aria-hidden="true" style="margin-right:20px;"></i><span>Nhóm chức danh:</span></div>
															<div class="feature_text ml-auto">35</div>
														</div>

													</div>
												</div>
											</div>

											<!-- Feature -->
											<div class="sidebar_section">
												<div class="sidebar_section_title">Giảng Viên : </div>
										  <c:forEach var="cc" items="${chitiet.courseJoins}">
												<div class="sidebar_teacher">
													<div class="teacher_title_container d-flex flex-row align-items-center justify-content-start" >
														<div class="teacher_image"><img src="/images/${cc.user.imageUsers}" alt=""></div>
														<div class="teacher_title">
															<div class="teacher_name"><a href="#">${cc.user.username}</a></div>
															
														</div>
													</div>
												</div>
											</c:forEach>
											</div>

											<!-- Latest courses -->
											<div class="sidebar_section">
												<div class="sidebar_section_title">Khóa học liên quan :</div>
												 <p>${mes}</p>
												<div class="sidebar_latest">
												
                                              <c:forEach var="c" items="${list}">
                                               
													<!-- Latest courses -->
													<div class="latest d-flex flex-row align-items-start justify-content-start">
														<div class="latest_image"><div><img src="/images/${c.avatar}" alt=""></div></div>
													
														<div class="latest_content">
														<a href="/home/courses/detail/${c.id}">${c.name}</a>
															 <c:if test="${chitiet.price==0}">
													<div class="courses_price">Miễn Phí</div>
                                                     </c:if>
                                                     <c:if test="${chitiet.price > 0}">
													<div class="courses_price">${chitiet.price}</div>
                                                     </c:if>
														</div>
													</div>
                                                 </c:forEach>
													<!-- Latest courses -->


													<!-- Latest courses -->


												</div>
											</div>

										</div>
									</div>
								</div>
							</div>
						</div>

						<!-- Newsletter -->
								
                 <!-- khóa học cùng chức danh -->
                 
        
				<div class="container">
				
					<div class="row">
						<div class="col">
							<div class="section_title_container text-center">
								<h2 class="section_title">Khóa Học Cùng Chủ Đề</h2>
								 <h3>${mes}</h3>

							</div>
						</div>
					</div>
					<div class="container courses_row">

						<!-- Course -->
	
                 <c:forEach var="c" items="${list}">
						<!-- Course -->
						<div class="col-lg-4 course_col">
							<div class="course">
								<div class="course_image"><img src="/images/${c.avatar}" alt=""></div>
								<div class="course_body">
							
									<h3 class="course_title"><a href="/home/courses/detail/${c.id}">${c.name}</a></h3>
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
										<div class="course_price ml-auto">
										            <c:if test="${chitiet.price==0}">
													<div class="courses_price">Miễn Phí</div>
                                                     </c:if>
                                                     <c:if test="${chitiet.price > 0}">
													<div class="courses_price">${chitiet.price}</div>
                                                     </c:if>
										</div>
									</div>
								</div>
							</div>
						</div>
                    </c:forEach>  
						<!-- Course -->
					


						<!-- Course -->
					

					</div>
				</div>
			</div>
						
						