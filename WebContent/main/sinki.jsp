<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>新規登録</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/css/bootstrap.min.css">
    <style>
        body {
            display: flex;
            flex-direction: column;
            min-height: 100vh;
            background-color: #fff; /* Set entire background to white */
        }
        main {
            flex: 1;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .card {
            width: 500px; /* Adjusted width for smaller box */
            padding: 40px;
            border-radius: 10px;
            background-color: #fff; /* White background for the box */
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1); /* Shadow for better visual separation */
        }
        .card-header {
            text-align: center;
            font-size: 28px; /* Larger font size */
            font-weight: bold;
            margin-bottom: 20px;
        }
        .form-group {
            margin-bottom: 20px;
        }
        .form-group label {
            font-weight: bold;
        }
        .form-control {
            font-size: 1rem; /* Smaller font size for the text */
            padding: 8px; /* Narrower padding for height reduction */
            width: 100%; /* Narrower width for input fields */
            margin: 0 auto; /* Center-align the input fields */
        }
        .button-group {
            display: flex;
            justify-content: space-between;
            margin-top: 30px;
        }
        .button-group button {
            width: 40%; /* Adjusted width for buttons to be narrower */
        }
    </style>
</head>
<body>
    <!-- Include header -->
    <jsp:include page="header.jsp" />

    <!-- Main content with the registration form -->
    <main>
        <div class="card">
            <div class="card-header">新規登録</div>
            <div class="card-body">
                <form action="RegisterExecute.action" method="post">
                    <div class="form-group row">
                        <label for="id" class="col-sm-3 col-form-label text-right">ID</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="id" name="id" maxlength="20" required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="password" class="col-sm-3 col-form-label text-right">パスワード</label>
                        <div class="col-sm-9">
                            <input type="password" class="form-control" id="password" name="password" maxlength="20" required>
                        </div>
                    </div>
                    <div class="button-group">
                        <button type="submit" class="btn btn-primary">ログイン</button>
                        <button type="button" class="btn btn-secondary">新規登録</button>
                    </div>
                </form>
            </div>
        </div>
    </main>

    <!-- Include footer -->
    <jsp:include page="footer.jsp" />
</body>
</html>
