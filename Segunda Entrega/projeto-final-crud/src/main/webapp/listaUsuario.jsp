<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
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

      <title>Link - Consulta de Cadastros</title>

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
              <a href="index.html" class="nav-item nav-link">HOME</a>
              <a href="usuarioCad.html" class="nav-item nav-link">CADASTRE-SE</a>
              <a href="PedidoCreateAndFind" class="nav-item nav-link">REQUESTS</a>
              <a href="about.html" class="nav-item nav-link">O PROJETO</a>
              <a href="contact.html" class="nav-item nav-link">CONTATO</a>
<<<<<<< HEAD
              <a href="listaUsuario.jsp" class="nav-item nav-link active">CONSULTA DE CADASTROS</a>
=======
              <a href="CreateAndFind" method = "GET" class="nav-item nav-link">CONSULTA DE CADASTROS</a>
>>>>>>> e964787e8d6e4d9ddad9a375d62bfb6b837566a8
            </div>
            <a href="./login.html" class="btn btn-primary px-4">LOGIN</a>		      
          </div>
        </nav>
      </div>
      <!-- Navbar End -->
      
      <div class="container">
		<div class="row">
			<div class="cold-md-7">
				<hr>
				<h3> USÚARIOS CADASTRADOS</h3>
				<br>
				<!-- CAMPO DE BUSCA-->
			    <form action ="CreateAndFind" method = "GET" class="d-flex" >
			      <input name="pesquisa" class="form-control me-2" type="search" placeholder="Digite o nome ou CPF" aria-label="Search">
			      <button class="btn btn-primary px-4" type="submit">Buscar</button>
			    </form>
				<hr>
				
				<table class="table">
					<thead>
						<tr>
							<th>#</th>
							<th>Nome</th>
							<th>CPF</th>
							<th>Sexo</th>
							<th>Email</th>
							<th>Senha</th>
							<th>Endereço</th>
							<th>Complemento</th>
							<th>Cidade</th>
							<th>Estado</th>
							<th>Cep</th>
							<th>Tipo Usúario</th>
							
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${usuarios}" var="usuario">
							<tr>
								<td>${usuario.id}</td>
								<td>${usuario.nome}</td>
								<td>${usuario.cpf}</td>
								<td>${usuario.sexo}</td>
								<td>${usuario.email}</td>
								<td>${usuario.senha}</td>
								<td>${usuario.endereco}</td>
								<td>${usuario.complemento}</td>
								<td>${usuario.cidade}</td>
								<td>${usuario.estado}</td>
								<td>${usuario.cep}</td>
								<td>${usuario.tipoUsuario}</td>						
								<td>
									<a href="UsuarioDestroy?usuarioId=${usuario.id}">Deletar</a>
									<a href="UsuarioUpdate?usuarioId=${usuario.id}">Atualizar</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

      

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