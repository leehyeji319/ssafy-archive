<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header>
  <nav class="navbar bg-light">
    <div class="container-fluid">
      <a class="navbar-brand mb-0 h1" href="/WhereIsMyHome08_Backend/index.jsp">구해줘 홈즈</a>
      <button
        class="navbar-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      
      <div>
        <!-- 네비게이션 -->
        <ul id="nav-header-point" class="nav justify-content-end">
        	<c:choose>
				<c:when test="${not empty userid}">
					<li class="nav-item">
			          <a class="nav-link" href="#">관심지역 설정</a>
			        </li>
		          	<li class="nav-item">
			            <a class="nav-link" href="#">관심지역 둘러보기</a>
		            </li>
		            <li class="nav-item">
		              	<a class="nav-link" href="${root}/user/logout.do" id="logout">로그아웃</a>
	              	</li>
	              	<li class="nav-item">
		                <a class="nav-link" href="${root}/user/detail.do?userid=${userid}">마이페이지</a>
	                </li>
		        </c:when>
				<c:otherwise>
		            <li class="nav-item">
		              <a class="nav-link" href="${root}/user/register_form.jsp">회원 가입</a>
		            </li>
		            <li class="nav-item">
		              <a class="nav-link" href="${root}/user/login_form.jsp">로그인</a>
		            </li>
				</c:otherwise>
			</c:choose>
		</ul>
      </div>
    </div>
  </nav>
</header>