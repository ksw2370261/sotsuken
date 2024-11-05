<!-- 管理者メニュー.jsp -->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="header_login.jsp" %>

<head>
    <meta charset="UTF-8">
    <title>イベント投稿画面</title>
</head>
<body>
    <!-- メインコンテンツ -->
    <div class="container">
            <!-- イベント投稿フォーム -->
        <form action="EventPostExe.action" method="post">
        <!-- 戻るリンク -->
        <a href="admin_menu.jsp">戻る</a><br><br>


            <div class="form-group">
                <label for="event_date">日付:</label>
                <input type="date" id="event_date" name="event_date" required>
            </div>

            <div class="form-group">
                <label for="event_time">時間:</label>
                <input type="time" id="event_time" name="event_time" required>
            </div>

            <div class="form-group">
                <label for="event_location">場所:</label>
                <input type="text" id="event_location" name="event_location" required>
            </div>

            <div class="form-group">
                <label for="event_name">イベント名:</label>
                <input type="text" id="event_name" name="event_name">
            </div>

            <div class="form-group">
                <label for="event_description">イベント内容:</label>
                <textarea id="event_description" name="event_description" rows="4"></textarea>
            </div>

            <!-- 送信ボタン -->
            <div class="btn-container">
                <input type="submit" value="投稿">
            </div>
        </form>
    </div>

<%@ include file="footer.jsp" %>
