<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.Kuchikomi" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ include file="header_user.jsp" %>

<html>
<head>
    <title>CampusMap-口コミ一覧</title>
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

        .button-container {
            display: flex;
            justify-content: center;
            margin-bottom: 15px;
            margin-top: 15px;
            gap: 10px;
        }

        .button-container form {
            margin: 0;
        }

        ul {
            list-style-type: none;
            padding: 0;
            margin: 0 auto;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        li {
            width: 50%;
            max-width: 700px;
            background-color: #ffffff;
            margin: 10px;
            padding: 20px;
            border-radius: 8px;
            border: 1px solid #ddd;
            display: flex;
            flex-direction: column;
            align-items: flex-start;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        .kuchikomiContent {
            font-size: 1.2rem;
            margin-bottom: 10px;
            font-weight: normal;
        }

        .kuchikomiName {
            font-size: 1rem;
            font-weight: bold;
            margin-bottom: 5px;
            color: #036635;
        }

        .kuchikomiTime {
            font-size: 0.9rem;
            color: #666;
        }

        button {
            padding: 10px 20px;
            background-color: #036635;
            color: white;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            font-size: 1rem;
        }

        button:hover {
            background-color: #024f3d;
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

            .button-container {
                flex-direction: row;
                flex-wrap: wrap;
                justify-content: center;
                gap: 10px;
            }

            ul {
                padding: 0 10px;
            }

            li {
                width: 95%;
                max-width: none;
                margin: 8px 0;
                padding: 15px;
                font-size: 1.4rem;
                box-shadow: none;
            }

            .kuchikomiContent {
                font-size: 1.2rem;
            }

            .kuchikomiName {
                font-size: 1.2rem;
            }

            .kuchikomiNameTag {
            	font-size: 1.2rem;
            }

            .kuchikomiTime {
                font-size: 1rem;
            }

            button {
                padding: 12px 20px;
                font-size: 1.2rem;
            }
        }
    </style>
</head>
<body>
    <h2>口コミ一覧</h2>
    <div class="button-container">
        <!-- 戻るボタン -->
        <form action="SchoolList.action">
            <button type="submit">戻る</button>
        </form>

        <!-- 口コミ投稿ボタン -->
        <form action="KuchikomiPost.action" method="get">
            <input type="hidden" name="schoolCd" value="<%= request.getParameter("schoolCd") %>">
            <button type="submit">口コミ投稿</button>
        </form>
    </div>

    <ul>
        <%
            // リクエスト属性から口コミリストを取得
            List<Kuchikomi> kuchikomiList = (List<Kuchikomi>) request.getAttribute("kuchikomiList");
            if (kuchikomiList != null && !kuchikomiList.isEmpty()) {
                // 日時フォーマットを指定 (秒数は省略)
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
                for (Kuchikomi kuchikomi : kuchikomiList) {
                    // 口コミ時間をフォーマット
                    String formattedTime = sdf.format(kuchikomi.getKuchikomiTime());
        %>
                    <li>
                        <!-- 口コミ内容 -->
                        <span class="kuchikomiContent"><%= kuchikomi.getKuchikomiContent() %></span>
                        <!-- 口コミ名 -->
                        <span class="kuchikomiNameTag">投稿者：<span class="kuchikomiName"><%= kuchikomi.getKuchikomiName() %></span></span>
                        <!-- 口コミ時間 (フォーマット後) -->
                        <span class="kuchikomiTime"><%= formattedTime %></span>
                    </li>
        <%
                }
            } else {
        %>
            <li>口コミが見つかりません。</li>
        <%
            }
        %>
    </ul>
</body>
<%@ include file="footer_user.jsp" %>
</html>
