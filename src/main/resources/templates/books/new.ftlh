<#import "base.ftlh" as layout>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<@layout.layout>
    <h3>Adding the book</h3>
    <div class>
<form class="" method="POST" action="/books/create">
    <input class="form-control" value="Name of book" type="text" name="title">
    <input class="btn btn-primary mt-2" type="submit" >
</form>
    </div>
    <a href="/books" class="btn btn-outline-dark d-block mx-auto mt-2" type="button">Return to main page</a>

</@layout.layout>
</body>
</html>