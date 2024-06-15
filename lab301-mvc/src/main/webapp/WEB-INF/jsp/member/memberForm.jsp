<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 등록 폼</title>
</head>
<body>
<form:form modelAttribute="memberInfo">
	<table>
		<tr>
			<td><form:label path="id">회원 ID</form:label></td>
			<td><form:input path="id" /></td>
			<td><form:errors path="id" /></td>
		</tr>
		<tr>
			<td><form:label path="name">이름</form:label></td>
			<td><form:input path="name" /></td>
			<td><form:errors path="name" /></td>
		</tr>
		<tr>
			<td><form:label path="address.address">주소1</form:label></td>
			<td><form:input path="address.address" /></td>
			<td><form:errors path="address.address" /></td>
		</tr>
		<tr>
			<td><form:label path="address.addressDetail">주소2</form:label></td>
			<td><form:input path="address.addressDetail" /></td>
			<td><form:errors path="address.addressDetail" /></td>
		</tr>
		<tr>
			<td><form:label path="jobCode">직업</form:label></td>
			<td><form:select path="jobCode">
				<option value="">--- 선택하세요 ---</option>
				<form:options items="${jobCodes}" itemLabel="label" itemValue="code" />
			</form:select></td>
			<td><form:errors path="jobCode" /></td>
		</tr>
		<tr>
			<td><form:label path="favorites">선호 색깔</form:label></td>
			<td><form:checkboxes items="${favoritesOsNames}" path="favorites" /></td>
			<td><form:errors path="favorites" /></td>
		</tr>
		<tr>
			<td><form:label path="tool">주로 사용하는 개발툴</form:label></td>
			<td colspan="2"><form:radiobuttons items="${tools}" path="tool" /></td>
		</tr>
		<tr>
			<td><form:label path="etc">기타</form:label></td>
			<td colspan="2"><form:textarea path="etc" cols="20" rows="3" /></td>
		</tr>
		<tr>
			<td colspan="3"><input type="submit" value="등록"></td>
		</tr>
	</table>
</form:form>
</body>
</html>