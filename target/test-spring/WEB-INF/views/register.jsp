<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/20 0020
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="ironman" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
<sf:form method="post" commandName="registerFormBean" action="/form">
	<sf:input path="name"/>
	<sf:errors path="name"/>
	<sf:password path="psw"/>
	<sf:errors path="psw"/>
	<input type="submit" value="TIJIAO">
</sf:form>
<br>
<br>
<br>
<ironman:out value="fff"/>
<ironman:set var="var" value="ss"/>
<ironman:if test="${var == registerFormBean.name}">
<ironman:out value="hhh"/>
</ironman:if>

<br>
<br>

<ironman:set var="sum" value="0"/>
<ironman:forEach var="i" begin="0" end="100" step="2">
	<ironman:set var="sum" value="${sum+i}"/>
</ironman:forEach>
<ironman:out value="${sum}"/>
<br>
<br>
<%
	List<String> names = new ArrayList<String>();
	names.add("zhangSan");
	names.add("liSi");
	names.add("wangWu");
	names.add("zhaoLiu");
	pageContext.setAttribute("ns", names);
%>
<%--第一种方式--%>
<ironman:forEach var="item" items="${ns}">
	<ironman:out value="name: ${item }"/><br/>
</ironman:forEach>
<br>
<br>
<%--第二种方式,有下标--%>
<ironman:forEach var="item" items="${ns}" varStatus="vs">
	<ironman:if test="${vs.first}">第一行：</ironman:if>
	<ironman:if test="${vs.last}">最后一行：</ironman:if>
	<ironman:out value="第${vs.count}行: "/>
	<ironman:out value="[${vs.index}]: "/>
	<ironman:out value="name: ${vs.current}"/><br/>
</ironman:forEach>
<br>
<br>



<%
	Map<String,String> stu = new LinkedHashMap<String,String>();
	stu.put("number", "N_1001");
	stu.put("name", "zhangSan");
	stu.put("age", "23");
	stu.put("sex", "male");
	pageContext.setAttribute("stu", stu);
%>
<ironman:forEach var="item" items="${stu}">
	<ironman:out value="${item.key}: ${item.value }"/><br/>
</ironman:forEach>
<br>
<br>


<fmt:formatDate value="<%=new Date() %>" pattern="yyyy年MM月dd日HH点mm分ss秒" />
<br>
<br>

</body>
</html>
