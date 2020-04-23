<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<div class="home">
		<div class="breadcrumbs_container">
			<div class="container">
				<div class="row">
					<div class="col">
						<div class="breadcrumbs">
							<ul>
								<li><a href="index.html">Trang chủ</a></li>
								<li><a href="blog.html">Tin tức</a></li>
								<li>Triển khai giải pháp tổng thể đồng bộ dữ liệu hệ thống cơ sở dữ liệu ngành giáo dục</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>			
	</div>

	<!-- Blog -->

	<div class="blog">
		<div class="container">
			<div class="row">

				<!-- Blog Content -->
				<div class="col-lg-8">
					<div class="blog_content">
						<div class="blog_title">${baiviet.title}</div>
						<div class="blog_meta">
							<ul>
								<li>Tạo lúc <a href="#">${baiviet.timeCreate}</a></li>
								
							</ul>
						</div>
						<div class="blog_image"><img src="images/blog_single.jpg" alt=""></div>
						<p class="content">${baiviet.content}</p>
						
						
					
						
					</div>
					<div class="blog_extra d-flex flex-lg-row flex-column align-items-lg-center align-items-start justify-content-start">
						<div class="blog_tags">
							<span>Tác Giả: </span>
							<ul>
								<li><a href="#">${baiviet.user.username}</a></li>
								
							</ul>
						</div>
						
					</div>
					<!-- Comments -->
					
				</div>

				<!-- Blog Sidebar -->
				<div class="col-lg-4">
					<div class="sidebar">

						<!-- Categories -->
						<div class="sidebar_section">
							<div class="sidebar_section_title">Danh mục tin tức</div>
							<div class="sidebar_categories">
								<ul class="categories_list">
								   <c:forEach var="l" items="${list}">
									<li><a href="/news/category/detail/${l.id}" data-id="${l.id}" class="clearfix clearfixs" >${l.nameDetail}</a>
																		</li>
									</c:forEach>
									
									
								</ul>
							</div>
						</div>

						<!-- Latest News -->
						<div class="sidebar_section">
							<div class="sidebar_section_title">Mới nhất</div>
							<div class="sidebar_latest">

								<!-- Latest Course -->
							 <c:forEach var="cc" items="${listnews}">
								<div class="latest d-flex flex-row align-items-start justify-content-start">
									<div class="latest_image"><div><img src="/images/${cc.images}" alt=""></div></div>
									<div class="latest_content">
										<div class="latest_title"><a data-id= "${cc.id}" href="#">${cc.title}</a></div>
										<div class="latest_date">${cc.timeCreate}</div>
									</div>
								</div>
                              </c:forEach>
                              
								<!-- Latest Course -->
							

								<!-- Latest Course -->
								
							</div>
						</div>

						<!-- Gallery -->
						
						<!-- Tags -->
						
						<!-- Banner -->
						
					</div>
				</div>
			</div>
		</div>
	</div>
