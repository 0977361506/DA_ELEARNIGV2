<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Bài kiểm tra</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <link rel="stylesheet" href="/styles/test.css" >
    <meta content="width=device-width, initial-scale=1" name="viewport">
</head>
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
            abc
          </div>
          <div class="col-auto menu-item">
            Vòng thi 1
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
  <div class="main p-3" id="main">
    <div class="row">
    <c:forEach var="c" items="${list}">
    <c:if test="${c.statusRound ==  0}">
      <div class="col-sm-3 mt-2">
        <div class="card round-test">
            <div class="color-primary p-1 pl-3">
              Vòng thi 1
            </div>
            <hr>
            <div class="p-1 pl-3 content">
              <div class="">
                <i class="far fa-clock"></i><span class="ml-1">Thời gian làm bài: <fmt:formatNumber value=" ${c.timeRound % 3600 /60}" pattern="#,##"></fmt:formatNumber> phút</span>
              </div>
              <div class="">
                <i class="fas fa-lock"></i><span class="ml-1">Điều kiện tham gia: ${c.condition.nameCondition}</span>
              </div>
            </div>
            <hr>
            <div class="text-center mb-3">
             
             
              <a href="/competition/roundtest/${c.id}" class="btn btn-danger">Tham gia vòng thi</a>
            
      
            </div>
        </div>
      </div>
      </c:if>
      </c:forEach>
    
      
    </div>
  </div>
</body>
<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/js/all.min.js"></script>
</html>
