<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/jsp/layout/top.jsp" %>
		gateway_regits <br>
		<form action="/gateway" method="post">
			일련번호 <input type="text" name="code" /> <br>
			<input type="submit" value="완료" />
		</form>
<%@ include file="/WEB-INF/jsp/layout/bottom.jsp" %>