<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><spring:message code="easaycompany.departmentlist.title"/></title>
<link type="text/css" rel="stylesheet" href="scripts/easycompany.css" />
<!-- jQuery -->
<link rel="stylesheet" href="<c:url value='/css/jqueryui.css'/>"/>
<script src="<c:url value='/js/jquery.js'/>"></script>
<script src="<c:url value='/js/jqueryui.js'/>"></script>
<script type="text/javascript">

	function departmentInfo(id){
		location.href = "${pageContext.request.contextPath}/updateDepartment.do?deptid="+id;
	};
	
	 $(function() {
	    $( "#listpage" ).tabs();
	  });
	  
</script>
</head>
<body>
<jsp:include page="menu.html" flush="true"/>
<br/>
<div id="listpage">
<ul>
	<c:forEach items="${departmentlist}" var="departmentinfo" varStatus="status">
		<c:choose>
			<c:when test="${status.first}">
				<li><a href="${pageContext.request.contextPath}/subDepartmentList.do?superdeptid=${departmentinfo.deptid}&depth=2">${departmentinfo.deptname}</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="${pageContext.request.contextPath}/subDepartmentList.do?superdeptid=${departmentinfo.deptid}&depth=2">${departmentinfo.deptname}</a></li>
			</c:otherwise>
		</c:choose>
		</li>
	</c:forEach>
</ul>
</div>

</body>
</html>