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
        <!-- 戻るリンク -->
        <a href="eventList.jsp">戻る</a><br><br>

        <!-- イベント投稿フォーム -->
        <form action="EventServlet" method="post">
            <div class="form-group">
                <label for="date">日付:</label>
                <input type="date" id="date" name="date" required>
            </div>

            <div class="form-group">
                <label for="time">時間:</label>
                <input type="time" id="time" name="time" required>
            </div>

            <div class="form-group">
                <label for="place">場所:</label>
                <input type="text" id="place" name="place" required>
            </div>

            <div class="form-group">
                <label for="event">イベント名:</label>
                <input type="text" id="event" name="event" required>
            </div>

            <div class="form-group">
                <label for="detail">イベント内容:</label>
                <textarea id="detail" name="detail" rows="4" required></textarea>
            </div>

            <!-- 送信ボタン -->
            <div class="btn-container">
                <input type="submit" value="投稿">
            </div>
        </form>
    </div>


<%@ include file="footer.jsp" %>