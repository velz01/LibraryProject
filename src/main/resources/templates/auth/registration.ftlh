<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>registration</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5">
    <h1 class="text-center mb-4"></h1>
    <form method="post" action="/registration">
        <div class="form-group">
            <label for="username" >Введите имя:</label>
            <input class="form-control" placeholder="Enter username" type="text" name="username" id="username">
        </div>
        <br/>

        <div class="form-group">
            <label for="password">Введите пароль:</label>
            <input class="form-control" type="password" placeholder="Enter password" name="password" id="password">
        </div>
        <input type="submit" value="Register" class="btn btn-primary">

    </form>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>