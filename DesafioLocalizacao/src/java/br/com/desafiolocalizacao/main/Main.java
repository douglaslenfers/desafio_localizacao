package br.com.desafiolocalizacao.main;

import br.com.desafiolocalizacao.obj.Funcionario;
import br.com.desafiolocalizacao.obj.Loja;
import java.util.List;

/**
 *
 * @author L3nfers
 */
public class Main {

    public static void main(String[] args) {
        List<Funcionario> funcionarios = LerCSVFuncionarios.carregarFuncionarios();
        List<Loja> lojas = LerCSVLojas.carregarLojas();

        for (Funcionario funcionario : funcionarios) {
            String nomeFuncionario = funcionario.getNome();
            double latitudeFuncionario = funcionario.getLatitude();
            double longitudeFuncionario = funcionario.getLongitude();

            System.out.println("Nome: " + nomeFuncionario + " - Latitude: "
                    + latitudeFuncionario + " - Longitude: "
                    + longitudeFuncionario);

            System.out.println("Atende:");
            for (Loja loja : lojas) {
                if (loja.getFuncionario() == null) {
                    String nomeLoja = loja.getNome();
                    double latitudeLoja = loja.getLatitude();
                    double longitudeLoja = loja.getLongitude();

                    double distanciaEntreDoisPontos = Haversine.distanciaEntreDoisPontos(latitudeFuncionario, longitudeFuncionario,
                            latitudeLoja, longitudeLoja);

                    if (distanciaEntreDoisPontos < 2) {
                        loja.setFuncionario(funcionario);
                        System.out.println("Loja: " + nomeLoja + " - Latitude: "
                                + latitudeLoja + " - Longitude: "
                                + longitudeLoja + " - Distância (Km): "
                                + distanciaEntreDoisPontos);
                    }
                }
            }

            System.out.println("\n");
        }
    }
}
