<#import "base.ftlh" as layout>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<@layout.layout>
<div class="card">
    <#if book.author.getAuthorName()??>
        <p class="card-header card-title">${book.id} | ${book.author.getAuthorName()} | ${book.title}</p>
        <div class=" card-body card-text">
            ${book.description}
        </div>



    </#if>

</div>
    <a class="btn btn-primary mt-3" href="/books/edit/${book.id?c}" type="button">Edit</a>
<div>
    <form  action="/books/delete/${book.id?c}" method=post>
        <input  type="hidden" name="_method" value="delete"/>
        <input class="btn btn-dark mt-1" type="submit" value="Delete">
    </form>
</div>
    <a href="/books" class="btn btn-outline-dark d-block mx-auto mt-2" type="button">Return to main page</a>

</@layout.layout>

</body>
</html>