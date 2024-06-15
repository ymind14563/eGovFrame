<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 성공</title>
<link type="text/css" rel="stylesheet" href="scripts/easycompany.css" />
</head>
<body>
${sessionScope.UserAccount.employeeid} 님은 로그인에 성공했습니다.
<br/>
<a href="employeeList.do">사원리스트 화면으로 가기</a>
</body>
</html>