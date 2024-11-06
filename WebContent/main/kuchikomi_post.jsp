<!-- 利用者メニュー -->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="header_login.jsp" %>

<head>
    <meta charset="UTF-8">
    <title>CampusMap-口コミ投稿画面</title>
</head>
<body>
    <!-- メインコンテンツ -->
    <div class="container">
            <!-- 口コミ投稿フォーム -->
        <form action="KuchikomiPostExe.action" method="post">
        <!-- 戻るリンク -->
        <a href="AdminMenu.action">戻る</a><br><br>

            <div class="form-group">
                <label for="kuchikomi_description">口コミ内容:</label>
                <textarea id="kuchikomi_description" name="kuchikomi_description" rows="4"></textarea>
            </div>

            <!-- 送信ボタン -->
            <div class="btn-container">
                <input type="submit" value="投稿">
            </div>
        </form>
    </div>

<%@ include file="footer.jsp" %>
