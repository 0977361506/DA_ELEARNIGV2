<%@ page pageEncoding="utf-8"%>

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
			   <script src="/js/roundtest.js"></script>
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