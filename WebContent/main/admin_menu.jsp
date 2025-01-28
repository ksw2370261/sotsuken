<!-- 管理者メニュー.jsp -->

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="header_login.jsp" %>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CampusMap-管理者メニュー</title>
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

        .menu-container {
            display: flex;
            justify-content: space-around;
            flex-wrap: wrap;
        }

        .menu-item1, .menu-item2, .menu-item3, .menu-item4, .menu-item5 {
	        background-color: #ffffff;
	        border: 1px solid #ccc;
	        border-radius: 8px;
	        padding: 20px;
	        margin: 10px;
	        width: 180px; /* ボックスの幅を250pxに設定 */
	        height: 80px; /* ボックスの高さを150pxに設定 */
	        text-align: center; /* テキストを中央に配置 */
	        transition: background-color 0.3s;
	        border: 1px solid #036635; /* 2pxの緑色の縁 */
	    }

	    .menu-item1 a, .menu-item2 a, .menu-item3 a, .menu-item4 a, .menu-item5 a {
	        text-decoration: none;
	        color: #036635;
	        font-weight: bold;
	        display: block; /* リンクをブロック要素にして中央に配置 */
	        height: 100%; /* リンクの高さをボックスに合わせる */
	        line-height: 85px; /* 高さに合わせてテキストを垂直方向に中央に配置 */
	    }

        .menu-item1:hover, .menu-item2:hover, .menu-item3:hover, .menu-item4:hover, .menu-item5:hover {
            background-color: #e0f7fa;
        }
    </style>
</head>

<body>
    <h2>管理者メニュー</h2>

    <div class="menu-container">
        <div class="menu-item1">
            <a href="MapList.action">マップ一覧</a>
        </div>

        <div class="menu-item2">
            <a href="MapUp.action">マップ投稿</a>
        </div>

        <div class="menu-item3">
            <a href="EventList.action">イベント一覧</a>
        </div>

        <div class="menu-item4">
            <a href="EventPost.action">イベント投稿</a>
        </div>

        <div class="menu-item5">
        	<a href="KuchikomiManage.action">口コミ管理</a>
        </div>
    </div>
</body>

<%@ include file="footer.jsp" %>

