<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="BASE" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>客户管理</title>
</head>
<body>

<h1>${createOrEdit}-客户界面</h1>

<form id="customer_form" action="${BASE}/customerSave" method="post">
    <table>
        <tr style="display:none;">
            <td>id：</td>
            <td>
                <input type="text" name="id" value="${customer.id}">
            </td>
        </tr>
        <tr>
            <td>客户名称：</td>
            <td>
                <input type="text" name="name" value="${customer.name}">
            </td>
        </tr>
        <tr>
            <td>联系人：</td>
            <td>
                <input type="text" name="contact" value="${customer.contact}">
            </td>
        </tr>
        <tr>
            <td>电话号码：</td>
            <td>
                <input type="text" name="telephone" value="${customer.telephone}">
            </td>
        </tr>
        <tr>
            <td>邮箱地址：</td>
            <td>
                <input type="text" name="email" value="${customer.email}">
            </td>
        </tr>
        <tr>
            <td>备注：</td>
            <td>
                <input type="text" name="remark" value="${customer.remark}">
            </td>
        </tr>
    </table>
    <button type="submit">保存</button>
</form>

</body>
</html>