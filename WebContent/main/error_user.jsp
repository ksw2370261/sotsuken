<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="header_user.jsp" %>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>Campus Map-利用者エラー</title>
    <style>
        /* 全体のフォント設定や背景 */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5fffa;
            overflow-x: hidden;
        }

        /* 見出し */
        h2 {
            text-align: center;
            margin: 20px auto 10px;
            padding: 1rem 3rem;
            width: 200px;
            color: #036635;
            border-radius: 100vh;
            background-color: #ffffff;
            border: 2px solid #036635;
        }

        /* メッセージ */
        .error-message {
            text-align: center;
            margin: 20px auto;
            font-size: 1.4rem;
        }

        /* ボタンコンテナ */
        .button-container {
            text-align: center;
            margin: 30px auto;
        }

        /* リンクボタン */
        .button-container a {
            display: inline-block;
            padding: 10px 20px;
            background-color: #036635;
            color: white;
            text-decoration: none;
            border-radius: 8px;
            font-size: 1rem;
            transition: background-color 0.3s;
            cursor: pointer;
        }

        .button-container a:hover {
            background-color: #024f3d;
        }

        @media (max-width: 768px) {
            body {
                padding: 10px;
                font-size: 1.4rem;
            }

            h2 {
                width: 80%;
                padding: 1rem;
                font-size: 2.0rem;
            }
    </style>
</head>
<body>
    <h2>エラー</h2>

  	<div class="error-message">
  		<p>エラーが発生しました</p>
	</div>

    <div class="button-container">
        <a href="SchoolList.action">学校一覧に戻る</a>
    </div>
<%@ include file="footer_user.jsp" %>
</body>
</html>