<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
    <!DOCTYPE html>
    <html lang="pt-br">

    <head>

      <meta charset="utf-8" />
      <meta content="width=device-width, initial-scale=1.0" name="viewport" />
      <link rel="preconnect" href="https://fonts.gstatic.com" />
      <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet" />
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" />
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
        crossorigin="anonymous"></script>
      <link href="css/style.css" rel="stylesheet" />

      <title>Link - Atualização de Cadastro</title>

    </head>

    <body>
      <!-- Navbar Start -->
      <div class="container-fluid bg-light position-relative shadow">
        <nav class="navbar navbar-expand-lg bg-white navbar-light py-3 py-lg-0 px-0 px-lg-5">
          <a href="index.html"><img src="img/LINK.png" alt="" style="width: 10rem; padding: 1.5rem;"></a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
            aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <div class="navbar-nav fw-bold mx-auto py-0" style="font-size: 1rem;">
              <a href="index.html" class="nav-item nav-link active">HOME</a>
              <a href="usuarioCad.html" class="nav-item nav-link">CADASTRE-SE</a>
              <a href="request.jsp" class="nav-item nav-link">REQUESTS</a>
              <a href="about.html" class="nav-item nav-link">O PROJETO</a>
              <a href="contact.html" class="nav-item nav-link">CONTATO</a>
              <a href="CreateAndFind" class="nav-item nav-link">CONSULTA DE CADASTROS</a>
            </div>
            <a href="./login.html" class="btn btn-primary px-4">LOGIN</a>
          </div>
        </nav>
      </div>
      <!-- Navbar End -->
      <main class="container-fluid p-5">
    <section>
      <h2 id="titleForm">Atualizar dados</h2>
      <div class="linha"></div>
      <form class="row g-3" action="UsuarioUpdate" method="POST">
      
      	<div class="form-floating mb-3">
			<input  value="${usuario.id}" name ="id" maxlength="40" type="text" class="form-control" readonly="readonly" >
			<label>ID</label>
		</div>
      
        <div class="col-md-12">
          <label for="inputNome" class="form-label">Nome Completo</label>
          <input type="text" class="form-control" name="nome" id="inputNome" value="${usuario.nome}">
        </div>
        
        <div class="col-md-6">
          <label for="cpf" class="form-label">CPF</label>
          <input type="text" maxlength="11" class="form-control" id="cpf" name="cpf" value="${usuario.cpf}">
        </div>
        
        <div class="col-md-6" id="selectionSexo">
          <label for="sexo" class="form-label">Qual o seu sexo?</label><br>
          <label for="masculino">Masculino</label>
          <input name="sexo" type="radio" value="M">
          <label for="feminino">Feminino</label>
          <input name="sexo" type="radio" value="F">
        </div>
        
        <div class="col-md-6">
          <label for="inputEmail4" class="form-label">Email</label>
          <input type="email" name="email" class="form-control" id="inputEmail4" value="${usuario.email}">
        </div>
        
        <div class="col-md-6">
          <label for="inputPassword" class="form-label">Senha</label>
          <input type="password" name="senha" class="form-control" id="inputPassword" value="${usuario.senha}">
        </div>
        
        <div class="col-12">
          <label for="inputAddress" class="form-label">Endereço</label>
          <input type="text" name="endereco" class="form-control" id="inputAddress"
            value="${usuario.endereco}">
        </div>
        
        <div class="col-12">
          <label for="inputAddress2" class="form-label">Complemento</label>
          <input type="text" name="complemento" class="form-control" id="inputAddress2"
            value="${usuario.complemento}">
        </div>
        
        <div class="col-md-5">
          <label for="inputCity" class="form-label">Cidade</label>
          <input type="text" name="cidade" class="form-control" id="inputCity" value="${usuario.cidade}">
        </div>
                
        <div class="col-md-3" id="estado">
          <label for="inputEstado">Estado</label>
          <select id="inputEstado" class="form-select" name="estado" value="${usuario.estado}">
            <option selected>Escolher...</option>
            <option value="AC">AC</option>
            <option value="AL">AL</option>
            <option value="AM">AM</option>
            <option value="AP">AP</option>
            <option value="BA">BA</option>
            <option value="CE">CE</option>
            <option value="DF">DF</option>
            <option value="ES">ES</option>
            <option value="GO">GO</option>
            <option value="MA">MA</option>
            <option value="MG">MG</option>
            <option value="MS">MS</option>
            <option value="MT">MT</option>
            <option value="PA">PA</option>
            <option value="PB">PB</option>
            <option value="PE">PE</option>
            <option value="PI">PI</option>
            <option value="PR">PR</option>
            <option value="RJ">RJ</option>
            <option value="RN">RN</option>
            <option value="RR">RR</option>
            <option value="RS">RS</option>
            <option value="SC">SC</option>
            <option value="SE">SE</option>
            <option value="SP">SP</option>
            <option value="TO">TO</option>
          </select>
        </div>
        
        <div class="col-md-4">
          <label for="inputCep" class="form-label">CEP</label>
          <input type="text" name="cep" class="form-control" id="inputCep" value="${usuario.cep}">
        </div>
        
        <div class="mb-3">
          <select id="inputTipoUsuario" class="form-select" name="tipoUsuario">
            <option selected>Selecione o tipo de Usúario</option>
            <option value="doador">Doador</option>
            <option value="donatario">Donatário</option>
          </select>
          
          <button type="submit" class="btn btn-primary mt-2" id="liveAlertBtn"
            style="background:#17a2b8;">Atualizar</button>
          <button type="reset" class="btn btn-secondary mt-2">Limpar formulário</button>
          
        </div>
      </form>
    </section>
  </main>
   
      

      <!-- Footer Start -->
      <div class="container-fluid bg-secondary text-white mt-5 py-5 px-sm-3 px-md-5">
        <div class="row justify-content-between">
          <div class="col-lg-3 mb-5">
            <img src="img/LINK1.jpg" alt="" style="width: 10rem; margin-bottom: 2rem;">
            <p>
              Labore dolor amet ipsum ea, erat sit ipsum duo eos. Volup amet ea
              dolor et magna dolor, elitr rebum duo est sed diam elitr. Stet elitr
              stet diam duo eos rebum ipsum diam ipsum elitr.
            </p>
            <div class="d-flex justify-content-start mt-4">
              <a class="btn fst_color rounded-circle text-center" style="width: 38px; height: 38px" href="#"><i
                  class="fab fa-twitter"></i></a>
              <a class="btn fst_color rounded-circle text-center" style="width: 38px; height: 38px" href="#"><i
                  class="fab fa-facebook-f"></i></a>
              <a class="btn fst_color rounded-circle text-center" style="width: 38px; height: 38px" href="#"><i
                  class="fab fa-linkedin-in"></i></a>
              <a class="btn fst_color rounded-circle text-center" style="width: 38px; height: 38px" href="#"><i
                  class="fab fa-instagram"></i></a>
            </div>
          </div>
          <div class="col-lg-3" style="align-self: flex-end;">
            <p class="m-0 text-center text-white">
              &copy;
              <a class="text-primary" href="#">Your Site Name</a>.
              All Rights Reserved.
              <br />Distributed By:
              <a class="text-primary" href="#">Placeholder</a>
            </p>
          </div>
          <div class="col-lg-3 pt-2">
            <h3 class="text-primary mb-4">Contato:</h3>
            <div class="d-flex">
              <h4 class="fa fa-map-marker-alt text-primary me-3"></h4>
              <div class="pl-3">
                <h5 class="text-white">Endereço</h5>
                <p>123 Street, New York, USA</p>
              </div>
            </div>
            <div class="d-flex">
              <h4 class="fa fa-envelope text-primary me-3"></h4>
              <div class="pl-3">
                <h5 class="text-white">Email</h5>
                <p>info@example.com</p>
              </div>
            </div>
            <div class="d-flex">
              <h4 class="fa fa-phone-alt text-primary me-3"></h4>
              <div class="pl-3">
                <h5 class="text-white">Telefone</h5>
                <p>+012 345 67890</p>
              </div>
            </div>
          </div>
        </div>
      </div>

    </body>

    </html>