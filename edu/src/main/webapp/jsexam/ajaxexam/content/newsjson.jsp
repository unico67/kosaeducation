<%@ page language="java" contentType="application/json; charset=UTF-8"%>
<% String news[] = { "뉴스1",
		"뉴스2",
		"뉴스3",
  	    "뉴스4?",
		"뉴스5",
		"뉴스6",
		"뉴스7"}; %>
<% response.setHeader("Cache-Control", "no-cache"); %>
<% int num = (int)(Math.random() * 7);%>
{ 
	"news" : "<%= news[num] %>"
}