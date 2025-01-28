<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.School" %>
<%@ include file="header_user.jsp" %>

<html>
<head>
    <title>CampusMap-学校一覧</title>
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

        /* 検索フォーム */
        .search-form {
            text-align: center;
            margin-top: 15px;
            display: flex;
            justify-content: center;
            gap: 10px;
        }

        .search-input {
            font-size: 1.2rem;
            padding: 8px;
            width: 250px;
            border-radius: 4px;
            border: 1px solid #ddd;
        }

        .search-button, .reset-button {
            font-size: 1.2rem;
            padding: 5px 16px;
            background-color: #036635;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .search-button:hover, .reset-button:hover {
            background-color: #024f3d;
        }

        /* 学校一覧 */
        ul {
            list-style-type: none;
            padding: 0;
            margin: 0 auto;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        li {
            width: 45%;
            max-width: 700px;
            background-color: #ffffff;
            margin: 10px;
            padding: 20px;
            border-radius: 8px;
            border: 1px solid #ddd;
            display: flex;
            align-items: center;
            justify-content: space-between;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        li span {
            font-size: 1.5rem;
            margin-right: 20px;
            font-weight: bold;
        }

        .button-container {
            display: flex;
        }

        .button-container form {
            margin-left: 15px;
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
                overflow-x: hidden;
            }

            h2 {
                width: 80%;
                padding: 1rem;
                font-size: 2.0rem;
            }

            /* 検索フォーム */
        .search-form {
            text-align: center;
            margin-top: 15px;
            display: flex;
            justify-content: center;
            gap: 10px;
        }

        .search-input {
            font-size: 1.2rem;
            padding: 8px;
            width: 144px;
            border-radius: 4px;
            border: 1px solid #ddd;
        }

        .search-button, .reset-button {
            font-size: 1.2rem;
            padding: 5px 8px;
            background-color: #036635;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .search-button:hover, .reset-button:hover {
            background-color: #024f3d;
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
                flex-direction: column;
                align-items: center;
            }

            li span {
                font-size: 1.7rem;
                margin-right: 0;
                font-weight: bold;
            }

            .button-container {
                width: 100%;
                justify-content: flex-start;
                margin-top: 4px;
                gap: 5px;
            }

            .button-container form {
                width: 100%;
                margin-left: 0;
                margin-top: 5px;
            }

            button {
            	white-space: nowrap; /* ここでも改行を防ぐ */
                padding: 12px 20px;
                font-size: 1.2rem;
            }
        }
    </style>
</head>
<body>
    <h2>学校一覧</h2>

    <!-- 検索フォーム -->
    <form action="SchoolList.action" method="get" class="search-form">
        <input type="text" name="schoolName" placeholder="学校名で検索" class="search-input">
        <button type="submit" class="search-button">検索</button>
        <!-- 解除ボタン -->
        <button type="reset" class="reset-button" onclick="window.location.href='SchoolListStartAction';">解除</button>
    </form>

    <ul>
        <%
            // "schools" 属性から学校リストを取得
            List<School> schools = (List<School>) request.getAttribute("schools");
            if (schools != null && !schools.isEmpty()) {
                for (School school : schools) {
        %>
                    <li>
                        <span><%= school.getSchoolName() %></span>

                        <div class="button-container">
                            <form action="MapEventView.action" method="get" style="display: inline;">
                                <input type="hidden" name="schoolCd" value="<%= school.getSchoolCd() %>">
                                <button type="submit" class="map-button">マップ</button>
                            </form>

                            <form action="EventDetail.action" method="get" style="display: inline;">
                                <input type="hidden" name="schoolCd" value="<%= school.getSchoolCd() %>">
                                <button type="submit" class="event-button">イベント</button>
                            </form>

                            <form action="Kuchikomi.action" method="get" style="display: inline;">
                                <input type="hidden" name="schoolCd" value="<%= school.getSchoolCd() %>">
                                <button type="submit" class="review-button">口コミ</button>
                            </form>
                        </div>
                    </li>
        <%
                }
            } else {
        %>
            <li>学校情報が見つかりません。</li>
        <%
            }
        %>
    </ul>
</body>
<%@ include file="footer_user.jsp" %>
</html>
