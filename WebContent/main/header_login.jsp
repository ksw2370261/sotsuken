<!-- ログイン後のヘッダー -->

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        header {
        	color: #036635;
            padding: 1px; /* パディングを少し増やす */
            display: flex;
            justify-content: space-between; /* 左右に要素を配置 */
            align-items: center; /* 垂直方向に中央揃え */
            z-index: 1000; /* 上層に表示 */
            font-size: 23px;
        }

        .logout-btn {
        	color: #111111;
        	font-size: 18px;
            border: none;
            padding: 8px 16px; /* ボタンのパディングを調整 */
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
            font-weight: bold; /* IDを太字に */
            color: #111111;
        }
    </style>
</head>
<body>
    <header>
        <h1> Campus Map </h1>

        <span class="id">
            <%
                String ID = (String) session.getAttribute("ID");
                if (ID != null) {
                    out.print(ID);  // ユーザーIDのみを表示
                }
            %>
            <a href="logout.jsp" class="logout-btn">ログアウト</a>
        </span>
    </header>
</body>
</html>
