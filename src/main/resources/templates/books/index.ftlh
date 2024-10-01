<#import "base.ftlh" as layout>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Books</title>
<#--    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">-->
</head>

<body>

<@layout.layout>
    <h3 class="mb-2">Список прочтенных книг</h3>
        <#list books as book>
            <div class="card card-text mb-1">
                <#if book.author.getAuthorName()??>
                    <p>${book.id} | <a href="/books/${book.author.getAuthorName()?string}">${book.author.getAuthorName()?string}</a> | ${book.title} | <a href="/books/show/${book.id?c}">Подробнее</a></p>

                <#else>
                    <p>${book.id} | Автор неизвестен | ${book.title} | <a href="/books/show/${book.id?c}">Подробнее</a></p>
                </#if>
            </div>
        </#list>

<#--    </div>-->
<#--</div>-->
<div>
    <a class="btn btn-primary" href="books/new">Go to adding page</a>
</div>
</@layout.layout>
<#--<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>-->
<#--<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>-->
</body>
</html>