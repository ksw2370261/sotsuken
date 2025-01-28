<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="header_user.jsp" %>

<html>
<head>
    <title>CampusMap-口コミ投稿</title>
    <style>
        /* PCスタイル */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5fffa;
            overflow-x: hidden;
        }

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

        .form-container {
            max-width: 550px;
            margin: 20px auto;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            border: 1px solid #ddd;
        }

        label {
            font-size: 1.2rem;
            display: block;
            color: #036635;
        }

        textarea, input[type="text"] {
            width: 100%;
            padding: 10px;
            margin: 0 0 15px 0;
            font-size: 1rem;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-sizing: border-box;
        }

        button {
            padding: 10px 20px;
            background-color: #036635;
            color: white;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            font-size: 1rem;
            display: block;
            margin: 15px auto;
        }

        button:hover {
            background-color: #024f3d;
        }

        .button-container {
            text-align: center;
            margin-bottom: 15px;
        }

        /* スマホ・タブレット用スタイル */
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

            .form-container {
                width: 90%;
                padding: 15px;
            }

            textarea, input[type="text"] {
                font-size: 1.4rem;
                padding: 12px;
                margin: 0 0 15px 0;
            }

            button {
                padding: 12px 20px;
                font-size: 1.2rem;
            }
        }
    </style>
</head>
<body>
    <h2>口コミ投稿</h2>

    <div class="button-container">
        <!-- 戻るボタン -->
        <form action="Kuchikomi.action" method="get">
            <input type="hidden" name="schoolCd" value="<%= request.getParameter("schoolCd") %>">
            <button type="submit">戻る</button>
        </form>
    </div>

    <div class="form-container">
        <form action="KuchikomiPostExe.action" method="post">
            <input type="hidden" name="schoolCd" value="<%= request.getParameter("schoolCd") %>">

            <label for="kuchikomiContent">口コミ内容</label><br>
            <textarea id="kuchikomiContent" name="kuchikomiContent" rows="4" cols="50" required></textarea><br>

            <label for="kuchikomiName">投稿名</label><br>
            <input type="text" id="kuchikomiName" name="kuchikomiName" required><br>

            <button type="submit">投稿</button>
        </form>
    </div>
</body>
<%@ include file="footer_user.jsp" %>
</html>
