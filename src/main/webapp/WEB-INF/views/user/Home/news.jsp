<%@ page   pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  	<div class="events" style="margin-top : 20px;">
				<div class="container">
					<div class="row">
						<div class="col">
							<div class="section_title_container text-center">
								<h2 class="section_title">Tin Tức</h2>

							</div>
						</div>
					</div>
					<div class="row events_row events_rows ">
           <c:forEach var="cc" items="${listnews}">
						<!-- Event -->
						<div class="col-lg-4 event_col">
							<div class="event event_left">
								<div class="event_image"><img src="/images/${cc.images}" alt=""></div>
								<div class="event_body d-flex flex-row align-items-start justify-content-start">
									<div class="event_date">
										<div class="d-flex flex-column align-items-center justify-content-center trans_200">
											<div class="event_day trans_200">21</div>
											<div class="event_month trans_200">Aug</div>
										</div>
									</div>
									<div class="event_content">
										<div class="event_title"><a href="/new/chitiet/${cc.id}">
											${cc.title}</a></div>
										<div class="event_info_container">
											<div class="event_info"><i class="fa fa-clock-o" aria-hidden="true"></i><span>Tác Giả  :  ${cc.user.username}</span></div>
											<div class="event_info"><i class="fa fa-map-marker" aria-hidden="true"></i><span>${cc.timeCreate}</span></div>
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
				 <div class="row">
        <div class="col text-center">
          <div class="load_more trans_200 aa"><a href="#">load more</a></div>
        </div>
      </div>
			</div>
         