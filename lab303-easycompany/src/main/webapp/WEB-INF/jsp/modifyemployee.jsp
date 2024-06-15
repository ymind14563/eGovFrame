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
<title><spring:message code="easaycompany.updateemployee.title"/></title>

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
		location.href="${pageContext.request.contextPath}/employeeList.do";
	}
	
	//부서정보에 대한 실행횟수에 대한 변수
	var nInitCheck = 0;
	
	$(document).ready(function(){
		$('#superdeptid').change(function(){
	    	   $.ajax({
	    		  url:"<c:url value='/autoSelectDept.do'/>",
	    		  contentType: "application/x-www-form-urlencoded; charset=UTF-8",
	    		  data: {depth:2, superdeptid:encodeURIComponent($('#superdeptid option:selected').val())},	 
	    		  dataType:'json',
	    		  success: function(returnData, status){	  
	    			  $('#departmentid').loadSelectDept(returnData,"근무부서를 선택하세요.");
	    			  //최초에 한번만 실행
	    			  if(nInitCheck == 0){	
	    			  	$('#departmentid').val("${employee.departmentid}");
	    			  	nInitCheck++;
	    			  }
	    		  }
	    	  });    
	    });
		//상위부서에 대한 change 이벤트 호출 
		$('#superdeptid').trigger("change");
	});	
	
</script>
<link type="text/css" rel="stylesheet" href="scripts/easycompany.css" />
</head>
<body>
<jsp:include page="menu.html" flush="true"/>
<br/>
<div id="editform">
<form:form modelAttribute="employee" action="${pageContext.request.contextPath}/updateEmployee.do">
<form:hidden path="employeeid"/>
<table>
	<tr>
		<th>사원번호</th>
		<td><c:out value="${employee.employeeid}"/></td>
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
		<input type="submit"/>
		<input type="button" value="저장" onclick="save(this.form)"/><!-- client-validation을 위해 바로 submit하지 않고 먼저 validateEmployee 함수를 호출-->		
		<input type="button" value="리스트페이지" onclick="location.href='${pageContext.request.contextPath}/employeeList.do'"/>
		</td>
	</tr>
</table>

</form:form>
</div>


	
</body>
</html>