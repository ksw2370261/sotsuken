<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="header_login.jsp" %>

<head>
    <meta charset="UTF-8">
    <title>CampusMap - 口コミ一覧</title>
</head>
<body>
    <!-- メインコンテンツ -->
    <div class="container">
        <div class="back-link">
            <a href="AdminMenu.action">戻る</a>
        </div>

        <h2>口コミ一覧</h2>

        <!-- 口コミがない場合のメッセージ -->
        <c:if test="${empty kuchikomiList}">
            <p>現在、口コミは投稿されていません。</p>
        </c:if>

        <!-- 口コミ一覧 -->
        <c:forEach var="kuchikomi" items="${kuchikomiList}">
            <div class="kuchikomi-item">
                <p><strong>投稿者:</strong> ${kuchikomi.kuchikomi_id}</p>
                <p><strong>投稿日時:</strong> ${kuchikomi.kuchikomi_time}</p>
                <p><strong>内容:</strong> ${kuchikomi.kuchikomi_content}</p>
                <hr />
            </div>
        </c:forEach>
    </div>

<%@ include file="footer.jsp" %>
</body>
</html>
