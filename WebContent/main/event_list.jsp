<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>CampusMap-イベント一覧</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/css/bootstrap.min.css">
    <style>
        body {
            display: flex; /* Use flexbox for the layout */
            flex-direction: column; /* Stack elements vertically */
            min-height: 100vh; /* Minimum height to fill the viewport */
            margin: 0; /* Remove default body margin */
        }
        .container {
            flex: 1; /* Allow the container to grow and take available space */
            padding: 15px; /* Add some padding for aesthetics */
        }
        /* Style for the box containing the table */
        .box-container {
            border: 2px solid black; /* Clear, visible border for the box */
            padding: 10px; /* Inner padding around the content */
            display: block; /* Change to block to control width */
            width: 100%; /* Set width to 100% to fit screen */
            max-width: 1000px; /* Maximum width */
            margin: 0 auto; /* Center the box on the page */
            background-color: #fff; /* White background for the box */
            border-radius: 8px; /* Rounded corners */
        }
        .event-table {
            width: 100%; /* Table spans full width of the box */
            margin: 0; /* Remove extra margins */
        }
        .event-table td {
            padding: 8px; /* Padding for cells */
            text-align: center; /* Center text in each cell */
            vertical-align: middle; /* Align text vertically */
        }
        .event-table .btn-cell {
            text-align: right; /* Align buttons to the right */
            white-space: nowrap; /* Prevent buttons from wrapping */
        }
        .btn-lg {
            width: auto; /* Set to auto for original button size */
        }
        footer {
            margin-top: auto; /* Push footer to the bottom */
        }
    </style>
</head>
<body>
    <%@ include file="header.jsp" %>

    <div class="container mt-3">
        <div class="text-center mb-3"> <!-- Center the button -->
            <button type="button" class="btn btn-primary btn-lg">戻る</button> <!-- Large size for button -->
        </div>
        <!-- Boxed container for the table -->
        <div class="box-container">
            <table class="table table-borderless mb-0 event-table">
                <thead>
                    <tr>
                        <th>日付</th>
                        <th>時間</th>
                        <th>場所</th>
                        <th>イベント名</th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="event" items="${eventList}">
                        <tr>
                            <td>${event.date}</td>
                            <td>${event.time}</td>
                            <td>${event.location}</td>
                            <td>${event.name}</td>
                              <td class="btn-cell">
                        <button type="button" class="btn btn-outline-secondary btn-sm">詳細</button>
                        <button type="button" class="btn btn-outline-secondary btn-sm ms-1">削除</button>
                    </td>

                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <%@ include file="footer.jsp" %>
</body>
</html>
