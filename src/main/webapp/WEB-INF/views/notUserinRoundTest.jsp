<%@ page pageEncoding="utf-8"%>
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
      <div class="col-sm-auto">
        <div class="alert alert-danger alert-sm">Bạn không được phép tham gia vòng thi này. Đây là vòng thi đóng và bạn không nằm trong danh sách thí sinh!</div>
    
      </div>
    </div>

  </div>
  <div class="main p-3" id="main">
    <div class="card w-100">
      <div class="color-primary pt-2 pl-3">
        <i class="fa fa-history"></i>
        <span class="">Bạn đã làm bài thi này <b>0</b> lần</span>
      </div>
      <hr>
      <div class="pb-3 pl-3">

        <span class="">Bạn chưa tham gia vòng thi này!</span>
      </div>
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
