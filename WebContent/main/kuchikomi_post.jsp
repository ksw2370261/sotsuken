<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>口コミ投稿</title>
    <link rel="stylesheet" href="user.css">
</head>
<body>
    <h2>口コミ投稿</h2>

    <!-- 戻るボタン -->
    <form action="Kuchikomi.action" method="get">
        <input type="hidden" name="schoolCd" value="<%= request.getParameter("schoolCd") %>">
        <button type="submit">戻る</button>
    </form>

    <form action="KuchikomiPostExe.action" method="post">
        <input type="hidden" name="schoolCd" value="<%= request.getParameter("schoolCd") %>">

        <label for="kuchikomiContent">口コミ内容</label><br>
        <textarea id="kuchikomiContent" name="kuchikomiContent" rows="4" cols="50"></textarea><br>

        <button type="submit">投稿</button>
    </form>
</body>
</html>
