<%@page import="sawon.data.SawonDao"%>
<%@page import="sawon.data.SawonDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%
	//폼 데이터를 읽는다
	String sname = request.getParameter("sname");
	String sphoto = request.getParameter("sphoto");
	String ipsaday = request.getParameter("ipsaday");
	String sblood = request.getParameter("sblood");
	int sbirth = Integer.parseInt(request.getParameter("sbirth"));
	int num = Integer.parseInt(request.getParameter("num"));
	// dto에 넣는다
	SawonDto dto = new SawonDto();
	dto.setSname(sname);
	dto.setSbirth(sbirth);
	dto.setSblood(sblood);
	dto.setSphoto(sphoto);
	dto.setIpsaday(ipsaday);
	dto.setNum(num);
	// dao 선언
	SawonDao dao= new SawonDao();
	// insert 메서드 호출
	dao.updateSawon(dto);
	// 목록으로 이동
	response.sendRedirect("./sawondetail.jsp?num="+num);
%>