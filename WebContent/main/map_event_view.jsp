<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header_user.jsp" %>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CampusMap-マップ</title>
    <script>
        function updateMapImage() {
            var selectedMap = document.getElementById("mapSelector").value;
            var mapImageElement = document.querySelector(".map-section img");
            mapImageElement.src = "http://localhost:8080/MICHISADA/main/mapImage?schoolCd=${schoolCd}&mapName=" + encodeURIComponent(selectedMap);
        }
    </script>
    <style>
        /* 基本的なフォントや背景色 */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5fffa;
            font-size: 1.3rem;
        }

        /* タイトルのスタイル */
        h2 {
            text-align: center;
            margin: 20px auto;
            padding: 1.5rem 4rem;
            width: 80%;
            max-width: 400px;
            color: #036635;
            border-radius: 100vh;
            background-color: #ffffff;
            border: 2px solid #036635;
            font-size: 3.0rem;
        }

        /* 戻るボタンを配置するためのコンテナ */
        .btn-container {
            margin-top: 10px;  /* h2とマップ選択の間に少し余白を追加 */
            text-align: center;  /* 中央寄せ */
        }

        .btn-container a {
            padding: 10px 20px;
            background-color: #036635;
            color: white;
            text-decoration: none;
            border-radius: 8px;
            margin: 20px auto; /* 自動的に左右を中央に配置 */
        }

        .btn-container a:hover {
            background-color: #024f3d;
        }

        /* マップ選択とマップ画像セクション */
        .container {
            padding: 20px;
        }

        .map-selection {
            margin-bottom: 20px;
            text-align: center; /* ドロップダウンリストを中央に寄せる */
        }

        .map-selection select {
            width: 50%; /* PC表示時の幅を50%に設定 */
            padding: 10px;
            font-size: 1.5rem;
            border: 1px solid #ccc;
            border-radius: 8px;
        }

        .map-section {
            text-align: center;
        }

        .map-section img {
            max-width: 65%;
            height: auto;
            border: 1px solid #ddd;
            border-radius: 8px;
        }

        /* イベント情報セクション */
        .event-section {
            margin-top: 30px;
            max-width: 800px; /* テーブル全体の最大幅を制限 */
            margin-left: auto;
            margin-right: auto;
        }

        .event-section h3 {
            text-align: center; /* 文字を中央に寄せる */
            border-top: 2px solid #036635;  /* 上部に緑色の線を追加 */
            padding-top: 30px;  /* 線と文字の間に余白を追加 */
        }

        .event-section table {
            width: 90%; /* テーブルの幅を90%に設定 */
            margin: 0 auto;
            border-collapse: collapse;
        }

        .event-section th, .event-section td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: center;
            word-wrap: break-word; /* 長い単語を折り返す */
            white-space: pre-wrap; /* テキストを折り返す */
            overflow-wrap: break-word; /* すべてのブラウザでの折り返し */
        }

        .event-section th {
            background-color: #f2f2f2;
        }

        /* スマホ用のレスポンシブデザイン */
        body {
            padding: 10px;
            font-size: 1.4rem;
        }

        h2 {
            width: 80%;
            padding: 1rem;
            font-size: 2.0rem;
        }

        /* タブレット用 */
        @media (max-width: 768px) {
            h2 {
                width: 80%;
                font-size: 2.0rem;
            }

            .map-section img {
                max-width: 100%;
                height: auto;
                border: 1px solid #ddd;
                border-radius: 8px;
            }

            .event-section table {
                width: 100%;
                border-collapse: collapse;
                font-size: 0.95rem; /* フォントサイズを小さく調整 */
            }

            .event-section th, .event-section td {
                padding: 8px; /* パディングを小さくしてコンテンツの余白を減少 */
            }

            .map-selection select {
                width: 100%; /* タブレットとスマホではフル幅に設定 */
                padding: 10px;
                font-size: 1.5rem;
                border: 1px solid #ccc;
                border-radius: 8px;
            }

            /* スマホ用の戻るボタン調整 */
            .btn-container {
                text-align: center; /* ボタンを中央寄せ */
            }

            .btn-container a {
                font-size: 1.1rem;
                padding: 8px 15px;
            }
        }
    </style>
</head>
<body>

    <h2>マップ</h2>

    <!-- 戻るボタンの配置 -->
    <div class="btn-container">
        <a href="SchoolList.action">戻る</a>
    </div>

    <div class="container">
        <div class="map-selection">
            <label for="mapSelector">マップを選択</label>
            <br>
            <select id="mapSelector" onchange="updateMapImage()">
                <c:forEach var="map" items="${maps}">
                    <option value="${map.mapName}">${map.mapName}</option>
                </c:forEach>
            </select>
        </div>

        <div class="map-section">
            <img src="http://localhost:8080/MICHISADA/main/mapImage?schoolCd=${schoolCd}&mapName=${map.mapName}" alt="${map.mapName}">
        </div>

        <div class="event-section">
            <h3>イベント情報</h3>

            <c:if test="${not empty events}">
                <table>
                    <thead>
                        <tr>
                            <th style="width: 39%;">イベント</th>
                            <th style="width: 13%;">日付</th>
                            <th style="width: 13%;">時間</th>
                            <th style="width: 35%;">場所</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="event" items="${events}">
                            <tr>
                                <td>${event.eventName}</td>
                                <td>${event.eventDate}</td>
                                <td>${event.eventTime}</td>
                                <td>${event.eventLocation}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>

            <c:if test="${empty events}">
                <p>イベント情報はありません。</p>
            </c:if>
        </div>

    </div>
</body>
<%@ include file="footer_user.jsp" %>
</html>
