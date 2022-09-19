$(document).ready(function() {
    $("#inputCelular").mask("(00)00000-0000")
    $("#inputRg").mask("00.000.000-00")
    $("#inputCpf").mask("000.000.000-00")
    $("#inputNome").keyup(function() {
        $(this).val($(this).val().toUpperCase())
    })
    $("#inputMae").keyup(function() {
        $(this).val($(this).val().toUpperCase())
    })
    $("#inputPai").keyup(function() {
        $(this).val($(this).val().toUpperCase())
    })
})

$(function (){
    $("#btnSalvar").on("click", function (){
        if(!validarForms()){
            alert("complete o formulario")
        }else {
            var nome = document.getElementById("inputNome").value;
            var email = document.getElementById("inputEmail4").value;
            var nomeMae = document.getElementById("inputMae").value;
            var nomePai = document.getElementById("inputPai").value;
            var cpf = document.getElementById("inputCpf").value;
            var celular = document.getElementById("inputCelular").value;
            var rg = document.getElementById("inputRg").value;
            var dataNasc = document.getElementById("inputDataNasc").value;

            var action = 'POST';

            $.ajax({
                url: "/softwell-estagio/home",
                type: 'GET',
                data: {nome, email, nomeMae, nomePai, cpf, celular, rg, dataNasc, action},
                success: function (dados) {
                    console.log(dados)
                    // alert('Salvo com Sucesso!');
                    alert(dados)
                    document.location.reload(true);
                },
                error: function (error) {
                    alert(error);
                }
            })
        }
    })
})



function calculaIdade(){

   var d = new Date( document.getElementById('inputDataNasc').value);
   var idade = Math.floor(Math.ceil(Math.abs(d.getTime() - Date.now()) / (1000 * 3600 * 24)) / 365.25);
   var validado = true;
   if (idade <= 17)
   {
       alert("Cliente nao possui permissao pra realizar cadastro!")
       return validado = false;
   }
}

function validarForms(){

    var validado = true;

    var nome = document.getElementById("inputNome").value;
    var nomeMae = document.getElementById("inputMae").value;
    var nomePai = document.getElementById("inputPai").value;
    var cpf = document.getElementById("inputCpf").value;
    var celular = document.getElementById("inputCelular").value;
    var rg = document.getElementById("inputRg").value;
    var dataNasc = document.getElementById("inputDataNasc").value;

    if(nome === "" || nomeMae === "" || nomePai === "" ||
        cpf === "" || celular === "" || rg === "" || dataNasc === "")
    {
        validado = false;
    }else if(calculaIdade())
    {
        validado = false;
    }

    return validado;
}