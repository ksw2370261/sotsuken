<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.Kuchikomi" %>
<html>
<head>
    <title>口コミ一覧</title>
    <link rel="stylesheet" href="user.css">
</head>
<body>
    <h2>口コミ一覧</h2>
    <!-- 戻るボタン -->
    <form action="SchoolList.action">
        <button type="submit">戻る</button>
    </form>

    <!-- 口コミ投稿ボタン -->
    <form action="KuchikomiPost.action" method="get">
        <input type="hidden" name="schoolCd" value="<%= request.getParameter("schoolCd") %>">
        <button type="submit">口コミ投稿</button>
    </form>

    <ul>
        <%
            // リクエスト属性から口コミリストを取得
            List<Kuchikomi> kuchikomiList = (List<Kuchikomi>) request.getAttribute("kuchikomiList");
            if (kuchikomiList != null && !kuchikomiList.isEmpty()) {
                for (Kuchikomi kuchikomi : kuchikomiList) {
        %>
                    <li>
                        <span><%= kuchikomi.getKuchikomiContent() %></span>
                        <span>(<%= kuchikomi.getKuchikomiTime() %>)</span>
                    </li>
        <%
                }
            } else {
        %>
            <li>口コミが見つかりません。</li>
        <%
            }
        %>
    </ul>
</body>
</html>
