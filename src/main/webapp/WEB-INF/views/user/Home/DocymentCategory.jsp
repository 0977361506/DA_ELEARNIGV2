<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

 <c:set scope="request" var="m" value="1" />
 
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
							<form action="/home/search/coursess" id="courses_search_form" class="courses_search_form d-flex flex-row align-items-center justify-content-start">
								<input type="search" value="" name="key" class="courses_search_input" placeholder="Search Courses" required="required" style="width: 480px;">
								
								<button action="submit" class="courses_search_button ml-auto">Tìm Kiếm</button>
							</form>
						</div>
						<div class="courses_container">
			<table class="table table-striped " id="documentTable">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col" width="40%">Tên</th>
					<th scope="col" width="35%">Tệp đính kèm</th>
					<th scope="col" width="25%">Thông tin</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="c" items="${listD}">
			
			 <tr>
				<th scope="row">${c.id}</th>
				<td>
					<i class="fa fa-lock"></i>${c.name}<br>
					<p class="info_text text-info"><i class="fa fa-building-o"></i>${c.poscodeVnpost.unitVnpost.name}</p>
					<p class="info_text"><i class="fa fa-info-circle"></i> ${c.describes}</p>
				</td>
				<td>
					<a class="documentFile" href="/dowload/file/${c.id}" >
							<i class="fa fa-paperclip"></i> ${c.linkFile} </a> 
						<span class="badge badge-info">46.54 KB</span>
					</td>
					<td>
						<div class="info_text">
							Người tạo: Đỗ tuấn hưng<br>
						Ngày tạo: <fmt:formatDate value="${c.timeCreate}" pattern="hh:mm dd/MM/yyyy"/>  </div>
					</td>
				</tr>
			</c:forEach>

	
						</tbody>
					</table>
							
	
						</div>
					</div>

					<!-- Courses Sidebar -->
					<div class="col-lg-3" >
						<div class="sidebar" style="padding-top: 0px;"> 

							<!-- Categories -->
							<div class="sidebar_section">
								<div class="sidebar_section_title">Danh Mục Tài Liệu</div>
								<div class="sidebar_categorie" style="margin-top: 20px;">
                                        <ul class="list-group">
                                        <li class="list-group-item active">Tất cả tài liệu</li>
                                        <c:forEach var="c" items="${listDC}">
                                           <li class="list-group-item"><a href="/home/documentCategory/${c.id}">  ${c.nameDocument}</a></li>
                                         </c:forEach>
                                         
                                         </ul>
								</div>
								<div>
								<ul class="list-group mt-5">
                                <li class="list-group-item active bg-green-dark">
                                 <a href="#" style="color: white;"> Tất cả tài liệu <i class="fa fa-circle pull-right" style="position: relative; top: 4px"></i></a>
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
