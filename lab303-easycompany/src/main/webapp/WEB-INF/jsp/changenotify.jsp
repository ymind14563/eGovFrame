<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	
	function goToList(){
		location.href = "${pageContext.request.contextPath}/employeeList.do";
	}

	function goToForm(){
		location.href = "${pageContext.request.contextPath}/updateEmployee.do?employeeid="+<c:out value="${employee.employeeid}"/>;
	}
	
</script>
<link type="text/css" rel="stylesheet" href="scripts/easycompany.css" />
</head>
<body>
<jsp:include page="menu.html" flush="true"/>
<div id="editform">
<table>
	<tr>
		<th>사원번호</th>
		<td><c:out value="${employee.employeeid}" /></td>
	</tr>
	<tr>
		<th>부서번호</th>
		<td><c:out value="${employee.departmentid}" /></td>
	</tr>
	<tr>
		<th>이름</th>
		<td><c:out value="${employee.name}" /></td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td><c:out value="${employee.password}" /></td>
	</tr>
	<tr>
		<th>나이</th>
		<td><c:out value="${employee.age}" /></td>
	</tr>
	<tr>
		<th>이메일</th>
		<td><c:out value="${employee.email}" /></td>
	</tr>
</table>
<table width="80%" border="1">
	<tr>
		<td><input type=button value="확인" onclick="goToList()" />
		<input type=button value="재수정" onclick="goToForm()" /></td>
	</tr>
</table>
</div>
</body>
</html>