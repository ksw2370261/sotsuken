<%@ page import="bean.Admin" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>管理者メニュー</title>
    <style>
        header {
            color: #036635;
            padding: 1px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            z-index: 1000;
            font-size: 23px;
        }

        .logout-btn {
            color: #111111;
            font-size: 18px;
            border: none;
            padding: 8px 16px;
            cursor: pointer;
            font-weight: bold;
            border-radius: 5px;
            text-decoration: none;
            transition: color 0.3s;
        }

        .logout-btn:hover {
            color: #036635;
        }

        .id {
            font-weight: bold;
            color: #111111;
        }
    </style>
</head>
<body>
    <header>
        <h1>Campus Map</h1>

        <span class="id">
            <%
                // セッションから admin オブジェクトを取得
                Admin admin = (Admin) session.getAttribute("admin");  // "admin"で取得
                if (admin != null) {
                    out.print(admin.getAdmin_Id());  // 管理者IDを表示
                } else {
                    out.print("ログインしていません。");  // もしログインしていない場合
                }
            %>
            <a href="logout.jsp" class="logout-btn">ログアウト</a>
        </span>
    </header>
</body>
</html>
