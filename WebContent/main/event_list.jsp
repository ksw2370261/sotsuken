<!-- event_list.jsp -->
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.Event" %>
<%@ include file="header_login.jsp" %>

<head>
    <title>CampusMap-イベント一覧</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
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
            margin: 0px 0px 25px 160px;
        }

        .btn-back:hover {
            background-color: #3cb371;
            color: #ffffff;
        }

        .container {
            max-width: 900px;
            margin: auto auto 100px auto;
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            overflow-y: auto; /* Enable scrolling */
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;

        }

        th, td {
            padding: 10px;
            text-align: center;
            border: 1px solid #ddd;
        }

        th {
            background-color: #036635;
            color: white;
        }

        td {
            background-color: #ffffff;
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
            color: #036635;
        }

        .event-info {
            display: flex; /* Arrange horizontally */
            justify-content: flex-start; /* Left align */
            gap: 20px; /* Space between items */
            margin-bottom: 10px;
        }

        .event-info div {
            margin-bottom: 0;
        }

        .event-content {
            display: inline;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
            max-width: 300px;
        }

        .full-content {
            display: none;
        }

        .toggle-link {
            color: #036635;
            cursor: pointer;
            font-weight: bold;
            text-decoration: underline;
        }

        .toggle-link:hover {
            color: #3cb371;
        }

        .event-content-container {
            display: flex;
            flex-direction: column;
            gap: 10px;
        }

        .btn-delete {
            transform: translateY(-50%);
            padding: 5px 10px;
            background-color: #ff6347;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
            transition: background-color 0.3s;
        }

        .btn-delete:hover {
            background-color: #ff4500;
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

        function deleteEvent(eventCd) {
            if (confirm('このイベントを削除しますか？')) {
                window.location.href = 'EventDelete.action?eventCd=' + eventCd;
            }
        }
    </script>
</head>

<body>
    <h2>イベント一覧</h2>

    <!-- Back Button -->
    <a href="AdminMenu.action" class="btn-back">戻る</a>

    <div class="container">
        <%
            List<Event> events = (List<Event>) request.getAttribute("events");
            if (events != null && !events.isEmpty()) {
        %>
            <div class="event-content-container">
                <%
                    for (Event event : events) {
                        String content = event.getEventContent();
                        boolean isLongContent = content.length() > 50; // Maximum characters to display
                        String shortContent = isLongContent ? content.substring(0, 50) + "..." : content;
                %>
                    <div class="event-row">
                        <h3><%= event.getEventName() %></h3>
                        <div class="event-info">
                            <div><strong>日付:</strong> <%= event.getEventDate() %></div>
                            <div><strong>時間:</strong> <%= event.getEventTime() %></div>
                            <div><strong>場所:</strong> <%= event.getEventLocation() %></div>
                        </div>
                        <div>
                            <span id="short-content-<%= event.getEventCd() %>" class="event-content"><%= shortContent %></span>
                            <span id="full-content-<%= event.getEventCd() %>" class="full-content"><%= content %></span>
                            <% if (isLongContent) { %>
                                <span id="toggle-link-<%= event.getEventCd() %>" class="toggle-link" onclick="toggleContent(<%= event.getEventCd() %>)">全文表示</span>
                            <% } %>
                        </div>
                        <div>
                        	<br>
                        	<br>
                            <button onclick="deleteEvent(<%= event.getEventCd() %>)" class="btn-delete">削除</button>
                        </div>
                    </div>
                <%
                    }
                %>
            </div>
        <%
            } else {
        %>
            <p>登録されたイベントはありません。</p>
        <%
            }
        %>
    </div>

<%@ include file="footer.jsp" %>
</body>
</html>