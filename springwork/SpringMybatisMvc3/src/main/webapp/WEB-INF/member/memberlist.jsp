<%--
  Created by IntelliJ IDEA.
  User: jw
  Date: 2025-02-21
  Time: 오후 12:41
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

        .m-l-tab td {
            text-align: center;
            vertical-align: middle;
        }
        .m-l-tab td:first-child {
            display: flex;
            align-items: center;
            justify-content: flex-start; /* 왼쪽 정렬 */
            gap: 10px; /* 체크박스, 이미지, 텍스트 사이 간격 */
        }
        /* 첫 번째 td 안의 회원명 텍스트를 중앙 정렬 */
        .m-l-tab td:first-child span {
            flex: 1; /* 남은 공간 차지 */
            text-align: center;
        }

        .m-l-tab thead th {
            background-color: mistyrose;
        }

        .mname-chkbox {
            margin: 5px 5px 0 5px;
            float: left;
        }
        .sm-profile {
            width: 40px;
            height: 40px;
            float: left;
        }
    </style>
</head>
<body>
<jsp:include page="../../layout/title.jsp"/>
<div class="container">
    <table class="table table-bordered m-l-tab" style="width: 800px;">
        <thead>
        <th>
            <input type="checkbox" class="mname-chkbox-head">
            회원명
        </th>
        <th>아이디</th>
        <th>휴대폰</th>
        <th>주 소</th>
        <th>삭 제</th>
        </thead>
        <tbody>
        <c:forEach var="dto" items="${list}">
            <tr>
                <td>
                    <input type="checkbox" class="mname-chkbox">
                    <img src="../save/${dto.mphoto}" onerror="this.src='../save/noimage.png'" class="sm-profile">
                    <span>${dto.mname}</span>
                </td>
                <td>
                    ${dto.myid}
                </td>
                <td>
                    ${dto.mhp}
                </td>
                <td>
                    <c:if test="${empty dto.maddr}">
                        미공개
                    </c:if>
                    ${dto.maddr}
                </td>
                <td>
                    <button type="button" class="btn btn-sm btn-danger mbtndel" num="${dto.num}">삭제</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <button type="button" class="btn btn-danger del-selected">선택한 회원 삭제</button>
</div>
</body>
</html>
<script>
    $(".mbtndel").click(function (){
        if(confirm("삭제하시겠습니까?")) {
            $.ajax({
                type: "get",
                dataType: "text",
                url: "./delete",
                data: {"num": $(this).attr("num")},
                success: function (res) {
                    console.log("응답: " + res)
                    location.reload();
                }
            })
        }
    });
    $(".mname-chkbox-head").click(function () {
        $(".mname-chkbox").prop("checked", $(this).prop("checked"));
    });
    $(".del-selected").click(function () {
        let selectedNums = [];  // 선택된 num 값을 저장할 배열

        $(".mname-chkbox:checked").each(function () {
            selectedNums.push($(this).closest("tr").find(".mbtndel").attr("num")); // 해당 행의 num 값 가져오기
        });

        if (selectedNums.length === 0) {
            alert("삭제할 회원을 선택하세요.");
            return;
        }

        if (confirm("선택한 회원을 삭제하시겠습니까?")) {
            $.ajax({
                type: "post",
                dataType: "text",
                url: "./deleteSelected",
                data: { "nums": selectedNums.join(",") }, // 배열을 문자열로 변환하여 전송
                success: function () {
                    location.reload();
                }
            });
        }
    });
</script>