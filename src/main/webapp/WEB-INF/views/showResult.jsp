<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Bài kiểm tra</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <link rel="stylesheet" href="/styles/test.css" >
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    
    <meta content="width=device-width, initial-scale=1" name="viewport">
</head>
<style>
	.modal-backdrop {
	display: none;}
</style>
<body>
  <div class="toolbars container-fluid color-light">
    <div class="d-flex justify-content-between align-items-center" style="">
      <div class="col">
        <div class="d-flex" style="flex-wrap:wrap">
          <div class="col-auto menu-item">
            <i class="fa fa-home"></i>
            Trang Chủ
          </div>
          <div class="col-auto menu-item">
            Cuộc thi
          </div>
          <div class="col-auto menu-item">
           Hiện thị bài làm 
          </div>
     
        </div>
      </div>

      <div class="login-acc-inf ">
        <div class="dropdown">
          <button class="btn-small btn-secondary dropdown-toggle login-acc-inf" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-user-circle"></i>
            <span class="ml-1">abc@gmail.com</span>
          </button>
          <div class="dropdown-menu color-dark" aria-labelledby="dropdownMenuButton">
            <a class="dropdown-item" href="#"><i class="fas fa-user-circle color-primary"></i><span class="ml-1">Hồ sơ cá nhân</span></a>
            <a class="dropdown-item" href="#"><i class="color-primary fa fa-book "></i><span class="ml-1">Khóa học của tôi</span></a>
            <a class="dropdown-item" href="#"><i class="color-primary fas fa-edit"></i><span class="ml-1">Cuộc thi của tôi</span></a>
            <a class="dropdown-item" href="#"><i class="color-primary fas fa-cog"></i><span class="ml-1">Cấu hình</span></a>
            <a class="dropdown-item" href="#"><i class="color-primary fas fa-power-off"></i><span class="ml-1">Đăng xuất</span></a>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="px-4 py-2">
    <h1 class="round-test-title">
      <a href="" class="">Vòng thi 1 ― ewqewqewqewqe </a>

    </h1>
    <div class="row justify-content-between align-items-center">
      <div class="col">
        <div class="row">
          <div class=" color-red col-auto">
            <i class="far fa-clock"></i> 15 phút
          </div>
          <div class=" font-blue-steel color-primary col-auto">
            <i class="fa fa-question-circle"></i> 1 câu hỏi
          </div>
        </div>
      </div>

    </div>

  </div>
  <div class="main p-3" id="main">
    <div class="row">
      <div class="col-sm-9 col-12">
      
      
     <c:forEach var="c" items="${obj}">
        <div class="card p-3 mt-2 d-block roundtest" id="q-1" data-id="${c.index}">
   
          <div class="">
            <a class="float-right star" data-id="#q-1" style="cursor:pointer">Đánh dấu <i class="far fa-star"></i> <i class="fas fa-star" style="display:none;"></i></a>
          </div>
         
         
          <div class="color-primary font-weight-bold">
            Câu <span>${c.index}</span>:
          </div>
          <div class="question mt-2">
           ${c.question.question}:
          </div>
          <div class="note mt-4">
            (${c.typeQuestion.nameType})
          </div>
          <div class="answers mt-2" >
          
      <!-- cau hoi chỉ  dc chon 1 dap an -->
               
               
      <c:if test="${c.typeQuestion.id==1}">
         <c:forEach var="b" items="${c.ans}">
            <div class="answwerlist">
              <label>
                <span>${b}</span>.
            
                  <c:if test="${c.check==1}">
                <span>
                  <input type="radio" checked disabled="disabled" class="answers" name="q-${c.index}" > 
                </span>
                </c:if>
                
                  <c:if test="${c.check==0}">
                <span>
                  <input type="radio" disabled="disabled" class="answer" name="q-${c.index}" > 
                </span>
                </c:if>
              </label>

            </div>
         </c:forEach>
     </c:if>
     <!-- cau hoi dc chon nhieu dap an -->
        <c:if test="${c.typeQuestion.id==2}">
         <c:forEach var="b" items="${c.ans}">
            <div class="answwerlist">
              <label>
                <span>${b}</span>.
                <c:if test="${c.check==1}">
                <span>
                  <input type="checkbox" checked="checked" readonly="readonly" name="q-${c.index}" > 
                </span>
                </c:if>
                 <c:if test="${c.check==0}">
                <span>
                  <input type="checkbox" readonly="readonly" name="q-${c.index}" > 
                </span>
                </c:if>
              </label>

            </div>
         </c:forEach>
     </c:if>
     
     
          <!-- cau hoi xung hop -->
          
          
        <c:if test="${c.typeQuestion.id==3}">
         <c:forEach var="b" items="${c.ans}">
            <div class="answwerlist">
              <label>
                <span>${b}</span>.
                <c:if test="${c.check==1}">
                <span>
                  <input type="checkbox" checked="checked" readonly="readonly" name="q-${c.index}" > 
                </span>
                </c:if>
                 <c:if test="${c.check==0}">
                <span>
                  <input type="checkbox" readonly="readonly" name="q-${c.index}" > 
                </span>
                </c:if>
              </label>

            </div>
         </c:forEach>
         </c:if>
     
          </div>
        </div>
        
    </c:forEach>    

      </div>
      <div class="col-sm-3 col-12">
        <div class="card position-sticky" style="top: 10px">
          <div class="p-3">
          
        
            <div class="result-set p-1">
              <div class="row">
               <c:forEach var="c" items="${obj}">
                <div class="col-auto">
                  <div class="answer-result" q-id="#q-${c.index}">
                    ${c.index}
                  </div>
                </div>
              </c:forEach>
    
              </div>
            </div>
     

          </div>



        </div>
      </div>
    </div>

  </div>
</body>


<!-- <script src="https://code.jquery.com/jquery-3.4.1.min.js" -->
<!-- 	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" -->
<!-- 	crossorigin="anonymous"></script> -->

<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/js/all.min.js"></script>
<script src="/js/exam.js"></script>
</html>
