<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
	<c:when test="${not empty cookie.userId.value}">
		${cookie.userId.value}님 로그인중
		<span class="btn btn-info">로그아웃</span>	
	</c:when>
	<c:otherwise>
		<span class="btn btn-primary">회원가입</span>
		<span class="btn btn-info">로그인</span>
	</c:otherwise>
</c:choose>