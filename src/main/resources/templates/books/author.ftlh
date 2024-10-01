<#import "base.ftlh" as layout>
<@layout.layout>
    <#list books as book>
        <div class="card card-text mb-1">
            <#if book.author.getAuthorName()??>
                <p>${book.id} | <a href="/books/${book.author.getAuthorName()?string}">${book.author.getAuthorName()?string}</a> | ${book.title} | <a href="/books/show/${book.id?c}">Подробнее</a></p>

            <#else>
                <p>${book.id} | Автор неизвестен | ${book.title} | <a href="/books/show/${book.id?c}">Подробнее</a></p>
            </#if>
        </div>
    </#list>
</@layout.layout>