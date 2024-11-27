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
            margin-left: 20px;
        }

        .logout-btn {
            color: #ffffff;
            background-color: #036635;
            font-size: 18px;
            border: none;
            padding: 8px 16px;
            cursor: pointer;
            font-weight: bold;
            border-radius: 5px;
            transition: background-color 0.3s;
            margin-right: 50px;
        }

        .logout-btn:hover {
            background-color: #3cb371;
        }

        .id {
            color: #111111;
            display: flex;
            align-items: center;
            gap: 10px;
        }
    </style>
</head>
<body>
    <header>
        <h1>Campus Map</h1>

        <span class="id">
            <%
                // セッションから admin オブジェクトを取得
                Admin admin = (Admin) session.getAttribute("admin");
                if (admin != null) {
                    out.print(admin.getAdmin_Id());  // 管理者IDを表示
                } else {
                    out.print("ログインしていません。");  // もしログインしていない場合
                }
            %>
            <form action="logout.jsp" method="post" style="display:inline;">
                <button type="submit" class="logout-btn">ログアウト</button>
            </form>
        </span>
    </header>
</body>
</html>

