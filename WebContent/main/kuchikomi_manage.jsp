<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.Kuchikomi" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="header_login.jsp" %>

<head>
    <title>CampusMap-口コミ管理</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5fffa;
        }

        h2 {
            text-align: center;
            align-items: center;
            margin: 20px auto;
            padding: 1rem 3rem;
            width: 200px;
            color: #036635;
            border-radius: 100vh;
            background-color: #ffffff;
            border: 2px solid #036635;
        }

        .btn-back {
            display: inline-block;
            background-color: #036635;
            color: white;
            padding: 10px 20px;
            border-radius: 5px;
            text-align: center;
            text-decoration: none;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
            transition: background-color 0.3s;
            margin: 0px 0px 25px 160px;
        }

        .btn-back:hover {
            background-color: #3cb371;
            color: #ffffff;
        }

        .container {
            max-width: 900px;
            margin: auto auto 100px auto;
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            overflow-y: auto; /* Enable scrolling */
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 10px;
            text-align: center;
            border: 1px solid #ddd;
        }

        th {
            background-color: #036635;
            color: white;
        }

        td {
            background-color: #ffffff;
        }

        .delete-btn {
            position: absolute;
            right: 203px;
            transform: translateY(-50%);
            padding: 5px 10px;
            background-color: #ff6347;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
            transition: background-color 0.3s;
        }

        .delete-btn:hover {
            background-color: #ff4500;
        }
    </style>
</head>

<body>
    <h2>口コミ管理</h2>
    <a href="admin_menu.jsp" class="btn-back">戻る</a>
    <div class="container">
        <c:if test="${not empty kuchikomiList}">
            <table>
			    <tr>
			    	<th style="width: 10%;">口コミ名</th>
			        <th style="width: 63%;">口コミ内容</th>
			        <th style="width: 17%;">口コミ時間</th>
			        <th style="width: 10%;">削除</th>
			    </tr>
			    <c:forEach var="kuchikomi" items="${kuchikomiList}">
			        <tr>
			        	<td>${kuchikomi.kuchikomiName}</td>
			            <td>${kuchikomi.kuchikomiContent}</td>
			            <!-- 日付をフォーマット -->
			            <td><fmt:formatDate value="${kuchikomi.kuchikomiTime}" pattern="yyyy年MM月dd日 HH時mm分" /></td>
			            <td><button class="delete-btn" onclick="deleteKuchikomi(${kuchikomi.kuchikomiCd})">削除</button></td>
			        </tr>
			    </c:forEach>
			</table>
        </c:if>

        <c:if test="${empty kuchikomiList}">
            <p>口コミはありません。</p>
        </c:if>
    </div>

    <script>
        function deleteKuchikomi(kuchikomiCd) {
            if (confirm('この口コミを削除しますか？')) {
                window.location.href = 'KuchikomiDelete.action?kuchikomiCd=' + kuchikomiCd;
            }
        }
    </script>
<%@ include file="footer.jsp" %>
</body>
</html>
