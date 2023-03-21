<!doctype html>
<html lang="pt-br">
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Softwell</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
    <h1>Softwell Solutions</h1>
    <form method="POST" class="row g-3">
        <div class="col-md-6">
            <label for="inputEmail4" class="form-label">Email</label>
            <input type="email" class="form-control" id="inputEmail4">
        </div>
        <div class="col-6">
            <label for="inputNome" class="form-label">Nome</label>
            <input type="text" class="form-control" id="inputNome" required>
        </div>
        <div class="col-md-2">
            <label for="inputCelular" class="form-label">Celular</label>
            <input type="tel" class="form-control" id="inputCelular" required>
        </div>
        <div class="col-2">
            <label for="inputDataNasc" class="form-label">Data Nasc</label>
            <input type="date" class="form-control" id="inputDataNasc" onblur="calculaIdade()" required>
        </div>
        <div class="col-md-4">
            <label for="inputRg" class="form-label">RG</label>
            <input type="text" class="form-control" id="inputRg" required>
        </div>
        <div class="col-md-4">
            <label for="inputCpf" class="form-label">CPF</label>
            <input type="text" class="form-control" id="inputCpf" required>
        </div>
        <div class="col-md-6">
            <label for="inputMae" class="form-label">Nome da mae</label>
            <input type="text" class="form-control" id="inputMae" required>
        </div>
        <div class="col-md-6">
            <label for="inputPai" class="form-label">Nome do pai</label>
            <input type="text" class="form-control" id="inputPai" required>
        </div>

        <div class="col-12">
            <button type="button" id="btnSalvar" class="btn btn-primary">Salvar</button>
        </div>
        <div id="alerta-sucesso" class="alert alert-success" role="alert">
            Salvo com sucesso
          </div>
    </form>
</div>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.10/jquery.mask.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src= "js/script.js"></script>
</body>
</html>

