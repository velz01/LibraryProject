<#import "base.ftlh" as layout>
<@layout.layout>
<h3>Edit</h3>
<form action="/books/update/${book.id?c}" method="post">
    <input type="hidden" name="_method" value="put"/>
    <input class="form-control" type="text" name="title" value="${book.title}">
    <input type="submit" class="btn btn-primary mt-2" value="update">
</form>
</@layout.layout>