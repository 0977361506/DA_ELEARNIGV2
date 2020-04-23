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
								<li><a href="blog.html">Hỗ trợ</a></li>
								
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>			
	</div>

	<!-- Contact -->

	<div class="contact">
		
		<!-- Contact Map -->

		<div class="hotro" style="margin-top: 200px; height: 700px;margin-top: 25px;">
			<div class="rowsss">
				<div class="container">
					<ul class="nav nav-tabs">
						<li class="active"><a data-toggle="tab" href="#home"><i class="fa fa-envelope-o"></i><b>Góp ý - liên hệ</b></a></li>
						<li><a data-toggle="tab" href="#menu1"><i class="fa fa-key"></i><b>Quên mất khẩu</b></a></li>
						<li><a data-toggle="tab" href="#menu2"><i class="fa fa-info-circle"></i><b>Hướng dẫn sử dụng</b></a></li>

					</ul>

					<div class="tab-content">
						<div id="home" class="tab-pane fade in active">
							<div class="lienhe">
								<div class="col col-sm-6">
									<h3 class="text-center">Gửi tin nhắn đến chúng tôi</h3>
									<p>${mes}</p>
									<div class="form-hotro">
										<form:form action="/home/support/Contact" class="form-group" modelAttribute="fom" method="post">
											<div id="fo" style="margin-bottom: 25px;">
												<label>Họ và tên</label>
												<form:input type="text" path="namemail" class="form-control"/>
												<form:errors path="namemail" style="color:red;"></form:errors>
											</div>
											<div id="fo" style="margin-bottom: 25px;">
												<label>Email</label>
												<form:input type="text" path="email" class="form-control"/>
												<form:errors path="email"></form:errors>
											</div>
											<div id="fo" style="margin-bottom: 25px;">
												<label>Nội dung tin nhắn</label>
												<form:textarea  rows="9" path="contents" class="form-control"/>
												<form:errors path="contents"></form:errors>
												<p>${suc}</p>
											</div>
											
											<button type="submit" class="btn btn-primary buttons">
												Gửi tin nhắn<i class="fa fa-paper-plane-o"></i>
											</button>
										</form:form>
									</div>
								</div>
								<div class="col col-sm-6 sms">
									<h3 class="text-center">Thông tin liên hệ</h3>
									<div style="margin-top: 20px;">
										<h4 class="text-center">VNPOST-ELearning</h4>
										<p class="text-center"><a href="#" title="">1900 54 54 81</a></p>
										<p class="text-center"><a href="#" title="">vanphong@vnpost.vn</a></p>
										<div class="contact_map">
										<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3724.0529511621844!2d105.77786555053841!3d21.03056719302369!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x313454b36fcf9fab%3A0x9418ec8714a53b9c!2zQsawdSDEkGnhu4duIFZpZXRuYW0gUG9zdA!5e0!3m2!1svi!2s!4v1584696014856!5m2!1svi!2s" width="100%" height="270"  ></iframe>
                                        
                                    </div>


									</div>
								</div>
							</div>
						</div>
						<div id="menu1" class="tab-pane fade">
							<div class="rowss">
								<!-- Contact Info -->
								<div class="col-lg-12">
									<div class="contact_forget_password">
										<div class="contact_info_title">Hướng dẫn về việc quên mật khẩu</div>
										<div class="contact_info_text">
											<p style="font-size: 10px; color: rgb(7, 85, 169);">Trong trường hợp tài khoản của bạn đăng nhập bằng <b>Email nội bộ</b>, vui lòng thay đổi mật khẩu tại trang quản lý email nội bộ.</p>
											<p style="font-size: 10px; rgb(7, 85, 169);">Trong trường hợp đăng nhập bằng các email khác, vui lòng đổi mật khẩu tại form dưới đây <a href="" onclick="$('#forgetPasswordForm').fadeIn(); return  false;"><b class="text-primary">mở form</b></a>.</p>

											<form id="forgetPasswordForm" method="POST" style="display:none; margin-top: 30px">
												<div class="contact_info_title" style="font-size: 26px">Nhập email của bạn</div>
												<div class="form-group">
													<input style="width: 100%; max-width: 300px" type="text" class="form-control forgetPassword_input" name="email" value="">
												</div>
												<div id="recaptcha-resetPassword"></div> <button style="background: #0060AA;" id="changePasswordBtn" onclick="return supportForm.resetPassword();" type="submit" name="btn_submit_password" class="resetPassword_button trans_200">
													Yêu cầu đổi mật khẩu <i class="fa fa-paper-plane-o"></i>
												</button>
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div id="menu2" class="tab-pane fade">
							<div class="menu2" style="margin-top: 20px;">
								<p style="margin-left: 20px;">Vui lòng xem Hướng dẫn sử dụng tại đây <a href="https://elearning.vnpt.vn/tmp/eEDU_LMS_UM_HocVien.v1.0.2.pdf">Hướng dẫn sử dụng</a></p>
							</div>
						</div>

					</div>
				</div>

			</div>
			<!--Hiển thị hỗ trợ-->

		</div>
</div>
		<!-- Contact Info -->
