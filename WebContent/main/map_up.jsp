<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="header_login.jsp" %>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>CampusMap-マップアップロード</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0px 0px 100px 0px;
            background-color: #f5fffa;
        }

        h2 {
            text-align: center;
            align-items: center;
            margin: 20px auto;
            padding: 1rem 3rem;
            width: 220px;
            color: #036635;
            border-radius: 100vh;
            background-color: #ffffff;
            border: 2px solid #036635;
        }

        .container {
            max-width: 600px;
            margin: 0 auto;
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-group label {
            display: block;
            color: #036635;
            font-weight: bold;
            margin-bottom: 5px;
        }

        .form-group input, .form-group textarea {
            width: 100%;
            padding: 8px;
            border-radius: 5px;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }

        .btn-container {
            text-align: center;
        }

        .btn-container button {
            background-color: #036635;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .btn-container button:hover {
            background-color: #3cb371;
        }

        a {
            color: #036635;
            text-decoration: none;
            font-weight: bold;
        }

        a:hover {
            color: #e0f7fa;
        }

        .btn-back {
            display: inline-block;
            background-color: #036635;
            color: white;
            padding: 10px 20px;
            border-radius: 5px;
            text-align: center;
            text-decoration: none;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
            transition: background-color 0.3s;
            margin-bottom: 20px;
        }

        .btn-back:hover {
            background-color: #3cb371;
            color: #ffffff;
        }

        .caution-message {
            color: red; /* 注意メッセージの色を赤に設定 */
        }
    </style>
</head>

<body>
    <h2>マップアップロード</h2>
    <div class="container">
        <!-- 戻るリンク -->
        <a href="AdminMenu.action" class="btn-back">戻る</a>

        <div class="caution-message">
        	<p>※マップ名に入力した名前が利用者画面に表示されます</p>
        </div>

        <!-- マップ投稿フォーム -->
        <form action="MapUpExe.action" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="mapName">マップ名:</label>
                <input type="text" id="mapName" name="mapName" placeholder="例：〇号館 〇階 ・ 〇〇棟 〇階 ・ キャンパス全体" required>
            </div>

            <div class="form-group">
                <label for="mapImage">マップ画像:</label>
                <input type="file" id="mapImage" name="mapImage" required>
            </div>

            <div class="btn-container">
                <button type="submit">アップロード</button>
            </div>
        </form>
    </div>

    <%@ include file="footer.jsp" %>
</body>
</html>
