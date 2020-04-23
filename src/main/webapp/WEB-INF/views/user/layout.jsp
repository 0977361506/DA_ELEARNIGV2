<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
  
   <tiles:insertAttribute name="head" />
 
</head>
<body>

 <div class="super_container">
  <tiles:insertAttribute name="menu" />

 
  
  <tiles:insertAttribute name="body" />

  

  <tiles:insertAttribute name="footer" />

</div>

  
</body>

</html>