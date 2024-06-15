<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><spring:message code="easaycompany.updatedepartment.title"/></title>
<link type="text/css" rel="stylesheet" href="scripts/easycompany.css" />
</head>
<body>
<jsp:include page="menu.html" flush="true"/>
<br/>
<div id="editform">
<form:form modelAttribute="department">
<table>
	<tr>
		<th>부서번호</th>
		<td><c:out value="${department.deptid}"/></td>
	</tr>
	<tr>
		<th>부서이름</th>
		<td><form:input path="deptname" size="20"/></td>
	</tr>
	<tr>
		<th>상위부서</th>
		<td>
			<form:select path="superdeptid">
				<option value="">상위부서를 선택하세요.</option>
				<form:options items="${deptInfoOneDepthCategory}" />
			</form:select>
		</td>
	</tr>
	<tr>
		<th>설명</th>
		<td><form:textarea path="description" rows="10" cols="40"/></td>
	</tr>	
</table>
<table width="80%" border="1">
	<tr>
		<td>
		<input type="submit" value="저장"/>		
		<input type="button" value="리스트페이지" onclick="location.href='${pageContext.request.contextPath}/departmentList.do?depth=1'"/>
		</td>
	</tr>
</table>
</form:form>
</div>
</body>
</html>