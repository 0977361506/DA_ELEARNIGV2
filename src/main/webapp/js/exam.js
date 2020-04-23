$(document).ready(function() {
	 var sao= 0;  
	 var cook = 0 ; // time luc out ra
	 var x= $('input.answer').length; // so luon go in put
	    var y = $('input.answer').not(':checked').length; // so luon go check ed
	  var diem =0; 
	  var socau = 0 ;
	   var mang = [];
       var idthisinh=   $("input.mathisinh").val(); 
       var sl =  $("input.soluong").val(); 
        var idround = $("input.maphongthi").val();
   	  var dateObj = new Date();
      var count = 0;
  	
   	 // bắt sự kiên nộp bài 
      
//      $("a.nopbais").click(function(){
////    	  var s = `<a type="button" class="btn btn-primary" href="/competition/send/result/`+idthisinh+`/`+idround+`/`+count+`/`+diem+`">Nộp</a>
////        <button type="button" class="btn btn-danger thoat" data-dismiss="modal">Thoát</button>`;
////    	  $("div.nop").append(s);
//    	  $("div.nop a").attr("href",`/competition/send/result/`+idthisinh+`/`+idround+`/`+count+`/`+diem+``);
//      
//      });
      $("div.nop a").click(function(){
    	  $.ajax({ // lưu thơi gian bat dau va id rountest
    		  
    		  url:`/competition/roundtest/saveDateStart/${dateObj}/${idround}/${idthisinh}`,
    	      type:"GET",
    		  success: function(res){
    			 // alert("thanhf coong số lần thi của sinh viên đã tăng lên");


    		   count=res;
    		   eraseCookie("p");
    		   window.location.href = `/competition/send/result/`+idthisinh+`/`+idround+`/`+count+`/`+diem+`/`+socau+``;
    		  
    		  }
       ,error:function(response){
    		 
    		        alert("error");
    		        }
    	  });
      
      });
   	  
   // nếu mà thí sinh làm lần thứ 2

   	 
 
 
// 
//luu time out ra 
      giay = readCookie("p");
    //giay = 60*3.6;
    //giay = readCookie("s");
   if(giay>0){
	   var phut = Math.floor(giay/60);
	    phut = String(phut);
	    if(phut.length == 1) {
	    	phut = "0"+phut;
	    }
	    var giayLeft = giay - 60*(phut);
	    giayLeft = String(giayLeft);
	    //console.log(phut.length);
	    if(giayLeft.length == 0) {
	    	giayLeft = "0" + giayLeft;
	    }

	    //console.log(phut)
	    $('.countdown-test .m').html(phut);
	    $('.countdown-test .s').html(giayLeft);
   }
   else if(giay==0){
	   $('.countdown-test .m').html($('.countdown-test .m').html()); //  var mm = $('.countdown-test .m').html();
	    $('.countdown-test .s').html($('.countdown-test .s').html());
	  //  window.location.href = `/competition/send/result/`+idthisinh+`/`+idround+`/`+count+`/`+diem+`/`+socau+``;
	   
   }
//	  
 
 
 
 
  $('.star').on('click',function() {  // su kien click ngoi sáo

	
    $(this).find('[data-prefix="fas"]').css('display','inline-block');
    $(this).find('[data-prefix="far"]').css('display','none');
    $(this).css('color','#FCB71E');
    var id = $(this).attr('data-id');
    $('.result-set').find('[q-id="'+id+'"]').css('border-color','#FCB71E');
  });
  
    // neeu khac nhau thi luwu
	  
	  $('input.answer').click(function() { // sự kiện click dáp án
		  var  idans= $(this).attr("data-id");
		  var idquestion  = $(this).attr("id");
	    var id = $(this).attr('name');
	    
	    $('.result-set').find('[q-id="#'+id+'"]').addClass("backg");
	    $('.result-set').find('[q-id="#'+id+'"]').css('background-color','#004793');
	    $('.result-set').find('[q-id="#'+id+'"]').css('color','#fff');
//	    console.log();
	    if ($('input[name='+id+']:checked').length == 0) {
	    	$('.result-set').find('[q-id="#'+id+'"]').removeClass("backg");
	    	$('.result-set').find('[q-id="#'+id+'"]').css('background-color','#fff');
	        $('.result-set').find('[q-id="#'+id+'"]').css('color','#000');
	    }
	    

	//   
	    var check = $('input[name='+id+']:checked').map(function () {
	        return $(this).val();
	    }).get();
	    var uncheck =$('input[name='+id+']').not(':checked').map(function () {
	        return $(this).val();
	    }).get();
//	     alert("check:"+check+"uncheck"+uncheck);
	    dataPUT = {};
		  dataPUT['idquestion'] = idquestion;
		  dataPUT['iduser'] =  idthisinh;
		  dataPUT['idRoundtest'] = idround ;
		 dataPUT['check'] =check;
		 dataPUT['nocheck'] =uncheck;
		 dataPUT['count'] =count;
		
		    $.ajax({
		        url: '/competition/save/result',
				method: 'POST',
		        data: JSON.stringify(dataPUT),
		        dataType: 'json',
		        contentType: "application/json",
		        success: function (res) {
	               diem+=res[0];
	               socau+=res[1];
	             
		        },
		        error: function(res){

		        	
		        	  alert("loi");
		        }
		        
		    });
		    
		 	    //// ajjax
	    sao = $('.backg').length;
	 if (sao== sl){
		 $("a.nopbai").css("display","inline-block");
	 }
	 else{
		 $("a.nopbai").css("display","none");
	 }
	  });
  

  
  
  
   // sử lí đồng hồ đemm ngược
  var phut = 0 ;
  var giay = 0 ;
  var mm = $('.countdown-test .m').html();
  var ss = $('.countdown-test .s').html();
  function countDown() {
    var countDown = new Date().getTime() +mm*60*1000 + ss*1000 + 1000;


    // Update the count down every 1 second
    var x = setInterval(function() {

      // Get today's date and time
      var now = new Date().getTime();

      // Find the distance between now and the count down date
      var distance = countDown - now;

      // Time calculations for days, hours, minutes and seconds
      if (distance >= 0) {
        var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60)).toString();

        var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60)).toString();
        var seconds = Math.floor((distance % (1000 * 60)) / 1000).toString();

        if(hours.length == 1) {
          hours = '0'+hours;
        }
        if(minutes.length == 1) {
          minutes = '0'+minutes;
        }
        if(seconds.length == 1) {
          seconds = '0'+seconds;
        }
        // Display the result in the element with id="demo"
        // console.log( hours + "h "
        // + minutes + "m " + seconds + "s ")
        $('.countdown-test .h').html(hours);
        $('.countdown-test .m').html(minutes);
        $('.countdown-test .s').html(seconds);
         phut =Number($('.countdown-test .m').html());
        giay = Number($('.countdown-test .s').html());
        createCookie("p",phut*60+giay, 30);
   //    createCookie("s",giay, 30);

      }
    
      // If the count down is finished, write some text
      if (distance < 0) {
        clearInterval(x);
        
        if(x==y){
        	$.ajax({
        		url:`/competition/save/notDo/${idround}/${idthisinh}`,
        		success:function(res){
        			alert("vip");
        		}
        	})
        }
        eraseCookie("p");
       
      // window.location.href = `/competition/send/result/`+idthisinh+`/`+idround+`/`+count+`/`+diem+``;
       //$('.countdown-test .m').html(2);
        $("div.nop a").click();
      //  alert('out of time');
      }
    }, 1000);
  }
  countDown();
  

 	  


  //côkkei
  function createCookie(name, value, days) {
      if (days) {
          var date = new Date();
          date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
          var expires = "; expires=" + date.toGMTString();
      }
      else var expires = "";               

      document.cookie = name + "=" + value + expires + "; path=/";
  }

  function readCookie(name) {
      var nameEQ = name + "=";
      var ca = document.cookie.split(';');
      for (var i = 0; i < ca.length; i++) {
          var c = ca[i];
          while (c.charAt(0) == ' ') c = c.substring(1, c.length);
          if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length, c.length);
      }
      return null;
  }

  function eraseCookie(name) {
      createCookie(name, "", 0);
  }
  
  
  
})
 
