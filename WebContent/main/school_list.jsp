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
            background-color: #ffffff;
            color: #036635;
            font-weight: bold;
            padding: 10px 20px;
            margin: 10px;
            border-radius: 8px;
            border: 1px solid #036635;
            width: 200px;
            text-align: center;
            transition: background-color 0.3s;

            /* テキストが10文字を超える場合に省略するスタイル */
            white-space: nowrap;          /* 改行させない */
            overflow: hidden;             /* 溢れたテキストを隠す */
            text-overflow: ellipsis;      /* 省略記号(...)を表示 */
        }

        li:hover {
            background-color: #e0f7fa;
        }
    </style>
</head>
<body>
    <h1>School Names</h1>
    <div class="list-container">
        <ul>
            <%
                // Actionクラスから渡されたschool_nameリストを取得し、1件ずつ表示
                List<String> schoolNames = (List<String>) request.getAttribute("schoolNames");
                if (schoolNames != null) {
                    for (String name : schoolNames) {
            %>
                        <li><%= name %></li>
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
