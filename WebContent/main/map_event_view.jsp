<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>マップとイベント情報</title>
</head>
<body>

    <h2>マップとイベント情報</h2>

    <div class="container">
        <!-- 上半分：マップ情報 -->
        <div class="map-section">
            <h3>${map.mapName}</h3>
            <!-- サーブレット経由で画像を表示 -->
            <img src="${mapImageUrl}" alt="${map.mapName}">
        </div>

        <!-- 下半分：イベント情報 -->
        <div class="event-section">
            <h3>イベント情報</h3>
            <table>
                <thead>
                    <tr>
                        <th>イベント名</th>
                        <th>日付</th>
                        <th>時間</th>
                        <th>場所</th>
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
        </div>

        <!-- 戻るボタン -->
        <div class="btn-container">
            <a href="MapList.action">戻る</a>
        </div>
    </div>

</body>
</html>
