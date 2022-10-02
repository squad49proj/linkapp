<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
        <!DOCTYPE html>
        <html lang="pt-br">

        <head>

            <meta charset="utf-8" />
            <meta content="width=device-width, initial-scale=1.0" name="viewport" />

            <link rel="preconnect" href="https://fonts.gstatic.com" />

            <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet" />

            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
                rel="stylesheet" />
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
                crossorigin="anonymous"></script>

            <link href="css/style.css" rel="stylesheet" />

            <title>Link - Requests</title>

        </head>

        <body>
            <!-- Navbar Start -->
            <div class="container-fluid bg-light position-relative shadow">
                <nav class="navbar navbar-expand-lg bg-white navbar-light py-3 py-lg-0 px-0 px-lg-5">
                    <a href="index.html"><img src="img/LINK.png" alt="" style="width: 10rem; padding: 1.5rem;"></a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <div class="navbar-nav fw-bold mx-auto py-0" style="font-size: 1rem;">
                            <a href="index.html" class="nav-item nav-link">HOME</a>
                            <a href="usuarioCad.html" class="nav-item nav-link">CADASTRE-SE</a>
                            <a href="PedidoCreateAndFind" class="nav-item nav-link active">REQUESTS</a>
                            <a href="about.html" class="nav-item nav-link">O PROJETO</a>
                            <a href="contact.html" class="nav-item nav-link">CONTATO</a>
                            <a href="CreateAndFind" class="nav-item nav-link">CONSULTA DE CADASTROS</a>
                        </div>
                        <a href="./login.html" class="btn btn-primary px-4">LOGIN</a>
                    </div>
                </nav>
            </div>
            <!-- Navbar End -->
            <main class="container">
                <section>
                    <h2 id="titleForm">Deixe seu pedido (REQUEST)</h2>
                    <div class="linha"></div>
                    <form class="row g-3" action="PedidoCreateAndFind" method="post">
                        <div class="mb-3">
                            <label for="input" class="form-label">CPF de usuário</label>
                            <input type="text" name="cpf" maxlength="11" class="form-control" id="input"
                                placeholder="CPF de usuário cadastrado">
                        </div>
                        <div class="mb-3">
                            <label for="input" class="form-label">Seu nome</label>
                            <input type="text" name="nome" class="form-control" id="input"
                                placeholder="Seu nome">
                        </div>
                        <div class="mb-3">
                            <label for="exampleFormControlInput1" class="form-label">Equipamento a solicitar:</label>
                            <input type="text" name="equip" class="form-control" id="exampleFormControlInput1"
                                placeholder="Notebook, Tablet..">
                        </div>
                        <div class="mb-3">
                            <label for="exampleFormControlTextarea1" class="form-label">Escreva seu relato:</label>
                            <textarea class="form-control" name="relato" placeholder="máximo de 400 caractéres" id="exampleFormControlTextarea1"
                                rows="3"></textarea>
                            <br>
                            <button class="btn btn-primary" type="submit">Enviar</button>
                        </div>
                        <section class="container">
                            <h2 id="titleForm">Pedidos (REQUESTS)</h2>
                            <div class="linha"></div>
                        </section>
                    </form>
                </section>

                <div class="container-fluid text-white px-3">
                    <div class="row w-100">
                        <div class="table-responsive">
                            <table class="table table-image">
                                <thead>
                                    <tr>
                                        <th style="visibility: hidden;">UserPicture</th>
                                        <th>Nome</th>
                                        <th>Relato</th>
                                        <th>Equipamento</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${pedidos}" var="pedido">
                                        <tr>
                                            <td style="vertical-align: middle;"><img style="width:10rem;"
                                                    src="img request/user.png" /></td>
                                            <td style="vertical-align: middle; font-weight: bold;">${pedido.nome}</td>
                                            <td style="vertical-align: middle; overflow: hidden; max-width: 200px; word-wrap: break-word;">${pedido.relato}</td>
                                            <td style="vertical-align: middle;">${pedido.equip}</td>
                                            <td style="vertical-align: middle;">
                                                <div>
                                                <a href="PedidoDelete?pedidoId=${pedido.id}">Deletar</a>
                                                <a href="PedidoUpdate?pedidoId=${pedido.id}">Editar</a>
                                                <a href="#">Ajudar</a>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        
                        <h5 class="mt-2"><a href="index.html">Voltar para página principal</a></h5>
                    </div>
                </div>

            </main>
            <!-- Footer Start -->
            <div class="container-fluid bg-secondary text-white mt-5 py-5 px-sm-3 px-md-5">
                <div class="row justify-content-between">
                    <div class="col-lg-3 mb-5">
                        <img src="img/LINK1.jpg" alt="" style="width: 10rem; margin-bottom: 2rem;">
                        <p>
                            Labore dolor amet ipsum ea, erat sit ipsum duo eos. Volup amet ea dolor et magna dolor,
                            elitr rebum
                            duo est sed diam elitr. Stet elitr stet diam duo eos rebum ipsum diam ipsum elitr.
                        </p>
                        <div class="d-flex justify-content-start mt-4">
                            <a class="btn fst_color rounded-circle text-center" style="width: 38px; height: 38px"
                                href="#"><i class="fab fa-twitter"></i></a>
                            <a class="btn fst_color rounded-circle text-center" style="width: 38px; height: 38px"
                                href="#"><i class="fab fa-facebook-f"></i></a>
                            <a class="btn fst_color rounded-circle text-center" style="width: 38px; height: 38px"
                                href="#"><i class="fab fa-linkedin-in"></i></a>
                            <a class="btn fst_color rounded-circle text-center" style="width: 38px; height: 38px"
                                href="#"><i class="fab fa-instagram"></i></a>
                        </div>
                    </div>
                    <div class="col-lg-3" style="align-self: flex-end;">
                        <p class="m-0 text-center text-white">
                            <a class="text-primary" href="#">Your Site Name</a>. All Rights Reserved.
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