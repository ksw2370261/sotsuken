<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>School Names</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f5fffa;
        }

        h1 {
            text-align: center;
            margin: 20px auto;
            padding: 1rem 3rem;
            width: 180px;
            color: #036635;
            border-radius: 100vh;
            background-color: #ffffff;
            border: 2px solid #036635;
        }

        .list-container {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            margin-top: 20px;
        }

        ul {
            list-style-type: none;
            padding: 0;
            margin: 0;
            text-align: center;
        }

        li {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: #ffffff;
            color: #036635;
            font-weight: bold;
            padding: 10px 20px;
            margin: 10px;
            border-radius: 8px;
            border: 1px solid #036635;
            width: 250px;
            text-align: center;
            transition: background-color 0.3s;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
        }

        li:hover {
            background-color: #e0f7fa;
        }

        .review-button {
            background-color: #036635;
            color: white;
            padding: 5px 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 0.9rem;
            transition: background-color 0.3s;
        }

        .review-button:hover {
            background-color: #025c2f;
        }
    </style>
</head>
<body>
    <h1>School Names</h1>
    <div class="list-container">
        <ul>
            <%
                // Actionクラスまたはサーブレットから渡されたschool_nameリストを取得し、1件ずつ表示
                List<String> schoolNames = (List<String>) request.getAttribute("schoolNames");
                if (schoolNames != null && !schoolNames.isEmpty()) {
                    for (String name : schoolNames) {
            %>
                        <li>
                            <span><%= name %></span>
                            <form action="Kuchikomi.action" method="get" style="margin: 0;">
                                <button type="submit" class="review-button">口コミ</button>
                            </form>
                        </li>
            <%
                    }
                } else {
            %>
                <li>No school names found.</li>
            <%
                }
            %>
        </ul>
    </div>
</body>
</html>
