<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>CampusMap-アップロード成功</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0 0 100px 0;
            background-color: #f5fffa;
        }

        h2 {
            text-align: center;
            margin: 20px auto;
            padding: 10px;
            color: #036635;
            font-size: 24px;
            display: inline-block;
        }

        .container {
            max-width: 600px;
            margin: 50px auto;
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        .message {
            font-size: 16px;
            color: #333;
        }

        .btn-container {
            margin-bottom: 10px;
        }

        .btn-container a {
            display: inline-block;
            background-color: #036635;
            color: white;
            text-decoration: none;
            padding: 10px 20px;
            border-radius: 5px;
            font-size: 16px;
            font-weight: bold;
            transition: background-color 0.3s ease;
        }

        .btn-container a:hover {
            background-color: #3cb371;
        }
    </style>
</head>
<body>
<%@ include file="header_login.jsp" %>
    <div class="container">
        <h2>イベントの投稿を完了しました</h2>
        <div class="message">
        	<p>${message}</p>
        </div>
        <div class="btn-container">
            <!-- 戻るボタン -->
            <a href="EventPost.action">戻る</a>
        </div>
    </div>
</body>
<%@ include file="footer.jsp" %>
</html>
