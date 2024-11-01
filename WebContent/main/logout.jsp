<!-- ログアウト.jsp -->

<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MICHISADA-ログアウト</title>
    <style>
	    body {
	        font-family: Arial, sans-serif;
	        margin: 0;
	        padding: 0;
	        background-color: #f0f0f0;
	    }

	    .content {
	        width: 100%;
	        max-width: 600px;
	        margin: 50px auto;
	        padding: 20px;
	        background-color: #fff;
	        border-radius: 10px;
	        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	    }

	    h2 {
	        text-align: center;
	        margin-bottom: 30px;
	        font-size: 24px;
	        color: #333;
	    }

	    input[type="text"],
	    input[type="password"] {
	        width: 100%;
	        padding: 10px;
	        margin: 10px 0;
	        border: 1px solid #ccc;
	        border-radius: 5px;
	        font-size: 16px;
	    }

	    button {
	        width: 100%;
	        padding: 12px;
	        margin: 10px 0;
	        background-color: #4CAF50;
	        border: none;
	        border-radius: 5px;
	        color: white;
	        font-size: 16px;
	        cursor: pointer;
	    }

	    button:hover {
	        background-color: #45a049;
	    }

	    .register-link {
	        text-align: center;
	        margin-top: 15px;
	    }

	    .register-link a {
	        color: #333;
	        text-decoration: none;
	    }

	    .register-link a:hover {
	        text-decoration: underline;
	    }
	</style>
</head>
<body>
    <%@ include file="header.jsp" %>

    <div class="content">
        <h2>ログアウトしました</h2>

        <div class="logout-link">
            <a href="Logout.action">ログインはこちら</a>
        </div>
    </div>

    <%@ include file="footer.jsp" %>
</body>
</html>
