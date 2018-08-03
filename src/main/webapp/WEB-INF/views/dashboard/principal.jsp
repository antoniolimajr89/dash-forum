<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css"
          integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">

    <title>Title</title>
</head>
<body>

<div class="container my-3">
    <div class="col-md-12 col-md-offset-3 mx-auto">
        <h1 class="text-center my-3">DASHBOARD</h1>
        <table class="table table-hover ">
            <thead>
            <tr class="alert alert-light">
                <th class="text-center">Categoria</th>
                <th class="text-center">Quantidade</th>
                <th class="text-center">Status</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${lista}" var="duvida">
                <tr>
                    <td class="text-center">${duvida.categoria}</td>
                    <td class="text-center">${duvida.duvidas.size()}</td>
                    <td class="text-center">${duvida.status}</td>
                </tr>
            </c:forEach>

            </tbody>

        </table>

    </div>

</div>


</body>
</html>
