<%@ page language="java" contentType="text/html; charset=UTF-8"
    import = "java.util.*, sec01.ex01.*" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="m" class="sec01.ex01.MemberBean" scope="page"/>
<%
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");
String name = request.getParameter("name");
String phone = request.getParameter("phone");

m.setUser_id("id");
m.setUser_pwd("pwd");
m.setUser_name("name");
m.setUser_phone("phone");

MemberDAO memberDAO = new MemberDAO();

memberDAO.addMember(m);
List memberList = memberDAO.listMembers();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록창</title>
</head>
<body>

</body>
</html>