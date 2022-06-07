<! -- Aqui estão as configurações da pagina em html//-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<! -- criando o arquivo em hrml -- >
<!DOCTYPE html>
<! -- Informando qual sera a linguagem utilizada -- >
<html lang="pt-br">
    <! -- Criando o head da pagina onde tem todas as configurações e o link da rota do bootstrap -- >
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Remover Autor</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    </head>
    <! -- criando o corpo do documento da pagina, onde estão localizados as funçoes da pagina
    e as mensagens que serão exibidas ao executar as funçoes  -- >
    <body>
        <main class="container">
            <h1>Remover Autor</h1>
            <hr />
            <p>Tem certeza que deseja remover o autor <em>"${autor.nome}"</em> ?</p>
            <form action="/autor/delete" method="post">
                <input type="hidden" name="id" value="${autor.id}" />
                <a href="/autor/list" class="btn btn-primary">Voltar</a>
                <input type="submit" value="Remover" class="btn btn-danger" />
            </form>
        </main>
        <! -- Aqui estão todas os links de comandos que foram utilizados nessa tag html, o bootstrap e o popperjs -- >
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js" integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js" integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc" crossorigin="anonymous"></script>
    </body>
</html>