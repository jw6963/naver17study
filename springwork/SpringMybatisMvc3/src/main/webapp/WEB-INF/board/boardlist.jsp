<%--
  Created by IntelliJ IDEA.
  User: jw
  Date: 2025-02-26
  Time: 오후 1:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>502 jsp study</title>
    <link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap"
          rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <style>
        body * {
            font-family: 'Jua';
        }

        .tabboard thead th {
            text-align: center;
            background-color: #ccc;
        }
        .p-icon {
            color: #ccc;
            font-size: 0.9em;
        }
    </style>
</head>
<body>
<jsp:include page="../../layout/title.jsp"/>

<div style="margin: 20px; width: 700px;">
    <h5 class="alert alert-danger">
        총 ${totalCount} 개의 글이 있습니다
        <button type="button" class="btn btn-sm btn-success"
                style="float: right" onclick="location.href='./writeform'">글쓰기
        </button>
    </h5>
    <table class="tabboard table table-bordered">
        <thead>
        <tr>
            <th width="50">번호</th>
            <th width="400">제목</th>
            <th width="80">작성자</th>
            <th width="100">작성일</th>
            <th>조회</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${totalCount==0}">
            <tr>
                <td colspan="5" align="center">
                    등록된 글이 없습니다
                </td>
            </tr>
        </c:if>
        <c:if test="${totalCount>0}">
            <c:forEach var="dto" items="${list}">
                <tr>
                    <td align="center">
                        ${no}
                        <c:set var="no" value="${no-1}"/>
                    </td>
                    <td>
                        <a href="./detail?idx=${dto.idx}&pageNum=${pageNum}"
                        style="color: black; text-decoration: none;">
                        <%--  답글인 경우 레벨만큼 띄어쓰기  --%>
                        <c:if test="${dto.relevel>0}">
                            <c:forEach begin="1" end="${dto.relevel}">
                                &nbsp;&nbsp;&nbsp;
                            </c:forEach>
                            <%--  답글인 경우 re 이미지  --%>
                            <img src="../re.png" alt="">
                        </c:if>
                        ${dto.subject}
                        <%--  이미지가 한 개 이상인 경우 이미지 아이콘 첨가  --%>
                        <c:if test="${dto.photocount>1}">
                            <i class="bi bi-images p-icon"></i>
                        </c:if>
                        <c:if test="${dto.photocount==1}">
                            <i class="bi bi-image p-icon"></i>
                        </c:if>
                            &nbsp;
                            <c:if test="${dto.repleCount>0}">
                                <span style="color: red">[${dto.repleCount}]</span>
                            </c:if>
                        </a>
                    </td>
                    <td align="center">
                        ${dto.writer}
                    </td>
                    <td style="font-size: 12px; color: gray;" align="center">
                        <fmt:formatDate value="${dto.writeday}" pattern="yyyy-MM-dd"/>
                    </td>
                    <td align="center" style="font-size: 14px; color: gray">
                        ${dto.readcount}
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>
    <div style="width: 700px; text-align: center; display: flex;justify-content: center;">
        <ul class="pagination">
            <c:if test="${startPage>1}">
                <li class="page-item"><a class="page-link" href="./list?pageNum=${startPage-1}">Prev</a></li>
            </c:if>
            <c:forEach var="pp" begin="${startPage}" end="${endPage}">
                <c:if test="${pp==pageNum}">
                    <li class="page-item active">
                        <a class="page-link" href="./list?pageNum=${pp}">${pp}</a>
                    </li>
                </c:if>
                <c:if test="${pp!=pageNum}">
                    <li class="page-item">
                        <a class="page-link" href="./list?pageNum=${pp}">${pp}</a>
                    </li>
                </c:if>
            </c:forEach>
            <c:if test="${endPage<totalPage}">
                <li class="page-item"><a class="page-link" href="./list?pageNum=${endPage+1}">Next</a></li>
            </c:if>
<%--            <li class="page-item"><a class="page-link" href="#">Previous</a></li>--%>
<%--            <li class="page-item"><a class="page-link" href="#">1</a></li>--%>
<%--            <li class="page-item active"><a class="page-link" href="#">2</a></li>--%>
<%--            <li class="page-item"><a class="page-link" href="#">3</a></li>--%>
<%--            <li class="page-item"><a class="page-link" href="#">Next</a></li>--%>
        </ul>
    </div>
</div>
</body>
</html>
