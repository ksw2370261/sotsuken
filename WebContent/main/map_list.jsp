<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.MapImage" %>
<%@ include file="header_login.jsp" %>

<head>
    <title>CampusMap-マップ一覧</title>
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
            margin: 0px 0px 25px 320px;
        }

        .btn-back:hover {
            background-color: #3cb371;
            color: #ffffff;
        }

        .container {
            max-width: 600px;
            margin: auto auto 100px auto;
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            max-height: 600px;
            overflow-y: auto;
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
            position: relative;
        }

        .delete-btn {
            position: absolute;
            right: 25px;
            top: 50%;
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

        .delete-btn:hover {
            background-color: #ff4500;
        }
    </style>
</head>

<body>
    <h2>マップ一覧</h2>

    <a href="AdminMenu.action" class="btn-back">戻る</a>

    <div class="container">
        <%
            List<MapImage> mapImages = (List<MapImage>) request.getAttribute("mapImages");
            if (mapImages != null && !mapImages.isEmpty()) {
        %>
            <table>
                <thead>
                    <tr>
                        <th>マップ名</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (MapImage mapImage : mapImages) {
                    %>
                        <tr>
                            <td>
                                <span><%= mapImage.getMapName() %></span>
                                <button class="delete-btn" onclick="deleteMap(<%= mapImage.getImageId() %>)">削除</button>
                            </td>
                        </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        <%
            } else {
        %>
            <p>登録されたマップはありません。</p>
        <%
            }
        %>
    </div>

    <script>
        function deleteMap(imageId) {
            if (confirm('このマップを削除しますか？')) {
                window.location.href = 'MapDelete.action?imageId=' + imageId;
            }
        }
    </script>

    <%@ include file="footer.jsp" %>
</body>
</html>
