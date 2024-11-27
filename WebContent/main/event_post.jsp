<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="header_login.jsp" %>

<head>
    <meta charset="UTF-8">
    <title>CampusMap-イベント投稿画面</title>
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
            width: 200px;
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

        .form-group input[type="date"], .form-group input[type="time"] {
            width: 48%;
            margin-right: 4%;
        }

        .form-group input[type="text"] {
            width: 100%;
        }

        .form-group textarea {
            height: 150px;
            resize: vertical;
        }

        .btn-container {
            text-align: center;
        }

        .btn-container input[type="submit"] {
            background-color: #036635;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .btn-container input[type="submit"]:hover {
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
        /* CSSはそのまま使用 */
    </style>
</head>

<body>
    <h2>イベント投稿画面</h2>
    <!-- メインコンテンツ -->
    <div class="container">
        <!-- イベント投稿フォーム -->
        <form action="EventPostExe.action" method="post">
            <!-- 戻るリンク -->
            <a href="AdminMenu.action" class="btn-back">戻る</a>

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
                <label for="event_content">イベント内容:</label>
                <textarea id="event_content" name="event_content" rows="4"></textarea>
            </div>

            <!-- 送信ボタン -->
            <div class="btn-container">
                <input type="submit" value="投稿">
            </div>
        </form>
    </div>

<%@ include file="footer.jsp" %>

