<%@page import="java.util.List"%>
<%@page import="br.com.desafiolocalizacao.obj.Loja"%>
<%@page import="br.com.desafiolocalizacao.obj.Loja"%>
<%@page import="br.com.desafiolocalizacao.main.ListarLojas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <header>
        <meta charset="UTF-8" />
        <title>Desafio de localização</title>
        <link rel="stylesheet" href="css/reset.css" type="text/css">
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="css/select2.min.css" type="text/css">
        <link rel="stylesheet" href="css/leaflet.css"/>
        <link rel="stylesheet" href="css/estilo.css" type="text/css">

        <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/select2.full.min.js"></script>
        <script type="text/javascript" src="js/leaflet.js"></script>
        <script type="text/javascript" src="js/leaflet-color-markers.js"></script>
        <script type="text/javascript" src="js/index.js"></script>
    </header>
    <body onload="criacaoDoMapa()">
        <nav class="navbar navbar-fixed-top navbar-inverse navbar-transparente">
            <div class="container">
                <div class="col-md-6" style="color: white;">
                    <label>Desafio Localização</label>
                </div>
            </div>
        </nav>
        <div class="container conteudo">
            <div class="row">
                <!-- Conteudo -->
                <div role="tabpanel">
                    <div class="col-md-5">
                        <div class="col-md-12" >
                            <input  type="text" id="myInput" onkeyup="myFunction()" placeholder="Pesquisar...">
                        </div>
                        <div class="col-md-12">
                            <table id="myTable" class="table table-hover table-striped">
                                <thead>
                                    <tr>
                                        <th>Loja</th>
                                        <th>Atendida Por</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        List<Loja> lojas = ListarLojas.listarLojas();
                                        for (Loja loja : lojas) {
                                    %>
                                    <tr onclick="mostrarPonto(<%=loja.getFuncionario().getLatitude()%>, <%=loja.getFuncionario().getLongitude()%>,
                                        <%=loja.getLatitude()%>, <%=loja.getLongitude()%>, '<%=loja.getFuncionario().getNome()%>', '<%=loja.getNome()%>')">
                                        <td><%=loja.getNome()%></td>
                                        <td><%=loja.getFuncionario().getNome()%></td>
                                    </tr>
                                    <%
                                        }
                                    %>

                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="col-md-7">
                        <div class="col-md-12">
                            <div id="mapa"></div>
                        </div>
                        <div class="col-md-12">
                            <h4>Legenda:</h4>
                            <div class="col-md-6"><img src="images/marker-icon-2x-green.png" height="41" width="25"> Atendente</div>
                            <div class="col-md-6"><img src="images/marker-icon-2x-violet.png" height="41" width="25"> Loja</div>
                        </div>
                    </div>
                </div>
                <!-- Fim conteudo -->
            </div>
        </div>
        <footer id="rodape">
            <div class="container">
                <div class="row">
                    <div class="col-md-6" style="margin-top: 25px; color: white;">
                        <label>Desafio Localização</label>
                    </div>
                </div>
            </div>
        </footer>
    </body>
</html>