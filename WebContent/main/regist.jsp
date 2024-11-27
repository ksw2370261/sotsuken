<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>CampusMap-新規登録</title>
    <!-- 共通スタイルを定義 -->
    <style>
        /* 既存のスタイル */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5fffa;
        }
        .content {
            width: 100%;
            max-width: 600px;
            margin: auto auto 100px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            margin-bottom: 30px;
            font-size: 24px;
            color: #333;
        }
        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px 12px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
            box-sizing: border-box;
        }
        button {
            width: 100%;
            padding: 12px;
            margin: 10px 0;
            background-color: #4CAF50;
            border: none;
            border-radius: 5px;
            color: white;
            font-size: 16px;
            cursor: pointer;
        }
        button:hover {
            background-color: #45a049;
        }
        .register-link {
            text-align: center;
            margin-top: 15px;
        }
        .register-link a {
            color: #333;
            text-decoration: none;
        }
        .register-link a:hover {
            text-decoration: underline;
        }
        /* エラーメッセージ用のスタイル */
        .error-message {
            color: red;
            font-size: 14px;
            text-align: center;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <%@ include file="header.jsp" %>

    <div class="content">
        <h2>新規登録</h2>

        <!-- エラーメッセージを表示 -->
        <%
            String error = (String) request.getAttribute("error");
            if (error != null) {
        %>
            <div class="error-message"><%= error %></div>
        <% } %>

        <form action="RegistExe.action" method="post">
            <div class="admin-id">
                <input type="text" name="admin_id" id="login" placeholder="ID　　　　　　半角英数字でご入力ください" required pattern="^[a-zA-Z0-9]+$" title="半角英数字のみ入力可能">
            </div>

            <div class="pass">
                <input type="password" name="password" placeholder="パスワード　　半角英数字でご入力ください" required pattern="^[a-zA-Z0-9]+$" title="半角英数字のみ入力可能">
            </div>

            <div class="school-name">
                <input type="text" name="school_name" placeholder="学校名" required>
            </div>

            <div>
                <button type="submit" name="register">新規登録</button>
            </div>
        </form>

        <div class="register-link">
            <a href="Login.action">ログインはこちら</a>
        </div>
    </div>

    <%@ include file="footer.jsp" %>
</body>
</html>

