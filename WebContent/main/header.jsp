<!-- ログイン前のヘッダー -->

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
		header {
        	color: #800000;
            padding: 10px; /* パディングを少し増やす */
            display: flex;
            justify-content: space-between; /* 左右に要素を配置 */
            align-items: center; /* 垂直方向に中央揃え */
            z-index: 1000; /* 上層に表示 */
            font-size: 23px;
        }
    </style>
</head>
<body>
    <header>
    	<h1> Campus Map </h1>
    </header>
