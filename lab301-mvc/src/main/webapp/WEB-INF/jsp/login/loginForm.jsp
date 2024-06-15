<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="login.form.title" /></title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/egov.css'/>"/>

</head>
<body>
<h3>Login Page</h3>
<form:form modelAttribute="login">
	<form:errors />
	<table>
		<tr>
			<!-- TODO [Step 1-2-2] SpringMessage 사용 -->
			<td><label for="id"><spring:message code="login.form.id" /></label></td>
			<!-- <td><label for="id">아이디</label></td> -->
			<td><form:input id="id" path="id" /></td>
			<td><form:errors path="id" /></td>
		</tr>
		<tr>
			<td><label for="password"><spring:message code="login.form.password" /></label></td>
			<td><form:password id="password" path="password" /></td>
			<td><form:errors path="password" /></td>
		</tr>
		<tr>
			<td><label for="loginType"> 
			<spring:message	code="login.form.type" /></label></td>
			<td><form:select path="loginType">
				<option value="">---선택하세요---</option>
				<form:options items="${loginTypes}" itemValue="code" itemLabel="value" />
			</form:select></td>
			<td><form:errors path="loginType" /></td>
		</tr>
        <tr>
            <td colspan="3" align="right" >
                <input type="submit" value="<spring:message code="login.form.submit" />">
            </td>
        </tr>
	</table>
</form:form>
</body>
</html>