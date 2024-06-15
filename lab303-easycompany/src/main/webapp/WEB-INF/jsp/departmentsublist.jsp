<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="scripts/easycompany.css" />
</head>
<body>
<div id="listpage">
<table>
	<tr>
		<th></th>
		<th>부서번호</th>
		<th>부서명</th>
		<th>상위부서명</th>
	</tr>	
<c:forEach items="${departmentlist}" var="departmentinfo">
	<tr>
		<td></td>
		<td><a href="javascript:departmentInfo('${departmentinfo.deptid}')">${departmentinfo.deptid}</a></td>
		<td>${departmentinfo.deptname}</td>
		<td>${departmentinfo.superdeptname}</td>
	</tr>
</c:forEach>
</table>
</div>
</body>
</html>