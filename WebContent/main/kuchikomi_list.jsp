<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.Kuchikomi" %>
<%@ page import="java.text.SimpleDateFormat" %>
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
                // 日時フォーマットを指定 (秒数は省略)
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
                for (Kuchikomi kuchikomi : kuchikomiList) {
                    // 口コミ時間をフォーマット
                    String formattedTime = sdf.format(kuchikomi.getKuchikomiTime());
        %>
                    <li>
                        <!-- 口コミ内容 -->
                        <span class="kuchikomiContent"><%= kuchikomi.getKuchikomiContent() %></span>
                        <!-- 口コミ時間 (フォーマット後) -->
                        <span class="kuchikomiTime"><%= formattedTime %></span>
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

