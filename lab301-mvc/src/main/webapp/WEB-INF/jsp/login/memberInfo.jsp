<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"    uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사용자 정보 보기</title>
</head>
<body>
사용자 정보 보기

<table>
	<tr>
		<td><label for="id">회원 ID</label></td>
		<td><input type="text" value="<c:out value="${login.id}"/>"></td>
	</tr>
    <tr>
        <td><label for="password">회원 패스워드</label></td>
        <td><input type="text" value="<c:out value="${login.password}"/>"></td>
    </tr>
    <tr>
        <td><label for="loginType">회원 로긴타입</label></td>
        <td><input type="text" value="<c:out value="${login.loginType}"/>"></td>
    </tr>
    <tr>
        <td colspan="2"><a href="loginOut.do">로그아웃</a></td>
    </tr>
    <tr>
        <td colspan="2"><a href="loginProcess1.do">다시 원 화면으로 </a></td>
    </tr>
</table> 

</body>
</html>