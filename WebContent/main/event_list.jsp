<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>MICHISADA-イベント一覧</title>　　　
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/css/bootstrap.min.css">
    <style>
        body {
            display: flex; /* Use flexbox for the layout */
            flex-direction: column; /* Stack elements vertically */
            min-height: 100vh; /* Minimum height to fill the viewport */
        }
        .container {
            flex: 1; /* Allow the container to grow and take available space */
        }
        /* Style for the box containing the table */
        .box-container {
            border: 2px solid black; /* Clear, visible border for the box */
            padding: 10px; /* Inner padding around the content */
            display: block; /* Change to block to control width */
            width: 100%; /* Set width to 100% to fit screen */
            max-width: 1000px; /* Increased maximum width to 1000px */
            margin: 0 auto; /* Center the box on the page */
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
    </style>
</head>
<body>
    <%@ include file="header.jsp" %>

    <div class="container mt-3">
        <div class="text-center mb-3"> <!-- Center the button -->
            <button type="button" class="btn btn-primary btn-lg">戻る</button> <!-- Added btn-lg for larger size -->
        </div>
        <!-- Boxed container for the table -->
        <div class="box-container">
            <table class="table table-borderless mb-0 event-table">
                <tr>
                    <td>日付</td>
                    <td>時間</td>
                    <td>場所</td>
                    <td>イベント名</td>
                    <td class="btn-cell">
                        <button type="button" class="btn btn-outline-secondary btn-sm">詳細</button>
                        <button type="button" class="btn btn-outline-secondary btn-sm ms-1">削除</button>
                    </td>
                </tr>
            </table>
        </div>
    </div>

    <%@ include file="footer.jsp" %>
</body>
</html>
