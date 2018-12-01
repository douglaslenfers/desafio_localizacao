# Desafio de localização

Desafio Desenvolvedor Full Stack - Involves


## Instalar

É preciso importar o projeto para o Netbeans.  

Modificar o caminho dos arquivos CSV nas classes `LerCSVLojas.java` e `LerCSVFuncionarios.java`, Exemplo:  
```java
final String arquivoCSV = "C:\\Users\\Usuario\\Downloads\\lojas.csv";
final String arquivoCSV = "C:\\Users\\Usuario\\Downloads\\funcionarios.csv";
```

## Rodar

Executar o "_Run File_" na classe `Main.java` para rodar uma listagem dos representantes com suas lojas próximas.

Executar o "_Run Project_" para rodar a parte web.

## Decisões/Arquitetura

Foi útilizado: Java, HTML, Javascript, CSS, Jquery, Bootstrap e o Leaflet (Para o mapa)

Projeto
* br.cm.desafiolocalizacao.main
  * `Haversine.java` (Cálculo de distância entre dois pontos)
  * `LerCSVFuncionarios.java` (Lê o arquivo CSV e cria os objetos de funcionários)
  * `LerCSVLojas.java` (Lê o arquivo CSV e cria os objetos de lojas)
  * `ListarLojas.java` (Cria a representação para o JSP com a lista de lojas com seus devidos representantes)
  * `Main.java` (Cria uma representação com prints dos funcionários e as lojas que pode atender)
* br.com.desafiolocalizacao.obj
  * `Funcionario.java` (Objeto de funcionário com os dados de ID, Nome, Latitude e Longitude)
  * `Loja.java` (Objeto de loja com os dados de ID, Nome, Latitude, Longitude e Funcionario)

Teste
* br.com.desafiolocalizacao.main
  * `HarversineTeste.java` (Teste realizado para duas posições uma próxima e outra distante)

A ideia da parte web é que o cliente tenha suas lojas listadas já com a informação de qual representante vai atender ela. Com um mapa para conseguir visualizar onde exatamente é cada loja e representante.
