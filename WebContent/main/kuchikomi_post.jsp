<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="header_login.jsp" %>

<head>
    <meta charset="UTF-8">
    <title>CampusMap - 口コミ投稿画面</title>
</head>
<body>
    <!-- メインコンテンツ -->
    <div class="container">
        <!-- 戻るリンク -->
        <div class="back-link">
            <a href="AdminMenu.action">戻る</a>
        </div>

        <h2>口コミ投稿</h2>

        <!-- 口コミ投稿フォーム -->
        <form action="KuchikomiPostExe.action" method="post">
            <!-- 口コミ内容 -->
            <div class="form-group">
                <label for="kuchikomi_content">口コミ内容:</label>
                <textarea id="kuchikomi_content" name="kuchikomi_content" rows="4" required></textarea>
            </div>

            <!-- 投稿ボタン -->
            <div class="btn-container">
                <input type="submit" value="投稿">
            </div>
        </form>
    </div>

<%@ include file="footer.jsp" %>
</body>
