<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.Kuchikomi" %>
<html>
<head>
    <title>口コミ一覧</title>
</head>
<body>
    <h2>口コミ一覧</h2>
    <a href="SchoolList.action">戻る</a>
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
