<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header_user.jsp" %>

<html>
<head>
    <title>イベント詳細</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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

        .btn-container {
            text-align: center;
            margin-top: 20px;
            margin-bottom: 20px;
        }

        .btn-container a {
            padding: 10px 20px;
            background-color: #036635;
            color: white;
            text-decoration: none;
            border-radius: 8px;
            font-size: 1.2rem;
            display: inline-block;
        }

        .btn-container a:hover {
            background-color: #024f3d;
        }

        .container {
            max-width: 900px;
            margin: auto auto 50px auto;
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }

        .event-row {
            margin-bottom: 15px;
            padding: 15px;
            border: 1px solid #036635;
            border-radius: 10px;
            background-color: #ffffff;
        }

        .event-row h3 {
            margin-top: 0;
            margin-bottom: 10px;
            color: #036635;
            word-wrap: break-word;
        }

        .event-info {
            display: flex;
            flex-wrap: wrap; /* コンテンツがはみ出ないよう折り返しを有効化 */
            margin-bottom: 10px;
        }

        .event-info div {
            flex: 1; /* 均等に分割 */
            min-width: 150px; /* スマホでも見やすくするための最小幅 */
            word-wrap: break-word;
        }

        .event-content {
            display: inline-block;
            white-space: pre-wrap; /* 折り返しを有効化 */
            overflow-wrap: break-word;
            word-wrap: break-word;
        }

        .toggle-link {
            color: #036635;
            cursor: pointer;
            font-weight: bold;
            text-decoration: underline;
            margin-left: 10px;
        }

        .toggle-link:hover {
            color: #3cb371;
        }

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

            .btn-container a {
                font-size: 1.1rem;
                padding: 8px 15px;
            }

            .container {
                padding: 15px;
            }

            .event-info {
            	font-size: 1.2rem;
            }

            .event-info div {
                flex: 100%; /* モバイルでは1行ずつ表示 */
                min-width: unset; /* 最小幅の制限を解除 */
            }

            .event-row {
                padding: 10px;
            }

            .event-row h3 {
                font-size: 1.4rem;
            }

            .event-content {
            	font-size: 1.2rem;
            }
        }
    </style>
    <script>
        function toggleContent(eventId) {
            const shortContent = document.getElementById("short-content-" + eventId);
            const fullContent = document.getElementById("full-content-" + eventId);
            const link = document.getElementById("toggle-link-" + eventId);

            if (fullContent.style.display === "none") {
                fullContent.style.display = "inline";
                shortContent.style.display = "none";
                link.innerText = "閉じる";
            } else {
                fullContent.style.display = "none";
                shortContent.style.display = "inline";
                link.innerText = "全文表示";
            }
        }
    </script>
</head>
<body>
    <h2>イベント詳細</h2>

    <!-- 戻るボタン -->
    <div class="btn-container">
        <a href="SchoolList.action">戻る</a>
    </div>

    <div class="container">
        <c:if test="${not empty events}">
            <c:forEach var="event" items="${events}">
                <div class="event-row">
                    <h3>${event.eventName}</h3>
                    <div class="event-info">
                        <div><strong>日付:</strong> ${event.eventDate}</div>
                        <div><strong>時間:</strong> ${event.eventTime}</div>
                        <div><strong>場所:</strong> ${event.eventLocation}</div>
                    </div>
                    <div>
                        <span id="short-content-${event.eventCd}" class="event-content">${event.shortContent}</span>
                        <span id="full-content-${event.eventCd}" class="event-content" style="display: none;">${event.eventContent}</span>
                        <c:if test="${event.eventContent.length() > 50}">
                            <span id="toggle-link-${event.eventCd}" class="toggle-link" onclick="toggleContent(${event.eventCd})">全文表示</span>
                        </c:if>
                    </div>
                </div>
            </c:forEach>
        </c:if>

        <c:if test="${empty events}">
            <p>イベント情報はありません。</p>
        </c:if>
    </div>

<%@ include file="footer_user.jsp" %>
</body>
</html>
