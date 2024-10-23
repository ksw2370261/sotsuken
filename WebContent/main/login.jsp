<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/MICHISADA/main/login_style.css">
<!DOCTYPE html>
<html lang="ja">
<div class="main-content">

<head>
<title>ログイン</title>
<head>

<body>
<div>
<h2>ログイン</h2>

<div class="id">
<input type="text" name="id" id="login" placeholder="半角でご入力ください" required>
</div>

<div class="pass">
<input type="text" name="password" password="login" placeholder="20文字以内の半角英数字でご入力ください">
</div>

<div>
<button name="login">ログイン</button>
<button name="login">新規登録</button>
</div>

</body>
</div>

</html>