<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<div class="home">
		<div class="breadcrumbs_container">
			<div class="container">
				<div class="row">
					<div class="col">
						<div class="breadcrumbs">
							<ul>
								<li><a href="index.html">Home</a></li>
								<li><a href="blog.html">Trang cá nhân</a></li>
								
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>			
	</div>

	<!--My profile -->

								<div class="container" style="margin-top: 120px; margin-bottom: 200px;">
									<div class="row">
										<div class="col-sm-3 text-center"><!--left col-->
											<div id="userAvatarOuter" class="text-center">
												<img id="userAvatar" class="avatar rounded-circle img-circle img-thumbnail" alt="avatar" src="/images/LeTheHieu.jpg" style="width: 200px ; height: 200px ; border-radius:50% ; z-index: -1; position: relative;">
												<form action="/user/changeAvatar" style="top: -120px;  z-index: 1;position: relative;">
													<div class="file btn btn-link" style="color:white;">Đổi ảnh
														<i class="fa fa-image"></i> <input id="userAvatarInput" type="file" name="file" accept="image/gif, image/jpeg, image/png" style=" opacity: 0;">
													</div>
													<button type="submit" class="d-none">Gửi</button>
												</form>
											</div>
											<div style="margin-top: -25px;">
												<h5 class="mt-2">Lê Hiếu</h5>
												<div class="text-center"><a href="/user/careerpath">Xem lộ trình công danh</a></div>
											</div>
											<hr>
											<br>

											<ul class="list-group d-none">
												<li class="list-group-item text-right"><span class="pull-left"><strong>Shares</strong></span> 125</li>
												<li class="list-group-item text-right"><span class="pull-left"><strong>Likes</strong></span> 13</li>
												<li class="list-group-item text-right"><span class="pull-left"><strong>Posts</strong></span> 37</li>
												<li class="list-group-item text-right"><span class="pull-left"><strong>Followers</strong></span> 78</li>
											</ul> 

										</div>
										<div class="col col-sm-9">
											<form action="course_submit" class="form-group" method="post">
												<div class="pro">
													<label class="userProfile" for="">Họ và Tên</label>
													<input type="text" class="form-control" name="">
												</div>
												<div class="row pro">
													<div class="col-sm-6">
														<label class="userProfile" for="">Đơn Vị</label>
														<input type="text" class="form-control" name="">
													</div>
													<div class="col-sm-6">
														<label class="userProfile" for="">Chức danh công việc</label>
														<input type="text" class="form-control"  name="">
													</div>

												</div>
												<div class="row pro">
													<div class="col-sm-6">
														<label class="userProfile" for="">Tên đăng nhập</label>
														<input type="text" class="form-control" name="">
													</div>
													<div class="col-sm-6">
														<label class="userProfile" for="">Email</label>
														<input type="text" class="form-control"  name="">
													</div>

												</div>
												<div class="row pro">
													<div class="col-sm-6">
														<label class="userProfile" for="">Ngày sinh</label>
														<input type="text" class="form-control" name="">
													</div>
													<div class="col-sm-6">
														<label class="userProfile" for="">Giới tính</label>
														<input type="text" class="form-control"  name="">
													</div>

												</div>
												<div class="row pro">
													<div class="col-sm-6">
														<label class="userProfile" for="">Địa chỉ</label>
														<input type="text" class="form-control" name="">
													</div>
													<div class="col-sm-6">
														<label class="userProfile" for="">Số điện thoại</label>
														<input type="text" class="form-control"  name="">
													</div>

												</div>
											</form>
											<hr>
											<div class="form-group pro" style="width: 130px;">
												<div class="col-sm-12">
													<a class="pull-right btn btn-link" href="/user/editProfile">
														<i class="fa fa-pencil-square" style="font-size: 25px;"></i> Cập nhật thông tin</a> 
												</div>
												</div>
											</div>
										</div>
									</div>
		<!-- Contact Info -->
