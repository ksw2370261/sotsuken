<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/MICHISADA/main/login_style.css">
<!DOCTYPE html>
<html lang="ja">

<head>
    <title>ログイン</title>
</head>

<body>
    <%@include file="header.jsp"%> <!-- ヘッダーを上部に配置 -->

    <div class="main-content">
        <h2>ログイン</h2>

        <div class="id">
            <input type="text" name="id" id="login" placeholder="半角でご入力ください" required>
        </div>

        <div class="pass">
            <input type="password" name="password" placeholder="20文字以内の半角英数字でご入力ください">
        </div>

        <div>
            <button name="login">ログイン</button>
            <button name="register">新規登録</button>
        </div>
    </div>

    <%@include file="footer.jsp" %> <!-- フッターを下部に配置 -->
</body>

</html>
