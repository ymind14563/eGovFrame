<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><spring:message code="easaycompany.insertemployee.title"/></title>

<!--for including generated Javascript Code(in validation-rules.xml)-->
<script type="text/javascript" src="<c:url value="/validator.do"/>"></script>
<!--for including generated Javascript Code(validateEmployee(), formName:커맨드 클래스 이름)-->
<validator:javascript formName="employee" staticJavascript="false" xhtml="true" cdata="false"/>

<!-- jQuery -->
<link rel="stylesheet" href="<c:url value='/css/jqueryui.css'/>"/>
<script src="<c:url value='/js/jquery.js'/>"></script>
<script src="<c:url value='/js/jqueryui.js'/>"></script>
<!-- jQuery plugin -->
<script src="<c:url value='/js/select_load.js'/>"></script>

<script type="text/javascript">

	function save(form){
		
		if(!validateEmployee(form)){
			return;
		}else{
			form.submit();
		}
	}
	
	function list(){
		location.href="employeeList.do";
	}
	
	
	$(document).ready(function(){
		// TODO [Step 4-4-04] addemployee.jsp 에서 jquery 이용하여 ajax 방식으로 통신하여 근무부서를 조회한다.
		// (jquery plugin loadSelectDept 사용하여 근무부서를 로딩한다.)
		
	
	});
		 
	
</script>

<link type="text/css" rel="stylesheet" href="scripts/easycompany.css" />
</head>
<body>
<jsp:include page="menu.html" flush="true"/>
<br/>
<div id="editform">
<form:form modelAttribute="employee">
<table>
	<tr>
		<th>사원번호</th>
		<td><form:input path="employeeid" size="20" /></td>
	</tr>
	<tr>
		<th>부서번호</th>
		<td>
			<form:select path="superdeptid">
				<option value="">상위부서를 선택하세요.</option>
				<form:options items="${deptInfoOneDepthCategory}" />
			</form:select>
			<form:select path="departmentid">
				<option value="">근무부서를 선택하세요.</option>
				<form:options items="${deptInfoTwoDepthCategory}" />
			</form:select>
		</td>
	</tr>
	<tr>
		<th>이름</th>
		<td><form:input path="name" size="20"/><form:errors path="name" /></td>		
	</tr>
	<tr>
		<th>비밀번호</th>
		<td><form:password path="password" size="10" showPassword="true"/></td>
	</tr>
	<tr>
		<th>나이</th>
		<td><form:input path="age" size="10"/><form:errors path="age" /></td>
	</tr>
	<tr>
		<th>이메일</th>
		<td><form:input path="email" size="50"/><form:errors path="email" /></td>
	</tr>
</table>
<table width="80%" border="1">
	<tr>
		<td>
		<!-- <input type="submit"/>  -->
		<input type="button" value="SAVE" onclick="save(this.form)"/><!-- client-validation을 위해 바로 submit하지 않고 먼저 validateEmployee 함수를 호출-->
		<input type="button" value="LIST" onclick="location.href='${pageContext.request.contextPath}/employeeList.do'"/>
		</td>
	</tr>
</table>

</form:form>
</div>


</body>
</html>