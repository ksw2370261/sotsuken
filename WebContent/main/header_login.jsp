<!-- ログイン後のヘッダー -->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>共通ヘッダー</title>
    <style>
		header {
	        background-color: #d3d3d3; /* ヘッダーの背景色 */
	        padding: 0.05px;
            display: flex;
            justify-content: space-between; /* 左右に要素を配置 */
            align-items: center; /* 垂直方向に中央揃え */
            z-index: 1000; /* 上層に表示 */
        }

        .logout-btn {
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            font-weight: bold;
            border-radius: 5px;
            text-decoration: none;
        }
    </style>
</head>
<body>
    <header>
    	<h1>　MICHISADA ミチサダ</h1>

    	<a href="logout.jsp" class="logout-btn">ログアウト</a>
    </header>
