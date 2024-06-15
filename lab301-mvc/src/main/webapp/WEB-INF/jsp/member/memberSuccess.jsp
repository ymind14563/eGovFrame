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
            <td>${memberInfo.id}</td>
        </tr>
        <tr>
            <td><form:label path="name">이름</form:label></td>
            <td>${memberInfo.name}</td>
        </tr>
        <tr>
            <td><form:label path="address.address">주소1</form:label></td>
            <td>${memberInfo.address.address}</td>
        </tr>
        <tr>
            <td><form:label path="address.addressDetail">주소2</form:label></td>
            <td>${memberInfo.address.addressDetail}</td>
        </tr>
        <tr>
            <td><form:label path="jobCode">직업</form:label></td>
            <td><form:select path="jobCode" disabled="true">
                <option value="">--- 선택하세요 ---</option>
                <form:options items="${jobCodes}" itemLabel="label" itemValue="code" />
            </form:select></td>
        </tr>
        <tr>
            <td><form:label path="favorites">선호 OS</form:label></td>
            <td><form:checkboxes items="${favoritesOsNames}" path="favorites" disabled="true"/></td>
        </tr>
        <tr>
            <td><form:label path="tool">주로 사용하는 개발툴</form:label></td>
            <td colspan="2"><form:radiobuttons items="${tools}" path="tool" disabled="true"/></td>
        </tr>
        <tr>
            <td><form:label path="etc">기타</form:label></td>
            <td colspan="2"><form:textarea path="etc" cols="20" rows="3" disabled="true"/></td>
        </tr>

    </table>
</form:form>
</body>
</html>