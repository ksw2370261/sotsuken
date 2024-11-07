<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>口コミ一覧</title>
</head>
<body>
    <h2>口コミ一覧</h2>

    <!-- 口コミ投稿ページへのリンク -->
    <a href="kuchikomi_post.jsp">口コミを投稿する</a>
    <br><br>

    <table border="1">
        <thead>
            <tr>
                <th>口コミ内容</th>
                <th>投稿時間</th>
            </tr>
        </thead>
        <tbody>
            <!-- 口コミを繰り返し表示 -->
            <c:forEach var="kuchikomi" items="${kuchikomiList}">
                <tr>
                    <td>${kuchikomi.kuchikomi_content}</td>
                    <td>${kuchikomi.kuchikomi_time}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
